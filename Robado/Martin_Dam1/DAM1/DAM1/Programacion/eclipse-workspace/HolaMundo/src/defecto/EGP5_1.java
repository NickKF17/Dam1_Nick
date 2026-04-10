package defecto;

import java.util.Arrays;

public class EGP5_1 {

	public static void main(String[] args) {
		System.out.println("Loteríaprimitivainador versión 1.0");
		int lotPrim[] = new int[6];
		int numazar = 0;
		int contador = 0;
		while(contador<6) {
			numazar= ((int)(Math.random()*49)+1);
			boolean yaExiste = false;
			for(int n=0; n<6; n++) {
				if(lotPrim[n] == numazar)
					yaExiste= true;
			}
			if(yaExiste ==false) {
				lotPrim[contador] = numazar;
				contador++;
			}
		}
		/*
		 * for(int i=0; i<lotPrim.length; i++) { numazar= ((int)(Math.random()*49)+1); }
		 */
		System.out.println("Los numeros de la primitiva son: ");
		for (int num : lotPrim)
			System.out.println(num);
		/*String texto = Arrays.toString(lotPrim);
		System.out.println(texto);*/
		System.out.println("Fin del programa.");

	}

}
