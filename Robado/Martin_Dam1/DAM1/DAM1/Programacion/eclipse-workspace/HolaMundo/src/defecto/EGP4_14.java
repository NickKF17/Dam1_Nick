package defecto;

import java.util.Scanner;

public class EGP4_14 {

	public static void main(String[] args) {
		Scanner teclado =  new Scanner(System.in);
		String hora = teclado.nextLine();
		teclado.close();
		boolean correcto = true;
		int hhInt = Integer.parseInt(hora.substring(0,2));
		int mmInt = Integer.parseInt(hora.substring(3,5));
		do {
			
			hora = teclado.nextLine();
		}while (hora.charAt(2) != ':'&& hhInt>=0 && hhInt<=23 && mmInt>=0 && mmInt<=59)
		if (hora.charAt(2) == ':'&& hhInt>=0 && hhInt<=23 && mmInt>=0 && mmInt<=59)
			correcto = true;
		else
			correcto = false;
		if(correcto == true) {
			System.out.println("La hora " + hora + " está en un formato correcto.");
			if (hhInt>= 0 && hhInt<=5)
				System.out.println("Es de madrugada.");
			else if (hhInt>= 6 && hhInt<=1)
				System.out.println("Es de mañana.");
			else if (hhInt>= 12 && hhInt<=19)
				System.out.println("Es de tarde.");
			else
				System.out.println("Es de noche.");
		}
		else
			System.out.println("La hora " + hora + " está en un formato incorrecto.");
		
	}

}
