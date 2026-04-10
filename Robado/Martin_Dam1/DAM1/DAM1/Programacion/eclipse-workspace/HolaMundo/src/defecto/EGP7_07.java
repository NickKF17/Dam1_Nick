package defecto;

import java.util.*;

public class EGP7_07 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("De qué tamaños será tu array: ");
		try {
			int num = teclado.nextInt();
			int tabla[] = new int[num];
			for (int i = 0; i < num; i++) {
				tabla[i] = (int) ((Math.random() * (1000 - 9)) + 10);
			}
			for (int i = 0; i < num; i++)
				System.out.print(tabla[i] + " - ");
			System.out.println("Ahora dime la posición que quieras buscar:\n(del 0 al " + (num - 1) + ")");
			int pos = teclado.nextInt();
			if (pos >= 0 && pos < num)
				System.out.println("El número de la posición indicada es: \n" + tabla[pos]);
			else
				System.out.println("Esa posición no existe.");
		} catch (Exception e) {
			System.out.println("El número que has introucido no es un entero");
		} finally {
			teclado.close();
		}

	}

}
