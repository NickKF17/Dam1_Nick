import random


class Pokemon:
    def __init__(self, nombre, codigo, tipos, peso_min, peso_max, altura_min, altura_max):
        """
        Constructor de la clase Pokemon
        - nombre: nombre del pokemon
        - codigo: código identificador
        - tipos: lista con 1 o 2 tipos
        - peso_min, peso_max: rango para generar el peso
        - altura_min, altura_max: rango para generar la altura
        """
        self.nombre = nombre
        self.codigo = codigo

        # Validar que los tipos sean 1 o 2
        if not tipos or len(tipos) > 2:
            raise ValueError("El pokemon debe tener 1 o 2 tipos")
        self.tipos = tipos

        # Generar peso y altura aleatorios
        self.peso = random.uniform(peso_min, peso_max)
        self.altura = random.uniform(altura_min, altura_max)

    def ver_datos(self):
        """Muestra todos los datos del pokemon"""
        print(f"\n--- Datos del Pokemon ---")
        print(f"Código: {self.codigo}")
        print(f"Nombre: {self.nombre}")
        print(f"Tipos: {', '.join(self.tipos)}")
        print(f"Peso: {self.peso:.2f} kg")
        print(f"Altura: {self.altura:.2f} m")
        print("------------------------")

    def __str__(self):
        """Representación en string del pokemon"""
        return f"{self.nombre} (Cód: {self.codigo}) - Tipos: {', '.join(self.tipos)}"


class Equipo:
    def __init__(self, nombre_equipo, entrenador):
        """
        Constructor de la clase Equipo
        - nombre_equipo: nombre del equipo
        - entrenador: nombre del entrenador
        """
        self.nombre_equipo = nombre_equipo
        self.entrenador = entrenador
        self.pokemons = []  # Lista para almacenar hasta 3 pokemons

    def agregar_pokemon(self, pokemon):
        """Agrega un pokemon al equipo si hay espacio"""
        if len(self.pokemons) < 3:
            self.pokemons.append(pokemon)
            print(f"✓ {pokemon.nombre} ha sido añadido al equipo {self.nombre_equipo}")
            return True
        else:
            print(f"❌ No se puede añadir {pokemon.nombre}. El equipo ya tiene 3 pokemons")
            return False

    def ver_datos_equipo(self):
        """Muestra todos los datos del equipo y sus pokemons"""
        print(f"\n{'=' * 40}")
        print(f"EQUIPO: {self.nombre_equipo}")
        print(f"ENTRENADOR: {self.entrenador}")
        print(f"{'=' * 40}")

        if not self.pokemons:
            print("El equipo no tiene pokemons aún")
        else:
            print(f"\nPokemons en el equipo ({len(self.pokemons)}/3):")
            for i, pokemon in enumerate(self.pokemons, 1):
                print(f"\nPokemon #{i}:")
                pokemon.ver_datos()

        print(f"\n{'=' * 40}")

    def __str__(self):
        """Representación en string del equipo"""
        num_pokemons = len(self.pokemons)
        return f"Equipo: {self.nombre_equipo} | Entrenador: {self.entrenador} | Pokemons: {num_pokemons}/3"


# ==================== EJEMPLO DE USO ====================
if __name__ == "__main__":
    # Crear algunos pokemons
    print("=== Creando Pokemons ===\n")

    # Pokemon de un solo tipo
    pikachu = Pokemon(
        nombre="Pikachu",
        codigo="P001",
        tipos=["Eléctrico"],
        peso_min=5.0,
        peso_max=7.0,
        altura_min=0.3,
        altura_max=0.5
    )

    # Pokemon de dos tipos
    charizard = Pokemon(
        nombre="Charizard",
        codigo="P002",
        tipos=["Fuego", "Volador"],
        peso_min=80.0,
        peso_max=100.0,
        altura_min=1.5,
        altura_max=1.8
    )

    # Otro pokemon
    bulbasaur = Pokemon(
        nombre="Bulbasaur",
        codigo="P003",
        tipos=["Planta", "Veneno"],
        peso_min=6.0,
        peso_max=8.0,
        altura_min=0.6,
        altura_max=0.8
    )

    # Mostrar datos de los pokemons
    pikachu.ver_datos()
    charizard.ver_datos()
    bulbasaur.ver_datos()

    # Crear un equipo
    print("\n=== Creando Equipo ===\n")
    mi_equipo = Equipo("Fénix Rojo", "Ash Ketchum")

    # Agregar pokemons al equipo
    mi_equipo.agregar_pokemon(pikachu)
    mi_equipo.agregar_pokemon(charizard)
    mi_equipo.agregar_pokemon(bulbasaur)

    # Intentar agregar un cuarto pokemon (debería fallar)
    pokemon_extra = Pokemon("Squirtle", "P004", ["Agua"], 8.0, 10.0, 0.4, 0.6)
    mi_equipo.agregar_pokemon(pokemon_extra)

    # Ver datos completos del equipo
    mi_equipo.ver_datos_equipo()