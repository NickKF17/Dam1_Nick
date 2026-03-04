colores = ["blanco", "gris", "azul", "amarillo", "morado"]

try:
    cosa = int(input("Ingresa un índice del 0 al 4: "))
    print("Color:", colores[cosa])
except IndexError:
    print("Fuera de rango.")
except ValueError:
    print("Número inválido.")