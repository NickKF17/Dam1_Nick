package defecto;
import java.util.*;
public class EGP7_3 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Mesesinador version 1.0");

		System.out.println("Introduce un número del 1 al 12: ");

		int mesPosicion = validacion(teclado);

		teclado.close();

		String[] Meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",

				"Octubre", "Noviembre", "Diciembre" };

		System.out.println(Meses[mesPosicion]);

	}

	static int validacion(Scanner teclado) {

		boolean siVal = false;

		int numero = 0;

		while (siVal == false) {

			while (siVal == false) {

				siVal = true;

				try {

					numero = teclado.nextInt();

				} catch (Exception e) {

					System.out.println("Entrada incorrecta: Tiene que ser un número entero.\nVuelve a intentarlo: ");

					teclado.nextLine();

					siVal = false;

				}

			}

			if (numero <= 12 && numero >= 1)

				siVal = true;

			else {

				System.out.println(

						"Entrada incorrecta: El número tiene que estar comprendido entre el 1 y el 12\nVuelve a intentarlo: ");

				siVal = false;

			}

		}

		return (numero - 1);

	}

}
