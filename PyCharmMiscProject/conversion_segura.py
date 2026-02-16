def convertir_a_entero(lista=[]):
    resultado=[]
    for item in lista:
        try:
            resultado.append(int(item))
            numero=int(item)
            resultado.append(numero)
        except:
            pass
    return resultado

lista_entrada=["10","hola","20","3.5"]
print(lista_entrada)
lista_numeros=convertir_a_entero(lista_entrada)
print(lista_numeros)