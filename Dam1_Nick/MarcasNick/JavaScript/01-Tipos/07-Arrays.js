let animales = ["Perro", "Gato", "Pájaro", "Pez"];

console.log(animales);
console.log(animales[0]); // Acceder al primer elemento del array
animales[4] = "Hamster"; // Agregar un nuevo elemento al array
console.log(animales);
animales.push("Conejo"); // Agregar un nuevo elemento al final del array
console.log(animales);
animales.pop(); // Eliminar el último elemento del array
console.log(animales);
console.log(animales.length); // Obtener la longitud del array
//Si asignas un valor de 10 cuando el array tiene una longitud de 5, el array se expandirá para acomodar el nuevo índice, y los índices intermedios (5 a 9) se llenarán con valores "undefined". Esto se debe a que JavaScript permite que los arrays sean dinámicos y no requieren una longitud fija. Sin embargo, es importante tener en cuenta que esto puede llevar a un uso ineficiente de la memoria si se asignan índices muy altos sin necesidad.
animales[10] = "Tortuga";
console.log(animales);
console.log(animales[5]); // Acceder a un índice que no ha sido asignado devuelve "undefined"