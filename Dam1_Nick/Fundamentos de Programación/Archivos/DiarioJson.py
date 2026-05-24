import json
import datetime

RUTA = "diario.json"

def cargar_diario(ruta=RUTA):
    try:
        with open(ruta, "r", encoding="utf-8") as f:
            return json.load(f)
    except FileNotFoundError:
        return []

def guardar_diario(entradas, ruta=RUTA):
    with open(ruta, "w", encoding="utf-8") as f:
        json.dump(entradas, f, ensure_ascii=False, indent=2)

def añadir_entrada(titulo, texto):
    entradas = cargar_diario()
    nueva = {
        "fecha": str(datetime.date.today()),
        "titulo": titulo,
        "texto": texto
    }
    entradas.append(nueva)
    guardar_diario(entradas)
    print(f"Entrada '{titulo}' guardada el {nueva['fecha']}.")

def listar_entradas(n=5):
    entradas = cargar_diario()
    if not entradas:
        print("El diario está vacío.")
        return
    ultimas = entradas[-n:]
    print(f"\nÚltimas {len(ultimas)} entradas:\n")
    for e in reversed(ultimas):
        print(f"  [{e['fecha']}] {e['titulo']}")
        print(f"  {e['texto']}")
        print("  " + "-" * 40)

def buscar_entradas(palabra_clave):
    entradas = cargar_diario()
    resultados = [
        e for e in entradas
        if palabra_clave.lower() in e["titulo"].lower()
        or palabra_clave.lower() in e["texto"].lower()
    ]
    if not resultados:
        print(f"No se encontraron entradas con '{palabra_clave}'.")
        return
    print(f"\n{len(resultados)} resultado(s) para '{palabra_clave}':\n")
    for e in resultados:
        print(f"  [{e['fecha']}] {e['titulo']}")
        print(f"  {e['texto']}")
        print("  " + "-" * 40)

def menu():
    print("\n=== DIARIO PERSONAL ===")
    print("1. Nueva entrada")
    print("2. Listar últimas entradas")
    print("3. Buscar por palabra clave")
    print("4. Salir")

def main():
    while True:
        menu()
        opcion = input("\nElige una opción: ").strip()

        if opcion == "1":
            titulo = input("Título: ").strip()
            texto = input("Texto: ").strip()
            if titulo and texto:
                añadir_entrada(titulo, texto)
            else:
                print("El título y el texto no pueden estar vacíos.")

        elif opcion == "2":
            try:
                n = int(input("¿Cuántas entradas quieres ver? (por defecto 5): ").strip() or "5")
            except ValueError:
                n = 5
            listar_entradas(n)

        elif opcion == "3":
            palabra = input("Palabra clave a buscar: ").strip()
            if palabra:
                buscar_entradas(palabra)
            else:
                print("Escribe una palabra clave.")

        elif opcion == "4":
            print("¡Hasta luego!")
            break

        else:
            print("Opción no válida. Elige entre 1 y 4.")

if __name__ == "__main__":
    main()