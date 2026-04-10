package defecto;
import java.util.Scanner;
import java.util.regex.*;
public class EGP6_2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Validadordeteléfonosfijoinador versión 1.0");
		String fijo= validador(teclado);
		teclado.close();
		System.out.println(fijo);
	}
	static String validador(Scanner teclado) {
		boolean numeroCorrecto = false;
		String numero= "";
		Pattern patron = Pattern.compile("^[89]\\d{8}$");
		while(numeroCorrecto==false) {
			numero = teclado.nextLine();
			Matcher coincidencia = patron.matcher(numero);
			numeroCorrecto=coincidencia.matches();
			if(numeroCorrecto==false)
				System.out.println("Entrada invàlida.\nRecuerda que el número fijo comienza\npor 8 o 9 y son 9 cifras\nVuelve a intentarlo: ");

		}
		return numero;
			}
}
