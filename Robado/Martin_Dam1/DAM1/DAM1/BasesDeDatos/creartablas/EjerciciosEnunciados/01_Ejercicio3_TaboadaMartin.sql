
DROP DATABASE IF EXISTS gestion_proyectos;
CREATE DATABASE gestion_proyectos;
USE gestion_proyectos;

CREATE TABLE empleados ( 
	id_empleado INT UNSIGNED AUTO_INCREMENT ,
    dni VARCHAR(9) NOT NULL,
    salario DECIMAL(10,2)NOT NULL DEFAULT 1200.00,
    estado ENUM('ACTIVO', 'INACTIVO') NOT NULL DEFAULT 'ACTIVO',
    CONSTRAINT pk_empleados PRIMARY KEY (id_empleado),
    CONSTRAINT uq_dni UNIQUE (dni),
    CONSTRAINT chk_dni_comprobacion CHECK(REGEXP_LIKE(dni, "^[0-9]{8}[A-Z]{1}$"))
    
);


CREATE TABLE departamentos(
	id_departamento INT UNSIGNED AUTO_INCREMENT,
    codigo_dpto VARCHAR(5) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    presupuesto DECIMAL(10,2) NOT NULL,
    CONSTRAINT pk_departamentos PRIMARY KEY (id_departamento),
    CONSTRAINT uq_codigo_dpto UNIQUE (codigo_dpto),
    CONSTRAINT chk_pos_presup CHECK (presupuesto>=0)
);
    
CREATE TABLE proyectos (
    id_proyecto INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    id_departamento INT UNSIGNED NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE,
    CONSTRAINT pk_proyectos PRIMARY KEY (id_proyecto),
    CONSTRAINT uq_nombre UNIQUE (nombre),
    CONSTRAINT fk_proyectos_departamentos FOREIGN KEY (id_departamento)
        REFERENCES departamentos (id_departamento)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT chk_fecha_fin CHECK (fecha_fin > fecha_inicio)
);

CREATE TABLE asignaciones(
	id_empleado INT UNSIGNED,
    id_proyecto INT UNSIGNED,
    horas_asignadas SMALLINT UNSIGNED DEFAULT 0,
    CONSTRAINT pk_asignaciones PRIMARY KEY (id_empleado, id_proyecto),
    CONSTRAINT fk_asignaciones_empleados FOREIGN KEY (id_empleado)
		REFERENCES empleados (id_empleado)
        ON DELETE CASCADE ON UPDATE CASCADE, 
	CONSTRAINT fk_asignaciones_proyecto FOREIGN KEY (id_proyecto)
		REFERENCES proyectos (id_proyecto)
        ON DELETE CASCADE ON UPDATE CASCADE 
);



