# Consultas SQL Graduales para tiendaonline-data.sql


## O. Intro

### Mostrar todas las tablas
```
mysql> show tables
    -> ;
+-------------------------+
| Tables_in_tienda_online |
+-------------------------+
| clientes                |
| detalle_pedido          |
| pagos                   |
| pedidos                 |
| productos               |
+-------------------------+
5 rows in set (0,00 sec)

```

### Mostrar la estructura de la tabla clientes
```
mysql> explain clientes;
+----------------+--------------+------+-----+---------+----------------+
| Field          | Type         | Null | Key | Default | Extra          |
+----------------+--------------+------+-----+---------+----------------+
| id_cliente     | int          | NO   | PRI | NULL    | auto_increment |
| nombre         | varchar(100) | NO   |     | NULL    |                |
| email          | varchar(100) | YES  | UNI | NULL    |                |
| fecha_registro | date         | YES  |     | NULL    |                |
| pais           | varchar(50)  | YES  |     | NULL    |                |
+----------------+--------------+------+-----+---------+----------------+
5 rows in set (0,00 sec)
```
## 1. Consultas Básicas

### 1.1. Mostrar todos los clientes registrados
```
mysql> select * from clientes;
+------------+--------------------+--------------------------------+----------------+-----------------------+
| id_cliente | nombre             | email                          | fecha_registro | pais                  |
+------------+--------------------+--------------------------------+----------------+-----------------------+
|          1 | Ana Torres         | ana@example.com                | 2023-01-10     | España                |
|          2 | Luis Méndez        | luis@example.com               | 2023-02-15     | México                |
|          3 | Carla Gómez        | carla@example.com              | 2023-03-20     | Chile                 |
|          4 | David Ruiz         | david@example.com              | 2023-04-05     | Argentina             |
|          5 | Sofía Paredes      | sofia@example.com              | 2023-04-25     | Perú                  |
|          6 | Marta Gil          | marta.gil6@example.com         | 2023-05-11     | Paraguay              |
|          7 | Gonzalo Jiménez    | gonzalo.jimenez7@example.com   | 2023-11-15     | Bolivia               |
|          8 | Daniel Moreno      | daniel.moreno8@example.com     | 2023-10-13     | Costa Rica            |
|          9 | Lucía Suárez       | lucia.suarez9@example.com      | 2024-07-17     | Bolivia               |
|         10 | Alba Domínguez     | alba.dominguez10@example.com   | 2023-10-26     | Italia                |
|         11 | Alba Sánchez       | alba.sanchez11@example.com     | 2024-04-28     | Argentina             |
|         12 | Hugo Gil           | hugo.gil12@example.com         | 2024-06-26     | Portugal              |
|         13 | Hugo Sánchez       | hugo.sanchez13@example.com     | 2023-09-29     | Uruguay               |
|         14 | Nicolás González   | nicolas.gonzalez14@example.com | 2023-11-11     | Venezuela             |
|         15 | Andrés García      | andres.garcia15@example.com    | 2024-08-12     | Venezuela             |
|         16 | María Alonso       | maria.alonso16@example.com     | 2025-04-07     | Panamá                |
|         17 | María García       | maria.garcia17@example.com     | 2025-03-10     | Colombia              |
|         18 | Adriana Navarro    | adriana.navarro18@example.com  | 2023-10-31     | Paraguay              |
|         19 | Lucía Domínguez    | lucia.dominguez19@example.com  | 2024-06-28     | Chile                 |
|         20 | Alicia Vázquez     | alicia.vazquez20@example.com   | 2024-12-12     | Colombia              |
|         21 | Nicolás Álvarez    | nicolas.alvarez21@example.com  | 2023-12-25     | El Salvador           |
|         22 | Irene Ramos        | irene.ramos22@example.com      | 2024-04-02     | México                |
|         23 | Elena López        | elena.lopez23@example.com      | 2024-09-23     | Uruguay               |
|         24 | Nicolás Serrano    | nicolas.serrano24@example.com  | 2025-06-13     | Nicaragua             |
|         25 | Sofía Sánchez      | sofia.sanchez25@example.com    | 2024-01-19     | Portugal              |
|         26 | Marta Alonso       | marta.alonso26@example.com     | 2023-09-10     | México                |
|         27 | Laura Ruiz         | laura.ruiz27@example.com       | 2023-05-10     | Perú                  |
|         28 | Elena Jiménez      | elena.jimenez28@example.com    | 2024-11-03     | Venezuela             |
|         29 | Laura Álvarez      | laura.alvarez29@example.com    | 2024-03-27     | España                |
|         30 | José Fernández     | jose.fernandez30@example.com   | 2025-04-28     | República Dominicana  |
|         31 | Juan Álvarez       | juan.alvarez31@example.com     | 2023-10-31     | España                |
|         32 | Adriana Ramos      | adriana.ramos32@example.com    | 2024-05-11     | Uruguay               |
|         33 | Sofía Alonso       | sofia.alonso33@example.com     | 2025-06-18     | Chile                 |
|         34 | Noelia Torres      | noelia.torres34@example.com    | 2023-07-03     | España                |
|         35 | Javier Romero      | javier.romero35@example.com    | 2024-03-29     | Italia                |
|         36 | Marta Castro       | marta.castro36@example.com     | 2024-11-14     | Uruguay               |
|         37 | Paula Ramírez      | paula.ramirez37@example.com    | 2025-03-09     | Chile                 |
|         38 | Alba Martínez      | alba.martinez38@example.com    | 2023-07-21     | Honduras              |
|         39 | Laura Ortega       | laura.ortega39@example.com     | 2024-04-08     | Ecuador               |
|         40 | Miguel Sánchez     | miguel.sanchez40@example.com   | 2023-10-14     | Paraguay              |
|         41 | Pablo Gutiérrez    | pablo.gutierrez41@example.com  | 2023-08-01     | El Salvador           |
|         42 | Valeria García     | valeria.garcia42@example.com   | 2023-09-28     | España                |
|         43 | Sofía Romero       | sofia.romero43@example.com     | 2023-11-06     | Italia                |
|         44 | Raúl Suárez        | raul.suarez44@example.com      | 2023-08-07     | Bolivia               |
|         45 | Hugo Ramírez       | hugo.ramirez45@example.com     | 2024-06-19     | Argentina             |
+------------+--------------------+--------------------------------+----------------+-----------------------+

```
### 1.2. Mostrar todos los productos disponibles
```
mysql> select * from productos;
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
| id_producto | nombre                    | descripcion                          | precio | stock | categoria    |
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
|           1 | Laptop Dell Inspiron      | Laptop 15" Intel i5                  | 750.00 |  1012 | Electrónica  |
|           2 | Smartphone Xiaomi         | Redmi Note 11 Pro                    | 320.00 |  1030 | Electrónica  |
|           3 | Auriculares Bluetooth     | Inalámbricos con micrófono           |  25.00 |  1050 | Accesorios   |
|           4 | Silla Gamer               | Silla ergonómica con soporte lumbar  | 180.00 |  1005 | Muebles      |
|           5 | Escritorio                | Escritorio de madera para oficina    | 210.00 |  1007 | Muebles      |
|           6 | Monitor LG 24"            | Monitor IPS Full HD 24"              | 129.99 |   340 | Electrónica  |
|           7 | Teclado Mecánico          | Switches rojos, layout ES            |  59.90 |   370 | Accesorios   |
|           8 | Ratón Inalámbrico         | 16000 DPI, recargable                |  39.50 |   380 | Accesorios   |
|           9 | Impresora HP DeskJet      | Multifunción Wi-Fi                   |  89.00 |   325 | Electrónica  |
|          10 | Tablet Samsung            | Galaxy Tab A8 64GB                   | 229.00 |   330 | Electrónica  |
|          11 | Smartwatch Amazfit        | Autonomía 14 días                    |  79.00 |   350 | Electrónica  |
|          12 | Disco SSD 1TB             | NVMe PCIe 3.0                        |  79.99 |   360 | Componentes  |
|          13 | Memoria RAM 16GB          | DDR4 3200MHz (2x8GB)                 |  44.99 |   365 | Componentes  |
|          14 | Placa Base MSI            | mATX B560M                           | 119.00 |   315 | Componentes  |
|          15 | Fuente 650W 80+ Bronze    | ATX, silenciosa                      |  59.00 |   325 | Componentes  |
|          16 | Tarjeta Gráfica RTX 3060  | 12GB GDDR6                           | 299.00 |   312 | Componentes  |
|          17 | Cámara Web 1080p          | Micrófono incorporado                |  29.00 |   390 | Accesorios   |
|          18 | Micrófono USB             | Cardioide, plug&play                 |  49.00 |   340 | Accesorios   |
|          19 | Altavoces 2.0             | 10W RMS                              |  24.99 |   370 | Accesorios   |
|          20 | Regleta 6 tomas           | Protección sobretensiones            |  19.50 |   400 | Hogar        |
|          21 | Silla de Oficina          | Ergonómica malla                     | 129.00 |   320 | Muebles      |
|          22 | Lámpara LED escritorio    | Brillo regulable                     |  22.00 |   380 | Hogar        |
|          23 | Mochila para portátil     | 15.6" impermeable                    |  34.90 |   360 | Accesorios   |
|          24 | Cable HDMI 2.1            | 2 metros                             |  11.99 |   500 | Accesorios   |
|          25 | Hub USB-C 6 en 1          | HDMI+USB3+SD                         |  39.90 |   350 | Accesorios   |
|          26 | Router Wi-Fi 6            | AX3000 doble banda                   |  79.90 |   330 | Electrónica  |
|          27 | NAS 2 Bahías              | Soporta RAID1                        | 249.00 |   310 | Electrónica  |
|          28 | Silla Gamer Pro           | Reclinable 160°                      | 229.00 |   310 | Muebles      |
|          29 | Escritorio en L           | 120x140 cm                           | 189.00 |   312 | Muebles      |
|          30 | Organizador de cables     | Pack 10 unidades                     |   9.99 |   800 | Accesorios   |
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
30 rows in set (0,00 sec)

```
### 1.3. Mostrar todos los pedidos realizados
```
mysql> select * from pedidos;
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|         1 |          1 | 2023-04-01 10:00:00 | entregado |     1070.00 |
|         2 |          2 | 2023-04-03 15:30:00 | enviado   |      320.00 |
|         3 |          1 | 2023-04-05 12:45:00 | pendiente |       25.00 |
|         4 |          3 | 2023-04-10 09:10:00 | cancelado |      180.00 |
|         5 |          4 | 2023-04-11 13:00:00 | entregado |      210.00 |
|         6 |         30 | 2025-02-06 16:22:51 | entregado |     2409.98 |
|         7 |         37 | 2025-07-14 10:22:00 | pendiente |      697.90 |
|         8 |         37 | 2024-03-09 22:58:56 | enviado   |      983.46 |
|         9 |         35 | 2023-10-15 10:21:56 | enviado   |      630.00 |
|        10 |         29 | 2024-11-24 01:35:05 | entregado |      698.97 |
|        11 |         23 | 2023-11-28 17:03:33 | cancelado |      750.00 |
|        12 |         13 | 2025-01-06 23:09:18 | entregado |     1175.67 |
|        13 |         24 | 2023-07-03 04:07:56 | entregado |      495.00 |
|        14 |          1 | 2023-12-20 04:45:24 | entregado |     1196.76 |
|        15 |         37 | 2025-08-05 07:42:28 | entregado |      878.00 |
|        16 |          1 | 2025-07-17 02:39:18 | entregado |      926.16 |
|        17 |         25 | 2024-10-31 12:27:44 | enviado   |     3790.50 |
|        18 |          4 | 2023-10-18 22:35:34 | entregado |      360.00 |
|        19 |         20 | 2024-04-01 15:21:06 | entregado |     1954.00 |
|        20 |         44 | 2025-05-02 21:23:21 | cancelado |      147.98 |
|        21 |         30 | 2023-05-23 18:47:29 | enviado   |       79.90 |
|        22 |          7 | 2024-06-16 09:21:24 | enviado   |      474.50 |
|        23 |         43 | 2025-01-17 05:17:51 | enviado   |      565.97 |
|        24 |          6 | 2025-02-14 02:59:59 | entregado |      675.00 |
|        25 |         25 | 2024-06-11 16:22:12 | enviado   |     1137.00 |
|        26 |         41 | 2024-03-09 12:54:14 | pendiente |     2408.95 |
|        27 |         14 | 2024-05-25 16:05:00 | cancelado |     1500.00 |
|        28 |          9 | 2024-09-22 11:14:30 | entregado |     4289.70 |
|        29 |          5 | 2025-05-11 18:49:48 | cancelado |      487.95 |
|        30 |         21 | 2025-01-31 11:25:48 | enviado   |      403.76 |
|        31 |         41 | 2023-05-23 13:59:20 | entregado |      784.95 |
|        32 |         28 | 2023-07-01 05:52:25 | entregado |     2957.97 |
|        33 |         32 | 2025-04-01 14:18:12 | enviado   |      914.08 |
|        34 |         15 | 2025-02-04 16:16:23 | entregado |      420.00 |
|        35 |         44 | 2023-11-08 07:42:52 | pendiente |      209.98 |
|        36 |         16 | 2025-08-14 12:00:30 | enviado   |     1024.92 |
|        37 |         11 | 2024-07-24 17:54:37 | enviado   |      810.60 |
|        38 |          3 | 2023-12-03 20:06:19 | entregado |      298.96 |
|        39 |         44 | 2025-07-01 15:12:28 | entregado |      700.98 |
|        40 |         14 | 2024-07-31 21:10:14 | entregado |      480.98 |
|        41 |         25 | 2023-06-08 13:30:04 | entregado |      605.70 |
|        42 |         34 | 2024-11-23 20:06:35 | enviado   |     1257.87 |
|        43 |          7 | 2023-10-15 18:58:00 | entregado |       59.00 |
|        44 |          9 | 2025-07-23 07:42:42 | entregado |      876.00 |
|        45 |         43 | 2024-08-31 03:45:22 | enviado   |      631.33 |
|        46 |         40 | 2025-03-04 09:48:02 | entregado |     1205.98 |
|        47 |          5 | 2025-09-08 22:58:53 | entregado |      258.99 |
|        48 |         17 | 2023-11-06 21:39:33 | pendiente |     3047.00 |
|        49 |         20 | 2025-03-20 11:20:53 | cancelado |       89.98 |
|        50 |         31 | 2023-12-10 14:52:01 | enviado   |     1631.96 |
|        51 |         45 | 2025-05-12 20:38:03 | cancelado |      308.00 |
|        52 |         26 | 2024-09-14 18:26:50 | cancelado |      970.44 |
|        53 |         25 | 2024-04-28 02:49:10 | pendiente |      249.99 |
|        54 |         27 | 2025-06-19 19:08:47 | entregado |     1636.97 |
|        55 |         30 | 2025-08-25 08:07:24 | pendiente |      319.60 |
|        56 |          9 | 2023-07-05 08:36:02 | entregado |      260.99 |
|        57 |         27 | 2024-09-19 21:37:37 | pendiente |     1690.00 |
|        58 |         32 | 2025-05-18 23:57:07 | enviado   |      934.80 |
|        59 |         30 | 2025-03-04 23:52:27 | entregado |      347.44 |
|        60 |         27 | 2025-07-25 04:49:19 | entregado |      104.70 |
|        61 |          2 | 2024-05-12 12:22:02 | enviado   |      129.97 |
|        62 |         42 | 2024-02-05 07:21:29 | entregado |     1132.00 |
|        63 |         15 | 2025-03-20 02:10:46 | enviado   |      139.60 |
|        64 |         34 | 2024-10-30 02:17:30 | enviado   |     1809.99 |
|        65 |         38 | 2024-09-28 06:43:50 | pendiente |      752.56 |
|        66 |         36 | 2024-11-29 07:12:46 | entregado |      387.00 |
|        67 |         33 | 2025-05-12 23:48:40 | pendiente |     1065.00 |
|        68 |         39 | 2024-05-12 17:45:07 | entregado |      799.55 |
|        69 |          5 | 2023-09-21 13:34:12 | pendiente |      193.97 |
|        70 |         36 | 2024-03-08 11:36:16 | enviado   |      970.97 |
|        71 |          9 | 2024-11-08 04:19:43 | cancelado |      682.26 |
|        72 |         16 | 2025-02-02 00:15:34 | pendiente |      123.97 |
|        73 |         32 | 2023-05-19 23:18:06 | enviado   |     1713.00 |
|        74 |          1 | 2024-12-02 08:42:30 | entregado |      317.00 |
|        75 |          6 | 2024-11-08 13:11:45 | entregado |       99.96 |
|        76 |         36 | 2024-01-16 23:04:06 | cancelado |      798.00 |
|        77 |         45 | 2024-03-24 13:08:23 | enviado   |     1415.69 |
|        78 |          7 | 2024-08-20 07:52:40 | entregado |      862.96 |
|        79 |         33 | 2025-05-22 18:34:54 | entregado |       25.00 |
|        80 |         24 | 2025-03-07 21:03:31 | entregado |      411.97 |
|        81 |         27 | 2025-08-07 06:41:09 | enviado   |      493.90 |
|        82 |          4 | 2024-12-20 16:05:11 | pendiente |      248.50 |
|        83 |         34 | 2024-06-23 21:01:43 | pendiente |     3243.87 |
|        84 |          8 | 2023-09-09 05:08:29 | entregado |     1544.00 |
|        85 |         42 | 2024-09-08 09:20:31 | entregado |      159.60 |
|        86 |         30 | 2024-03-01 19:12:50 | entregado |     1084.40 |
|        87 |         26 | 2024-11-20 08:05:39 | pendiente |      227.06 |
|        88 |         17 | 2024-07-04 09:03:36 | entregado |      435.60 |
|        89 |          6 | 2024-12-23 04:18:39 | entregado |     3422.00 |
|        90 |         11 | 2024-05-07 15:34:48 | entregado |      759.76 |
|        91 |          4 | 2025-03-19 15:55:01 | cancelado |     1218.59 |
|        92 |         39 | 2024-02-24 04:47:14 | enviado   |     1753.90 |
|        93 |          9 | 2023-07-21 06:15:47 | cancelado |      774.66 |
|        94 |         29 | 2024-08-20 06:27:14 | pendiente |     2262.96 |
|        95 |         26 | 2024-12-22 17:32:18 | pendiente |      104.70 |
|        96 |         17 | 2023-05-13 12:18:02 | entregado |     2236.86 |
|        97 |         40 | 2024-12-20 15:45:45 | entregado |     1336.00 |
|        98 |         10 | 2025-01-01 08:54:38 | cancelado |      178.00 |
|        99 |         10 | 2023-07-13 12:11:10 | enviado   |      625.70 |
|       100 |         14 | 2024-08-16 07:38:23 | enviado   |      295.00 |
|       101 |          4 | 2025-02-25 15:05:06 | cancelado |       49.00 |
|       102 |         18 | 2025-01-15 04:47:50 | enviado   |     1722.00 |
|       103 |          3 | 2025-07-16 07:06:39 | cancelado |      375.00 |
|       104 |         13 | 2023-08-13 06:34:54 | cancelado |      726.06 |
|       105 |         44 | 2023-07-14 02:03:36 | entregado |      461.00 |
|       106 |         25 | 2025-02-07 12:19:12 | cancelado |      789.96 |
|       107 |         29 | 2024-08-31 12:22:43 | pendiente |      707.25 |
|       108 |          4 | 2025-03-20 06:56:54 | enviado   |      747.00 |
|       109 |          6 | 2023-12-17 18:19:57 | enviado   |      487.00 |
|       110 |         19 | 2024-11-14 14:00:29 | entregado |      425.94 |
|       111 |         15 | 2024-07-09 20:08:34 | enviado   |      623.89 |
|       112 |         42 | 2023-05-27 05:25:59 | entregado |      988.96 |
|       113 |          5 | 2023-05-19 08:05:29 | entregado |      866.80 |
|       114 |         35 | 2025-02-06 07:24:00 | entregado |      149.79 |
|       115 |         27 | 2023-12-19 13:15:54 | cancelado |      297.90 |
|       116 |         16 | 2024-12-15 11:42:22 | pendiente |      847.00 |
|       117 |         12 | 2024-02-23 06:50:55 | enviado   |     1601.97 |
|       118 |         24 | 2025-05-31 19:28:54 | entregado |      630.00 |
|       119 |         42 | 2024-03-03 10:46:42 | entregado |      229.00 |
|       120 |         24 | 2024-01-20 23:24:47 | entregado |     1743.98 |
|       121 |         32 | 2023-05-12 04:35:14 | enviado   |       75.00 |
|       122 |         21 | 2023-11-06 02:20:32 | entregado |     1509.99 |
|       123 |         30 | 2025-08-23 17:58:05 | enviado   |      257.00 |
|       124 |         15 | 2025-03-03 14:46:22 | entregado |       69.99 |
|       125 |         41 | 2023-11-11 22:35:27 | entregado |      789.58 |
|       126 |         17 | 2025-06-17 13:01:26 | entregado |      750.00 |
|       127 |          4 | 2023-10-14 09:07:49 | entregado |      390.86 |
|       128 |         10 | 2024-11-11 08:59:34 | entregado |     2783.70 |
|       129 |         39 | 2024-03-20 08:40:09 | entregado |      398.70 |
|       130 |         20 | 2024-06-10 08:32:30 | cancelado |     2129.70 |
|       131 |         35 | 2023-08-06 10:00:18 | cancelado |      892.10 |
|       132 |         45 | 2025-05-15 09:13:36 | pendiente |     1045.00 |
|       133 |         39 | 2023-09-14 21:53:03 | entregado |     2004.59 |
|       134 |         31 | 2025-07-13 03:57:51 | cancelado |     1079.88 |
|       135 |         28 | 2025-03-19 22:32:32 | enviado   |     1196.00 |
|       136 |          8 | 2025-02-20 10:38:58 | entregado |      647.66 |
|       137 |          2 | 2025-02-05 06:48:16 | pendiente |      415.00 |
|       138 |         20 | 2024-07-18 11:21:34 | entregado |       74.97 |
|       139 |          5 | 2024-08-30 08:53:45 | entregado |      244.50 |
|       140 |         35 | 2025-06-03 23:57:31 | entregado |     1584.00 |
|       141 |         23 | 2024-06-20 12:58:36 | entregado |      500.60 |
|       142 |         13 | 2025-06-09 10:12:15 | entregado |     1240.58 |
|       143 |         21 | 2023-05-11 21:31:45 | cancelado |      443.97 |
|       144 |         34 | 2025-05-24 00:03:02 | entregado |      928.40 |
|       145 |         13 | 2024-05-03 22:26:59 | enviado   |     2234.00 |
|       146 |         12 | 2025-08-21 20:42:36 | enviado   |      223.70 |
|       147 |          7 | 2023-07-12 20:59:04 | pendiente |      441.70 |
|       148 |         45 | 2025-01-09 02:25:02 | entregado |      158.80 |
|       149 |         45 | 2024-11-22 07:43:09 | entregado |     1095.70 |
|       150 |          1 | 2024-07-16 08:54:02 | entregado |      196.00 |
|       151 |         30 | 2023-10-05 21:07:56 | entregado |     2593.98 |
|       152 |         10 | 2024-09-17 15:21:00 | entregado |     1389.88 |
|       153 |          9 | 2024-11-29 22:17:40 | enviado   |     2701.80 |
|       154 |         17 | 2023-07-24 05:59:43 | enviado   |       39.90 |
|       155 |         28 | 2023-06-16 15:24:32 | pendiente |       11.99 |
+-----------+------------+---------------------+-----------+-------------+
155 rows in set (0,00 sec)

```

## 2. Consultas Básicas seleccionando campos específicos

### 2.1. Mostrar solo el nombre y el email de todos los clientes
**PD: primero se observan los elementos de la tabla para poder seleccionarlos**
```
mysql> select * from clientes limit 1;
+------------+------------+-----------------+----------------+---------+
| id_cliente | nombre     | email           | fecha_registro | pais    |
+------------+------------+-----------------+----------------+---------+
|          1 | Ana Torres | ana@example.com | 2023-01-10     | España  |
+------------+------------+-----------------+----------------+---------+
1 row in set (0,00 sec)

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
45 rows in set (0,00 sec)

```
### 2.2. Mostrar solo el nombre y el precio de todos los productos
**PD: primero se observan los elementos de la tabla para poder seleccionarlos**
```
mysql> select * from productos limit 1;
+-------------+----------------------+---------------------+--------+-------+--------------+
| id_producto | nombre               | descripcion         | precio | stock | categoria    |
+-------------+----------------------+---------------------+--------+-------+--------------+
|           1 | Laptop Dell Inspiron | Laptop 15" Intel i5 | 750.00 |  1012 | Electrónica  |
+-------------+----------------------+---------------------+--------+-------+--------------+
1 row in set (0,00 sec)


mysql> select nombre,precio from productos;
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
30 rows in set (0,00 sec)

```
### 2.3. Mostrar solo el nombre y el estado de todos los pedidos
```
mysql> select id_pedido,estado from pedidos;
+-----------+-----------+
| id_pedido | estado    |
+-----------+-----------+
|         1 | entregado |
|         2 | enviado   |
|         3 | pendiente |
|         4 | cancelado |
|         5 | entregado |
|         6 | entregado |
|         7 | pendiente |
|         8 | enviado   |
|         9 | enviado   |
|        10 | entregado |
|        11 | cancelado |
|        12 | entregado |
|        13 | entregado |
|        14 | entregado |
|        15 | entregado |
|        16 | entregado |
|        17 | enviado   |
|        18 | entregado |
|        19 | entregado |
|        20 | cancelado |
|        21 | enviado   |
|        22 | enviado   |
|        23 | enviado   |
|        24 | entregado |
|        25 | enviado   |
|        26 | pendiente |
|        27 | cancelado |
|        28 | entregado |
|        29 | cancelado |
|        30 | enviado   |
|        31 | entregado |
|        32 | entregado |
|        33 | enviado   |
|        34 | entregado |
|        35 | pendiente |
|        36 | enviado   |
|        37 | enviado   |
|        38 | entregado |
|        39 | entregado |
|        40 | entregado |
|        41 | entregado |
|        42 | enviado   |
|        43 | entregado |
|        44 | entregado |
|        45 | enviado   |
|        46 | entregado |
|        47 | entregado |
|        48 | pendiente |
|        49 | cancelado |
|        50 | enviado   |
|        51 | cancelado |
|        52 | cancelado |
|        53 | pendiente |
|        54 | entregado |
|        55 | pendiente |
|        56 | entregado |
|        57 | pendiente |
|        58 | enviado   |
|        59 | entregado |
|        60 | entregado |
|        61 | enviado   |
|        62 | entregado |
|        63 | enviado   |
|        64 | enviado   |
|        65 | pendiente |
|        66 | entregado |
|        67 | pendiente |
|        68 | entregado |
|        69 | pendiente |
|        70 | enviado   |
|        71 | cancelado |
|        72 | pendiente |
|        73 | enviado   |
|        74 | entregado |
|        75 | entregado |
|        76 | cancelado |
|        77 | enviado   |
|        78 | entregado |
|        79 | entregado |
|        80 | entregado |
|        81 | enviado   |
|        82 | pendiente |
|        83 | pendiente |
|        84 | entregado |
|        85 | entregado |
|        86 | entregado |
|        87 | pendiente |
|        88 | entregado |
|        89 | entregado |
|        90 | entregado |
|        91 | cancelado |
|        92 | enviado   |
|        93 | cancelado |
|        94 | pendiente |
|        95 | pendiente |
|        96 | entregado |
|        97 | entregado |
|        98 | cancelado |
|        99 | enviado   |
|       100 | enviado   |
|       101 | cancelado |
|       102 | enviado   |
|       103 | cancelado |
|       104 | cancelado |
|       105 | entregado |
|       106 | cancelado |
|       107 | pendiente |
|       108 | enviado   |
|       109 | enviado   |
|       110 | entregado |
|       111 | enviado   |
|       112 | entregado |
|       113 | entregado |
|       114 | entregado |
|       115 | cancelado |
|       116 | pendiente |
|       117 | enviado   |
|       118 | entregado |
|       119 | entregado |
|       120 | entregado |
|       121 | enviado   |
|       122 | entregado |
|       123 | enviado   |
|       124 | entregado |
|       125 | entregado |
|       126 | entregado |
|       127 | entregado |
|       128 | entregado |
|       129 | entregado |
|       130 | cancelado |
|       131 | cancelado |
|       132 | pendiente |
|       133 | entregado |
|       134 | cancelado |
|       135 | enviado   |
|       136 | entregado |
|       137 | pendiente |
|       138 | entregado |
|       139 | entregado |
|       140 | entregado |
|       141 | entregado |
|       142 | entregado |
|       143 | cancelado |
|       144 | entregado |
|       145 | enviado   |
|       146 | enviado   |
|       147 | pendiente |
|       148 | entregado |
|       149 | entregado |
|       150 | entregado |
|       151 | entregado |
|       152 | entregado |
|       153 | enviado   |
|       154 | enviado   |
|       155 | pendiente |
+-----------+-----------+

```
**PD: se considera como "nombre" del pedido a su id debido a que es su identificativo**

## 3. Consultas con ORDER BY, SORT y LIMIT

### 3.1. Mostrar los productos ordenados por precio de mayor a menor

### 3.2. Mostrar los pedidos ordenados por fecha de pedido de más reciente a más antigua

### 3.3. Mostrar los 5 primeros clientes registrados

### 3.4. Mostrar los 3 últimos pedidos realizados

## 4. Filtros avanzados (IN, BETWEEN, LIKE...)

### 4.1. Mostrar los productos cuyo precio esté entre 100 y 500 euros
```
mysql> select * from productos where precio between 100 and 500;
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
| id_producto | nombre                    | descripcion                          | precio | stock | categoria    |
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
|           2 | Smartphone Xiaomi         | Redmi Note 11 Pro                    | 320.00 |  1030 | Electrónica  |
|           4 | Silla Gamer               | Silla ergonómica con soporte lumbar  | 180.00 |  1005 | Muebles      |
|           5 | Escritorio                | Escritorio de madera para oficina    | 210.00 |  1007 | Muebles      |
|           6 | Monitor LG 24"            | Monitor IPS Full HD 24"              | 129.99 |   340 | Electrónica  |
|          10 | Tablet Samsung            | Galaxy Tab A8 64GB                   | 229.00 |   330 | Electrónica  |
|          14 | Placa Base MSI            | mATX B560M                           | 119.00 |   315 | Componentes  |
|          16 | Tarjeta Gráfica RTX 3060  | 12GB GDDR6                           | 299.00 |   312 | Componentes  |
|          21 | Silla de Oficina          | Ergonómica malla                     | 129.00 |   320 | Muebles      |
|          27 | NAS 2 Bahías              | Soporta RAID1                        | 249.00 |   310 | Electrónica  |
|          28 | Silla Gamer Pro           | Reclinable 160°                      | 229.00 |   310 | Muebles      |
|          29 | Escritorio en L           | 120x140 cm                           | 189.00 |   312 | Muebles      |
+-------------+---------------------------+--------------------------------------+--------+-------+--------------+
11 rows in set (0,00 sec)


```
### 4.2. Mostrar los clientes que sean de España
```
mysql> select * from clientes where pais='España';
+------------+-----------------+------------------------------+----------------+---------+
| id_cliente | nombre          | email                        | fecha_registro | pais    |
+------------+-----------------+------------------------------+----------------+---------+
|          1 | Ana Torres      | ana@example.com              | 2023-01-10     | España  |
|         29 | Laura Álvarez   | laura.alvarez29@example.com  | 2024-03-27     | España  |
|         31 | Juan Álvarez    | juan.alvarez31@example.com   | 2023-10-31     | España  |
|         34 | Noelia Torres   | noelia.torres34@example.com  | 2023-07-03     | España  |
|         42 | Valeria García  | valeria.garcia42@example.com | 2023-09-28     | España  |
+------------+-----------------+------------------------------+----------------+---------+
5 rows in set (0,00 sec)

```
### 4.3. Mostrar los pedidos que tengan un estado que no sea 'pendiente'
```
mysql> select * from pedidos where estado != 'pendiente';
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|         1 |          1 | 2023-04-01 10:00:00 | entregado |     1070.00 |
|         2 |          2 | 2023-04-03 15:30:00 | enviado   |      320.00 |
|         4 |          3 | 2023-04-10 09:10:00 | cancelado |      180.00 |
|         5 |          4 | 2023-04-11 13:00:00 | entregado |      210.00 |
|         6 |         30 | 2025-02-06 16:22:51 | entregado |     2409.98 |
|         8 |         37 | 2024-03-09 22:58:56 | enviado   |      983.46 |
|         9 |         35 | 2023-10-15 10:21:56 | enviado   |      630.00 |
|        10 |         29 | 2024-11-24 01:35:05 | entregado |      698.97 |
|        11 |         23 | 2023-11-28 17:03:33 | cancelado |      750.00 |
|        12 |         13 | 2025-01-06 23:09:18 | entregado |     1175.67 |
|        13 |         24 | 2023-07-03 04:07:56 | entregado |      495.00 |
|        14 |          1 | 2023-12-20 04:45:24 | entregado |     1196.76 |
|        15 |         37 | 2025-08-05 07:42:28 | entregado |      878.00 |
|        16 |          1 | 2025-07-17 02:39:18 | entregado |      926.16 |
|        17 |         25 | 2024-10-31 12:27:44 | enviado   |     3790.50 |
|        18 |          4 | 2023-10-18 22:35:34 | entregado |      360.00 |
|        19 |         20 | 2024-04-01 15:21:06 | entregado |     1954.00 |
|        20 |         44 | 2025-05-02 21:23:21 | cancelado |      147.98 |
|        21 |         30 | 2023-05-23 18:47:29 | enviado   |       79.90 |
|        22 |          7 | 2024-06-16 09:21:24 | enviado   |      474.50 |
|        23 |         43 | 2025-01-17 05:17:51 | enviado   |      565.97 |
|        24 |          6 | 2025-02-14 02:59:59 | entregado |      675.00 |
|        25 |         25 | 2024-06-11 16:22:12 | enviado   |     1137.00 |
|        27 |         14 | 2024-05-25 16:05:00 | cancelado |     1500.00 |
|        28 |          9 | 2024-09-22 11:14:30 | entregado |     4289.70 |
|        29 |          5 | 2025-05-11 18:49:48 | cancelado |      487.95 |
|        30 |         21 | 2025-01-31 11:25:48 | enviado   |      403.76 |
|        31 |         41 | 2023-05-23 13:59:20 | entregado |      784.95 |
|        32 |         28 | 2023-07-01 05:52:25 | entregado |     2957.97 |
|        33 |         32 | 2025-04-01 14:18:12 | enviado   |      914.08 |
|        34 |         15 | 2025-02-04 16:16:23 | entregado |      420.00 |
|        36 |         16 | 2025-08-14 12:00:30 | enviado   |     1024.92 |
|        37 |         11 | 2024-07-24 17:54:37 | enviado   |      810.60 |
|        38 |          3 | 2023-12-03 20:06:19 | entregado |      298.96 |
|        39 |         44 | 2025-07-01 15:12:28 | entregado |      700.98 |
|        40 |         14 | 2024-07-31 21:10:14 | entregado |      480.98 |
|        41 |         25 | 2023-06-08 13:30:04 | entregado |      605.70 |
|        42 |         34 | 2024-11-23 20:06:35 | enviado   |     1257.87 |
|        43 |          7 | 2023-10-15 18:58:00 | entregado |       59.00 |
|        44 |          9 | 2025-07-23 07:42:42 | entregado |      876.00 |
|        45 |         43 | 2024-08-31 03:45:22 | enviado   |      631.33 |
|        46 |         40 | 2025-03-04 09:48:02 | entregado |     1205.98 |
|        47 |          5 | 2025-09-08 22:58:53 | entregado |      258.99 |
|        49 |         20 | 2025-03-20 11:20:53 | cancelado |       89.98 |
|        50 |         31 | 2023-12-10 14:52:01 | enviado   |     1631.96 |
|        51 |         45 | 2025-05-12 20:38:03 | cancelado |      308.00 |
|        52 |         26 | 2024-09-14 18:26:50 | cancelado |      970.44 |
|        54 |         27 | 2025-06-19 19:08:47 | entregado |     1636.97 |
|        56 |          9 | 2023-07-05 08:36:02 | entregado |      260.99 |
|        58 |         32 | 2025-05-18 23:57:07 | enviado   |      934.80 |
|        59 |         30 | 2025-03-04 23:52:27 | entregado |      347.44 |
|        60 |         27 | 2025-07-25 04:49:19 | entregado |      104.70 |
|        61 |          2 | 2024-05-12 12:22:02 | enviado   |      129.97 |
|        62 |         42 | 2024-02-05 07:21:29 | entregado |     1132.00 |
|        63 |         15 | 2025-03-20 02:10:46 | enviado   |      139.60 |
|        64 |         34 | 2024-10-30 02:17:30 | enviado   |     1809.99 |
|        66 |         36 | 2024-11-29 07:12:46 | entregado |      387.00 |
|        68 |         39 | 2024-05-12 17:45:07 | entregado |      799.55 |
|        70 |         36 | 2024-03-08 11:36:16 | enviado   |      970.97 |
|        71 |          9 | 2024-11-08 04:19:43 | cancelado |      682.26 |
|        73 |         32 | 2023-05-19 23:18:06 | enviado   |     1713.00 |
|        74 |          1 | 2024-12-02 08:42:30 | entregado |      317.00 |
|        75 |          6 | 2024-11-08 13:11:45 | entregado |       99.96 |
|        76 |         36 | 2024-01-16 23:04:06 | cancelado |      798.00 |
|        77 |         45 | 2024-03-24 13:08:23 | enviado   |     1415.69 |
|        78 |          7 | 2024-08-20 07:52:40 | entregado |      862.96 |
|        79 |         33 | 2025-05-22 18:34:54 | entregado |       25.00 |
|        80 |         24 | 2025-03-07 21:03:31 | entregado |      411.97 |
|        81 |         27 | 2025-08-07 06:41:09 | enviado   |      493.90 |
|        84 |          8 | 2023-09-09 05:08:29 | entregado |     1544.00 |
|        85 |         42 | 2024-09-08 09:20:31 | entregado |      159.60 |
|        86 |         30 | 2024-03-01 19:12:50 | entregado |     1084.40 |
|        88 |         17 | 2024-07-04 09:03:36 | entregado |      435.60 |
|        89 |          6 | 2024-12-23 04:18:39 | entregado |     3422.00 |
|        90 |         11 | 2024-05-07 15:34:48 | entregado |      759.76 |
|        91 |          4 | 2025-03-19 15:55:01 | cancelado |     1218.59 |
|        92 |         39 | 2024-02-24 04:47:14 | enviado   |     1753.90 |
|        93 |          9 | 2023-07-21 06:15:47 | cancelado |      774.66 |
|        96 |         17 | 2023-05-13 12:18:02 | entregado |     2236.86 |
|        97 |         40 | 2024-12-20 15:45:45 | entregado |     1336.00 |
|        98 |         10 | 2025-01-01 08:54:38 | cancelado |      178.00 |
|        99 |         10 | 2023-07-13 12:11:10 | enviado   |      625.70 |
|       100 |         14 | 2024-08-16 07:38:23 | enviado   |      295.00 |
|       101 |          4 | 2025-02-25 15:05:06 | cancelado |       49.00 |
|       102 |         18 | 2025-01-15 04:47:50 | enviado   |     1722.00 |
|       103 |          3 | 2025-07-16 07:06:39 | cancelado |      375.00 |
|       104 |         13 | 2023-08-13 06:34:54 | cancelado |      726.06 |
|       105 |         44 | 2023-07-14 02:03:36 | entregado |      461.00 |
|       106 |         25 | 2025-02-07 12:19:12 | cancelado |      789.96 |
|       108 |          4 | 2025-03-20 06:56:54 | enviado   |      747.00 |
|       109 |          6 | 2023-12-17 18:19:57 | enviado   |      487.00 |
|       110 |         19 | 2024-11-14 14:00:29 | entregado |      425.94 |
|       111 |         15 | 2024-07-09 20:08:34 | enviado   |      623.89 |
|       112 |         42 | 2023-05-27 05:25:59 | entregado |      988.96 |
|       113 |          5 | 2023-05-19 08:05:29 | entregado |      866.80 |
|       114 |         35 | 2025-02-06 07:24:00 | entregado |      149.79 |
|       115 |         27 | 2023-12-19 13:15:54 | cancelado |      297.90 |
|       117 |         12 | 2024-02-23 06:50:55 | enviado   |     1601.97 |
|       118 |         24 | 2025-05-31 19:28:54 | entregado |      630.00 |
|       119 |         42 | 2024-03-03 10:46:42 | entregado |      229.00 |
|       120 |         24 | 2024-01-20 23:24:47 | entregado |     1743.98 |
|       121 |         32 | 2023-05-12 04:35:14 | enviado   |       75.00 |
|       122 |         21 | 2023-11-06 02:20:32 | entregado |     1509.99 |
|       123 |         30 | 2025-08-23 17:58:05 | enviado   |      257.00 |
|       124 |         15 | 2025-03-03 14:46:22 | entregado |       69.99 |
|       125 |         41 | 2023-11-11 22:35:27 | entregado |      789.58 |
|       126 |         17 | 2025-06-17 13:01:26 | entregado |      750.00 |
|       127 |          4 | 2023-10-14 09:07:49 | entregado |      390.86 |
|       128 |         10 | 2024-11-11 08:59:34 | entregado |     2783.70 |
|       129 |         39 | 2024-03-20 08:40:09 | entregado |      398.70 |
|       130 |         20 | 2024-06-10 08:32:30 | cancelado |     2129.70 |
|       131 |         35 | 2023-08-06 10:00:18 | cancelado |      892.10 |
|       133 |         39 | 2023-09-14 21:53:03 | entregado |     2004.59 |
|       134 |         31 | 2025-07-13 03:57:51 | cancelado |     1079.88 |
|       135 |         28 | 2025-03-19 22:32:32 | enviado   |     1196.00 |
|       136 |          8 | 2025-02-20 10:38:58 | entregado |      647.66 |
|       138 |         20 | 2024-07-18 11:21:34 | entregado |       74.97 |
|       139 |          5 | 2024-08-30 08:53:45 | entregado |      244.50 |
|       140 |         35 | 2025-06-03 23:57:31 | entregado |     1584.00 |
|       141 |         23 | 2024-06-20 12:58:36 | entregado |      500.60 |
|       142 |         13 | 2025-06-09 10:12:15 | entregado |     1240.58 |
|       143 |         21 | 2023-05-11 21:31:45 | cancelado |      443.97 |
|       144 |         34 | 2025-05-24 00:03:02 | entregado |      928.40 |
|       145 |         13 | 2024-05-03 22:26:59 | enviado   |     2234.00 |
|       146 |         12 | 2025-08-21 20:42:36 | enviado   |      223.70 |
|       148 |         45 | 2025-01-09 02:25:02 | entregado |      158.80 |
|       149 |         45 | 2024-11-22 07:43:09 | entregado |     1095.70 |
|       150 |          1 | 2024-07-16 08:54:02 | entregado |      196.00 |
|       151 |         30 | 2023-10-05 21:07:56 | entregado |     2593.98 |
|       152 |         10 | 2024-09-17 15:21:00 | entregado |     1389.88 |
|       153 |          9 | 2024-11-29 22:17:40 | enviado   |     2701.80 |
|       154 |         17 | 2023-07-24 05:59:43 | enviado   |       39.90 |
+-----------+------------+---------------------+-----------+-------------+
132 rows in set (0,00 sec)

```
### 4.4. Mostrar los productos cuyo nombre contenga la palabra 'Laptop'
```
mysql> select * from productos where nombre like '%Laptop%';
+-------------+----------------------+---------------------+--------+-------+--------------+
| id_producto | nombre               | descripcion         | precio | stock | categoria    |
+-------------+----------------------+---------------------+--------+-------+--------------+
|           1 | Laptop Dell Inspiron | Laptop 15" Intel i5 | 750.00 |  1012 | Electrónica  |
+-------------+----------------------+---------------------+--------+-------+--------------+
1 row in set (0,01 sec)

```
### 4.5. Buscar productos cuyo nombre comiencen por 'Laptop' o 'laptop'
```
mysql> select * from productos where nombre like 'Laptop%';
+-------------+----------------------+---------------------+--------+-------+--------------+
| id_producto | nombre               | descripcion         | precio | stock | categoria    |
+-------------+----------------------+---------------------+--------+-------+--------------+
|           1 | Laptop Dell Inspiron | Laptop 15" Intel i5 | 750.00 |  1012 | Electrónica  |
+-------------+----------------------+---------------------+--------+-------+--------------+
1 row in set (0,00 sec)

```
### 4.6. Mostrar los clientes que tengan un email que contenga '@example.com'
```
mysql> select * from clientes where email like '%@example.com';
+------------+--------------------+--------------------------------+----------------+-----------------------+
| id_cliente | nombre             | email                          | fecha_registro | pais                  |
+------------+--------------------+--------------------------------+----------------+-----------------------+
|          1 | Ana Torres         | ana@example.com                | 2023-01-10     | España                |
|          2 | Luis Méndez        | luis@example.com               | 2023-02-15     | México                |
|          3 | Carla Gómez        | carla@example.com              | 2023-03-20     | Chile                 |
|          4 | David Ruiz         | david@example.com              | 2023-04-05     | Argentina             |
|          5 | Sofía Paredes      | sofia@example.com              | 2023-04-25     | Perú                  |
|          6 | Marta Gil          | marta.gil6@example.com         | 2023-05-11     | Paraguay              |
|          7 | Gonzalo Jiménez    | gonzalo.jimenez7@example.com   | 2023-11-15     | Bolivia               |
|          8 | Daniel Moreno      | daniel.moreno8@example.com     | 2023-10-13     | Costa Rica            |
|          9 | Lucía Suárez       | lucia.suarez9@example.com      | 2024-07-17     | Bolivia               |
|         10 | Alba Domínguez     | alba.dominguez10@example.com   | 2023-10-26     | Italia                |
|         11 | Alba Sánchez       | alba.sanchez11@example.com     | 2024-04-28     | Argentina             |
|         12 | Hugo Gil           | hugo.gil12@example.com         | 2024-06-26     | Portugal              |
|         13 | Hugo Sánchez       | hugo.sanchez13@example.com     | 2023-09-29     | Uruguay               |
|         14 | Nicolás González   | nicolas.gonzalez14@example.com | 2023-11-11     | Venezuela             |
|         15 | Andrés García      | andres.garcia15@example.com    | 2024-08-12     | Venezuela             |
|         16 | María Alonso       | maria.alonso16@example.com     | 2025-04-07     | Panamá                |
|         17 | María García       | maria.garcia17@example.com     | 2025-03-10     | Colombia              |
|         18 | Adriana Navarro    | adriana.navarro18@example.com  | 2023-10-31     | Paraguay              |
|         19 | Lucía Domínguez    | lucia.dominguez19@example.com  | 2024-06-28     | Chile                 |
|         20 | Alicia Vázquez     | alicia.vazquez20@example.com   | 2024-12-12     | Colombia              |
|         21 | Nicolás Álvarez    | nicolas.alvarez21@example.com  | 2023-12-25     | El Salvador           |
|         22 | Irene Ramos        | irene.ramos22@example.com      | 2024-04-02     | México                |
|         23 | Elena López        | elena.lopez23@example.com      | 2024-09-23     | Uruguay               |
|         24 | Nicolás Serrano    | nicolas.serrano24@example.com  | 2025-06-13     | Nicaragua             |
|         25 | Sofía Sánchez      | sofia.sanchez25@example.com    | 2024-01-19     | Portugal              |
|         26 | Marta Alonso       | marta.alonso26@example.com     | 2023-09-10     | México                |
|         27 | Laura Ruiz         | laura.ruiz27@example.com       | 2023-05-10     | Perú                  |
|         28 | Elena Jiménez      | elena.jimenez28@example.com    | 2024-11-03     | Venezuela             |
|         29 | Laura Álvarez      | laura.alvarez29@example.com    | 2024-03-27     | España                |
|         30 | José Fernández     | jose.fernandez30@example.com   | 2025-04-28     | República Dominicana  |
|         31 | Juan Álvarez       | juan.alvarez31@example.com     | 2023-10-31     | España                |
|         32 | Adriana Ramos      | adriana.ramos32@example.com    | 2024-05-11     | Uruguay               |
|         33 | Sofía Alonso       | sofia.alonso33@example.com     | 2025-06-18     | Chile                 |
|         34 | Noelia Torres      | noelia.torres34@example.com    | 2023-07-03     | España                |
|         35 | Javier Romero      | javier.romero35@example.com    | 2024-03-29     | Italia                |
|         36 | Marta Castro       | marta.castro36@example.com     | 2024-11-14     | Uruguay               |
|         37 | Paula Ramírez      | paula.ramirez37@example.com    | 2025-03-09     | Chile                 |
|         38 | Alba Martínez      | alba.martinez38@example.com    | 2023-07-21     | Honduras              |
|         39 | Laura Ortega       | laura.ortega39@example.com     | 2024-04-08     | Ecuador               |
|         40 | Miguel Sánchez     | miguel.sanchez40@example.com   | 2023-10-14     | Paraguay              |
|         41 | Pablo Gutiérrez    | pablo.gutierrez41@example.com  | 2023-08-01     | El Salvador           |
|         42 | Valeria García     | valeria.garcia42@example.com   | 2023-09-28     | España                |
|         43 | Sofía Romero       | sofia.romero43@example.com     | 2023-11-06     | Italia                |
|         44 | Raúl Suárez        | raul.suarez44@example.com      | 2023-08-07     | Bolivia               |
|         45 | Hugo Ramírez       | hugo.ramirez45@example.com     | 2024-06-19     | Argentina             |
+------------+--------------------+--------------------------------+----------------+-----------------------+

```
**Todos los clientes tienen la misma terminación en el email**
### 4.7. Mostrar los productos cuya categoría sea 'Electrónica' o 'Muebles' usando el operador IN
```
mysql> select * from productos where categoria in ('Electrónica','Muebles') order by categoria;
+-------------+----------------------+--------------------------------------+--------+-------+--------------+
| id_producto | nombre               | descripcion                          | precio | stock | categoria    |
+-------------+----------------------+--------------------------------------+--------+-------+--------------+
|           1 | Laptop Dell Inspiron | Laptop 15" Intel i5                  | 750.00 |  1012 | Electrónica  |
|           2 | Smartphone Xiaomi    | Redmi Note 11 Pro                    | 320.00 |  1030 | Electrónica  |
|           6 | Monitor LG 24"       | Monitor IPS Full HD 24"              | 129.99 |   340 | Electrónica  |
|           9 | Impresora HP DeskJet | Multifunción Wi-Fi                   |  89.00 |   325 | Electrónica  |
|          10 | Tablet Samsung       | Galaxy Tab A8 64GB                   | 229.00 |   330 | Electrónica  |
|          11 | Smartwatch Amazfit   | Autonomía 14 días                    |  79.00 |   350 | Electrónica  |
|          26 | Router Wi-Fi 6       | AX3000 doble banda                   |  79.90 |   330 | Electrónica  |
|          27 | NAS 2 Bahías         | Soporta RAID1                        | 249.00 |   310 | Electrónica  |
|           4 | Silla Gamer          | Silla ergonómica con soporte lumbar  | 180.00 |  1005 | Muebles      |
|           5 | Escritorio           | Escritorio de madera para oficina    | 210.00 |  1007 | Muebles      |
|          21 | Silla de Oficina     | Ergonómica malla                     | 129.00 |   320 | Muebles      |
|          28 | Silla Gamer Pro      | Reclinable 160°                      | 229.00 |   310 | Muebles      |
|          29 | Escritorio en L      | 120x140 cm                           | 189.00 |   312 | Muebles      |
+-------------+----------------------+--------------------------------------+--------+-------+--------------+
13 rows in set (0,00 sec)

```
### 4.8. Mostrar los pedidos que tengan un total entre 100 y 500 euros
```
mysql> select * from pedidos where coste_total between 100 and 500;
+-----------+------------+---------------------+-----------+-------------+
| id_pedido | id_cliente | fecha_pedido        | estado    | coste_total |
+-----------+------------+---------------------+-----------+-------------+
|         2 |          2 | 2023-04-03 15:30:00 | enviado   |      320.00 |
|         4 |          3 | 2023-04-10 09:10:00 | cancelado |      180.00 |
|         5 |          4 | 2023-04-11 13:00:00 | entregado |      210.00 |
|        13 |         24 | 2023-07-03 04:07:56 | entregado |      495.00 |
|        18 |          4 | 2023-10-18 22:35:34 | entregado |      360.00 |
|        20 |         44 | 2025-05-02 21:23:21 | cancelado |      147.98 |
|        22 |          7 | 2024-06-16 09:21:24 | enviado   |      474.50 |
|        29 |          5 | 2025-05-11 18:49:48 | cancelado |      487.95 |
|        30 |         21 | 2025-01-31 11:25:48 | enviado   |      403.76 |
|        34 |         15 | 2025-02-04 16:16:23 | entregado |      420.00 |
|        35 |         44 | 2023-11-08 07:42:52 | pendiente |      209.98 |
|        38 |          3 | 2023-12-03 20:06:19 | entregado |      298.96 |
|        40 |         14 | 2024-07-31 21:10:14 | entregado |      480.98 |
|        47 |          5 | 2025-09-08 22:58:53 | entregado |      258.99 |
|        51 |         45 | 2025-05-12 20:38:03 | cancelado |      308.00 |
|        53 |         25 | 2024-04-28 02:49:10 | pendiente |      249.99 |
|        55 |         30 | 2025-08-25 08:07:24 | pendiente |      319.60 |
|        56 |          9 | 2023-07-05 08:36:02 | entregado |      260.99 |
|        59 |         30 | 2025-03-04 23:52:27 | entregado |      347.44 |
|        60 |         27 | 2025-07-25 04:49:19 | entregado |      104.70 |
|        61 |          2 | 2024-05-12 12:22:02 | enviado   |      129.97 |
|        63 |         15 | 2025-03-20 02:10:46 | enviado   |      139.60 |
|        66 |         36 | 2024-11-29 07:12:46 | entregado |      387.00 |
|        69 |          5 | 2023-09-21 13:34:12 | pendiente |      193.97 |
|        72 |         16 | 2025-02-02 00:15:34 | pendiente |      123.97 |
|        74 |          1 | 2024-12-02 08:42:30 | entregado |      317.00 |
|        80 |         24 | 2025-03-07 21:03:31 | entregado |      411.97 |
|        81 |         27 | 2025-08-07 06:41:09 | enviado   |      493.90 |
|        82 |          4 | 2024-12-20 16:05:11 | pendiente |      248.50 |
|        85 |         42 | 2024-09-08 09:20:31 | entregado |      159.60 |
|        87 |         26 | 2024-11-20 08:05:39 | pendiente |      227.06 |
|        88 |         17 | 2024-07-04 09:03:36 | entregado |      435.60 |
|        95 |         26 | 2024-12-22 17:32:18 | pendiente |      104.70 |
|        98 |         10 | 2025-01-01 08:54:38 | cancelado |      178.00 |
|       100 |         14 | 2024-08-16 07:38:23 | enviado   |      295.00 |
|       103 |          3 | 2025-07-16 07:06:39 | cancelado |      375.00 |
|       105 |         44 | 2023-07-14 02:03:36 | entregado |      461.00 |
|       109 |          6 | 2023-12-17 18:19:57 | enviado   |      487.00 |
|       110 |         19 | 2024-11-14 14:00:29 | entregado |      425.94 |
|       114 |         35 | 2025-02-06 07:24:00 | entregado |      149.79 |
|       115 |         27 | 2023-12-19 13:15:54 | cancelado |      297.90 |
|       119 |         42 | 2024-03-03 10:46:42 | entregado |      229.00 |
|       123 |         30 | 2025-08-23 17:58:05 | enviado   |      257.00 |
|       127 |          4 | 2023-10-14 09:07:49 | entregado |      390.86 |
|       129 |         39 | 2024-03-20 08:40:09 | entregado |      398.70 |
|       137 |          2 | 2025-02-05 06:48:16 | pendiente |      415.00 |
|       139 |          5 | 2024-08-30 08:53:45 | entregado |      244.50 |
|       143 |         21 | 2023-05-11 21:31:45 | cancelado |      443.97 |
|       146 |         12 | 2025-08-21 20:42:36 | enviado   |      223.70 |
|       147 |          7 | 2023-07-12 20:59:04 | pendiente |      441.70 |
|       148 |         45 | 2025-01-09 02:25:02 | entregado |      158.80 |
|       150 |          1 | 2024-07-16 08:54:02 | entregado |      196.00 |
+-----------+------------+---------------------+-----------+-------------+
52 rows in set (0,00 sec)

```
## 5. Ejemplos con funciones de cadenas, numéricas y de fechas

### Numéricas

#### 5.1. Obtener la longitud del nombre de cada cliente

#### 5.2. Obtener el total de pedidos realizados

#### 5.3. Obtener el precio promedio de los productos

#### 5.4. Obtener el precio más bajo de los productos

#### 5.5. Obtener el precio más alto de los productos

### Funciones de cadena

#### 5.6. Convertir el nombre de los productos a mayúsculas

#### 5.7. Convertir el nombre de los clientes a minúsculas

#### 5.8. Obtener los primeros 3 caracteres del nombre de cada producto

#### 5.9. Obtener los últimos 3 caracteres del nombre de cada producto

### Funciones de fecha

#### 5.10. Obtener la fecha de hoy

#### 5.11. Calcular cuántos días han pasado desde el registro de cada cliente hasta hoy
