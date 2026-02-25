def analizar_lecturas(num1,num2,num3,num4):
    numeros = [num1,num2,num3,num4]
    for i in numeros :
        contador = 0
        if i >100:
            contador = contador + 1
            if contador > 2 :
                print("Mal funcionamiento")



analizar_lecturas(24,190,134,123)


