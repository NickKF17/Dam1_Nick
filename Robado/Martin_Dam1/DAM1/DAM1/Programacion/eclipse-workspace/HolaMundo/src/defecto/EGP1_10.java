
package defecto;


public class EGP1_10 {


	public static void main(String[] args) {
		int dado1;
		int dado2;
		dado1 = (int) (Math.random()*6)+1;
		dado2 = (int) (Math.random()*6)+1;
		System.out.println("lanzadordedosdadosinador versión 1.0");
		System.out.println("El primer dado muestra el número: " + dado1);
		System.out.println("El segundo dado muestra el número: "+ dado2);
		System.out.println("Fin del programa.");
	}

}
