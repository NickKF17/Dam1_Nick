-- =============================================================================
-- SCRIPT 01: ORBITA_COMERCIAL
-- Descripcion: Motor relacional del negocio - 16 tablas
-- Autor: Equipo de Respuesta Rapida
-- Fecha: 2026-03-16
-- =============================================================================

-- Eliminar base de datos si existe (para pruebas limpias)
DROP DATABASE IF EXISTS orbita_comercial;

-- Crear base de datos con configuracion UTF8
CREATE DATABASE orbita_comercial 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

USE orbita_comercial;

-- =============================================================================
-- AREA: GEOPOLITICA Y FISCALIDAD
-- =============================================================================

-- Tabla 1: geo_regiones
CREATE TABLE geo_regiones (
    id_region INT AUTO_INCREMENT PRIMARY KEY,
    nombre_region VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Tabla 2: geo_monedas (debe crearse antes de geo_paises por la FK)
CREATE TABLE geo_monedas (
    codigo_iso_moneda CHAR(3) PRIMARY KEY,
    nombre_moneda VARCHAR(100) NOT NULL,
    simbolo_moneda VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_codigo_moneda CHECK (codigo_iso_moneda REGEXP '^[A-Z]{3}$')
) ENGINE=InnoDB;

-- Tabla 3: geo_paises
CREATE TABLE geo_paises (
    codigo_iso_pais CHAR(2) PRIMARY KEY,
    nombre_pais VARCHAR(150) NOT NULL,
    id_region_fk INT,
    moneda_iso CHAR(3),
    iva_importacion_pct DECIMAL(5,2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_paises_region FOREIGN KEY (id_region_fk) 
        REFERENCES geo_regiones(id_region),
    CONSTRAINT fk_paises_moneda FOREIGN KEY (moneda_iso) 
        REFERENCES geo_monedas(codigo_iso_moneda),
    CONSTRAINT chk_codigo_pais CHECK (codigo_iso_pais REGEXP '^[A-Z]{2}$')
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: CARTERA DE CLIENTES Y CONTACTOS
-- =============================================================================

-- Tabla 4: ent_matrices
CREATE TABLE ent_matrices (
    id_matriz INT AUTO_INCREMENT PRIMARY KEY,
    razon_social VARCHAR(200) NOT NULL,
    cif_nif VARCHAR(20) NOT NULL UNIQUE,
    codigo_pais_fk CHAR(2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_matrices_pais FOREIGN KEY (codigo_pais_fk) 
        REFERENCES geo_paises(codigo_iso_pais),
    CONSTRAINT chk_cif_nif CHECK (cif_nif REGEXP '^[A-Z][0-9]{8}$')
) ENGINE=InnoDB;

-- Tabla 5: ent_clientes
CREATE TABLE ent_clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_comercial VARCHAR(200) NOT NULL,
    id_matriz_fk INT,
    id_agente_principal_fk INT,
    clasificacion ENUM('ESTANDAR', 'VIP', 'GUBERNAMENTAL') DEFAULT 'ESTANDAR',
    fecha_alta DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_clientes_matriz FOREIGN KEY (id_matriz_fk) 
        REFERENCES ent_matrices(id_matriz),
    CONSTRAINT chk_jerarquia_cliente CHECK (id_cliente != id_matriz_fk)
) ENGINE=InnoDB;

-- Tabla 6: ent_contactos
CREATE TABLE ent_contactos (
    id_contacto INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente_fk INT NOT NULL,
    nombre_completo VARCHAR(150) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(30),
    es_principal_legal BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_contactos_cliente FOREIGN KEY (id_cliente_fk) 
        REFERENCES ent_clientes(id_cliente) ON DELETE CASCADE
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: GESTION ADUANERA
-- =============================================================================

-- Tabla 7: adu_agentes
CREATE TABLE adu_agentes (
    id_agente INT AUTO_INCREMENT PRIMARY KEY,
    nombre_agente VARCHAR(150) NOT NULL,
    num_licencia_federal VARCHAR(20) NOT NULL UNIQUE,
    id_cliente_empleador_fk INT,
    estado_homologacion ENUM('ACTIVO', 'SUSPENDIDO', 'RETIRADO') DEFAULT 'ACTIVO',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_agentes_cliente FOREIGN KEY (id_cliente_empleador_fk) 
        REFERENCES ent_clientes(id_cliente),
    CONSTRAINT chk_licencia_federal CHECK (num_licencia_federal REGEXP '^FED-[0-9]{6}$')
) ENGINE=InnoDB;

-- Tabla 8: adu_delegaciones
CREATE TABLE adu_delegaciones (
    id_delegacion INT AUTO_INCREMENT PRIMARY KEY,
    nombre_delegacion VARCHAR(150) NOT NULL,
    codigo_pais_fk CHAR(2),
    direccion_fisica TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_delegaciones_pais FOREIGN KEY (codigo_pais_fk) 
        REFERENCES geo_paises(codigo_iso_pais)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: CATALOGO Y TARIFAS
-- =============================================================================

-- Tabla 9: cat_tipos_contenedor
CREATE TABLE cat_tipos_contenedor (
    id_tipo_cont INT AUTO_INCREMENT PRIMARY KEY,
    descripcion_tecnica VARCHAR(200) NOT NULL,
    peso_max_ton DECIMAL(8,3) NOT NULL,
    categoria_transporte ENUM('ESTANDAR', 'REFRIGERADO', 'PELIGROSOS', 'AEREO') DEFAULT 'ESTANDAR',
    volumen_m3 DECIMAL(10,3),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_peso_positivo CHECK (peso_max_ton > 0),
    CONSTRAINT chk_peso_aereo CHECK (
        (categoria_transporte != 'AEREO') OR 
        (categoria_transporte = 'AEREO' AND peso_max_ton <= 5.5)
    )
) ENGINE=InnoDB;

-- Tabla 10: cat_servicios
CREATE TABLE cat_servicios (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre_servicio VARCHAR(150) NOT NULL,
    descripcion_comercial TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Tabla 11: cat_tarifas
CREATE TABLE cat_tarifas (
    id_tarifa INT AUTO_INCREMENT PRIMARY KEY,
    id_servicio_fk INT NOT NULL,
    id_tipo_cont_fk INT,
    precio_base DECIMAL(15,2) NOT NULL,
    moneda_iso_fk CHAR(3),
    vigencia_hasta DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_tarifas_servicio FOREIGN KEY (id_servicio_fk) 
        REFERENCES cat_servicios(id_servicio),
    CONSTRAINT fk_tarifas_tipo_cont FOREIGN KEY (id_tipo_cont_fk) 
        REFERENCES cat_tipos_contenedor(id_tipo_cont),
    CONSTRAINT fk_tarifas_moneda FOREIGN KEY (moneda_iso_fk) 
        REFERENCES geo_monedas(codigo_iso_moneda)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: FACTURACION Y CONTRATOS
-- =============================================================================

-- Tabla 12: fin_contratos
CREATE TABLE fin_contratos (
    id_contrato INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente_fk INT NOT NULL,
    fecha_firma DATE NOT NULL,
    fecha_vencimiento DATE,
    estado_contrato ENUM('ACTIVO', 'EXPIRADO', 'REVISION') DEFAULT 'ACTIVO',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_contratos_cliente FOREIGN KEY (id_cliente_fk) 
        REFERENCES ent_clientes(id_cliente) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Tabla 13: fin_facturas
CREATE TABLE fin_facturas (
    id_factura INT AUTO_INCREMENT PRIMARY KEY,
    num_factura_serie VARCHAR(20) NOT NULL UNIQUE,
    id_contrato_fk INT,
    fecha_emision DATE NOT NULL,
    base_imponible DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    total_iva DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    total_factura DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    estado_pago ENUM('PENDIENTE', 'PAGADA', 'VENCIDA') DEFAULT 'PENDIENTE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_facturas_contrato FOREIGN KEY (id_contrato_fk) 
        REFERENCES fin_contratos(id_contrato) ON DELETE SET NULL,
    CONSTRAINT chk_fecha_emision CHECK (fecha_emision <= CURRENT_DATE),
    CONSTRAINT chk_num_factura CHECK (num_factura_serie REGEXP '^FAC-[0-9]{4}-[0-9]{5}$')
) ENGINE=InnoDB;

-- Tabla 14: adu_tramites (depende de fin_facturas)
CREATE TABLE adu_tramites (
    id_tramite INT AUTO_INCREMENT PRIMARY KEY,
    id_factura_fk INT,
    id_agente_fk INT,
    id_delegacion_fk INT,
    estado_tramite VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_tramites_factura FOREIGN KEY (id_factura_fk) 
        REFERENCES fin_facturas(id_factura),
    CONSTRAINT fk_tramites_agente FOREIGN KEY (id_agente_fk) 
        REFERENCES adu_agentes(id_agente),
    CONSTRAINT fk_tramites_delegacion FOREIGN KEY (id_delegacion_fk) 
        REFERENCES adu_delegaciones(id_delegacion)
) ENGINE=InnoDB;

-- Tabla 15: fin_lineas_factura
CREATE TABLE fin_lineas_factura (
    id_linea INT AUTO_INCREMENT PRIMARY KEY,
    id_factura_fk INT NOT NULL,
    descripcion_linea TEXT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    precio_unitario DECIMAL(15,2) NOT NULL,
    subtotal DECIMAL(15,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_lineas_factura FOREIGN KEY (id_factura_fk) 
        REFERENCES fin_facturas(id_factura) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Tabla 16: fin_impuestos_especiales
CREATE TABLE fin_impuestos_especiales (
    id_impuesto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_impuesto VARCHAR(100) NOT NULL,
    tasa_porcentaje DECIMAL(5,2) NOT NULL,
    codigo_pais_fk CHAR(2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_impuestos_pais FOREIGN KEY (codigo_pais_fk) 
        REFERENCES geo_paises(codigo_iso_pais)
) ENGINE=InnoDB;

-- =============================================================================
-- TRIGGERS ADICIONALES PARA VALIDACIONES COMPLEJAS
-- =============================================================================

DELIMITER //

-- Trigger para validar que un cliente no sea su propia matriz
CREATE TRIGGER trg_validar_jerarquia_cliente
BEFORE INSERT ON ent_clientes
FOR EACH ROW
BEGIN
    IF NEW.id_cliente = NEW.id_matriz_fk THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Un cliente no puede ser su propia matriz';
    END IF;
END//

CREATE TRIGGER trg_validar_jerarquia_cliente_update
BEFORE UPDATE ON ent_clientes
FOR EACH ROW
BEGIN
    IF NEW.id_matriz_fk IS NOT NULL AND NEW.id_cliente = NEW.id_matriz_fk THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: Un cliente no puede ser su propia matriz';
    END IF;
END//

DELIMITER ;

-- =============================================================================
-- INDICES PARA OPTIMIZACION
-- =============================================================================

CREATE INDEX idx_clientes_matriz ON ent_clientes(id_matriz_fk);
CREATE INDEX idx_clientes_clasificacion ON ent_clientes(clasificacion);
CREATE INDEX idx_facturas_contrato ON fin_facturas(id_contrato_fk);
CREATE INDEX idx_facturas_fecha ON fin_facturas(fecha_emision);
CREATE INDEX idx_tarifas_servicio ON cat_tarifas(id_servicio_fk);
CREATE INDEX idx_tramites_factura ON adu_tramites(id_factura_fk);

-- =============================================================================
-- MENSAJE DE CONFIRMACION
-- =============================================================================

SELECT 'Base de datos orbita_comercial creada exitosamente - 16 tablas' AS mensaje;
