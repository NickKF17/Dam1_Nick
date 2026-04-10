package defecto;
import java.util.Scanner;
public class EGP3_4 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String texto = teclado.next();
		String sinEspacios = "";
		int contador = 0;
		for(int i=0; i<texto.length(); i++) {
			if(texto.charAt(i) != ' ') {
				sinEspacios = sinEspacios + texto.charAt(i);
			}
			else
				contador++;
		}
			System.out.println("Cadena sin espacios: " + sinEspacios);
			System.out.println("Número de espacios eliminados: " + contador);
			teclado.close();
	}

}
