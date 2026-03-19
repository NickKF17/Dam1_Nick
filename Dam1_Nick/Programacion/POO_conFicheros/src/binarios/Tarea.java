package binarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class Tarea implements Serializable{ // sin Serializable no puedes trabajar con esta clase en un fichero
	private String id;
	private String titulo;
	private int prioridad; // con private transient int no se recuperan(leen)los datos en un fichero, importante para cosas como contraseñas, ademas los estaticos tampoco se guardan
	private boolean completada;
	
	private static ArrayList<Tarea>listaTareas =new ArrayList<>();
	public Tarea(String id,String titulo,int prioridad,boolean completada){
		this.id=id;
		this.titulo=titulo;
		this.prioridad=prioridad;
		this.completada=completada;
		Tarea.listaTareas.add(this);
	}
	
	public static void leerFicheroTareas(String fichero) {
		try (BufferedReader lector=new BufferedReader(new FileReader(fichero))){
			String linea;
			while((linea=lector.readLine())!=null) {
				String [] lista =linea.split(":");
		boolean completado=true;
		if(lista[3].equals("0"))
			completado=false;
		new Tarea(lista[0],lista[1],Integer.parseInt(lista[2]),completado);
			}
			
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	public static void grabarFicheroTareas(String fichero) {
		try (PrintWriter pluma =new PrintWriter(fichero)){
			for(Tarea tarea:listaTareas){
					int completada=0;
			if(tarea.completada==true)
					completada=1;
			pluma.printf("%s:%s:%d:%d",tarea.id,tarea.titulo,tarea.prioridad,completada);
			pluma.println();
			}
		}catch(Exception e){
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public  void mostrarTarea() {
		String completada=" ";
if(this.completada==true)
	completada="X";
		System.out.printf("%s [%s] %s (Prioridad: %d)\n",completada,this.id,this.titulo,this.prioridad);
	}
	public  static void mostrarTareas() {
	for(Tarea tarea:Tarea.listaTareas)
		tarea.mostrarTarea();
	}
	public static void ordenarTareas() {
	ArrayList<Tarea>listaTareasCopia =new ArrayList<>();
	do {
		int mayor=-1;
	 for(Tarea tarea:listaTareas) {
		 if(tarea.prioridad>mayor)
			 mayor=tarea.prioridad;
			 
	 }
	 int posicion=0;
	 for(int i=0;i<listaTareas.size();i++) {
		 if(listaTareas.get(i).prioridad==mayor)
			 posicion=i;
	}
	 listaTareasCopia.add(listaTareas.get(posicion));
	 listaTareas.remove(posicion);
	}while(listaTareas.size()!=0);
			for(Tarea tareas:listaTareasCopia)
				tareas.mostrarTarea();
				
	}
}
