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
    id_region SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre_region VARCHAR(100) NOT NULL UNIQUE,
    descripcion TEXT,
    CONSTRAINT pk_geo_regiones PRIMARY KEY (id_region) 
) ENGINE=InnoDB;

-- Tabla 2: geo_monedas (debe crearse antes de geo_paises por la FK)
CREATE TABLE geo_monedas (
    codigo_iso_moneda CHAR(3) PRIMARY KEY,
    nombre_moneda VARCHAR(100) NOT NULL,
    simbolo_moneda VARCHAR(10),
    CONSTRAINT pk_geo_monedas PRIMARY KEY (codigo_iso_moneda),
    CONSTRAINT chk_codigo_moneda CHECK (codigo_iso_moneda REGEXP '^[A-Z]{3}$')
) ENGINE=InnoDB;

-- Tabla 3: geo_paises
CREATE TABLE geo_paises (
    codigo_iso_pais CHAR(2) PRIMARY KEY,
    nombre_pais VARCHAR(150) NOT NULL,
    id_region_fk SMALLINT,
    moneda_iso CHAR(3),
    iva_importacion_pct DECIMAL(5,2) DEFAULT 0.00,
    CONSTRAINT pk_geo_paises PRIMARY KEY (codigo_iso_pais),
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
    id_matriz SMALLINT AUTO_INCREMENT PRIMARY KEY,
    razon_social VARCHAR(200) NOT NULL,
    cif_nif VARCHAR(20) NOT NULL UNIQUE,
    codigo_pais_fk CHAR(2),
    CONSTRAINT pk_ent_matrices PRIMARY KEY (id_matriz),
    CONSTRAINT fk_matrices_pais FOREIGN KEY (codigo_pais_fk) 
        REFERENCES geo_paises(codigo_iso_pais),
    CONSTRAINT chk_cif_nif CHECK (cif_nif REGEXP '^[A-Z][0-9]{8}$')
) ENGINE=InnoDB;

-- Tabla 5: ent_clientes
CREATE TABLE ent_clientes (
    id_cliente SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre_comercial VARCHAR(200) NOT NULL,
    id_matriz_fk SMALLINT,
    id_agente_principal_fk SMALLINT,
    clasificacion ENUM('ESTANDAR', 'VIP', 'GUBERNAMENTAL') DEFAULT 'ESTANDAR',
    fecha_alta DATE NOT NULL,
    CONSTRAINT pk_ent_clientes PRIMARY KEY (id_cliente),
    CONSTRAINT fk_clientes_matriz FOREIGN KEY (id_matriz_fk) 
        REFERENCES ent_matrices(id_matriz),
    CONSTRAINT chk_jerarquia_cliente CHECK (id_cliente != id_matriz_fk)
) ENGINE=InnoDB;

-- Tabla 6: ent_contactos
CREATE TABLE ent_contactos (
    id_contacto SMALLINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente_fk SMALLINT NOT NULL,
    nombre_completo VARCHAR(150) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(30),
    es_principal_legal BOOLEAN DEFAULT FALSE,
    CONSTRAINT pk_ent_contactos PRIMARY KEY (id_contacto),
    CONSTRAINT fk_contactos_cliente FOREIGN KEY (id_cliente_fk) 
        REFERENCES ent_clientes(id_cliente) ON DELETE CASCADE
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: GESTION ADUANERA
-- =============================================================================

-- Tabla 7: adu_agentes
CREATE TABLE adu_agentes (
    id_agente SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre_agente VARCHAR(150) NOT NULL,
    num_licencia_federal VARCHAR(20) NOT NULL UNIQUE,
    id_cliente_empleador_fk SMALLINT,
    estado_homologacion ENUM('ACTIVO', 'SUSPENDIDO', 'RETIRADO') DEFAULT 'ACTIVO',
    CONSTRAINT pk_adu_agentes PRIMARY KEY (id_agente),
    CONSTRAINT fk_agentes_cliente FOREIGN KEY (id_cliente_empleador_fk) 
        REFERENCES ent_clientes(id_cliente),
    CONSTRAINT chk_licencia_federal CHECK (num_licencia_federal REGEXP '^FED-[0-9]{6}$')
) ENGINE=InnoDB;

-- Tabla 8: adu_delegaciones
CREATE TABLE adu_delegaciones (
    id_delegacion SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre_delegacion VARCHAR(150) NOT NULL,
    codigo_pais_fk CHAR(2),
    direccion_fisica TEXT,
    CONSTRAINT pk_adu_delegaciones PRIMARY KEY (id_delegacion),
    CONSTRAINT fk_delegaciones_pais FOREIGN KEY (codigo_pais_fk) 
        REFERENCES geo_paises(codigo_iso_pais)
) ENGINE=InnoDB;

-- =============================================================================
-- AREA: CATALOGO Y TARIFAS
-- =============================================================================

-- Tabla 9: cat_tipos_contenedor
CREATE TABLE cat_tipos_contenedor (
    id_tipo_cont SMALLINT AUTO_INCREMENT PRIMARY KEY,
    descripcion_tecnica VARCHAR(200) NOT NULL,
    peso_max_ton DECIMAL(8,3) NOT NULL,
    categoria_transporte ENUM('ESTANDAR', 'REFRIGERADO', 'PELIGROSOS', 'AEREO') DEFAULT 'ESTANDAR',
    volumen_m3 DECIMAL(10,3),
    CONSTRAINT pk_cat_tipos_contenedor PRIMARY KEY (id_tipo_cont),
    CONSTRAINT chk_peso_positivo CHECK (peso_max_ton > 0),
    CONSTRAINT chk_peso_aereo CHECK (
        (categoria_transporte != 'AEREO') OR 
        (categoria_transporte = 'AEREO' AND peso_max_ton <= 5.5)
    )
) ENGINE=InnoDB;

-- Tabla 10: cat_servicios
CREATE TABLE cat_servicios (
    id_servicio SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre_servicio VARCHAR(150) NOT NULL,
    descripcion_comercial TEXT,
    CONSTRAINT pk_cat_servicios PRIMARY KEY (id_servicio),
) ENGINE=InnoDB;

-- Tabla 11: cat_tarifas
CREATE TABLE cat_tarifas (
    id_tarifa SMALLINT AUTO_INCREMENT PRIMARY KEY,
    id_servicio_fk SMALLINT NOT NULL,
    id_tipo_cont_fk SMALLINT,
    precio_base DECIMAL(15,2) NOT NULL,
    moneda_iso_fk CHAR(3),
    vigencia_hasta DATE,
    CONSTRAINT pk_cat_tarifas PRIMARY KEY (id_tarifa),
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
    id_contrato SMALLINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente_fk SMALLINT NOT NULL,
    fecha_firma DATE NOT NULL,
    fecha_vencimiento DATE,
    estado_contrato ENUM('ACTIVO', 'EXPIRADO', 'REVISION') DEFAULT 'ACTIVO',
    CONSTRAINT pk_fin_contratos PRIMARY KEY (id_contrato),
    CONSTRAINT fk_contratos_cliente FOREIGN KEY (id_cliente_fk) 
        REFERENCES ent_clientes(id_cliente) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Tabla 13: fin_facturas
CREATE TABLE fin_facturas (
    id_factura SMALLINT AUTO_INCREMENT PRIMARY KEY,
    num_factura_serie VARCHAR(20) NOT NULL UNIQUE,
    id_contrato_fk SMALLINT,
    fecha_emision DATE NOT NULL,
    base_imponible DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    total_iva DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    total_factura DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    estado_pago ENUM('PENDIENTE', 'PAGADA', 'VENCIDA') DEFAULT 'PENDIENTE',
    CONSTRAINT pk_fin_facturas PRIMARY KEY (id_factura),
    CONSTRAINT fk_facturas_contrato FOREIGN KEY (id_contrato_fk) 
        REFERENCES fin_contratos(id_contrato) ON DELETE SET NULL,
    CONSTRAINT chk_fecha_emision CHECK (fecha_emision <= CURRENT_DATE),
    CONSTRAINT chk_num_factura CHECK (num_factura_serie REGEXP '^FAC-[0-9]{4}-[0-9]{5}$')
) ENGINE=InnoDB;

-- Tabla 14: adu_tramites (depende de fin_facturas)
CREATE TABLE adu_tramites (
    id_tramite SMALLINT AUTO_INCREMENT PRIMARY KEY,
    id_factura_fk SMALLINT,
    id_agente_fk SMALLINT,
    id_delegacion_fk SMALLINT,
    estado_tramite VARCHAR(50),
    CONSTRAINT pk_adu_tramites PRIMARY KEY (id_tramite),
    CONSTRAINT fk_tramites_factura FOREIGN KEY (id_factura_fk) 
        REFERENCES fin_facturas(id_factura),
    CONSTRAINT fk_tramites_agente FOREIGN KEY (id_agente_fk) 
        REFERENCES adu_agentes(id_agente),
    CONSTRAINT fk_tramites_delegacion FOREIGN KEY (id_delegacion_fk) 
        REFERENCES adu_delegaciones(id_delegacion)
) ENGINE=InnoDB;

-- Tabla 15: fin_lineas_factura
CREATE TABLE fin_lineas_factura (
    id_linea SMALLINT AUTO_INCREMENT PRIMARY KEY,
    id_factura_fk SMALLINT NOT NULL,
    descripcion_linea TEXT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    precio_unitario DECIMAL(15,2) NOT NULL,
    subtotal DECIMAL(15,2) NOT NULL,
    CONSTRAINT pk_fin_lineas_factura PRIMARY KEY (id_linea),
    CONSTRAINT fk_lineas_factura FOREIGN KEY (id_factura_fk) 
        REFERENCES fin_facturas(id_factura) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Tabla 16: fin_impuestos_especiales
CREATE TABLE fin_impuestos_especiales (
    id_impuesto SMALLINT AUTO_INCREMENT PRIMARY KEY,
    nombre_impuesto VARCHAR(100) NOT NULL,
    tasa_porcentaje DECIMAL(5,2) NOT NULL,
    codigo_pais_fk CHAR(2),
    CONSTRAINT pk_fin_impuestos_especiales PRIMARY KEY (id_impuesto),
    CONSTRAINT fk_impuestos_pais FOREIGN KEY (codigo_pais_fk) 
        REFERENCES geo_paises(codigo_iso_pais)
) ENGINE=InnoDB;

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
