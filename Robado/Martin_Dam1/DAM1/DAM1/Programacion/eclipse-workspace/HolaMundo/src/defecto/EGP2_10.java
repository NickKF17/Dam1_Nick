package defecto;

import java.util.Scanner;

public class EGP2_10 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String num = "";
		int contador = 0;
		double med = 0;
		int numax = 0;
		int nummin= 100;
		do {
			System.out.println("Introduce un número entre el 1 y el 100 o FIN: ");
			num = teclado.nextLine();
			if(num.equals("FIN")==false) {
			int numero = Integer.parseInt(num);
			if(numero>=1 && numero<= 100) {
				contador++;
				med = med +numero;
				numax= Math.max(numax, numero);
				nummin = Math.min(nummin, numero);
			}
			}
		}while( num.equals("FIN")==false);
		System.out.println("Has metido " + contador + " números entre 1 y 100.");
		System.out.println("La media aritmética es de: " + (med/contador));
		System.out.println("El número mayor es: " + numax);
		System.out.println("El número menor es: " + nummin);
		teclado.close();

	}

}
