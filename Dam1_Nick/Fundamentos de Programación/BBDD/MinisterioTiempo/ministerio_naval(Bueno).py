import sqlite3

def setup():
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        conexion = sqlite3.connect('MinisterioDelTiempo.db')
        conexion.execute("PRAGMA foreign_keys = ON")
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
        Insert into naves (nombre,tipo,anyo_construccion,epoca) values(?,?,?,?)
        """,[nombre,tipo,anyo,epoca])
        conexion.commit()

def registrar_agente(nombre, anyo_nacimiento, especialidad): # Añade un agente al registro.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Insert into agentes (nombre,anyo_nacimiento,especialidad) values(?,?,?)
        """,[nombre,anyo_nacimiento,especialidad])
        conexion.commit()

def enviar_agente(id_agente, id_nave, fecha_partida): # Asigna un agente a una nave. Un agente no puede estar en dos misiones simultaneas.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        conexion.execute("PRAGMA foreign_keys = ON")
        cursor = conexion.cursor()

        cursor.execute("SELECT nombre FROM agentes WHERE id = ?", [id_agente])
        nombre_agente = cursor.fetchone()[0]

        # 1. Comprobar si el agente esta en una mision (sin fecha de regreso)
        cursor.execute("SELECT id FROM misiones WHERE id_agente = ? AND fecha_regreso IS NULL", [id_agente,])
        ocupado = cursor.fetchone()

        if ocupado:
            # Si el SELECT encontro algo, el agente esta fuera
            print("❌ Error: El agente", nombre_agente, "ya esta en mision. ¿Paradoja temporal detectada?")
        else:
            # 2. Si no encontro nada, hacemos el insert normal
            cursor.execute("""
                INSERT INTO misiones (id_agente, id_nave, fecha_partida) 
                VALUES (?, ?, ?)
            """, [id_agente, id_nave, fecha_partida])
            conexion.commit()
            print("Agente enviado con exito.")

def cerrar_mision(id_mision, exito, incidencias): # Marca la mision como terminada.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        UPDATE misiones set fecha_regreso = date('now'),exito = ?,incidencias = ? where id = ?
        """,[exito,incidencias,id_mision])
        conexion.commit()

def naves_sin_capitan(): # Lista las naves que actualmente no tienen ningun agente asignado en mision activa.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Select naves.id,naves.nombre,naves.tipo from naves
        where naves.id not in (select id_nave from misiones where fecha_regreso is null)
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
        misiones = cursor.fetchall()
        for mision in misiones:
            print(mision)

def misiones_fallidas(): # Devuelve todas las misiones donde exito = 0 y ya han terminado.
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("""
        Select * from misiones where exito =0 and fecha_regreso IS not NULL
        """)
        misiones = cursor.fetchall()
        for mision in misiones:
            print(mision)

def poblar_datos():
    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("select count(*) from naves")
        if cursor.fetchone()[0] > 0:
            return

    registrar_nave("Santa Maria","Carabela",1492,"Edad Media")
    registrar_nave("San Martin","Galeon",1571,"Siglo XVI")
    registrar_nave("Victoria","Nao",1519,"Siglo XVI")
    registrar_nave("Bucentaure","Navio",1803,"Siglo XIX")
    registrar_nave("Numancia","Fragata",1863,"Siglo XIX")

    registrar_agente("Alonso de Entrerios",1960,"Infiltracion")
    registrar_agente("Amelia Folch",1880,"Ciencias")
    registrar_agente("Julian Martinez",1985,"Historia Moderna")
    registrar_agente("Salvador Marti",1975,"Medicina")

    enviar_agente(1,1,"1492-08-03")
    cerrar_mision(1,1,None)
    enviar_agente(2,3,"1519-09-20")
    cerrar_mision(2,1,"Tormenta en el Atlantico, sin bajas.")
    enviar_agente(3,2,"1571-10-07")
    cerrar_mision(3,1,None)
    enviar_agente(4,4,"1805-10-20")
    cerrar_mision(4,0,"Nelson intercepto la flota. Retirada forzosa.")
    enviar_agente(1,5,"1898-07-03")
    cerrar_mision(5,0,"Flota enemiga superior. Nave danada.")
    enviar_agente(2,4,"2024-03-15")
    enviar_agente(2,1,"2024-04-01") # paradoja temporal, agente ya en mision

def mostrar_informe():
    print("\nNaves sin capitan asignado:")
    naves_sin_capitan()

    with sqlite3.connect("MinisterioDelTiempo.db") as conexion:
        cursor = conexion.cursor()
        cursor.execute("select id,nombre from agentes")
        agentes = cursor.fetchall()

    for id_ag,nombre_ag in agentes:
        print("\nHistorial de",nombre_ag,":")
        historial_agente(id_ag)

    print("\nMisiones fallidas registradas:")
    misiones_fallidas()

setup()
poblar_datos()
mostrar_informe()
