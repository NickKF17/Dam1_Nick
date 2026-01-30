package def;

import java.util.Scanner;
import java.util.Arrays;

		public class holay {

			public static void main(String[] args) {
	
		        Scanner teclado = new Scanner(System.in);

		        System.out.print("¿Cuántos números quieres ingresar?: ");
		        int cantidad = teclado.nextInt();

		        int[] numeros = new int[cantidad];
		        
		        System.out.println("Ingresa los numeros");
		        for (int i = 0; i < cantidad; i++) {
		            System.out.print("Número " + (i + 1) + ": ");
		            numeros[i] = teclado.nextInt();
		        }

		        Arrays.sort(numeros);

		        System.out.println("\nNúmeros ordenados de menor a mayor:");
		
		        for (int numero : numeros) {
		            System.out.print(numero + " ");
		        }

		        teclado.close();
		   
	}
	}
