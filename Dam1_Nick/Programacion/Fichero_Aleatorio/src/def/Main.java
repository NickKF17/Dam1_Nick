package def;

import java.io.RandomAccessFile;
import java.util.HashMap;

public class Main {
static final int TAMANYO_NOMBRE=20;
static final int TAMANYO_REGISTRO=(TAMANYO_NOMBRE *2 )+4;
	public static void main(String[] args) {
		String fichero ="agenda.dat";
		HashMap<String,Integer> agenda=new HashMap<>();
		agenda.put("Alejandro", 33);
		agenda.put("Luis", 24);
		agenda.put("Ana", 32);
		agenda.put("Elvira", 41);
		try {
		crearAgenda(fichero,agenda);
		leerRegistro(fichero,2);
		leerRegistro(fichero,4);
		modificarRegistro(fichero,2,"Ana Maria",33);
		leerRegistro(fichero,2);
		leerRegistro(fichero, 3);
		// nuevoRegistro(fichero,"José Antonio",56);
		leerRegistro(fichero,4);
		System.out.println();
		eliminarRegistro(fichero, 4);
		eliminarRegistro(fichero, 4);
		leerRegistro(fichero, 4);
		modificarRegistro(fichero, 4, "Elvira", 17);
		leerTodosLosRegistros(fichero);
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	public static void leerTodosLosRegistros(String fichero) throws Exception {
		try(RandomAccessFile raf = new RandomAccessFile(fichero,"r")){
			int numRegistros=(int)raf.length()/TAMANYO_REGISTRO;	
			
		for(int i =1;i<numRegistros;i++) {
			String nombre =leerNombre(raf);
		int edad = raf.readInt();
		if(nombre.charAt(0)!='*')
		System.out.printf("Registro: %d - Nombre: %s. Edad: %d\n",i,nombre,edad);
		}
	}
	}
	
	public static void nuevoRegistro(String fichero ,String nombre,int edad)throws Exception {
		try(RandomAccessFile raf=new RandomAccessFile(fichero,"rw")){
			raf.seek(raf.length());
			escribirNombre(raf, nombre);
			raf.writeInt(edad);
			System.out.println("Registro añadido correctamente");
			
		}
	}
	
	public static void crearAgenda(String fichero,HashMap<String,Integer> agenda) throws Exception{
		
		try(RandomAccessFile raf= new RandomAccessFile(fichero,"rw")){
		for(String nombre: agenda.keySet()) {
			int edad=agenda.get(nombre);
			escribirNombre(raf,nombre);
			raf.writeInt(edad);
		}
		System.out.println("Agenda creada, Tamaño: " + raf.length() + " Bytes");
		}
		
	}
	
	public static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception {
		char[] chars = new char[TAMANYO_NOMBRE];
		for(int i=0;i<TAMANYO_NOMBRE;i++) {
			if(i<nombre.length())
				chars[i]=nombre.charAt(i);
			else
				chars[i]=' ';
	}
	
	for(char c:chars)
		raf.writeChar(c);
}
	
	public static void leerRegistro(String fichero,int registro)throws Exception{
		try(RandomAccessFile raf = new RandomAccessFile(fichero,"r")){
			long posicion=TAMANYO_REGISTRO * (registro-1);
			
			if(posicion>=raf.length()) {
				System.out.println("El Registro "+ registro +" no existe");
				System.out.println("El registro mas alto es el "+ raf.length()/TAMANYO_REGISTRO);
				
			}
			else {
				raf.seek(posicion);
			}
			String nombre =leerNombre(raf);
			int edad = raf.readInt();
			if(nombre.charAt(0)!='*')
			System.out.printf("Registro: %d - Nombre: %s. Edad: %d\n",registro,nombre,edad);
		
		else
			System.out.println("El registro "+ registro+ " esta marcado para ser eliminado");
		}
			}
			
	public static String leerNombre(RandomAccessFile raf) throws Exception{
		String nombre="";
	for(int i=0;i<TAMANYO_NOMBRE;i++) {	
	char c = raf.readChar();
	nombre=nombre+c;
	}
		return nombre.trim();
	}
	public static void modificarRegistro(String fichero, int registro,String nombre, int edad) throws Exception {
		try(RandomAccessFile raf = new RandomAccessFile(fichero,"rw")){
			long posicion=TAMANYO_REGISTRO * (registro-1);
			
			if(posicion>=raf.length()) {
				System.out.println("El Registro "+ registro +" no existe");
				System.out.println("El registro mas alto es el "+ raf.length()/TAMANYO_REGISTRO);
				
			}
			else {
				raf.seek(posicion);
				if(raf.readChar()!='*') {
					raf.seek(posicion);
				escribirNombre(raf, nombre);
				raf.writeInt(edad);
				System.out.println("Registro " + registro + " modificado correctamente");
				}
				else
					System.out.println("No puedes modificar un registro que ha sido marcado como borrado");
			}
	}
	}
	
	public static void eliminarRegistro(String fichero,int posicionnatu) throws Exception{
		try(RandomAccessFile raf = new RandomAccessFile(fichero,"rw")){	
			long posicion=(posicionnatu-1)*TAMANYO_REGISTRO;
			if(posicion>=raf.length()) {
				System.out.println("El Registro "+ posicionnatu +" no existe");
				System.out.println("El registro mas alto es el "+ raf.length()/TAMANYO_REGISTRO);
				
			}
			else {
			
			raf.seek(posicion);
			if(raf.readChar()=='*') {
					System.out.println("El registro "+posicionnatu+" ya esta borrado");
			}else {
				raf.seek(posicion);
			raf.writeChar('*');
			}
			}}}}
