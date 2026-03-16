**Informe de Auditoria - Sistema Orbita**  
**Fecha:** 16 de marzo de 2026  
   
 **Proyecto:** Reconstruccion del Sistema Orbita (MySQL)  
   
 **Equipo:** Respuesta Rapida de Bases de Datos  
   
 **Auditor** **es** **:** Nick Constante, Daniel Rodriguez, Jhon Kevin, David Campanario  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AABAAsSPBCj7fFjsymJHAjAU2QtIq6DIzW7UHAMBfnGt1V8fXEwAAXrsexNkF4H1/HJoAAAAASUVORK5CYII=)  
   
**En la terminal**  
mysql -u root -p -e "SET GLOBAL local_infile = 1;"  
mysql -u root -p -e "SET GLOBAL max_allowed_packet = 1073741824;"  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AUBBAsUeCE4yeIiT9CRVMWGAjJK2CbjNzVGcAAPzF2qu7Wl9PAAB47XoA/vcF8exqpY4AAAAASUVORK5CYII=)  
**Base de datos TELEMETRÍA (Nick)**  
Para empezar ante la contradicción del pdf de la creación de la base de datos telemetría en la que te pedia 8 pero tan solo te proporcionaba información de 6 he decidido añadir las tablas de activos y contenedores para cumplir estrictamente con el volumen de 8 tablas especificado en el Anexo y para dar soporte legal a las claves foráneas (FK) que el documento exige en las áreas de Tracking e IoT, garantizando así la integridad referencial del sistema.  
   
Por otro lado el script original presentaba discrepancias críticas respecto al Anexo Técnico, principalmente en la validación del esquema JSON, donde se omitió el campo opcional alerts y no se verificaban los tipos de datos numéricos para las lecturas de temperatura y humedad exigidas. Asimismo, existía una falta de uniformidad geográfica al mezclar el uso de tipos DECIMAL con el tipo espacial POINT, el cual no estaba solicitado y dificultaba la coherencia en la ingesta masiva de datos. También se identificaron desviaciones en la precisión de los formatos, utilizando VARCHAR para identificadores que debían seguir patrones rígidos como NODE-0000 o ALR-XXX, lo que permitía registros inconsistentes con el estándar definido.  
Siguiendo con los errores encontrados en la ia, el planteamiento inicial incluía campos y tablas excedentes que no figuraban en el diccionario de datos oficial, como variables climáticas adicionales (viento, visibilidad) y estados de red (tipo de conexión, mantenimiento), alejándose del diseño estricto. El uso de triggers para la validación lógica representaba un error de arquitectura para un entorno de alta frecuencia, por lo que se corrigió integrando CHECK constraints directamente en la estructura de las tablas para optimizar el rendimiento de inserción. Finalmente, se eliminaron dependencias a tablas no definidas, como el caso de las misiones, asegurando que el esquema final de 8 tablas sea una implementación fiel y funcional de los requerimientos.  
   
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANklEQVR4nO3OQQmAABRAsSfYxZo/khWsYQLPJrCCNxG2BFtmZquOAAD4i3Ot7mr/egIAwGvXA4qjBdKlX6OKAAAAAElFTkSuQmCC)  
**Base de datos 04_orbita_documental (Daniel)**  
En el documento exige un repositorio legan inmutable donde los registros deben quedar null pero no eliminarse para cumplir el requisito, para que se pueda cumplir ese requisito es necesario el uso de triggers.  
En la tablas ‘doc_manifiestos’, ‘doc_declaraciones_dua’, ‘doc_contratos_firmados’, ‘doc_polizas_seguros’, ‘doc_versiones’ el campo ‘hash_sha256’ permite valores null, la solución es poner un NOT NULL a los campos que lo permiten.  
Las claves foráneas estaban todas mal y la solución es crear ALTER TABLE para cada tabla que una clave foranea con las definiciones completas.  
La función para calcular hash estaba mal, tenia como resultado un RETURN NULL y no se permite eso, la solución es un RETURN SHA2(contenido, 256)  
-    
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAAM0lEQVR4nO3OMQ0AIAwAwdIgBKl1gjacsGCAiZDcTT9+q6oRETMAAPjF6ify6QYAADdyA9Y0AypN+bdfAAAAAElFTkSuQmCC)  
**Rechazo #2: Uso de VARCHAR sin Restricciones para Codigos ISO**  
**Propuesta de IA:**  
-- IA sugirio VARCHAR generico sin validacion  
 CREATE TABLE geo_paises (  
     codigo_iso_pais VARCHAR(2) PRIMARY KEY,  
     ...  
 );  
   
**Problema Identificado:**  
   
 La IA propuso usar VARCHAR(2) sin ninguna restriccion de formato. Esto permite codigos como "es", "us", "12" que violan el estandar ISO 3166-1 alpha-2 (debe ser exactamente 2 letras mayusculas).  
**Decision de Auditoria:** ❌ RECHAZADO  
**Solucion Implementada:**  
CREATE TABLE geo_paises (  
     codigo_iso_pais CHAR(2) PRIMARY KEY,  
     ...  
     CONSTRAINT chk_codigo_pais CHECK (codigo_iso_pais REGEXP '^[A-Z]{2}$')  
 );  
   
**Justificacion Tecnica:**  
- CHAR(2) es mas eficiente que VARCHAR(2) para longitud fija  
- La restriccion CHECK garantiza formato ISO correcto  
- Previene errores de integridad en claves foraneas transversales  
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AABAAsSPBCj7fFjsymJHAjAU2QtIq6DIzW7UHAMBfnGt1V8fXEwAAXrsexNkF4H1/HJoAAAAASUVORK5CYII=)  
En las validaciones del hash comprueba si el valor es nulo pero al haberlo cambiado a NOT NULL no se permiten valores null lo cual hace que sea un código muerto, la solución es borrar el parámetro IS NULL.  
   
De acuerdo con la metodología AI-Driven Audit, se documentan los tres errores más graves propuestos por la IA que habrían invalidado el despliegue:  
   
Error 1: Sintaxis Fatal en cat_servicios (Violación de "Error Zero") * Propuesta de la IA: La tabla cat_servicios incluía una coma sobrante tras la definición de descripcion_comercial TEXT, antes del cierre del paréntesis.  
   
Riesgo: El script fallaría inmediatamente al ejecutarse por terminal, deteniendo todo el proceso de recuperación de emergencia.  
   
Acción: Se eliminó la coma redundante y se normalizó la estructura del DDL.  
   
Error 2: Integridad Referencial Fantasma en ent_clientes * Propuesta de la IA: Se definió la columna id_agente_principal_fk dentro de ent_clientes, pero la IA olvidó declarar el CONSTRAINT FOREIGN KEY hacia la tabla adu_agentes.  
   
Riesgo: Inconsistencia de datos. Se podrían asignar agentes inexistentes a clientes VIP, rompiendo la trazabilidad legal del sistema comercial.  
   
Acción: Se debe añadir manualmente la restricción FOREIGN KEY (id_agente_principal_fk) REFERENCES adu_agentes(id_agente).  
   
Error 3: Restricción Lógica Absurda (CHECK semántico) * Propuesta de la IA: En ent_clientes, se añadió CONSTRAINT chk_jerarquia_cliente CHECK (id_cliente != id_matriz_fk).  
   
Riesgo: Error de diseño lógico grave. Compara un ID de la tabla actual (ent_clientes) con un ID de otra tabla (ent_matrices). Al ser ambos autoincrementales independientes, es probable que coincidan numéricamente por azar, bloqueando inserciones válidas sin motivo técnico.  
   
Acción: Rechazar y eliminar este CHECK. La integridad ya está garantizada por la FK hacia ent_matrices.  
-    
![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAnEAAAACCAYAAAA3pIp+AAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAANUlEQVR4nO3OMQ2AABAAsSPBCj5fFyM6mJHAjAU2QtIq6DIzW7UHAMBfnGt1V8fXEwAAXrsexOEF35f1aEgAAAAASUVORK5CYII=)  
**Base de datos 02_orbita_flota (kevin)**  
   
En la tabla de act_aviones, se cambio la relacion entre hangares y aviones con “Set null”   
Para cumplir con el “Error Zero”, para no causar perdidas de datos criticos.   
En la tabla mis_asignaciones_activos, se aplico el borrado de Cascade. Porque una asignación no tiene que existir si no existe una misión. Con Cascade se realiza una limpieza del esquema, con una base de datos mas optimizadas   
En la tabla de mnt_ordenes. Se puso el Set null, para garantizar la persistencia del historial técnico de la flota, ya que no se busca perder datos de desaparición de todas las ordenes de trabajo.  
   
