package defecto;

import java.util.Scanner;

public class EGP3_1 {

	public static void main(String[] args) {
		boolean salir = false;
		Scanner teclado = new Scanner(System.in);
		while (salir==false) {
			System.out.println("Escribe tu contraseña: ");
			String pasword1 = teclado.nextLine();
			System.out.println("Confirma tu contraseña: ");
			String pasword2 = teclado.nextLine();
			if(pasword1.equals(pasword2)) {
				System.out.println("Las contraseñas coinciden.");
				salir = true;
			}
			else 
				System.out.println("Las contraseñas no coinciden");
			
		}
		teclado.close();

	}

}
