-- Script de creación del ejercicio 5 de obras musicales
-- Construimos a partir del modelo relacional.

DROP DATABASE IF EXISTS obras_musicales;
CREATE DATABASE obras_musicales;
USE obras_musicales;

CREATE TABLE compositor (
	id_compositor SMALLINT unsigned AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
	año_nacimiento SMALLINT,
    nacionalidad CHAR(4), -- como codigo de pais, esto es una chapuza
	CONSTRAINT pk_id_compositor primary key (id_compositor)
);


CREATE TABLE director (
	id_director SMALLINT unsigned AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
	año_nacimiento SMALLINT,
    nacionalidad CHAR(4), -- como codigo de pais, esto es una chapuza
	CONSTRAINT pk_id_director primary key (id_director),
    CONSTRAINT uq_director_nombre UNIQUE(nombre), -- El nombre se puede poenr así para que sea unico
    CONSTRAINT chk_nombre_not_null CHECK(nombre IS NOT NULL)
);



CREATE TABLE interprete (
	id_interprete SMALLINT unsigned AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    año_nacimiento SMALLINT,
    nacionalidad CHAR(4), -- como codigo de pais, esto es una chapuza
	CONSTRAINT pk_id_interprete primary key (id_interprete)
    
);

CREATE TABLE obra(
	id_obra SMALLINT UNSIGNED AUTO_INCREMENT,
	titulo VARCHAR(50) NOT NULL, -- ojo que no estaba bien el relacional
	tipo VARCHAR(25),
    modo VARCHAR(25), -- probablemente sea un error, pero necesitamos mas contexto de los modos
    tono ENUM('C','Cm','C#','C#m'), -- así se seguira hasta que se acabe la nota
	id_compositor SMALLINT UNSIGNED,
    CONSTRAINT pk_obra_ PRIMARY KEY (id_obra),
    CONSTRAINT fk_obra_compositor 
		FOREIGN KEY (id_compositor) -- campo de esta tabla
        REFERENCES compositor(id_compositor)
        ON DELETE SET NULL ON UPDATE CASCADE -- Por defecto
    );
    
CREATE TABLE version(
	-- este caso es si es que generamos una clave primaria para el id de version
	id_version SMALLINT UNSIGNED AUTO_INCREMENT, -- como lleva on constraint de pk no hace falta indicar not null ni unique
    -- POSIBILIDAD REAL, INCOMPATIBLE CON EL MODELO RELACIONAL, ADEMAS TIENE UN ERROR DE DISEÑÑO
    -- POR ESO NO podemos asignar como clave primaria las tres versiones, porque hay una fk que tiene las de no ser null
    id_obra SMALLINT UNSIGNED,
    id_interprete SMALLINT UNSIGNED,
    id_director SMALLINT UNSIGNED,
    
    -- id_version SMALLINT UNSIGNED --ERROR DE DISEÑO
    -- CONSTRAINT pk_version PRIMARY KEY (id_obra, id_interprete, id_director)la version malilla
    CONSTRAINT pk_version PRIMARY KEY (id_version),
    CONSTRAINT fk_version_obra FOREIGN KEY (id_obra)
		REFERENCES obra(id_obra)
        ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT fk_version_interprete FOREIGN KEY (id_interprete)
    REFERENCES interprete (id_interprete)
    ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT fk_version_director FOREIGN KEY (id_director)
    REFERENCES director(id_director)
    -- SE presentan dos opciones que valen segun el contexto
    -- ON DELETE RESTRICT ON UPDATE CASCADE
    ON DELETE SET NULL ON UPDATE CASCADE
    
    
);




