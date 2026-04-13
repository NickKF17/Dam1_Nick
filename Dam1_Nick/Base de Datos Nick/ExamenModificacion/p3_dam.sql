use logistica_global;

select * from empleados;
select *from almacenes;
Start transaction;

SET SQL_SAFE_UPDATES = 0;

#Ponemos 1 a los que no existan el almacen_id
update empleados
set almacen_id=1 where almacen_id is null;

update empleados
set almacen_id=1 where almacen_id not in (select id from almacenes);
savepoint hecho;
commit;

#Definimos la FK
alter table empleados
add constraint fk_almacen_id foreign key (almacen_id)references almacenes(id); 

SET SQL_SAFE_UPDATES = 1;

