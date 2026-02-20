function capturarValores(){

    let texto = document.querySelector("#idTexto").value;
    let numero = document.querySelector("#idNumero").value;
    let password = document.querySelector("#idPassword").value;
    let fecha = document.querySelector("#idFecha").value;
    let hora = document.querySelector("#idHora").value;
    let radio = document.querySelector("#idRadio").value;
    let checkbox = document.querySelector("#idCheckbox").value;
    let select = document.querySelector("#idSelect").value;

    let visualizar = "";
    visualizar += "TEXTO: "+ texto + "\n";
    visualizar += "NUMERO: "+ numero + "\n";
    visualizar += "PASSWORD: "+ password + "\n";
    visualizar += "FECHA: "+ fecha + "\n";
    visualizar += "HORA: " + hora + "\n";
    visualizar += "RADIO: "+ radio + "\n";
    visualizar += "CHECKBOX: " + checkbox + "\n";
    visualizar += "SELECT: " + select + "\n";

    alert(visualizar);
}
