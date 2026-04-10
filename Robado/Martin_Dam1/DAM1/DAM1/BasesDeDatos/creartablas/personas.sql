CREATE DATABASE prueba;
use prueba;
CREATE TABLE personas (
    id_persona INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(40),
    apellido VARCHAR(55),
    edad INT,
    fecha_acc DATETIME DEFAULT CURRENT_TIMESTAMP (),
    UNIQUE (id_persona),
    PRIMARY KEY (id_persona),
    CHECK (edad >= 18)
);

ALTER TABLE personas 
	ADD email varchar(100);
ALTER TABLE personas
	RENAME COLUMN apellido to descripcion;
Alter TABLE personas
MODIFY COLUMN descripcion varchar(250);

CREATE TABLE dni (
	id_dni int AUTO_INCREMENT NOT NULL pRIMARY KEY,
    numero_dni varchar(9) NOT NULL,
    id_persona int,
    UNIQUE(id_dni, numero_dni),
    FOREIGN KEY (id_persona) REFERENCES personas(id_persona)
);

ALTER TABLE dni
ADD CONSTRAINT fk_persona
FOREIGN KEY(id_persona) REFERENCES personas(id_persona);

CREATE TABLE empresa(
	id_empresa int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(30) NOT NULL
);



ALTER TABLE personas 
MODIFY id_empresa int;

CREATE TABLE lenguajes(
	id_languaje int AUTO_INCREMENT PRIMARY KEY,
    name varchar(20) NOT NULL
);

CREATE TABLE personas_lenguajes(
	id_persona int, -- AUTO_INCREMENT PRIMARY KEY(otra forma de hacer llaves primarias),
    id_lenguaje int,
    PRIMARY KEY (id_persona, id_lenguaje),
    FOREIGN KEY(id_persona) REFERENCES personas(id_persona) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_lenguaje) REFERENCES lenguajes(id_lenguaje),
    UNIQUE (id_persona, id_lenguaje)
);

ALTER TABLE personas 
ADD CONSTRAINT fk_empresa
FOREIGN KEY (id_empresa) REFERENCES empresa(id_empresa);
