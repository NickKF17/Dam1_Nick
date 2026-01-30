
i="3"
i= int(i)
print(i+i)
'''
nombre= input("Ingrese su nombre: ")#Esto es un comentario
print(nombre)
'''

fruta="Manzana"
print(len(fruta))
print(fruta[len(fruta)-1])




indice=0
while indice < len(fruta):
    letra= fruta[indice]
    print(indice,letra)
    indice +=1

print(" ")
i=0
for letra in fruta:

        print(i,letra)
        i += 1

print("")

contador=0
for letra in fruta:
    if letra == "a":
        contador+= 1

print(contador)


s="Ali"
t=5
print(s[0:2])



print("Buenas " + s + " "+ str(t))



print ("a" in fruta)


if fruta == "Manzana":
    print ("Muy bien bananas")
elif fruta < "Manzana":
    print("Tu palabra " + fruta + " esta antes de Manzana")
elif fruta > "Manzana":
    print("Tu palabra " + fruta + " esta despues de Manzana")


saludo = "Hola bob"
zap=saludo.lower()
print(zap)


palabra="Buenas tardes a todos"
print(palabra.find("b"))


saludo2= "Buenas tardes"


print(saludo2.replace("tardes","noches"))


#Substrings
data = "Algo@ ejemplo.com"

arrpos = data.find("@")

print(arrpos)

esppos = data.find(" ")
print(esppos)

dominio = data[arrpos : esppos]

print(dominio)



a=5
b=3

if a>b:
    print("A es mayor")
elif a<b:
    print("A es menor")
else:
    print("Son iguales")



num= int(input("Introduce un numero menor que 5: "))

if num>5:
    print("Tu numero "   + str(num) +  " es mayor que 5")
elif num<5:
    print("Tu numero " + str(num) + " es menor que 5")
else:
    print("Tu numero es el 5")