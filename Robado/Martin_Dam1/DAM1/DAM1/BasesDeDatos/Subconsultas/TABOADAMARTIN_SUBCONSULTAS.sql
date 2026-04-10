use sakila;

SELECT 
    title
FROM
    film
WHERE
    language_id = (SELECT 
            language_id
        FROM
            language
        WHERE
            name = 'English');

SELECT 
    title
FROM
    film
WHERE
    length > (SELECT 
            AVG(length)
        FROM
            film);
            
		
        
SELECT 
    first_name, last_name
FROM
    actor
WHERE
    actor_id IN (SELECT 
            actor_id
        FROM
            film_actor
        WHERE
            film_id = (SELECT 
                    film_id
                FROM
                    film
                WHERE
                    title = 'ALONE TRIP'));
                    
                    


SELECT 
    title, length
FROM
    film
WHERE
    length > ANY (SELECT 
            length
        FROM
            film
        WHERE
            film_id IN (SELECT 
                    film_id
                FROM
                    film_category
                WHERE
                    category_id = (SELECT 
                            category_id
                        FROM
                            category
                        WHERE
                            name = 'sports')));
                            
                            
                            


SELECT 
    title, length
FROM
    film
WHERE
    length > ALL (SELECT 
            length
        FROM
            film
        WHERE
            film_id IN (SELECT 
                    film_id
                FROM
                    film_category
                WHERE
                    category_id = (SELECT 
                            category_id
                        FROM
                            category
                        WHERE
                            name = 'sports')));
                            
                            
					
SELECT 
    first_name, last_name
FROM
    customer AS c
WHERE
    EXISTS( SELECT 
            1
        FROM
            rental AS r
        WHERE
            r.customer_id = c.customer_id);
            
            
            

SELECT 
    title
FROM
    film
WHERE
    NOT EXISTS( SELECT 
            1
        FROM
            inventory
                JOIN
            rental USING (inventory_id)
        WHERE
            inventory.film_id = film.film_id);
            
            
            
		

SELECT 
    title
FROM
    film
WHERE
    film_id IN (SELECT 
            film_id
        FROM
            film_category
        WHERE
            category_id = (SELECT 
                    category_id
                FROM
                    category
                WHERE
                    name = 'children'));
                    
                    



-- Select
SELECT 
    title,
    (SELECT 
            COUNT(*)
        FROM
            rental
                JOIN
            inventory USING (inventory_id)
        WHERE
            inventory.film_id = film.film_id) AS total_rentals
FROM
    film;
    
    
SELECT 
    first_name,
    last_name,
    (SELECT 
            SUM(amount)
        FROM
            payment
        WHERE
            customer.customer_id = payment.customer_id) AS total_amount
FROM
    customer;



SELECT 
    name, film_counts
FROM
    (SELECT 
        category_id, COUNT(film_id) AS film_counts
    FROM
        film_category
    GROUP BY category_id) AS category_counts
        JOIN
    category USING (category_id)
WHERE
    category_counts.film_counts > (SELECT 
            AVG(film_counts)
        FROM
            (SELECT 
                category_id, COUNT(film_id) AS film_counts
            FROM
                film_category
            GROUP BY category_id) as category_counts2);
            
            
-- 2.1 
	-- Peliculas de la categoría "Children"
SELECT 
    film_id, title
FROM
    film
        JOIN
    film_category USING (film_id)
WHERE
    category_id = (SELECT 
            category_id
        FROM
            category
        WHERE
            name = 'Children');

	-- Películas nunca alquiladas
Select film_id, title from film as f1;


SELECT 
    f.film_id, f.title
FROM
    film AS f
WHERE
    NOT EXISTS( SELECT 
            1
        FROM
            inventory AS i
                JOIN
            rental USING (inventory_id)
        WHERE
            f.film_id = i.film_id);



SELECT 
    actor_id, first_name, last_name
FROM
    actor
WHERE
    EXISTS( SELECT 
            1
        FROM
            film_actor
                JOIN
            film USING (film_id)
        WHERE
            length > 120
                AND film_actor.actor_id = actor.actor_id);

-- 4 
	-- Ejercicio 1
    SELECT 
    film_id, title, length
FROM
    film
WHERE
    length > (SELECT 
            AVG(length)
        FROM
            film);
	-- Ejercicio 2
    SELECT 
    actor_id, CONCAT(first_name, ' ', last_name) AS actor
FROM
    actor
WHERE
    EXISTS( SELECT 
            1
        FROM
            film_actor
                JOIN
            film USING (film_id)
                JOIN
            film_category USING (film_id)
        WHERE
            category_id = (SELECT 
                    category_id
                FROM
                    category
                WHERE
                    name = 'Action')
                AND film_actor.actor_id = actor.actor_id)
        AND EXISTS( SELECT 
            1
        FROM
            film_actor
                JOIN
            film_category USING (film_id)
                JOIN
            category USING (category_id)
        WHERE
            name = 'Comedy'
                AND film_actor.actor_id = actor.actor_id)
ORDER BY actor.last_name , actor.first_name;
	-- Ejercicio 3
    SELECT 
    c.customer_id, c.first_name, c.last_name
FROM
    customer AS c
        JOIN
    (SELECT 
        r.customer_id, COUNT(*) AS rentals
    FROM
        rental AS r
    GROUP BY r.customer_id) AS t ON t.customer_id = c.customer_id
    where t.rentals= (SELECT 
    MAX(x.rentals)
FROM
    (SELECT 
        r2.customer_id, COUNT(*) AS rentals
    FROM
        rental AS r2
    GROUP BY r2.customer_id) AS x);
    
    -- Ejercicio 4: categoría Sports
    SELECT 
    f.title
FROM
    film AS f
        JOIN
    film_category AS fc USING (film_id)
        JOIN
    category AS c USING (category_id)
WHERE
    c.name = 'SPORTS'
        AND NOT EXISTS( SELECT 
            *
        FROM
            inventory AS i
                JOIN
            rental AS r USING (inventory_id)
        WHERE
            f.film_id = i.film_id
                AND YEAR(r.rental_date) = 2005);
    
    
-- 5 EJERCICIOS RESUELTOS
	-- 1. Derivada -Peliculas por idioma
    SELECT 
    l.language_id, l.name, t.films_in_language
FROM
    (SELECT 
        f.language_id, COUNT(*) AS films_in_language
    FROM
        film AS f
    GROUP BY f.language_id) AS t
    join language as l on t.language_id=l.language_id
    order by t.films_in_language desc, l.name;
    
    -- 2. Derivada -Idiomas con longitud media superior a 110 minutos
    SELECT 
    l.language_id, l.name AS language_name, s.avg_length
FROM
    (SELECT 
        f.language_id, AVG(f.length) AS avg_length
    FROM
        film AS f
    GROUP BY language_id) AS s
        JOIN
    language AS l USING (language_id)
WHERE
    s.avg_length > 110;
    
    -- 3. Derivada -Maximo y minimo replacement_cost por idioma
    SELECT 
    l.language_id,
    l.name AS language_name,
    m.max_replacement_cost,
    m.min_replacement_cost
FROM
    (SELECT 
        f.language_id,
            MAX(f.replacement_cost) AS max_replacement_cost,
            MIN(f.replacement_cost) AS min_replacement_cost
    FROM
        film AS f
    GROUP BY language_id) AS m
        JOIN
    language AS l ON l.language_id = m.language_id
ORDER BY l.language_id;

	-- 4. Correlacionada: Idiomas con al menos una película rating R
    use sakila;
    select * from film limit 1;
    SELECT 
    l.language_id, l.name AS language_name
FROM
    language AS l
WHERE
    EXISTS( SELECT 
            1
        FROM
            film AS f
        WHERE
            l.language_id = f.language_id
                AND rating = 'R');
                
	-- 5. Escalar: número total de idiomas distintos presentes en film
    SELECT 
    COUNT(DISTINCT (language_id))
FROM
    film; 
    
    SELECT 
    (SELECT 
            COUNT(DISTINCT (language_id))
        FROM
            film AS f) AS film_languages;
    #perra mamadota
    
    -- 6. Escalar: número de películas con clasificacón 'R'
    SELECT 
    (SELECT 
            COUNT(1)
        FROM
            film AS f
        WHERE
            rating = 'R') AS R_rated_movies;
    
    -- 7. CTE WITH: actores con más de 30 películas
    
    with film_counts as(select fa.actor_id, count(fa.film_id) as total_films from film_actor as fa group by fa.actor_id)
    select a.actor_id,concat(a.first_name,' ', a.last_name) as actors_name, fc.total_films from actor as a join film_counts as fc using(actor_id)
    where fc.total_films>=30 order by fc.total_films desc;


-- 6. Para practicar
    -- 6.7. Derivada-Idioma con más películas
    SELECT 
    l.language_id, l.name, t.d_lang
FROM
    (SELECT 
        f.language_id, COUNT(f.film_id) AS d_lang
    FROM
        film AS f
    GROUP BY f.language_id) AS t
        JOIN
    language AS l USING (language_id)
LIMIT 1;
    
    

