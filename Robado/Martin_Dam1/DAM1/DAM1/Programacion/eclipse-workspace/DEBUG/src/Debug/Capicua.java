package Debug;

import java.util.Scanner;

public class Capicua {

	public static void main(String[] args) {
		int N, aux, inverso = 0, cifra;
		
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.println("Introduce un numero >= 10");
			N = teclado.nextInt();
		}while(N < 10);
		
		aux = N;
		while (aux != 0) {
			cifra = aux % 10;
			inverso = inverso * 10 + cifra;
			aux = aux / 10;
		}
		
		if (N == inverso) {
			System.out.println("Es capicua.");
		}else {
			System.out.println("No es capicua.");
		}
		
		teclado.close();
	}

}
