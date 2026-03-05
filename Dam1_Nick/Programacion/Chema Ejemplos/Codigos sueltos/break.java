import java.util.Random;

public class Main {

	public static void main(String[] args) {

		/* La instrucción break nos fuerza a salir del bloque que estamos ejecutando
		 * sin evaluar condiciones de salida ni nada de nada.
		 * Usar break para salir de un bucle es una mala práctica
		 * porque dificulta entender lo que hace el código. Veamos un ejemplo de lo 
		 * que no deberíamos de hacer jamas
		 */
		
		/*
		 * En este ejemplo (incorrecto) la condición de salida es true (no sale nunca)
		 * y cuando queremos salir forzamos con un break. Esta forma de programar
		 * dificulta que entendamos lo que hace el código. Siempre hay una forma de
		 * usar una condición de salida que haga el código mas claro.
		 */
		while(true){
			int dado = (int)(Math.random()*6)+1;
			System.out.println("Ha salido un " + dado);
			if(dado == 6)
				break;				
		}
		
		/*
		 * Este ejemplo hace exactamente lo mismo que el anterior pero no usa break
		 * y se entiende mucho mejor
		 */
		boolean terminado = false;
		while(terminado == false){
			int dado = (int)(Math.random()*6)+1;
			System.out.println("Ha salido un " + dado);
			if(dado == 6)
				terminado = true;				
		}
	}
}
