package defecto;
import java.util.Scanner;
public class EGP2_7 {

	public static void main(String[] args) {
		Scanner teclado =  new Scanner(System.in);
		System.out.println("Tablademultiplicarinador versión 1.0");
		System.out.println("Introduce un número y te diré su tabla de multiplicar hasta el 10: ");
		int num = teclado.nextInt();
		int num2 = num;
		teclado.close();
		for (int i=1; i<= 10; i++) {
			System.out.println(num2 + " x " + i + " = " + num);
			num+=num2;
		}
		System.out.println("Fin del programa.");
		/*String numeroCadena = String.valueOf(num);
		String cadenaInvertida = "";
		for (int i=numeroCadena.length()-1; i>=0; i--) {
			cadenaInvertida = cadenaInvertida + numeroCadena.charAt(i);
		}
		System.out.println(cadenaInvertida);
		if (numeroCadena.equals(cadenaInvertida))
			System.out.println("El número es capicúa");
		else
			System.out.println("El número no es capicúa");*/

	}

}
