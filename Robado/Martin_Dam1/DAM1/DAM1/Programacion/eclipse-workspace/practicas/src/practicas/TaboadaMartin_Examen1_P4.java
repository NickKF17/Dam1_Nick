package practicas;

public class TaboadaMartin_Examen1_P4 {

	public static void main(String[] args) {
		String texto1 = "toDrugs SayYes";
		String texto2 = "SayNo-toPizza";
		String textoN = "";
		System.out.println("Cadena1: " + texto1 + "\nCadena2: " + texto2);
		int posicionEspacio = texto1.indexOf(" ") + 1;
		int posicionGuion = texto2.indexOf("-");
		for (int i = posicionEspacio; i < texto1.length(); i++) {
			textoN += texto1.charAt(i);
		}
		for (int i = posicionGuion; i < texto2.length(); i++) {
			textoN += texto2.charAt(i);
			if (i == texto2.length() - 1)
				textoN += " ";

		}

		for (int i = 0; i < posicionEspacio; i++) {
			textoN += texto1.charAt(i);
			if (i == texto1.length() - 1)
				textoN += " ";

		}
		for (int i = 0; i < posicionGuion; i++) {
			textoN += texto2.charAt(i);

		}

		System.out.println("Resultado: " + textoN + "(" + textoN.length() + ")");
		System.out.println("Fin del programa");
	}

}
