package defecto;

public class Práctica_sub_2 {

	public static void main(String[] args) {
		int[] numeros = { 7, 13, 56, 77, 2, 56, 84 };
		for (int n : numeros)
			if (esPrimo(n) == true)
				System.out.println(n + " es primo");
			else
				System.out.println(n + " no es primo");
	}

	public static boolean esPrimo(int numero) {
		boolean primo = true;
		int raiz = (int)Math.sqrt(numero) + 1;
		if (numero % 2 != 0 || numero==2) {
			for (int i = 3; i < raiz && primo == true; i += 2)
				if (numero % i == 0)
					primo = false;
		}
		else
			primo =false;
			
			return primo;
		
	}

}
