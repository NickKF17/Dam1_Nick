USE orbita_telemetria;

DELIMITER //

CREATE PROCEDURE sp_insertar_lectura_iot_ESTRICTO(
    IN p_id_contenedor BIGINT UNSIGNED,
    IN p_payload_json JSON,
    IN p_nivel_bateria DECIMAL(5,2)
)
BEGIN
    -- 1. Insertar la lectura principal (El CHECK de la tabla validará el JSON automáticamente)
    INSERT INTO iot_sensores_carga (
        id_contenedor_fk, 
        payload_datos, 
        nivel_bateria_pct
    ) VALUES (
        p_id_contenedor, 
        p_payload_json, 
        p_nivel_bateria
    );
    
    -- 2. Si el JSON traía alertas, las registramos en la tabla de alertas
    -- Solo usamos la columna 'tipo_alerta' que pide el PDF
    IF JSON_EXTRACT(p_payload_json, '$.alerts') IS NOT NULL THEN
        INSERT INTO iot_alertas_sensor (id_lectura_iot_fk, tipo_alerta)
        SELECT 
            LAST_INSERT_ID(), 
            CONCAT('ALR-', UPPER(SUBSTRING(JSON_UNQUOTE(JSON_EXTRACT(p_payload_json, '$.sensor_id')), 1, 3)))
        FROM JSON_TABLE(p_payload_json, '$.alerts[*]' COLUMNS (val VARCHAR(50) PATH '$')) AS jt;
    END IF;
END //

DELIMITER ;
