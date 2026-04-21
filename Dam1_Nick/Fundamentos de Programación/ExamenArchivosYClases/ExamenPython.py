import csv

class Tripulante:
    def __init__(self, nombre, rango, planeta_origen, anyos_experiencia):
        self.nombre = nombre
        self.rango = rango
        self.planeta_origen = planeta_origen
        self.anyos_experiencia = anyos_experiencia

    # El __str__ es para que TÚ lo leas bien en consola
    def __str__(self):
        return f"Nombre: {self.nombre} | rango: {self.rango} | planeta_origen: {self.planeta_origen} | años_experiencia: {self.anyos_experiencia}\n"

# Esta función es la que genera la línea para el archivo
def TripulanteTOcsv(Tripulantes):
    return f"{Tripulantes.nombre},{Tripulantes.rango},{Tripulantes.planeta_origen},{Tripulantes.anyos_experiencia}\n"

def ContactoTOcsv(contacto):
    return f"{contacto.nombre};{contacto.telefono};{contacto.email}\n"

def CsvTOTripulante(lineaCSV):
    # Corregido: usamos 'lineaCSV' que es el parámetro de la función
    datos = lineaCSV.strip().split(",")
    if len(datos) == 4:
        return Tripulante(datos[0], datos[1], datos[2],datos[3])
    return None

def agregarTripulante(rutaCSV,nuevoTripulante):
    with open(rutaCSV, "a", encoding="utf-8") as tripulacion:
        tripulacion.write(TripulanteTOcsv(nuevoTripulante))

def cargar_tripulacion(rutaCSV):
    listaTripulantes = []
    try:
        with open(rutaCSV, "r", encoding="utf-8") as tripulacion:

            for linea in tripulacion:
                 listaTripulantes.append(CsvTOTripulante(linea))
    except FileNotFoundError:
            listaTripulantes=[]
    return listaTripulantes


#Imprime con formato gracias al __str__


nuevoTripulante = Tripulante("Nick", "10", "Tierra","2")

agregarTripulante("tripulacion.csv",nuevoTripulante)
contador = 0
for tripulante in cargar_tripulacion("tripulacion.csv"):
    if contador > 0:
        print(tripulante)
    contador += 1
