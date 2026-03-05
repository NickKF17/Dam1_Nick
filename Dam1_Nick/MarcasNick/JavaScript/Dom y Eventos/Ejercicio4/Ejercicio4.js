

function Sumar(){
    let numero1 = parseInt(document.getElementById("idNum1").value)
    let numero2 = parseInt(document.getElementById("idNum2").value)

    let resultado = numero1 + numero2

    document.getElementById("idNumResultado").value = resultado

}
function Restar(){
    let numero1 = parseInt(document.getElementById("idNum1").value)
    let numero2 = parseInt(document.getElementById("idNum2").value)

    let resultado = numero1 - numero2

    document.getElementById("idNumResultado").value = resultado
    
}
function Producto(){
    let numero1 = parseInt(document.getElementById("idNum1").value)
    let numero2 = parseInt(document.getElementById("idNum2").value)

    let resultado = numero1 * numero2

    document.getElementById("idNumResultado").value = resultado
    
}

function Dividir(){
    let numero1 = parseInt(document.getElementById("idNum1").value)
    let numero2 = parseInt(document.getElementById("idNum2").value)

    let resultado = numero1 / numero2

    document.getElementById("idNumResultado").value = resultado
    
}
function Limpiar(){

    document.querySelector("#idNum1").value = " "
    document.querySelector("#idNum2").value = " "
    document.querySelector("#idNumResultado").value = " "


    
}
