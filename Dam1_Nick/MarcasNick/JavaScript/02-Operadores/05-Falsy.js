//short-circuit

//Falsy values: false, 0, -0, 0n, "", null, undefined, NaN
console.log(false || "Hola"); // "Hola", porque false es un valor falsy, entonces se evalúa el segundo operando


//Otros ejemplos de short-circuit

let nombre = null;
let saludo = "Hola " + (nombre || "desconocido");   // "Hola desconocido", porque nombre es null, que es un valor falsy, entonces se evalúa el segundo operando
console.log(saludo);

//Ahora si nombre tiene un valor, por ejemplo "Nick", entonces el resultado sería diferente

nombre = "Nick";
saludo = "Hola " + (nombre || "desconocido");   // "Hola Nick", porque nombre es "Nick", que es un valor truthy, entonces se evalúa el primer operando y se devuelve su valor
console.log(saludo);

function fn1() {
    console.log("SOY FUNCION 1");
    return true;
}
function fn2() {
    console.log("SOY FUNCION 2");
    return false;
}
let x = fn1() && fn2(); // "SOY FUNCION 1" se imprime, pero "SOY FUNCION 2" no se imprime, porque el operador AND evalúa el primer operando y como es true, evalúa el segundo operando
console.log(x); // false, porque el resultado de la operación AND es false

let resultado = fn1() || fn2(); // "SOY FUNCION 1" se imprime, pero "SOY FUNCION 2" no se imprime, porque el operador OR evalúa el primer operando y como es true, no evalúa el segundo operando
console.log(resultado); // true, porque el resultado de la operación OR es true