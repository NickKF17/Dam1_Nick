package defecto;

import java.util.Arrays;
import java.util.Scanner;

public class EGP5_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[] num = new int[2];
		boolean todoCorrecto = false;
		while (todoCorrecto == false) {
			try {
				System.out.println("introduce un número: ");
				num[0] = teclado.nextInt();
				System.out.println("Introduce otro número: ");
				num[1] = teclado.nextInt();
				todoCorrecto = true;
			} catch (Exception e) {
				System.out.println("Ta mal we");
				teclado.nextLine();
			}
		}
		teclado.close();
		System.out.println("Los divisores comunes entre " + num[0] + " y " + num[1] + " son:");
		Arrays.sort(num);
		for (int i = 1; i <= num[0]; i++) {
			if (num[0] % i == 0 && num[1] % i == 0)
				System.out.println(i);
		}

	}

}
