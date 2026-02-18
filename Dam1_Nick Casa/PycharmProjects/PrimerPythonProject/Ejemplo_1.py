print("Hola Mundo")

a = 0       #Entero
b = 1.0     #Real o float
c = 2 + 4j  #Conplejo
d = 1.2e-3  #Notación Cientifica: 0,0012

a += 1
b -= 0.5
print(a)
print(b)

print(a,b,c,d,sep=",",end=" ")
print("prueba")

print(a+b)

cadena = "Prueba de cadena."
cadena_simple = "Prueba de cadena símple."

print(str(a) + cadena)
print(a + len(cadena))
a+=1
print(a*cadena)

print(cadena[5])    #Posición 5
print(cadena[-1])    #Última Posición
print(cadena[:3])    #Hasta la posición 3