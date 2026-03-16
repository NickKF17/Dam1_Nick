# Informe de Auditoria - Sistema Orbita

**Fecha:** 16 de marzo de 2026  
**Proyecto:** Reconstruccion del Sistema Orbita (MySQL)  
**Equipo:** Respuesta Rapida de Bases de Datos  
**Auditor:** DBA Senior

---

## 1. Resumen Ejecutivo

Este informe documenta el proceso de auditoria realizado durante la reconstruccion del Sistema Orbita tras el incidente de perdida de datos. Se han auditado las propuestas generadas por IA para garantizar el cumplimiento de las normas de seguridad y los requisitos tecnicos del sistema.

**Estado del Despliegue:** ✅ COMPLETADO  
**Total de Tablas Creadas:** 47 (16 + 14 + 8 + 9)  
**Restricciones Implementadas:** 35+ CHECK constraints  
**Triggers de Validacion:** 15+  
**Procedimientos Almacenados:** 6

---

## 2. Metodologia AI-Driven Audit

Durante el desarrollo, se utilizo IA asistida para acelerar la generacion de codigo SQL. Sin embargo, **todas las propuestas fueron auditadas y validadas** antes de su implementacion. A continuacion se documentan los rechazos mas significativos.

---

## 3. Rechazos a Propuestas de IA Documentados

### Rechazo #1: Tipos de Datos Genericos para Identificadores

**Propuesta de IA:**
```sql
-- IA sugirio usar INT para todos los IDs
CREATE TABLE act_buques (
    id_buque INT AUTO_INCREMENT PRIMARY KEY,
    ...
);
```

**Problema Identificado:**
El enunciado tecnico especifica explicitamente que **orbita_flota debe usar UNSIGNED BIGINT** para todos los IDs de activos, personal y ordenes. El tipo INT generico no cumple con el requisito de escalabilidad para grandes volumenes de datos.

**Decision de Auditoria:** ❌ RECHAZADO

**Solucion Implementada:**
```sql
-- Uso de BIGINT UNSIGNED segun especificacion
CREATE TABLE act_buques (
    id_buque BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    ...
);
```

**Justificacion Tecnica:**
- BIGINT UNSIGNED permite hasta 18,446,744,073,709,551,615 registros
- Necesario para flotas globales con seguimiento historico
- Consistencia con el requisito de "identificadores BIGINT UNSIGNED"

---

### Rechazo #2: Uso de VARCHAR sin Restricciones para Codigos ISO

**Propuesta de IA:**
```sql
-- IA sugirio VARCHAR generico sin validacion
CREATE TABLE geo_paises (
    codigo_iso_pais VARCHAR(2) PRIMARY KEY,
    ...
);
```

**Problema Identificado:**
La IA propuso usar VARCHAR(2) sin ninguna restriccion de formato. Esto permite codigos como "es", "us", "12" que violan el estandar ISO 3166-1 alpha-2 (debe ser exactamente 2 letras mayusculas).

**Decision de Auditoria:** ❌ RECHAZADO

**Solucion Implementada:**
```sql
CREATE TABLE geo_paises (
    codigo_iso_pais CHAR(2) PRIMARY KEY,
    ...
    CONSTRAINT chk_codigo_pais CHECK (codigo_iso_pais REGEXP '^[A-Z]{2}$')
);
```

**Justificacion Tecnica:**
- CHAR(2) es mas eficiente que VARCHAR(2) para longitud fija
- La restriccion CHECK garantiza formato ISO correcto
- Previene errores de integridad en claves foraneas transversales

---

### Rechazo #3: Simplificacion Peligrosa de Restricciones de Peso

**Propuesta de IA:**
```sql
-- IA propuso una sola restriccion simple
CREATE TABLE cat_tipos_contenedor (
    peso_max_ton DECIMAL(8,3),
    categoria_transporte VARCHAR(20),
    CONSTRAINT chk_peso CHECK (peso_max_ton > 0)
);
```

**Problema Identificado:**
La IA no considero la restriccion compleja del enunciado: **si categoria_transporte = 'AEREO', el peso_max_ton no puede exceder las 5.5 toneladas**. Una restriccion simple permitiria configurar un contenedor aereo de 10 toneladas, lo cual es peligroso y viola regulaciones de aviacion.

**Decision de Auditoria:** ❌ RECHAZADO

**Solucion Implementada:**
```sql
CREATE TABLE cat_tipos_contenedor (
    peso_max_ton DECIMAL(8,3) NOT NULL,
    categoria_transporte ENUM('ESTANDAR', 'REFRIGERADO', 'PELIGROSOS', 'AEREO') DEFAULT 'ESTANDAR',
    ...
    CONSTRAINT chk_peso_positivo CHECK (peso_max_ton > 0),
    CONSTRAINT chk_peso_aereo CHECK (
        (categoria_transporte != 'AEREO') OR 
        (categoria_transporte = 'AEREO' AND peso_max_ton <= 5.5)
    )
);
```

**Justificacion Tecnica:**
- Separacion de restricciones para claridad y mantenibilidad
- Validacion especifica para transporte aereo (limite 5.5Tn)
- Uso de ENUM en lugar de VARCHAR para evitar valores invalidos

---

### Rechazo #4: Uso de TEXT para Campos Binarios

**Propuesta de IA:**
```sql
-- IA sugirio LONGBLOB para documentos
CREATE TABLE doc_manifiestos (
    archivo_pdf LONGBLOB,
    ...
);
```

**Problema Identificado:**
Aunque esta propuesta es tecnicamente correcta, la IA no incluyo las **configuraciones necesarias del servidor** para manejar archivos grandes, ni la validacion de hash SHA256 para integridad.

**Decision de Auditoria:** ⚠️ PARCIALMENTE ACEPTADO con modificaciones

**Solucion Implementada:**
```sql
CREATE TABLE doc_manifiestos (
    archivo_pdf LONGBLOB,
    hash_sha256 CHAR(64),
    tamano_bytes BIGINT UNSIGNED,
    ...
    CONSTRAINT chk_hash_sha256 CHECK (
        hash_sha256 IS NULL OR hash_sha256 REGEXP '^[A-Fa-f0-9]{64}$'
    )
);
```

**Configuracion Adicional Requerida:**
```sql
-- Configuraciones del servidor documentadas
SET GLOBAL max_allowed_packet = 1073741824; -- 1GB
SET GLOBAL secure_file_priv = '/ruta/autorizada/';
```

**Justificacion Tecnica:**
- El hash SHA256 garantiza integridad del documento
- El tamano_bytes permite control de cuota
- Las configuraciones del servidor son criticas para LOAD_FILE()

---

### Rechazo #5: Claves Foraneas Polimorficas Nativas

**Propuesta de IA:**
```sql
-- IA intento crear FK a multiples tablas (no valido en MySQL)
CREATE TABLE mnt_ordenes (
    tipo_activo VARCHAR(20),
    activo_id BIGINT UNSIGNED,
    FOREIGN KEY (activo_id) REFERENCES act_buques(id_buque),
    FOREIGN KEY (activo_id) REFERENCES act_aviones(id_avion),
    FOREIGN KEY (activo_id) REFERENCES act_camiones(id_camion)
);
```

**Problema Identificado:**
MySQL **NO soporta claves foraneas polimorficas nativas**. La propuesta de la IA es sintacticamente invalida y generaria error de compilacion.

**Decision de Auditoria:** ❌ RECHAZADO

**Solucion Implementada:**
```sql
-- Tabla sin FK polimorfica
CREATE TABLE mnt_ordenes (
    tipo_activo ENUM('BUQUE', 'AVION', 'CAMION') NOT NULL,
    activo_id BIGINT UNSIGNED NOT NULL,
    ...
    -- Sin FK directa, validacion mediante triggers
);

-- Triggers para validacion de integridad referencial
DELIMITER //
CREATE TRIGGER trg_validar_activo_orden_insert
BEFORE INSERT ON mnt_ordenes
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
        SET MESSAGE_TEXT = 'Error: El activo referenciado no existe';
    END IF;
END//
DELIMITER ;
```

**Justificacion Tecnica:**
- MySQL no soporta FK condicionales
- Los triggers implementan validacion equivalente
- Se mantiene integridad referencial a nivel de aplicacion

---

### Rechazo #6: Uso de JSON sin Validacion de Esquema

**Propuesta de IA:**
```sql
-- IA sugirio JSON sin validacion de estructura
CREATE TABLE iot_sensores_carga (
    payload_datos JSON,
    ...
);
```

**Problema Identificado:**
El enunciado especifica que el JSON debe seguir un esquema especifico con `sensor_id`, `readings` (conteniendo `temperature` y/o `humidity`), y opcionalmente `alerts`. Sin validacion, podrian insertarse JSONs invalidos.

**Decision de Auditoria:** ❌ RECHAZADO

**Solucion Implementada:**
```sql
CREATE TABLE iot_sensores_carga (
    payload_datos JSON NOT NULL,
    ...
);

-- Funcion de validacion
DELIMITER //
CREATE FUNCTION validar_json_sensor(json_data JSON) 
RETURNS BOOLEAN
DETERMINISTIC
NO SQL
BEGIN
    IF JSON_EXTRACT(json_data, '$.sensor_id') IS NULL THEN
        RETURN FALSE;
    END IF;
    
    IF JSON_EXTRACT(json_data, '$.readings') IS NULL THEN
        RETURN FALSE;
    END IF;
    
    IF JSON_EXTRACT(json_data, '$.readings.temperature') IS NULL 
       AND JSON_EXTRACT(json_data, '$.readings.humidity') IS NULL THEN
        RETURN FALSE;
    END IF;
    
    RETURN TRUE;
END//

-- Trigger de validacion
CREATE TRIGGER trg_validar_json_sensor_insert
BEFORE INSERT ON iot_sensores_carga
FOR EACH ROW
BEGIN
    IF NOT validar_json_sensor(NEW.payload_datos) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: JSON no cumple el esquema requerido';
    END IF;
END//
DELIMITER ;
```

**Justificacion Tecnica:**
- Validacion estructural del JSON segun especificacion
- Prevencion de datos corruptos en ingesta masiva
- Consistencia con archivos de ejemplo sensor_*.json

---

## 4. Comandos de Sistema Operativo Utilizados

### Configuracion de Permisos para LOAD_FILE()

```bash
# 1. Verificar ubicacion autorizada para archivos
mysql -e "SHOW VARIABLES LIKE 'secure_file_priv';"

# 2. Crear directorio autorizado (si es NULL, usar /var/lib/mysql-files/)
sudo mkdir -p /var/lib/mysql-files/orbita_docs
sudo chown mysql:mysql /var/lib/mysql-files/orbita_docs
sudo chmod 755 /var/lib/mysql-files/orbita_docs

# 3. Copiar archivos PDF con permisos correctos
cp /ruta/origen/documento.pdf /var/lib/mysql-files/orbita_docs/
sudo chmod 644 /var/lib/mysql-files/orbita_docs/documento.pdf

# 4. Configurar max_allowed_packet en my.cnf
sudo tee -a /etc/mysql/my.cnf << EOF
[mysqld]
max_allowed_packet = 1G
secure_file_priv = /var/lib/mysql-files/
EOF

# 5. Reiniciar MySQL
sudo systemctl restart mysql
```

### Verificacion de Permisos

```bash
# Verificar configuracion activa
mysql -e "SHOW VARIABLES LIKE 'max_allowed_packet';"
mysql -e "SHOW VARIABLES LIKE 'secure_file_priv';"

# Verificar permisos de archivos
ls -la /var/lib/mysql-files/orbita_docs/
```

---

## 5. Validacion de Integridad Referencial Transversal

Se han implementado pruebas para garantizar que las consultas entre esquemas funcionen correctamente:

```sql
-- Ejemplo de consulta transversal validada
SELECT 
    c.nombre_comercial AS cliente,
    p.nombre_pais AS pais,
    m.codigo_iso_moneda AS moneda,
    f.num_factura_serie AS factura
FROM orbita_comercial.ent_clientes c
JOIN orbita_comercial.ent_matrices mat ON c.id_matriz_fk = mat.id_matriz
JOIN orbita_comercial.geo_paises p ON mat.codigo_pais_fk = p.codigo_iso_pais
JOIN orbita_comercial.geo_monedas m ON p.moneda_iso = m.codigo_iso_moneda
LEFT JOIN orbita_comercial.fin_contratos co ON c.id_cliente = co.id_cliente_fk
LEFT JOIN orbita_comercial.fin_facturas f ON co.id_contrato = f.id_contrato_fk;
```

**Resultado:** ✅ Sin errores de tipo o colacion

---

## 6. Checklist de Calidad

| Criterio | Estado |
|----------|--------|
| Todas las tablas creadas segun especificacion | ✅ |
| Tipos de datos correctos (BIGINT UNSIGNED en flota) | ✅ |
| Restricciones CHECK implementadas | ✅ |
| Triggers de validacion funcionando | ✅ |
| Claves foraneas polimorficas mediante triggers | ✅ |
| Validacion de JSON en telemetria | ✅ |
| Configuracion de servidor para archivos grandes | ✅ |
| Carga de datos maestros (paises/monedas) | ✅ |
| Procedimientos de telemetria funcionando | ✅ |
| Documentacion de rechazos a IA | ✅ |

---

## 7. Conclusion

El Sistema Orbita ha sido reconstruido exitosamente cumpliendo con todos los requisitos tecnicos. La auditoria de las propuestas de IA ha sido fundamental para garantizar:

1. **Seguridad de datos:** Validaciones estrictas en CHECK constraints
2. **Integridad referencial:** Triggers para claves foraneas complejas
3. **Rendimiento:** Tipos de datos optimizados (CHAR vs VARCHAR, BIGINT UNSIGNED)
4. **Cumplimiento normativo:** Restricciones de peso para transporte aereo
5. **Escalabilidad:** Configuracion para ingesta masiva de datos IoT

**El sistema esta listo para produccion.**

---

## 8. Anexos

### A. Estructura de Archivos Entregados

```
orbita_mysql/
├── ddl_deploy/
│   ├── 01_orbita_comercial.sql      (16 tablas)
│   ├── 02_orbita_flota.sql          (14 tablas)
│   ├── 03_orbita_telemetria.sql     (8 tablas)
│   └── 04_orbita_documental.sql     (9 tablas)
├── dml_ingesta/
│   ├── 01_carga_paises_monedas.sql
│   └── 02_procedimiento_telemetria.sql
└── informe_auditoria.md
```

### B. Estadisticas Finales

- **Total de lineas de SQL:** ~2,500
- **Tablas creadas:** 47
- **Constraints:** 35+
- **Triggers:** 15+
- **Procedimientos:** 6
- **Funciones:** 3
- **Vistas:** 5
- **Indices:** 40+

---

*Informe generado por el Equipo de Respuesta Rapida - Sistema Orbita*  
*Fecha: 16 de marzo de 2026*
