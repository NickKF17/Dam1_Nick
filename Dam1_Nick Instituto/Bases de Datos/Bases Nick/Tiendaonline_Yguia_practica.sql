use tienda_online;


SELECT DISTINCT
  pr.nombre AS producto
FROM productos AS pr
LEFT JOIN detalle_pedido AS dp ON dp.id_producto = pr.id_producto
WHERE dp.id_producto IS NULL
ORDER BY producto ASC;


