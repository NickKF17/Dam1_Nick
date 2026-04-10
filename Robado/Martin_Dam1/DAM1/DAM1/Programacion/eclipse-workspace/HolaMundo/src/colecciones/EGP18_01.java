package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class EGP18_01 {

	public static void main(String[] args) {

		HashSet<Integer> conj1 = new HashSet<>(10);
		HashSet<Integer> conj2 = new HashSet<>(10);
		addNumPrim(conj1);
		addNumPrim(conj2);

		System.out.print("Conjunto 1: ");
		orderYShowConj(conj1);

		System.out.print("Conjunto 2: ");
		orderYShowConj(conj2);

		HashSet<Integer> union = new HashSet<>(conj1);
		HashSet<Integer> interseccion = new HashSet<>(conj2);
		union.addAll(conj2);
		interseccion.retainAll(conj1);

		System.out.print("Unión entre ellos: ");
		orderYShowConj(union);

		System.out.print("Intersección entre ellos: ");
		orderYShowConj(interseccion);

		HashSet<Integer> numPrim = createPrimos(1, 100);
		
		System.out.print("Los números primos que no han aparecido en los conjuntos son: ");
		numPrim.removeAll(union);
		orderYShowConj(numPrim);

	}

	public static HashSet<Integer> createPrimos(int n1, int n2) {
		HashSet<Integer> h = new HashSet<>();
		for (int j = n1; j < n2; j++) {
			if (isPrimo(j))
				h.add(j);
		}
		return h;
	}

	public static boolean isPrimo(int n) {
		boolean si = true;
		int raiz = (int) Math.sqrt(n) + 1;
		if (n % 2 == 0)
			si = false;
		for (int i = 3; i < raiz && si == true; i += 2)
			if (n % i == 0)
				si = false;
		return si;
	}

	public static void addNumPrim(HashSet h) {
		int j = 0;
		while (j < 10) {
			boolean si = false;
			int n = 0;
			while (si == false) {
				n = (int) (Math.random() * 100) + 1;
				si = isPrimo(n);
			}
			if (h.contains(n) == false) {
				h.add(n);
				j++;

			}
		}
	}

	// Esta funcion no la muestra ordenada
	public static void mostrarConj(HashSet<Integer> h) {
		Iterator<Integer> iterador = h.iterator();
		while (iterador.hasNext()) {
			System.out.print(iterador.next() + " ");
		}
		System.out.println();
	}

	public static void orderYShowConj(HashSet<Integer> h) {
		int[] vector = new int[h.size()];
		int i = 0;
		for (int n : h) {
			vector[i] = n;
			i++;
		}
		Arrays.sort(vector);
		i = 0;
		for (int n : vector) {
			System.out.print(n);
			if (i != vector.length - 1) {
				System.out.print(", ");
			}
			i++;
		}
		System.out.println();

	}
}
