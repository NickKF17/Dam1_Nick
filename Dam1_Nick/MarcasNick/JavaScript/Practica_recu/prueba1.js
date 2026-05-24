let nombreTarea =document.getElementById("task-name");
let mensajeError = document.getElementById("error-msg");
document.getElementById("add-btn").addEventListener("click", validarYAgregarTarea);

function ValidarNombreTarea(){
    if(nombreTarea.value.length < 5){
        mensajeError.textContent = "El nombre de la tarea debe tener al menos 5 caracteres.";
    } else {
        mensajeError.textContent = "";
        return true;
    }
}

function agregarTarea(){
        let listaTareas = document.getElementById("task-list");
        let nuevaTarea = document.createElement("li");
        nuevaTarea.textContent = nombreTarea.value;
        listaTareas.appendChild(nuevaTarea);
        let checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        nuevaTarea.appendChild(checkbox);
        checkbox.addEventListener("change", function() {
            if (checkbox.checked) {
                nuevaTarea.style.textDecoration = "line-through";
            } else {
                nuevaTarea.style.textDecoration = "none";
            }
        }); 
        let botonEliminar = document.createElement("button");
        botonEliminar.textContent = "Eliminar";
        nuevaTarea.appendChild(botonEliminar);
        botonEliminar.addEventListener("click", function() {
            listaTareas.removeChild(nuevaTarea);
        });
}

function limpiarnombreTarea(){
    nombreTarea.value = "";
    mensajeError.textContent = "";
}

function validarYAgregarTarea(){
    if(ValidarNombreTarea()){
        agregarTarea();
        limpiarnombreTarea();
    }
}