print("Hola Nick")

a = 8 #Entero
b = 0.0 #Real o float
c= 2+4j #Complejo
d = 1.2e-3 #notacion científica:0,0012

a +=1
b-=0.5

print(a)
print(b)
print(c)
print(d)


print(a,b,c,d,sep=",",end="+")  #sep es la variable con la que van a ir separadas las variables
print("Prueba")

print(a+b)

cadena = "Prueba \" de cadena."
#         012345
cadena_simple = 'Prueba de cadena \' simple.'

print(cadena)
print(cadena_simple)

print(cadena,cadena_simple)

print(str(a)+ " " + cadena)
print(str(a) + cadena)
print(a + len(cadena)) #Longitud de la cadena con len

a+=1
print(a*cadena)

print(cadena[5])
print(cadena[-1]) #-1 significa la ultima posicion
print(cadena[-5]) #-5 significa la 5 posicion empezando desde la derecha hacia la izquierda
print(cadena[:3]) #Coge los 4 primeros (0,1,2,3) sin incluir la 4
