package defecto;

import java.util.Scanner;

public class EGP1_15 {

	public static void main(String[] args) {
		Scanner tec1= new Scanner(System.in);
		Scanner tec2= new Scanner(System.in);
		int inicio;
		int fin;
		System.out.println("Generadoraleatorioentrelosnúmerosquemedesinador versión 0.1");
		System.out.println("A continuación, con dos números que me des, te daré un número aleatorio entre ellos(Pero esto solo funciona con enteros eh?)");
		System.out.println("Introduzca por favor el primer numero: ");
		inicio= tec1.nextInt();
		System.out.println("Ahora introduce(͡° ͜ʖ ͡°) el siguiente número: ; ");
		fin= tec2.nextInt();
		if (inicio<fin) {
			int azar = (int)(Math.random()*(fin-inicio+1))+inicio;
			System.out.println("El número al azar que te doy eeees el "+ azar);
			}
		else if (inicio==fin) {
			System.out.println("El numero al azar que te doy eees: " + inicio + " (Me diste el mismo número sonso).");
		}
		else {
			int azar = (int)(Math.random()*(inicio-fin+1))+fin;
			System.out.println("El número al azar que te doy eeees el "+ azar);
		}
			
		System.out.println("Fin del programa");
		tec1.close();
		tec2.close();

	}

}
