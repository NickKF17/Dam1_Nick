use logistica_global;

select * from almacenes;
explain almacenes;

create table tipos_gestion(
id int auto_increment primary key, # las primary key son autoincrements por si solas
nombre_tipo varchar(50) # mismo tipo (varchar(50))que en la otra tabla
);

start transaction;
INSERT INTO tipos_gestion (nombre_tipo)
SELECT tipo_gestion
FROM almacenes
GROUP BY tipo_gestion
HAVING COUNT(*) = 1;

select * from tipos_gestion;
SET SQL_SAFE_UPDATES = 0;

#la subconsulta me sale pero da mas de 1 row
select tipo_gestion from almacenes
GROUP BY tipo_gestion
Having count(tipo_gestion)=1 ;
commit;
#Nueva columna
alter table almacenes 
add column tipo_gestion_id varchar(50);


