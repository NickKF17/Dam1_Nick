/**
 * 
 */
package defecto;

/**
 * 
 */
public class EGP1_11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int dado1;
		int dado2;
		int contador = 0;
		System.out.println("lanzadordedosdadoshastaquelosdosdenigualinador versión 1.1");
		System.out.println("Ahora mismo lanzaré el dado varias veces hasta que ambos salgan iguales!");
		do {
			dado1 = (int)(Math.random()*(6))+1;
			dado2= (int)(Math.random()*(6))+1;
			contador++;
			System.out.println("El primer dado muestra el número: " + dado1);
			System.out.println("El segundo dado muestra el número: "+ dado2);
			System.out.println(" ");
		}while(dado1!=dado2);
		System.out.print("Tuve que tirar los dados " + contador);
		if (contador ==1)
			System.out.println(" vez.");
		else
			System.out.println(" veces.");
		System.out.println("Fin del programa.");
		

	}

}
