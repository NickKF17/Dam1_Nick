def es_primo(numero):
    # Los números menores o iguales a 1 no son primos
    if numero <= 1:
        return False

    # Verificamos divisibilidad desde 2 hasta la raíz cuadrada del número
    # Esto es mucho más rápido que probar todos los números
    for i in range(2, int(numero ** 0.5) + 1):
        if numero % i == 0:
            return False  # Si es divisible, no es primo

    return True  # Si no encontró divisores, es primo


# --- Bloque de prueba ---
try:
    num = int(input("Introduce un número para verificar: "))
    if es_primo(num):
        print(f"¡El {num} es un número primo! 🚀")
    else:
        print(f"El {num} no es primo. 🙃")
except ValueError:
    print("Por favor, introduce un número entero válido.")