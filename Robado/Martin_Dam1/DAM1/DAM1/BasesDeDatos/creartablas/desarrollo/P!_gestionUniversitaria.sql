DROP DATABASE IF EXISTS gestion_universitaria;
CREATE DATABASE gestion_universitaria;
USE gestion_universitaria;

CREATE TABLE facultades(
	id_facultad SMALLINT UNSIGNED AUTO_INCREMENT,
    codigo CHAR(4) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    id_decano INT UNSIGNED DEFAULT NULL,
    CONSTRAINT pk_facultades PRIMARY KEY(id_facultad),
    CONSTRAINT uq_codigo UNIQUE (codigo),
    CONSTRAINT uq_nombre UNIQUE (nombre)
);

CREATE TABLE profesores(
	id_profesor INT UNSIGNED,
    nif VARCHAR(9) NOT NULL,
    nombre_completo VARCHAR(60) NOT NULL,
    salario DECIMAL(10,2) DEFAULT 2000.00,
    id_facultad SMALLINT UNSIGNED NOT NULL,
    CONSTRAINT pk_profesores PRIMARY KEY(id_profesor),
    CONSTRAINT fk_profesores_facultades FOREIGN KEY (id_facultad)
		REFERENCES facultades (id_facultad)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT uq_nif UNIQUE(nif),
    CONSTRAINT chk_nif_comprobacion CHECK(REGEXP_LIKE(nif, '^[0-9]{8}[A-Z]{1}$')),
    CONSTRAINT chk_salario_pos CHECK(salario>0)
    
);

ALTER TABLE facultades
	ADD CONSTRAINT fk_facultades_profesores FOREIGN KEY(id_decano)
		REFERENCES profesores(id_profesor)
        ON DELETE SET NULL ON UPDATE CASCADE;
        
CREATE TABLE grados(
	id_grado INT UNSIGNED AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    id_facultad SMALLINT UNSIGNED NOT NULL,
	CONSTRAINT pk_grados PRIMARY KEY (id_grado),
    CONSTRAINT fk_grados_facultades FOREIGN KEY (id_facultad)
		REFERENCES facultades(id_facultad)
        ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT uq_nombre UNIQUE(nombre)
);

CREATE TABLE asignaturas(
	id_asignatura INT UNSIGNED AUTO_INCREMENT,
    codigo_asig VARCHAR(10) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    creditos SMALLINT UNSIGNED DEFAULT 6,
    CONSTRAINT pk_asignaturas PRIMARY KEY(id_asignatura),
    CONSTRAINT uq_codigo_asig UNIQUE(codigo_asig),
    CONSTRAINT chk_creditos CHECK(creditos >= 3)
);
CREATE TABLE imparten(
	id_profesor INT UNSIGNED,
    id_asignatura INT UNSIGNED,
    tipo_grupo ENUM('TEORIA','PRACTICA') DEFAULT 'TEORIA',
    CONSTRAINT pk_imparten PRIMARY KEY (id_profesor, id_asignatura),
    CONSTRAINT fk_imparten_profesores FOREIGN KEY(id_profesor)
		REFERENCES profesores(id_profesor)
        ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT fk_imparten_asignaturas FOREIGN KEY(id_asignatura)
		REFERENCES asignaturas(id_asignatura)
        ON DELETE CASCADE ON UPDATE CASCADE
        
);

CREATE VIEW v_cuadro_docente AS
    SELECT 
        profesores.nombre_completo AS profesor,
        profesores.nif AS nif_profesor,
        asignaturas.nombre AS asignatura,
        imparten.tipo_grupo AS modalidad,
        facultades.nombre AS facultad_origen
    FROM
        profesores
            JOIN
        imparten USING (id_profesor)
            JOIN
        asignaturas USING (id_asignatura)
            JOIN
        facultades USING (id_facultad);

CREATE VIEW v_resumen_facultades AS
	SELECT
		facultades.nombre AS facultad,
        facultades.codigo AS codigo_facultad,
        COUNT(profesores.id_facultad) as num_profesores,
        SUM(profesores.salario) as masa_salarial,
        ROUND(AVG(profesores.salario), 2) as salario_medio
        from
			facultades
		JOIN 
			profesores USING (id_facultad)
		GROUP BY id_facultad;
        
USE gestion_universitaria;

-- 1. Insertamos Facultades primero (con id_decano en NULL para evitar errores de FK)
INSERT INTO facultades (codigo, nombre, id_decano) VALUES
('FING', 'Facultad de Ingeniería', NULL),
('FCE', 'Facultad de Ciencias Económicas', NULL),
('FDER', 'Facultad de Derecho', NULL),
('FMED', 'Facultad de Medicina', NULL);

-- 2. Insertamos Profesores (cumpliendo el formato de NIF: 8 números + 1 letra)
INSERT INTO profesores (id_profesor, nif, nombre_completo, salario, id_facultad) VALUES
(101, '12345678A', 'Dr. Alan Turing', 3500.00, 1),
(102, '23456789B', 'Dra. Ada Lovelace', 3200.00, 1),
(201, '34567890C', 'Lic. Adam Smith', 2800.00, 2),
(202, '45678901D', 'Dra. Elinor Ostrom', 3100.00, 2),
(301, '56789012E', 'Dr. Hans Kelsen', 2950.00, 3),
(401, '67890123F', 'Dr. René Favaloro', 4000.00, 4);

-- 3. Ahora que los profesores existen, asignamos los Decanos a las facultades
UPDATE facultades SET id_decano = 101 WHERE codigo = 'FING';
UPDATE facultades SET id_decano = 202 WHERE codigo = 'FCE';
UPDATE facultades SET id_decano = 301 WHERE codigo = 'FDER';
UPDATE facultades SET id_decano = 401 WHERE codigo = 'FMED';

-- 4. Insertamos Grados
INSERT INTO grados (nombre, id_facultad) VALUES
('Ingeniería en Sistemas', 1),
('Ingeniería Electrónica', 1),
('Licenciatura en Economía', 2),
('Abogacía', 3),
('Medicina', 4);

-- 5. Insertamos Asignaturas
INSERT INTO asignaturas (codigo_asig, nombre, creditos) VALUES
('ALG01', 'Álgebra Lineal', 6),
('PROG02', 'Programación I', 8),
('ECON01', 'Microeconomía I', 6),
('DER01', 'Derecho Romano', 4),
('ANAT01', 'Anatomía Humana', 10);

-- 6. Relacionamos Profesores con Asignaturas (Tabla Imparten)
INSERT INTO imparten (id_profesor, id_asignatura, tipo_grupo) VALUES
(101, 1, 'TEORIA'),
(101, 2, 'PRACTICA'),
(102, 2, 'TEORIA'),
(201, 3, 'TEORIA'),
(202, 3, 'PRACTICA'),
(301, 4, 'TEORIA'),
(401, 5, 'TEORIA');


select * from v_cuadro_docente;
select * from v_resumen_facultades;
