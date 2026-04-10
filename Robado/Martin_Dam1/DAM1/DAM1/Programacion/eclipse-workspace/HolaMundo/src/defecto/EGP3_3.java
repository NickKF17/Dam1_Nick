package defecto;

import java.util.Scanner;

public class EGP3_3 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe tu o tus nombres: ");
		String nombre = teclado.nextLine();
		System.out.println("Escribe tus apellidos: ");
		String apellidos = teclado.nextLine();
		System.out.println(apellidos + ", " + nombre);
		teclado.close();
		System.out.println("Fin del prgrama.");

	}

}
