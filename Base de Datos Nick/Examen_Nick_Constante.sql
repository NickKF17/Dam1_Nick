	-- 1)Obtener para cada idioma, cuántas películas tienen rating 'R'--
   SELECT l.name as Idioma, count(*) as Num_R
   FROM film f
   JOIN language l USING(language_id)
   WHERE rating Like 'R'
   group by l.name;
   
   -- 2)El **encargado de atención al cliente** quiere un listado de *todos* los clientes registrados en el almacén 1 y el número de alquileres que han hecho, incluyendo clientes sin alquileres. --
   Select concat(c.first_name," ",c.last_name) as Cliente , count(r.rental_id) as Alquileres
   from customer c 
   Left Join rental r ON c.customer_id=r.customer_id
   where c.store_id=1
   group by Cliente
   order by Alquileres asc;
   
   -- 3) --El **gerente de la tienda** desea conocer qué clientes han realizado alquileres de películas, sin incluir a aquellos que no han alquilado nada.
   
     Select concat(c.first_name," ",c.last_name) as Cliente , count(r.rental_id) as Alquileres
   from customer c 
   Right Join rental r ON c.customer_id=r.customer_id
   where c.store_id=1
   group by Cliente
   order by Alquileres asc;
   
	-- 4)Para cada categoría, calcula la duración media de las películas alquiladas (considerando solo películas alquiladas). --

	SELECT
    c.name AS Categoria, avg(f.length) AS Duracion_media
FROM
    category c
        JOIN
    film_category fc ON c.category_id = fc.category_id
        JOIN
    film f ON fc.film_id = f.film_id
WHERE f.length IN (
   SELECT 
            r2.rental_id
        FROM
            rental r2
               
        WHERE
            r2.rental_id >=1 )
group by Categoria
order by Duracion_media asc;

	-- 5)Obtener para cada país la suma de los pagos (amount) realizados en 2005 -- 
    Select c.country as Pais,sum(amount) as Pagos_Total
    From payment
    Join customer Using (customer_id)
    Join address using (address_id)
    Join city using (city_id)
    Join country c using (country_id)
    Where payment_date like '2005%'
    group by Pais
    order by Pagos_Total asc;
    
    
    
    

