
package defecto;
import java.util.

public class HolaMundo {

	public static void main(String[] args) {
		System.out.println("Contadordenumerosdivisiblesentre0al100inador versión 0.1.0");

		for (int i = 3; i < 100; i += 3) {
			System.out.println(i);
		}
		System.out.println("Presione ENTER para terminar");
		
		System.out.println("No te creas, ahora vamos a mostrartelo de nuevo");
		for (int i=1; i<100; i++) {
			if(i%3==0) {
				System.out.println(i);
		}
	}
}
}