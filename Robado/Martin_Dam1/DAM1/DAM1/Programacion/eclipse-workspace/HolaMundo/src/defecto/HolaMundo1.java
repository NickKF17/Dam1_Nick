
package defecto;

public class HolaMundo {

	public static void main(String[] args) {
		double salario = 100000;
		double neto = 0;
		System.out.println("Programa de hacienda versión 0.1.0");
		System.out.println("Tu salario es de:");
		System.out.print(salario);
		System.out.println(" €");
		// System.out.println(curso);

		if (salario < 1000) {
			System.out.println("AJAJAJAJA, que pobre!!");
			System.out.println("No pagas impuestos");
			System.out.print("Fin del programa");
		}

		else if (salario > 10000) {
			System.out.println("Eres de clase alta");
			System.out.println("------------ Cargando... ------------");
			System.out.println("Tienes que pagar el 50% de impuestos");
			neto = salario - ((salario * 50) / 100);
			System.out.println("Por lo tanto, declarando a hacienda terminas cobrando:");
			System.out.print(neto);
			System.out.print(" €");
		}

		else {
			System.out.println("Eres de clase media");
			System.out.println("ya te vendrìa bien empezar a declarar a hacienda");
			System.out.println("------------ Cargando... ------------");
			System.out.println("Tienes que pagar el 10% de impuestos");
			neto = salario - salario * 0.1;
			System.out.println("Por lo tanto, declarando a hacienda terminas cobrando:");
			System.out.print(neto);
			System.out.print(" €");
		}

	}
}
