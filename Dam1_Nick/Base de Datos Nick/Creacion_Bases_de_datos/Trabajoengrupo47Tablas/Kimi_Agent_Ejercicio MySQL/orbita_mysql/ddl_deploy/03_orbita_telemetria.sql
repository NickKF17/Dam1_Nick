-- =============================================================================
-- SCRIPT 03: ORBITA_TELEMETRIA
-- Descripcion: Ingesta masiva de datos IoT, tracking y registros en tiempo real
--              8 tablas con validacion de esquemas JSON
-- Autor: Equipo de Respuesta Rapida
-- Fecha: 2026-03-16
-- =============================================================================

DROP DATABASE IF EXISTS orbita_telemetria;

CREATE DATABASE orbita_telemetria 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

USE orbita_telemetria;

-- =============================================================================
-- AREA: SEGUIMIENTO DE ACTIVOS (TRACKING)
-- =============================================================================

-- Tabla 1: iot_gps_tracking
CREATE TABLE iot_gps_tracking (
    id_lectura BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tipo_activo ENUM('BUQUE', 'AVION', 'CAMION') NOT NULL,
    activo_id BIGINT UNSIGNED NOT NULL,
    latitud DECIMAL(10, 8) NOT NULL,
    longitud DECIMAL(11, 8) NOT NULL,
    fecha_hora_lectura DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: MONITORIZACION DE CARGA (IoT)
-- =============================================================================

-- Tabla 2: iot_sensores_carga
CREATE TABLE iot_sensores_carga (
    id_lectura_iot BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_contenedor_fk BIGINT UNSIGNED,
    payload_datos JSON NOT NULL,
    nivel_bateria_pct DECIMAL(5,2),
    fecha_hora_recepcion DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_bateria CHECK (nivel_bateria_pct BETWEEN 0 AND 100)
) ENGINE=InnoDB;

ALTER TABLE iot_sensores_carga 
ADD CONSTRAINT chk_json_esquema CHECK (
    JSON_TYPE(JSON_EXTRACT(payload_datos, '$.sensor_id')) = 'STRING' AND
    JSON_TYPE(JSON_EXTRACT(payload_datos, '$.readings')) = 'OBJECT' AND
    (
        JSON_EXTRACT(payload_datos, '$.readings.temperature') IS NOT NULL OR 
        JSON_EXTRACT(payload_datos, '$.readings.humidity') IS NOT NULL
    )
    -- El PDF menciona 'alerts' como opcional, por lo que no es estrictamente 
    -- necesario validarlo aquí, pero debe ser permitido en la estructura.
);

-- Tabla 3: iot_alertas_sensor
CREATE TABLE iot_alertas_sensor (
    id_alerta BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_lectura_iot_fk BIGINT UNSIGNED NOT NULL,
    tipo_alerta VARCHAR(7) NOT NULL,
    descripcion_alerta TEXT,
    severidad ENUM('BAJA', 'MEDIA', 'ALTA', 'CRITICA') DEFAULT 'MEDIA',
    fecha_alerta DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_alertas_lectura FOREIGN KEY (id_lectura_iot_fk) 
        REFERENCES iot_sensores_carga(id_lectura_iot) ON DELETE CASCADE,
    CONSTRAINT chk_tipo_alerta CHECK (tipo_alerta REGEXP '^ALR-[A-Z]{3}$')
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: EVENTOS E INCIDENCIAS
-- =============================================================================

-- Tabla 4: log_eventos_ruta
CREATE TABLE log_eventos_ruta (
    id_evento BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_mision_fk BIGINT UNSIGNED,
    tipo_evento ENUM('CLIMA', 'PIRATERIA', 'RETRASO', 'FALLO_MECANICO') NOT NULL,
    severidad ENUM('BAJA', 'MEDIA', 'ALTA', 'CRITICA') NOT NULL,
    descripcion_evento TEXT,
    latitud DECIMAL(10, 8),
    longitud DECIMAL(11, 8),
    fecha_evento DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_evento_lat CHECK (latitud BETWEEN -90 AND 90),
    CONSTRAINT chk_evento_lon CHECK (longitud BETWEEN -180 AND 180)
) ENGINE=InnoDB;

-- Tabla 5: log_meteorologia
CREATE TABLE log_meteorologia (
    id_clima BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_lectura_gps_fk BIGINT UNSIGNED,
    presion_hpa INT,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_clima_gps FOREIGN KEY (id_lectura_gps_fk) 
        REFERENCES iot_gps_tracking(id_lectura) ON DELETE SET NULL,
    CONSTRAINT chk_presion CHECK (presion_hpa BETWEEN 800 AND 1100),
    CONSTRAINT chk_humedad CHECK (humedad_pct BETWEEN 0 AND 100)
) ENGINE=InnoDB;

-- Tabla 6: log_incidencias
CREATE TABLE log_incidencias (
    id_incidencia BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_mision_fk BIGINT UNSIGNED,
    tipo_incidencia VARCHAR(50),
    descripcion TEXT,
    estado_resolucion ENUM('ABIERTA', 'EN_PROGRESO', 'RESUELTA', 'ESCADA') DEFAULT 'ABIERTA',
    fecha_apertura DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre DATETIME,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: INFRAESTRUCTURA DE RED (NODOS)
-- =============================================================================

-- Tabla 7: net_nodos_recepcion
CREATE TABLE net_nodos_recepcion (
    id_nodo BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_estacion VARCHAR(9) NOT NULL UNIQUE,
    ubicacion_geo POINT NOT NULL SRID 4326,
    tipo_conexion ENUM('SATELITE', 'CELULAR', 'RADIO', 'FIBRA') DEFAULT 'CELULAR',
    estado_nodo ENUM('ACTIVO', 'INACTIVO', 'MANTENIMIENTO') DEFAULT 'ACTIVO',
    ultima_comunicacion DATETIME,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_nombre_nodo CHECK (nombre_estacion REGEXP '^NODE-[0-9]{4}$')
) ENGINE=InnoDB;

-- Tabla 8: net_conectividad
CREATE TABLE net_conectividad (
    id_registro BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_nodo_fk BIGINT UNSIGNED NOT NULL,
    id_lectura_iot_fk BIGINT UNSIGNED,
    calidad_senal_pct DECIMAL(5,2),
    latencia_ms INT,
    paquetes_perdidos_pct DECIMAL(5,2),
    timestamp_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_conec_nodo FOREIGN KEY (id_nodo_fk) 
        REFERENCES net_nodos_recepcion(id_nodo),
    CONSTRAINT fk_conec_lectura FOREIGN KEY (id_lectura_iot_fk) 
        REFERENCES iot_sensores_carga(id_lectura_iot) ON DELETE SET NULL,
    CONSTRAINT chk_calidad_senal CHECK (calidad_senal_pct BETWEEN 0 AND 100)
) ENGINE=InnoDB;

-- =============================================================================
-- TRIGGERS PARA VALIDACION DE JSON
-- =============================================================================

DELIMITER //

-- Funcion para validar el esquema JSON de sensores
CREATE FUNCTION validar_json_sensor(json_data JSON) 
RETURNS BOOLEAN
DETERMINISTIC
NO SQL
BEGIN
    -- Verificar que existe sensor_id (texto)
    IF JSON_EXTRACT(json_data, '$.sensor_id') IS NULL THEN
        RETURN FALSE;
    END IF;
    
    -- Verificar que existe readings con al menos temperature o humidity
    IF JSON_EXTRACT(json_data, '$.readings') IS NULL THEN
        RETURN FALSE;
    END IF;
    
    -- Verificar que temperature o humidity existen en readings
    IF JSON_EXTRACT(json_data, '$.readings.temperature') IS NULL 
       AND JSON_EXTRACT(json_data, '$.readings.humidity') IS NULL THEN
        RETURN FALSE;
    END IF;
    
    RETURN TRUE;
END//

-- Trigger para validar JSON en insercion
CREATE TRIGGER trg_validar_json_sensor_insert
BEFORE INSERT ON iot_sensores_carga
FOR EACH ROW
BEGIN
    IF NOT validar_json_sensor(NEW.payload_datos) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El JSON no cumple el esquema requerido. Debe contener sensor_id y readings con temperature y/o humidity';
    END IF;
END//

CREATE TRIGGER trg_validar_json_sensor_update
BEFORE UPDATE ON iot_sensores_carga
FOR EACH ROW
BEGIN
    IF NOT validar_json_sensor(NEW.payload_datos) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El JSON no cumple el esquema requerido. Debe contener sensor_id y readings con temperature y/o humidity';
    END IF;
END//

-- Trigger para actualizar ultima_comunicacion del nodo
CREATE TRIGGER trg_actualizar_nodo_comunicacion
AFTER INSERT ON net_conectividad
FOR EACH ROW
BEGIN
    UPDATE net_nodos_recepcion 
    SET ultima_comunicacion = NEW.timestamp_registro
    WHERE id_nodo = NEW.id_nodo_fk;
END//

DELIMITER ;

-- =============================================================================
-- VISTAS PARA ANALISIS DE DATOS IoT
-- =============================================================================

-- Vista de ultimas lecturas por contenedor
CREATE VIEW v_ultimas_lecturas_iot AS
SELECT 
    sc.id_contenedor_fk,
    sc.id_lectura_iot,
    JSON_UNQUOTE(JSON_EXTRACT(sc.payload_datos, '$.sensor_id')) AS sensor_id,
    JSON_EXTRACT(sc.payload_datos, '$.readings.temperature') AS temperatura,
    JSON_EXTRACT(sc.payload_datos, '$.readings.humidity') AS humedad,
    sc.nivel_bateria_pct,
    sc.fecha_hora_recepcion
FROM iot_sensores_carga sc
INNER JOIN (
    SELECT id_contenedor_fk, MAX(fecha_hora_recepcion) AS max_fecha
    FROM iot_sensores_carga
    GROUP BY id_contenedor_fk
) ult ON sc.id_contenedor_fk = ult.id_contenedor_fk 
    AND sc.fecha_hora_recepcion = ult.max_fecha;

-- Vista de alertas activas
CREATE VIEW v_alertas_activas AS
SELECT 
    a.id_alerta,
    a.tipo_alerta,
    a.severidad,
    a.descripcion_alerta,
    sc.id_contenedor_fk,
    JSON_UNQUOTE(JSON_EXTRACT(sc.payload_datos, '$.sensor_id')) AS sensor_id,
    a.fecha_alerta
FROM iot_alertas_sensor a
JOIN iot_sensores_carga sc ON a.id_lectura_iot_fk = sc.id_lectura_iot
WHERE a.severidad IN ('ALTA', 'CRITICA')
ORDER BY a.fecha_alerta DESC;

-- =============================================================================
-- INDICES PARA OPTIMIZACION
-- =============================================================================

CREATE INDEX idx_gps_activo ON iot_gps_tracking(tipo_activo, activo_id);
CREATE INDEX idx_gps_fecha ON iot_gps_tracking(fecha_hora_lectura);
CREATE INDEX idx_iot_contenedor ON iot_sensores_carga(id_contenedor_fk);
CREATE INDEX idx_iot_fecha ON iot_sensores_carga(fecha_hora_recepcion);
CREATE INDEX idx_alertas_lectura ON iot_alertas_sensor(id_lectura_iot_fk);
CREATE INDEX idx_eventos_fecha ON log_eventos_ruta(fecha_evento);
CREATE INDEX idx_clima_gps ON log_meteorologia(id_lectura_gps_fk);
CREATE INDEX idx_nodo_estado ON net_nodos_recepcion(estado_nodo);
CREATE SPATIAL INDEX idx_nodo_ubicacion ON net_nodos_recepcion(ubicacion_geo);

-- =============================================================================
-- MENSAJE DE CONFIRMACION
-- =============================================================================

SELECT 'Base de datos orbita_telemetria creada exitosamente - 8 tablas' AS mensaje;
