package EGP23;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class EGP23_02 {
	public static void main(String[] args) {
		ArrayList<String> contenido = devolverContenido("/home/alumno/lapera");
		System.out.println(contenido);
		int contadorChar = 0;
		int contadorLineasB = 0;
		int contadorEsp = 0;
		
	}
	public static ArrayList<String> devolverContenido(String fich){
		ArrayList <String> ficherito = new ArrayList();
		Path f = Path.of(fich);
		try {
			ficherito = (ArrayList) Files.readAllLines(f);
		}catch(Exception e) {
			System.out.println("Error con el fichero:");
			System.out.println(e);
		}
		return ficherito;
	}
	
	
}
