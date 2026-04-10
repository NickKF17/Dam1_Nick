
package defecto;
import java.util.Scanner;
public class EGP1_5 {


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Tediresiesparoimparinador versión 0.1");
		System.out.println("Weeeee, dame un número y te digo si es par o no");
		int numero;
		numero = kb.nextInt();
		if (numero%2==0) {
			System.out.println("El el número que me dijiste es par papá.");
		}
		else
			System.out.println("El número que me dijiste no es par papá, o sea es impar pues.");
		
		System.out.println("Fin del programa");
	}

}
