Drop Database if exists obras_musicales;
Create database obras_musicales;
use obras_musicales;



CREATE TABLE compositor (
	   id_compositor SMALLINT UNSIGNED,
    nombre VARCHAR(50) NOT NULL,
    año_nacimiento int,
    nacionalidad CHAR(4), -- esto es una chapuza
    CONSTRAINT pk_id_compositor PRIMARY KEY (id_compositor)
);

CREATE TABLE director (
    id_director SMALLINT UNSIGNED,
    nombre VARCHAR(50) NOT NULL,
    año_nacimiento int,
    nacionalidad CHAR(4), -- esto es una chapuza
    CONSTRAINT pk_id_director PRIMARY KEY (id_director),
    constraint uq_director_nombre UNIQUE(nombre),
    constraint nombre_not_null CHECK(nombre is not null) 
);

CREATE TABLE interprete (
    id_interprete SMALLINT UNSIGNED,
    nombre VARCHAR(50) NOT NULL,
    año_nacimiento int,
    nacionalidad CHAR(4), -- esto es una chapuza
    CONSTRAINT pk_id_interprete PRIMARY KEY (id_interprete)
);

CREATE table obra( 
id_obra Smallint unsigned,
titulo varchar(50) not null,
tipo varchar(25),
modo varchar(25),
tono ENUM("domayor","domenor","do#mayor","do#menor"),
constraint pk_obra primary key(id_obra),
compositor SMALLINT unsigned,
constraint fk_obra_compositor foreign key(compositor)
    References compositor(id_compositor)
    on delete set null on update cascade
);

create table version (
id_version mediumint unsigned, -- como lleva un constraint de pk no hace falta indicar not null ni unique 
id_obra smallint unsigned,
id_interprete smallint unsigned,
id_director smallint unsigned,
-- id_version Smallint unsigned es un error de diseño ya que deberia ser mas grande que el id de obras --
constraint pk_version primary key(id_obra,id_interprete,id_director),
constraint fk_version_obra foreign key (id_obra)
references obra(id_obra)
on delete restrict on update cascade, -- por defecto lo normal --
constraint fk_version_interprete foreign key(id_interprete)
references interprete(id_interprete)
on delete restrict on update cascade,
constraint fk_version_director foreign key(id_director)
references director(id_director)
 on delete restrict on update cascade
);


