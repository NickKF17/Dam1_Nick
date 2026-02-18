package defecto;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("E para euros, P para pesos cubanos, R para rupias y F para francos suizos");
		System.out.println("Ponga la cantidad a cambiar seguidad de la letra para el cambio:");
		String cantidad = teclado.nextLine();
		double aPesos = 27.93;
		double aRupias = 102.81;
		double aFrancos = 0.93;
		teclado.close();
		double euros;
		String cantidadSin = cantidad.replace("E","");
		double cantidadSinLetra = Double.parseDouble(cantidadSin);
			if(cantidad.matches("[0-9]+[E]")) {
				double pesos = cantidadSinLetra*aPesos;
					System.out.println("Equivalen a "+pesos+" pesos cubanos.");
				double rupias = cantidadSinLetra*aRupias;
					System.out.println("Equivalen a "+rupias+" rupias.");
				double francos = cantidadSinLetra*aFrancos;
						System.out.println("Equivalen a "+francos+" francos suizos.");
			}
			else if(cantidad.matches("[0-9]+[P]")) {
				euros = cantidadSinLetra/aPesos;
				System.out.println("Equivalen a "+euros+" euros.");
			}
			else if(cantidad.matches("[0-9]+[R]")) {
				euros = cantidadSinLetra/aRupias;
				System.out.println("Equivalen a "+euros+" euros.");
			}
			else if(cantidad.matches("[0-9]+[F]")) {
				euros = cantidadSinLetra/aFrancos;
				System.out.println("Equivalen a "+euros+" euros.");
			}

		

	}

}
