
Create table vehiculos (
id_vehiculo Int auto_increment,
matricula varchar(8),
tipo varchar(50),
precio decimal(10,2),
fecha_compra DAte,
constraint pk_vehiculo primary key(id_vehiculo),
constraint chk_precio check(precio>0),
constraint chk_matricula_comprobacion check(REGEXP_LIKE (matricula, '[0-9]{4}-[0-9]{3}' ))
);


