package poo2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.*;

public class Tarea {
	private String titulo;
	private String descripcion;
	private String color;
	private LocalDate fecha;
	boolean completada = false;

	private static ArrayList<Tarea> lista = new ArrayList<>();

	public Tarea(String titulo, String descripcion, String color) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.color = color;
		this.fecha = LocalDate.now();
		lista.add(this);
		// para cuando la lista era un arary y no una coleccion
		/*
		 * if(lista==null) { //inicializo la lista con un elemento y compio en el de la
		 * tarea lista = new Tarea[1]; lista[0]= this; }
		 * 
		 * else { //aumento en una posisicon la lista y copio en el de la tarea lista=
		 * Arrays.copyOf(lista, lista.length+1); lista[lista.length-1]=this;
		 * 
		 * }
		 */
	}

	public void mostrar() {
		System.out.println(titulo + "(" + color + ")");
		System.out.println(descripcion);
		System.out.println("Fecha: " + fecha + " - Completada: " + completada);
		System.out.println("------------------------------------------------");
	}

	public static void mostrarTareas() {
		Iterator<Tarea> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Tarea t = iterador.next();
			t.mostrar();
			}
		
		/*for (Tarea tarea : lista) {
		tarea.mostrar(); //otra forma de mostrar las tareas
		}*/
	}

	public static void mostrarCompletada() {
		for (Tarea tarea : lista) {
			if (tarea.completada == true)
				tarea.mostrar();
		}
	}

	public void completarTarea() {
		this.completada = true;
	}

	public void eliminarTarea() {
		//lista.remove(lista.indexOf(this));
		if(lista.remove(this)== false)
			System.err.println("No puedo eliminar la tarea, no esiste");
		
	}
}
