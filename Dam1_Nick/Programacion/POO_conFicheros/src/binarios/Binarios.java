package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Binarios {
public static void main(String[] args) {
	String fichero ="/home/alumno/Dam_Nick/Dam1_Nick/Programacion/POO_conFicheros/binario.dat";
	String ficheroTarea ="/home/alumno/Dam_Nick/Dam1_Nick/Programacion/POO_conFicheros/binarioTarea.dat";
	//escribirFicheroBinario(fichero);
	// leerFicheroBinario(fichero);
	Tarea t1=new Tarea("E34","Aprender a grabar objetos con java",10,false);
	grabarTarea(t1,ficheroTarea);
	/*
	Tarea trecuperada=leerTarea(ficheroTarea);
	if(trecuperada!=null)
		trecuperada.mostrarTarea();
	*/
	Tarea t2=new Tarea("Y67","Salir a jugar futbol",10,false);
	Tarea t3=new Tarea("N07","Duolingo activar racha",10,false);
	Tarea t4=new Tarea("Y45","Boda",10,false);
	Tarea t5=new Tarea("K17","La protagonista",10,true);
	Tarea t6=new Tarea("M72","Muy rica tambien",10,false);
	ArrayList<Tarea> lista=new ArrayList <>(List.of(t1,t2,t3,t4,t5,t6));
	grabarLista(lista, ficheroTarea);
	
	
	ArrayList<Tarea> listaRecuperada=leerLista(ficheroTarea);
	grabarLista(lista, ficheroTarea);
	Tarea tnuevo=new Tarea("V55","Planificar Vacas",10,false);
	listaRecuperada.add(tnuevo);
	grabarLista(listaRecuperada,fichero);
	
	ArrayList<Tarea> listaRecuperadaNueva=leerLista(ficheroTarea);
	for(Tarea tarea:listaRecuperadaNueva) {
		tarea.mostrarTarea();
	}
	}
	
	public static ArrayList<Tarea> leerLista(String fichero) {
		ArrayList<Tarea> lista=null;
		try(ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))){
			lista=(ArrayList <Tarea>) binario.readObject();
			}catch(Exception e){
				System.out.println("Error: " +e.getMessage());
				
			}
		
		return lista;
	}

public static Tarea leerTarea(String fichero) {
	Tarea tarea=null;
	try(ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))){
		tarea=(Tarea) binario.readObject();
		}catch(Exception e){
			System.out.println("Error: " +e.getMessage());
			
		}
	
	return tarea;
}

public static void grabarLista(ArrayList<Tarea>lista,String fichero) { //Escribir fichero con clases creadas
try(ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))){
	binario.writeObject(lista);
	
	}catch(Exception e){
		System.out.println("Error: " +e.getMessage());
		
	}
}

public static void leerFicheroBinario(String fichero) {
try(DataInputStream binario = new DataInputStream(new FileInputStream(fichero))){
		
	System.out.println(binario.readInt());	
	System.out.println(binario.readDouble());
	System.out.println(binario.readBoolean());
	System.out.println(binario.readChar());
	System.out.println(binario.readUTF());
	
	}catch(Exception e){
		System.out.println("Error: " +e.getMessage());
		
	}
}
public static void grabarTarea(Tarea tarea,String fichero) { //Escribir fichero con clases creadas
try(ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))){
	binario.writeObject(tarea);
	
	}catch(Exception e){
		System.out.println("Error: " +e.getMessage());
		
	}
}
public static void escribirFicheroBinario(String fichero) {
try(DataOutputStream binario = new DataOutputStream(new FileOutputStream(fichero))){ //Escribir fichero normal
		
		binario.writeInt(3456);
		binario.writeDouble(3.1415935);
		binario.writeBoolean(false);
		binario.writeChar('X');
		binario.writeUTF("Hola mundo binario");
		
	}catch(Exception e){
		System.out.println("Error: " +e.getMessage());
		
	}
}
}
