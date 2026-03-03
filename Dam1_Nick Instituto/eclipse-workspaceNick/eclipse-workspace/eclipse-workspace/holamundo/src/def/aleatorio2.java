package def;

import java.util.Scanner;

public class aleatorio2 {

	public static void main(String[] args) {
		double azar = Math.random();
		Scanner teclado= new Scanner(System.in);
		int num1;
		int contador;

		System.out.println("Elige un numero");
		num1=teclado.nextInt();
		
		System.out.print("Los divisores de " + num1 + " son: ");
		
for (int i=1;num1%i<=num1;i++) {
	 if (num1%i ==0) {
         System.out.print(i + " ");
}
	}
	}
}
