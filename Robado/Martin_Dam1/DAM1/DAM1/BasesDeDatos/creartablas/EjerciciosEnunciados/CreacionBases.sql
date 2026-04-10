-- EJERCICIOS DE BASES


-- Ejercicio 1
DROP DATABASE IF EXISTS ejercicios_creacion;
CREATE DATABASE ejercicios_creacion;
USE ejercicios_creacion;


CREATE TABLE vehiculos (
    id_vehiculo INT AUTO_INCREMENT,
    matricula VARCHAR(8),
    tipo VARCHAR(50),
    precio DECIMAL(10,2),
    fecha_compra DATE,
    CONSTRAINT pk_vehiculo PRIMARY KEY (id_vehiculo),
    CONSTRAINT chk_precio CHECK(precio>0),
    CONSTRAINT chk_matricula_comprobacion CHECK(REGEXP_LIKE((matricula, "[1-9]{4}-[A-Z]{3}"))),
    CONSTRAINT uq_matricula UNIQUE (matricula)
);

-- Ejercicio 2

DROP DATABASE IF EXISTS ejercicios_creacion2;
CREATE DATABASE ejercicios_creacion2;
USE ejercicios_creacion2;
CREATE TABLE investigador(
	id_investigador SMALLINT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(50),
    laboratorio SMALLINT UNSIGNED,
    CONSTRAINT pk_investigador PRIMARY KEY (id_investigador)
    
);
CREATE TABLE laboratorio(
	id_laboratorio SMALLINT UNSIGNED AUTO_INCREMENT,
    investigador SMaLLINT UNSIGNED,
    CONSTRAINT pk_laboratorio PRIMARY KEY (id_laboratorio),
    CONSTRAINT fk_laboratorio_investigador FOREIGN KEY(id_investigador)
    REFERENCES investigador(id_investigador)
    ON DELETE RESTRICT ON UPDATE CASCADE
);

ALTER TABLE investigador
	ADD CONSTRAINT fk_investigador_laboratorio FOREIGN KEY (laboratorio)
    REFERENCES laboratorio(id_laboratorio)
    ON DELETE RESTRICT ON UPDATE CASCADE;