package defecto;
import java.util.Scanner;
public class EGP4_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num1 = 0;
		int num2 = 1;
		System.out.println("cuàntos nùmeros de la sucesión de fibonacci quieres?: ");
		int veces = teclado.nextInt();
		teclado.close();
		System.out.print("Los primeros " + veces + " números de la sucesión de fibonacci: ");
		if (veces>=1)
			System.out.print(0);
		if (veces>=2)
			System.out.print(", 1");
		for(int i=2; i<veces; i++) {
			int nuevoNumero = num1 + num2;
			System.out.print(", " + nuevoNumero);
			num1 = num2;
			num2 = nuevoNumero;
		}
 
	}

}
