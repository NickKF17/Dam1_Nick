package def;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList(List.of(7, 1, 3, 5, 4, 6, 14));
		// ArrayList<Integer> ordenada1 = ordenarPorSeleccion(numeros);
		// System.out.println(ordenada1);

		ArrayList<Integer> ordenada2 = ordenarPorBurbuja(numeros);
		System.out.println(ordenada2);
	}

	public static ArrayList<Integer> ordenarPorSeleccion(ArrayList<Integer> desordenada) {
		ArrayList<Integer> ordenada = new ArrayList<>();
		int mayor = -1;
		do {
			for (int n : desordenada) {
				if (n > mayor)
					mayor = n;
			}
			desordenada.remove((Integer) mayor);
			ordenada.add(mayor);
			mayor = -1;
		} while (desordenada.size() != 0);

		return ordenada;

	}

	public static ArrayList ordenarPorBurbuja(ArrayList numeros) {
		boolean cambio;
		int num1;
		int num2;
		do {
			cambio = false;
			for (int i = 0; i < numeros.size() - 1; i++) {
				num1 = (int) numeros.get(i);
				num2 = (int) numeros.get(i + 1);

				if (num1 < num2) {
					Collections.swap(numeros, numeros.indexOf(num1), numeros.indexOf(num2));
					cambio = true;
				}

			}
		} while (cambio == true);

		return numeros;
	}
}
