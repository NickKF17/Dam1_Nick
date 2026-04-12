use gha_analytics;
 show tables;
 Select * from pacientes;
 explain pacientes;
 ###############################1
 
 Set sql_safe_updates=0;
 Start TRANSACTION;
SELECT * FROM pacientes;
select lower(trim(nombre_completo)) from pacientes;

ALTER TABLE pacientes 
ADD COLUMN nombre Varchar(30);

UPDATE pacientes 
SET 
    nombre = nombre_completo;

Update pacientes 
set nombre = replace(nombre,"  "," ");

Update pacientes
set nombre = trim(nombre);


Update pacientes
Set nombre_completo = nombre;

Alter table pacientes 
Drop column nombre;

SELECT * FROM pacientes;
Set sql_safe_updates=1;

-- ahora que ya no hay pedidos de los clientes duplicados, eliminamos esos clientes.ALTER
Set sql_safe_updates=0;
DELETE p2
FROM pacientes p1 JOIN pacientes p2 ON p1.nombre_completo = p2.nombre_completo
WHERE p2.id > p1.id;
select * from pacientes;
Set sql_safe_updates=1;
COMMIT;
#################################
#################################1.2
Set sql_safe_updates=0;
Start Transaction;

Update pacientes
set nif = trim(nif);

update pacientes 
set nif = replace(nif,"-","") where char_length(10);

update pacientes
set nif = "00000000X" where nif  REGEXP "^[^0-9]+$";
commit;

Alter table pacientes
add constraint chk_nif check (nif regexp '[0-9]{8}[A-Z]{1}');
/*
INSERT INTO `gha_analytics`.`pacientes`
(`id`,
`nif`,
`nombre_completo`,
`email`,
`tel_contacto`,
`f_nacimiento`,
`num_poliza`)
VALUES
(10,
"000f",
"xc",
"vgde",
"ghgtrh",
"erg detr",
"rgge");
Prueba de que funciona el check añadido
*/

Alter table pacientes
modify column nif VARCHAR(30) Unique Not null;

# explain pacientes;
################################# Acabado ejercicio 1
################################# 2
select * from medicos;
Start Transaction;
Update medicos
set num_colegiado= replace(replace(num_colegiado,"/",""),"-","") where num_colegiado REGEXP ('^[0-9]');
savepoint Sin_simbolos;
update medicos 
set num_colegiado = concat("COL-",substring(num_colegiado,1,2),"-",SUBSTRING(num_colegiado,3,4)) where num_colegiado REGEXP ('^[0-9]');
savepoint Sin_simbolosdos;
update medicos
set num_colegiado = concat(substring(num_colegiado,1,3),"-",substring(num_colegiado,4,2),"-",substring(num_colegiado,6,4)) where num_colegiado RegEXP('[A-Z]{3}[0-9]{6}');
savepoint Ultimo;
Update medicos
set num_colegiado= concat("COL-28-",substring(num_colegiado,5,3),"9") where num_colegiado REGEXP('[A-Z]{3}-[0-9]{3}');
commit;

alter table medicos
add constraint chk_num_colegiado check (num_colegiado regexp '^COL-[0-9]{2}-[0-9]{4}$');

Set sql_safe_updates=1;
select * from medicos;

################################# Acabado ejercicio 2
################################# 3
Set sql_safe_updates=0;
update medicos 
set especialidad_id =4 where especialidad_id > 4;
explain medicos;
explain visitas;
select * from especialidades;
select * from medicos;
select * from visitas;
alter table medicos
add constraint fk_especialidad_id foreign key (especialidad_id) references especialidades(id);

#limpio los pacientes y medicos que no existen
UPDATE visitas SET medico_id = NULL WHERE medico_id NOT IN (SELECT id FROM medicos);
UPDATE visitas SET paciente_id = NULL WHERE paciente_id NOT IN (SELECT id FROM pacientes);

alter table visitas 
add constraint fk_medicos_id foreign key (medico_id) references medicos(id);

alter table visitas 
add constraint fk_pacientes_id foreign key (paciente_id) references pacientes(id);

Set sql_safe_updates=1;
################################# Acabado ejercicio 3
################################# 4
Set sql_safe_updates=0;
select * from pacientes;
CREATE TABLE seguros_pacientes (
    paciente_id int  ,
    num_poliza varchar(50),
    estado_poliza  enum('Activa','Apagada')  default 'Activa'
);
#Evitando que los null sean iguales al cambiarlo
set @id=1000;
UPDATE pacientes
SET num_poliza = CONCAT('TEMP-', (@id := @id + 1))
WHERE num_poliza IS NULL;

UPDATE pacientes
SET num_poliza = CONCAT('TEMP-', (@id := @id + 1))
WHERE num_poliza like 'FAKE%';

alter table pacientes
modify column num_poliza varchar(50) Not null;

Set sql_safe_updates=1;
/*
UPDATE seguros_pacientes
JOIN pacientes ON seguros_pacientes.paciente_id = pacientes.id
SET seguros_pacientes.num_poliza = pacientes.num_poliza ;

UPDATE seguros_pacientes
JOIN pacientes ON seguros_pacientes.paciente_id = pacientes.id
Set seguros_pacientes.paciente_id = pacientes.id;
Esto no es asi
*/
#Es asi
Set sql_safe_updates=0;
INSERT INTO seguros_pacientes (paciente_id, num_poliza)
SELECT id, num_poliza FROM pacientes;

explain pacientes;


explain seguros_pacientes;



select * from seguros_pacientes;
select* from pacientes;


alter table seguros_pacientes
add constraint pk_paciente_id_num_poliza primary key (paciente_id,num_poliza);


alter table seguros_pacientes
add constraint fk_paciente_id foreign key (paciente_id) references pacientes(id);

#Obligatorio para evitar el error 1822 que no permite foraneas en elementos que no sean uniques
ALTER TABLE pacientes 
ADD UNIQUE (num_poliza);

alter table seguros_pacientes
add constraint fk_num_poliza foreign key (num_poliza) references pacientes(num_poliza);


explain seguros_pacientes;
Set sql_safe_updates=1;
################################# Acabado ejercicio 4
################################# 5
#Limpiamos los precios sucios
Set sql_safe_updates=0;
select * from visitas;
start transaction;
update visitas
set importe_sucio=replace(importe_sucio,'?','');
update visitas
set importe_sucio=trim(importe_sucio);

update visitas
set importe_sucio='00,00' where importe_sucio like 'Gratis';

update visitas
set importe_sucio=replace(importe_sucio,'$','');

update visitas
set importe_sucio=replace(importe_sucio,',','.');

update visitas
set importe_sucio=replace(importe_sucio,' EUR','');


alter table visitas
add column copago_estimado decimal(10,2);

update visitas
set copago_estimado= importe_sucio *(0.20);


select * from visitas;
explain seguros_pacientes;

explain visitas;

alter table visitas 
modify column copago_estimado  decimal(10,2) not null;

Set sql_safe_updates=1;

################################# Acabado ejercicio 5
################################# 6

SET sql_safe_updates = 0;

-- Crear tabla temporal
CREATE TABLE temp_raw AS
SELECT 
    ext_id,
    SUBSTRING_INDEX(raw_data, '|', 1) AS nif,
    SUBSTRING_INDEX(SUBSTRING_INDEX(raw_data, '|', 2), '|', -1) AS nombre,
    SUBSTRING_INDEX(SUBSTRING_INDEX(raw_data, '|', 3), '|', -1) AS fecha_visita,
    SUBSTRING_INDEX(raw_data, '|', -1) AS coste,
    raw_phone
FROM raw_import_visitas;

-- Insertar pacientes que NO existen
INSERT INTO pacientes (nif, nombre_completo, tel_contacto, email, f_nacimiento, num_poliza)
SELECT DISTINCT 
    t.nif, 
    t.nombre, 
    t.raw_phone,
    NULL,
    NULL,
    CONCAT('TEMP_', t.nif)
FROM temp_raw t
WHERE t.nif NOT IN (SELECT nif FROM pacientes WHERE nif IS NOT NULL);

-- Insertar visitas SOLO si NO existen ya (evitar duplicados)
INSERT INTO visitas (paciente_id, medico_id, fecha_visita, importe_sucio, descuento_aplicado, observaciones, copago_estimado)
SELECT 
    p.id,
    1,
    t.fecha_visita,
    REPLACE(REPLACE(REPLACE(REPLACE(t.coste, '€', ''), '$', ''), 'EUR', ''), 'GRATIS', '0'),
    NULL,
    'Importado desde staging',
    0
FROM temp_raw t
JOIN pacientes p ON p.nif = t.nif
WHERE NOT EXISTS (
    SELECT 1 
    FROM visitas v 
    WHERE v.paciente_id = p.id 
      AND v.fecha_visita = t.fecha_visita
      AND v.medico_id = 1
);

DROP TABLE temp_raw;

Set sql_safe_updates=0;
select * from visitas;
start transaction;
update visitas
set importe_sucio=replace(importe_sucio,'?','');
update visitas
set importe_sucio=trim(importe_sucio);

update visitas
set importe_sucio='00,00' where importe_sucio like 'Gratis';

update visitas
set importe_sucio=replace(importe_sucio,'$','');

update visitas
set importe_sucio=replace(importe_sucio,',','.');

update visitas
set importe_sucio=replace(importe_sucio,' EUR','');

update visitas
set copago_estimado= importe_sucio *(0.20);

SET sql_safe_updates = 1;

#REvisamos si se han importado correctamente y sin duplicados
SELECT 
    (SELECT COUNT(*) FROM pacientes WHERE num_poliza LIKE 'TEMP_%') AS pacientes_nuevos,
    (SELECT COUNT(*) FROM visitas WHERE observaciones = 'Importado desde staging') AS visitas_importadas;
################################# Acabado ejercicio 6


################################# Escenario 2
CREATE OR REPLACE VIEW informe_facturacion AS
SELECT 
    id,
    nif,
    nombre_completo,
    COALESCE(email, 'sin_email@registro.com') AS email_facturacion,
    IF(num_poliza LIKE 'TEMP_%', 'SIN_POLIZA', COALESCE(num_poliza, 'SIN_POLIZA')) AS num_poliza_normalizado
FROM pacientes
WHERE email IS NULL 
   OR email NOT REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
   OR email LIKE '%@%@%'   -- Rechaza doble @
   OR num_poliza IS NULL
   OR num_poliza LIKE 'TEMP_%';
   #miramos el informe
Select * from informe_facturacion;

# Consulta para ver los que no entran en el informe
SELECT p.*
FROM pacientes p
LEFT JOIN informe_facturacion v ON p.id = v.id
WHERE v.id IS NULL;


################################################# Escenario 2.1
select * from visitas;



SET sql_safe_updates = 0;

-- 1. Añadir columna nueva DATETIME
ALTER TABLE visitas ADD COLUMN fecha_datetime DATETIME;

-- 2. Actualizar según los formatos 
UPDATE visitas 
SET fecha_datetime = STR_TO_DATE(fecha_visita, '%d/%m/%Y %H:%i')
WHERE fecha_visita LIKE '%/%/% %:%';

-- Formato: '2026.03.13 09:00' 
UPDATE visitas 
SET fecha_datetime = STR_TO_DATE(fecha_visita, '%Y.%m.%d %H:%i')
WHERE fecha_visita LIKE '%.%.% %:%';

-- Formato: '14-03-2026 11:15' 
UPDATE visitas 
SET fecha_datetime = STR_TO_DATE(fecha_visita, '%d-%m-%Y %H:%i')
WHERE fecha_visita LIKE '%-%-% %:%';

-- Formato: '12/03/2026' 
UPDATE visitas 
SET fecha_datetime = STR_TO_DATE(fecha_visita, '%d/%m/%Y')
WHERE fecha_visita REGEXP '^[0-9]{2}/[0-9]{2}/[0-9]{4}$';

-- Formato: '15/03/2026' (igual que arriba, ya cubierto)

-- Formato: '2026-03-17' 
UPDATE visitas 
SET fecha_datetime = STR_TO_DATE(fecha_visita, '%Y-%m-%d')
WHERE fecha_visita REGEXP '^[0-9]{4}-[0-9]{2}-[0-9]{2}$';

-- Formato: '18/03/2026' 



-- Formato: '2026.03.19' 
UPDATE visitas 
SET fecha_datetime = STR_TO_DATE(
    REPLACE(fecha_visita, '.', '-'),
    '%Y-%m-%d %H:%i'
)
WHERE fecha_visita REGEXP '^[0-9]{4}\.[0-9]{2}\.[0-9]{2}';

-- Formato: '20/03/2026' 

-- Formato: '21-03-2026' 
UPDATE visitas 
SET fecha_datetime = STR_TO_DATE(fecha_visita, '%d-%m-%Y')
WHERE fecha_visita REGEXP '^[0-9]{2}-[0-9]{2}-[0-9]{4}$';

-- 3. Los que quedaron NULL (como el NULL original) se dejan NULL

ALTER TABLE visitas DROP COLUMN fecha_visita;
ALTER TABLE visitas CHANGE COLUMN fecha_datetime fecha_visita DATETIME;

select * from visitas;

explain visitas;
SET sql_safe_updates = 1;
########################################## Escenario 2.3
SET sql_safe_updates = 0;

-- Limpiar importe_sucio
UPDATE visitas SET importe_sucio = REPLACE(REPLACE(REPLACE(importe_sucio, '€', ''), '$', ''), 'EUR', '');
UPDATE visitas SET importe_sucio = REPLACE(importe_sucio, ',', '.');
UPDATE visitas SET importe_sucio = '0' WHERE importe_sucio = 'GRATIS';
UPDATE visitas SET importe_sucio = '0' WHERE importe_sucio NOT REGEXP '^[0-9]+\.?[0-9]*$';

-- Limpiar descuento_aplicado
UPDATE visitas SET descuento_aplicado = REPLACE(descuento_aplicado, ',', '.');
UPDATE visitas SET descuento_aplicado = '0' WHERE descuento_aplicado IS NULL OR descuento_aplicado = '';
UPDATE visitas SET descuento_aplicado = '0' WHERE descuento_aplicado NOT REGEXP '^[0-9]+\.?[0-9]*$';


ALTER TABLE visitas MODIFY COLUMN importe_sucio DECIMAL(10,2);
ALTER TABLE visitas MODIFY COLUMN descuento_aplicado DECIMAL(10,2);

Alter table visitas
modify column descuento_aplicado decimal(10,2);

explain visitas;
SET sql_safe_updates = 1;

########################################## Escenario 2.4

-- Consulta NO SARGable (lenta)
SELECT * FROM visitas WHERE DATE(fecha_visita) = '2026-03-12';

-- Consulta SARGable (rápida)
SELECT * FROM visitas WHERE fecha_visita >= '2026-03-12 00:00:00' AND fecha_visita < '2026-03-13 00:00:00';