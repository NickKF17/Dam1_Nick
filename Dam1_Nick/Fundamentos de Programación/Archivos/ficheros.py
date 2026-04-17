with open("quijote.txt") as quijote:
    print(quijote)
    print(quijote.read())
    quijote.seek(0)
    print(quijote.readlines())

    with open("quijote.txt") as quijote2:
        contador = 0
        for linea in quijote2:
            linea.strip()