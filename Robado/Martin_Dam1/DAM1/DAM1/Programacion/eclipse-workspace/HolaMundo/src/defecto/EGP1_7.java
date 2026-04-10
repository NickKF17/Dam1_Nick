
package defecto;
import java.util.Scanner;
public class EGP1_7 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		double precio;
		System.out.println("Calculadordeivainador versión 0.1");
		System.out.println("Introduzca el importe del producto: ");
		precio = tec.nextDouble();
		double iva = 0.12;
		double precio2 = precio+precio*iva;
		System.out.println("El precio del producto más el Iva añadido es de " + precio2 + "€");
		System.out.println("Programa terminado.");
		tec.close();

	}

}
