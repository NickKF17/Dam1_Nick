package defecto;
import  java.util.Scanner;
public class EGP2_3 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Calculadordeivainador versión 1.0");
		System.out.println("Por favor, introduzca el importe a calcular");
		final double presio = teclado.nextDouble();
		
		double presioiv = (double) Math.round((presio*1.21)*100)/100;
		System.out.println("El precio mas el iva del 21% añadido es de: " + presioiv + "€");
		teclado.close();

	}

}
