package defecto;

public class EGP1_17 {

	public static void main(String[] args) {
		int fin=3;
		System.out.println("Quinelainador versión 1.0");
		for(int i=0; i<15; i++) {
			int quinela = (int) (Math.random()*fin)+1;
			if (quinela==3)
				System.out.println("x");
			else 
				System.out.println(quinela);

		}
		System.out.println("Fin del programa.");

	}

}
