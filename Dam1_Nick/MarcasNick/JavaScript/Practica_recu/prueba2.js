
// ✅ Guardas el elemento
let nombreProducto = document.getElementById("product-name");
let precioProducto = document.getElementById("product-price");

// Y luego dentro de las funciones usas .value cuando lo necesites

function validarNombreYPrecio() {
    
    if ( nombreProducto.value === '' ||parseFloat(precioProducto.value) <= 0) {
       document.getElementById("error-msg").textContent = "El nombre del producto no puede estar vacío y el precio no puede ser negativo.";
        return false;  
    } else {
        document.getElementById("error-msg").textContent = "";
        
        return true;
    } }

function agregarProducto() {
   // ✅
const nuevaLi = document.createElement("li");
nuevaLi.textContent = nombreProducto.value + " - " + parseFloat(precioProducto.value).toFixed(2) + "€";
document.getElementById("product-list").appendChild(nuevaLi);
    let eliminarBtn = document.createElement("button");
    eliminarBtn.textContent = "Eliminar";
    eliminarBtn.addEventListener("click", function() {
        this.parentElement.remove();
            sumasPrecios();
    });
    document.getElementById("product-list").lastChild.appendChild(eliminarBtn);
}

function sumasPrecios() {
    let productos = document.querySelectorAll("#product-list li");
    let total = 0;
    productos.forEach(function(producto) {
        let precio = parseFloat(producto.textContent.split(" - ")[1].replace("€", ""));
        total += precio;
    });
    document.getElementById("total").textContent = total.toFixed(2) + "€";
}

function limpiarCampos() {
    nombreProducto.value = "";
    precioProducto.value = "";
}
function ValidarYAgregar() {
    if (validarNombreYPrecio()) {
        agregarProducto();
        sumasPrecios();
        limpiarCampos();
    }
}

document.getElementById("add-btn").addEventListener("click", ValidarYAgregar);
