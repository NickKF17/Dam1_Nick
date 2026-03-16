-- =============================================================================
-- SCRIPT 02: ORBITA_FLOTA
-- Descripcion: Gestion integral de activos fisicos de transporte - 14 tablas
-- Nota: Usa UNSIGNED BIGINT para todos los IDs de activos, personal y ordenes
-- Autor: Equipo de Respuesta Rapida
-- Fecha: 2026-03-16
-- =============================================================================

DROP DATABASE IF EXISTS orbita_flota;

CREATE DATABASE orbita_flota 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

USE orbita_flota;

-- =============================================================================
-- AREA: INFRAESTRUCTURA GLOBAL
-- =============================================================================

-- Tabla 1: inf_terminales
CREATE TABLE inf_terminales (
    codigo_unlocode CHAR(5) PRIMARY KEY,
    nombre_terminal VARCHAR(150) NOT NULL,
    tipo_infraestructura ENUM('PUERTO', 'AEROPUERTO', 'HUB_TERRESTRE') NOT NULL,
    codigo_pais CHAR(2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_unlocode CHECK (codigo_unlocode REGEXP '^[A-Z]{5}$')
) ENGINE=InnoDB;

-- Tabla 2: inf_hangares
CREATE TABLE inf_hangares (
    id_hangar BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    codigo_terminal_fk CHAR(5),
    capacidad_m2 DECIMAL(10,2),
    estado_uso BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_hangares_terminal FOREIGN KEY (codigo_terminal_fk) 
        REFERENCES inf_terminales(codigo_unlocode)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: ACTIVOS DE TRANSPORTE (LA FLOTA)
-- =============================================================================

-- Tabla 3: act_buques
CREATE TABLE act_buques (
    id_buque BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_buque VARCHAR(150) NOT NULL,
    numero_imo VARCHAR(15) NOT NULL UNIQUE,
    capacidad_teu INT UNSIGNED,
    año_construccion YEAR,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_numero_imo CHECK (numero_imo REGEXP '^IMO[0-9]{7}$')
) ENGINE=InnoDB;

-- Tabla 4: act_aviones
CREATE TABLE act_aviones (
    id_avion BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    matricula_faa VARCHAR(10) NOT NULL UNIQUE,
    modelo_aeronave VARCHAR(100),
    id_hangar_fk BIGINT UNSIGNED,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_aviones_hangar FOREIGN KEY (id_hangar_fk) 
        REFERENCES inf_hangares(id_hangar) ON DELETE SET NULL, -- Con esto se hace que el solo el hangar desaparezcan sin afectar al avion
    CONSTRAINT chk_matricula_faa CHECK (matricula_faa REGEXP '^N[A-Z0-9]{1,5}$')
) ENGINE=InnoDB;

-- Tabla 5: act_camiones
CREATE TABLE act_camiones (
    id_camion BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    matricula_vehiculo VARCHAR(10) NOT NULL UNIQUE,
    modelo_motor VARCHAR(100),
    tara_kg DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_matricula_vehiculo CHECK (matricula_vehiculo REGEXP '^[0-9]{4}[A-Z]{3}$')
) ENGINE=InnoDB;

-- Tabla 6: act_contenedores
CREATE TABLE act_contenedores (
    id_contenedor BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    numero_serie_bic VARCHAR(15) NOT NULL UNIQUE,
    id_tipo_cont_fk BIGINT UNSIGNED,
    estado_actual VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_numero_bic CHECK (numero_serie_bic REGEXP '^[A-Z]{4}[0-9]{7}$')
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: PERSONAL OPERATIVO Y TALENTO
-- =============================================================================

-- Tabla 7: per_empleados
CREATE TABLE per_empleados (
    id_empleado BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(150) NOT NULL,
    documento_identidad VARCHAR(15) NOT NULL UNIQUE,
    tipo_licencia ENUM('CAPITAN', 'PILOTO', 'CONDUCTOR', 'MECANICO') NOT NULL,
    fecha_contratacion DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_documento_id CHECK (documento_identidad REGEXP '^[0-9]{8}[A-Z]$')
) ENGINE=InnoDB;

-- Tabla 8: per_certificaciones
CREATE TABLE per_certificaciones (
    id_cert BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_empleado_fk BIGINT UNSIGNED NOT NULL,
    nombre_titulo VARCHAR(150) NOT NULL,
    entidad_emisora VARCHAR(150),
    fecha_caducidad DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_cert_empleado FOREIGN KEY (id_empleado_fk) 
        REFERENCES per_empleados(id_empleado) ON DELETE CASCADE
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: MANTENIMIENTO Y PIEZAS
-- =============================================================================

-- Tabla 9: mnt_ordenes
CREATE TABLE mnt_ordenes (
    id_orden BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tipo_activo ENUM('BUQUE', 'AVION', 'CAMION') NOT NULL,
    activo_id BIGINT UNSIGNED NOT NULL,
    id_mecanico_fk BIGINT UNSIGNED,
    descripcion_averia TEXT,
    fecha_inicio DATETIME,
    estado_reparacion VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_ordenes_mecanico FOREIGN KEY (id_mecanico_fk) 
        REFERENCES per_empleados(id_empleado) ON DELETE SET NULL 
) ENGINE=InnoDB;

-- Tabla 10: mnt_piezas
CREATE TABLE mnt_piezas (
    id_pieza BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre_pieza VARCHAR(150) NOT NULL,
    referencia_fabricante VARCHAR(50) NOT NULL UNIQUE,
    stock_minimo INT UNSIGNED DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_referencia_fab CHECK (referencia_fabricante REGEXP '^REF-[A-Z0-9]+$')
) ENGINE=InnoDB;

-- Tabla 11: mnt_piezas_orden (tabla intermedia para relacion ordenes-piezas)
CREATE TABLE mnt_piezas_orden (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_orden_fk BIGINT UNSIGNED NOT NULL,
    id_pieza_fk BIGINT UNSIGNED NOT NULL,
    cantidad_usada INT UNSIGNED DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_po_orden FOREIGN KEY (id_orden_fk) 
        REFERENCES mnt_ordenes(id_orden) ON DELETE CASCADE,
    CONSTRAINT fk_po_pieza FOREIGN KEY (id_pieza_fk) 
        REFERENCES mnt_piezas(id_pieza)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: MISIONES Y ASIGNACIONES
-- =============================================================================

-- Tabla 12: mis_misiones
CREATE TABLE mis_misiones (
    id_mision BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    codigo_mision VARCHAR(30) NOT NULL UNIQUE,
    tipo_transporte ENUM('MARITIMO', 'AEREO', 'TERRESTRE') NOT NULL,
    fecha_salida DATE,
    fecha_llegada_estimada DATE,
    estado_mision ENUM('PLANIFICADA', 'EN_CURSO', 'COMPLETADA', 'CANCELADA') DEFAULT 'PLANIFICADA',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Tabla 13: mis_asignaciones_activos
CREATE TABLE mis_asignaciones_activos (
    id_asignacion BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_mision_fk BIGINT UNSIGNED NOT NULL,
    tipo_activo ENUM('BUQUE', 'AVION', 'CAMION', 'CONTENEDOR') NOT NULL,
    activo_id BIGINT UNSIGNED NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_asign_mision FOREIGN KEY (id_mision_fk) 
        REFERENCES mis_misiones(id_mision) ON DELETE CASCADE -- Cumplimos con la regla de error zero , 
) ENGINE=InnoDB;

-- Tabla 14: mis_tripulacion
CREATE TABLE mis_tripulacion (
    id_asignacion_trip BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_mision_fk BIGINT UNSIGNED NOT NULL,
    id_empleado_fk BIGINT UNSIGNED NOT NULL,
    rol_tripulacion VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_trip_mision FOREIGN KEY (id_mision_fk) 
        REFERENCES mis_misiones(id_mision) ON DELETE CASCADE,
    CONSTRAINT fk_trip_empleado FOREIGN KEY (id_empleado_fk) 
        REFERENCES per_empleados(id_empleado)
) ENGINE=InnoDB;

-- =============================================================================
-- TRIGGERS PARA VALIDACION DE CLAVES FORANEAS POLIMORFICAS
-- =============================================================================

DELIMITER //

-- Trigger para validar que el activo existe en la tabla correspondiente
CREATE TRIGGER trg_validar_activo_orden_insert
BEFORE INSERT ON mnt_ordenes
FOR EACH ROW BEGIN
    DECLARE v_existe INT DEFAULT 0;
    
    IF NEW.tipo_activo = 'BUQUE' THEN
        SELECT COUNT(*) INTO v_existe FROM act_buques WHERE id_buque = NEW.activo_id;
    ELSEIF NEW.tipo_activo = 'AVION' THEN
        SELECT COUNT(*) INTO v_existe FROM act_aviones WHERE id_avion = NEW.activo_id;
    ELSEIF NEW.tipo_activo = 'CAMION' THEN
        SELECT COUNT(*) INTO v_existe FROM act_camiones WHERE id_camion = NEW.activo_id;
    END IF;
    
    IF v_existe = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El activo referenciado no existe en la tabla correspondiente';
    END IF;
END//

CREATE TRIGGER trg_validar_activo_orden_update
BEFORE UPDATE ON mnt_ordenes
FOR EACH ROW
BEGIN
    DECLARE v_existe INT DEFAULT 0;
    
    IF NEW.tipo_activo = 'BUQUE' THEN
        SELECT COUNT(*) INTO v_existe FROM act_buques WHERE id_buque = NEW.activo_id;
    ELSEIF NEW.tipo_activo = 'AVION' THEN
        SELECT COUNT(*) INTO v_existe FROM act_aviones WHERE id_avion = NEW.activo_id;
    ELSEIF NEW.tipo_activo = 'CAMION' THEN
        SELECT COUNT(*) INTO v_existe FROM act_camiones WHERE id_camion = NEW.activo_id;
    END IF;
    
    IF v_existe = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El activo referenciado no existe en la tabla correspondiente';
    END IF;
END//

-- Trigger para prevenir borrado de hangar con aviones asignados (RESTRICT)
CREATE TRIGGER trg_prevenir_borrar_hangar
BEFORE DELETE ON inf_hangares
FOR EACH ROW BEGIN
    DECLARE v_aviones_asignados INT DEFAULT 0;
    
    SELECT COUNT(*) INTO v_aviones_asignados 
    FROM act_aviones 
    WHERE id_hangar_fk = OLD.id_hangar;
    
    IF v_aviones_asignados > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: No se puede borrar un hangar con aviones asignados';
    END IF;
END//

-- Trigger para CASCADE: borrar ordenes cuando se borra un activo
CREATE TRIGGER trg_cascade_ordenes_buque
AFTER DELETE ON act_buques
FOR EACH ROW
BEGIN
    DELETE FROM mnt_ordenes WHERE tipo_activo = 'BUQUE' AND activo_id = OLD.id_buque;
END//

CREATE TRIGGER trg_cascade_ordenes_avion
AFTER DELETE ON act_aviones
FOR EACH ROW
BEGIN
    DELETE FROM mnt_ordenes WHERE tipo_activo = 'AVION' AND activo_id = OLD.id_avion;
END//

CREATE TRIGGER trg_cascade_ordenes_camion
AFTER DELETE ON act_camiones
FOR EACH ROW
BEGIN
    DELETE FROM mnt_ordenes WHERE tipo_activo = 'CAMION' AND activo_id = OLD.id_camion;
END//

DELIMITER ;

-- =============================================================================
-- INDICES PARA OPTIMIZACION
-- =============================================================================

CREATE INDEX idx_aviones_hangar ON act_aviones(id_hangar_fk);
CREATE INDEX idx_cert_empleado ON per_certificaciones(id_empleado_fk);
CREATE INDEX idx_ordenes_activo ON mnt_ordenes(tipo_activo, activo_id);
CREATE INDEX idx_ordenes_mecanico ON mnt_ordenes(id_mecanico_fk);
CREATE INDEX idx_asign_mision ON mis_asignaciones_activos(id_mision_fk);
CREATE INDEX idx_trip_mision ON mis_tripulacion(id_mision_fk);

-- =============================================================================
-- MENSAJE DE CONFIRMACION
-- =============================================================================

SELECT 'Base de datos orbita_flota creada exitosamente - 14 tablas' AS mensaje;