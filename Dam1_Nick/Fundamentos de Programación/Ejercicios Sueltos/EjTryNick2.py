def convertirEntero(lista):
    resultado = []
    for cosa in lista:
        try:
            num = int(cosa)
            resultado.append(num)
        except ValueError:
            pass
    return resultado

lis = ["17", "Nick", "01", "10.04"]

print(convertirEntero(lis))