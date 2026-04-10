use tienda_online;
-- 1) Listar cada id del pedido con el nombre del cliente que lo realizó.
--    Orden: cliente ASC, y a igualdad de cliente por pedido ASC.
select pedidos.id_pedido,clientes.nombre,clientes.id_cliente from pedidos
join clientes on pedidos.id_cliente = clientes.id_cliente
order by clientes.nombre,clientes.id_cliente, id_pedido asc;

-- 2) Listar cada línea de detalle con el nombre del producto y el id del pedido.
--    Columnas EXACTAS y alias:
--      - producto (pr.nombre)
--      - pedido   (dp.id_pedido)
--    Orden: producto ASC, y a igualdad de producto por pedido ASC.
select productos.nombre , detalle_pedido.id_pedido
from productos
join detalle_pedido on productos.id_producto = detalle_pedido.id_producto
order by productos.nombre, detalle_pedido.id_pedido asc;

-- 3) Listar cada pedido con el nombre del cliente y su coste total.
--    Columnas EXACTAS y alias:
--      - cliente      (c.nombre)
--      - pedido       (p.id_pedido)
--      - coste_total  (p.coste_total)
--    Orden: coste_total DESC y, en empates, pedido ASC.
select clientes.nombre,pedidos.id_pedido, pedidos.coste_total
from pedidos
join clientes on pedidos.id_cliente = clientes.id_cliente
order by pedidos.coste_total desc, pedidos.id_pedido asc;
-- 4) Listar pedidos realizados a partir del 1 de enero de 2024 (incluido), con nombre del cliente y fecha.
--    Columnas y alias:
--      - pedido        (p.id_pedido)
--      - cliente       (c.nombre)
--      - fecha_pedido  (p.fecha_pedido)
--    Orden: fecha_pedido ASC; en empate, pedido ASC.
-- WHERE p.fecha_pedido >= '2024-01-01 00:00:00'
select pedidos.id_pedido,clientes.nombre,pedidos.fecha_pedido
from pedidos
join clientes on pedidos.id_cliente = clientes.id_cliente
where pedidos.fecha_pedido >= '2024-01-01 00:00:00'
order by pedidos.fecha_pedido asc, pedidos.id_pedido asc;
-- 5) Listar pedidos cuyo estado sea 'cancelado' o 'pendiente', con cliente y coste_total.
--    Columnas y alias:
--      - pedido       (p.id_pedido)
--      - cliente      (c.nombre)
--      - estado       (p.estado)
--      - coste_total  (p.coste_total)
--    Orden: estado ASC (cancelado < pendiente por orden alfabético), y dentro de cada estado coste_total DESC.
select pedidos.id_pedido, clientes.nombre, pedidos.estado, pedidos.coste_total
from pedidos
join clientes on pedidos.id_cliente = clientes.id_cliente
where estado in ('cancelado','pendiente')
order by pedidos.estado asc, pedidos.coste_total desc;
-- 6) Listar pagos con su pedido y cliente, mostrando el método de pago.
--    Columnas y alias:
--      - pedido       (p.id_pedido)
--      - cliente      (c.nombre)
--      - metodo_pago  (pa.metodo_pago)
--    Importante: solo pedidos con al menos un pago (INNER JOIN).
--    Orden: pedido ASC.
select pedidos.id_pedido, clientes.nombre, pagos.metodo_pago
from pagos
inner join pedidos on pagos.id_pedido = pedidos.id_pedido
join clientes on pedidos.id_cliente = clientes.id_cliente
order by pedidos.id_pedido asc;
-- 7) Listar las líneas del pedido con id 10, incluyendo nombre del producto, cantidad y precio unitario.
--    Columnas y alias:
--      - producto         (pr.nombre)
--      - cantidad         (dp.cantidad)
--      - precio_unitario  (dp.precio_unitario)
--    Orden: producto ASC.
select productos.nombre, detalle_pedido.cantidad,  detalle_pedido.precio_unitario
from productos
join detalle_pedido on productos.id_producto= detalle_pedido.id_producto
join pedidos on detalle_pedido.id_pedido = pedidos.id_pedido
where pedidos.id_pedido = 10
order by productos.nombre asc;
-- 8) Listar pedidos con estado 'entregado' con nombre del cliente y fecha del pedido.
--    Columnas y alias:
--      - pedido        (p.id_pedido)
--      - cliente       (c.nombre)
--      - fecha_pedido  (p.fecha_pedido)
--    Orden: fecha_pedido ASC; en empate, pedido ASC.
select pedidos.id_pedido, clientes.nombre, pedidos.fecha_pedido
from pedidos
join clientes on pedidos.id_cliente = clientes.id_cliente
where pedidos.estado = 'entregado'
order by pedidos.fecha_pedido asc, pedidos.id_pedido asc;
-- 9) Calcular la suma total pagada por cada pedido que tenga al menos un pago.
--    Columnas y alias:
--      - pedido        (p.id_pedido)
--      - total_pagado  (SUM(pa.total_pagado))
--    Agrupación: por p.id_pedido exclusivamente.
--    Orden: total_pagado DESC; en empate, pedido ASC.
select pedidos.id_pedido, sum(pagos.total_pagado) as total_pagado
from pagos
inner join pedidos on pedidos.id_pedido = pagos.id_pedido
group by pedidos.id_pedido
order by sum(pagos.total_pagado) desc, pedidos.id_pedido asc;



-- 10) Contar el número de pedidos realizados por cada cliente.
--     Columnas y alias:
--       - cliente        (c.nombre)
--       - total_pedidos  (COUNT(p.id_pedido))
--     Agrupación: por c.id_cliente y c.nombre (ambos campos, para evitar ambigüedad).
--     Orden: total_pedidos DESC; en empate, cliente ASC.
select clientes.nombre, count(pedidos.id_pedido) as total_pedidos
from pedidos
join clientes on pedidos.id_cliente =  clientes.id_cliente
group by clientes.id_cliente, clientes.nombre
order by count(pedidos.id_pedido) desc, clientes.nombre asc;
-- 11) Listar los clientes que poseen MÁS DE 3 pedidos (estrictamente > 3).
--     Columnas y alias:
--       - cliente        (c.nombre)
--       - total_pedidos  (COUNT(p.id_pedido))
--     Agrupación: por c.id_cliente y c.nombre.
--     Orden: total_pedidos DESC; en empate, cliente ASC.

-- 12) Calcular los ingresos totales por cada producto (cantidad * precio_unitario) considerando SOLO líneas existentes.
--     Columnas y alias:
--       - producto  (pr.nombre)
--       - ingresos  (SUM(dp.cantidad * dp.precio_unitario))
--     Agrupación: por pr.id_producto y pr.nombre.
--     Orden: ingresos DESC; en empate, producto ASC.
select productos.nombre, sum(detalle_pedido.cantidad*detalle_pedido.precio_unitario) as Ingresos
from productos
join detalle_pedido on productos.id_producto = detalle_pedido.id_pedido
group by productos.id_producto, productos.nombre
order by sum(detalle_pedido.cantidad*detalle_pedido.precio_unitario) desc, productos.nombre;
-- 13) Listar los productos cuyo ingreso total (cantidad * precio_unitario) sea superior a 10.000,00 euros.
--     Columnas y alias:
--       - producto  (pr.nombre)
--       - ingresos  (SUM(dp.cantidad * dp.precio_unitario))
--     Agrupación: por pr.id_producto y pr.nombre.
--     Orden: ingresos DESC; en empate, producto ASC.
select productos.nombre, sum(detalle_pedido.cantidad * detalle_pedido.precio_unitario) as ingresos
from productos
join detalle_pedido on productos.id_producto = detalle_pedido.id_producto

group by productos.id_producto, productos.nombre
order by sum(detalle_pedido.canditad*detalle_pedido.precio_unitario) desc, producto.nombre asc;
-- 14) Listar los pedidos cuyo estado sea 'entregado' O 'enviado' y cuyo cliente tenga país 'España' O 'México'.
--     Columnas y alias:
--       - pedido   (p.id_pedido)
--       - cliente  (c.nombre)
--       - pais     (c.pais)
--       - estado   (p.estado)
--     Orden: pais ASC, luego estado ASC y finalmente pedido ASC.
-- 15) Listar productos con precio_unitario > 200 en líneas pertenecientes a pedidos CANCELADOS.
--     Columnas y alias (sin duplicados en misma consulta):
--       - producto        (pr.nombre)
--       - precio_unitario (dp.precio_unitario)
--       - estado          (p.estado)
--     Selección DISTINCT para evitar filas repetidas por combinaciones idénticas.
--     Orden: precio_unitario DESC; en empate, producto ASC.
-- 16) Listar clientes registrados en 2024 que tengan al menos un pedido en estado 'pendiente' O 'enviado' (no entregado ni cancelado).
--     Columnas y alias (sin duplicados por cliente-estado):
--       - cliente        (c.nombre)
--       - fecha_registro (c.fecha_registro)
--       - estado         (p.estado)
--     DISTINCT para evitar múltiples filas idénticas por mismo cliente y estado.
--     Orden: cliente ASC, y en empate por estado ASC.