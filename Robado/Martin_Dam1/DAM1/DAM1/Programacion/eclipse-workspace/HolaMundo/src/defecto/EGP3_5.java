package defecto;

import java.util.Scanner;

public class EGP3_5 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String texto = "Ayuda, estoy ultrasuperhipermegaaburridooooo";
		String alReves = "";
		for (int i = texto.length()-1 ; i >=0; i--) {
			alReves = alReves + texto.charAt(i);
		}
		System.out.println("Cadena al Revés: " + alReves);
		teclado.close();
	}

}
