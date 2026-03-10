DROP DATABASE IF EXISTS erp_sostenibilidad; 
CREATE DATABASE erp_sostenibilidad;
USE erp_sostenibilidad;

CREATE TABLE huella_carbono (
    id INT AUTO_INCREMENT PRIMARY KEY,
    actividad VARCHAR(100),
    emisiones_co2 DECIMAL(10,2),
    fecha DATE
);

INSERT INTO huella_carbono (actividad, emisiones_co2, fecha) VALUES 
('Transporte Logístico', 450.50, '2024-03-10'),
('Consumo Eléctrico Oficina', 120.30, '2024-03-09');

-- 1. Crear los roles
DROP ROLE IF EXISTS 'rol_delegado_tecnico', 'rol_desarrollador', 'rol_auditor';
CREATE ROLE 'rol_delegado_tecnico', 'rol_desarrollador', 'rol_auditor';


-- 2. Asignar privilegios a los roles
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, ALTER ON erp_sostenibilidad.* TO 'rol_delegado_tecnico';
GRANT SELECT, INSERT, UPDATE, DELETE ON erp_sostenibilidad.* TO 'rol_desarrollador';
GRANT SELECT ON erp_sostenibilidad.* TO 'rol_auditor';


-- Crear Usuarios

-- Borrado de seguridad de los usuarios específicos
DROP user IF EXISTS  'root'@'localhost';
DROP USER IF EXISTS 'DelegadoTecnico(Daniel)'@'10.230.99.59';
DROP USER IF EXISTS 'Desarrollador(David)'@'10.230.99.169';
DROP USER IF EXISTS 'RolAuditor(Kevin)'@'10.230.98.238';

-- Es buena práctica ejecutar esto para refrescar los privilegios en el servidor
FLUSH PRIVILEGES;

CREATE USER 'root'@'localhost' IDENTIFIED BY 'root';
CREATE USER 'DelegadoTecnico(Daniel)'@'10.230.99.59' IDENTIFIED  BY '1234';
CREATE USER 'Desarrollador(David)'@'10.230.99.169' IDENTIFIED  BY '1234';
CREATE USER 'RolAuditor(Kevin)'@'10.230.98.238' IDENTIFIED BY '1234';

-- Asignar los roles
Grant all privileges on *.* TO 'root'@'localhost';
GRANT 'rol_delegado_tecnico' TO 'DelegadoTecnico(Daniel)'@'10.230.99.59';
GRANT 'rol_desarrollador' TO 'Desarrollador(David)'@'10.230.99.169';
GRANT 'rol_auditor' TO 'RolAuditor(Kevin)'@'10.230.98.238';

-- Definir el rol por defecto para que se active al conectar
SET DEFAULT ROLE ALL TO 'DelegadoTecnico(Daniel)'@'10.230.99.59', 'Desarrollador(David)'@'10.230.99.169', 'RolAuditor(Kevin)'@'10.230.98.238';

-- Ver usuarios y desde dónde pueden conectar
SELECT user, host, plugin FROM mysql.user;

-- Ver qué roles están asignados a qué usuarios
SELECT FROM_USER, FROM_HOST, TO_USER, TO_HOST FROM mysql.role_edges;

-- Ver permisos de los roles en las bases de datos
SELECT User, Host, Db, Select_priv, Insert_priv, Delete_priv FROM mysql.db WHERE Db = 'erp_sostenibilidad';

-- Revocar el permiso del ROL, no del usuario directamente
REVOKE DELETE ON erp_sostenibilidad.* FROM 'rol_desarrollador';