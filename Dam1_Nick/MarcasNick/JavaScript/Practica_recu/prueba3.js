let asignatura = document.getElementById("asignatura");
let nota = document.getElementById("nota");

function validaarAsignaturaYNota() {
    if (asignatura.value === "" || nota.value < 0 || nota.value > 10) {
        document.getElementById("error-msg").textContent = "Por favor, ingrese una asignatura y una nota válida (0-10).";
        return false;
    } else {
        document.getElementById("error-msg").textContent = "";
        return true;
    }
}

function agregarAsignaturaYNota() {
    let lista = document.getElementById("notas-list");
    let nuevaEntrada = document.createElement("li");
    nuevaEntrada.textContent = `${asignatura.value} : ${nota.value}`;
    lista.appendChild(nuevaEntrada);

    let btneliminar = document.createElement("button");
    btneliminar.textContent = "Eliminar";
    btneliminar.addEventListener("click", function() {
        lista.removeChild(nuevaEntrada);
        mediaNotas();
    });
    nuevaEntrada.appendChild(btneliminar);
}

function mediaNotas() {
    let lista = document.getElementById("notas-list");
    let total = 0;
    let count = 0;
    for (let i = 0; i < lista.children.length; i++) {
        let notaTexto = lista.children[i].textContent.split(":")[1].trim();
        total += parseFloat(notaTexto);
        count++;
    }
    if (count === 0) {
    document.getElementById("media").textContent = "Media: 0";
    return;
}
    let media = total / count;
    document.getElementById("media").textContent = `Media: ${media.toFixed(2)}`;
}

function limpiardatos(){
    asignatura.value = "";
    nota.value="";
}

function ValidarTodo() {
    if (validaarAsignaturaYNota()) {
        agregarAsignaturaYNota();
        mediaNotas();
        limpiardatos();
    }
}

document.getElementById("add-btn").addEventListener("click", ValidarTodo);
