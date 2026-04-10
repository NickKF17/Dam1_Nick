package defecto;

import java.util.Scanner;
import java.util.regex.*;

public class EGP6_1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("ValidadordecódigopostaldeMadridinador versión 1.0");
		System.out.print("Por favor, introduce tu código postal: ");
		String postal = validador(teclado);
		teclado.close();
		System.out.println(postal);

	}

	static String validador(Scanner teclado) {
		Pattern patron = Pattern.compile("^28\\d{3}");
		boolean codigoCorrecto = false;
		String numero = "";
		while (codigoCorrecto == false) {
			numero = teclado.nextLine();
			Matcher coincidencia = patron.matcher(numero);
			codigoCorrecto = coincidencia.matches();
			if (codigoCorrecto == false)
				System.out.print(
						"Entrada incorrecta, recuerda que la zona en la\nque estamos comienza con \"28\" y son 5 cifras\nVuelve a intentarlo: ");
		}
		return numero;

	}
}
