Use sakila;

#1 Alquiler Rapido

DELIMITER //
CREATE PROCEDURE rent_movie (IN p_cust_id INT, IN p_inv_id INT, IN p_staff_id INT)
BEGIN
    INSERT INTO rental (rental_date, inventory_id, customer_id, staff_id)
    VALUES (NOW(), p_inv_id, p_cust_id, p_staff_id);
END //
DELIMITER ;

# 2. Cierre de tiende

DELIMITER //
CREATE PROCEDURE close_store (IN p_store_id INT)
BEGIN
    DECLARE v_target_store INT;
    SELECT store_id INTO v_target_store FROM store WHERE store_id <> p_store_id LIMIT 1;
    UPDATE staff SET store_id = v_target_store WHERE store_id = p_store_id;
END //
DELIMITER ;

# 3. Actualizacion de precios

DELIMITER //
CREATE PROCEDURE update_cat_prices (IN p_perc DECIMAL (5,2), IN p_cat_id INT)
BEGIN
    UPDATE film f JOIN film_category fc USING(film_id)
    SET f.rental_rate = f.rental_rate * (1 + p_perc/100)
    WHERE fc.category_id = p_cat_id;
END //
DELIMITER ;

#Estadisticas de actor

DELIMITER //
CREATE PROCEDURE get_actor_stats (IN p_actor_id INT, OUT p_films INT, OUT p_avg_len DECIMAL (10,2))
BEGIN
    SELECT COUNT(*), AVG(length) INTO p_films, p_avg_len
    FROM film JOIN film_actor USING (film_id) WHERE actor_id = p_actor_id;
END //
DELIMITER ;

#Limpieza de logs

DELIMITER //
CREATE PROCEDURE purge_audit_logs (IN p_days INT)
BEGIN
    DELETE FROM audit_log WHERE log_date < DATE_SUB(NOW(), INTERVAL p_days DAY);
END //
DELIMITER ;

#Bloque 2 Calculo de multas

DELIMITER //
CREATE FUNCTION get_late_fine(p_rental_id INT) RETURNS DECIMAL (10,2) READS SQL DATA
BEGIN
    DECLARE v_delay INT;
    SELECT DATEDIFF (IFNULL(return_date, NOW()), rental_date) - f.rental_duration
    INTO v_delay
    FROM rental r JOIN inventory i USING (inventory_id) JOIN film f USING(film_id)
    WHERE r.rental_id = p_rental_id;
    RETURN IF (v_delay > 0, v_delay * 1.50, 0.00);
END //
DELIMITER ;

# 2. Estado del cliente
DELIMITER //
CREATE FUNCTION get_customer_status(p_cust_id INT) RETURNS VARCHAR(20) READS SQL DATA
BEGIN
    DECLARE v_spent DECIMAL (10,2);
    SELECT SUM(amount) INTO v_spent FROM payment WHERE customer_id = p_cust_id;
    RETURN IF (v_spent > 150, 'VIP', 'ESTANDAR');
END //
DELIMITER ;

# 3. Conversor de tiempo

DELIMITER //
CREATE FUNCTION format_min(p_min INT) RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    RETURN CONCAT(p_min DIV 60, 'h', p_min MOD 60, 'm');
END //
DELIMITER ;

# 4. Disponibilidad total

DELIMITER //
CREATE FUNCTION total_film_stock(p_film_id INT) RETURNS INT READS SQL DATA
BEGIN
    DECLARE v_count INT;
    SELECT COUNT(*) INTO v_count FROM inventory i
    WHERE film_id = p_film_id AND inventory_in_stock(i.inventory_id);
    RETURN v_count;
END //
DELIMITER ;

# 5. Email de marketing

DELIMITER //
CREATE FUNCTION gen_mkt_email(p_first VARCHAR(45), p_last VARCHAR(45)) RETURNS VARCHAR(100) DETERMINISTIC
BEGIN
    RETURN LOWER (CONCAT(p_first, '.', p_last, '@sakilavideo.com'));
END //
DELIMITER ;

# Bloqur 3  Clasificador por rating

DELIMITER //
CREATE PROCEDURE desc_rating(IN p_rating VARCHAR(10), OUT p_desc VARCHAR(100))
BEGIN
    CASE p_rating
        WHEN 'G' THEN SET p_desc = 'Todos los publicos';
        WHEN 'PG' THEN SET p_desc = 'Supervision de padres';
        WHEN 'R' THEN SET p_desc = 'Restringido (+18)';
        ELSE SET p_desc = 'Otras categorias';
    END CASE;
END //
DELIMITER ;

# 2.Generador de numeros

DELIMITER //
CREATE PROCEDURE populate_test()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 100 DO
        INSERT INTO test_table(val) VALUES (i);
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

# 3, Validacion de stock

DELIMITER //
CREATE PROCEDURE check_and_rent (IN p_film_id INT, IN p_store_id INT)
BEGIN
    DECLARE v_stock INT;
    CALL film_in_stock(p_film_id, p_store_id, v_stock);
    IF v_stock > 0 THEN SELECT 'Disponible' AS msg;
    ELSE SELECT 'Sin existencias' AS msg;
    END IF;
END //
DELIMITER ;

# 4. Promocion mensual

DELIMITER //
CREATE FUNCTION get_monthly_promo () RETURNS DECIMAL (5,2) DETERMINISTIC
BEGIN
    IF MONTH (NOW()) = 12 THEN RETURN 20.00;
    ELSEIF MONTH (NOW()) = 8 THEN RETURN 10.00;
    ELSE RETURN 0.00;
    END IF;
END //
DELIMITER ;

# 5. Bucle de intereses

DELIMITER //
CREATE PROCEDURE calc_debt (IN p_init DECIMAL (10,2), IN p_target DECIMAL (10,2))
BEGIN
    DECLARE v_debt DECIMAL (10,2) DEFAULT p_init;
    WHILE v_debt < p_target DO
        SET v_debt = v_debt * 1.05;
    END WHILE;
    SELECT v_debt;
END //
DELIMITER ;

#Bloque 4 Auditoria de pagos

DELIMITER //
CREATE TRIGGER audit_pay AFTER UPDATE ON payment FOR EACH ROW
BEGIN
    IF OLD.amount <> NEW.amount THEN
        INSERT INTO audit_payments (payment_id, old_amt, new_amt)
        VALUES (OLD.payment_id, OLD.amount, NEW.amount);
    END IF;
END //
DELIMITER ;

#2. Proteccion de actores

DELIMITER //
CREATE TRIGGER protect_actors BEFORE DELETE ON actor FOR EACH ROW
BEGIN
    DECLARE v_count INT;
    SELECT COUNT(*) INTO v_count FROM film_actor WHERE actor_id = OLD.actor_id;
    IF v_count > 20 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Actor demasiado famoso para borrar';
    END IF;
END //
DELIMITER ;

# 3. Auto-Mayusculas

DELIMITER //
CREATE TRIGGER cust_upper BEFORE UPDATE ON customer FOR EACH ROW
BEGIN
    SET NEW.first_name = UPPER(NEW.first_name);
END //
DELIMITER ;

#4.Control de stock minimo

DELIMITER //
CREATE TRIGGER check_min_inventory BEFORE INSERT ON rental FOR EACH ROW
BEGIN
    DECLARE v_count INT;
    SELECT COUNT(*) INTO v_count FROM inventory WHERE inventory_id = NEW.inventory_id;
    IF v_count = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Copia de inventario no existente';
    END IF;
END //
DELIMITER ;

#5. Historico de email

DELIMITER //
CREATE TRIGGER email_hist BEFORE UPDATE ON customer FOR EACH ROW
BEGIN
    IF OLD.email <> NEW.email THEN
        INSERT INTO email_history(customer_id, old_email) VALUES (OLD.customer_id, OLD.email);
    END IF;
END //
DELIMITER ;

































































































































#Bloque 5 Resumen de ventas staff

DELIMITER //
CREATE PROCEDURE total_staff_sales()
BEGIN
    DECLARE v_id INT;
    DECLARE v_total DECIMAL(10,2);
    DECLARE v_fin INT DEFAULT FALSE;
    DECLARE cur CURSOR FOR SELECT staff_id FROM staff;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;
    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO v_id;
        IF v_fin THEN LEAVE read_loop; END IF;
        SELECT SUM(amount) INTO v_total FROM payment WHERE staff_id = v_id;
        INSERT INTO staff_report (id, total) VALUES (v_id, v_total);
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;

# 2.Normalizador de nombres

DELIMITER //
CREATE PROCEDURE capitalize_actors()
BEGIN
    DECLARE v_id INT;
    DECLARE v_fname VARCHAR(45);
    DECLARE v_fin INT DEFAULT FALSE;
    DECLARE cur CURSOR FOR SELECT actor_id, first_name FROM actor;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;
    OPEN cur;
    loop1: LOOP
        FETCH cur INTO v_id, v_fname;
        IF v_fin THEN LEAVE loop1; END IF;
        UPDATE actor SET first_name = CONCAT (UPPER (LEFT(v_fname, 1)), LOWER (SUBSTRING(v_fname, 2)))
        WHERE actor_id = v_id;
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;

# 3. Informe ingresos por categoria

DELIMITER //
CREATE PROCEDURE cat_report ()
BEGIN
    DECLARE v_name VARCHAR(25);
    DECLARE v_rev DECIMAL(10,2);
    DECLARE v_fin INT DEFAULT FALSE;
    DECLARE cur CURSOR FOR SELECT name FROM category;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;
    OPEN cur;
    loop_r: LOOP
        FETCH cur INTO v_name;
        IF v_fin THEN LEAVE loop_r; END IF;
        SELECT SUM(amount) INTO v_rev FROM payment JOIN rental USING(rental_id)
        JOIN inventory USING (inventory_id) JOIN film_category USING (film_id)
        JOIN category USING (category_id) WHERE name = v_name;
        INSERT INTO cat_stats VALUES (v_name, v_rev);
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;


# 4. Aviso de devolucion

DELIMITER //
CREATE PROCEDURE overdue_report()
BEGIN
    DECLARE v_id INT;
    DECLARE v_fin INT DEFAULT FALSE;
    DECLARE cur CURSOR FOR SELECT rental_id FROM rental WHERE return_date IS NULL
    AND rental_date < DATE_SUB(NOW(), INTERVAL 7 DAY);
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;
    OPEN cur;
    loop_o: LOOP
        FETCH cur INTO v_id;
        IF v_fin THEN LEAVE loop_o; END IF;
        INSERT INTO overdue_logs (rental_id) VALUES (v_id);
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;


#5. Reemplazo masivo de descripcion

DELIMITER //
CREATE PROCEDURE replace_desc(IN p_old VARCHAR(50), IN p_new VARCHAR(50))
BEGIN
    DECLARE v_id INT;
    DECLARE v_desc TEXT;
    DECLARE v_fin INT DEFAULT FALSE;
    DECLARE cur CURSOR FOR SELECT film_id, description FROM film;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_fin = TRUE;
    OPEN cur;
    loop_res: LOOP
        FETCH cur INTO v_id, v_desc;
        IF v_fin THEN LEAVE loop_res; END IF;
        IF v_desc LIKE CONCAT('%', p_old, '%') THEN
            UPDATE film SET description = REPLACE(v_desc, p_old, p_new) WHERE film_id = v_id;
        END IF;
    END LOOP;
    CLOSE cur;
END //
DELIMITER ;

