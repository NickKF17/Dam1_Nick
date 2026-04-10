-- Consulta 18 de TiendaOnline
use tienda_online;
SELECT DISTINCT
    (id_producto) AS id_producto, nombre, precio
FROM
    productos
        LEFT JOIN
    detalle_pedido USING (id_producto)
WHERE
    id_producto IS NULL
ORDER BY nombre ASC;


-- Consultas en Sakila
use sakila;
-- Consulta 1: Clientes con al menos un alquiler
SELECT distinct(customer_id), concat(first_name,' ',last_name) as customers_name FROM customer left join rental using(customer_id)
where rental_id is not null;

-- Consulta 2: Todos los clientes y sus alquileres
select customer_id, concat(first_name,' ', last_name) as customers_name, count(rental_id) as number_rentals
from rental
right join customer using(customer_id)
group by customer_id;

-- Consulta 3: Actores y sus películas
SELECT 
    actor_id,
    CONCAT(first_name, ' ', last_name) AS actors_name,
    title
FROM
    actor
        LEFT JOIN
    film_actor USING (actor_id)
        LEFT JOIN
    film USING (film_id);
/*No se pone un "distinct(actor_id)" porque no se considera que se repita el actor */

-- Consulta 4: Categorías y películas
SELECT 
    category_id, name, title
FROM
    film
        RIGHT JOIN
    film_category USING (film_id)
        RIGHT JOIN
    category USING (category_id) 
UNION SELECT 
    category_id, name, title
FROM
    film
        LEFT JOIN
    film_category USING (film_id)
        LEFT JOIN
    category USING (category_id);


-- Consulta 5: Películas y sus actores
SELECT 
    film_id,
    title,
    actor_id,
    CONCAT(first_name, ' ', last_name) AS actors_name
FROM
    film
        LEFT JOIN
    film_actor USING (film_id)
        LEFT JOIN
    actor USING (actor_id);
