use gha_analytics;
 show tables;
 Select * from pacientes;
 explain pacientes;
 Start TRANSACTION;

SELECT * FROM pacientes;
-- ahora que ya no hay pedidos de los clientes duplicados, eliminamos esos clientes.
DELETE c2
FROM clientes c1 JOIN clientes c2 ON c1.email = c2.email
WHERE c2.id > c1.id;
select * from clientes;
Set sql_safe_updates=1;
COMMIT;