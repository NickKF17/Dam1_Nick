def programa_poblacion():
    paises_poblacion = {}

    print("Registro de Población Mundial 2024")
    print("Instrucciones: Introduce el nombre del país y su población (en millones).")
    print("Escribe '-1' en el nombre del país para finalizar.\n")

    while True:
        pais = input("Nombre del país: ").strip()
    
        if pais == "-1":
            break
        
        try:
            poblacion = float(input(f"Población de {pais} (en millones): "))
      
            paises_poblacion[pais] = poblacion
        except ValueError:
            print("Error: Por favor, introduce un número válido para la población.")
            continue


    if paises_poblacion:
        
        paises_ordenados = sorted(paises_poblacion.items(), key=lambda item: item[1], reverse=True)

        print("\n--- Lista de Países Ordenados por Población ---")
        for i, (pais, pob) in enumerate(paises_ordenados, start=1):
            print(f"{i}. {pais}: {pob} millones")
    else:
        print("\nNo se ingresaron datos para mostrar.")


programa_poblacion()