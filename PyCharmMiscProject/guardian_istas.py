from csv import excel

colores=["rojo","amarillo","azul","verde","magenta","cyan"]

try:
    posicion=int(input("Dime una posicion"))
    print(colores[posicion])
except ValueError:
    print("El numero no es valido")
except IndexError:
    print("Solo tenemos 6 psosiciones")
    