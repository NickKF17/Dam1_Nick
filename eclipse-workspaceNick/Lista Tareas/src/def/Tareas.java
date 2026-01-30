
package def;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Tareas {
	private String titulo;
	private String descripción;
	private String color;
	private LocalDate fecha;
	boolean completada=false;
	
	private static ArrayList <Tareas> lista= new ArrayList<>();
	public Tareas(String titulo,String descripcion,String color){
		this.titulo=titulo;
		this.descripción=descripcion;
		this.color=color;
		this.fecha=LocalDate.now();
		lista.add(this);
	}
	public void mostrar() {
		System.out.println(this.titulo+"("+this.color+")");
		System.out.println(this.descripción);
		System.out.println("Fecha: "+this.fecha+" - Completada: "+ this.completada);
		System.out.println("--------------------------------------");
		
	}
	
	
	public void mostrartitulo() {
		System.out.println(this.titulo+"("+this.color+")");
	}
 public static void mostrartodootraforma() {
	 Iterator<Tareas> iterador= lista.iterator();
	 while(iterador.hasNext()) {
		 Tareas t= iterador.next();
		 t.mostrar();
	 }
	 
 }	
	
	public static void mostrartodo() {
		for(Tareas tarea: lista) { 
tarea.mostrar();
		}
		}
	public static void mostrartitulotodo() {
		for(Tareas tarea: lista) { 
tarea.mostrartitulo();
		}
		}
	public void completar(){
		completada=true;

	}
	
	public void nocompletar(){
		completada=false;

	}
	public static void mostrarnocompletadas(){
		for(Tareas tarea: lista) { 
		if (tarea.completada ==false)
			tarea.mostrar();
		}
	}
		public static void mostrarcompletadas(){
			for(Tareas tarea: lista) { 
			if (tarea.completada ==true)
				tarea.mostrar();
			}
	}
		
		public static void mostrartitulonocompletadas(){
			for(Tareas tarea: lista) { 
			if (tarea.completada ==false)
				tarea.mostrartitulo();
			}
		}
			public static void mostrartitulocompletadas(){
				for(Tareas tarea: lista) { 
				if (tarea.completada ==true)
					tarea.mostrartitulo();
				}
		}
		public void borrartarea(){
			if (lista.remove(this) ==false)		
		System.err.println("No puedo eliminar una tarea que no existe");
		}
}
