package defecto;

public class EGP1_16 {

	public static void main(String[] args) {
		System.out.println("Lotoprimitivoinador versión 1.0");
		System.out.println("A continuación se dirán los números ganadores: ");
		int fin= 49;
		for(int i = 0; i<6; i++) {
			int loteria = (int) (Math.random()*fin)+1;
			System.out.println(loteria);
		}
		System.out.println("Fin del programa.");
	}

}
