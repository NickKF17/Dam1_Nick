package defecto;
import java.util.Scanner;
public class EGP4_10 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un texto con cifras y letras: ");
		String texto = teclado.nextLine();
		teclado.close();
		for(int i = 0; i<texto.length(); i++) {
			char caracter = texto.charAt(i);
			switch (caracter) {
			case '0', '1','2','3','4','5','6','7','8','9':
		
				System.out.print(caracter);
			
			}
		}

	}

}
