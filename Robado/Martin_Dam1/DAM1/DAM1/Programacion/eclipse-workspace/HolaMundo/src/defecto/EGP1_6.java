package defecto;
import java.util.Scanner;
public class EGP1_6 {


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Esdivisibleparatresinador versión 0.1");
		System.out.println("Mi estimado, le pido de la manera más encarecida posible que escriba un número, a continuación le diré si es divisible para tres o no");
		int numero;
		numero = kb.nextInt();
		if (numero%3==0) {
			System.out.println("El el número que ha escrito es divisible para tres.");
		}
		else
			System.out.println("El número que ha escrito no es divisible para tres.");
		
		System.out.println("Fin del programa");
	}

}
