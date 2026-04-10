package defecto;

import java.util.Scanner;

public class EGP3_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int contador = 1;
		boolean coincidentes = false;
		while (coincidentes == false) {

			System.out.println("Introduzca su contraseña por favor: ");
			String clave = teclado.nextLine();
			System.out.println("Vuelva a introducir su contraseña por favor: ");
			String clave2 = teclado.nextLine();
			if (clave.equals(clave2)) {
				System.out.println("Las claves coinciden.");
				coincidentes = true;
			} else {
				System.out.println("Las claves no coinciden.");
				System.out.println("Vuelva a intentarlo.");
				contador++;
			}

		}
		System.out.println("Numeros de intentos: " + contador);
		teclado.close();

	}

}
