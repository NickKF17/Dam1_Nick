SELECT productos.count(id_producto), clientes.pais
FROM
clientes
        join pedidos on clientes.id_cliente = pedidos.id_cliente
            join detalle_pedido on detalle_pedido.id_pedido = pedidos.id_pedido
        join productos on detalle_pedido.id_producto = productos.id_producto
        group by productos.count(id_producto)
   order by pais;
   

  



