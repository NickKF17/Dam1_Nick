DROP DATABASE IF EXISTS gestion_proyectos;
CREATE DATABASE gestion_proyectos;
USE gestion_proyectos;

CREATE TABLE departamentos(
	id_departamento INT UNSIGNED not null AUTO_INCREMENT,
    codigo_dpto VARCHAR(5) NOT NULL unique ,
    nombre varchar(30) not null,	
   presupuesto decimal(10,2) not null check(presupuesto>=0),
    CONSTRAINT pk_departamento PRIMARY KEY (id_departamento)
);

CREATE TABLE empleados(
	id_empleado INT UNSIGNED AUTO_INCREMENT,
    dni VARCHAR(9) NOT NULL unique ,
    salario float  default 1200.00 check(salario>=0),	
    estado Enum('ACTIVO','INACTIVO') default 'ACTIVO',
    CONSTRAINT pk_empleado PRIMARY KEY (id_empleado)
);

CREATE TABLE proyectos(
    id_proyecto INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL UNIQUE,
    id_departamento INT UNSIGNED NOT NULL , 
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    Constraint chk_fecha CHECK(fecha_fin > fecha_inicio),
    CONSTRAINT pk_proyecto PRIMARY KEY (id_proyecto),
    CONSTRAINT fk_proyectos_departamentos FOREIGN KEY (id_departamento)
        REFERENCES departamentos(id_departamento)
);

CREATE TABLE asignaciones(
	id_empleado INT UNSIGNED ,
    id_proyecto int unsigned ,
    salario decimal(10,2)  default 1200.00 check(salario >= 0),	
    estado Enum('ACTIVO','INACTIVO') default 'ACTIVO',
    horas_asignadas int unsigned default 0,
   CONSTRAINT pk_asignaciones PRIMARY KEY (id_empleado, id_proyecto),
    CONSTRAINT fk_asignaciones_empleados foreign key (id_empleado)
    references empleados(id_empleado)
     ON DELETE CASCADE ON UPDATE CASCADE ,
     
    CONSTRAINT fk_asignaciones_proyectos foreign KEY (id_proyecto)	
    references proyectos(id_proyecto)
     ON DELETE CASCADE ON UPDATE CASCADE -- SET NULL porque... 
);

