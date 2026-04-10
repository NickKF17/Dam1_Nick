const inputNombre = document.getElementById("guest-name")
let lista=document.getElementById("guest-list")
let errormensaje=document.getElementById("error-msg")
let crearelemento=document.createElement("li");
let crearboton=document.createElement("button")
function nuevoelemento() {

lista.appendChild(crearelemento).textContent=inputNombre.value

        return true
}

function comprobarNombre() {
    let nombre = inputNombre.value
    if(nombre.length < 3 ){
errormensaje.textContent="El nombre debe tener al menos 3 caracteres";
        return false
}
        else{
            return true
}
}
function validar(){
    if(comprobarNombre() == true) 
    nuevoelemento()
    limpiarentrada()
}
function limpiarentrada(){
    if(comprobarNombre()==true){
    inputNombre.value=""
    errormensaje.textContent=""
    }
}