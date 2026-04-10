package defecto;
import java.util.Scanner;
public class EGP1_14 {

	public static void main(String[] args) {
		Scanner tec1= new Scanner(System.in);
		Scanner tec2= new Scanner(System.in);
		int inicio;
		int fin;
		System.out.println("Generadoraleatorioentrelosnúmerosquemedesinador versión 0.1");
		System.out.println("A continuación, con dos números que me des, te daré un número aleatorio entre ellos(Pero esto solo funciona con enteros eh?)");
		System.out.println("Esta es una versión primitiva, por favor primero introduce el número menor y luego el número mayor");
		System.out.println("Introduzca por favor el primer numero(debe ser el menor): ");
		inicio= tec1.nextInt();
		System.out.println("Ahora introduce(͡° ͜ʖ ͡°) el siguiente número(debe ser el mayor); ");
		fin= tec2.nextInt();
		int azar = (int)(Math.random()*(fin-inicio+1))+inicio;
		System.out.println("El número al azar que te doy eeees el "+ azar);
		System.out.println("Fin del programa");
		tec1.close();
		tec2.close();
	}

}
