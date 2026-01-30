package defecto;

import java.util.Scanner;

public class kaprekar2 {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int entrada = 0;
		String numTxt = "";
		final int kaprekar = 6174;
		boolean todoCorrecto = false;
		int entrada1 = validarKaprekar();
		teclado.close();
		System.out.println("Pasos para obtener la constante de kaprekar a partir del número " + entrada1);
		int contador = 0;
		while (entrada1 != kaprekar) {
			contador++;
			int numDescendente = kaprekarDescendente(entrada1);
			int numAscendente = kaprekarAscendente(entrada1);
			entrada1 = numDescendente - numAscendente;
			numTxt = Integer.toString(entrada1);
			// Si el número resultante tiene menos de cuatro cifras
			for (int i = numTxt.length(); i < 4; i++)
				numTxt = "0" + numTxt;
			System.out.println(numDescendente + " - " + numAscendente + " = " + entrada1);
		}
		System.out.println("Constante de kaprekar obtenida con " + contador + " operaciones");
	}

	public static int kaprekarAscendente(int entrada) {
		
	}

	public static int kaprekarDescendente(int entrada) {
		
	}

	public static int validarKaprekar() {
		
	}

}
