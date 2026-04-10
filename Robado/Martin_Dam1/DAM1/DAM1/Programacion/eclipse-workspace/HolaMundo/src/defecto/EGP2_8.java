package defecto;
import java.util.Scanner;
public class EGP2_8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Tabladedivisionesinador versión 1.0");
		System.out.println("Por favor, introduce un número y a continuación se mostrarán los números por los cual es divisible: ");
		int num = teclado.nextInt();
		teclado.close();
		System.out.println("Cargando...");
		System.out.print("Divisiones del número " + num + ":");
		for (int i=1; i<=num; i++) {
			if(num%i== 0) {
				System.out.print(i);
				if (i<num)
					System.out.print(", ");
			}
		}
		System.out.println("Fin del programa.");
			

	}

}
