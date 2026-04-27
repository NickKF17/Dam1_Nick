import sqlite3


def setup():
    # El bloque "with" debe tener todo el código indentado dentro
    with sqlite3.connect("juegos.db") as conexion:
        conexion.row_factory = sqlite3.Row
        cursor = conexion.cursor()
        cursor.execute("""
            CREATE TABLE IF NOT EXISTS juegos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                numero_jugadores TEXT NOT NULL,
                duracion INTEGER,
                fecha_inserccion DATETIME DEFAULT CURRENT_TIMESTAMP
                )
            """)
        conexion.commit()


def guardar_juego(nombre,numero_jugadores,duracion):
    with sqlite3.connect("juegos.db") as conexion:
        conexion.row_factory = sqlite3.Row  # Necesario para leer por nombre de columna
        cursor = conexion.cursor()

        # TODO el código debe estar dentro del "with" para que la conexión esté abierta
        cursor.execute("INSERT INTO juegos (nombre, numero_jugadores, duracion) VALUES (?, ?, ?)", (nombre, numero_jugadores, duracion))
        conexion.commit()
def actualizar_juego(nombre,numero_jugadores,duracion,id):
    with sqlite3.connect("juegos.db") as conexion:
        conexion.row_factory = sqlite3.Row  # Necesario para leer por nombre de columna
        cursor = conexion.cursor()
        # Actualizaciones
        cursor.execute("UPDATE juegos SET nombre = ? WHERE id = ?", (nombre, id))
        cursor.execute("UPDATE juegos SET numero_jugadores = ? WHERE id = ?", (numero_jugadores, id))
        cursor.execute("UPDATE juegos SET duracion = ? WHERE id = ?", (duracion, id))
        conexion.commit()

def leer_juego():
    with sqlite3.connect("juegos.db") as conexion:
        conexion.row_factory = sqlite3.Row  # Necesario para leer por nombre de columna
        cursor = conexion.cursor()
        # Lectura
        cursor.execute("SELECT * FROM juegos")
        registros = cursor.fetchall()

        for registro in registros:
            print(f"ID: {registro['id']} | Nombre: {registro['nombre']} | Jugadores: {registro['numero_jugadores']}")

    # Al salir del bloque "with", la conexión se cierra sola. No hace falta cursor.close()
def eliminar_juego(id):
    with sqlite3.connect("juegos.db") as conexion:
        conexion.row_factory = sqlite3.Row
        cursor = conexion.cursor()
        cursor.execute("""Delete FROM juegos where id=?""",(id,))
        conexion.commit()


def seleccionar_juego(nombre):
    with sqlite3.connect("juegos.db") as conexion:
        conexion.row_factory = sqlite3.Row
        cursor = conexion.cursor()

        # Usamos LIKE y concatenamos los % para buscar coincidencias parciales
        cursor.execute("SELECT * FROM juegos WHERE nombre LIKE ?", (f"%{nombre}%",))

        registros = cursor.fetchall()

        # Devolvemos la lista completa de registros encontrados
        return registros


# Ejemplo de uso:
resultados = seleccionar_juego("Uno")
for juego in resultados:
    print(juego["nombre"])

# Para que el código funcione, debes llamar a las funciones:
setup()
# guardar_juego("La Rule","1",10)
#actualizar_juego("Dos","1-10",10,3)
#actualizar_juego("Monopoly","2-6",30,4)
#eliminar_juego(12)
seleccionar_juego("Dos")
leer_juego()
