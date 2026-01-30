package defecto;

import java.util.Scanner;

public class Ejercicio2Daniel {

	public static void main(String[] args) {
		String[] clientes= {"Diego Norrea","Inés Perado","Demetrio Imedio","Roberto Rija","Ruben Tosidad","Armando Adistancia","Germán Tequilla"};
		System.out.print("Cuantos premios vas a repartir? ");
		Scanner teclado = new Scanner(System.in);
		int numPremios=teclado.nextInt();
		teclado.close();
		int numSinPremio=clientes.length;
		numSinPremio-=numPremios;
		int sobran=numPremios;
		sobran-=clientes.length;
		
		
		if(numPremios>=clientes.length) {
			System.out.println("\nTienes sólo "+clientes.length+" clientes. Les puedes dar un premio a cada uno");
			if(numPremios>clientes.length)
				System.out.println("Te sobran "+sobran+" premios sin repartir. ¡Guárdalos para el siguiente sorteo!");
		}
		if(numPremios<clientes.length) {
			System.out.println("\nLos/as afortunados/as son:");
			for(int i=0;i<numPremios;i++) {
				System.out.println(clientes[i]);
			}
			System.out.println("\n"+numSinPremio+" clientes se han quedado sin premio. ¡Mucha suerte en el próximo sorteo!");
		}
	}

}
