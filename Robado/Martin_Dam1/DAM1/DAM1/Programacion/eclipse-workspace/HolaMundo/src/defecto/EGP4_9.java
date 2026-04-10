package defecto;

import java.util.Scanner;

public class EGP4_9 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe un texto: ");
		String texto = teclado.nextLine();
		System.out.println("Escribe un caracter: ");
		String caracter = teclado.nextLine();
		//char caracter = temporal.charAt(0);
		teclado.close();
		int contador = 0;
		for(int i=0; i<texto.length(); i++)
			if(texto.charAt(i) == caracter.charAt(0))
				contador++;
		System.out.println("El caracter " + caracter + " aparece en " + contador + " ocasiones.");
		if (contador != 0) {
		System.out.print("Las posiciones en las que aparece son: ");
		String Posiciones = "";
		for(int i=0; i<texto.length(); i++) {
			if(texto.charAt(i) == caracter.charAt(0))
				Posiciones = Posiciones + i + ", ";
			}
		
		Posiciones = Posiciones.substring(0,Posiciones.length()-2);
		System.out.println(Posiciones);
		}

	}

}
