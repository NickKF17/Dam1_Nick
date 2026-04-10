package practicas;

import java.util.Scanner;

public class Practica_El_ahorcado_TaboadaMartin_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("JuegodelAhorcadoinador Versión 0.1");
		System.out.println("Por favor, introduce la frase que quieras que sea adivinada:");
		String frase = teclado.nextLine();
		System.out.println("Ahora introduce la letra que servirá de pista: ");
		String letra = teclado.nextLine();
		String cifrado = "";
		String temp = "";
		System.out.println(letra.charAt(0));
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ' || frase.charAt(i) == letra.charAt(0))
				cifrado = cifrado + frase.charAt(i);
			else
				cifrado = cifrado + "*";

		}
		System.out.println("El juego ha comenzado, el resultado es: ");
		System.out.println(cifrado);
		boolean palabraAcertada= false;
		int contador = 0;
		while(palabraAcertada==false) {
			System.out.println("introduce una letra: ");
			letra = teclado.nextLine();
			for (int i = 0; i < frase.length(); i++) {
				temp = cifrado;
				cifrado = "";
				if (frase.charAt(i) == letra.charAt(0) && temp.charAt(i)=='*') {
					cifrado = cifrado + frase.charAt(i);
					contador++;
				}
				else if (frase.charAt(i) == ' ')
					cifrado = cifrado + frase.charAt(i);
				else if (temp.charAt(i) != '*')
					cifrado = cifrado+ temp.charAt(i); 
			

			}
			System.out.println(cifrado);
			System.out.println(temp);
			if (temp.equals(frase)== true) {
				palabraAcertada = true;
				System.out.println("Genial! Has ganado");
			}
		}
		System.out.println("Programa finalizado.");
		teclado.close();

	}

}
