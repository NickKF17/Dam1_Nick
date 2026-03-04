function Sumar(){
    let numero1=parseInt(document.getElementById("idNum1").value)
    let numero2=parseInt(document.getElementById("idNum2").value)
    let resultado= numero1+numero2

    document.getElementById("idNumResultado").value=resultado
}
function Restar() {
     let numero1=parseInt(document.getElementById("idNum1").value)
    let numero2=parseInt(document.getElementById("idNum2").value)
    let resultado= numero1-numero2

    document.getElementById("idNumResultado").value=resultado
}
function Producto() {
     let numero1=parseInt(document.getElementById("idNum1").value)
    let numero2=parseInt(document.getElementById("idNum2").value)
    let resultado= numero1*numero2

    document.getElementById("idNumResultado").value=resultado
}
function Dividir() {
    try{
     let numero1=parseInt(document.getElementById("idNum1").value)
    let numero2=parseInt(document.getElementById("idNum2").value)
    let resultado= numero1/numero2
    }catch (error){
        resultado = error
    
    }
    document.getElementById("idNumResultado").value=resultado
    
}
function Limpiar() {
    
}