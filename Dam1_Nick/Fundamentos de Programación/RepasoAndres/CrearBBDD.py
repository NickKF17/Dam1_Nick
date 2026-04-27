import sqlite3
from datetime import datetime

# Nombre del archivo que será tu base de datos
DB_NAME = "tienda.db"


def inicializar_sistema():
    """Crea el archivo y las tablas si no existen."""
    try:
        with sqlite3.connect(DB_NAME) as conexion:
            cursor = conexion.cursor()

            # 1. Tabla de Productos
            cursor.execute("""
                CREATE TABLE IF NOT EXISTS productos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre TEXT NOT NULL,
                    cantidad INTEGER,
                    precio REAL
                )""")

            # 2. Tabla de Logs (Errores)
            cursor.execute("""
                CREATE TABLE IF NOT EXISTS logs_sistema (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    modulo TEXT,
                    error_msg TEXT,
                    timestamp DATETIME
                )""")

            conexion.commit()
            print("Base de datos y tablas listas.")
    except sqlite3.Error as e:
        print(f"Error inicializando: {e}")


def registrar_error(modulo, error_msg):
    """Guarda un error en la tabla de logs."""
    with sqlite3.connect(DB_NAME) as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
            INSERT INTO logs_sistema (modulo, error_msg, timestamp) 
            VALUES (?, ?, ?)""", (modulo, str(error_msg), datetime.now()))
        conexion.commit()


def insertar_producto(nombre, cantidad, precio):
    """Inserta un producto de forma segura."""
    try:
        with sqlite3.connect(DB_NAME) as conexion:
            cursor = conexion.cursor()
            cursor.execute("""
                INSERT INTO productos (nombre, cantidad, precio) 
                VALUES (?, ?, ?)""", (nombre, cantidad, precio))
            conexion.commit()
            print(f"Éxito: Se guardó '{nombre}'.")
    except sqlite3.Error as e:
        print(f"Error al insertar: {e}")
        registrar_error("Insertar Producto", e)


# --- PRUEBA DEL PROGRAMA ---
inicializar_sistema()
insertar_producto("Teclado RGB", 5, 25.99)
insertar_producto("Mouse Pad", 10, 12.50)