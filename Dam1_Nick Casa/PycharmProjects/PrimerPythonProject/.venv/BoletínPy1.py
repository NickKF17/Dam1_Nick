import random


def ejercicio1():
    print('Ejercicio1')
    print()
    for i in range(11):
        print(i, end=' ')   #end=' ' es para evitar el salto de linea y que haya un espacio entre ellos

def ejercicio7():
    print('Ejercicio7')
    print()
    num = int(input('Introduce el número: '))
    print(num * 1.21)

def ejercicio12():
    print('Ejercicio12')
    print()
    for i in range(6):
        num = random.randint(1,49)
        print(num, end=' ')

def ejercicio16():
    print('Ejercicio16')
    print()
    primo = True
    while primo:
        random_num = random.randint(int(1e7), int(5e7))
        for i in range(2, int(random_num/2)):
            if random_num % i != 0:
                primo = False
    print(random_num)


#PARA EJECUTAR LOS EJERCICIOS
if __name__ == '__main__':
    ejercicio16()