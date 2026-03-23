use erp_logistica;

-- Estudiamos la BD.
show tables;
select * from categorias;
select * from clientes;
explain clientes;
select * from pedidos;

-- 1) Limpia los espacios en blanco del nombre
SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET nombre_completo = TRIM(nombre_completo);
SELECT * FROM clientes;
SET SQL_SAFE_UPDATES = 1;


-- ERROR:
SET SQL_SAFE_UPDATES = 0;
-- UPDATE clientes SET nombre_completo = TRIM('nombre_completo');
SET SQL_SAFE_UPDATES = 1;
SELECT * FROM clientes;

-- 2)
-- 2.1) Miro a ver qué está mal
select * from clientes;
-- 2.2) Corrijo
UPDATE clientes SET email = REPLACE (email, '.con','.com');
-- gomez.conrado@gmail.com -> gomez.comrado@gmail.com ¡ERROR! Así que, lo mejoramos.
UPDATE clientes SET email = REPLACE (email, '.con','.com') WHERE email LIKE '%.con';
-- gomez.conrado@gmail.com ->  no lo toca, así que guay.
-- gomez.conrado@gmail.con -> 
SELECT replace('gomez.conrado@gmail.con','.con','.com');
-- gomez.conrado@gmail.con -> gomez.comrado@gmail.com
-- SOLUCIONES:
-- 1) parto el email en el @ y luego concateno de vuelta. [solución muy buena muy general]
-- 2) Solución válida para el ejemplo 2 de clase que tiene pocos datos. 
select email from clientes where email like '%.con';
SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET email = REPLACE (email, 'email.con','email.com') WHERE email LIKE '%.con';
UPDATE clientes SET email = REPLACE (email, 'outlook.con','outlook.com') WHERE email LIKE '%.con';
SET SQL_SAFE_UPDATES = 1;
-- 3) Comprobamos:
select * from clientes;

SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET email = REPLACE (email, ',','.');
SET SQL_SAFE_UPDATES = 1;

-- 2.3) Compruebo
select * from clientes;

-- 3) Arreglar los teléfonos
-- 3.1) Comprobamos que está fatal.
-- 3.2) Vamos poco a poco.
-- PLAN A:
SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET telefono = REPLACE(telefono,' ','');
UPDATE clientes SET telefono = REPLACE(telefono,'-','');
UPDATE clientes SET telefono = REPLACE(telefono,'+34','');
SELECT telefono from clientes where telefono like '0034%';
-- UPDATE clientes SET telefono = REPLACE(telefono,'0034','') WHERE telefono like '0034%';-- Como solo hay un teléfono con el prefijo 0034 que NO CONTIENE 0034 como dígitos válidos, este update es seguro. No obstante, es mejor este otro:
UPDATE clientes SET telefono = SUBSTRING(telefono,5,9)  WHERE telefono like '0034%';
select SUBSTRING('0034650034123',5,9);
SET SQL_SAFE_UPDATES = 1;
-- 0034650034123 -> 65123
select * from clientes;
-- PLAN B: Encadeno
UPDATE clientes SET telefono = 
	substring(
		REPLACE(
			REPLACE(
				REPLACE(telefono,'-','')
			,' ','')
		,'+34','')
	,5,9);


-- PROTECCIÓN ANTE DESASTRES (se va la luz, he puesto el mismo nombre a todos los clientes)
-- 2 formas de protección: Staging y transacciones.
select * from clientes; -- Voy a cargar otra vez la BD para tener los teléfonos "sucios"

-- Staging: crear una tabla o columna temporal, rellenarla con los datos limpios y luego sustituir la columna inicial.
select * from clientes;
explain clientes; -- mira el tipo de dato de teléfono para poner el mismo en la tabla/columna temporal.
ALTER TABLE clientes
	ADD COLUMN telefono_en_proceso VARCHAR(20); -- CON EL MISMO TIPO DE DATO.
    
-- voy actualizando
SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET telefono_en_proceso = REPLACE(telefono,' ','');
UPDATE clientes SET telefono_en_proceso = REPLACE(telefono_en_proceso,'-','');
UPDATE clientes SET telefono_en_proceso = REPLACE(telefono_en_proceso,'+34','');
SELECT telefono_en_proceso from clientes where telefono_en_proceso like '0034%';
UPDATE clientes SET telefono_en_proceso = SUBSTRING(telefono_en_proceso,5,9)  WHERE telefono_en_proceso like '0034%';
-- YA TENGO LOS CAMBIOS "A SUCIO". COMPROBAMOS Y PASAMOS A LIMPIO.
select * from clientes;
-- PASO A LIMPIO:
UPDATE clientes SET telefono = telefono_en_proceso;
ALTER TABLE clientes
	DROP COLUMN telefono_en_proceso; -- eliminamos la tabla
SET SQL_SAFE_UPDATES = 1;
select * from clientes;

-- PROTECCIÓN 2: TRANSACCIONES
-- EJEMPLO 1
START TRANSACTION; -- A partir de ahora, todos los cambios son TEMPORALES hasta que se deshagan (rollback) o se confirmen (commit)
-- vuelvo a cargar los teléfonos
select * from clientes;
-- Empiezo a corregir cosas.
SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET telefono = REPLACE(telefono,' ','');
select * from clientes;
SET SQL_SAFE_UPDATES = 1;
select * from clientes;
-- CIERRA Y VUELVE A ABRIR

-- EJEMPLO 2
SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET telefono = REPLACE(telefono,' ',''); -- DEFINITIVO
select * from clientes;
START TRANSACTION; -- A partir de ahora, todos los cambios son TEMPORALES hasta que se deshagan (rollback) o se confirmen (commit)
UPDATE clientes SET telefono = REPLACE(telefono,'-',''); -- TEMPORAL
UPDATE clientes SET telefono = REPLACE(telefono,'+34',''); -- TEMPORAL
UPDATE clientes SET telefono = REPLACE(telefono,'0034','?'); -- TEMPORAL
SET SQL_SAFE_UPDATES = 1;
select * from clientes;
ROLLBACK;
select * from clientes; -- NO HAY ESPACIOS, PERO SÍ GUIONE

-- EJEMPLO 3: TENEMOS GUIONES, PERO NO ESPACIOS.
START TRANSACTION;
SET SQL_SAFE_UPDATES = 0;
UPDATE clientes SET telefono = REPLACE(telefono,'-',''); -- TEMPORAL
UPDATE clientes SET telefono = REPLACE(telefono,'+34',''); -- TEMPORAL
UPDATE clientes SET telefono = SUBSTRING(telefono,5,9)  WHERE telefono like '0034%';-- TEMPORAL
select * from clientes;
COMMIT; -- LOS MARCAMOS COMO DEFINITIVOS.
select * from clientes;
SET SQL_SAFE_UPDATES = 1;



##NICK
# Bloque 1
# 4)
SET SQL_SAFE_UPDATES = 0;
select * from pedidos;
Update pedidos set estado= upper(estado);
select * from pedidos;

SET SQL_SAFE_UPDATES = 1;

# 5) && 6) && 7) && 8)
select * from productos;
SET SQL_SAFE_UPDATES = 0;
Update productos set precio_sucio= replace(replace(replace(precio_sucio,'$',''),'€',''),',','.');
Update productos set precio_sucio=replace(precio_sucio,'EUR','');
Update productos set precio_sucio=replace(precio_sucio,' ','');
Update productos set precio_sucio=replace(precio_sucio,'Gratis','0.00');
SET SQL_SAFE_UPDATES = 1;
select * from productos;

# Bloque 2
# 1)
Alter table productos
	Rename column precio_sucio to precio;	
Start Transaction;
SET SQL_SAFE_UPDATES = 0;
Alter table productos	
    MODIFY COLUMN precio DEcimal(10,2);
SET SQL_SAFE_UPDATES = 1;
select * from productos;
commit;
# 2) 
show tables;
select * from pedidos;

Start transaction;
SET SQL_SAFE_UPDATES = 0;
Update pedidos set fecha_texto=replace(fecha_texto,'/','-');
Update pedidos set fecha_texto=replace(fecha_texto,'.','-');
Update pedidos set fecha_texto=replace(fecha_texto,'-','');
SET SQL_SAFE_UPDATES = 1;
commit;
select * from pedidos;
explain pedidos;
#Update pedidos Set fecha_texto=fecha_prueba;
Start transaction;
SET SQL_SAFE_UPDATES = 0;
select substring(fecha_prueba,1,2);
select substring(fecha_prueba,7,4);

Update pedidos set fecha_texto=concat(substring(fecha_prueba,7,4),'-',substring(fecha_prueba,4,2),'-',substring(fecha_prueba,1,2)) WHERE fecha_texto REGEXP '[0-9]{4}$';
SET SQL_SAFE_UPDATES = 1;

alter table pedidos 
	add column fecha_prueba varchar(20);
#Update pedidos Set fecha_prueba= fecha_texto;
Commit;
select * from pedidos;