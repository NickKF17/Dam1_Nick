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
set num_colegiado= concat("PRO-28-",substring(num_colegiado,5,3),"9") where num_colegiado REGEXP('[A-Z]{3}-[0-9]{3}');
commit;
################################# Acabado ejercicio 2
Set sql_safe_updates=1;