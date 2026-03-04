package def;
import java.util.*;
public class Colecciones {

	public static void main(String[] args) {
		
		ArrayList numeros = new ArrayList();
		ArrayList alumnos = new ArrayList();


		Collections.addAll(numeros, 44, 56, 1, 2, 55, 7, 3, 3, 44, 2, 89, 120, 45, 6);
		Collections.addAll(alumnos,"Lucía","Marcos", "Sara", "Alejandro");

		System.out.println(numeros);
		System.out.println(alumnos);

		Collections.sort(numeros); //De menor a mayor
		Collections.sort(alumnos);
		
		System.out.println(alumnos);
		System.out.println(numeros);

		Collections.shuffle(numeros); //ordena aleatoriamente
		Collections.shuffle(alumnos);

		System.out.println(numeros);
		System.out.println(alumnos);

		Collections.reverse(numeros);
		Collections.reverse(alumnos);

		System.out.println(numeros);
		System.out.println(alumnos);

		System.out.println(Collections.max(numeros) + " - " + Collections.min(numeros));
		System.out.println(Collections.max(alumnos) + " - " + Collections.min(alumnos));
		System.out.println(Collections.frequency(numeros, 3));
		System.out.println(Collections.frequency(numeros, 444));
		
		Collections.sort(numeros);
		System.out.println("Posicion: " + Collections.binarySearch(numeros, 3));
		}
	}

