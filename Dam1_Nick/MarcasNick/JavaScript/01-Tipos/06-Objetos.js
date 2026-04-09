// Personaje de TV
let personaje = {
    nombre: "Tanjirou Kamado",
    edad: 16,
    profesion: "Cazador de demonios",
    anime: "Demon Slayer",
};

console.log(personaje);
console.log("Nombre:", personaje.nombre);
console.log("Edad:", personaje.edad);
console.log("Profesión:", personaje.profesion);
console.log("Anime:", personaje.anime);

// Accediendo a las propiedades del objeto utilizando la notación de corchetes
console.log("Nombre:", personaje["nombre"]);
console.log("Edad:", personaje["edad"]);
console.log("Profesión:", personaje["profesion"]);
console.log("Anime:", personaje["anime"]);

// Modificando las propiedades del objeto
personaje.edad = 17;
personaje.profesion = "Cazador de demonios y protector de su hermana";
console.log("Edad modificada:", personaje.edad);
console.log("Profesión modificada:", personaje.profesion);

//Modificando las propiedades del objeto utilizando la notación de corchetes
personaje["edad"] = 18;
personaje["profesion"] = "Cazador de demonios, protector de su hermana y líder del grupo";
console.log("Edad modificada con corchetes:", personaje["edad"]);
console.log("Profesión modificada con corchetes:", personaje["profesion"]);
// Agregando una nueva propiedad al objeto
personaje.hobby = "Cocinar";
console.log("Hobby agregado:", personaje.hobby);
// Agregando una nueva propiedad al objeto utilizando la notación de corchetes
personaje["hobby"] = "Cocinar y entrenar";
console.log("Hobby modificado con corchetes:", personaje["hobby"]);

// Eliminando una propiedad del objeto
delete personaje.hobby;
console.log("Hobby eliminado:", personaje.hobby);   
// Eliminando una propiedad del objeto utilizando la notación de corchetes
delete personaje["hobby"];
console.log("Hobby eliminado con corchetes:", personaje["hobby"]);