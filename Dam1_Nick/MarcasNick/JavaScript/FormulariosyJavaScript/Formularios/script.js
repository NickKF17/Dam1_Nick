document.getElementById("miFormulario").addEventListener("submit", function(e){
    e.preventDefault(); // Evita que el formulario se envíe

    let nombre = document.getElementById("nombre");
    let email = document.getElementById("email");
    let mensaje = document.getElementById("mensaje");

    let errorNombre = document.getElementById("errorNombre");
    let errorEmail = document.getElementById("errorEmail");
    let errorMensaje = document.getElementById("errorMensaje");

    let valido = true;

    // Resetear errores
    errorNombre.textContent = "";
    errorEmail.textContent = "";
    errorMensaje.textContent = "";
    nombre.classList.remove("error-input");
    email.classList.remove("error-input");
    mensaje.classList.remove("error-input");

    // Validación nombre
    if(nombre.value.trim() === ""){
        errorNombre.textContent = "El nombre es obligatorio.";
        nombre.classList.add("error-input");
        valido = false;
    } else if(nombre.value.length < 3){
        errorNombre.textContent = "Debe tener al menos 3 caracteres.";
        nombre.classList.add("error-input");
        valido = false;
    }

    // Validación email
    let patronEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email.value.trim() === ""){
        errorEmail.textContent = "El correo es obligatorio.";
        email.classList.add("error-input");
        valido = false;
    } else if(!patronEmail.test(email.value)){
        errorEmail.textContent = "Correo no válido.";
        email.classList.add("error-input");
        valido = false;
    }

    // Validación mensaje
    if(mensaje.value.trim() === ""){
        errorMensaje.textContent = "El mensaje no puede estar vacío.";
        mensaje.classList.add("error-input");
        valido = false;
    }

    // Si todo está bien
    if(valido){
        document.getElementById("resultado").textContent = 
            "Formulario enviado correctamente. ¡Gracias!";
        
        // Opcional: limpiar formulario
        nombre.value = "";
        email.value = "";
        mensaje.value = "";
    }
});
