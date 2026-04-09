let accion = 'listar';

switch (accion) {   
    case 'listar':
        console.log('Listando elementos...');
        break;
    case 'agregar':
        console.log('Agregando elemento...');
        break;
    case 'eliminar':
        console.log('Eliminando elemento...');
        break;
    default:
        console.log('Acción no reconocida.');
}