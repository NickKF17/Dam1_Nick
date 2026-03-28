import random


class Pokemon:
    def __init__(self, nombre, codigo, tipos, peso_min, peso_max, altura_min, altura_max):

        self.nombre = nombre
        self.codigo = codigo

        if not tipos or len(tipos) > 2:
            raise ValueError("El pokemon debe tener 1 o 2 tipos")
        self.tipos = tipos


        self.peso = random.uniform(peso_min, peso_max)
        self.altura = random.uniform(altura_min, altura_max)

    def ver_datos(self):

        print(f"\n--- Datos del Pokemon ---")
        print(f"Código: {self.codigo}")
        print(f"Nombre: {self.nombre}")
        print(f"Tipos: {', '.join(self.tipos)}")
        print(f"Peso: {self.peso:.2f} kg")
        print(f"Altura: {self.altura:.2f} m")
        print("------------------------")

    def __str__(self):

        return f"{self.nombre} (Cód: {self.codigo}) - Tipos: {', '.join(self.tipos)}"


class Equipo:
    def __init__(self, nombre_equipo, entrenador):

        self.nombre_equipo = nombre_equipo
        self.entrenador = entrenador
        self.pokemons = []

    def agregar_pokemon(self, pokemon):

        if len(self.pokemons) < 3:
            self.pokemons.append(pokemon)
            print(f"✓ {pokemon.nombre} ha sido añadido al equipo {self.nombre_equipo}")
            return True
        else:
            print(f"No se puede añadir {pokemon.nombre}. El equipo ya tiene 3 pokemons")
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

        num_pokemons = len(self.pokemons)
        return f"Equipo: {self.nombre_equipo} | Entrenador: {self.entrenador} | Pokemons: {num_pokemons}/3"


if __name__ == "__main__":

    print("=== Creando Pokemons ===\n")


    pikachu = Pokemon(
        nombre="Pikachu",
        codigo="P001",
        tipos=["Eléctrico"],
        peso_min=5.0,
        peso_max=7.0,
        altura_min=0.3,
        altura_max=0.5
    )


    charizard = Pokemon(
        nombre="Charizard",
        codigo="P002",
        tipos=["Fuego", "Volador"],
        peso_min=80.0,
        peso_max=100.0,
        altura_min=1.5,
        altura_max=1.8
    )


    bulbasaur = Pokemon(
        nombre="Bulbasaur",
        codigo="P003",
        tipos=["Planta", "Veneno"],
        peso_min=6.0,
        peso_max=8.0,
        altura_min=0.6,
        altura_max=0.8
    )


    pikachu.ver_datos()
    charizard.ver_datos()
    bulbasaur.ver_datos()


    print("\n=== Creando Equipo ===\n")
    mi_equipo = Equipo("Fénix Rojo", "Ash Ketchum")


    mi_equipo.agregar_pokemon(pikachu)
    mi_equipo.agregar_pokemon(charizard)
    mi_equipo.agregar_pokemon(bulbasaur)

    # Intentar agregar un cuarto pokemon (debería fallar)
    pokemon_extra = Pokemon("Squirtle", "P004", ["Agua"], 8.0, 10.0, 0.4, 0.6)
    mi_equipo.agregar_pokemon(pokemon_extra)


    mi_equipo.ver_datos_equipo()