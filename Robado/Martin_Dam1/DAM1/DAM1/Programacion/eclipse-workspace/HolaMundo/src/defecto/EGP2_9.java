package defecto;
import java.util.Scanner;
public class EGP2_9 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String num = "";
		int contador = 0;
		do {
			System.out.println("Introduce un número entre el 1 y el 100 o FIN: ");
			num = teclado.nextLine();
			if(num.equals("FIN")==false) {
			int numero = Integer.parseInt(num);
			if(numero>=1 && numero<= 100)
				contador++;
			}
		}while( num.equals("FIN")==false);
		System.out.println("Has metido " + contador + " números entre 1 y 100.");
		teclado.close();

	}

}
