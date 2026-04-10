package poo2;

public class Main {

	public static void main(String[] args) {
		Tarea t1 = new Tarea("Aprender Java", "Estudiar POO para aprobar el segundo trimestre", "verde");
		Tarea t2= new Tarea("Stranger Things", "Ver la última temporada antes de que me frían los spoilers", "amarillo");
		Tarea t3 = new Tarea("Salir a hacer deporte","Hay que bajar ese roscón de reyes","rojo");
		
		t2.completarTarea();
		//t1.mostrar();
		//t2.mostrar();
		
		t2.eliminarTarea();
		t2.eliminarTarea();
		Tarea.mostrarTareas();
		//Tarea.mostrarCompletada();
	}

}
entidad bancaria tiene sucursales, cuentas corrientes, y clientes 