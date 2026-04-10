
//4. Crea un  array de números aleatorios, ordénalos y muestralos en una lista ordenada

Math.random()

let numeros = []//New Array

let cantidad = Math.floor((Math.random()*20)+1)

for (let index = 0; index < cantidad; index++) {
    numeros.push(Math.floor((Math.random()*89)+10))
    
}

document.write(numeros+ "<br>")


//5. Crea una funcion que devuekva el último elemento de un array

function devolverUltimo(array) {
    return array[array.length-1]
}


document.writeln(devolverUltimo(numeros))

//Seleccionar un elemento por id #

 parrafo = document.getElementById("p1")
 let nodoTexto = document.createTextNode("patata")
 parrafo.appendChild(nodoTexto)
 //parrafo.innerHTML = "patata"
 //Nos da una colección de elementos
 let elementos = document.getElementsByClassName("textoCaja")
 for (let index = 0; index < elementos.length; index++) {
    elementos[index].innerHTML = "patata";
    
 }
// busca elementos por atributo de NAme
document.getElementsByName()

//bsca elementos de una misma etiqueta
let parrafos = document.getElementsByTagName("p")
document.writeln(parrafos.length)
for (let index = 0; index < parrafos.length; index++) {
    document.writeln(parrafos[indez].getHTML())
    
}

document.getElementsByClassName()
document.getElementsByName()
document.getElementsByTagName()
document.getElementsByTagNameNS()