# Ejemplos resueltos en la BBDD tiendaonline_completa.

## 1) Selección básica de datos y renombrado de columnas

- Listado simple de nombres y correos de todos los clientes.

```sql
mysql> select nombre,email from clientes;
+--------------------+--------------------------------+
| nombre             | email                          |
+--------------------+--------------------------------+
| Ana Torres         | ana@example.com                |
| Luis Méndez        | luis@example.com               |
| Carla Gómez        | carla@example.com              |
| David Ruiz         | david@example.com              |
| Sofía Paredes      | sofia@example.com              |
| Marta Gil          | marta.gil6@example.com         |
| Gonzalo Jiménez    | gonzalo.jimenez7@example.com   |
| Daniel Moreno      | daniel.moreno8@example.com     |
| Lucía Suárez       | lucia.suarez9@example.com      |
| Alba Domínguez     | alba.dominguez10@example.com   |
| Alba Sánchez       | alba.sanchez11@example.com     |
| Hugo Gil           | hugo.gil12@example.com         |
| Hugo Sánchez       | hugo.sanchez13@example.com     |
| Nicolás González   | nicolas.gonzalez14@example.com |
| Andrés García      | andres.garcia15@example.com    |
| María Alonso       | maria.alonso16@example.com     |
| María García       | maria.garcia17@example.com     |
| Adriana Navarro    | adriana.navarro18@example.com  |
| Lucía Domínguez    | lucia.dominguez19@example.com  |
| Alicia Vázquez     | alicia.vazquez20@example.com   |
| Nicolás Álvarez    | nicolas.alvarez21@example.com  |
| Irene Ramos        | irene.ramos22@example.com      |
| Elena López        | elena.lopez23@example.com      |
| Nicolás Serrano    | nicolas.serrano24@example.com  |
| Sofía Sánchez      | sofia.sanchez25@example.com    |
| Marta Alonso       | marta.alonso26@example.com     |
| Laura Ruiz         | laura.ruiz27@example.com       |
| Elena Jiménez      | elena.jimenez28@example.com    |
| Laura Álvarez      | laura.alvarez29@example.com    |
| José Fernández     | jose.fernandez30@example.com   |
| Juan Álvarez       | juan.alvarez31@example.com     |
| Adriana Ramos      | adriana.ramos32@example.com    |
| Sofía Alonso       | sofia.alonso33@example.com     |
| Noelia Torres      | noelia.torres34@example.com    |
| Javier Romero      | javier.romero35@example.com    |
| Marta Castro       | marta.castro36@example.com     |
| Paula Ramírez      | paula.ramirez37@example.com    |
| Alba Martínez      | alba.martinez38@example.com    |
| Laura Ortega       | laura.ortega39@example.com     |
| Miguel Sánchez     | miguel.sanchez40@example.com   |
| Pablo Gutiérrez    | pablo.gutierrez41@example.com  |
| Valeria García     | valeria.garcia42@example.com   |
| Sofía Romero       | sofia.romero43@example.com     |
| Raúl Suárez        | raul.suarez44@example.com      |
| Hugo Ramírez       | hugo.ramirez45@example.com     |
+--------------------+--------------------------------+

```


- Catálogo: nombre y precio de todos los productos.
```sql
select nombre,precio from productos;
+---------------------------+--------+
| nombre                    | precio |
+---------------------------+--------+
| Laptop Dell Inspiron      | 750.00 |
| Smartphone Xiaomi         | 320.00 |
| Auriculares Bluetooth     |  25.00 |
| Silla Gamer               | 180.00 |
| Escritorio                | 210.00 |
| Monitor LG 24"            | 129.99 |
| Teclado Mecánico          |  59.90 |
| Ratón Inalámbrico         |  39.50 |
| Impresora HP DeskJet      |  89.00 |
| Tablet Samsung            | 229.00 |
| Smartwatch Amazfit        |  79.00 |
| Disco SSD 1TB             |  79.99 |
| Memoria RAM 16GB          |  44.99 |
| Placa Base MSI            | 119.00 |
| Fuente 650W 80+ Bronze    |  59.00 |
| Tarjeta Gráfica RTX 3060  | 299.00 |
| Cámara Web 1080p          |  29.00 |
| Micrófono USB             |  49.00 |
| Altavoces 2.0             |  24.99 |
| Regleta 6 tomas           |  19.50 |
| Silla de Oficina          | 129.00 |
| Lámpara LED escritorio    |  22.00 |
| Mochila para portátil     |  34.90 |
| Cable HDMI 2.1            |  11.99 |
| Hub USB-C 6 en 1          |  39.90 |
| Router Wi-Fi 6            |  79.90 |
| NAS 2 Bahías              | 249.00 |
| Silla Gamer Pro           | 229.00 |
| Escritorio en L           | 189.00 |
| Organizador de cables     |   9.99 |
+---------------------------+--------+

```

- Pedidos con su fecha y estado.
```sql
select fecha_pedido,estado from pedidos;
+---------------------+-----------+
| fecha_pedido        | estado    |
+---------------------+-----------+
| 2023-04-01 10:00:00 | entregado |
| 2023-04-03 15:30:00 | enviado   |
| 2023-04-05 12:45:00 | pendiente |
| 2023-04-10 09:10:00 | cancelado |
| 2023-04-11 13:00:00 | entregado |
| 2025-02-06 16:22:51 | entregado |
| 2025-07-14 10:22:00 | pendiente |
| 2024-03-09 22:58:56 | enviado   |
| 2023-10-15 10:21:56 | enviado   |
| 2024-11-24 01:35:05 | entregado |
| 2023-11-28 17:03:33 | cancelado |
| 2025-01-06 23:09:18 | entregado |
| 2023-07-03 04:07:56 | entregado |
| 2023-12-20 04:45:24 | entregado |
| 2025-08-05 07:42:28 | entregado |
| 2025-07-17 02:39:18 | entregado |
| 2024-10-31 12:27:44 | enviado   |
| 2023-10-18 22:35:34 | entregado |
| 2024-04-01 15:21:06 | entregado |
| 2025-05-02 21:23:21 | cancelado |
| 2023-05-23 18:47:29 | enviado   |
| 2024-06-16 09:21:24 | enviado   |
| 2025-01-17 05:17:51 | enviado   |
| 2025-02-14 02:59:59 | entregado |
| 2024-06-11 16:22:12 | enviado   |
| 2024-03-09 12:54:14 | pendiente |
| 2024-05-25 16:05:00 | cancelado |
| 2024-09-22 11:14:30 | entregado |
| 2025-05-11 18:49:48 | cancelado |
| 2025-01-31 11:25:48 | enviado   |
| 2023-05-23 13:59:20 | entregado |
| 2023-07-01 05:52:25 | entregado |
| 2025-04-01 14:18:12 | enviado   |
| 2025-02-04 16:16:23 | entregado |
| 2023-11-08 07:42:52 | pendiente |
| 2025-08-14 12:00:30 | enviado   |
| 2024-07-24 17:54:37 | enviado   |
| 2023-12-03 20:06:19 | entregado |
| 2025-07-01 15:12:28 | entregado |
| 2024-07-31 21:10:14 | entregado |
| 2023-06-08 13:30:04 | entregado |
| 2024-11-23 20:06:35 | enviado   |
| 2023-10-15 18:58:00 | entregado |
| 2025-07-23 07:42:42 | entregado |
| 2024-08-31 03:45:22 | enviado   |
| 2025-03-04 09:48:02 | entregado |
| 2025-09-08 22:58:53 | entregado |
| 2023-11-06 21:39:33 | pendiente |
| 2025-03-20 11:20:53 | cancelado |
| 2023-12-10 14:52:01 | enviado   |
| 2025-05-12 20:38:03 | cancelado |
| 2024-09-14 18:26:50 | cancelado |
| 2024-04-28 02:49:10 | pendiente |
| 2025-06-19 19:08:47 | entregado |
| 2025-08-25 08:07:24 | pendiente |
| 2023-07-05 08:36:02 | entregado |
| 2024-09-19 21:37:37 | pendiente |
| 2025-05-18 23:57:07 | enviado   |
| 2025-03-04 23:52:27 | entregado |
| 2025-07-25 04:49:19 | entregado |
| 2024-05-12 12:22:02 | enviado   |
| 2024-02-05 07:21:29 | entregado |
| 2025-03-20 02:10:46 | enviado   |
| 2024-10-30 02:17:30 | enviado   |
| 2024-09-28 06:43:50 | pendiente |
| 2024-11-29 07:12:46 | entregado |
| 2025-05-12 23:48:40 | pendiente |
| 2024-05-12 17:45:07 | entregado |
| 2023-09-21 13:34:12 | pendiente |
| 2024-03-08 11:36:16 | enviado   |
| 2024-11-08 04:19:43 | cancelado |
| 2025-02-02 00:15:34 | pendiente |
| 2023-05-19 23:18:06 | enviado   |
| 2024-12-02 08:42:30 | entregado |
| 2024-11-08 13:11:45 | entregado |
| 2024-01-16 23:04:06 | cancelado |
| 2024-03-24 13:08:23 | enviado   |
| 2024-08-20 07:52:40 | entregado |
| 2025-05-22 18:34:54 | entregado |
| 2025-03-07 21:03:31 | entregado |
| 2025-08-07 06:41:09 | enviado   |
| 2024-12-20 16:05:11 | pendiente |
| 2024-06-23 21:01:43 | pendiente |
| 2023-09-09 05:08:29 | entregado |
| 2024-09-08 09:20:31 | entregado |
| 2024-03-01 19:12:50 | entregado |
| 2024-11-20 08:05:39 | pendiente |
| 2024-07-04 09:03:36 | entregado |
| 2024-12-23 04:18:39 | entregado |
| 2024-05-07 15:34:48 | entregado |
| 2025-03-19 15:55:01 | cancelado |
| 2024-02-24 04:47:14 | enviado   |
| 2023-07-21 06:15:47 | cancelado |
| 2024-08-20 06:27:14 | pendiente |
| 2024-12-22 17:32:18 | pendiente |
| 2023-05-13 12:18:02 | entregado |
| 2024-12-20 15:45:45 | entregado |
| 2025-01-01 08:54:38 | cancelado |
| 2023-07-13 12:11:10 | enviado   |
| 2024-08-16 07:38:23 | enviado   |
| 2025-02-25 15:05:06 | cancelado |
| 2025-01-15 04:47:50 | enviado   |
| 2025-07-16 07:06:39 | cancelado |
| 2023-08-13 06:34:54 | cancelado |
| 2023-07-14 02:03:36 | entregado |
| 2025-02-07 12:19:12 | cancelado |
| 2024-08-31 12:22:43 | pendiente |
| 2025-03-20 06:56:54 | enviado   |
| 2023-12-17 18:19:57 | enviado   |
| 2024-11-14 14:00:29 | entregado |
| 2024-07-09 20:08:34 | enviado   |
| 2023-05-27 05:25:59 | entregado |
| 2023-05-19 08:05:29 | entregado |
| 2025-02-06 07:24:00 | entregado |
| 2023-12-19 13:15:54 | cancelado |
| 2024-12-15 11:42:22 | pendiente |
| 2024-02-23 06:50:55 | enviado   |
| 2025-05-31 19:28:54 | entregado |
| 2024-03-03 10:46:42 | entregado |
| 2024-01-20 23:24:47 | entregado |
| 2023-05-12 04:35:14 | enviado   |
| 2023-11-06 02:20:32 | entregado |
| 2025-08-23 17:58:05 | enviado   |
| 2025-03-03 14:46:22 | entregado |
| 2023-11-11 22:35:27 | entregado |
| 2025-06-17 13:01:26 | entregado |
| 2023-10-14 09:07:49 | entregado |
| 2024-11-11 08:59:34 | entregado |
| 2024-03-20 08:40:09 | entregado |
| 2024-06-10 08:32:30 | cancelado |
| 2023-08-06 10:00:18 | cancelado |
| 2025-05-15 09:13:36 | pendiente |
| 2023-09-14 21:53:03 | entregado |
| 2025-07-13 03:57:51 | cancelado |
| 2025-03-19 22:32:32 | enviado   |
| 2025-02-20 10:38:58 | entregado |
| 2025-02-05 06:48:16 | pendiente |
| 2024-07-18 11:21:34 | entregado |
| 2024-08-30 08:53:45 | entregado |
| 2025-06-03 23:57:31 | entregado |
| 2024-06-20 12:58:36 | entregado |
| 2025-06-09 10:12:15 | entregado |
| 2023-05-11 21:31:45 | cancelado |
| 2025-05-24 00:03:02 | entregado |
| 2024-05-03 22:26:59 | enviado   |
| 2025-08-21 20:42:36 | enviado   |
| 2023-07-12 20:59:04 | pendiente |
| 2025-01-09 02:25:02 | entregado |
| 2024-11-22 07:43:09 | entregado |
| 2024-07-16 08:54:02 | entregado |
| 2023-10-05 21:07:56 | entregado |
| 2024-09-17 15:21:00 | entregado |
| 2024-11-29 22:17:40 | enviado   |
| 2023-07-24 05:59:43 | enviado   |
| 2023-06-16 15:24:32 | pendiente |
+---------------------+-----------+

```

- Pagos: método y monto registrados.
```sql
select metodo_pago,total_pagado from pagos;
```
- Detalle de líneas: producto y cantidad por cada detalle_pedido.
```sql
select id_producto,cantidad from detalle_pedido;
```

- Clientes con fecha de registro (orden natural de inserción).
```sql
select id_cliente,nombre,email,fecha_registro from clientes;
```
*Ojo: orden natural de inserción es el orden por defecto de una consulta (salvo indices).*

- Productos con su categoría asociada (solo columnas principales).
```sql
select categoria,id_producto,nombre,stock,precio from productos;
```
- IDs de pedidos y su total.
```sql

```
- IDs de pagos con su fecha de pago.
```sql

```
- Relación básica: id_pedido e id_producto de detalle_pedido.
```sql

```

## 2) Filtros con WHERE (comparadores, lógicos, BETWEEN, IN, LIKE, NULL)

- Productos con precio > 200.
```sql
    mysql> select * from productos where precio > 200
    -> ;
+-------------+---------------------------+-----------------------------------+--------+-------+--------------+
| id_producto | nombre                    | descripcion                       | precio | stock | categoria    |
+-------------+---------------------------+-----------------------------------+--------+-------+--------------+
|           1 | Laptop Dell Inspiron      | Laptop 15" Intel i5               | 750.00 |  1012 | Electrónica  |
|           2 | Smartphone Xiaomi         | Redmi Note 11 Pro                 | 320.00 |  1030 | Electrónica  |
|           5 | Escritorio                | Escritorio de madera para oficina | 210.00 |  1007 | Muebles      |
|          10 | Tablet Samsung            | Galaxy Tab A8 64GB                | 229.00 |   330 | Electrónica  |
|          16 | Tarjeta Gráfica RTX 3060  | 12GB GDDR6                        | 299.00 |   312 | Componentes  |
|          27 | NAS 2 Bahías              | Soporta RAID1                     | 249.00 |   310 | Electrónica  |
|          28 | Silla Gamer Pro           | Reclinable 160°                   | 229.00 |   310 | Muebles      |
+-------------+---------------------------+-----------------------------------+--------+-------+--------------+

```

- Pedidos con estado = 'pendiente' y total > 500.
```sql
    mysql> select * from pedidos where estado = "pendiente" and coste_total > 500;
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|         7 |         37 | 2025-07-14 10:22:00 | pendiente |      697.90 |
|        26 |         41 | 2024-03-09 12:54:14 | pendiente |     2408.95 |
|        48 |         17 | 2023-11-06 21:39:33 | pendiente |     3047.00 |
|        57 |         27 | 2024-09-19 21:37:37 | pendiente |     1690.00 |
|        65 |         38 | 2024-09-28 06:43:50 | pendiente |      752.56 |
|        67 |         33 | 2025-05-12 23:48:40 | pendiente |     1065.00 |
|        83 |         34 | 2024-06-23 21:01:43 | pendiente |     3243.87 |
|        94 |         29 | 2024-08-20 06:27:14 | pendiente |     2262.96 |
|       107 |         29 | 2024-08-31 12:22:43 | pendiente |      707.25 |
|       116 |         16 | 2024-12-15 11:42:22 | pendiente |      847.00 |
|       132 |         45 | 2025-05-15 09:13:36 | pendiente |     1045.00 |
+-----------+------------+---------------------+-----------+-------------+
;
```
- Clientes registrados en 2024.
```sql
mysql> select * from clientes 



4
    -> ;
+------------+-------------------+-------------------------------+----------------+-----------+
| id_cliente | nombre            | email                         | fecha_registro | pais      |
+------------+-------------------+-------------------------------+----------------+-----------+
|          9 | Lucía Suárez      | lucia.suarez9@example.com     | 2024-07-17     | Bolivia   |
|         11 | Alba Sánchez      | alba.sanchez11@example.com    | 2024-04-28     | Argentina |
|         12 | Hugo Gil          | hugo.gil12@example.com        | 2024-06-26     | Portugal  |
|         15 | Andrés García     | andres.garcia15@example.com   | 2024-08-12     | Venezuela |
|         19 | Lucía Domínguez   | lucia.dominguez19@example.com | 2024-06-28     | Chile     |
|         20 | Alicia Vázquez    | alicia.vazquez20@example.com  | 2024-12-12     | Colombia  |
|         22 | Irene Ramos       | irene.ramos22@example.com     | 2024-04-02     | México    |
|         23 | Elena López       | elena.lopez23@example.com     | 2024-09-23     | Uruguay   |
|         25 | Sofía Sánchez     | sofia.sanchez25@example.com   | 2024-01-19     | Portugal  |
|         28 | Elena Jiménez     | elena.jimenez28@example.com   | 2024-11-03     | Venezuela |
|         29 | Laura Álvarez     | laura.alvarez29@example.com   | 2024-03-27     | España    |
|         32 | Adriana Ramos     | adriana.ramos32@example.com   | 2024-05-11     | Uruguay   |
|         35 | Javier Romero     | javier.romero35@example.com   | 2024-03-29     | Italia    |
|         36 | Marta Castro      | marta.castro36@example.com    | 2024-11-14     | Uruguay   |
|         39 | Laura Ortega      | laura.ortega39@example.com    | 2024-04-08     | Ecuador   |
|         45 | Hugo Ramírez      | hugo.ramirez45@example.com    | 2024-06-19     | Argentina |
+------------+-------------------+-------------------------------+----------------+-----------+

```

**Ojo:** pendiente iba entre comillas porque es una palabra. 2024 va sin comillas porque es un número. 

- Pagos cuyo método IN ('tarjeta','paypal').
```sql
select * from pagos where metodo_pago IN ('tarjeta','paypal');
select * from pagos where metodo_pago='tarjeta' or metodo_pago = 'paypal';
```


- Productos con stock entre 300 y 400.
mysql> select * from productos where stock<400 and stock>30;
+-------------+---------------------------+---------------------------+--------+-------+--------------+
| id_producto | nombre                    | descripcion               | precio | stock | categoria    |
+-------------+---------------------------+---------------------------+--------+-------+--------------+
|           6 | Monitor LG 24"            | Monitor IPS Full HD 24"   | 129.99 |   340 | Electrónica  |
|           7 | Teclado Mecánico          | Switches rojos, layout ES |  59.90 |   370 | Accesorios   |
|           8 | Ratón Inalámbrico         | 16000 DPI, recargable     |  39.50 |   380 | Accesorios   |
|           9 | Impresora HP DeskJet      | Multifunción Wi-Fi        |  89.00 |   325 | Electrónica  |
|          10 | Tablet Samsung            | Galaxy Tab A8 64GB        | 229.00 |   330 | Electrónica  |
|          11 | Smartwatch Amazfit        | Autonomía 14 días         |  79.00 |   350 | Electrónica  |
|          12 | Disco SSD 1TB             | NVMe PCIe 3.0             |  79.99 |   360 | Componentes  |
|          13 | Memoria RAM 16GB          | DDR4 3200MHz (2x8GB)      |  44.99 |   365 | Componentes  |
|          14 | Placa Base MSI            | mATX B560M                | 119.00 |   315 | Componentes  |
|          15 | Fuente 650W 80+ Bronze    | ATX, silenciosa           |  59.00 |   325 | Componentes  |
|          16 | Tarjeta Gráfica RTX 3060  | 12GB GDDR6                | 299.00 |   312 | Componentes  |
|          17 | Cámara Web 1080p          | Micrófono incorporado     |  29.00 |   390 | Accesorios   |
|          18 | Micrófono USB             | Cardioide, plug&play      |  49.00 |   340 | Accesorios   |
|          19 | Altavoces 2.0             | 10W RMS                   |  24.99 |   370 | Accesorios   |
|          21 | Silla de Oficina          | Ergonómica malla          | 129.00 |   320 | Muebles      |
|          22 | Lámpara LED escritorio    | Brillo regulable          |  22.00 |   380 | Hogar        |
|          23 | Mochila para portátil     | 15.6" impermeable         |  34.90 |   360 | Accesorios   |
|          25 | Hub USB-C 6 en 1          | HDMI+USB3+SD              |  39.90 |   350 | Accesorios   |
|          26 | Router Wi-Fi 6            | AX3000 doble banda        |  79.90 |   330 | Electrónica  |
|          27 | NAS 2 Bahías              | Soporta RAID1             | 249.00 |   310 | Electrónica  |
|          28 | Silla Gamer Pro           | Reclinable 160°           | 229.00 |   310 | Muebles      |
|          29 | Escritorio en L           | 120x140 cm                | 189.00 |   312 | Muebles      |
+-------------+---------------------------+---------------------------+--------+-------+--------------+
mysql> select * from productos where stock between 300 and 400;



**Estas 2 consultas son equivalentes**

```sql
select * from productos where stock => 300 and stock <= 400
select * from productos where stock between 300 and 400;

```
- Clientes de país IN ('España','México','Argentina').
```sql
mysql> select * from clientes where pais in ('España', 'México','Argentina') order by pais;
+------------+-----------------+------------------------------+----------------+-----------+
| id_cliente | nombre          | email                        | fecha_registro | pais      |
+------------+-----------------+------------------------------+----------------+-----------+
|          4 | David Ruiz      | david@example.com            | 2023-04-05     | Argentina |
|         11 | Alba Sánchez    | alba.sanchez11@example.com   | 2024-04-28     | Argentina |
|         45 | Hugo Ramírez    | hugo.ramirez45@example.com   | 2024-06-19     | Argentina |
|          1 | Ana Torres      | ana@example.com              | 2023-01-10     | España    |
|         29 | Laura Álvarez   | laura.alvarez29@example.com  | 2024-03-27     | España    |
|         31 | Juan Álvarez    | juan.alvarez31@example.com   | 2023-10-31     | España    |
|         34 | Noelia Torres   | noelia.torres34@example.com  | 2023-07-03     | España    |
|         42 | Valeria García  | valeria.garcia42@example.com | 2023-09-28     | España    |
|          2 | Luis Méndez     | luis@example.com             | 2023-02-15     | México    |
|         22 | Irene Ramos     | irene.ramos22@example.com    | 2024-04-02     | México    |
|         26 | Marta Alonso    | marta.alonso26@example.com   | 2023-09-10     | México    |
+------------+-----------------+------------------------------+----------------+-----------+
sel
```

- Productos cuyo nombre contenga Silla.
```sql
select * from productos where nombre like '%silla%';
```

**Más ejemplos de % y _**
```sql
mysql> select * from productos where nombre like '_lla%';
Empty set (0,00 sec)
mysql> select * from productos where nombre LIKE '%silla%';
+-------------+------------------+--------------------------------------+--------+-------+-----------+
| id_producto | nombre           | descripcion                          | precio | stock | categoria |
+-------------+------------------+--------------------------------------+--------+-------+-----------+
|           4 | Silla Gamer      | Silla ergonómica con soporte lumbar  | 180.00 |  1005 | Muebles   |
|          21 | Silla de Oficina | Ergonómica malla                     | 129.00 |   320 | Muebles   |
|          28 | Silla Gamer Pro  | Reclinable 160°                      | 229.00 |   310 | Muebles   |
+-------------+------------------+--------------------------------------+--------+-------+-----------+


mysql> select * from productos where nombre like '__lla%';
+-------------+------------------+--------------------------------------+--------+-------+-----------+
| id_producto | nombre           | descripcion                          | precio | stock | categoria |
+-------------+------------------+--------------------------------------+--------+-------+-----------+
|           4 | Silla Gamer      | Silla ergonómica con soporte lumbar  | 180.00 |  1005 | Muebles   |
|          21 | Silla de Oficina | Ergonómica malla                     | 129.00 |   320 | Muebles   |
|          28 | Silla Gamer Pro  | Reclinable 160°                      | 229.00 |   310 | Muebles   |
+-------------+------------------+--------------------------------------+--------+-------+-----------+
3 rows in set (0,01 sec)

mysql> select * from productos where nombre like 'S_lla%';
+-------------+------------------+--------------------------------------+--------+-------+-----------+
| id_producto | nombre           | descripcion                          | precio | stock | categoria |
+-------------+------------------+--------------------------------------+--------+-------+-----------+
|           4 | Silla Gamer      | Silla ergonómica con soporte lumbar  | 180.00 |  1005 | Muebles   |
|          21 | Silla de Oficina | Ergonómica malla                     | 129.00 |   320 | Muebles   |
|          28 | Silla Gamer Pro  | Reclinable 160°                      | 229.00 |   310 | Muebles   |
+-------------+------------------+--------------------------------------+--------+-------+-----------+
3 rows in set (0,00 sec)
```

- Pedidos con fecha_pedido en abril de 2023.

```sql
mysql> select * from pedidos where fecha_pedido < '2023-05-01' and fecha_pedido > '2023-03-31';
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|         1 |          1 | 2023-04-01 10:00:00 | entregado |     1070.00 |
|         2 |          2 | 2023-04-03 15:30:00 | enviado   |      320.00 |
|         3 |          1 | 2023-04-05 12:45:00 | pendiente |       25.00 |
|         4 |          3 | 2023-04-10 09:10:00 | cancelado |      180.00 |
|         5 |          4 | 2023-04-11 13:00:00 | entregado |      210.00 |
+-----------+------------+---------------------+-----------+-------------+
5 rows in set (0,00 sec)

mysql> select * from pedidos where year(fecha_pedido)=2023 AND month(fecha_pedido)=04;
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|         1 |          1 | 2023-04-01 10:00:00 | entregado |     1070.00 |
|         2 |          2 | 2023-04-03 15:30:00 | enviado   |      320.00 |
|         3 |          1 | 2023-04-05 12:45:00 | pendiente |       25.00 |
|         4 |          3 | 2023-04-10 09:10:00 | cancelado |      180.00 |
|         5 |          4 | 2023-04-11 13:00:00 | entregado |      210.00 |
+-----------+------------+---------------------+-----------+-------------+
5 rows in set (0,00 sec)

mysql> select * from pedidos where fecha_pedido like '2023-04%';
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|         1 |          1 | 2023-04-01 10:00:00 | entregado |     1070.00 |
|         2 |          2 | 2023-04-03 15:30:00 | enviado   |      320.00 |
|         3 |          1 | 2023-04-05 12:45:00 | pendiente |       25.00 |
|         4 |          3 | 2023-04-10 09:10:00 | cancelado |      180.00 |
|         5 |          4 | 2023-04-11 13:00:00 | entregado |      210.00 |
+-----------+------------+---------------------+-----------+-------------+
5 rows in set (0,00 sec)
```
- Listado de los clientes con más de 9 caracteres
```sql
mysql> select nombre from clientes where length(nombre) > 9;

```


```sql
--- Para quitar espacios.
mysql> select nombre,length(replace(nombre,' ','')) from clientes;
mysql> select nombre from clientes where length( replace(nombre,' ','') ) > 9;

```


```sql
--- cortesía de Juan Andrés
--- Seleccionar solo el nombre (hasta el primer espacio)
select SUBSTRING_INDEX(nombre,' ',1) from clientes;
select reverse(SUBSTRING_INDEX(reverse(nombre),' ',1)) from clientes;
```

- Pagos con fecha_pago IS NULL (simularía no pagados si existieran).
```sql
select * from pagos where fecha_pago is null;
```
**Null se compara con "is" no con un "=", esto es porque el "NULL" termina siendo un valor que no existe y se pone automáticamente por rellenar espacio"**

- Detalles donde cantidad sea 3 o más pero el precio_unitario menor que 50.
```sql
select * from detalle_pedido where cantidad >=3 and precio_unitario < 50;
mysql> select * from detalle_pedido where cantidad >= 3 and precio_unitario < 50;

```



## 3) Ordenación, límite y duplicados (ORDER BY, LIMIT, DISTINCT)

- Top 10 productos más caros.

mysql> select * from productos order by precio desc limit 10;
```
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
| id_producto | nombre                    | descripcion                          | precio | stock | categoria    |
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
|           1 | Laptop Dell Inspiron      | Laptop 15" Intel i5                  | 750.00 |  1012 | Electrónica  |
|           2 | Smartphone Xiaomi         | Redmi Note 11 Pro                    | 320.00 |  1030 | Electrónica  |
|          16 | Tarjeta Gráfica RTX 3060  | 12GB GDDR6                           | 299.00 |   312 | Componentes  |
|          27 | NAS 2 Bahías              | Soporta RAID1                        | 249.00 |   310 | Electrónica  |
|          10 | Tablet Samsung            | Galaxy Tab A8 64GB                   | 229.00 |   330 | Electrónica  |
|          28 | Silla Gamer Pro           | Reclinable 160°                      | 229.00 |   310 | Muebles      |
|           5 | Escritorio                | Escritorio de madera para oficina    | 210.00 |  1007 | Muebles      |
|          29 | Escritorio en L           | 120x140 cm                           | 189.00 |   312 | Muebles      |
|           4 | Silla Gamer               | Silla ergonómica con soporte lumbar  | 180.00 |  1005 | Muebles      |
|           6 | Monitor LG 24"            | Monitor IPS Full HD 24"              | 129.99 |   340 | Electrónica  |
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
10 rows in set (0,00 sec)
```


- Últimos 20 pedidos por fecha_pedido DESC. (asc = orden ascendente)
```mysql> select * from pedidos order by fecha_pedido desc limit 20;
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|        47 |          5 | 2025-09-08 22:58:53 | entregado |      258.99 |
|        55 |         30 | 2025-08-25 08:07:24 | pendiente |      319.60 |
|       123 |         30 | 2025-08-23 17:58:05 | enviado   |      257.00 |
|       146 |         12 | 2025-08-21 20:42:36 | enviado   |      223.70 |
|        36 |         16 | 2025-08-14 12:00:30 | enviado   |     1024.92 |
|        81 |         27 | 2025-08-07 06:41:09 | enviado   |      493.90 |
|        15 |         37 | 2025-08-05 07:42:28 | entregado |      878.00 |
|        60 |         27 | 2025-07-25 04:49:19 | entregado |      104.70 |
|        44 |          9 | 2025-07-23 07:42:42 | entregado |      876.00 |
|        16 |          1 | 2025-07-17 02:39:18 | entregado |      926.16 |
|       103 |          3 | 2025-07-16 07:06:39 | cancelado |      375.00 |
|         7 |         37 | 2025-07-14 10:22:00 | pendiente |      697.90 |
|       134 |         31 | 2025-07-13 03:57:51 | cancelado |     1079.88 |
|        39 |         44 | 2025-07-01 15:12:28 | entregado |      700.98 |
|        54 |         27 | 2025-06-19 19:08:47 | entregado |     1636.97 |
|       126 |         17 | 2025-06-17 13:01:26 | entregado |      750.00 |
|       142 |         13 | 2025-06-09 10:12:15 | entregado |     1240.58 |
|       140 |         35 | 2025-06-03 23:57:31 | entregado |     1584.00 |
|       118 |         24 | 2025-05-31 19:28:54 | entregado |      630.00 |
|       144 |         34 | 2025-05-24 00:03:02 | entregado |      928.40 |
+-----------+------------+---------------------+-----------+-------------+
20 rows in set (0,00 sec)

```
- Clientes más recientes por fecha_registro.
```
mysql> select * from clientes order by fecha_registro desc;
+------------+--------------------+--------------------------------+----------------+-----------------------+
| id_cliente | nombre             | email                          | fecha_registro | pais                  |
+------------+--------------------+--------------------------------+----------------+-----------------------+
|         33 | Sofía Alonso       | sofia.alonso33@example.com     | 2025-06-18     | Chile                 |
|         24 | Nicolás Serrano    | nicolas.serrano24@example.com  | 2025-06-13     | Nicaragua             |
|         30 | José Fernández     | jose.fernandez30@example.com   | 2025-04-28     | República Dominicana  |
|         16 | María Alonso       | maria.alonso16@example.com     | 2025-04-07     | Panamá                |
|         17 | María García       | maria.garcia17@example.com     | 2025-03-10     | Colombia              |
|         37 | Paula Ramírez      | paula.ramirez37@example.com    | 2025-03-09     | Chile                 |
|         20 | Alicia Vázquez     | alicia.vazquez20@example.com   | 2024-12-12     | Colombia              |
|         36 | Marta Castro       | marta.castro36@example.com     | 2024-11-14     | Uruguay               |
|         28 | Elena Jiménez      | elena.jimenez28@example.com    | 2024-11-03     | Venezuela             |
|         23 | Elena López        | elena.lopez23@example.com      | 2024-09-23     | Uruguay               |
|         15 | Andrés García      | andres.garcia15@example.com    | 2024-08-12     | Venezuela             |
|          9 | Lucía Suárez       | lucia.suarez9@example.com      | 2024-07-17     | Bolivia               |
|         19 | Lucía Domínguez    | lucia.dominguez19@example.com  | 2024-06-28     | Chile                 |
|         12 | Hugo Gil           | hugo.gil12@example.com         | 2024-06-26     | Portugal              |
|         45 | Hugo Ramírez       | hugo.ramirez45@example.com     | 2024-06-19     | Argentina             |
|         32 | Adriana Ramos      | adriana.ramos32@example.com    | 2024-05-11     | Uruguay               |
|         11 | Alba Sánchez       | alba.sanchez11@example.com     | 2024-04-28     | Argentina             |
|         39 | Laura Ortega       | laura.ortega39@example.com     | 2024-04-08     | Ecuador               |
|         22 | Irene Ramos        | irene.ramos22@example.com      | 2024-04-02     | México                |
|         35 | Javier Romero      | javier.romero35@example.com    | 2024-03-29     | Italia                |
|         29 | Laura Álvarez      | laura.alvarez29@example.com    | 2024-03-27     | España                |
|         25 | Sofía Sánchez      | sofia.sanchez25@example.com    | 2024-01-19     | Portugal              |
|         21 | Nicolás Álvarez    | nicolas.alvarez21@example.com  | 2023-12-25     | El Salvador           |
|          7 | Gonzalo Jiménez    | gonzalo.jimenez7@example.com   | 2023-11-15     | Bolivia               |
|         14 | Nicolás González   | nicolas.gonzalez14@example.com | 2023-11-11     | Venezuela             |
|         43 | Sofía Romero       | sofia.romero43@example.com     | 2023-11-06     | Italia                |
|         18 | Adriana Navarro    | adriana.navarro18@example.com  | 2023-10-31     | Paraguay              |
|         31 | Juan Álvarez       | juan.alvarez31@example.com     | 2023-10-31     | España                |
|         10 | Alba Domínguez     | alba.dominguez10@example.com   | 2023-10-26     | Italia                |
|         40 | Miguel Sánchez     | miguel.sanchez40@example.com   | 2023-10-14     | Paraguay              |
|          8 | Daniel Moreno      | daniel.moreno8@example.com     | 2023-10-13     | Costa Rica            |
|         13 | Hugo Sánchez       | hugo.sanchez13@example.com     | 2023-09-29     | Uruguay               |
|         42 | Valeria García     | valeria.garcia42@example.com   | 2023-09-28     | España                |
|         26 | Marta Alonso       | marta.alonso26@example.com     | 2023-09-10     | México                |
|         44 | Raúl Suárez        | raul.suarez44@example.com      | 2023-08-07     | Bolivia               |
|         41 | Pablo Gutiérrez    | pablo.gutierrez41@example.com  | 2023-08-01     | El Salvador           |
|         38 | Alba Martínez      | alba.martinez38@example.com    | 2023-07-21     | Honduras              |
|         34 | Noelia Torres      | noelia.torres34@example.com    | 2023-07-03     | España                |
|          6 | Marta Gil          | marta.gil6@example.com         | 2023-05-11     | Paraguay              |
|         27 | Laura Ruiz         | laura.ruiz27@example.com       | 2023-05-10     | Perú                  |
|          5 | Sofía Paredes      | sofia@example.com              | 2023-04-25     | Perú                  |
|          4 | David Ruiz         | david@example.com              | 2023-04-05     | Argentina             |
|          3 | Carla Gómez        | carla@example.com              | 2023-03-20     | Chile                 |
|          2 | Luis Méndez        | luis@example.com               | 2023-02-15     | México                |
|          1 | Ana Torres         | ana@example.com                | 2023-01-10     | España                |
+------------+--------------------+--------------------------------+----------------+-----------------------+
45 rows in set (0,00 sec)

```
**Limit 20 es arbitrario, sin embargo se pone por evitar tener una lista inmensa de clientes**;
- Primeros 5 productos con menor stock.
```
mysql> select * from productos order by stock asc limit 5;
+-------------+---------------------------+------------------+--------+-------+--------------+
| id_producto | nombre                    | descripcion      | precio | stock | categoria    |
+-------------+---------------------------+------------------+--------+-------+--------------+
|          27 | NAS 2 Bahías              | Soporta RAID1    | 249.00 |   310 | Electrónica  |
|          28 | Silla Gamer Pro           | Reclinable 160°  | 229.00 |   310 | Muebles      |
|          16 | Tarjeta Gráfica RTX 3060  | 12GB GDDR6       | 299.00 |   312 | Componentes  |
|          29 | Escritorio en L           | 120x140 cm       | 189.00 |   312 | Muebles      |
|          14 | Placa Base MSI            | mATX B560M       | 119.00 |   315 | Componentes  |
+-------------+---------------------------+------------------+--------+-------+--------------+
5 rows in set (0,00 sec)

```
- DISTINCT de categorías de productos disponibles.
```
mysql> select distinct categoria from productos;
+--------------+
| categoria    |
+--------------+
| Electrónica  |
| Accesorios   |
| Muebles      |
| Componentes  |
| Hogar        |
+--------------+
5 rows in set (0,01 sec)

```
- Países distintos de los clientes registrados.
```
mysql> select distinct pais from clientes;
+-----------------------+
| pais                  |
+-----------------------+
| España                |
| México                |
| Chile                 |
| Argentina             |
| Perú                  |
| Paraguay              |
| Bolivia               |
| Costa Rica            |
| Italia                |
| Portugal              |
| Uruguay               |
| Venezuela             |
| Panamá                |
| Colombia              |
| El Salvador           |
| Nicaragua             |
| República Dominicana  |
| Honduras              |
| Ecuador               |
+-----------------------+
19 rows in set (0,00 sec)

```
- Pagos ordenados por monto DESC (mayor a menor).
```
mysql> select * from pagos order by total_pagado desc;
+---------+-----------+---------------------+---------------+--------------+
| id_pago | id_pedido | fecha_pago          | metodo_pago   | total_pagado |
+---------+-----------+---------------------+---------------+--------------+
|      24 |        28 | 2024-09-22 13:14:30 | transferencia |      4289.70 |
|      27 |        32 | 2023-07-01 07:52:25 | tarjeta       |      2957.97 |
|     105 |       128 | 2024-11-11 10:59:34 | transferencia |      2783.70 |
|     126 |       153 | 2024-11-30 00:17:40 | tarjeta       |      2701.80 |
|     124 |       151 | 2023-10-05 23:07:56 | transferencia |      2593.98 |
|      15 |        17 | 2024-11-01 12:27:44 | transferencia |      2463.13 |
|       5 |         6 | 2025-02-06 18:22:51 | tarjeta       |      2409.98 |
|     119 |       145 | 2024-05-04 00:26:59 | tarjeta       |      2234.00 |
|     108 |       133 | 2023-09-14 23:53:03 | paypal        |      2004.59 |
|      17 |        19 | 2024-04-01 17:21:06 | tarjeta       |      1954.00 |
|      55 |        64 | 2024-10-30 04:17:30 | paypal        |      1809.99 |
|      96 |       120 | 2024-01-21 01:24:47 | paypal        |      1743.98 |
|      83 |       102 | 2025-01-15 06:47:50 | paypal        |      1722.00 |
|      46 |        54 | 2025-06-19 21:08:47 | tarjeta       |      1636.97 |
|      45 |        50 | 2023-12-10 16:52:01 | tarjeta       |      1631.96 |
|      93 |       117 | 2024-02-23 08:50:55 | tarjeta       |      1601.97 |
|      68 |        84 | 2023-09-09 07:08:29 | paypal        |      1544.00 |
|      98 |       122 | 2023-11-06 04:20:32 | tarjeta       |      1509.99 |
|      61 |        77 | 2024-03-24 15:08:23 | paypal        |      1415.69 |
|     125 |       152 | 2024-09-17 17:21:00 | tarjeta       |      1389.88 |
|      78 |        96 | 2023-05-14 12:18:02 | paypal        |      1383.11 |
|      14 |        17 | 2024-10-31 13:27:44 | transferencia |      1327.37 |
|      40 |        42 | 2024-11-23 22:06:35 | transferencia |      1257.87 |
|     117 |       142 | 2025-06-09 12:12:15 | transferencia |      1240.58 |
|      76 |        92 | 2024-02-25 04:47:14 | transferencia |      1212.82 |
|      12 |        14 | 2023-12-20 06:45:24 | paypal        |      1196.76 |
|     109 |       135 | 2025-03-20 00:32:32 | paypal        |      1196.00 |
|      10 |        12 | 2025-01-07 01:09:18 | paypal        |      1175.67 |
|       1 |         1 | 2023-04-01 12:00:00 | tarjeta       |      1070.00 |
|      31 |        36 | 2025-08-14 14:00:30 | tarjeta       |      1024.92 |
|     115 |       140 | 2025-06-04 23:57:31 | transferencia |       989.00 |
|      91 |       112 | 2023-05-27 07:25:59 | paypal        |       988.96 |
|       6 |         8 | 2024-03-10 00:58:56 | transferencia |       983.46 |
|      58 |        70 | 2024-03-08 13:36:16 | paypal        |       970.97 |
|      47 |        58 | 2025-05-19 01:57:07 | tarjeta       |       934.80 |
|     118 |       144 | 2025-05-24 02:03:02 | paypal        |       928.40 |
|      13 |        16 | 2025-07-17 04:39:18 | tarjeta       |       926.16 |
|      28 |        33 | 2025-04-01 16:18:12 | transferencia |       914.08 |
|      44 |        48 | 2023-11-07 00:39:33 | tarjeta       |       896.33 |
|      42 |        44 | 2025-07-23 09:42:42 | tarjeta       |       876.00 |
|      92 |       113 | 2023-05-19 10:05:29 | tarjeta       |       866.80 |
|      77 |        96 | 2023-05-13 13:18:02 | transferencia |       853.75 |
|      79 |        97 | 2024-12-20 16:45:45 | tarjeta       |       824.64 |
|      57 |        68 | 2024-05-12 19:45:07 | transferencia |       799.55 |
|      53 |        62 | 2024-02-06 07:21:29 | transferencia |       791.33 |
|     101 |       125 | 2023-11-12 00:35:27 | tarjeta       |       789.58 |
|      26 |        31 | 2023-05-23 15:59:20 | paypal        |       784.95 |
|      74 |        90 | 2024-05-07 17:34:48 | paypal        |       759.76 |
|     102 |       126 | 2025-06-17 15:01:26 | tarjeta       |       750.00 |
|      86 |       108 | 2025-03-20 08:56:54 | paypal        |       747.00 |
|       9 |        10 | 2024-11-24 03:35:05 | tarjeta       |       698.97 |
|      21 |        24 | 2025-02-14 04:59:59 | transferencia |       675.00 |
|      94 |       118 | 2025-05-31 21:28:54 | tarjeta       |       630.00 |
|      81 |        99 | 2023-07-13 14:11:10 | transferencia |       625.70 |
|      90 |       111 | 2024-07-09 22:08:34 | paypal        |       623.89 |
|      39 |        41 | 2023-06-08 15:30:04 | tarjeta       |       605.70 |
|      63 |        78 | 2024-08-21 07:52:40 | transferencia |       601.89 |
|     114 |       140 | 2025-06-04 00:57:31 | paypal        |       595.00 |
|      70 |        86 | 2024-03-01 20:12:50 | paypal        |       579.41 |
|      23 |        25 | 2024-06-12 16:22:12 | transferencia |       577.91 |
|      20 |        23 | 2025-01-17 07:17:51 | transferencia |       565.97 |
|      22 |        25 | 2024-06-11 17:22:12 | paypal        |       559.09 |
|      75 |        92 | 2024-02-24 05:47:14 | tarjeta       |       541.08 |
|      32 |        37 | 2024-07-24 18:54:37 | transferencia |       539.11 |
|      80 |        97 | 2024-12-21 15:45:45 | transferencia |       511.36 |
|      71 |        86 | 2024-03-02 19:12:50 | tarjeta       |       504.99 |
|     116 |       141 | 2024-06-20 14:58:36 | transferencia |       500.60 |
|      11 |        13 | 2023-07-03 06:07:56 | tarjeta       |       495.00 |
|      67 |        81 | 2025-08-07 08:41:09 | tarjeta       |       493.90 |
|      19 |        22 | 2024-06-16 11:21:24 | paypal        |       474.50 |
|      85 |       105 | 2023-07-14 04:03:36 | transferencia |       461.00 |
|      73 |        88 | 2024-07-04 11:03:36 | paypal        |       435.60 |
|     111 |       136 | 2025-02-21 10:38:58 | transferencia |       433.08 |
|      89 |       110 | 2024-11-14 16:00:29 | transferencia |       425.94 |
|      29 |        34 | 2025-02-04 18:16:23 | transferencia |       420.00 |
|      66 |        80 | 2025-03-07 23:03:31 | tarjeta       |       411.97 |
|      25 |        30 | 2025-01-31 13:25:48 | tarjeta       |       403.76 |
|     106 |       129 | 2024-03-20 10:40:09 | tarjeta       |       398.70 |
|      36 |        39 | 2025-07-02 15:12:28 | paypal        |       391.34 |
|      56 |        66 | 2024-11-29 09:12:46 | tarjeta       |       387.00 |
|      16 |        18 | 2023-10-19 00:35:34 | tarjeta       |       360.00 |
|       7 |         9 | 2023-10-15 11:21:56 | paypal        |       348.97 |
|      48 |        59 | 2025-03-05 01:52:27 | paypal        |       347.44 |
|      52 |        62 | 2024-02-05 08:21:29 | tarjeta       |       340.67 |
|       2 |         2 | 2023-04-04 10:00:00 | paypal        |       320.00 |
|      59 |        74 | 2024-12-02 10:42:30 | transferencia |       317.00 |
|      35 |        39 | 2025-07-01 16:12:28 | paypal        |       309.64 |
|      38 |        40 | 2024-08-01 21:10:14 | tarjeta       |       304.06 |
|     107 |       132 | 2025-05-15 12:13:36 | tarjeta       |       302.82 |
|      34 |        38 | 2023-12-03 22:06:19 | tarjeta       |       298.96 |
|      82 |       100 | 2024-08-16 09:38:23 | transferencia |       295.00 |
|       8 |         9 | 2023-10-16 10:21:56 | transferencia |       281.03 |
|      33 |        37 | 2024-07-25 17:54:37 | tarjeta       |       271.49 |
|      62 |        78 | 2024-08-20 08:52:40 | paypal        |       261.07 |
|      43 |        47 | 2025-09-09 00:58:53 | tarjeta       |       258.99 |
|      99 |       123 | 2025-08-23 19:58:05 | transferencia |       257.00 |
|      88 |       109 | 2023-12-18 18:19:57 | paypal        |       249.60 |
|     113 |       139 | 2024-08-30 10:53:45 | tarjeta       |       244.50 |
|      87 |       109 | 2023-12-17 19:19:57 | transferencia |       237.40 |
|     104 |       127 | 2023-10-15 09:07:49 | paypal        |       231.95 |
|      95 |       119 | 2024-03-03 12:46:42 | tarjeta       |       229.00 |
|     120 |       146 | 2025-08-21 22:42:36 | tarjeta       |       223.70 |
|     110 |       136 | 2025-02-20 11:38:58 | transferencia |       214.58 |
|       4 |         5 | 2023-04-12 09:30:00 | transferencia |       210.00 |
|      37 |        40 | 2024-07-31 22:10:14 | transferencia |       176.92 |
|      69 |        85 | 2024-09-08 11:20:31 | tarjeta       |       159.60 |
|     103 |       127 | 2023-10-14 10:07:49 | paypal        |       158.91 |
|     121 |       148 | 2025-01-09 04:25:02 | paypal        |       158.80 |
|      54 |        63 | 2025-03-20 04:10:46 | paypal        |       139.60 |
|     122 |       150 | 2024-07-16 09:54:02 | tarjeta       |       126.50 |
|      49 |        60 | 2025-07-25 06:49:19 | paypal        |       104.70 |
|      60 |        75 | 2024-11-08 15:11:45 | tarjeta       |        99.96 |
|      18 |        21 | 2023-05-23 20:47:29 | tarjeta       |        79.90 |
|      51 |        61 | 2024-05-13 12:22:02 | transferencia |        75.86 |
|      97 |       121 | 2023-05-12 06:35:14 | tarjeta       |        75.00 |
|     112 |       138 | 2024-07-18 13:21:34 | paypal        |        74.97 |
|     100 |       124 | 2025-03-03 16:46:22 | transferencia |        69.99 |
|     123 |       150 | 2024-07-17 08:54:02 | tarjeta       |        69.50 |
|      41 |        43 | 2023-10-15 20:58:00 | paypal        |        59.00 |
|      50 |        61 | 2024-05-12 13:22:02 | paypal        |        54.11 |
|      72 |        87 | 2024-11-20 11:05:39 | tarjeta       |        45.31 |
|      30 |        35 | 2023-11-08 10:42:52 | transferencia |        42.23 |
|     127 |       154 | 2023-07-24 07:59:43 | transferencia |        39.90 |
|      84 |       104 | 2023-08-13 08:34:54 | tarjeta       |        31.78 |
|      64 |        79 | 2025-05-22 19:34:54 | tarjeta       |        15.05 |
|      65 |        79 | 2025-05-23 18:34:54 | transferencia |         9.95 |
|       3 |         3 | NULL                | tarjeta       |         0.00 |
+---------+-----------+---------------------+---------------+--------------+
127 rows in set (0,00 sec)

```
- Pedidos ordenados por total ASC.
```
mysql> select * from pedidos order by coste_total asc;
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|       155 |         28 | 2023-06-16 15:24:32 | pendiente |       11.99 |
|         3 |          1 | 2023-04-05 12:45:00 | pendiente |       25.00 |
|        79 |         33 | 2025-05-22 18:34:54 | entregado |       25.00 |
|       154 |         17 | 2023-07-24 05:59:43 | enviado   |       39.90 |
|       101 |          4 | 2025-02-25 15:05:06 | cancelado |       49.00 |
|        43 |          7 | 2023-10-15 18:58:00 | entregado |       59.00 |
|       124 |         15 | 2025-03-03 14:46:22 | entregado |       69.99 |
|       138 |         20 | 2024-07-18 11:21:34 | entregado |       74.97 |
|       121 |         32 | 2023-05-12 04:35:14 | enviado   |       75.00 |
|        21 |         30 | 2023-05-23 18:47:29 | enviado   |       79.90 |
|        49 |         20 | 2025-03-20 11:20:53 | cancelado |       89.98 |
|        75 |          6 | 2024-11-08 13:11:45 | entregado |       99.96 |
|        60 |         27 | 2025-07-25 04:49:19 | entregado |      104.70 |
|        95 |         26 | 2024-12-22 17:32:18 | pendiente |      104.70 |
|        72 |         16 | 2025-02-02 00:15:34 | pendiente |      123.97 |
|        61 |          2 | 2024-05-12 12:22:02 | enviado   |      129.97 |
|        63 |         15 | 2025-03-20 02:10:46 | enviado   |      139.60 |
|        20 |         44 | 2025-05-02 21:23:21 | cancelado |      147.98 |
|       114 |         35 | 2025-02-06 07:24:00 | entregado |      149.79 |
|       148 |         45 | 2025-01-09 02:25:02 | entregado |      158.80 |
|        85 |         42 | 2024-09-08 09:20:31 | entregado |      159.60 |
|        98 |         10 | 2025-01-01 08:54:38 | cancelado |      178.00 |
|         4 |          3 | 2023-04-10 09:10:00 | cancelado |      180.00 |
|        69 |          5 | 2023-09-21 13:34:12 | pendiente |      193.97 |
|       150 |          1 | 2024-07-16 08:54:02 | entregado |      196.00 |
|        35 |         44 | 2023-11-08 07:42:52 | pendiente |      209.98 |
|         5 |          4 | 2023-04-11 13:00:00 | entregado |      210.00 |
|       146 |         12 | 2025-08-21 20:42:36 | enviado   |      223.70 |
|        87 |         26 | 2024-11-20 08:05:39 | pendiente |      227.06 |
|       119 |         42 | 2024-03-03 10:46:42 | entregado |      229.00 |
|       139 |          5 | 2024-08-30 08:53:45 | entregado |      244.50 |
|        82 |          4 | 2024-12-20 16:05:11 | pendiente |      248.50 |
|        53 |         25 | 2024-04-28 02:49:10 | pendiente |      249.99 |
|       123 |         30 | 2025-08-23 17:58:05 | enviado   |      257.00 |
|        47 |          5 | 2025-09-08 22:58:53 | entregado |      258.99 |
|        56 |          9 | 2023-07-05 08:36:02 | entregado |      260.99 |
|       100 |         14 | 2024-08-16 07:38:23 | enviado   |      295.00 |
|       115 |         27 | 2023-12-19 13:15:54 | cancelado |      297.90 |
|        38 |          3 | 2023-12-03 20:06:19 | entregado |      298.96 |
|        51 |         45 | 2025-05-12 20:38:03 | cancelado |      308.00 |
|        74 |          1 | 2024-12-02 08:42:30 | entregado |      317.00 |
|        55 |         30 | 2025-08-25 08:07:24 | pendiente |      319.60 |
|         2 |          2 | 2023-04-03 15:30:00 | enviado   |      320.00 |
|        59 |         30 | 2025-03-04 23:52:27 | entregado |      347.44 |
|        18 |          4 | 2023-10-18 22:35:34 | entregado |      360.00 |
|       103 |          3 | 2025-07-16 07:06:39 | cancelado |      375.00 |
|        66 |         36 | 2024-11-29 07:12:46 | entregado |      387.00 |
|       127 |          4 | 2023-10-14 09:07:49 | entregado |      390.86 |
|       129 |         39 | 2024-03-20 08:40:09 | entregado |      398.70 |
|        30 |         21 | 2025-01-31 11:25:48 | enviado   |      403.76 |
|        80 |         24 | 2025-03-07 21:03:31 | entregado |      411.97 |
|       137 |          2 | 2025-02-05 06:48:16 | pendiente |      415.00 |
|        34 |         15 | 2025-02-04 16:16:23 | entregado |      420.00 |
|       110 |         19 | 2024-11-14 14:00:29 | entregado |      425.94 |
|        88 |         17 | 2024-07-04 09:03:36 | entregado |      435.60 |
|       147 |          7 | 2023-07-12 20:59:04 | pendiente |      441.70 |
|       143 |         21 | 2023-05-11 21:31:45 | cancelado |      443.97 |
|       105 |         44 | 2023-07-14 02:03:36 | entregado |      461.00 |
|        22 |          7 | 2024-06-16 09:21:24 | enviado   |      474.50 |
|        40 |         14 | 2024-07-31 21:10:14 | entregado |      480.98 |
|       109 |          6 | 2023-12-17 18:19:57 | enviado   |      487.00 |
|        29 |          5 | 2025-05-11 18:49:48 | cancelado |      487.95 |
|        81 |         27 | 2025-08-07 06:41:09 | enviado   |      493.90 |
|        13 |         24 | 2023-07-03 04:07:56 | entregado |      495.00 |
|       141 |         23 | 2024-06-20 12:58:36 | entregado |      500.60 |
|        23 |         43 | 2025-01-17 05:17:51 | enviado   |      565.97 |
|        41 |         25 | 2023-06-08 13:30:04 | entregado |      605.70 |
|       111 |         15 | 2024-07-09 20:08:34 | enviado   |      623.89 |
|        99 |         10 | 2023-07-13 12:11:10 | enviado   |      625.70 |
|         9 |         35 | 2023-10-15 10:21:56 | enviado   |      630.00 |
|       118 |         24 | 2025-05-31 19:28:54 | entregado |      630.00 |
|        45 |         43 | 2024-08-31 03:45:22 | enviado   |      631.33 |
|       136 |          8 | 2025-02-20 10:38:58 | entregado |      647.66 |
|        24 |          6 | 2025-02-14 02:59:59 | entregado |      675.00 |
|        71 |          9 | 2024-11-08 04:19:43 | cancelado |      682.26 |
|         7 |         37 | 2025-07-14 10:22:00 | pendiente |      697.90 |
|        10 |         29 | 2024-11-24 01:35:05 | entregado |      698.97 |
|        39 |         44 | 2025-07-01 15:12:28 | entregado |      700.98 |
|       107 |         29 | 2024-08-31 12:22:43 | pendiente |      707.25 |
|       104 |         13 | 2023-08-13 06:34:54 | cancelado |      726.06 |
|       108 |          4 | 2025-03-20 06:56:54 | enviado   |      747.00 |
|        11 |         23 | 2023-11-28 17:03:33 | cancelado |      750.00 |
|       126 |         17 | 2025-06-17 13:01:26 | entregado |      750.00 |
|        65 |         38 | 2024-09-28 06:43:50 | pendiente |      752.56 |
|        90 |         11 | 2024-05-07 15:34:48 | entregado |      759.76 |
|        93 |          9 | 2023-07-21 06:15:47 | cancelado |      774.66 |
|        31 |         41 | 2023-05-23 13:59:20 | entregado |      784.95 |
|       125 |         41 | 2023-11-11 22:35:27 | entregado |      789.58 |
|       106 |         25 | 2025-02-07 12:19:12 | cancelado |      789.96 |
|        76 |         36 | 2024-01-16 23:04:06 | cancelado |      798.00 |
|        68 |         39 | 2024-05-12 17:45:07 | entregado |      799.55 |
|        37 |         11 | 2024-07-24 17:54:37 | enviado   |      810.60 |
|       116 |         16 | 2024-12-15 11:42:22 | pendiente |      847.00 |
|        78 |          7 | 2024-08-20 07:52:40 | entregado |      862.96 |
|       113 |          5 | 2023-05-19 08:05:29 | entregado |      866.80 |
|        44 |          9 | 2025-07-23 07:42:42 | entregado |      876.00 |
|        15 |         37 | 2025-08-05 07:42:28 | entregado |      878.00 |
|       131 |         35 | 2023-08-06 10:00:18 | cancelado |      892.10 |
|        33 |         32 | 2025-04-01 14:18:12 | enviado   |      914.08 |
|        16 |          1 | 2025-07-17 02:39:18 | entregado |      926.16 |
|       144 |         34 | 2025-05-24 00:03:02 | entregado |      928.40 |
|        58 |         32 | 2025-05-18 23:57:07 | enviado   |      934.80 |
|        52 |         26 | 2024-09-14 18:26:50 | cancelado |      970.44 |
|        70 |         36 | 2024-03-08 11:36:16 | enviado   |      970.97 |
|         8 |         37 | 2024-03-09 22:58:56 | enviado   |      983.46 |
|       112 |         42 | 2023-05-27 05:25:59 | entregado |      988.96 |
|        36 |         16 | 2025-08-14 12:00:30 | enviado   |     1024.92 |
|       132 |         45 | 2025-05-15 09:13:36 | pendiente |     1045.00 |
|        67 |         33 | 2025-05-12 23:48:40 | pendiente |     1065.00 |
|         1 |          1 | 2023-04-01 10:00:00 | entregado |     1070.00 |
|       134 |         31 | 2025-07-13 03:57:51 | cancelado |     1079.88 |
|        86 |         30 | 2024-03-01 19:12:50 | entregado |     1084.40 |
|       149 |         45 | 2024-11-22 07:43:09 | entregado |     1095.70 |
|        62 |         42 | 2024-02-05 07:21:29 | entregado |     1132.00 |
|        25 |         25 | 2024-06-11 16:22:12 | enviado   |     1137.00 |
|        12 |         13 | 2025-01-06 23:09:18 | entregado |     1175.67 |
|       135 |         28 | 2025-03-19 22:32:32 | enviado   |     1196.00 |
|        14 |          1 | 2023-12-20 04:45:24 | entregado |     1196.76 |
|        46 |         40 | 2025-03-04 09:48:02 | entregado |     1205.98 |
|        91 |          4 | 2025-03-19 15:55:01 | cancelado |     1218.59 |
|       142 |         13 | 2025-06-09 10:12:15 | entregado |     1240.58 |
|        42 |         34 | 2024-11-23 20:06:35 | enviado   |     1257.87 |
|        97 |         40 | 2024-12-20 15:45:45 | entregado |     1336.00 |
|       152 |         10 | 2024-09-17 15:21:00 | entregado |     1389.88 |
|        77 |         45 | 2024-03-24 13:08:23 | enviado   |     1415.69 |
|        27 |         14 | 2024-05-25 16:05:00 | cancelado |     1500.00 |
|       122 |         21 | 2023-11-06 02:20:32 | entregado |     1509.99 |
|        84 |          8 | 2023-09-09 05:08:29 | entregado |     1544.00 |
|       140 |         35 | 2025-06-03 23:57:31 | entregado |     1584.00 |
|       117 |         12 | 2024-02-23 06:50:55 | enviado   |     1601.97 |
|        50 |         31 | 2023-12-10 14:52:01 | enviado   |     1631.96 |
|        54 |         27 | 2025-06-19 19:08:47 | entregado |     1636.97 |
|        57 |         27 | 2024-09-19 21:37:37 | pendiente |     1690.00 |
|        73 |         32 | 2023-05-19 23:18:06 | enviado   |     1713.00 |
|       102 |         18 | 2025-01-15 04:47:50 | enviado   |     1722.00 |
|       120 |         24 | 2024-01-20 23:24:47 | entregado |     1743.98 |
|        92 |         39 | 2024-02-24 04:47:14 | enviado   |     1753.90 |
|        64 |         34 | 2024-10-30 02:17:30 | enviado   |     1809.99 |
|        19 |         20 | 2024-04-01 15:21:06 | entregado |     1954.00 |
|       133 |         39 | 2023-09-14 21:53:03 | entregado |     2004.59 |
|       130 |         20 | 2024-06-10 08:32:30 | cancelado |     2129.70 |
|       145 |         13 | 2024-05-03 22:26:59 | enviado   |     2234.00 |
|        96 |         17 | 2023-05-13 12:18:02 | entregado |     2236.86 |
|        94 |         29 | 2024-08-20 06:27:14 | pendiente |     2262.96 |
|        26 |         41 | 2024-03-09 12:54:14 | pendiente |     2408.95 |
|         6 |         30 | 2025-02-06 16:22:51 | entregado |     2409.98 |
|       151 |         30 | 2023-10-05 21:07:56 | entregado |     2593.98 |
|       153 |          9 | 2024-11-29 22:17:40 | enviado   |     2701.80 |
|       128 |         10 | 2024-11-11 08:59:34 | entregado |     2783.70 |
|        32 |         28 | 2023-07-01 05:52:25 | entregado |     2957.97 |
|        48 |         17 | 2023-11-06 21:39:33 | pendiente |     3047.00 |
|        83 |         34 | 2024-06-23 21:01:43 | pendiente |     3243.87 |
|        89 |          6 | 2024-12-23 04:18:39 | entregado |     3422.00 |
|        17 |         25 | 2024-10-31 12:27:44 | enviado   |     3790.50 |
|        28 |          9 | 2024-09-22 11:14:30 | entregado |     4289.70 |
+-----------+------------+---------------------+-----------+-------------+
155 rows in set (0,00 sec)

```
- Primeros 10 clientes por orden alfabético del nombre.
```
mysql> select * from clientes order by nombre limit 10;
+------------+-----------------+-------------------------------+----------------+------------+
| id_cliente | nombre          | email                         | fecha_registro | pais       |
+------------+-----------------+-------------------------------+----------------+------------+
|         18 | Adriana Navarro | adriana.navarro18@example.com | 2023-10-31     | Paraguay   |
|         32 | Adriana Ramos   | adriana.ramos32@example.com   | 2024-05-11     | Uruguay    |
|         10 | Alba Domínguez  | alba.dominguez10@example.com  | 2023-10-26     | Italia     |
|         38 | Alba Martínez   | alba.martinez38@example.com   | 2023-07-21     | Honduras   |
|         11 | Alba Sánchez    | alba.sanchez11@example.com    | 2024-04-28     | Argentina  |
|         20 | Alicia Vázquez  | alicia.vazquez20@example.com  | 2024-12-12     | Colombia   |
|          1 | Ana Torres      | ana@example.com               | 2023-01-10     | España     |
|         15 | Andrés García   | andres.garcia15@example.com   | 2024-08-12     | Venezuela  |
|          3 | Carla Gómez     | carla@example.com             | 2023-03-20     | Chile      |
|          8 | Daniel Moreno   | daniel.moreno8@example.com    | 2023-10-13     | Costa Rica |
+------------+-----------------+-------------------------------+----------------+------------+
10 rows in set (0,00 sec)


```
- Top 5 productos más baratos en la categoría “Accesorios”.
```
mysql> select * from productos where categoria='Accesorios' order by precio limit 5;
+-------------+-----------------------+------------------------------+--------+-------+------------+
| id_producto | nombre                | descripcion                  | precio | stock | categoria  |
+-------------+-----------------------+------------------------------+--------+-------+------------+
|          30 | Organizador de cables | Pack 10 unidades             |   9.99 |   800 | Accesorios |
|          24 | Cable HDMI 2.1        | 2 metros                     |  11.99 |   500 | Accesorios |
|          19 | Altavoces 2.0         | 10W RMS                      |  24.99 |   370 | Accesorios |
|           3 | Auriculares Bluetooth | Inalámbricos con micrófono   |  25.00 |  1050 | Accesorios |
|          17 | Cámara Web 1080p      | Micrófono incorporado        |  29.00 |   390 | Accesorios |
+-------------+-----------------------+------------------------------+--------+-------+------------+
5 rows in set (0,00 sec)

```
