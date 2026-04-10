package defecto;
import java.util.Scanner;
public class EGP4_1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Factorial200inador versión 1.0");
		System.out.println("Por favor, introduce un número positivo que no supere el 63: ");
		int n = teclado.nextInt();
		/*int factorial = 1;
		for(int i=n; i>=1; i--) {
			factorial*= i;
		}*/
		long factorial = n;
		for(int i=n-1; i>=1; i--) {
			factorial*= i;
		}
		//el factorial solo llega a 16 si solo es int, si es long, entonces llega hasta 63
		System.out.println("Su factorial es: " + factorial);
		teclado.close();
	}

}
