let user= {
    nombre: "Damian",
    edad: 30,
    ciudad: "Buenos Aires"
};

for (let propiedad in user) {
    console.log(propiedad + ": " + user[propiedad]);
}// El bucle for...in itera sobre las propiedades enumerables de un objeto, en este caso el objeto user. En cada iteración, la variable propiedad toma el nombre de una propiedad del objeto, y se puede acceder a su valor utilizando user[propiedad].
