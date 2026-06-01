const inventario = [
  { id: 1, nombre: "Teclado Mecánico", precio: 60, enStock: true },
  { id: 2, nombre: "Ratón Inalámbrico", precio: 25, enStock: false },
  { id: 3, nombre: "Monitor 24 pulgadas", precio: 150, enStock: true },
  { id: 4, nombre: "Alfombrilla", precio: 10, enStock: true }
];
//Recuerda que para acceder a un elemento específico de un objeto debes usar la sintaxis inventario["clave"].

let productosDisponibles= ""
let listadisponibles=[]
let precio_total=0
//Ejercicio1
for (const producto of inventario) {
  if(producto.enStock==true){
    productosDisponibles+=producto.id+","+producto.nombre+","+producto.precio+","+producto.enStock+"\n";
  }
}
console.log(productosDisponibles)

//Ejercicio2
for (const producto of inventario) {
  if(producto.enStock==true){
    listadisponibles.push(producto.nombre)
  }
}

console.log(listadisponibles);

//Ejercicio3


for (const producto of inventario) {
   if(producto.enStock==true){
  precio_total+=producto.precio
   }
}

console.log(precio_total);