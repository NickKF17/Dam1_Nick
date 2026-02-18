tupla1 = (1,4,2,5,49,3,75,3)
tupla2 = (3,3,75,180,9,5)
listaaux = []

for i in tupla1:
    if i not in tupla2 and i not in listaaux:
        listaaux.append(i)
for i in tupla2:
    if i not in tupla1 and i not in listaaux:
        listaaux.append(i)

listaaux.sort(reverse=True)

listaaux=tuple(listaaux)
print("Los elementos que solo aparecen en una son:",listaaux)