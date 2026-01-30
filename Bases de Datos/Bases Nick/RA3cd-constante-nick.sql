use sakila;

-- ==============================================
-- SECCIÓN A) 30 CONSULTAS CON JOIN DE 2 TABLAS
-- ==============================================
-- 1:  Para cada actor, muestra el número total de películas en las que aparece; es decir, cuenta cuántas filas de film_actor corresponden a cada actor.
Select concat(actor.first_name," ",actor.last_name) as Actor,count(*) as pelis_actuadas
From actor
Join film_actor Using (actor_id)
Group by concat(actor.first_name," ",actor.last_name)
Order by pelis_actuadas desc;

-- Concat para que aparezca en una sola columna y como nos pide que contemos en las que aparece usamos un Count() que puede ser de actor_id o de todo, da igual y como nos pide informacion de otra tabla hacemos join con dicha tabla 
-- 2:  Lista solo los actores que participan en 20 o más películas (umbral alto) con su conteo.

Select concat(actor.first_name," ",actor.last_name) as Actor,count(*) as pelis_actuadas
From actor
Join film_actor Using (actor_id)
Group by concat(actor.first_name," ",actor.last_name)
Having pelis_actuadas>=20;

-- Lo mismo que arriba pero filtrando que sea mayor o igual a 20. IMPORTANTISIMO se usa Having porque filtro después de agrupar
-- 3:  Para cada idioma, indica cuántas películas están catalogadas en ese idioma.

Select language.name, count(film.language_id)
From language
Join film Using (language_id)
Group by language.name;

-- 4:  Muestra el promedio de duración (length) de las películas por idioma y filtra aquellos idiomas con duración media estrictamente mayor a 110 minutos.
Select avg(film.length) as promedio_duracion , language.name as Idiomas 
From language
Join film Using (language_id)
Group by language.name 
Having promedio_duracion> 110 ;

-- Aparece solo ingles porque todas estan en ingles
-- 5:  Para cada película, muestra cuántas copias hay en el inventario.

Select film.title ,count(inventory.inventory_id) as Copias
From film
JOin inventory  Using (film_id)
Group by film.title;
 
 -- Se usa el inventory_id para saber cuantas copias hay disponibles
-- 6:  Lista solo las películas que tienen al menos 5 copias en inventario.

Select film.title ,count(inventory.inventory_id) as Copias
From film
JOin inventory  Using (film_id)
Group by film.title
Having Copias>= 5;

-- Lo mismo que arriba pero filtrando solo las que tengan 5 o mas copias
-- 7:  Para cada artículo de inventario, cuenta cuántos alquileres se han realizado.

Select rental.inventory_id, count(rental.rental_id) as Rentas
From rental
Group by rental.inventory_id;

-- Se hace con inventory_id porque si se hace con titulo por ejemplo te multiplica los rentals por el numero de copias, ya que el titulo esta afiliado a multiples inventory_id
-- 8:  Para cada cliente, muestra cuántos alquileres ha realizado en total.

Select Concat(customer.first_name, " " , customer.last_name) as Cliente , count(rental.rental_id) as Rentas
From customer
Join rental Using (Customer_id)
Group by Cliente;

-- 9:  Lista los clientes con 30 o más alquileres acumulados.

Select Concat(customer.first_name, " " , customer.last_name) as Cliente , count(rental.rental_id) as Rentas
From customer
Join rental Using (Customer_id)
Group by Cliente
Having Rentas>= 30;

-- 10:  Para cada cliente, muestra el total de pagos (suma en euros/dólares) que ha realizado.

Select Concat(customer.first_name, " " , customer.last_name) as Cliente , Concat(Sum(payment.amount)," $") as Tot_pagos
From customer
Join payment Using (Customer_id)
Group by Cliente;

-- 11:  Muestra los clientes cuyo importe total pagado es al menos 200.

Select Concat(customer.first_name, " " , customer.last_name) as Cliente , Concat(Sum(payment.amount)," $") as Tot_pagos
From customer
Join payment Using (Customer_id)
Group by Cliente
Having Tot_pagos >= 200;

-- Concatenar los nombres y apellidos en lugar de imprimir dos columnas have que se vea mejor, ademas se puede añadir el simbolo del dolar
-- 12:  Para cada empleado (staff), muestra el número de pagos que ha procesado.

Select Concat(staff.first_name, " " , staff.last_name) as Empleado , count(payment_id) as Tot_pagos
From staff
Join payment Using (staff_id)
Group by Empleado;


-- 13:  Para cada empleado, muestra el importe total procesado.
Select Concat(staff.first_name, " " , staff.last_name) as Empleado , Concat(sum(payment.amount)," $") as Tot_importe
From staff
Join payment Using (staff_id)
Group by Empleado;

-- 14:  Para cada tienda, cuenta cuántos artículos de inventario tiene.

Select store_id as ID_tienda , count(inventory_id) as Inventario_total
from store
Join inventory Using (Store_id)
Group by store_id;


-- 15:  Para cada tienda, cuenta cuántos clientes tiene asignados.

Select store_id as ID_tienda , count(customer_id) as Clientes_asignados
from store
Join customer Using (store_id)
Group by store_id;

-- 16:  Para cada tienda, cuenta cuántos empleados (staff) tiene asignados.

Select store_id as ID_tienda , count(staff_id) as Staff_asignados
from store
Join staff Using (store_id)
Group by store_id;

-- 17:  Para cada dirección (address), cuenta cuántas tiendas hay ubicadas ahí (debería ser 0/1 en datos estándar).

Select address , count(store_id)
from address
Join store Using (address_id)
Group by address_id;

-- 18:  Para cada dirección, cuenta cuántos empleados residen en esa dirección.

Select address_id,address, count(staff_id)
from address
Join staff Using (address_id)
Group by address_id;


-- 19:  Para cada dirección, cuenta cuántos clientes residen ahí.

Select address, count(address_id)
From address
Join customer Using (address_id)
Group by address;

-- 20:  Para cada ciudad, cuenta cuántas direcciones hay registradas.

Select city , count(address)
From city
Join address Using (city_id)
Group by city_id;


-- 21:  Para cada país, cuenta cuántas ciudades existen.

Select country , count(city_id)
From country 
Join city Using (country_id)
Group by country_id;

-- 22:  Para cada idioma, calcula la duración media de películas y muestra solo los idiomas con media entre 90 y 120 inclusive.

Select language.name as Idioma , avg(film.length) as media
from language
Join film Using (language_id)
Group by language_id
Having media Between 90 and 120;


-- 23:  Para cada película, cuenta el número de alquileres que se han hecho de cualquiera de sus copias (usando inventario).

Select film.film_id,film.title, count(rental_id) 
From film 
Join inventory Using (film_id)
Join rental	 Using(inventory_id)
Group by film.film_id;

-- 24:  Para cada cliente, cuenta cuántos pagos ha realizado en 2005 (usando el año de payment_date).

Select concat(customer.first_name ," ",customer.last_name) as Nombre , count(*) as Pagos_2005
From customer
Join payment using (customer_id)
WHERE payment_date Like "2005%"
Group by Nombre;

-- 25:  Para cada película, muestra el promedio de tarifa de alquiler (rental_rate) de las copias existentes (es un promedio redundante pero válido).

Select film.film_id, film.title , avg(rental_rate) as Promedio_tarifa
From film
Group by film.film_id;

-- 26:  Para cada actor, muestra la duración media (length) de sus películas.

Select concat(actor.first_name, " " ,actor.last_name) Nombre , avg(film.length) as Duracion_media
From actor
Join film_actor Using (actor_id)
Join film using (film_id)
Group by Nombre;

-- 27:  Para cada ciudad, cuenta cuántos clientes hay (usando la relación cliente->address->city requiere 3 tablas; aquí contamos direcciones por ciudad).

Select city.city_id ,city.city , count(*) as t9tal_addresses
From customer
Join address using (address_id)
Join city using(city_id)
Group by city.city_id
Order by city.city_id Asc;

-- 28:  Para cada película, cuenta cuántos actores tiene asociados.

Select film.film_id ,film.title , count(actor_id) as Num_actores
From film
Join film_actor Using(film_id)
Join actor Using(actor_id)
Group by film.film_id
Order by film.film_id Asc;

-- 29:  Para cada categoría (por id), cuenta cuántas películas pertenecen a ella (sin nombre de categoría para mantener 2 tablas).

Select film_category.category_id as Id_pelicula, count(*) as Num_pelis
From film
Join film_category Using (film_id)
Group by film_category.category_id;

-- 30:  Para cada tienda, cuenta cuántos alquileres totales se originan en su inventario.

Select store.store_id , count(rental_id) as Alquileres_tot
From rental
Join inventory using (inventory_id)
Join store Using (store_id)
Group by store.store_id;

-- ==============================================
-- SECCIÓN B) 30 CONSULTAS CON JOIN DE 3 TABLAS
-- ==============================================
-- 31:  Para cada actor, cuenta cuántas películas tiene y muestra solo los que superan 15 películas.

Select actor.actor_id ,concat(actor.first_name , " " , actor.last_name) , count(*) as num_pelis
From  actor
Join film_actor using (actor_id)
Join film using (film_id)
Group by actor.actor_id
Having num_pelis > 15;

-- 32:  Para cada categoría (por nombre), cuenta cuántas películas hay en esa categoría.

Select category.name as categoria , count(*) as Num_peliculas
From category
Join  film_category Using (category_id)
Join film Using (film_id)
Group by category.name;

-- 33:  Para cada película, cuenta cuántos alquileres se han hecho de sus copias.

Select film.film_id,film.title , count(*) as Alquileres
From film 
Join inventory Using (film_id)
Join rental Using (inventory_id)
Group by film.film_id;


-- 34:  Para cada cliente, suma el importe pagado en 2005 y filtra clientes con total >= 150.

Select customer.customer_id, concat(customer.first_name, " " , customer.last_name) as Nombre , sum(payment.amount) as importe_pagado
From customer 
Join payment using (customer_id)
where payment_date Like "2005%"
Group by customer.customer_id
Having importe_pagado>= 150; 

-- 35:  Para cada tienda, suma el importe cobrado por todos sus empleados.



-- 36:  Para cada ciudad, cuenta cuántos empleados residen ahí (staff -> address -> city).
-- 37:  Para cada ciudad, cuenta cuántas tiendas existen (store -> address -> city).
-- 38:  Para cada actor, calcula la duración media de sus películas del año 2006.
-- 39:  Para cada categoría, calcula la duración media y muestra solo las que superan 120.
-- 40:  Para cada idioma, suma las tarifas de alquiler (rental_rate) de todas sus películas.
-- 41:  Para cada cliente, cuenta cuántos alquileres realizó en fines de semana (SÁB-DO) usando DAYOFWEEK (1=Domingo).
-- 42:  Para cada actor, muestra el total de títulos distintos en los que participa (equivale a COUNT DISTINCT, sin subconsulta).
-- 43:  Para cada ciudad, cuenta cuántos clientes residen ahí (customer -> address -> city).
-- 44:  Para cada categoría, muestra cuántos actores distintos participan en películas de esa categoría.
-- 45:  Para cada tienda, cuenta cuántas copias totales (inventario) tiene de películas en 2006.
-- 46:  Para cada cliente, suma el total pagado por alquileres cuyo empleado pertenece a la tienda 1.
-- 47:  Para cada película, cuenta cuántos actores tienen el apellido de longitud >= 5.
-- 48:  Para cada categoría, suma la duración total (length) de sus películas.
-- 49:  Para cada ciudad, suma los importes pagados por clientes que residen en esa ciudad.
-- 50:  Para cada idioma, cuenta cuántos actores distintos participan en películas de ese idioma.
-- 51:  Para cada tienda, cuenta cuántos clientes activos (active=1) tiene.
-- 52:  Para cada cliente, cuenta en cuántas categorías distintas ha alquilado (aprox. vía film_category; requiere 4 tablas, aquí contamos películas 2006 por inventario).
-- 53:  Para cada empleado, cuenta cuántos clientes diferentes le han pagado.
-- 54:  Para cada ciudad, cuenta cuántas películas del año 2006 han sido alquiladas por residentes en esa ciudad.
-- 55:  Para cada categoría, calcula el promedio de replacement_cost de sus películas.
-- 56:  Para cada tienda, suma los importes cobrados en 2006 (vía empleados de esa tienda).
-- 57:  Para cada actor, cuenta cuántas películas tienen título de más de 12 caracteres.
-- 58:  Para cada ciudad, calcula la suma de pagos de 2005 y filtra las ciudades con total >= 300.
-- 59:  Para cada categoría, cuenta cuántas películas tienen rating 'PG' o 'PG-13'.
-- 60:  Para cada cliente, calcula el total pagado en pagos procesados por el empleado 2.
-- ==============================================
-- SECCIÓN C) 20 CONSULTAS CON JOIN DE 4 TABLAS
-- ==============================================
-- 61:  Para cada ciudad, cuenta cuántos clientes hay y muestra solo ciudades con 10 o más clientes.
-- 62:  Para cada actor, cuenta cuántos alquileres totales suman todas sus películas.
-- 63:  Para cada categoría, suma los importes pagados derivados de películas de esa categoría.
-- 64:  Para cada ciudad, suma los importes pagados por clientes residentes en esa ciudad en 2005.
-- 65:  Para cada tienda, cuenta cuántos actores distintos aparecen en las películas de su inventario.
-- 66:  Para cada idioma, cuenta cuántos alquileres totales se han hecho de películas en ese idioma.
-- 67:  Para cada cliente, cuenta en cuántos meses distintos de 2005 realizó pagos (meses distintos).
-- 68:  Para cada categoría, calcula la duración media de las películas alquiladas (considerando solo películas alquiladas).
-- 69:  Para cada país, cuenta cuántos clientes hay (country -> city -> address -> customer).
-- 70:  Para cada país, suma los importes pagados por sus clientes.
-- 71:  Para cada tienda, cuenta cuántas categorías distintas existen en su inventario.
-- 72:  Para cada tienda, suma la recaudación por categoría (resultado agregado por tienda y categoría).
-- 73:  Para cada actor, cuenta en cuántas tiendas distintas se han alquilado sus películas.
-- 74:  Para cada categoría, cuenta cuántos clientes distintos han alquilado películas de esa categoría.
-- 75:  Para cada idioma, cuenta cuántos actores distintos participan en películas alquiladas en ese idioma.
-- 76:  Para cada país, cuenta cuántas tiendas hay (país->ciudad->address->store).
-- 77:  Para cada cliente, cuenta los alquileres en los que la devolución (return_date) fue el mismo día del alquiler.
-- 78:  Para cada tienda, cuenta cuántos clientes distintos realizaron pagos en 2005.
-- 79:  Para cada categoría, cuenta cuántas películas con título de longitud > 15 han sido alquiladas.
-- 80:  Para cada país, suma los pagos procesados por los empleados de las tiendas ubicadas en ese país.
-- ==============================================
-- SECCIÓN D) 20 CONSULTAS EXTRA (DIFICULTAD +), <=4 JOINS
-- ==============================================
-- 81:  Para cada cliente, muestra el total pagado con IVA teórico del 21% aplicado (total*1.21), redondeado a 2 decimales.
-- 82:  Para cada hora del día (0-23), cuenta cuántos alquileres se iniciaron en esa hora.
-- 83:  Para cada tienda, muestra la media de length de las películas alquiladas en 2005 y filtra las tiendas con media >= 100.
-- 84:  Para cada categoría, muestra la media de replacement_cost de las películas alquiladas un domingo.
-- 85:  Para cada empleado, muestra el importe total por pagos realizados entre las 00:00 y 06:00 (inclusive 00:00, exclusivo 06:00).
-- 86:  Para cada actor, cuenta cuántas de sus películas tienen un título que contiene la palabra 'LOVE' (mayúsculas).
-- 87:  Para cada idioma, muestra el total de pagos de alquileres de películas en ese idioma.
-- 88:  Para cada cliente, cuenta en cuántos días distintos de 2005 realizó algún alquiler.
-- 89:  Para cada categoría, calcula la longitud media de títulos (número de caracteres) de sus películas alquiladas.
-- 90:  Para cada tienda, cuenta cuántos clientes distintos alquilaron en el primer trimestre de 2006 (enero-marzo).
-- 91:  Para cada país, cuenta cuántas categorías diferentes han sido alquiladas por clientes residentes en ese país.
-- 92:  Para cada cliente, muestra el importe medio de sus pagos redondeado a 2 decimales, solo si ha hecho al menos 10 pagos.
-- 93:  Para cada categoría, muestra el número de películas con replacement_cost > 20 que hayan sido alquiladas al menos una vez.
-- 94:  Para cada tienda, suma los importes pagados en fines de semana.
-- 95:  Para cada actor, cuenta cuántas películas suyas fueron alquiladas por al menos 5 clientes distintos (se cuenta alquileres y luego se filtra por HAVING).
-- 96:  Para cada idioma, muestra el número de películas cuyo título empieza por la letra 'A' y que han sido alquiladas.
-- 97:  Para cada país, suma el importe total de pagos realizados por clientes residentes y filtra países con total >= 1000.
-- 98:  Para cada cliente, cuenta cuántos días han pasado entre su primer y su último alquiler en 2005 (diferencia de fechas), mostrando solo clientes con >= 5 alquileres en 2005.
--     (Se evita subconsulta calculando sobre el conjunto agrupado por cliente y usando MIN/MAX de rental_date en 2005).
-- 99:  Para cada tienda, muestra la media de importes cobrados por transacción en el año 2006, con dos decimales.
-- 100:  Para cada categoría, calcula la media de duración (length) de películas alquiladas en 2006 y ordénalas descendentemente por dicha media.