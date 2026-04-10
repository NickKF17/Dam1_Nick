package defecto;

import java.util.Scanner;

public class EGP2_6 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ponderadordenotas400inador versión 1.0");
		System.out.println("Por favor, introduce la nota correspondiente al trabajo en clase(representa un 5%): ");
		double num1 = teclado.nextDouble();
		System.out.println("Por favor, introduce la nota correspondiente a los trabajos prácticos(15%) ");
		double num2 = teclado.nextDouble();
		System.out.println("Por favor, introcuce la nota correspondiente al exámen(80%): ");
		double num3 = teclado.nextDouble();
		double ponderacion = (num1*0.05)+(num2*0.15)+(num3*0.8);
		double ponderacionr = (double) Math.round(ponderacion*100)/100;
		if (p
			
		double ponderacionsd = Math.round(ponderacion);
		System.out.println("La nota de boletín será: " + ponderacionsd);
		System.out.println("La nota real será: " + ponderacionr);
		teclado.close();


	}

}
