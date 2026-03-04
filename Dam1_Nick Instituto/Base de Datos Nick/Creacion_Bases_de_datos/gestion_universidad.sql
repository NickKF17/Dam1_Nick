
DROP DATABASE IF EXISTS gestion_universidad;
CREATE DATABASE gestion_universidad;
USE gestion_universidad;

CREATE TABLE facultades(
    id_facultad SMALLINT UNSIGNED AUTO_INCREMENT,
    codigo VARCHAR(4) NOT NULL Unique,
	nombre varchar(30) Not NUll unique,
    id_decano SmallInt unsigned default null,
    CONSTRAINT pk_facultad PRIMARY KEY (id_facultad),
    Constraint chk_longitud check (char_length(codigo)=4)
);

CREATE TABLE profesores(
    id_profesor SMALLINT UNSIGNED AUTO_INCREMENT,
    nif VARCHAR(9) NOT NULL Unique,
	nombre_completo varchar(30) Not NUll ,
    salario decimal(10,2) default 2000.00,
    id_facultad smallint unsigned ,
    CONSTRAINT pk_profesor PRIMARY KEY (id_profesor),
    Constraint chk_longitud_nif check (char_length(nif)=9),
    constraint chk_salario check (salario>0),
    constraint fk_profesor_facultad foreign key (id_facultad)
    references facultades(id_facultad)
);

alter table facultades
	add constraint fk_facultad_profesor foreign key (id_decano)
    references profesores(id_profesor)
;


CREATE TABLE asignaturas(
    id_asignatura SMALLINT UNSIGNED AUTO_INCREMENT,
    codigo_asig VARCHAR(10) NOT NULL Unique,
	nombre varchar(30) not null,
    creditos smallint default 6 ,
    CONSTRAINT pk_asignatura PRIMARY KEY (id_asignatura),
    Constraint chk_longitud_asignaturas check (char_length(codigo_asig)<=10),
    constraint chk_creditos check (creditos>=3)
);


CREATE TABLE grados(
   id_grado smallint auto_increment,
   nombre varchar(30) unique not null ,
   id_facultad smallint unsigned not null,
   
   constraint pk_grados primary key (id_grado),
   constraint fk_grado_facultad foreign key(id_facultad)
   references facultades(id_facultad)
);


CREATE TABLE imparten(
    id_profesor SMALLINT UNSIGNED ,
    id_asignatura smallint unsigned ,
	tipo_grupo Enum('TEORIA','PRACTICA') default 'TEORIA' ,
    CONSTRAINT pk_imparten PRIMARY KEY (id_profesor,id_asignatura),
    
    
    constraint fk_imparten_profesor foreign key (id_profesor)
    references profesores(id_profesor)
    on delete cascade,
    
    constraint fk_imparten_asignatura foreign key (id_asignatura)
    references asignaturas(id_asignatura)
    on delete cascade
);



-- 1. Facultades (primero, con decano NULL)
INSERT INTO facultades (codigo, nombre, id_decano) VALUES 
('F001', 'Facultad de Informática', NULL),
('F002', 'Facultad de Ciencias', NULL);

-- 2. Profesores (ahora que las facultades existen)
INSERT INTO profesores (nif, nombre_completo, salario, id_facultad) VALUES 
('12345678A', 'Dr. Alan Turing', 3500.00, 1),
('23456789B', 'Dra. Ada Lovelace', 3200.00, 1),
('34567890C', 'Dr. Isaac Newton', 3100.00, 2);

-- 3. Grados (ahora que id_facultad 1 y 2 existen en la tabla facultades)
INSERT INTO grados (nombre, id_facultad) VALUES 
('Grado en Software', 1),
('Grado en IA', 1),
('Grado en Física', 2);

-- 4. Asignaturas
INSERT INTO asignaturas (codigo_asig, nombre, creditos) VALUES 
('BD-01', 'Bases de Datos', 6),
('FIS-01', 'Física I', 6);

-- 5. Imparten (relación N:M)
INSERT INTO imparten (id_profesor, id_asignatura, tipo_grupo) VALUES 
(1, 1, 'TEORIA'),
(3, 2, 'TEORIA');

-- 6. Por último, actualizamos los Decanos
UPDATE facultades SET id_decano = 1 WHERE codigo = 'F001';
UPDATE facultades SET id_decano = 3 WHERE codigo = 'F002';


CREATE VIEW `v_cuadro_docente` AS
Select nombre_completo as profesor,nif as nif_profesor,asignaturas.nombre as asignatura,imparten.tipo_grupo as modalidad ,facultades.nombre as facultad_origen from profesores 
join imparten using (id_profesor)
join asignaturas using (id_asignatura)
join facultades using (id_facultad);

CREATE VIEW `v_resumen_facultades` AS
Select facultades.nombre as facultad , facultades.codigo as codigo_facultad, count(profesores.id_profesor) as num_profesores, sum(profesores.salario) as masa_salarial,round(avg(profesores.salario),2) from profesores
join facultades Using(id_facultad)
group by id_facultad;

Select * from v_cuadro_docente;
select * from v_resumen_facultades;