-- =============================================================================
-- SCRIPT DML: PROCEDIMIENTO DE TELEMETRIA IoT
-- Descripcion: Procedimientos almacenados para procesamiento de datos IoT
--              con validacion de esquemas JSON
-- Autor: Equipo de Respuesta Rapida
-- Fecha: 2026-03-16
-- =============================================================================

USE orbita_telemetria;

-- =============================================================================
-- FUNCION: Validar esquema JSON de sensor
-- =============================================================================

DELIMITER //

CREATE FUNCTION IF NOT EXISTS fn_validar_json_sensor(
    p_json_data JSON
) RETURNS BOOLEAN
DETERMINISTIC
NO SQL
BEGIN
    DECLARE v_sensor_id VARCHAR(50);
    DECLARE v_has_temperature BOOLEAN DEFAULT FALSE;
    DECLARE v_has_humidity BOOLEAN DEFAULT FALSE;
    
    -- Verificar que existe sensor_id
    SET v_sensor_id = JSON_UNQUOTE(JSON_EXTRACT(p_json_data, '$.sensor_id'));
    IF v_sensor_id IS NULL OR v_sensor_id = 'null' THEN
        RETURN FALSE;
    END IF;
    
    -- Verificar que existe readings
    IF JSON_EXTRACT(p_json_data, '$.readings') IS NULL THEN
        RETURN FALSE;
    END IF;
    
    -- Verificar que temperature o humidity existen en readings
    IF JSON_EXTRACT(p_json_data, '$.readings.temperature') IS NOT NULL THEN
        SET v_has_temperature = TRUE;
    END IF;
    
    IF JSON_EXTRACT(p_json_data, '$.readings.humidity') IS NOT NULL THEN
        SET v_has_humidity = TRUE;
    END IF;
    
    -- Debe tener al menos uno de los dos
    IF NOT v_has_temperature AND NOT v_has_humidity THEN
        RETURN FALSE;
    END IF;
    
    RETURN TRUE;
END//

-- =============================================================================
-- PROCEDIMIENTO: Insertar lectura de sensor IoT
-- =============================================================================

CREATE PROCEDURE IF NOT EXISTS sp_insertar_lectura_iot(
    IN p_id_contenedor BIGINT UNSIGNED,
    IN p_payload_json JSON,
    IN p_nivel_bateria DECIMAL(5,2)
)
BEGIN
    DECLARE v_id_lectura BIGINT UNSIGNED;
    DECLARE v_sensor_id VARCHAR(50);
    DECLARE v_temperature DECIMAL(8,2);
    DECLARE v_humidity DECIMAL(8,2);
    DECLARE v_alerts JSON;
    DECLARE v_alert_count INT DEFAULT 0;
    DECLARE v_i INT DEFAULT 0;
    DECLARE v_alert_text VARCHAR(100);
    
    -- Validar JSON
    IF NOT fn_validar_json_sensor(p_payload_json) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: JSON invalido. Debe contener sensor_id y readings con temperature y/o humidity';
    END IF;
    
    -- Extraer valores del JSON
    SET v_sensor_id = JSON_UNQUOTE(JSON_EXTRACT(p_payload_json, '$.sensor_id'));
    SET v_temperature = JSON_EXTRACT(p_payload_json, '$.readings.temperature');
    SET v_humidity = JSON_EXTRACT(p_payload_json, '$.readings.humidity');
    SET v_alerts = JSON_EXTRACT(p_payload_json, '$.alerts');
    
    -- Insertar lectura
    INSERT INTO iot_sensores_carga (
        id_contenedor_fk, 
        payload_datos, 
        nivel_bateria_pct
    ) VALUES (
        p_id_contenedor, 
        p_payload_json, 
        p_nivel_bateria
    );
    
    SET v_id_lectura = LAST_INSERT_ID();
    
    -- Procesar alertas si existen
    IF v_alerts IS NOT NULL AND JSON_LENGTH(v_alerts) > 0 THEN
        SET v_alert_count = JSON_LENGTH(v_alerts);
        
        WHILE v_i < v_alert_count DO
            SET v_alert_text = JSON_UNQUOTE(JSON_EXTRACT(v_alerts, CONCAT('$[', v_i, ']')));
            
            INSERT INTO iot_alertas_sensor (
                id_lectura_iot_fk,
                tipo_alerta,
                descripcion_alerta,
                severidad
            ) VALUES (
                v_id_lectura,
                CONCAT('ALR-', UPPER(SUBSTRING(v_sensor_id, 1, 3))),
                v_alert_text,
                CASE 
                    WHEN v_alert_text LIKE '%critical%' OR v_alert_text LIKE '%danger%' THEN 'CRITICA'
                    WHEN v_alert_text LIKE '%high%' OR v_alert_text LIKE '%warning%' THEN 'ALTA'
                    WHEN v_alert_text LIKE '%low%' THEN 'BAJA'
                    ELSE 'MEDIA'
                END
            );
            
            SET v_i = v_i + 1;
        END WHILE;
    END IF;
    
    -- Generar alertas automaticas basadas en umbrales
    IF v_temperature IS NOT NULL THEN
        IF v_temperature > 30 THEN
            INSERT INTO iot_alertas_sensor (
                id_lectura_iot_fk, tipo_alerta, descripcion_alerta, severidad
            ) VALUES (
                v_id_lectura, 'ALR-TMP', CONCAT('Temperatura alta: ', v_temperature, '°C'), 'ALTA'
            );
        ELSEIF v_temperature < -20 THEN
            INSERT INTO iot_alertas_sensor (
                id_lectura_iot_fk, tipo_alerta, descripcion_alerta, severidad
            ) VALUES (
                v_id_lectura, 'ALR-TMP', CONCAT('Temperatura critica: ', v_temperature, '°C'), 'CRITICA'
            );
        END IF;
    END IF;
    
    IF v_humidity IS NOT NULL AND v_humidity > 80 THEN
        INSERT INTO iot_alertas_sensor (
            id_lectura_iot_fk, tipo_alerta, descripcion_alerta, severidad
        ) VALUES (
            v_id_lectura, 'ALR-HUM', CONCAT('Humedad alta: ', v_humidity, '%'), 'MEDIA'
        );
    END IF;
    
    IF p_nivel_bateria < 20 THEN
        INSERT INTO iot_alertas_sensor (
            id_lectura_iot_fk, tipo_alerta, descripcion_alerta, severidad
        ) VALUES (
            v_id_lectura, 'ALR-BAT', CONCAT('Bateria baja: ', p_nivel_bateria, '%'), 'ALTA'
        );
    END IF;
    
    SELECT v_id_lectura AS id_lectura_insertada;
END//

-- =============================================================================
-- PROCEDIMIENTO: Registrar tracking GPS
-- =============================================================================

CREATE PROCEDURE IF NOT EXISTS sp_registrar_tracking(
    IN p_tipo_activo ENUM('BUQUE', 'AVION', 'CAMION'),
    IN p_activo_id BIGINT UNSIGNED,
    IN p_latitud DECIMAL(10, 8),
    IN p_longitud DECIMAL(11, 8)
)
BEGIN
    INSERT INTO iot_gps_tracking (
        tipo_activo, 
        activo_id, 
        latitud, 
        longitud,
        fecha_hora_lectura
    ) VALUES (
        p_tipo_activo, 
        p_activo_id, 
        p_latitud, 
        p_longitud,
        NOW()
    );
    
    SELECT LAST_INSERT_ID() AS id_tracking;
END//

-- =============================================================================
-- PROCEDIMIENTO: Registrar evento de ruta
-- =============================================================================

CREATE PROCEDURE IF NOT EXISTS sp_registrar_evento_ruta(
    IN p_id_mision BIGINT UNSIGNED,
    IN p_tipo_evento ENUM('CLIMA', 'PIRATERIA', 'RETRASO', 'FALLO_MECANICO'),
    IN p_severidad ENUM('BAJA', 'MEDIA', 'ALTA', 'CRITICA'),
    IN p_descripcion TEXT,
    IN p_latitud DECIMAL(10, 8),
    IN p_longitud DECIMAL(11, 8)
)
BEGIN
    INSERT INTO log_eventos_ruta (
        id_mision_fk,
        tipo_evento,
        severidad,
        descripcion_evento,
        latitud,
        longitud,
        fecha_evento
    ) VALUES (
        p_id_mision,
        p_tipo_evento,
        p_severidad,
        p_descripcion,
        p_latitud,
        p_longitud,
        NOW()
    );
    
    -- Si es incidencia critica, crear entrada en log_incidencias
    IF p_severidad IN ('ALTA', 'CRITICA') THEN
        INSERT INTO log_incidencias (
            id_mision_fk,
            tipo_incidencia,
            descripcion,
            estado_resolucion,
            fecha_apertura
        ) VALUES (
            p_id_mision,
            p_tipo_evento,
            p_descripcion,
            'ABIERTA',
            NOW()
        );
    END IF;
    
    SELECT LAST_INSERT_ID() AS id_evento;
END//

-- =============================================================================
-- PROCEDIMIENTO: Registrar datos meteorologicos
-- =============================================================================

CREATE PROCEDURE IF NOT EXISTS sp_registrar_meteorologia(
    IN p_id_lectura_gps BIGINT UNSIGNED,
    IN p_presion_hpa INT,
    IN p_temperatura_c DECIMAL(5,2),
    IN p_humedad_pct DECIMAL(5,2),
    IN p_velocidad_viento_kmh DECIMAL(5,2),
    IN p_visibilidad_km DECIMAL(5,2)
)
BEGIN
    INSERT INTO log_meteorologia (
        id_lectura_gps_fk,
        presion_hpa,
        temperatura_c,
        humedad_pct,
        velocidad_viento_kmh,
        visibilidad_km,
        fecha_registro
    ) VALUES (
        p_id_lectura_gps,
        p_presion_hpa,
        p_temperatura_c,
        p_humedad_pct,
        p_velocidad_viento_kmh,
        p_visibilidad_km,
        NOW()
    );
    
    SELECT LAST_INSERT_ID() AS id_clima;
END//

-- =============================================================================
-- PROCEDIMIENTO: Registrar nodo de recepcion
-- =============================================================================

CREATE PROCEDURE IF NOT EXISTS sp_registrar_nodo(
    IN p_nombre_estacion VARCHAR(20),
    IN p_latitud DECIMAL(10, 8),
    IN p_longitud DECIMAL(11, 8),
    IN p_tipo_conexion ENUM('SATELITE', 'CELULAR', 'RADIO', 'FIBRA')
)
BEGIN
    INSERT INTO net_nodos_recepcion (
        nombre_estacion,
        ubicacion_geo,
        tipo_conexion,
        estado_nodo,
        ultima_comunicacion
    ) VALUES (
        p_nombre_estacion,
        ST_GeomFromText(CONCAT('POINT(', p_longitud, ' ', p_latitud, ')'), 4326),
        p_tipo_conexion,
        'ACTIVO',
        NOW()
    )
    ON DUPLICATE KEY UPDATE
        ubicacion_geo = ST_GeomFromText(CONCAT('POINT(', p_longitud, ' ', p_latitud, ')'), 4326),
        tipo_conexion = p_tipo_conexion,
        ultima_comunicacion = NOW();
    
    SELECT LAST_INSERT_ID() AS id_nodo;
END//

-- =============================================================================
-- PROCEDIMIENTO: Procesar batch de lecturas IoT (para ingesta masiva)
-- =============================================================================

CREATE PROCEDURE IF NOT EXISTS sp_procesar_batch_iot(
    IN p_json_batch JSON
)
BEGIN
    DECLARE v_batch_size INT;
    DECLARE v_i INT DEFAULT 0;
    DECLARE v_item JSON;
    DECLARE v_id_contenedor BIGINT UNSIGNED;
    DECLARE v_payload JSON;
    DECLARE v_bateria DECIMAL(5,2);
    DECLARE v_procesados INT DEFAULT 0;
    DECLARE v_errores INT DEFAULT 0;
    
    SET v_batch_size = JSON_LENGTH(p_json_batch);
    
    WHILE v_i < v_batch_size DO
        SET v_item = JSON_EXTRACT(p_json_batch, CONCAT('$[', v_i, ']'));
        
        BEGIN
            DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
            BEGIN
                SET v_errores = v_errores + 1;
            END;
            
            SET v_id_contenedor = JSON_EXTRACT(v_item, '$.id_contenedor');
            SET v_payload = JSON_EXTRACT(v_item, '$.payload');
            SET v_bateria = JSON_EXTRACT(v_item, '$.nivel_bateria');
            
            CALL sp_insertar_lectura_iot(v_id_contenedor, v_payload, v_bateria);
            SET v_procesados = v_procesados + 1;
        END;
        
        SET v_i = v_i + 1;
    END WHILE;
    
    SELECT 
        v_procesados AS registros_procesados,
        v_errores AS registros_con_error,
        v_batch_size AS total_en_batch;
END//

-- =============================================================================
-- PROCEDIMIENTO: Generar reporte de telemetria por contenedor
-- =============================================================================

CREATE PROCEDURE IF NOT EXISTS sp_reporte_telemetria_contenedor(
    IN p_id_contenedor BIGINT UNSIGNED,
    IN p_fecha_desde DATETIME,
    IN p_fecha_hasta DATETIME
)
BEGIN
    SELECT 
        sc.id_lectura_iot,
        sc.id_contenedor_fk,
        JSON_UNQUOTE(JSON_EXTRACT(sc.payload_datos, '$.sensor_id')) AS sensor_id,
        JSON_EXTRACT(sc.payload_datos, '$.readings.temperature') AS temperatura,
        JSON_EXTRACT(sc.payload_datos, '$.readings.humidity') AS humedad,
        sc.nivel_bateria_pct,
        sc.fecha_hora_recepcion,
        (SELECT COUNT(*) FROM iot_alertas_sensor a 
         WHERE a.id_lectura_iot_fk = sc.id_lectura_iot) AS num_alertas
    FROM iot_sensores_carga sc
    WHERE sc.id_contenedor_fk = p_id_contenedor
      AND sc.fecha_hora_recepcion BETWEEN p_fecha_desde AND p_fecha_hasta
    ORDER BY sc.fecha_hora_recepcion DESC;
END//

DELIMITER ;

-- =============================================================================
-- DATOS DE EJEMPLO: Insertar lecturas de sensores desde archivos JSON
-- =============================================================================

-- Sensor de obras de arte (ART-004-VIP)
CALL sp_insertar_lectura_iot(
    1,
    '{
        "sensor_id": "ART-004-VIP",
        "metadata": {"firmware": "v3.0.0", "encryption": "AES-256"},
        "readings": {
            "temperature": 21.0,
            "humidity": 50.0,
            "vibration_level": 0.02,
            "light_exposure": 0,
            "tilt_angle": 0.1
        },
        "alerts": ["low_battery_warning"]
    }',
    15.5
);

-- Sensor quimico (CHEM-HAZ-88)
CALL sp_insertar_lectura_iot(
    2,
    '{
        "sensor_id": "CHEM-HAZ-88",
        "metadata": {"hazmat_class": 3, "emergency_contact": "+34-900-OIL"},
        "readings": {
            "pressure_psi": 32.5,
            "internal_temp": 45.2,
            "gas_leak_ppm": 0,
            "ventilation_status": "auto"
        },
        "alerts": ["high_temp_threshold_approaching"]
    }',
    67.0
);

-- Sensor refrigerado (REF-9920-X)
CALL sp_insertar_lectura_iot(
    3,
    '{
        "sensor_id": "REF-9920-X",
        "metadata": {"firmware": "v2.4.1", "last_service": "2024-01-15"},
        "readings": {
            "temperature": -18.4,
            "humidity": 12.5,
            "compressor_status": "active",
            "defrost_cycle": false,
            "door_seal_integrity": 100
        },
        "alerts": []
    }',
    89.5
);

-- =============================================================================
-- DATOS DE EJEMPLO: Nodos de recepcion
-- =============================================================================

CALL sp_registrar_nodo('NODE-0001', 40.4168, -3.7038, 'FIBRA');
CALL sp_registrar_nodo('NODE-0002', 41.3851, 2.1734, 'CELULAR');
CALL sp_registrar_nodo('NODE-0003', 39.4699, -0.3763, 'SATELITE');
CALL sp_registrar_nodo('NODE-0042', 51.5074, -0.1278, 'RADIO');

-- =============================================================================
-- DATOS DE EJEMPLO: Tracking GPS
-- =============================================================================

CALL sp_registrar_tracking('BUQUE', 1, 36.1408, -5.3536);
CALL sp_registrar_tracking('AVION', 1, 48.8566, 2.3522);
CALL sp_registrar_tracking('CAMION', 1, 52.5200, 13.4050);

-- =============================================================================
-- VERIFICACION
-- =============================================================================

SELECT 'Procedimientos de telemetria creados exitosamente' AS mensaje;

SELECT 
    'ESTADISTICAS IoT' AS reporte,
    (SELECT COUNT(*) FROM iot_sensores_carga) AS total_lecturas,
    (SELECT COUNT(*) FROM iot_alertas_sensor) AS total_alertas,
    (SELECT COUNT(*) FROM iot_gps_tracking) AS total_tracking,
    (SELECT COUNT(*) FROM net_nodos_recepcion) AS total_nodos;
