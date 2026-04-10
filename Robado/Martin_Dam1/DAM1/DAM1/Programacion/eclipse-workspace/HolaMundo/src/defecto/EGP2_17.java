package defecto;

import java.util.Scanner;

public class EGP2_17 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Calculadordegradosinador versión 1.0");
		System.out.println(
				"Por favor, introduce la temperatura que quisieras transformar(se consideran correctos grados Farenheit, celsius o kelvin): ");
		String grados = teclado.nextLine();
		grados = grados.trim();
		String gradosnums = "";
		int unidadnum = grados.length() - 1;
		String unidad = "" + grados.charAt(unidadnum);
		while (unidad.equalsIgnoreCase("c") == false && unidad.equalsIgnoreCase("f") == false
				&& unidad.equalsIgnoreCase("k") == false) {
			System.out.println("Entrada incorrecta, por favor vuelve a introducir la temperatura:");
			grados = teclado.nextLine();
			grados = grados.trim();
			unidad = "" + grados.charAt(unidadnum);
		}

		for (int i = 0; i < grados.length() - 1; i++) {
			gradosnums = gradosnums + grados.charAt(i);
		}
		double gradosnum = Double.parseDouble(gradosnums);

		if (unidad.equalsIgnoreCase("c")) {
			double gradosf = ((double) 9 / 5 * gradosnum) + 32;
			double gradosk = gradosnum + 273;
			System.out.println("En grados Farenheit es: " + gradosf + "°F");
			System.out.println("En Kelvin es: " + gradosk + "K");
		} else if (unidad.equalsIgnoreCase("f")) {
			double gradosc = (gradosnum - 32) / 1.8;
			double gradosk = gradosc + 273;
			System.out.println("En grados Celsius es: " + gradosc + "°C");
			System.out.println("En Kelvin es: " + gradosk + "K");
		} else if (unidad.equalsIgnoreCase("k")) {
			double gradosc = gradosnum - 273;
			double gradosf = ((double) 9 / 5 * gradosc) + 32;
			System.out.println("En grados Celsius es: " + gradosc + "°C");
			System.out.println("En grados Farenheit es: " + gradosf + "°F");
		} 
		teclado.close();
	}

}
