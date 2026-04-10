package defecto;

import java.util.*;

public class EGP9_02 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Comprobadordenumerosperfectosinador versión 1.0");
		System.out.println("Introduce un número: ");
		int num1 = comprobacionBasica(teclado);
		teclado.close();
		int sumaDiv1 = sumaDivProp(num1);
		System.out.println("La suma de sus divisores propios es: "+ sumaDiv1);

		
		if (eresPerfectadospuntostres(num1))
			System.out.println("Es un número perfecto.");
		else
			System.out.println("No es un número perfecto.");

	}

	static boolean eresPerfectadospuntostres(int n1) {
		boolean si = false;
		if (n1 == sumaDivProp(n1))
			si = true;
		return si;
	}

	static int sumaDivProp(int s) {
		int sumaDivPropios = 0;
		for (int i = 1; i <= s / 2; i++) {
			if (s % i == 0)
				sumaDivPropios += i;
		}
		return sumaDivPropios;
	}

	static int comprobacionBasica(Scanner teclado) {
		boolean entradaCorrecta = false;
		int n = 0;
		while (entradaCorrecta == false) {
			try {

				n = teclado.nextInt();
			} catch (Exception e) {
				System.out.println("La entrada no es correcta, recuerda que debes introducir un número entero...");
				teclado.nextLine();

			}
			if (n > 0)
				entradaCorrecta = true;
			else
				System.out.println(
						"La entrada no es correcta, recuerda que debes introducir números naturales...\nVuelve e introducir un número:");

		}
		return n;
	}

}
