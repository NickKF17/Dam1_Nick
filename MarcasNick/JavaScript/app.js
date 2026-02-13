function CambiarTexto(){
  let texto=  document.getElementById("idTexto").value
  let parrafo =document.createElement("p")
  parrafo.innerHTML=texto
  document.getElementById("idDivTexto").appendChild(parrafo)
}

function CambiarColorFondo(){
    let colorfondo =document.getElementById("idColorFondo").value
   document.querySelector("#idDivTexto").s

}