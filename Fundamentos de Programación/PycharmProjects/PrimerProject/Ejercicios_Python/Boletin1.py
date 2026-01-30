import random



def ejercicio1():
    for i in range(11):
        print(i, end=":\n")

def ejercicio2():
    for i in range(101):
        if i%2==0:
            print(i)

def ejercicio3():
    teclado=int(input("Di un numero"))
    for i in range(1,6):
        print(teclado*i)
def ejercicio4():
     print("Solucion ejercicio 4")

def ejercicio5():
     print("Solucion ejercicio 5")

def ejercicio6():
     print("Solucion ejercicio 6")

def ejercicio7():
    numero=int(input("¿Cuánto cuesta?"))
    print(numero*1.21)
def ejercicio8():
     print("Solucion ejercicio 8")

def ejercicio9():
     print("Solucion ejercicio 9")

def ejercicio10():
     print("Solucion ejercicio 10")

def ejercicio11():
    print("Solucion ejercicio 10")

def ejercicio12():
  for i in range(6):
    numero = random.randint(1 ,49)
    print(numero)

def ejercicio13():
    print("Solucion ejercicio 10")

def ejercicio14():
     print("Solucion ejercicio 10")

def ejercicio15():
     print("Solucion ejercicio 10")

def ejercicio16():

    primo=False
    while not primo:
        primo =True
        numero = random.randint(int(1e7), int(5e7))
        for i in range(2, int(numero/2)):
            if numero%i==0:
                primo = False
                break
        print(numero)

if __name__=='__main__':
    # ejercicio1()
    # ejercicio2()
    # ejercicio3()
    # ejercicio4()
    # ejercicio5()
    # ejercicio6()
    # ejercicio7()
    # ejercicio8()
    # ejercicio9()
    # ejercicio9()
    # ejercicio10()
    # ejercicio11()
    # ejercicio12()
    # ejercicio13()
    # ejercicio14()
    # ejercicio15()
     ejercicio16()