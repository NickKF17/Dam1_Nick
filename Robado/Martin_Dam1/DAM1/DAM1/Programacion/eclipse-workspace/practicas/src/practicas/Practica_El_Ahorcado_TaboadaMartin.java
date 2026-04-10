package practicas;

import java.util.Scanner;

public class Practica_El_Ahorcado_TaboadaMartin {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("JuegodelAhorcadoinador Versión 0.1");
		System.out.println("Por favor, introduce la frase que quieras que sea adivinada:");
		String frase = teclado.nextLine();
		System.out.println("Ahora introduce la letra que servirá de pista: ");
		String letra = teclado.nextLine();
		String cifrado = "";
		System.out.println(letra.charAt(0));
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ' || frase.charAt(i) == letra.charAt(0))
				cifrado = cifrado + frase.charAt(i);
			else
				cifrado = cifrado + "*";

		}
		System.out.println("El juego ha comenzado, el resultado es: ");
		System.out.println(cifrado);
		// Hasta aquí la primera parte
		int contador = 0;
		int contadorLetra = 0;
		boolean fraseTerminada = false;
		while(fraseTerminada==false) {
			int contadorAsteriscos=0;
			System.out.println("Introduce una letra: ");
			letra =  teclado.nextLine();
			contador++;
			String fraseNueva="";
			for(int i = 0; i<frase.length(); i++) {
				if(frase.charAt(i) == letra.charAt(0)) {
					fraseNueva = fraseNueva + frase.charAt(i);
					contadorLetra++;
				}
				else
					fraseNueva = fraseNueva + cifrado.charAt(i);
				cifrado = fraseNueva;
				System.out.println("La letra "+ letra + " aparece en " + contadorLetra + " ocasiones.");
				System.out.println("Resultado: "+cifrado);
				if (contadorAsteriscos==0) {
					fraseTerminada =true;
					System.out.println("Has necesitado " + contador + " intentos");
				}
			}
		}
		
		teclado.close();

	}

}
