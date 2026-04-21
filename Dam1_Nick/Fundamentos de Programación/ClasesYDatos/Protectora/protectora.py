class Animal:
    def __init__(self, anio_nacimiento: int, nombre: str = None):
        if not isinstance(anio_nacimiento, int) or anio_nacimiento < 1900:
            raise ValueError("El año de nacimiento debe ser un entero válido.")
        self._anio_nacimiento = anio_nacimiento
        self._nombre = nombre
        self._adoptado = False

    @property
    def anio_nacimiento(self):
        return self._anio_nacimiento

    @property
    def nombre(self):
        return self._nombre if self._nombre else "Sin nombre"

    @property
    def adoptado(self):
        return self._adoptado

    def marcar_adoptado(self):
        self._adoptado = True

    def marcar_disponible(self):
        self._adoptado = False

    def __str__(self):
        estado = "Adoptado" if self._adoptado else "Disponible"
        return (f"[{self.__class__.__name__}] {self.nombre} "
                f"| Nacido: {self._anio_nacimiento} | Estado: {estado}")


class AnimalesConVacuna(Animal):
    def __init__(self, anio_nacimiento: int, vacunado: bool, nombre: str = None):
        super().__init__(anio_nacimiento, nombre)
        if not isinstance(vacunado, bool):
            raise ValueError("El campo 'vacunado' debe ser True o False.")
        self._vacunado = vacunado

    @property
    def vacunado(self):
        return self._vacunado

    def __str__(self):
        vacuna = "Vacunado ✓" if self._vacunado else "Sin vacunar ✗"
        return super().__str__() + f" | {vacuna}"


class Perro(AnimalesConVacuna):
    def __init__(self, anio_nacimiento: int, vacunado: bool, nombre: str = None):
        super().__init__(anio_nacimiento, vacunado, nombre)


class Gato(AnimalesConVacuna):
    def __init__(self, anio_nacimiento: int, vacunado: bool, nombre: str = None):
        super().__init__(anio_nacimiento, vacunado, nombre)


class Tortuga(Animal):
    def __init__(self, anio_nacimiento: int, nombre: str = None):
        super().__init__(anio_nacimiento, nombre)


class Cliente:
    LIMITE_PERROS   = 2
    LIMITE_GATOS    = 3
    LIMITE_TORTUGAS = 1
    LIMITE_TOTAL    = 4

    def __init__(self, nombre: str, apellido: str, edad: int, telefono: str):
        if not nombre or not apellido:
            raise ValueError("El nombre y el apellido son obligatorios.")
        if not isinstance(edad, int) or edad < 0:
            raise ValueError("La edad debe ser un número entero positivo.")
        self._nombre   = nombre
        self._apellido = apellido
        self._edad     = edad
        self._telefono = telefono
        self._animales: list[Animal] = []

    @property
    def nombre_completo(self):
        return f"{self._nombre} {self._apellido}"

    @property
    def animales(self):
        return list(self._animales)

    def _contar(self, tipo: type) -> int:
        return sum(1 for a in self._animales if isinstance(a, tipo))

    def adoptar(self, animal: Animal) -> None:
        if animal.adoptado:
            raise ValueError(f"{animal.nombre} ya ha sido adoptado por otra persona.")
        if len(self._animales) >= self.LIMITE_TOTAL:
            raise ValueError(
                f"{self.nombre_completo} ya ha alcanzado el límite de {self.LIMITE_TOTAL} animales."
            )
        if isinstance(animal, Perro) and self._contar(Perro) >= self.LIMITE_PERROS:
            raise ValueError(
                f"{self.nombre_completo} ya tiene {self.LIMITE_PERROS} perros (límite alcanzado)."
            )
        if isinstance(animal, Gato) and self._contar(Gato) >= self.LIMITE_GATOS:
            raise ValueError(
                f"{self.nombre_completo} ya tiene {self.LIMITE_GATOS} gatos (límite alcanzado)."
            )
        if isinstance(animal, Tortuga) and self._contar(Tortuga) >= self.LIMITE_TORTUGAS:
            raise ValueError(
                f"{self.nombre_completo} ya tiene {self.LIMITE_TORTUGAS} tortuga(s) (límite alcanzado)."
            )
        animal.marcar_adoptado()
        self._animales.append(animal)
        print(f"✔ {self.nombre_completo} ha adoptado a {animal.nombre} ({animal.__class__.__name__}).")

    def listar_animales(self) -> None:
        print(f"\n── Animales adoptados por {self.nombre_completo} ──")
        if not self._animales:
            print("  Este cliente aún no ha adoptado ningún animal.")
        else:
            for i, a in enumerate(self._animales, 1):
                print(f"  {i}. {a}")

    def __str__(self):
        return (f"Cliente: {self.nombre_completo} | Edad: {self._edad} "
                f"| Tel: {self._telefono} | Animales: {len(self._animales)}")


class Protectora:
    def __init__(self, nombre: str):
        self._nombre = nombre
        self._animales: list[Animal]  = []
        self._clientes: list[Cliente] = []

    def registrar_animal(self, animal: Animal) -> None:
        self._animales.append(animal)

    def registrar_cliente(self, cliente: Cliente) -> None:
        self._clientes.append(cliente)

    def listar_disponibles(self) -> None:
        print(f"\n══ Animales SIN adoptar en {self._nombre} ══")
        disponibles = [a for a in self._animales if not a.adoptado]
        if not disponibles:
            print("  No hay animales disponibles en este momento.")
        else:
            for i, a in enumerate(disponibles, 1):
                print(f"  {i}. {a}")

    def listar_adoptados_por(self, cliente: Cliente) -> None:
        cliente.listar_animales()

    def __str__(self):
        return (f"Protectora '{self._nombre}' | "
                f"Animales: {len(self._animales)} | Clientes: {len(self._clientes)}")


if __name__ == "__main__":
    protectora = Protectora("Huellitas Felices")

    p1 = Perro(2020, True, "Rex")
    p2 = Perro(2019, False, "Laika")
    p3 = Perro(2022, True)
    g1 = Gato(2021, True, "Misi")
    g2 = Gato(2018, False, "Luna")
    g3 = Gato(2023, True, "Nala")
    g4 = Gato(2020, False)
    t1 = Tortuga(2015, "Speedy")
    t2 = Tortuga(2010)

    for animal in [p1, p2, p3, g1, g2, g3, g4, t1, t2]:
        protectora.registrar_animal(animal)

    c1 = Cliente("Ana",   "García",   34, "600111222")
    c2 = Cliente("Luis",  "Martínez", 28, "600333444")
    c3 = Cliente("Marta", "López",    45, "600555666")

    for cliente in [c1, c2, c3]:
        protectora.registrar_cliente(cliente)

    c1.adoptar(p1)
    c1.adoptar(g1)
    c1.adoptar(t1)
    c1.adoptar(p2)

    c2.adoptar(g2)
    c2.adoptar(g3)
    c2.adoptar(g4)
    c2.adoptar(t2)

    try:
        c1.adoptar(p3)
    except ValueError as e:
        print(f"✘ {e}")

    try:
        c2.adoptar(g1)
    except ValueError as e:
        print(f"✘ {e}")

    protectora.listar_disponibles()
    protectora.listar_adoptados_por(c1)
    protectora.listar_adoptados_por(c2)
    protectora.listar_adoptados_por(c3)
