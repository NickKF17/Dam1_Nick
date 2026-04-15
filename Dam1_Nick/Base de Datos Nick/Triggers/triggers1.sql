use sakila;

# Drop procedure saludo;

DELIMITER // 
#Las // son los caracteres que encierran un bloque de codigo, pueden ser lo que quieras. Abro bloque de codigo
CREATE PROCEDURE saludo()
BEGIN
	Select 'Hola clase de Dam' as mensaje1;
    Select 'Hola clase de Dam (1)' as mensaje2;
    Select 'Hola clase de Dam (2)' as mensaje3;
END // 
# Cierro bloque de codigo
DELIMITER ; 
# Cierro el delimitador

call sakila.saludo();

Delimiter //
CReate procedure buscar_actor(IN p_apellido varchar(45))
begin
	select first_name,last_name from actor
    where last_name LIKE concat(p_apellido,'%');
    END // 
    
DELIMITER ; 

call buscar_actor('Jackson');

Delimiter //
CReate procedure contar_peliculas(out p_total int)
begin
	select count(*) into p_total from film;
    END // 
    
DELIMITER ; 

call contar_peliculas(@resultado);
select @resultado;

DELIMITER $$
CREATE  PROCEDURE `film_in_stock`(IN p_film_id INT, IN p_store_id INT, OUT p_film_count INT)
    READS SQL DATA
BEGIN
     SELECT inventory_id
     FROM inventory
     WHERE film_id = p_film_id
     AND store_id = p_store_id
     AND inventory_in_stock(inventory_id);

     SELECT COUNT(*)
     FROM inventory
     WHERE film_id = p_film_id
     AND store_id = p_store_id
     AND inventory_in_stock(inventory_id)
     INTO p_film_count;
END$$
DELIMITER ;

call sakila.film_in_stock(15,2,@resultado);


Delimiter //
CReate function calcular_iva(p_precio DEcimal(10,2))
Returns decimal(10,2) deterministic
begin
	return p_precio*1.21;
    END // 
    
DELIMITER ; 

select calcular_iva(amount) from payment;


DELIMITER $$
CREATE FUNCTION `inventory_in_stock`(p_inventory_id INT) RETURNS tinyint(1)
    READS SQL DATA
BEGIN
    DECLARE v_rentals INT;
    DECLARE v_out     INT;

    
    

    SELECT COUNT(*) INTO v_rentals
    FROM rental
    WHERE inventory_id = p_inventory_id;

    IF v_rentals = 0 THEN
      RETURN TRUE;
    END IF;

    SELECT COUNT(rental_id) INTO v_out
    FROM inventory LEFT JOIN rental USING(inventory_id)
    WHERE inventory.inventory_id = p_inventory_id
    AND rental.return_date IS NULL;

    IF v_out > 0 THEN
      RETURN FALSE;
    ELSE
      RETURN TRUE;
    END IF;
END$$
DELIMITER ;

#Cuantos inventorys hay en cada tienda

select store_id,count(inventory_id) as num_stock
from inventory
join store using (store_id)
where inventory_in_stock(inventory_id)
group by store_id;



#Parecidos
# Estructura muy similar
# Se puede hacer casi lo mismo en las dos
# Puedes meter varios parametros en los dos

#Diferencias
# La forma de ejecutarlos o usarlos
# Las function pueden tener 1 output mientras que el procedimiento 0 o varios
# Las function necesitan saber si son determinist mientras que los procedimientos no, por la forma en la que se usan por dentro