numeros = [1,2,3]
document.writeln(numeros[2])
document.write(numeros, "<br>")
document.writeln(numeros[6])

numeros[4]=4
document.writeln(numeros, "<br>")

//añade un elemento al final del array
numeros.push(5)
document.writeln(numeros, "<br>")

//añade un elemento al principio de un array
numeros.unshift(0)
document.writeln(numeros, "<br>")

//es como un shift en linux, elmina el último elemento del array
numeros.pop()
document.writeln(numeros, "<br>")
