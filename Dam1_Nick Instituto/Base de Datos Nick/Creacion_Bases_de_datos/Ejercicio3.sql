DROP DATABASE IF EXISTS ejercicio2;
CREATE DATABASE ejercicio3;
USE ejercicio3;

CREATE TABLE empleados(
	id_empleado INT UNSIGNED AUTO_INCREMENT,
    dni VARCHAR(9) NOT NULL unique ,
    salario float UNSIGNED default(1200.00),	
    estado Enum('ACTIVO','INACTIVO') default('ACTIVO'),
    CONSTRAINT pk_empleado PRIMARY KEY (id_empleado)
        ON DELETE RESTRICT ON UPDATE CASCADE
);