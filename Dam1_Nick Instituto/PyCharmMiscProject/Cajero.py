from sys import excepthook

saldo =1000

try:
    retirada =int(input("Ingrese una cantidad de retirada: "))
    if retirada > saldo:
        raise Exception("La retirada no puede ser mayor que el saldo")

    saldo-=retirada

except ValueError as e:
    print(e)
    print("No es un numero valido")
except Exception as e:
    print(e)
else:
    print("Saldo restante: ",saldo)
    print("Efectivo:",retirada)
finally:
    print("Gracias por usar nuestro cajero")

def validar_retirada(retirada):
    retirada = int(retirada)
    if retirada <0 :
        raise ValueError("No se puede retirar un numero negativo")
    