use logistica_global;
select * from almacenes;

Start transaction;
SET SQL_SAFE_UPDATES = 0;

DELETE a2
FROM almacenes a1 JOIN almacenes a2 ON a1.cod_almacen = a2.cod_almacen
WHERE char_length(a2.nombre_sucursal) > char_length(a1.nombre_sucursal);

savepoint hecho;
/* No me sale el de iguales quedarse con el mas bajo
DELETE a2
FROM almcacenes a1 JOIN almacenes a2 ON a1.cod_almacen = a2.cod_almacen
where  char_length(a2.nombre_sucursal) = char_length(a1.nombre_sucursal)
group by id;
having  c2.id > c1.id; 
*/

SET SQL_SAFE_UPDATES = 1;
commit;
select * from almacenes;