def fraccion(frac):
    algo = frac.split("/")
    if len(algo) != 2:
        return 0
    try:
        numerador = int(algo[0])
        denominador = int(algo[1])
        if denominador == 0:
            return 0
        return numerador / denominador
    except ValueError:
        return 0

print(fraccion("25/10"))
print(fraccion("a/10"))
print(fraccion("//10"))
print(fraccion("10"))