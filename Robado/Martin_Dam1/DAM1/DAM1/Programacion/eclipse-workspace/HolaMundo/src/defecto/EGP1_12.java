
package defecto;

import java.util.Scanner;
public class EGP1_12 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("ASISTENTEDEJUEGOCONNUMERODEDADOSATIRARYNUMERODECARASINADOR versión 1.0");
		System.out.println("¿Cuántos dados vas a tirar?: ");
		int numDados = lector.nextInt();
		System.out.println("¿Cuántas caras tienen tus dados?: ");
		int numCaras = lector.nextInt();
		System.out.println("Vamos a tirar " + numDados + " dados de " + numCaras + " caras.");
		for(int i=0; i<numDados; i++) {
			int dado= (int)(Math.random()*numCaras)+1;
			System.out.println(dado);
		}
		System.out.println("Fin del programa");
		lector.close();
	}

}
