saldo = 1000

try:
    dinero = float(input("¿Cuánto deseas retirar?: "))
    if dinero > saldo:
        raise Exception("Fondos insuficientes.")
    saldo -= dinero
except ValueError:
    print("Debes ingresar un número válido.")
except Exception as e:
    print(e)
else:
    print("Nuevo saldo:", saldo)
finally:
    print("Retiro exitoso.")