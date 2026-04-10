package defecto;

import java.util.Scanner;

public class EGP1_13 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("ASISTENTEDEJUEGOCONNUMERODEDADOSATIRARYNUMERODECARASINADOR versión 3.0");
		System.out.println("¿Cuántos dados vas a tirar?: ");
		int numDados = lector.nextInt();
		System.out.println("¿Cuántas caras tienen tus dados?: ");
		int numCaras = lector.nextInt();
		while (numCaras%2 !=0) {
			System.out.println("Cabrón, un dado así no existe, vamos vuelve a decirme el número de caras del dado que quieras tirar: ");
			int numCaras2 = lector.nextInt();
			numCaras = numCaras2;
		}
		System.out.println("Vamos a tirar " + numDados + " dados de " + numCaras + " caras.");
		for(int i=0; i<numDados; i++) {
			int dado= (int)(Math.random()*numCaras)+1;
			System.out.println(dado);
		}
		System.out.println("Fin del programa");
		lector.close();

	}

}
