package defecto;
import java.util.Scanner;
public class EGP4_13 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un caracter: ");
		String caracter = teclado.nextLine();
		System.out.println("Introduce un número de repeticiones: ");
		int repeticiones = teclado.nextInt();
		teclado.close();
		String linea = "";
		for(int i=0; i<repeticiones; i++) {
			
				System.out.print(caracter);
			}
			System.out.println();
		}

	}

}
