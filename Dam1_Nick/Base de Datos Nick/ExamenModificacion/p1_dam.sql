use logistica_global;
 select * from empleados;
 
 #Creamos la columna de salario_neto
 alter table empleados
 add COLUMN salario_neto decimal (10,2);
 
 Start transaction;
 
 SET SQL_SAFE_UPDATES = 0;
 
 #Quitamos los EUR
  update empleados
 set salario_base_sucio=replace(salario_base_sucio,"EUR","");
 

   update empleados
 set salario_base_sucio=trim(salario_base_sucio);
 
 #Quitamos los que no son numericos
 
 update empleados
 set salario_base_sucio='00.00' where salario_base_sucio regexp '[^0-9]+$';
  #savepoint de los cambios hechos antes de hacer la retencion y antes del alter table para que no rompa el rollback
 savepoint cambios_sucio;
 
 alter table empleados
 modify column salario_base_sucio decimal(10,2);

 update empleados
 set salario_neto= salario_base_sucio * 0.85;
 
 ROLLBACK to cambios_sucio;
 
  update empleados
 set salario_neto= salario_base_sucio * 0.82;
 savepoint corregido;
 commit;
 SET SQL_SAFE_UPDATES = 1;
 
  select * from empleados;