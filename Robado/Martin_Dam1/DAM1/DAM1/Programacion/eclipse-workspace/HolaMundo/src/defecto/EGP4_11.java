package defecto;
import java.util.Scanner;
public class EGP4_11 {

	public static void main(String[] args) {
		Scanner teclado =  new Scanner(System.in);
		String texto = teclado.nextLine();
		teclado.close();
		String textoPares= "" + texto.charAt(0);
		for(int posicion=1; posicion<texto.length(); posicion++) {
			textoPares = textoPares + "-"+texto.charAt(posicion);
		}
		textoPares = textoPares.replace("- -", " ");
		System.out.println(textoPares);

	}

}
