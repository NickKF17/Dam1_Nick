-- =============================================================================
-- SCRIPT 04: ORBITA_DOCUMENTAL
-- Descripcion: Repositorio legal inmutable con almacenamiento de objetos binarios
--              9 tablas con gestion de permisos a nivel de OS
-- Autor: Equipo de Respuesta Rapida
-- Fecha: 2026-03-16
-- =============================================================================

-- Configuracion previa necesaria para manejo de archivos grandes
-- Ejecutar en MySQL antes de cargar este script:
-- SET GLOBAL max_allowed_packet = 1073741824; -- 1GB
-- SET GLOBAL secure_file_priv = '/ruta/autorizada/';

DROP DATABASE IF EXISTS orbita_documental;

CREATE DATABASE orbita_documental 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

USE orbita_documental;

-- =============================================================================
-- AREA: ADUANAS Y CARGA
-- =============================================================================

-- Tabla 1: doc_manifiestos
CREATE TABLE doc_manifiestos (
    id_manifiesto BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    referencia_transporte VARCHAR(50) NOT NULL,
    archivo_pdf LONGBLOB,
    hash_sha256 CHAR(64) NOT NULL,
    fecha_carga DATETIME DEFAULT CURRENT_TIMESTAMP,
    tamano_bytes BIGINT UNSIGNED,
    uploaded_by VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_ref_transporte CHECK (
        referencia_transporte REGEXP '^(SHIP|AIR|LAND)-[0-9]{4}-[A-Z0-9]+$'
    ),
    CONSTRAINT chk_hash_sha256 CHECK (
        hash_sha256 REGEXP '^[A-Fa-f0-9]{64}$'
    )
) ENGINE=InnoDB;

-- Tabla 2: doc_declaraciones_dua
CREATE TABLE doc_declaraciones_dua (
    id_dua_doc BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_tramite_fk BIGINT UNSIGNED ON DELETE SET NULL,
    num_declaracion VARCHAR(50) NOT NULL UNIQUE,
    archivo_binario LONGBLOB,
    hash_sha256 CHAR(64) NOT NULL,
    fecha_carga DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_num_declaracion CHECK (
        num_declaracion REGEXP '^DUA-[0-9]{4}-[A-Z0-9]+$'
    ),
    CONSTRAINT chk_dua_hash CHECK (
        hash_sha256 REGEXP '^[A-Fa-f0-9]{64}$'
    )
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: LEGAL Y SEGUROS
-- =============================================================================

-- Tabla 3: doc_contratos_firmados
CREATE TABLE doc_contratos_firmados (
    id_contrato_doc BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_contrato_fk BIGINT UNSIGNED ON DELETE SET NULL,
    archivo_pdf_legal LONGBLOB,
    hash_sha256 CHAR(64) NOT NULL,
    fecha_escaneado DATE,
    fecha_carga DATETIME DEFAULT CURRENT_TIMESTAMP,
    notario_validador VARCHAR(150),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_contrato_hash CHECK (
        hash_sha256 REGEXP '^[A-Fa-f0-9]{64}$'
    )
) ENGINE=InnoDB;

-- Tabla 4: doc_polizas_seguros
CREATE TABLE doc_polizas_seguros (
    id_poliza_doc BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    numero_poliza VARCHAR(50) NOT NULL UNIQUE,
    entidad_aseguradora VARCHAR(150) NOT NULL,
    archivo_pdf_poliza LONGBLOB,
    hash_sha256 CHAR(64) NOT NULL,
    fecha_inicio DATE,
    fecha_vencimiento DATE,
    cobertura_eur DECIMAL(15,2),
    fecha_carga DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_numero_poliza CHECK (
        numero_poliza REGEXP '^POL-[0-9]+$'
    ),
    CONSTRAINT chk_poliza_hash CHECK (
        hash_sha256 REGEXP '^[A-Fa-f0-9]{64}$'
    )
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: SINIESTROS Y PERITAJES
-- =============================================================================

-- Tabla 5: doc_siniestros
CREATE TABLE doc_siniestros (
    id_siniestro_doc BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_incidencia_fk BIGINT UNSIGNED ON DELETE SET NULL,
    informe_peritaje_pdf LONGBLOB,
    descripcion_daños TEXT,
    fecha_siniestro DATE,
    estimacion_danos_eur DECIMAL(15,2),
    estado_reclamacion ENUM('PENDIENTE', 'EN_TRAMITE', 'RESUELTA', 'RECHAZADA') DEFAULT 'PENDIENTE',
    fecha_carga DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: AUDITORIA Y FIRMAS
-- =============================================================================

-- Tabla 6: doc_firmas_digitales
CREATE TABLE doc_firmas_digitales (
    id_firma BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_referencia_doc BIGINT UNSIGNED NOT NULL,
    tabla_referencia VARCHAR(50) NOT NULL,
    sello_digital LONGBLOB,
    certificado_firma LONGBLOB,
    id_empleado_auditor_fk BIGINT UNSIGNED ON DELETE SET NULL,
    fecha_firma DATETIME DEFAULT CURRENT_TIMESTAMP,
    validez_firma ENUM('VALIDA', 'REVOCADA', 'EXPIRADA') DEFAULT 'VALIDA',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_tabla_ref CHECK (
        tabla_referencia IN ('doc_manifiestos', 'doc_declaraciones_dua', 
                            'doc_contratos_firmados', 'doc_polizas_seguros', 
                            'doc_siniestros'),
    CONSTRAINT fk_firmas_manifiesto FOREIGN KEY (id_referencia_doc) 
        REFERENCES doc_manifiestos(id_manifiesto) ON DELETE SET NULL
    )
) ENGINE=InnoDB;

-- Tabla 7: log_auditoria_documental
CREATE TABLE log_auditoria_documental (
    id_log BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_documento BIGINT UNSIGNED NOT NULL,
    tabla_documento VARCHAR(50) NOT NULL,
    accion_realizada ENUM('SUBIDA', 'LECTURA', 'BORRADO', 'MODIFICACION') NOT NULL,
    ip_origen VARCHAR(45),
    usuario_sistema VARCHAR(100),
    fecha_hora DATETIME DEFAULT CURRENT_TIMESTAMP,
    detalles_adicionales JSON,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_auditoria_fecha (fecha_hora),
    INDEX idx_auditoria_documento (tabla_documento, id_documento)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: GESTION DE PERMISOS Y VERSIONADO
-- =============================================================================

-- Tabla 8: doc_permisos_acceso
CREATE TABLE doc_permisos_acceso (
    id_permiso BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_documento BIGINT UNSIGNED NOT NULL,
    tabla_documento VARCHAR(50) NOT NULL,
    tipo_usuario ENUM('EMPLEADO', 'CLIENTE', 'AGENTE', 'ADMIN') NOT NULL,
    id_usuario BIGINT UNSIGNED,
    permiso_lectura BOOLEAN DEFAULT FALSE,
    permiso_escritura BOOLEAN DEFAULT FALSE,
    permiso_borrado BOOLEAN DEFAULT FALSE,
    fecha_concesion DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_expiracion DATETIME,
    concedido_por BIGINT UNSIGNED,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Tabla 9: doc_versiones
CREATE TABLE doc_versiones (
    id_version BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    id_documento BIGINT UNSIGNED NOT NULL,
    tabla_documento VARCHAR(50) NOT NULL,
    version_numero INT UNSIGNED NOT NULL,
    archivo_version LONGBLOB,
    hash_sha256 CHAR(64) NOT NULL,
    cambios_descripcion TEXT,
    creado_por VARCHAR(100),
    fecha_version DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uk_version_doc (id_documento, tabla_documento, version_numero),
    CONSTRAINT chk_version_hash CHECK (
        hash_sha256 REGEXP '^[A-Fa-f0-9]{64}$'
    )
) ENGINE=InnoDB;

-- =============================================================================
-- Creando las rutas foreaneas completas
-- =============================================================================

ALTER TABLE doc_declaraciones_dua
ADD CONSTRAINT fk_dua_manifiesto
    FOREIGN KEY (id_tramite_fk)
    REFERENCES doc_manifiestos(id_manifiesto)
    ON DELETE SET NULL;

ALTER TABLE doc_firmas_digitales
ADD CONSTRAINT fk_firmas_manifiesto
    FOREIGN KEY (id_referencia_doc)
    REFERENCES doc_manifiestos(id_manifiesto)
    ON DELETE SET NULL;

ALTER TABLE doc_versiones
ADD CONSTRAINT fk_versiones_manifiesto
    FOREIGN KEY (id_documento)
    REFERENCES doc_manifiestos(id_manifiesto)
    ON DELETE SET NULL;

ALTER TABLE doc_permisos_acceso
ADD CONSTRAINT fk_permisos_documento
    FOREIGN KEY (id_documento)
    REFERENCES doc_manifiestos(id_manifiesto)
    ON DELETE SET NULL;

ALTER TABLE log_auditoria_documental
ADD CONSTRAINT fk_log_documento
    FOREIGN KEY (id_documento)
    REFERENCES doc_manifiestos(id_manifiesto)
    ON DELETE SET NULL;

-- Funcion para calcular hash SHA256 de un documento
DELIMITER //
CREATE FUNCTION calcular_hash_documento(contenido LONGBLOB)
RETURNS CHAR(64)
DETERMINISTIC
NO SQL
BEGIN
    RETURN SHA2(contenido, 256);
END//
DELIMITER ;

-- =============================================================================
-- VISTAS PARA GESTION DOCUMENTAL
-- =============================================================================

-- Vista de documentos con informacion de auditoria
CREATE VIEW v_documentos_con_auditoria AS
SELECT 
    'MANIFIESTO' AS tipo_documento,
    m.id_manifiesto AS id_documento,
    m.referencia_transporte AS referencia,
    m.fecha_carga,
    m.tamano_bytes,
    m.hash_sha256,
    (SELECT COUNT(*) FROM log_auditoria_documental 
     WHERE tabla_documento = 'doc_manifiestos' 
     AND id_documento = m.id_manifiesto 
     AND accion_realizada = 'LECTURA') AS num_accesos
FROM doc_manifiestos m
UNION ALL
SELECT 
    'DUA' AS tipo_documento,
    d.id_dua_doc AS id_documento,
    d.num_declaracion AS referencia,
    d.fecha_carga,
    LENGTH(d.archivo_binario) AS tamano_bytes,
    d.hash_sha256,
    (SELECT COUNT(*) FROM log_auditoria_documental 
     WHERE tabla_documento = 'doc_declaraciones_dua' 
     AND id_documento = d.id_dua_doc 
     AND accion_realizada = 'LECTURA') AS num_accesos
FROM doc_declaraciones_dua d
UNION ALL
SELECT 
    'CONTRATO' AS tipo_documento,
    c.id_contrato_doc AS id_documento,
    CONCAT('CONTRATO-', c.id_contrato_fk) AS referencia,
    c.fecha_carga,
    LENGTH(c.archivo_pdf_legal) AS tamano_bytes,
    c.hash_sha256,
    (SELECT COUNT(*) FROM log_auditoria_documental 
     WHERE tabla_documento = 'doc_contratos_firmados' 
     AND id_documento = c.id_contrato_doc 
     AND accion_realizada = 'LECTURA') AS num_accesos
FROM doc_contratos_firmados c
UNION ALL
SELECT 
    'POLIZA' AS tipo_documento,
    p.id_poliza_doc AS id_documento,
    p.numero_poliza AS referencia,
    p.fecha_carga,
    LENGTH(p.archivo_pdf_poliza) AS tamano_bytes,
    p.hash_sha256,
    (SELECT COUNT(*) FROM log_auditoria_documental 
     WHERE tabla_documento = 'doc_polizas_seguros' 
     AND id_documento = p.id_poliza_doc 
     AND accion_realizada = 'LECTURA') AS num_accesos
FROM doc_polizas_seguros p;

-- =============================================================================
-- INDICES PARA OPTIMIZACION
-- =============================================================================

CREATE INDEX idx_manifiestos_ref ON doc_manifiestos(referencia_transporte);
CREATE INDEX idx_dua_tramite ON doc_declaraciones_dua(id_tramite_fk);
CREATE INDEX idx_contratos_fk ON doc_contratos_firmados(id_contrato_fk);
CREATE INDEX idx_polizas_numero ON doc_polizas_seguros(numero_poliza);
CREATE INDEX idx_siniestros_incidencia ON doc_siniestros(id_incidencia_fk);
CREATE INDEX idx_firmas_ref ON doc_firmas_digitales(id_referencia_doc, tabla_referencia);
CREATE INDEX idx_versiones_doc ON doc_versiones(id_documento, tabla_documento);

-- =============================================================================
-- INGESTA BINARIA REQUERIDA POR EL ANEXO TÉCNICO
-- Requisito: Usar LOAD_FILE y SHA2 para integridad
-- =============================================================================

INSERT INTO doc_manifiestos (referencia_transporte, archivo_pdf, hash_sha256)
VALUES (
    'SHIP-2026-TEST01', 
    LOAD_FILE('manifiesto_legal.pdf'), 
    SHA2(LOAD_FILE('manifiesto_legal.pdf'), 256)
);

INSERT INTO doc_manifiestos (referencia_transporte, archivo_pdf, hash_sha256)
VALUES (
    'AIR-2026-TEST02', 
    LOAD_FILE('declaracion_aduana.pdf'), 
    SHA2(LOAD_FILE('declaracion_aduana.pdf'), 256)
);

-- =============================================================================
-- CONFIGURACION DE PERMISOS (COMANDOS PARA DBA)
-- =============================================================================

-- Nota: Ejecutar estos comandos como root o usuario con privilegios
-- GRANT FILE ON *.* TO 'orbita_user'@'localhost';
-- FLUSH PRIVILEGES;

-- Verificar configuracion de secure_file_priv
-- SHOW VARIABLES LIKE 'secure_file_priv';

-- Configurar max_allowed_packet para archivos grandes
-- SET GLOBAL max_allowed_packet = 1073741824; -- 1GB

-- =============================================================================
-- MENSAJE DE CONFIRMACION
-- =============================================================================

SELECT 'Base de datos orbita_documental creada exitosamente - 9 tablas' AS mensaje;
SELECT 'IMPORTANTE: Configurar max_allowed_packet y secure_file_priv para carga de archivos' AS advertencia;
