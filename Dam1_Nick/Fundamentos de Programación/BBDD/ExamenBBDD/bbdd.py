import sqlite3

from Tarea import Ejercicio1


def inicializar_base_datos():
    # Esto creará el archivo tienda.db en el mismo directorio donde ejecutes el script
    conexion = sqlite3.connect('tienda.db')
    cursor = conexion.cursor()

    # Ejecutar el script SQL
    cursor.executescript('''
        CREATE TABLE IF NOT EXISTS productos (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombre TEXT NOT NULL,
            categoria TEXT NOT NULL,
            precio REAL NOT NULL,
            stock INTEGER NOT NULL
        );

        INSERT INTO productos (nombre, categoria, precio, stock) VALUES
            ('Portátil Gaming X', 'Informática', 1200.50, 5),
            ('Monitor 27 Pulgadas', 'Informática', 250.00, 10),
            ('Ratón Inalámbrico', 'Informática', 25.99, 0),
            ('Smartphone Pro Max', 'Telefonía', 999.99, 15),
            ('Auriculares Bluetooth', 'Audio', 75.00, 20),
            ('Altavoz Inteligente', 'Audio', 45.00, 0),
            ('Teclado Mecánico', 'Informática', 85.50, 8),
            ('Tablet 10 Pulgadas', 'Informática', 550.00, 12),
            ('Cargador USB-C', 'Telefonía', 15.00, 50),
            ('Barra de Sonido', 'Audio', 150.00, 3);
    ''')

    conexion.commit()
    conexion.close()
    print("Base de datos 'tienda.db' creada y poblada con éxito.")

if __name__ == '__main__':
    def ex_ejercicio1():
       with sqlite3.connect("tienda.db") as conexion:
           cursor = conexion.cursor()
           cursor.execute("""SELECT nombre,precio FROM productos where categoria like 'Informática' and precio >500""")
           productos = cursor.fetchall()
           for producto in productos:
               print(producto)
    def ex_ejercicio2():
        with sqlite3.connect("tienda.db") as conexion:
            cursor = conexion.cursor()
            cursor.execute("""Update productos set precio = precio-20 where categoria like 'Audio' """)
            conexion.commit()

    def ex_ejercicio3():
        with sqlite3.connect("tienda.db") as conexion:
            cursor = conexion.cursor()
            cursor.execute("""
            Delete from productos where stock=0 
            """)
            conexion.commit()
    def ex_ejercicio4():
        with sqlite3.connect("tienda.db") as conexion:
            cursor = conexion.cursor()
            cursor.execute(""" 
            Select  count(*) ,avg(precio) from productos where categoria like 'Telefonía'
            """)
            dife = cursor.fetchall()
            for dif in dife:
                print(dif)

    def ex_ejercicio5():
        nombre='Auriculares Inalambricos Pro'
        categoria='Audio'
        precio=89.99
        stock=15
        with sqlite3.connect("tienda.db") as conexion:
            cursor = conexion.cursor()
            cursor.execute("""
                           Insert into productos values (Null,?,?,?,?)
                           """,[nombre,categoria,precio,stock])
            conexion.commit()

#ex_ejercicio1()
#ex_ejercicio2()
#ex_ejercicio3()
#ex_ejercicio4()
#ex_ejercicio5()