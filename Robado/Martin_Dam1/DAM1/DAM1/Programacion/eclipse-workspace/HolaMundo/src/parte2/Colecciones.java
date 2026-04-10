package parte2;

import java.util.Collections;
import java.util.ArrayList;
public class Colecciones {

	public static void main(String[] args) {
		ArrayList<Integer> numeros= new ArrayList<>();
		ArrayList<String> alumnos = new ArrayList<>();
		
		Collections.addAll(numeros, 44, 56, 1, 2, 55, 7, 3, 3, 44, 2, 89, 120, 45, 6);
		Collections.addAll(alumnos, "Lucía", "Marcos", "Alejandro", "Sara");
		
		System.out.println(alumnos);
		System.out.println(numeros);
		
		Collections.sort(numeros);
		Collections.sort(alumnos);
		
		//Para que funcione esta wea, la coleccion debe de estar ordenada
		System.out.println();
		System.out.println("Posición: "+ Collections.binarySearch(numeros, 89));
		System.out.println();
		
		System.out.println(alumnos);
		System.out.println(numeros);
		
		Collections.shuffle(numeros);
		Collections.shuffle(alumnos);
		
		System.out.println(alumnos);
		System.out.println(numeros);
		
		Collections.reverse(numeros);
		Collections.reverse(alumnos);
		
		System.out.println(alumnos);
		System.out.println(numeros);
		
		// Esto no se puede System.out.println(Collections.reverse(alumnos));
		System.out.println(Collections.max(numeros)+" - "+Collections.min(numeros));
		System.out.println(Collections.max(alumnos)+" - "+Collections.min(alumnos));
		
		
		//Frecuency: el numero de veces que aparece el item en una lista
		
		System.out.println(Collections.frequency(numeros, 3));
		
		System.out.println();
		
		
	}

}
