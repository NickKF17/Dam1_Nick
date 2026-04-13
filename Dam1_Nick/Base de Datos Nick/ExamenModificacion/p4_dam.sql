use logistica_global;

select * from envios;

SET SQL_SAFE_UPDATES = 0;

alter table envios
add column dias_retraso int;
Start transaction;
# 1. Hacer replaces

update envios
set f_entrega_real= REPLACE(f_entrega_real, '-', '/');

update envios
set f_llegada_prevista= REPLACE(f_llegada_prevista, '-', '/');

-- 2. Actualizar según los formatos 
UPDATE envios 
SET f_entrega_real = STR_TO_DATE(f_entrega_real, '%Y/%m/%d ')
WHERE f_entrega_real LIKE '%/%/____';

-- Formato: '2026/03/13 ' 
UPDATE envios
SET f_entrega_real = STR_TO_DATE(f_entrega_real, '%Y/%m/%d' )
WHERE f_entrega_real LIKE '____/%/%';

-- Formato: '03/13/2026 ' 

UPDATE envios 
SET f_llegada_prevista = STR_TO_DATE(f_llegada_prevista, '%Y/%m/%d ')
WHERE f_llegada_prevista LIKE '%/%/____';

 
UPDATE envios
SET f_llegada_prevista = STR_TO_DATE(f_llegada_prevista, '%Y/%m/%d' )
WHERE f_llegada_prevista LIKE '____/%/%';

#Nos aseguramos de que este vacia
UPDATE envios 
SET dias_retraso =null;

#Hacemos el datediff
UPDATE envios 
SET dias_retraso = DATEDIFF(f_entrega_real,f_llegada_prevista) 
WHERE  f_entrega_real > f_llegada_prevista and  f_entrega_real LIKE '____/%/%' and f_llegada_prevista LIKE '____/%/%' ;

select * from envios;

SET SQL_SAFE_UPDATES = 1;

savepoint hecho;
commit;