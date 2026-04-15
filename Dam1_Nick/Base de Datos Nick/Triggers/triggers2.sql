
Delimiter //

create procedure alquiler_rapido(
in var_customer_id int,
in var_inventory_id int,
in var_staff_id int)
begin 
	insert into sakila.rental
    (
    rental_date,
    inventory_id,
    customer_id,
    staff_id
    )
    values
    (now(),
    var_inventory_id,
    var_customer_id,
    var_staff_id
    );
END //
    DElimiter ;
    
select * from inventory;

call alquiler_rapido(
67,46,1
);
select * from rental where customer_id =67 and inventory_id and staff_id=1;

call alquiler_rapido(
(select customer_id from customer where first_name like 'A%' limit 1),45,1
);

######################################2
explain store;

start transaction;
Delimiter //
create procedure muda_tienda(in var_idstore tinyint)
begin 
	insert into sakila.store
    (
    store_id,
    manager_staff_id,
    address_id,
    last_update
    )
  SELECT  store_id,
    manager_staff_id,
    address_id,
    last_update
FROM store
WHERE store_id != var_idstore;

END //
    DElimiter ;

call muda_tienda(1);

	