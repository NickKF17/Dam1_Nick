import NumPy as np

lista=[]
num=0

while num>=0:
    num=int(input("Introduce un numero: "))
    lista.append(num)



lista.sort()

print(lista)

lista.sort(reverse=True)

print(lista)