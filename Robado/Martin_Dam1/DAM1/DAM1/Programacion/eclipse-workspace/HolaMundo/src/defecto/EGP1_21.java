package defecto;
import java.util.Scanner;
public class EGP1_21 {

	public static void main(String[] args) {
		Scanner Tecla = new Scanner(System.in);
		int num;
		boolean idk;
		System.out.println("Adivinadordeprimos2000inador versión 1.0");
		System.out.println("Por favor, introduce un número, a continuación te diré si es primo o no:");
		do {
			num= Tecla.nextInt();
			idk=true;
			int raiz = (int)Math.sqrt(num)+1;
			System.out.println("Probando el número" + num + "...");
			if (num%2 == 0)
				idk = false;
			for (int divisor=3; divisor<raiz && idk == true;  divisor+=2)
				if (num%divisor==0)
					idk = false;
		}while(idk==false);
		System.out.println("El número "+ num + " es primo");
		
	}


		

	}


