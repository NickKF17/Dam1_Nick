package def;

import java.util.Scanner;

public class Ejercicios19 {
	public static void main(String[] args) {


		Scanner teclado = new Scanner(System.in);
		
		float num1;
		int meses;
		
		
		System.out.println("¿Que cantidad tienes que pagar?");
		num1 = teclado.nextFloat();
		

		System.out.println("¿Durante cuantos meses?");
		meses=teclado.nextInt();
		


		
		float pagos=(float)(num1/meses);
		
		pagos= (float)Math.round(pagos*100/100);
		
		System.out.println("Tienes que pagar " + pagos + "$ durante " + meses + " meses ");
		
		teclado.close();
	}

}
