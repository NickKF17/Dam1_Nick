package def;

public class Main {

	public static void main(String[] args) {
String nombreFichero="tareas.txt";
Tarea.leerFicheroTareas(nombreFichero);
	//Tarea.mostrarTareas();
	Tarea.grabarFicheroTareas(nombreFichero);
	Tarea.ordenarTareas();
	Tarea.mostrarTareas();
	}

}
