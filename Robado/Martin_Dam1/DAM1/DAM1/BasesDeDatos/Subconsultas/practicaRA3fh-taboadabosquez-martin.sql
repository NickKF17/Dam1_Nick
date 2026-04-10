use sakila;

-- 1) Película(s) más larga(s) por categoría

SELECT 
    c.name, f.title, f.length
FROM
    film AS f
        JOIN
    film_category USING (film_id)
        JOIN
    category AS c USING (category_id)
WHERE
    f.length = (SELECT 
            MAX(f2.length)
        FROM
            film AS f2
            join film_category as fc2 using(film_id)
            join category as c2 using(category_id)
            where fc2.category_id=c.category_id);

	
-- 2) Número de películas sin stock disponible en ninguna tienda

	select * from film as f where not exists(select 1 from inventory as i where i.film_id=f.film_id);
    SELECT 
    COUNT(film_id) AS num_unvailable_films
FROM
    film AS f
WHERE
    NOT EXISTS( SELECT 
            1
        FROM
            inventory AS i
        WHERE
            i.film_id = f.film_id);
            
-- 3) Recaudación mensual por categoría en 2024
select * from payment;
 SELECT 
    t.category, t.month, SUM(t.amount) as total
FROM
    (SELECT 
        c.name AS category, MONTH(p.payment_date) AS month, p.amount as amount
    FROM
        category AS c
    JOIN film_category USING (category_id)
    join film using(film_id)
    join inventory using(film_id)
	join rental using(inventory_id)
    join payment as p using(rental_id) where year(p.payment_date)=2024) as t 
    group by t.category, t.month order by t.category, t.month; 

 
-- 4) Clientes con alquileres pero sin pagos registrados
SELECT 
    c.customer_id,
    CONCAT(c.first_name, ' ', last_name) AS customer
FROM
    customer AS c
WHERE
    EXISTS( SELECT 
            1
        FROM
            rental AS r
        WHERE
            r.customer_id = c.customer_id)
        AND NOT EXISTS( SELECT 
            1
        FROM
            payment AS p
        WHERE
            p.customer_id = c.customer_id);
            
-- 5) Cliente(s) que más ha(n) gastado en cada país
    
    SELECT
    t.country,
    CONCAT(t.first_name, ' ', t.last_name) AS top_customer,
    t.total_spent AS max_spent
FROM (
    SELECT
        co.country,
        co.country_id,
        c.customer_id,
        c.first_name,
        c.last_name,
        SUM(p.amount) AS total_spent
    FROM payment as p
    JOIN customer as c ON c.customer_id = p.customer_id
    JOIN address as  a ON a.address_id = c.address_id
    JOIN city as ci ON ci.city_id = a.city_id
    JOIN country as co ON co.country_id = ci.country_id
    GROUP BY co.country_id, co.country, c.customer_id
) as t
JOIN (
    SELECT
        country_id,
        MAX(total_spent) AS max_spent
    FROM (
        SELECT
            co.country_id,
            SUM(p.amount) AS total_spent
        FROM payment p
        JOIN customer c ON c.customer_id = p.customer_id
        JOIN address a ON a.address_id = c.address_id
        JOIN city ci ON ci.city_id = a.city_id
        JOIN country co ON co.country_id = ci.country_id
        GROUP BY co.country_id, c.customer_id
    ) as x
    GROUP BY country_id
) as m
ON m.country_id = t.country_id
AND m.max_spent = t.total_spent
ORDER BY t.country ASC;
    
-- 6) Categorías con ingresos superiores a la media global
	SELECT
    c.name AS category,
    SUM(p.amount) AS total_revenue
FROM category as c
JOIN film_category as fc ON fc.category_id = c.category_id
JOIN inventory as i ON i.film_id = fc.film_id
JOIN rental as r ON r.inventory_id = i.inventory_id
JOIN payment as p ON p.rental_id = r.rental_id
GROUP BY c.category_id, c.name
HAVING SUM(p.amount) > (
    SELECT AVG(category_revenue)
    FROM (
        SELECT
            SUM(p2.amount) AS category_revenue
        FROM category as c2
        JOIN film_category as fc2 ON fc2.category_id = c2.category_id
        JOIN inventory as i2 ON i2.film_id = fc2.film_id
        JOIN rental as r2 ON r2.inventory_id = i2.inventory_id
        JOIN payment as p2 ON p2.rental_id = r2.rental_id
        GROUP BY c2.category_id
    ) t
)
ORDER BY total_revenue DESC;