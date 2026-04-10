package defecto;
import java.util.Scanner;
public class EGP2_1 {

	public static void main(String[] args) {
		Scanner Tecla1 = new Scanner(System.in);
		Scanner Tecla2 = new Scanner(System.in);
		Scanner Tecla3 = new Scanner(System.in);
		String letra1;
		String letra2;
		String letra3;
		System.out.println("Ordenadoralfabéticodeletrrasinador versión 2.0");
		System.out.println("Por favor, introduce una Palabra: ");
		letra1 = Tecla1.next();
		System.out.println("Por favor, introduce otra Palabra: ");
		letra2 = Tecla2.next();
		System.out.println("Otra más, por favor: ");
		letra3 = Tecla3.next();
		System.out.println("El orden de las Palabras alfabéticamente es:");
		if (letra1.compareTo(letra2)<0 && letra2.compareTo(letra3)<0)
			System.out.println(letra1+", "+letra2+", "+letra3);
		else if(letra1.compareTo(letra2)<0 && letra2.compareTo(letra3)>0)
			System.out.println(letra1+", "+letra3+", "+letra2);
		
		else if (letra2.compareTo(letra1)<0 && letra1.compareTo(letra3)<0)
			System.out.println(letra2+", "+letra1+", "+letra3);
		else if(letra2.compareTo(letra1)<0 && letra1.compareTo(letra3)>0)
			System.out.println(letra2+", "+letra3+", "+letra1);
		
		else if (letra3.compareTo(letra1)<0 && letra1.compareTo(letra2)<0)
			System.out.println(letra3+", "+letra1+", "+letra2);
		else if(letra3.compareTo(letra1)<0 && letra1.compareTo(letra2)>0)
			System.out.println(letra3+", "+letra2+", "+letra1);
			
	}

}
