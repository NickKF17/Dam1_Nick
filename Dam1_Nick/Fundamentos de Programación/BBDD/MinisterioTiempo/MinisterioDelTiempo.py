import sqlite3

def setup():
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        conexion = sqlite3.connect('MinisterioDelTiempo.db')
        conexion.execute("PRAGMA foreign_keys = ON")  # <--- ESTO ES FUNDAMENTAL Para activar las FK
        cursor = conexion.cursor()
        cursor.execute(""" CREATE TABLE if not exists naves (
        id integer primary key autoincrement,nombre text not null,tipo text,anyo_construccion integer,epoca text)
                       """)

        cursor.execute(""" CREATE TABLE if not exists agentes (
                id integer primary key autoincrement,nombre text not null,anyo_nacimiento integer,especialidad text,activo integer default 1)
                               """)

        cursor.execute(""" CREATE TABLE if not exists misiones (
        id integer primary key autoincrement,id_agente integer ,id_nave integer ,fecha_partida text ,fecha_regreso text default null,exito integer default 0,incidencias text
        ,foreign key (id_agente) references agentes(id),foreign key (id_nave) references naves(id))""")

        conexion.commit()



def registrar_nave(nombre, tipo, anyo, epoca): # Añade una nave al registro.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Insert into nave values(?,?,?,?)
        """,[nombre,tipo,anyo,epoca])
        conexion.commit()



def enviar_agente(id_agente, id_nave, fecha_partida): # Asigna un agente a una nave. Un agente no puede estar en dos misiones simultáneas.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()

        # 1. Comprobar si el agente está en una misión (sin fecha de regreso)
        cursor.execute("SELECT id FROM misiones WHERE id_agente = ? AND fecha_regreso IS NULL", [id_agente,])
        ocupado = cursor.fetchone()

        if ocupado:
            # Si el SELECT encontró algo, el agente está fuera
            print("❌ Error: El agente ",{id_agente}, " ya está en misión. ¿Paradoja temporal detectada?")
        else:
            # 2. Si no encontró nada, hacemos el insert normal
            cursor.execute("""
                INSERT INTO misiones (id_agente, id_nave, fecha_partida) 
                VALUES (?, ?, ?)
            """, [id_agente, id_nave, fecha_partida])

            conexion.commit()
            print("Agente enviado con éxito.")

def cerrar_mision(id_mision, exito, incidencias): # Marca la misión como terminada.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Insert into misiones (id,exito,incidencias)
        """,[id_mision,exito,incidencias])
        conexion.commit()

def naves_sin_capitan(): # Lista las naves que actualmente no tienen ningún agente asignado.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Select distinct naves.id,naves.nombre,naves.tipo from naves 
        left join misiones 
        on misiones.id_nave = naves.id
        where misiones.id_agente is null
        """)
        navessincapitan = cursor.fetchall()
        for naves in navessincapitan:
            print(naves)

def historial_agente(id_agente): # Muestra todas las misiones de un agente, ordenadas por fecha.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Select * from misiones where id_agente = ? order by fecha_partida desc
        """,[id_agente,])
def misiones_fallidas(): # Devuelve todas las misiones donde exito = 0 y ya han terminado.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Select * from misiones where exito =0 and fecha_regreso IS not NULL
        """)
        misiones = cursor.fetchall()
        for mision in misiones:
            print(mision)

setup()