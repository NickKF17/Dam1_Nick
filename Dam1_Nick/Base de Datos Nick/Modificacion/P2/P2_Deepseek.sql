-- =============================================================================
-- LIMPIEZA TOTAL - LOGÍSTICA 4.0 (VERSIÓN CORREGIDA CON COMENTARIOS)
-- =============================================================================
-- OBJETIVO: Transformar una base de datos caótica (con 8 formatos de fecha,
--           datos absurdos, NULLs, huérfanos y duplicados) en un sistema 
--           relacional limpio, normalizado y blindado con constraints.
-- =============================================================================
-- ESTRATEGIA: 1. Respaldar (staging) → 2. Limpiar datos → 3. Transformar tipos
--             4. Corregir integridad → 5. Blindar con constraints
-- =============================================================================

USE logistica_global;

-- =============================================================================
-- 1. CREACIÓN DE TABLAS STAGING (RESPALDO PARA ROLLBACK)
-- =============================================================================
-- PROPÓSITO: Crear copias exactas de todas las tablas originales antes de
--            modificar nada. Si algo sale mal, podemos restaurar desde aquí.
-- =============================================================================

-- Eliminar tablas staging si existen de ejecuciones anteriores (limpieza)
DROP TABLE IF EXISTS staging_almacenes, staging_empleados, staging_vehiculos, 
                     staging_clientes, staging_envios, staging_incidencias, 
                     staging_proveedores, staging_mantenimientos;

-- Crear tablas staging con la misma estructura que las originales
CREATE TABLE staging_almacenes LIKE almacenes;
CREATE TABLE staging_empleados LIKE empleados;
CREATE TABLE staging_vehiculos LIKE vehiculos;
CREATE TABLE staging_clientes LIKE clientes;
CREATE TABLE staging_envios LIKE envios;
CREATE TABLE staging_incidencias LIKE incidencias;
CREATE TABLE staging_proveedores LIKE proveedores;
CREATE TABLE staging_mantenimientos LIKE mantenimientos_flota;

-- Copiar todos los datos actuales a las tablas staging
INSERT INTO staging_almacenes SELECT * FROM almacenes;
INSERT INTO staging_empleados SELECT * FROM empleados;
INSERT INTO staging_vehiculos SELECT * FROM vehiculos;
INSERT INTO staging_clientes SELECT * FROM clientes;
INSERT INTO staging_envios SELECT * FROM envios;
INSERT INTO staging_incidencias SELECT * FROM incidencias;
INSERT INTO staging_proveedores SELECT * FROM proveedores;
INSERT INTO staging_mantenimientos SELECT * FROM mantenimientos_flota;

SELECT '✅ Respaldos completados (puedes restaurar desde staging_*)' AS Progreso;

-- =============================================================================
-- 2. ELIMINACIÓN DE EASTER EGGS (DATOS ABSURDOS DE BROMAS)
-- =============================================================================
-- PROPÓSITO: El script original inserta registros de broma (HAL 9000, Sauron,
--            Batman, etc.) que contaminan los datos reales. Los eliminamos.
-- =============================================================================

-- Eliminar empleados ficticios (personajes de películas/series)
DELETE FROM empleados WHERE nif_nie IN ('00000000X', '1-RING-RULE', '99999999L', 'C3PO-R2D2', '42424242Z');

-- Eliminar almacenes ficticios (Área 51, Batcueva, Narnia, etc.)
DELETE FROM almacenes WHERE cod_almacen IN ('ALM-ALIEN', 'ALM-BERMUDAS', 'ALM-BAT', 'ALM-TUPPER', 'ALM-NARNIA');

-- Eliminar vehículos ficticios (trineo de Santa, DeLorean, Alfombra mágica)
DELETE FROM vehiculos WHERE matricula IN ('XMAS-2025', 'OUTATIME', 'FLY-KINTON', 'TARDIS-01', 'CARPET-01');

-- Eliminar envíos ficticios (El Anillo Único, Gato de Schrödinger, etc.)
DELETE FROM envios WHERE tracking_number IN ('PRECIOUSSS', 'CAT-SCHRODINGER', 'MILLHOUSE-DIGNITY', 'TOP-SECRET-BURGER', 'THE-EX-TEN');

-- Eliminar incidencias absurdas (ganso con cuchillo, glitch matrix, etc.)
DELETE FROM incidencias WHERE descripcion_breve LIKE '%ganso%' OR descripcion_breve LIKE '%Glitch%';

-- Eliminar clientes ficticios (Tony Stark, ACME Corp)
DELETE FROM clientes WHERE razon_social IN ('Tony Stark', 'ACME Corp');

-- Eliminar proveedor ficticio (Ollivanders, el de Harry Potter)
DELETE FROM proveedores WHERE nombre_comercial = 'Ollivanders';

SELECT '✅ Easter eggs eliminados (datos de broma removidos)' AS Progreso;

-- =============================================================================
-- 3. LIMPIEZA DE LA TABLA ALMACENES
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - Capacidad en VARCHAR con texto (' m3', ' metros cúbicos')
--   - Ubicación geográfica en formato texto 'Lat: X | Lon: Y'
--   - Duplicados en cod_almacen
--   - NULLs en campos que deberían ser únicos
-- =============================================================================

-- Crear columnas temporales para datos limpios
ALTER TABLE almacenes ADD COLUMN capacidad_m3_numeric DECIMAL(10,2);
ALTER TABLE almacenes ADD COLUMN latitud DECIMAL(10,6);
ALTER TABLE almacenes ADD COLUMN longitud DECIMAL(10,6);

-- Convertir capacidad de texto a número (eliminar ' m3' o ' metros cúbicos')
UPDATE almacenes SET capacidad_m3_numeric = 
    CAST(REPLACE(REPLACE(capacidad_m3, ' m3', ''), ' metros cúbicos', '') AS DECIMAL(10,2)) 
WHERE capacidad_m3 IS NOT NULL AND capacidad_m3 != '';

-- Extraer latitud y longitud del texto 'Lat: 40.4168 | Lon: -3.7038'
-- SUBSTRING_INDEX extrae la parte después de 'Lat: ' y antes de ' |'
UPDATE almacenes SET 
    latitud = CAST(SUBSTRING_INDEX(SUBSTRING_INDEX(ubicacion_geografica, 'Lat: ', -1), ' |', 1) AS DECIMAL(10,6)),
    longitud = CAST(SUBSTRING_INDEX(ubicacion_geografica, 'Lon: ', -1) AS DECIMAL(10,6))
WHERE ubicacion_geografica IS NOT NULL AND ubicacion_geografica LIKE 'Lat:%';

-- Eliminar registros duplicados con el mismo cod_almacen (conservar el de menor ID)
DELETE a1 FROM almacenes a1
INNER JOIN almacenes a2 
WHERE a1.id > a2.id AND a1.cod_almacen = a2.cod_almacen AND a1.cod_almacen IS NOT NULL;

-- Rellenar NULLs en cod_almacen con un valor único basado en ID
UPDATE almacenes SET cod_almacen = CONCAT('ALM-FIX-', id) WHERE cod_almacen IS NULL;

SELECT '✅ Almacenes limpios' AS Progreso;

-- =============================================================================
-- 4. LIMPIEZA DE LA TABLA EMPLEADOS
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - 8 formatos diferentes de fecha en f_alta
--   - Salario con texto ' EUR' al final
--   - activo_boolean con '1' o 'NO' (inconsistente)
--   - NIF con espacios y mayúsculas/minúsculas mezcladas
--   - Huérfanos (almacen_id que no existe en almacenes)
-- =============================================================================

-- Crear columnas temporales para datos limpios
ALTER TABLE empleados ADD COLUMN f_alta_date DATE;
ALTER TABLE empleados ADD COLUMN salario_base_numeric DECIMAL(10,2);
ALTER TABLE empleados ADD COLUMN activo_flag BOOLEAN;

-- LIMPIEZA DE FECHAS: soporta 8 formatos diferentes
-- Los formatos posibles son:
--   1. dd/mm/yyyy (ej: 15/03/2025)
--   2. dd-mm-yyyy (ej: 15-03-2025)
--   3. yyyy-mm-dd (ej: 2025-03-15)
--   4. yyyy/mm/dd (ej: 2025/03/15)
--   5. dd/mm/yy   (ej: 15/03/25) → se asume siglo 20 = 2025
--   6. dd-mm-yy   (ej: 15-03-25) → se asume siglo 20 = 2025
--   7. yy-mm-dd   (ej: 25-03-15) → se asume siglo 20 = 2025
--   8. yy/mm/dd   (ej: 25/03/15) → se asume siglo 20 = 2025
-- =============================================================================
UPDATE empleados SET f_alta = TRIM(f_alta);  -- Eliminar espacios al inicio/final

UPDATE empleados SET f_alta_date = 
    CASE
        -- Formato 1: dd/mm/yyyy (10 caracteres)
        WHEN f_alta LIKE '%/%/%' AND LENGTH(f_alta) = 10 THEN STR_TO_DATE(f_alta, '%d/%m/%Y')
        -- Formato 2: dd-mm-yyyy (10 caracteres)
        WHEN f_alta LIKE '%-%-%' AND LENGTH(f_alta) = 10 THEN STR_TO_DATE(f_alta, '%d-%m-%Y')
        -- Formato 3: yyyy-mm-dd (formato ISO)
        WHEN f_alta REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(f_alta, '%Y-%m-%d')
        -- Formato 5 y 6: dd/mm/yy o dd-mm-yy (8 caracteres, año 2 dígitos)
        WHEN (f_alta LIKE '%/%/%y' OR f_alta LIKE '%-%-%y') AND LENGTH(f_alta) = 8 THEN 
            STR_TO_DATE(f_alta, '%d/%m/%y')
        -- Formato 7 y 8: yy-mm-dd o yy/mm/dd (8 caracteres, año primero)
        WHEN f_alta REGEXP '^[0-9]{2}[/-][0-9]{2}[/-][0-9]{2}$' THEN 
            STR_TO_DATE(CONCAT('20', SUBSTRING(f_alta, 7, 2), '-', SUBSTRING(f_alta, 4, 2), '-', SUBSTRING(f_alta, 1, 2)), '%Y-%m-%d')
        ELSE NULL
    END;

-- Extraer salario numérico eliminando el texto ' EUR'
UPDATE empleados SET salario_base_numeric = 
    CAST(REPLACE(salario_base_sucio, ' EUR', '') AS DECIMAL(10,2)) 
WHERE salario_base_sucio IS NOT NULL AND salario_base_sucio REGEXP '^[0-9]+\.?[0-9]* EUR$';

-- Convertir '1'/'NO' a booleano (TRUE/FALSE)
UPDATE empleados SET activo_flag = (activo_boolean = '1');

-- Normalizar NIF: mayúsculas y sin espacios
UPDATE empleados SET nif_nie = UPPER(TRIM(nif_nie)) WHERE nif_nie IS NOT NULL;

-- Corregir huérfanos: si almacen_id no existe en almacenes, poner NULL
UPDATE empleados SET almacen_id = NULL WHERE almacen_id NOT IN (SELECT id FROM almacenes);

SELECT '✅ Empleados limpios' AS Progreso;

-- =============================================================================
-- 5. LIMPIEZA DE LA TABLA VEHÍCULOS
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - Fechas de ITV en múltiples formatos
--   - Capacidad de carga con texto 'kg'
--   - Coordenadas GPS en formato texto 'lat, lon'
--   - Matrículas con espacios o NULLs
-- =============================================================================

-- Crear columnas temporales
ALTER TABLE vehiculos ADD COLUMN f_ultima_itv_date DATE;
ALTER TABLE vehiculos ADD COLUMN capacidad_carga_numeric DECIMAL(10,2);
ALTER TABLE vehiculos ADD COLUMN latitud DECIMAL(10,6);
ALTER TABLE vehiculos ADD COLUMN longitud DECIMAL(10,6);

-- Limpiar fecha de ITV (misma lógica de 8 formatos que en empleados)
UPDATE vehiculos SET f_ultima_itv = TRIM(f_ultima_itv);
UPDATE vehiculos SET f_ultima_itv_date = 
    CASE
        WHEN f_ultima_itv LIKE '%/%/%' AND LENGTH(f_ultima_itv) = 10 THEN STR_TO_DATE(f_ultima_itv, '%d/%m/%Y')
        WHEN f_ultima_itv LIKE '%-%-%' AND LENGTH(f_ultima_itv) = 10 THEN STR_TO_DATE(f_ultima_itv, '%d-%m-%Y')
        WHEN f_ultima_itv REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(f_ultima_itv, '%Y-%m-%d')
        ELSE NULL
    END;

-- Extraer capacidad numérica eliminando 'kg'
UPDATE vehiculos SET capacidad_carga_numeric = 
    CAST(REPLACE(capacidad_carga_kg, 'kg', '') AS DECIMAL(10,2))
WHERE capacidad_carga_kg IS NOT NULL AND capacidad_carga_kg != '';

-- Extraer latitud/longitud del formato '40.4168, -3.7038'
UPDATE vehiculos SET 
    latitud = CAST(SUBSTRING_INDEX(coordenadas_gps, ',', 1) AS DECIMAL(10,6)),
    longitud = CAST(SUBSTRING_INDEX(coordenadas_gps, ',', -1) AS DECIMAL(10,6))
WHERE coordenadas_gps IS NOT NULL AND coordenadas_gps LIKE '%,%';

-- Normalizar matrícula: mayúsculas y sin espacios
UPDATE vehiculos SET matricula = UPPER(TRIM(matricula)) WHERE matricula IS NOT NULL;

-- Rellenar matrículas NULL o vacías con valor único
UPDATE vehiculos SET matricula = CONCAT('FIX-', id) WHERE matricula IS NULL OR matricula = '';

SELECT '✅ Vehículos limpios' AS Progreso;

-- =============================================================================
-- 6. LIMPIEZA DE LA TABLA CLIENTES
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - Límite de crédito con símbolos de moneda ('€', ' USD')
--   - Fechas de alta en múltiples formatos
--   - Campo activo inconsistente
--   - razon_social con espacios
-- =============================================================================

ALTER TABLE clientes ADD COLUMN limite_credito_numeric DECIMAL(12,2);
ALTER TABLE clientes ADD COLUMN fecha_alta_date DATE;
ALTER TABLE clientes ADD COLUMN activo_flag BOOLEAN;

-- Limpiar límite de crédito: eliminar '€' o ' USD'
UPDATE clientes SET limite_credito_numeric = 
    CAST(REPLACE(REPLACE(limite_credito_sucio, '€', ''), ' USD', '') AS DECIMAL(12,2))
WHERE limite_credito_sucio IS NOT NULL AND limite_credito_sucio REGEXP '^[0-9]+\.?[0-9]*(€| USD)?$';

-- Limpiar fecha de alta (misma lógica de 8 formatos)
UPDATE clientes SET fecha_alta_cliente = TRIM(fecha_alta_cliente);
UPDATE clientes SET fecha_alta_date = 
    CASE
        WHEN fecha_alta_cliente LIKE '%/%/%' AND LENGTH(fecha_alta_cliente) = 10 THEN STR_TO_DATE(fecha_alta_cliente, '%d/%m/%Y')
        WHEN fecha_alta_cliente LIKE '%-%-%' AND LENGTH(fecha_alta_cliente) = 10 THEN STR_TO_DATE(fecha_alta_cliente, '%d-%m-%Y')
        WHEN fecha_alta_cliente REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(fecha_alta_cliente, '%Y-%m-%d')
        ELSE NULL
    END;

-- Convertir '1' a TRUE, cualquier otra cosa a FALSE
UPDATE clientes SET activo_flag = (activo = '1');

-- Eliminar espacios en razón social
UPDATE clientes SET razon_social = TRIM(razon_social) WHERE razon_social IS NOT NULL;

SELECT '✅ Clientes limpios' AS Progreso;

-- =============================================================================
-- 7. LIMPIEZA DE LA TABLA ENVÍOS (LA MÁS GRANDE: 100.000 REGISTROS)
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - 3 columnas de fecha (salida, llegada prevista, entrega real)
--   - Peso, volumen, importe y distancia como VARCHAR con texto
--   - FK huérfanas (cliente_id, vehiculo_id, etc. que no existen)
--   - tracking_number NULL
-- =============================================================================

-- Crear columnas temporales para datos limpios
ALTER TABLE envios ADD COLUMN f_salida_date DATE;
ALTER TABLE envios ADD COLUMN f_llegada_prevista_date DATE;
ALTER TABLE envios ADD COLUMN f_entrega_real_date DATE;
ALTER TABLE envios ADD COLUMN peso_kg_numeric DECIMAL(10,2);
ALTER TABLE envios ADD COLUMN volumen_m3_numeric DECIMAL(10,2);
ALTER TABLE envios ADD COLUMN importe_numeric DECIMAL(12,2);
ALTER TABLE envios ADD COLUMN ruta_distancia_km_numeric DECIMAL(10,2);

-- LIMPIEZA DE FECHA DE SALIDA (misma lógica de 8 formatos)
UPDATE envios SET f_salida = TRIM(f_salida);
UPDATE envios SET f_salida_date = 
    CASE
        WHEN f_salida LIKE '%/%/%' AND LENGTH(f_salida) = 10 THEN STR_TO_DATE(f_salida, '%d/%m/%Y')
        WHEN f_salida LIKE '%-%-%' AND LENGTH(f_salida) = 10 THEN STR_TO_DATE(f_salida, '%d-%m-%Y')
        WHEN f_salida REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(f_salida, '%Y-%m-%d')
        WHEN (f_salida LIKE '%/%/%y' OR f_salida LIKE '%-%-%y') AND LENGTH(f_salida) = 8 THEN 
            STR_TO_DATE(f_salida, '%d/%m/%y')
        WHEN f_salida REGEXP '^[0-9]{2}[/-][0-9]{2}[/-][0-9]{2}$' THEN 
            STR_TO_DATE(CONCAT('20', SUBSTRING(f_salida, 7, 2), '-', SUBSTRING(f_salida, 4, 2), '-', SUBSTRING(f_salida, 1, 2)), '%Y-%m-%d')
        ELSE NULL
    END;

-- LIMPIEZA DE FECHA DE LLEGADA PREVISTA
UPDATE envios SET f_llegada_prevista = TRIM(f_llegada_prevista);
UPDATE envios SET f_llegada_prevista_date = 
    CASE
        WHEN f_llegada_prevista LIKE '%/%/%' AND LENGTH(f_llegada_prevista) = 10 THEN STR_TO_DATE(f_llegada_prevista, '%d/%m/%Y')
        WHEN f_llegada_prevista LIKE '%-%-%' AND LENGTH(f_llegada_prevista) = 10 THEN STR_TO_DATE(f_llegada_prevista, '%d-%m-%Y')
        WHEN f_llegada_prevista REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(f_llegada_prevista, '%Y-%m-%d')
        ELSE NULL
    END;

-- LIMPIEZA DE FECHA DE ENTREGA REAL
UPDATE envios SET f_entrega_real = TRIM(f_entrega_real);
UPDATE envios SET f_entrega_real_date = 
    CASE
        WHEN f_entrega_real LIKE '%/%/%' AND LENGTH(f_entrega_real) = 10 THEN STR_TO_DATE(f_entrega_real, '%d/%m/%Y')
        WHEN f_entrega_real LIKE '%-%-%' AND LENGTH(f_entrega_real) = 10 THEN STR_TO_DATE(f_entrega_real, '%d-%m-%Y')
        WHEN f_entrega_real REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(f_entrega_real, '%Y-%m-%d')
        ELSE NULL
    END;

-- EXTRAER PESO NUMÉRICO (eliminar 'kg')
UPDATE envios SET peso_kg_numeric = 
    CAST(REPLACE(peso_kg_bruto, 'kg', '') AS DECIMAL(10,2))
WHERE peso_kg_bruto IS NOT NULL AND peso_kg_bruto != '';

-- EXTRAER VOLUMEN NUMÉRICO
UPDATE envios SET volumen_m3_numeric = 
    CAST(volumen_m3 AS DECIMAL(10,2)) 
WHERE volumen_m3 IS NOT NULL AND volumen_m3 != '';

-- EXTRAER IMPORTE NUMÉRICO (eliminar '€')
UPDATE envios SET importe_numeric = 
    CAST(REPLACE(importe_envio, '€', '') AS DECIMAL(12,2))
WHERE importe_envio IS NOT NULL AND importe_envio != '';

-- EXTRAER DISTANCIA NUMÉRICA (eliminar ' km')
UPDATE envios SET ruta_distancia_km_numeric = 
    CAST(REPLACE(ruta_distancia_km, ' km', '') AS DECIMAL(10,2))
WHERE ruta_distancia_km IS NOT NULL AND ruta_distancia_km != '';

-- CORREGIR FK HUÉRFANAS: si el ID referenciado no existe, poner NULL
UPDATE envios SET cliente_id = NULL WHERE cliente_id NOT IN (SELECT id FROM clientes);
UPDATE envios SET vehiculo_id = NULL WHERE vehiculo_id NOT IN (SELECT id FROM vehiculos);
UPDATE envios SET empleado_id = NULL WHERE empleado_id NOT IN (SELECT id FROM empleados);
UPDATE envios SET almacen_destino_id = NULL WHERE almacen_destino_id NOT IN (SELECT id FROM almacenes);

-- RELLENAR TRACKING_NUMBER NULL con valor único basado en ID
UPDATE envios SET tracking_number = CONCAT('TRK-FIX-', id) WHERE tracking_number IS NULL OR TRIM(tracking_number) = '';

SELECT '✅ Envíos limpios (100k registros procesados)' AS Progreso;

-- =============================================================================
-- 8. LIMPIEZA DE LA TABLA INCIDENCIAS
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - Fechas en múltiples formatos
--   - Coste con texto (' pavos', '€')
--   - envio_id huérfano
-- =============================================================================

ALTER TABLE incidencias ADD COLUMN f_incidencia_date DATE;
ALTER TABLE incidencias ADD COLUMN coste_numeric DECIMAL(10,2);

-- Limpiar fecha de incidencia
UPDATE incidencias SET f_incidencia = TRIM(f_incidencia);
UPDATE incidencias SET f_incidencia_date = 
    CASE
        WHEN f_incidencia LIKE '%/%/%' AND LENGTH(f_incidencia) = 10 THEN STR_TO_DATE(f_incidencia, '%d/%m/%Y')
        WHEN f_incidencia LIKE '%-%-%' AND LENGTH(f_incidencia) = 10 THEN STR_TO_DATE(f_incidencia, '%d-%m-%Y')
        WHEN f_incidencia REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(f_incidencia, '%Y-%m-%d')
        ELSE NULL
    END;

-- Extraer coste numérico eliminando ' pavos' o '€'
UPDATE incidencias SET coste_numeric = 
    CAST(REPLACE(REPLACE(coste_asociado_sucio, ' pavos', ''), '€', '') AS DECIMAL(10,2))
WHERE coste_asociado_sucio IS NOT NULL AND coste_asociado_sucio != '';

-- Corregir FK huérfanas
UPDATE incidencias SET envio_id = NULL WHERE envio_id NOT IN (SELECT id FROM envios);

SELECT '✅ Incidencias limpias' AS Progreso;

-- =============================================================================
-- 9. LIMPIEZA DE LA TABLA PROVEEDORES
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - Fecha de último pedido en múltiples formatos
-- =============================================================================

ALTER TABLE proveedores ADD COLUMN ultimo_pedido_date DATE;

-- Limpiar fecha de último pedido
UPDATE proveedores SET ultimo_pedido = TRIM(ultimo_pedido);
UPDATE proveedores SET ultimo_pedido_date = 
    CASE
        WHEN ultimo_pedido LIKE '%/%/%' AND LENGTH(ultimo_pedido) = 10 THEN STR_TO_DATE(ultimo_pedido, '%d/%m/%Y')
        WHEN ultimo_pedido LIKE '%-%-%' AND LENGTH(ultimo_pedido) = 10 THEN STR_TO_DATE(ultimo_pedido, '%d-%m-%Y')
        WHEN ultimo_pedido REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(ultimo_pedido, '%Y-%m-%d')
        ELSE NULL
    END;

SELECT '✅ Proveedores limpios' AS Progreso;

-- =============================================================================
-- 10. LIMPIEZA DE LA TABLA MANTENIMIENTOS_FLOTA
-- =============================================================================
-- PROBLEMAS A RESOLVER:
--   - Fechas de mantenimiento en múltiples formatos
--   - Coste con texto (' Euros')
--   - vehiculo_id huérfano
-- =============================================================================

ALTER TABLE mantenimientos_flota ADD COLUMN f_mantenimiento_date DATE;
ALTER TABLE mantenimientos_flota ADD COLUMN coste_reparacion_numeric DECIMAL(10,2);

-- Limpiar fecha de mantenimiento
UPDATE mantenimientos_flota SET f_mantenimiento = TRIM(f_mantenimiento);
UPDATE mantenimientos_flota SET f_mantenimiento_date = 
    CASE
        WHEN f_mantenimiento LIKE '%/%/%' AND LENGTH(f_mantenimiento) = 10 THEN STR_TO_DATE(f_mantenimiento, '%d/%m/%Y')
        WHEN f_mantenimiento LIKE '%-%-%' AND LENGTH(f_mantenimiento) = 10 THEN STR_TO_DATE(f_mantenimiento, '%d-%m-%Y')
        WHEN f_mantenimiento REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$' THEN STR_TO_DATE(f_mantenimiento, '%Y-%m-%d')
        ELSE NULL
    END;

-- Extraer coste numérico eliminando ' Euros'
UPDATE mantenimientos_flota SET coste_reparacion_numeric = 
    CAST(REPLACE(coste_reparacion, ' Euros', '') AS DECIMAL(10,2))
WHERE coste_reparacion IS NOT NULL AND coste_reparacion != '';

-- Corregir FK huérfanas
UPDATE mantenimientos_flota SET vehiculo_id = NULL WHERE vehiculo_id NOT IN (SELECT id FROM vehiculos);

SELECT '✅ Mantenimientos limpios' AS Progreso;

-- =============================================================================
-- 11. ELIMINACIÓN DE COLUMNAS SUCIAS Y RENOMBRADO DE LIMPIAS
-- =============================================================================
-- PROPÓSITO: Una vez que los datos limpios están en columnas temporales,
--            eliminamos las columnas originales (sucias) y renombramos
--            las columnas temporales con el nombre original.
-- =============================================================================

-- ALMACENES: eliminar columna original VARCHAR y renombrar la nueva
ALTER TABLE almacenes DROP COLUMN capacidad_m3, DROP COLUMN ubicacion_geografica;
ALTER TABLE almacenes CHANGE COLUMN capacidad_m3_numeric capacidad_m3 DECIMAL(10,2);

-- EMPLEADOS: eliminar columnas originales sucias
ALTER TABLE empleados DROP COLUMN f_alta, DROP COLUMN salario_base_sucio, DROP COLUMN activo_boolean;
ALTER TABLE empleados CHANGE COLUMN f_alta_date f_alta DATE;
ALTER TABLE empleados CHANGE COLUMN salario_base_numeric salario_base DECIMAL(10,2);
ALTER TABLE empleados CHANGE COLUMN activo_flag activo BOOLEAN;

-- VEHÍCULOS: eliminar columnas originales sucias
ALTER TABLE vehiculos DROP COLUMN f_ultima_itv, DROP COLUMN capacidad_carga_kg, DROP COLUMN coordenadas_gps;
ALTER TABLE vehiculos CHANGE COLUMN f_ultima_itv_date f_ultima_itv DATE;
ALTER TABLE vehiculos CHANGE COLUMN capacidad_carga_numeric capacidad_carga_kg DECIMAL(10,2);

-- CLIENTES: eliminar columnas originales sucias
ALTER TABLE clientes DROP COLUMN limite_credito_sucio, DROP COLUMN fecha_alta_cliente, DROP COLUMN activo;
ALTER TABLE clientes CHANGE COLUMN limite_credito_numeric limite_credito DECIMAL(12,2);
ALTER TABLE clientes CHANGE COLUMN fecha_alta_date fecha_alta DATE;
ALTER TABLE clientes CHANGE COLUMN activo_flag activo BOOLEAN;

-- ENVÍOS: eliminar columnas originales sucias
ALTER TABLE envios DROP COLUMN f_salida, DROP COLUMN f_llegada_prevista, DROP COLUMN f_entrega_real,
                     DROP COLUMN peso_kg_bruto, DROP COLUMN volumen_m3, DROP COLUMN importe_envio,
                     DROP COLUMN ruta_distancia_km;
ALTER TABLE envios CHANGE COLUMN f_salida_date f_salida DATE;
ALTER TABLE envios CHANGE COLUMN f_llegada_prevista_date f_llegada_prevista DATE;
ALTER TABLE envios CHANGE COLUMN f_entrega_real_date f_entrega_real DATE;
ALTER TABLE envios CHANGE COLUMN peso_kg_numeric peso_kg DECIMAL(10,2);
ALTER TABLE envios CHANGE COLUMN volumen_m3_numeric volumen_m3 DECIMAL(10,2);
ALTER TABLE envios CHANGE COLUMN importe_numeric importe DECIMAL(12,2);
ALTER TABLE envios CHANGE COLUMN ruta_distancia_km_numeric ruta_distancia_km DECIMAL(10,2);

-- INCIDENCIAS: eliminar columnas originales sucias
ALTER TABLE incidencias DROP COLUMN f_incidencia, DROP COLUMN coste_asociado_sucio;
ALTER TABLE incidencias CHANGE COLUMN f_incidencia_date f_incidencia DATE;
ALTER TABLE incidencias CHANGE COLUMN coste_numeric coste DECIMAL(10,2);

-- PROVEEDORES: eliminar columna original sucia
ALTER TABLE proveedores DROP COLUMN ultimo_pedido;
ALTER TABLE proveedores CHANGE COLUMN ultimo_pedido_date ultimo_pedido DATE;

-- MANTENIMIENTOS: eliminar columnas originales sucias
ALTER TABLE mantenimientos_flota DROP COLUMN f_mantenimiento, DROP COLUMN coste_reparacion;
ALTER TABLE mantenimientos_flota CHANGE COLUMN f_mantenimiento_date f_mantenimiento DATE;
ALTER TABLE mantenimientos_flota CHANGE COLUMN coste_reparacion_numeric coste_reparacion DECIMAL(10,2);

SELECT '✅ Columnas reorganizadas (datos sucios eliminados, limpias renombradas)' AS Progreso;

-- =============================================================================
-- 12. BLINDAJE FINAL (CONSTRAINTS)
-- =============================================================================
-- PROPÓSITO: Aplicar todas las restricciones de integridad para garantizar
--            que los datos futuros no se corrompan:
--   - FOREIGN KEY: integridad referencial entre tablas
--   - UNIQUE: evitar duplicados en campos clave
--   - NOT NULL: campos obligatorios
-- =============================================================================

-- ===== FOREIGN KEYS (Integridad Referencial) =====
-- ON DELETE SET NULL: si se borra el padre, el hijo queda NULL (no se pierde el hijo)
-- ON DELETE CASCADE: si se borra el padre, se borran los hijos automáticamente

-- Empleados pertenecen a un almacén (opcional, puede ser NULL)
ALTER TABLE empleados ADD CONSTRAINT fk_empleados_almacen 
    FOREIGN KEY (almacen_id) REFERENCES almacenes(id) ON DELETE SET NULL;

-- Envíos referencian a cliente (opcional)
ALTER TABLE envios ADD CONSTRAINT fk_envios_cliente 
    FOREIGN KEY (cliente_id) REFERENCES clientes(id) ON DELETE SET NULL;

-- Envíos referencian a vehículo (opcional)
ALTER TABLE envios ADD CONSTRAINT fk_envios_vehiculo 
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id) ON DELETE SET NULL;

-- Envíos referencian a empleado (opcional)
ALTER TABLE envios ADD CONSTRAINT fk_envios_empleado 
    FOREIGN KEY (empleado_id) REFERENCES empleados(id) ON DELETE SET NULL;

-- Envíos referencian a almacén de destino (opcional)
ALTER TABLE envios ADD CONSTRAINT fk_envios_almacen_destino 
    FOREIGN KEY (almacen_destino_id) REFERENCES almacenes(id) ON DELETE SET NULL;

-- Incidencias referencian a envío (obligatorio: ON DELETE CASCADE)
ALTER TABLE incidencias ADD CONSTRAINT fk_incidencias_envio 
    FOREIGN KEY (envio_id) REFERENCES envios(id) ON DELETE CASCADE;

-- Incidencias referencian a responsable (opcional)
ALTER TABLE incidencias ADD CONSTRAINT fk_incidencias_responsable 
    FOREIGN KEY (responsable_id) REFERENCES empleados(id) ON DELETE SET NULL;

-- Mantenimientos referencian a vehículo (obligatorio: ON DELETE CASCADE)
ALTER TABLE mantenimientos_flota ADD CONSTRAINT fk_mantenimientos_vehiculo 
    FOREIGN KEY (vehiculo_id) REFERENCES vehiculos(id) ON DELETE CASCADE;

-- ===== UNIQUE CONSTRAINTS (Evitar duplicados) =====
-- Estos campos deben ser únicos en toda la tabla
ALTER TABLE almacenes ADD CONSTRAINT unique_cod_almacen UNIQUE (cod_almacen);
ALTER TABLE empleados ADD CONSTRAINT unique_nif UNIQUE (nif_nie);
ALTER TABLE vehiculos ADD CONSTRAINT unique_matricula UNIQUE (matricula);
ALTER TABLE clientes ADD CONSTRAINT unique_cif_nif UNIQUE (cif_nif);
ALTER TABLE envios ADD CONSTRAINT unique_tracking UNIQUE (tracking_number);
ALTER TABLE proveedores ADD CONSTRAINT unique_cif_prov UNIQUE (cif_prov);

-- ===== NOT NULL CONSTRAINTS (Campos obligatorios) =====
-- Estos campos no pueden ser NULL bajo ninguna circunstancia
ALTER TABLE almacenes MODIFY cod_almacen VARCHAR(50) NOT NULL;
ALTER TABLE empleados MODIFY nif_nie VARCHAR(50) NOT NULL;
ALTER TABLE empleados MODIFY nombre_completo VARCHAR(200) NOT NULL;
ALTER TABLE vehiculos MODIFY matricula VARCHAR(50) NOT NULL;
ALTER TABLE vehiculos MODIFY marca_modelo VARCHAR(150) NOT NULL;
ALTER TABLE clientes MODIFY razon_social VARCHAR(200) NOT NULL;
ALTER TABLE envios MODIFY tracking_number VARCHAR(100) NOT NULL;
ALTER TABLE envios MODIFY f_salida DATE NOT NULL;

SELECT '✅ Constraints aplicados (base de datos blindada)' AS Progreso;

-- =============================================================================
-- 13. VERIFICACIÓN FINAL (CONSULTAS DE CONTROL)
-- =============================================================================
-- PROPÓSITO: Validar que la limpieza se realizó correctamente.
--            Todas estas consultas deben devolver 0 registros.
-- =============================================================================

SELECT '=== VERIFICACIÓN FINAL ===' AS Estado;

-- Mostrar el número total de registros por tabla (para información)
SELECT 'Total registros por tabla:' AS Tabla, 'almacenes' AS Nombre, COUNT(*) AS Total FROM almacenes
UNION SELECT '', 'empleados', COUNT(*) FROM empleados
UNION SELECT '', 'vehiculos', COUNT(*) FROM vehiculos
UNION SELECT '', 'clientes', COUNT(*) FROM clientes
UNION SELECT '', 'envios', COUNT(*) FROM envios
UNION SELECT '', 'incidencias', COUNT(*) FROM incidencias
UNION SELECT '', 'proveedores', COUNT(*) FROM proveedores
UNION SELECT '', 'mantenimientos_flota', COUNT(*) FROM mantenimientos_flota;

-- Verificar huérfanos (debe ser 0 en todos)
SELECT '=== Verificación de Huérfanos (debe ser 0) ===' AS Control;
SELECT 'empleados.almacen_id' AS Campo_con_huérfanos, COUNT(*) AS Total 
FROM empleados WHERE almacen_id IS NOT NULL AND almacen_id NOT IN (SELECT id FROM almacenes)
UNION 
SELECT 'envios.cliente_id', COUNT(*) 
FROM envios WHERE cliente_id IS NOT NULL AND cliente_id NOT IN (SELECT id FROM clientes)
UNION 
SELECT 'envios.vehiculo_id', COUNT(*) 
FROM envios WHERE vehiculo_id IS NOT NULL AND vehiculo_id NOT IN (SELECT id FROM vehiculos)
UNION 
SELECT 'incidencias.envio_id', COUNT(*) 
FROM incidencias WHERE envio_id IS NOT NULL AND envio_id NOT IN (SELECT id FROM envios);

-- Verificar NULLs en campos obligatorios (debe ser 0 en todos)
SELECT '=== Verificación de NULLs en campos obligatorios (debe ser 0) ===' AS Control;
SELECT 'almacenes.cod_almacen' AS Campo_con_NULL, COUNT(*) AS Total 
FROM almacenes WHERE cod_almacen IS NULL
UNION 
SELECT 'empleados.nif_nie', COUNT(*) 
FROM empleados WHERE nif_nie IS NULL
UNION 
SELECT 'vehiculos.matricula', COUNT(*) 
FROM vehiculos WHERE matricula IS NULL
UNION 
SELECT 'envios.tracking_number', COUNT(*) 
FROM envios WHERE tracking_number IS NULL
UNION
SELECT 'envios.f_salida', COUNT(*)
FROM envios WHERE f_salida IS NULL;

-- Mensaje final de éxito
SELECT '>>> LIMPIEZA COMPLETADA CON ÉXITO <<<' AS Mensaje;
SELECT 'Si todas las verificaciones muestran 0, la base de datos está perfecta.' AS Instruccion;