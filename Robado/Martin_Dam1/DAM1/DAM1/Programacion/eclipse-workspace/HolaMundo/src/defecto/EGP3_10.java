package defecto;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EGP3_10 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Pattern Juan = Pattern.compile("^\\d{8}([A-Z]||[a-z])$");
		boolean DNICorrecto = false;
		System.out.println("ValidadordeDNIsinador versión 1.0");
		while (DNICorrecto == false) {
			System.out.println("Por favor Introduce tu DNI: \n(Recuerda que la letra debe ser escrita en mayúscula)");
			String DNI = teclado.nextLine();
			Matcher coincidencia = Juan.matcher(DNI);
			boolean si = coincidencia.matches();
			System.out.println(si);
			if (coincidencia.matches() == true) {
				System.out.println("DNI válido");
				DNICorrecto = true;

			} else {
				
				System.out.println("DNI incorrecto, vuelve a intentar");
			}

		}
		teclado.close();
		System.out.println("Fin del programa.");

	}

}
