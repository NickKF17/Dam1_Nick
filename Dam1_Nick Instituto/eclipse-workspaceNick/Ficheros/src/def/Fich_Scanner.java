package def;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Fich_Scanner {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		/*System.out.println("Escribe el nombre del fichero:");
		String nombreFichero = teclado.nextLine();
		while(existeElFichero(nombreFichero)==false) {
			System.out.printf("El fichero %s no existe, vuelce a escribir el nombre del fichero:", nombreFichero);
			nombreFichero = teclado.nextLine();*/
		boolean existe = false;
		String nombreFichero=null;
		while(existe==false) {
			System.out.println("Escribe el nombre del fichero: ");
			nombreFichero = teclado.nextLine();
			existe= existeElFichero(nombreFichero);
			if(existe == false)
				System.out.println("Error: fichero no encontrado");
		}
		//Primero pedimos por teclado el nombre del fichero
		//HAcemos un método que nos diga sie l fichero existe o no
		//Si no existe, volvemos a pedir un nombre de fichero
		// Una vezz que tenemos un fichero válido, hacemos otra función que nos devuelva
		
		ArrayList<String> lineas= devuelveContenido(nombreFichero);
		if (lineas!=null) {
			System.out.println(lineas);
			
			System.out.println("Escribe la palabra a buscar: ");
			String palabra = teclado.nextLine();
			
			System.out.println("El fichero tiene "+ lineas.size()+" lineas");
			
			int contador=0;
			for(String linea :lineas)
				contador +=cuentaPalabras(linea,palabra);
			
			System.out.println("La palabra "+palabra+" aparece en "+contador+" ocasiones");
		}else
			System.out.println("El fichero esta vacio o ha ocurrido un error al leerlo");
		// un ArrayList con su contenido
		// HAcemos una funcion que nos devuelva cuantas veces aparece una palabra en una liena de texto
		// y la ejecutamos para cada línea del ArrayList
		// no olvidar ir acumulando resultados en un contador

	}
	
	private static int cuentaPalabras( String linea , String palabra) {
		String [] palabras=linea.split("\\s+");
		int contador=0;
		for(String p:palabras)
			if(palabra.equalsIgnoreCase(p))
				contador++;
				return contador;
	}

	public static boolean existeElFichero(String fichero) {
		File f = new File(fichero);
		return (f.exists());
	}
	public static ArrayList<String> devuelveContenido(String fichero){
		
		
		
		ArrayList<String> lineas = null;
	
Path f =Path.of(fichero);	
try {
	lineas=(ArrayList<String>)Files.readAllLines(f);
}catch(Exception e){
	System.out.println("Error con el fichero "+ fichero);
	System.out.println(e.getMessage());
}
return lineas;
	}
	
	public static int contador(){
		return 1;
	}

}