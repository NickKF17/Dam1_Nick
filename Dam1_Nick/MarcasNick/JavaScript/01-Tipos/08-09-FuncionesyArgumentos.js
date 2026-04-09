function saludar(nombre) {
    return "Hola, " + nombre + "!";
}// Llamando a la función con un argumento
console.log(saludar("Nick")); // Output: Hola, Nick!

function sumar(a, b) {
    return a + b;
}// Llamando a la función con dos argumentos
console.log(sumar(5, 3)); // Output: 8

function multiplicar(a, b) {
    console.log("Argumentos adicionales:", arguments); // El objeto "arguments" contiene todos los argumentos pasados a la función, incluso aquellos que no están definidos como parámetros formales. En este caso, se mostrarán los argumentos adicionales (7, 8, 9) que se pasan al llamar a la función multiplicar.
    return a * b;
}// Llamando a la función con dos argumentos
console.log(multiplicar(4, 6,7,8,9)); // Output: 24