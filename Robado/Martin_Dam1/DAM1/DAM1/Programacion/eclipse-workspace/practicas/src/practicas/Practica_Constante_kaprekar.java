package practicas;

import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practica_Constante_kaprekar {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Constantedekaprekarinador versión 1.0\n");
		boolean entradaCorrecta = true;
		int contador = 0;
		int numeroInt = 0;
		final int kaprekar = 6174;
		boolean intentoNuevo= true;
		do {
			System.out.println("Introduce un número de 4 cifras por favor: ");
		try {
			
			numeroInt = teclado.nextInt();
		} catch (Exception e) {
			entradaCorrecta = false;
			System.out.println("Eso no es un número entero");
			
		} finally {
			//teclado.close();
			teclado.nextLine();
		}
		if (entradaCorrecta == true) {
			String numero = String.valueOf(numeroInt);
			if (numero.length() != 4) {
				System.out.println("El número no tiene cuatro cifras exactamente.");
			} else {
				boolean hayDiferencias = false;
				for (int i = 0; i < numero.length(); i++) {
					if (numero.charAt(0) != numero.charAt(i))
						hayDiferencias = true;
				}
				if (hayDiferencias == false) {
					System.out.println("Todos los dígitos son iguales.");
				} else {
					if (numeroInt == kaprekar) {
						System.out.println("El número introducido es ya la constante de Kaprekar");
						
						
						
						
						
						
					} else {
						intentoNuevo =false;
						System.out.println("Para llegar a la constante de Kaprekar con el número " + numeroInt
								+ " se necesitan...");
						do {
							numero = String.valueOf(numeroInt);
							for(int i=numero.length(); i<4; i++) {
								numero= "0" + numero;
							}
							String numeroOrd = "";
							String numeroOrdReverse = "";
							int numeroIntOrd = 0;
							int numeroIntOrdRev = 0;
							String[] numeroarr = new String[numero.length()];
							Arrays.fill(numeroarr, "");
							for (int i = 0; i < numero.length(); i++) {
								numeroarr[i] += numero.charAt(i)-'0';
							}
							Arrays.sort(numeroarr);
							for (int j = 0; j < numeroarr.length; j++) {
								numeroOrd = numeroOrd+ numeroarr[j];
								numeroOrdReverse = numeroarr[j] + numeroOrdReverse;
							}
							System.out.println(numeroOrd);
							/*for (int k = numeroarr.length - 1; k >= 0; k--) {
								numeroOrdReverse += numeroarr[k];
							}*/
							System.out.println(numeroOrdReverse);
							System.out.print(numeroOrdReverse + " - " + numeroOrd + " = ");
							numeroIntOrd = Integer.parseInt(numeroOrd);
							numeroIntOrdRev = Integer.parseInt(numeroOrdReverse);
							numeroInt = numeroIntOrdRev - numeroIntOrd;
							System.out.println(numeroInt);
							contador++;
						} while (numeroInt != kaprekar);
						System.out.println("..." + contador + " operaciones.");
					}
				}
			}
		
		
		}
	}while(intentoNuevo ==true);
		
	}	
}
