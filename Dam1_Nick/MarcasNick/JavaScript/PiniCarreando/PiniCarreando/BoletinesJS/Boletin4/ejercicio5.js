let lista = []
let cadena = ""

const parrafo = document.getElementById("parrafo")
parrafo.style.backgroundColor = "white"
function añadirTarea() {
    cadena += "· " + prompt("Introduce la tarea que quieres añadir") + "\n"
    parrafo.innerText = cadena
}