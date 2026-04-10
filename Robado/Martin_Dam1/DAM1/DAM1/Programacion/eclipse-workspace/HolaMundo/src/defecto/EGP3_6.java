package defecto;

import java.util.Scanner;

public class EGP3_6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String texto = "Ayuda, estoy ultrasuperhipermegaaburridooooo";
		String Pares = "";
		String Impares = "";
		for (int i = 0; i <texto.length(); i++) {
			if(i%2==0)
				Pares+=texto.charAt(i);
			else
				Impares+=texto.charAt(i);
		}
		System.out.println("Cadena de posiciones pares:" + Pares);
		System.out.println("Cadena de posiciones impares: " + Impares);
		teclado.close();
	}

}
