

package defecto;
import java.util.Scanner;


public class EGP1_8 {


	public static void main(String[] args) {
		Scanner precio;
		Scanner meses;
		precio = new Scanner(System.in);
		meses = new Scanner(System.in);
		float p;
		int m;
		System.out.println("Diferidoramesesinador versión 0.1");
		System.out.println("Introduzca el precio que desea diferir:");
		p = precio.nextFloat();
		System.out.println("Ahora introduzca el número de meses por los cuales quiera diferir su compra(inserte números enteros):");
		m = meses.nextInt();
		float preciodif = p/m;
		System.out.println("El importe que tiene que pagar todos los meses será de " + preciodif + " €");
		System.out.println("Fin del programa");
		precio.close();
		meses.close();

	}

}
