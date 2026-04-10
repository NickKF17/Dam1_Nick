use ejemplos_tipos_join;
show tables;
select * from alumnos;
select * from cursos;
select * from matriculas;


SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
INNER JOIN matriculas m
ON m.id_alumno = a.id_alumno
ORDER BY a.id_alumno, m.id_matricula;

SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
LEFT JOIN matriculas m
ON m.id_alumno = a.id_alumno
ORDER BY a.id_alumno, m.id_matricula;

SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
RIGHT JOIN matriculas m
ON m.id_alumno = a.id_alumno
ORDER BY m.id_matricula;

SELECT alumno.id_alumno, alumno.nombre, matricula.id_matricula, matricula.id_curso
FROM alumnos a
LEFT JOIN matriculas m
ON m.id_alumno = a.id_alumno
UNION
SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
RIGHT JOIN matriculas m
ON m.id_alumno = a.id_alumno
WHERE a.id_alumno IS NULL
ORDER BY 1 IS NULL, a.id_alumno, m.id_matricula;

SELECT m.id_matricula,
a.nombre AS alumno,
c.nombre_curso AS curso
FROM matriculas m
LEFT JOIN alumnos a ON a.id_alumno = m.id_alumno
LEFT JOIN cursos c ON c.id_curso = m.id_curso
ORDER BY m.id_matricula;

-- 2. cosa


SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
LEFT JOIN matriculas m
ON m.id_alumno = a.id_alumno


UNION

SELECT a.id_alumno, a.nombre, m.id_matricula, m.id_curso
FROM alumnos a
RIGHT JOIN matriculas m
ON m.id_alumno = a.id_alumno
WHERE a.id_alumno IS NULL
ORDER by id_alumno, id_matricula;
-- 3. Matrículas sin alumno
  Select id_matricula, id_alumno, id_curso
  from alumnos 
  right join matriculas using(id_alumno)
  where alumnos.id_alumno is null;
  
  select * from cursos;
  select * from matriculas;
  
  select id_curso, nombre_curso
  from cursos
  left join matriculas using(id_curso)
  where id_matricula is null;
  
  select * from alumnos;
  
  SELECT 
    id_alumno, nombre, id_matricula, id_curso
FROM
    alumnos
        LEFT JOIN
    matriculas USING (id_alumno) 
UNION SELECT 
    id_alumno, nombre, id_matricula, id_curso
FROM
    alumnos
        RIGHT JOIN
    matriculas USING (id_alumno);
  
  -- Listado de alumnos con sus id_curso (sólo emparejados).
  SELECT 
    a.id_alumno, a.nombre, m.id_curso
FROM
    alumnos a
        INNER JOIN
    matriculas m ON m.id_alumno = a.id_alumno
ORDER BY a.id_alumno , m.id_curso;
  -- Alumnos sin ninguna matrícula (anti-join).
  SELECT 
    a.id_alumno, a.nombre
FROM
    alumnos a
        LEFT JOIN
    matriculas m ON m.id_alumno = a.id_alumno
WHERE
    m.id_matricula IS NULL
ORDER BY a.id_alumno;

  -- Matrículas sin alumno (huérfanas).
   SELECT 
    id_matricula, id_alumno, id_curso
FROM
    alumnos
        RIGHT JOIN
    matriculas USING (id_alumno)
WHERE
    alumnos.id_alumno IS NULL;
  -- Cursos del catálogo sin ninguna matrícula.
    SELECT 
    id_curso, nombre_curso
FROM
    cursos
        LEFT JOIN
    matriculas USING (id_curso)
WHERE
    id_matricula IS NULL;
  -- Número de matrículas por alumno (incluye 0).  
  SELECT 
    id_alumno, nombre, COUNT(id_matricula) AS matriculas
FROM
    alumnos
        LEFT JOIN
    matriculas USING (id_alumno)
GROUP BY id_alumno;
  
  -- Alumnos con más de un curso.
  SELECT 
    id_alumno, nombre, COUNT(id_matricula) AS n
FROM
    alumnos
        LEFT JOIN
    matriculas USING (id_alumno)
GROUP BY id_alumno
HAVING n > 1;

  -- FULL OUTER JOIN emulado (alumnos y sus matrículas, incluyendo huérfanas).
   SELECT 
    id_alumno, nombre, id_matricula, id_curso
FROM
    alumnos
        LEFT JOIN
    matriculas USING (id_alumno) 
UNION SELECT 
    id_alumno, nombre, id_matricula, id_curso
FROM
    alumnos
        RIGHT JOIN
    matriculas USING (id_alumno);
  
  -- Para cada curso del catálogo, número de alumnos con matrícula válida (alumno y curso existen).
  SELECT 
    id_curso, nombre_curso, COUNT(id_alumno) AS num_alumnos
FROM
    cursos
        LEFT JOIN
    matriculas USING (id_curso)
        LEFT JOIN
    alumnos USING (id_alumno)
GROUP BY id_curso;