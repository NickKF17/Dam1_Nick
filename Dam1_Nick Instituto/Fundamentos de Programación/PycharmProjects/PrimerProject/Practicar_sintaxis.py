''' Ejercicio 3 Boletin 5

lista = []

lista.append(input('Introduce el nombre: ').strip())
lista.append(input('Introduce la asignatura: ').strip())
lista.append(float(input('Introdice la nota del primer trimestre: ').strip()))
lista.append(float(input('Introdice la nota del segundo trimestre: ').strip()))
lista.append(float(input('Introdice la nota del tercer trimestre: ').strip()))

media = (lista[2]+lista[3]+lista[4])/3

print('Nombre: ', lista[0])
print('Asignatura', lista[1])
print('Nota del primer trimestre:', lista)
'''




'''Ejercicio 4 Boletin 5

mes=0
year=0
while mes<=0 or mes>12:
    mes=int(input("Escribe un numero de mes válido"))
    year=int(input("Escribe un numero de año válido"))


lista = ["Febrero,29","Enero,31","Febrero,28","Marzo,31","Abril,30","Mayo,31","Junio,30","Julio,31","Agosto,31","Septiembre,30","Octumbre,31","Noviembre,30","Diciembre,31"]


if year%4!=0:
    print(lista[mes])
elif year%4==0 and mes==2:
    print(lista[mes-2])
    '''

'''Ejercicio 5 Boletín 5'''

Primitiva=[]