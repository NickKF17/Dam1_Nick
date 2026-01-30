package defecto;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		String[] vector = new String[10];
		for(int i=0;i<10;i++) {
		int dado = (int)(Math.random()*50)+1;
		String texto = String.valueOf(dado);
		vector[i] = vector[i]+texto;
		vector[i] = vector[i].replace("null","");
		}
		String vectorDado = Arrays.toString(vector);
		vectorDado.replace("[","");
		vectorDado.replace("]","");
		System.out.println(vectorDado);
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un número entre el 1 y el 50:");
		int numero = teclado.nextInt();
		teclado.close();
		int contador=0;
	
		for(int i=vectorDado.length()-1;i>0;i--) {
			String numeroDado = vector[i];
			int numeroInt = Integer.parseInt(numeroDado);
			if(numeroInt>numero) {
				contador++;
			}
		}
		System.out.println("En el array hay "+contador+" números mayores a "+numero+".");
		

	}

}
