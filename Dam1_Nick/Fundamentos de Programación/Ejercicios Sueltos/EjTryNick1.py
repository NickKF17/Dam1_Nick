try:
    num1 = float(input("Primer número: "))
    num2 = float(input("Segundo número: "))

    resultado = num1 / num2
    print("Resultado:", resultado)

except ZeroDivisionError:
    print("No se puede dividir entre cero.")
except ValueError:
    print("Debes ingresar dos números válidos.")