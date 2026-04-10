function CambiarTexto(){
  let texto=  document.getElementById("idTexto").value
  let parrafo =document.createElement("p")
  parrafo.innerHTML=texto
  document.getElementById("idDivTexto").appendChild(parrafo)
}

function CambiarColorFondo(){
    let colorfondo =document.getElementById("idColorFondo").value
   document.querySelector("#idDivTexto").style.backgroundColor = colorfondo
}
function CambiarColorBorde(){
  let colorborde=document.getElementById("idColorBorde").value
  document.querySelector("#idDivTexto").style.borderColor=colorborde
}
function CambiarColorTexto(){
  let colorletra=document.getElementById("idColorTexto").value
  document.querySelector("#idDivTexto").style.color=colorletra

}