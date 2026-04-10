use sakila;

-- Curiosidad:
select * from tienda_online.clientes;

select * from actor limit 5;

-- 1) Cinco actores con más películas
-- dos formas
select count(film_actor.actor_id) as num_peliculas, actor.first_name, actor.last_name  from film_actor
join actor on film_actor.actor_id = actor.actor_id
group by film_actor.actor_id
order by count(film_actor.actor_id) desc limit 5;

select actor.first_name, actor.last_name, count(film_id) as num_peliculas
from actor
-- join film_actor on actor.actor_id= film_actor.actor_id
join film_actor fa using(actor_id)
-- esta es otra forma de meter el join
group by actor.actor_id
order by num_peliculas desc
limit 5;

-- 2) País con más clientes
select country.country, count(customer.customer_id) as num_clientes from country
join city on country.country_id = city.country_id
join address on city.city_id = address.city_id
join customer on address.address_id = customer.address_id
group by country.country
order by count(customer.customer_id) desc limit 1;
-- 2.2) paises con más de 40 clientes
select country.country, count(customer.customer_id) as num_clientes from country
join city on country.country_id = city.country_id
join address on city.city_id = address.city_id
join customer on address.address_id = customer.address_id
group by country.country
having count(customer.customer_id) >= 40
order by count(customer.customer_id) desc;

-- 3) Tres películas con mayores ingresos por alquiler
select film.title, sum(payment.amount) as ingresos_totales from payment
join rental on payment.rental_id = rental.rental_id
join inventory on rental.inventory_id = inventory.inventory_id
join film on inventory.film_id = film.film_id
group by film.film_id
order by sum(payment.amount) desc
limit 3;
-- si usamos el using, no es necesario especificar tablas con el "group by"
select film.title, sum(payment.amount) as ingresos_totales from payment
join rental on payment.rental_id = rental.rental_id
join inventory on rental.inventory_id = inventory.inventory_id
join film using(film_id)
group by film_id
order by sum(payment.amount) desc
limit 3;
-- 4) Cliente que más ha gastado
select concat(customer.first_name,' ', customer.last_name) as name, sum(payment.amount) as amount_wasted from payment
join customer using(customer_id)
group by customer.customer_id
order by sum(payment.amount) desc
limit 1;
/**otra forma: trailer de mi proximo martirio unu**/
SELECT customer_id
FROM payment
GROUP BY customer_id
HAVING sum(amount) >221;

SELECT sum(amount)
FROM payment
GROUP BY customer_id
ORDER BY sum(amount) DESC limit 1;


SELECT customer_id
FROM payment
GROUP BY customer_id
HAVING sum(amount) >=(
					SELECT sum(amount)
					FROM payment
					GROUP BY customer_id
					ORDER BY sum(amount) DESC limit 1);

SELECT CONCAT(first_name, ' ', last_name)
FROM customer
WHERE customer_id = 526;


SELECT CONCAT(first_name, ' ', last_name) as customer
FROM customer
WHERE customer_id = (
					SELECT customer_id
					FROM payment
					GROUP BY customer_id
					HAVING sum(amount) >=(
											SELECT sum(amount)
											FROM payment
											GROUP BY customer_id
											ORDER BY sum(amount) DESC limit 1));


-- 5) Ingreso promedio por alquiler en cada tienda
select * from store;
select round(avg(payment.amount), 2) as avg_income, store.store_id from payment
join staff using(staff_id)
join store using(store_id)
group by store.store_id; 

select round(avg(payment.amount), 2) as av_income, store.store_id from payment
join rental using(rental_id)
join inventory using(inventory_id)
join store using(store_id)
group by store_id;

select * from category;


/**Conclusiones
- hay que tener cuidado con las tablas, debido a que estas pueden romper la relaciòn y te pueden dar datos que no son del todo acertados
por ejemplo, en esta tabla el problema recae en que pueden haber clientes o puede haber staff que se cambia de tienda, entonces los datos de cambian
- SAKILA es muy sencilla en comparación a bases de datos de tiendas más grandes 
**/
-- 6) Ventas totales por categoría ordenadas
select category.name, sum(amount) as total_sales from payment
join rental using(rental_id)
join inventory using(inventory_id)
join film using(film_id)
join film_category using(film_id)
join category using(category_id)
group by category.category_id
ORDER BY sum(amount);

select category.name, sum(amount) as total_sales, COUNT(payment.amount) as num_sales from payment
join rental using(rental_id)
join inventory using(inventory_id)
join film using(film_id)
join film_category using(film_id)
join category using(category_id)
group by category.category_id
ORDER BY sum(amount) DESC;

-- 7) Actores con al menos diez películas de categorías distintas
select actor.first_name, actor.last_name, count(distinct(category.category_id)) as diff_categories from actor
join film_actor using(actor_id)
join film using (film_id)
join film_category using(film_id)
join category using(category_id)
group by actor_id
having diff_categories>= 10;
select name, count(name) from category
group by name;

-- 8) Tiendas con más stock disponible
select store_id, count(film_id) as stock from inventory
join store using(store_id)
group by store_id;
-- 9) Películas que nunca han sido alquiladas
SELECT * 
FROM film
LEFT JOIN inventory using(film_id);
-- 10) Diez películas con mayor diferencia entre coste de reposición y tarifa de alquiler
select * from film;
SELECT 
    *
FROM
    payment
        JOIN
    rental USING (rental_id)
        JOIN
    inventory USING (inventory_id)
ORDER BY amount DESC;
select * from rental;
SELECT 
    film_id, COUNT(film_id), store_id
FROM
    inventory
GROUP BY film_id , store_id
order by film_id;



select *from film;
SELECT 
    title, replacement_cost, film_id, inventory_id ,store_id, rental_id
FROM
    film
        left JOIN
    inventory USING (film_id) 
     left join rental using (inventory_id)
     left join payment using(rental_id)
     where inventory_id is null or rental_id is null;
     
     
     select payment_id,rental_id from payment
     left join rental using(rental_id);
     


select * from inventory;


-- 11) Películas con más de tres actores y duración menor a 90 minutos
