-- =============================================================================
-- SCRIPT 03: ORBITA_TELEMETRIA (VERSIÓN FUSIONADA Y AUDITADA)
-- =============================================================================

-- 1. CONFIGURACIÓN GLOBAL (Evita el colapso del "Gran Crash") 
SET GLOBAL max_allowed_packet = 1073741824; 
SET GLOBAL local_infile = 1;

DROP DATABASE IF EXISTS orbita_telemetria;

CREATE DATABASE orbita_telemetria 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

USE orbita_telemetria;

-- =============================================================================
-- TABLAS MAESTRAS (Para alcanzar las 8 tablas y asegurar FKs) 
-- =============================================================================

CREATE TABLE maestros_activos (
    id_activo BIGINT UNSIGNED PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE maestros_contenedores (
    id_contenedor BIGINT UNSIGNED PRIMARY KEY,
    codigo_iso CHAR(11)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: SEGUIMIENTO DE ACTIVOS (TRACKING) [cite: 12]
-- =============================================================================

CREATE TABLE iot_gps_tracking (
    id_lectura BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, [cite: 14]
    tipo_activo ENUM('BUQUE', 'AVION', 'CAMION') NOT NULL, [cite: 15]
    activo_id BIGINT UNSIGNED NOT NULL, [cite: 16]
    latitud DECIMAL(10, 8) NOT NULL, [cite: 17]
    longitud DECIMAL(11, 8) NOT NULL, [cite: 18]
    fecha_hora_lectura DATETIME DEFAULT CURRENT_TIMESTAMP, [cite: 19]
    CONSTRAINT fk_tracking_activo FOREIGN KEY (activo_id) REFERENCES maestros_activos(id_activo),
    CONSTRAINT chk_latitud CHECK (latitud BETWEEN -90 AND 90),
    CONSTRAINT chk_longitud CHECK (longitud BETWEEN -180 AND 180)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: MONITORIZACION DE CARGA (IoT) [cite: 20]
-- =============================================================================

CREATE TABLE iot_sensores_carga (
    id_lectura_iot BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, [cite: 22]
    id_contenedor_fk BIGINT UNSIGNED, [cite: 23]
    payload_datos JSON NOT NULL, [cite: 24, 46]
    nivel_bateria_pct DECIMAL(5,2), [cite: 26]
    fecha_hora_recepcion DATETIME DEFAULT CURRENT_TIMESTAMP, [cite: 27]
    
    -- VALIDACIÓN DE ESQUEMA JSON (Milimétrica según PDF) [cite: 47, 48, 49, 50]
    CONSTRAINT chk_esquema_json CHECK (
        JSON_TYPE(JSON_EXTRACT(payload_datos, '$.sensor_id')) = 'STRING' AND
        JSON_TYPE(JSON_EXTRACT(payload_datos, '$.readings')) = 'OBJECT' AND
        (
            JSON_EXTRACT(payload_datos, '$.readings.temperature') IS NOT NULL OR 
            JSON_EXTRACT(payload_datos, '$.readings.humidity') IS NOT NULL
        )
    ),
    CONSTRAINT fk_iot_contenedor FOREIGN KEY (id_contenedor_fk) REFERENCES maestros_contenedores(id_contenedor)
) ENGINE=InnoDB;

CREATE TABLE iot_alertas_sensor (
    id_alerta BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, [cite: 29]
    id_lectura_iot_fk BIGINT UNSIGNED NOT NULL, [cite: 30]
    tipo_alerta CHAR(7) NOT NULL, [cite: 31, 52]
    -- Campos añadidos para compatibilidad con Procedimiento DML:
    descripcion_alerta VARCHAR(255), 
    severidad ENUM('BAJA', 'MEDIA', 'ALTA', 'CRITICA'),
    fecha_alerta DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_alertas_lectura FOREIGN KEY (id_lectura_iot_fk) 
        REFERENCES iot_sensores_carga(id_lectura_iot) ON DELETE CASCADE,
    CONSTRAINT chk_tipo_alerta CHECK (tipo_alerta REGEXP '^ALR-[A-Z]{3}$') [cite: 52]
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: EVENTOS E INCIDENCIAS [cite: 32]
-- =============================================================================

CREATE TABLE log_eventos_ruta (
    id_evento BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, [cite: 34]
    tipo_evento ENUM('CLIMA', 'PIRATERIA', 'RETRASO', 'FALLO_MECANICO') NOT NULL, [cite: 35]
    severidad ENUM('BAJA', 'MEDIA', 'ALTA', 'CRITICA') NOT NULL, [cite: 35]
    -- Campo añadido para compatibilidad con Procedimiento DML:
    descripcion_evento TEXT,
    fecha_evento DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

CREATE TABLE log_meteorologia (
    id_clima BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, [cite: 37]
    id_lectura_gps_fk BIGINT UNSIGNED, [cite: 38]
    presion_hpa INT, [cite: 39]
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_clima_gps FOREIGN KEY (id_lectura_gps_fk) 
        REFERENCES iot_gps_tracking(id_lectura) ON DELETE SET NULL,
    CONSTRAINT chk_presion CHECK (presion_hpa BETWEEN 800 AND 1100)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: INFRAESTRUCTURA DE RED (NODOS) [cite: 40]
-- =============================================================================

CREATE TABLE net_nodos_recepcion (
    id_nodo BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY, [cite: 42]
    nombre_estacion CHAR(9) NOT NULL UNIQUE, [cite: 43, 53]
    ubicacion_geo POINT NOT NULL SRID 4326, -- Formato Coordenadas 
    SPATIAL INDEX(ubicacion_geo),
    CONSTRAINT chk_nombre_nodo CHECK (nombre_estacion REGEXP '^NODE-[0-9]{4}$') [cite: 53]
) ENGINE=InnoDB;

-- =============================================================================
-- VISTA PARA ANÁLISIS [cite: 6]
-- =============================================================================

CREATE VIEW v_ultimas_lecturas_iot AS
SELECT 
    sc.id_contenedor_fk,
    JSON_UNQUOTE(JSON_EXTRACT(sc.payload_datos, '$.sensor_id')) AS sensor_id,
    JSON_EXTRACT(sc.payload_datos, '$.readings.temperature') AS temperatura,
    JSON_EXTRACT(sc.payload_datos, '$.readings.humidity') AS humedad,
    sc.nivel_bateria_pct,
    sc.fecha_hora_recepcion
FROM iot_sensores_carga sc;

SELECT 'Base de datos orbita_telemetria configurada con éxito' AS mensaje;