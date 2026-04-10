package practicas;

import java.util.Scanner;

public class TaboadaMartin_Examen1_P3 {

	public static void main(String[] args) {
		Scanner teclado =  new Scanner(System.in);
		int vector[] = new int [10];
		int contador = 0;
		System.out.print("Generando un array: ");
		for(int i=0; i<vector.length; i++) {
			vector [i]= (int)(Math.random()*50)+1;
			System.out.print(vector[i]);
			if (i<vector.length-1)
				System.out.print(", ");
		}
		System.out.print("\nPor favor, introduce un número del 1 al 50: ");
		int numero = teclado.nextInt();
		while(numero>50) {
			System.out.print("El número no está en el rango seleccionado, por favor vuelve a introducir un número entre el 1 y el 50: ");
			numero = teclado.nextInt();
		}
		for(int i= 0; i<vector.length; i++) {
			if (numero<vector[i])
				contador++;
		}
		System.out.println("En el array aparecen " + contador + " numeros mayores al " + numero +".");
		System.out.println("Fin del programa");
		teclado.close();


	}

}
