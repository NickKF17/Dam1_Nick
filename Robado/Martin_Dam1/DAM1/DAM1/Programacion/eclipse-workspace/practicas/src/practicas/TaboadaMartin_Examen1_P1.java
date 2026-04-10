package practicas;

public class TaboadaMartin_Examen1_P1 {

	public static void main(String[] args) {
		String cadenaEjemplo = "12345-67891-12345-12345-12345";
		int tamañoCadena = cadenaEjemplo.length();
		int numClaves = 4;
		System.out.println("Generando claves en el formato solicitado: ");
		for (int j = 0; j < numClaves; j++) {
			for (int i = 0; i < tamañoCadena; i++) {
				int random = (int) (Math.random() * 10) + 1;

				if (cadenaEjemplo.charAt(i) != '-') {
					if (random == 10)
						System.out.print("0");
					else
						System.out.print(random);
				} else
					System.out.print("-");
			}
			System.out.println();
		}
		System.out.println("Fin del programa.");

	}

}
