package defecto;
import java.util.Arrays;
import java.util.Scanner;
public class EGP2_9plus {

	public static void main(String[] args) {
		boolean hemosAcabado= false;
		Scanner teclado = new Scanner(System.in);
		String patronNumerico = "[0-9]+";
		int contador = 0;
		do{
			System.out.println("Introduce un número entre el 1 y el 100 o presiona FIN para salir: ");
			String entrada = teclado.nextLine();
			if(entrada.equals("FIN"))
				hemosAcabado = true;
			else if (entrada.matches(patronNumerico)== true) {
				int numero = Integer.parseInt(entrada);
				if (numero>=1 && numero <=100)
					contador++;
				System.out.println(entrada);}
			else
				System.out.println("Es otra cosa.");
		}while(hemosAcabado==false);
		System.out.println("Has introducido " + contador +" números válidos.");

	}

}
