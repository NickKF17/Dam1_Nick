# Lista de inventario inicial para el Ejercicio 1
from hgext.histedit import between

inventario = [
    {"id": 101, "nombre": "Laptop Pro 16", "precio": 1450.00, "stock": 5},
    {"id": 102, "nombre": "Ratón Inalámbrico", "precio": 25.99, "stock": 50},
    {"id": 103, "nombre": "Monitor 4K 27", "precio": 380.50, "stock": 12},
    {"id": 104, "nombre": "Smartphone Alpha", "precio": 899.00, "stock": 8},
    {"id": 105, "nombre": "Teclado Mecánico RGB", "precio": 120.00, "stock": 20},
    {"id": 106, "nombre": "Tarjeta Gráfica RTX", "precio": 650.00, "stock": 4},
    {"id": 107, "nombre": "Auriculares Noise Cancelling", "precio": 210.00, "stock": 15},
    {"id": 108, "nombre": "Servidor NAS", "precio": 520.00, "stock": 2}
]

def limpiar_inventario(inventario):
    inventario2={}
    i=0
    for item  in inventario:
        valor= {inventario[i].get("nombre"): inventario[i].get("precio")}
        inventario2[inventario[i].get("id")]= valor

        i=i+1
    return inventario2

print(limpiar_inventario(inventario))



def filtrar_precio_entre(inventario,min,max):
    lista_precio = []
    tuplas=()
    i = 0
    for item in inventario:
            precio= int(inventario[i].get("precio"))
            if min is None and max is None:
                min=0
                max=8000
            elif min is not None and max is None:
                max=8000
            elif min is None and max is not None:
                min=0
            else :
                min=min
                max=max

            if int(inventario[i].get("precio"))  >min and int(inventario[i].get("precio"))  <max :
                tuplas  = (inventario[i].get("nombre"), inventario[i].get("precio"))
                lista_precio.append(tuplas)
                tuplas = tuplas+tuplas
            i = i + 1
    return lista_precio


print(filtrar_precio_entre(inventario,42,4000))
