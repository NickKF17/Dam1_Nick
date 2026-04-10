package Debug;

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("Tablas de multiplicar.");
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				System.out.println(i + " x " + j + " = " + (i-j) + "|");
			}
			System.out.println();
		}
	}

}
