const inputNombre = document.getElementById("guest-name");
const lista = document.getElementById("guest-list");
const errormensaje = document.getElementById("error-msg");
const addBtn = document.getElementById("add-btn");

addBtn.addEventListener("click", validar);

function comprobarNombre() {
    const nombre = inputNombre.value.trim();
    if (nombre.length < 3) {
        errormensaje.textContent = "El nombre debe tener al menos 3 caracteres";
        return false;
    }
    return true;
}

function nuevoelemento() {
    // ✅ Se crean DENTRO de la función, cada llamada crea elementos nuevos
    const crearelemento = document.createElement("li");
    const crearboton = document.createElement("button");

    crearelemento.textContent = inputNombre.value.trim();
    crearboton.textContent = "Eliminar";

    // ✅ El botón elimina su propio <li> padre
    crearboton.addEventListener("click", (e) => {
        e.target.parentElement.remove();
    });

    crearelemento.appendChild(crearboton);
    lista.appendChild(crearelemento);
}

function limpiarentrada() {
    inputNombre.value = "";
    errormensaje.textContent = "";
}

function validar() {
    if (comprobarNombre()) {
        nuevoelemento();
        limpiarentrada();
    }
}