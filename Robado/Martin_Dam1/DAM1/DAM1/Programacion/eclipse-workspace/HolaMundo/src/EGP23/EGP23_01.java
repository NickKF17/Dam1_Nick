package EGP23;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class EGP23_01 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		/*System.out.println("Escribe el nombre del fichero:");
		String nombreFichero = teclado.nextLine();
		while(existeElFichero(nombreFichero)==false) {
			System.out.printf("El fichero %s no existe, vuelce a escribir el nombre del fichero:", nombreFichero);
			nombreFichero = teclado.nextLine();*/
		boolean existe = false;
		String nombreFichero = null;
		while(existe==false) {
			System.out.println("Escribe el nombre del fichero: ");
			nombreFichero = teclado.nextLine();
			existe= existeElFichero(nombreFichero);
			if(existe == false)
				System.out.printf("Error: fichero %s no encontrado\n", nombreFichero);
		}
		ArrayList<String>ficherito = devuelveContenido(nombreFichero);
		if(ficherito !=null ) {
			System.out.println(ficherito);
			
			System.out.println("Escibe que palabra quieres buscar: ");
			String palabra = teclado.nextLine();
			teclado.close();
			System.out.printf("El fichero tiene %d líneas\n", ficherito.size());
			int contador = 0;
			for(String linea: ficherito)
				contador+= cuentaPalabras(linea, palabra);
			System.out.printf("La palabra %s aparace %d veces", palabra, contador);
		}
		else {
			System.out.println("El fichero está vacío o ha ocurrido un error al leerlo");
			}
		//Primero pedimos por teclado el nombre del fichero
		//HAcemos un método que nos diga sie l fichero existe o no
		//Si no existe, volvemos a pedir un nombre de fichero
		// Una vezz que tenemos un fichero válido, hacemos otra función que nos devuelva
		// un ArrayList con su contenido
		// HAcemos una funcion que nos devuelva cuantas veces aparece una palabra en una liena de texto
		// y la ejecutamos para cada línea del ArrayList
		// no olvidar ir acumulando resultados en un contador

	}
	
	public static boolean existeElFichero(String fichero) {
		File f = new File(fichero);
		return (f.exists());
	}
	
	
	public static ArrayList<String> devuelveContenido(String fich){
		ArrayList<String> ficherito = new ArrayList<>();
		Path fichero = Path.of(fich);
		try {
			ficherito = (ArrayList<String>) Files.readAllLines(fichero);
		}catch (Exception e) {
			System.out.println("Error con el fichero:");
			System.out.println(e);
		}
		return ficherito;
	}
	
	public static int cuentaPalabras(String linea, String palabra){
		int contador = 0;
		String[] palabras = linea.split("\\s+");
		for(String p:palabras)
			if(palabra.equalsIgnoreCase(p))
					contador++;
			
		/*String palabraC = "";
		for(int i=0; i<linea.length(); i++) {
			if (linea.charAt(i)!= ' ' || linea.charAt(i)!= '.' || linea.charAt(i)!=':') {
				palabraC+= linea.charAt(i);
			}
			else {
				if (palabraC.equals(palabra))
					contador++;
				palabraC="";
			}
				
		}*/
		
		return contador;
	}

}
