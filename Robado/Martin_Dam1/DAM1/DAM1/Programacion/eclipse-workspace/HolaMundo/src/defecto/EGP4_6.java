package defecto;

public class EGP4_6 {

	public static void main(String[] args) {
		int numero = 50;
		int anterior = 0;
		boolean gemelosEncontrados = false;
		while (gemelosEncontrados == false) {
			boolean esPrimo;
			do {
				int raiz = (int) (Math.sqrt(numero) + 1);
				esPrimo = true;
				for (int i = 2; i < raiz; i++)
					if (numero % i == 0)
						esPrimo = false;

				if (esPrimo == false)
					numero++;
			} while (esPrimo == false);
			if (numero - anterior == 2) {
				gemelosEncontrados = true;
			} else {
				anterior = numero;
				numero++;
			}

		}
		System.out.println("Los primeros numeros gemelos después del 50 son " + anterior + " y " + numero);
	}

}
