package def;

import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) {

		/*
		 * System.out.println("Hola Mundo"); System.err.println("Adios Mundo"); int edad
		 * = 30; int curso = 1; int edad2= 0;
		 * 
		 * System.out.println(edad); edad=31;
		 * 
		 * System.out.println(edad);
		 * 
		 * System.out.println(curso); curso=1+1;
		 * 
		 * System.out.println(curso); edad2= edad + 1;
		 * 
		 * curso= curso+3;
		 * 
		 * 
		 * System.out.println(edad2); System.out.println(curso);
		 * 
		 * double precio = 4.5; System.out.println(precio); // Sin el = (float) daria
		 * error float iva = (float)12.5; System.out.println(iva); //Division sin
		 * decimales System.out.println(5/2); //Resto de la division
		 * System.out.println(5%2);
		 * 
		 * 
		 */

		int x = 5;
		int y = 3;
		/*
		 * x++; // x=x +1 // x +=1; y--; // y= y -1; //y -=1;
		 * 
		 * //System.out.println(x); //System.out.println(y);
		 * 
		 * 
		 * 
		 * System.out.println(x++); // De la forma x++ imprimes x y luego sumas uno para
		 * la siguiente vez que imprimas x //System.out.println(++x);
		 * System.out.println(x);
		 */
		/*
		 * 
		 * int numero= 5; String num2= "5";
		 * 
		 * 
		 * String texto ="Hola Mundo";
		 * 
		 * System.out.println(texto);
		 * 
		 */

		/*
		 * String texto2 = ""; texto2="Hola" + " " +"Mundo"; System.out.println(texto2);
		 * 
		 * String playa = "" ; playa= "Hola"+ " " + "Playa"+ " " + (texto2);
		 * System.out.println(playa);
		 */

		/*
		 * int edad= 18; if(edad>18) { System.out.println("Tienes mas de 18 años"); }
		 * else if (edad<18) { System.out.println("Tienes menos de 18 años"); } else
		 * {System.out.println("Tienes 18 años"); } }
		 */

		/*
		 * int sueldo = 500; int sueldodef1 = sueldo - (sueldo * 10) / 100;
		 * 
		 * int sueldodef2 = sueldo - (sueldo * 50) / 100;
		 * 
		 * if (sueldo <= 1000) { System.out.println("No pagas impuestos");
		 * System.out.println("Cobras " + sueldo + "$"); } else if (sueldo >= 10000) {
		 * System.out.println("Tienes que pagar un 50% de impuestos");
		 * System.out.println("Cobras " + sueldodef2 + "$"); } else {
		 * System.out.println("Tienes que pagar un 10% de impuestos");
		 * System.out.println("Cobras " + sueldodef1 + "$"); }
		 * System.out.println("Fin del programa");
		 */

		/*
		 * char letra = 'x'; String otraletra = "x"; System.out.println(otraletra);
		 * System.out.println(letra);
		 */

		/*
		 * for(int i=3;i<100;i=i+3) System.out.println(i);
		 */

		/*
		 * Scanner lector; /* lector= new Scanner(System.in);
		 * 
		 * System.out.println("Escribe tu nombre:"); String nombre= lector.nextLine();
		 * System.out.println("Tu nombre es: " + nombre);
		 * 
		 * lector.close();
		 */

		/*
		 * Scanner teclado = new Scanner(System.in); int numero;
		 * System.out.println("Escribe un numero"); numero =teclado.nextInt(); if
		 * (numero %2==0) System.out.println("Tu numero " + numero + " es par"); else
		 * System.out.pri
		 */

		/*
		 * Scanner teclado = new Scanner(System.in); int numero1; int numero2;
		 * System.out.println("Escribe un numero"); numero1 = teclado.nextInt();
		 * System.out.println("Escribe otro numero"); numero2 = teclado.nextInt(); if
		 * (numero1 > numero2) { System.out.println("El " + numero1 + " es mas grande");
		 * } else if (numero1 < numero2) { System.out.println("El " + numero2 +
		 * " es mas grande"); } else {
		 * System.out.println("Los dos numeros son iguales"); } teclado.close();
		 */
		/*
		 * for (int i=0;i<5;i++) { System.out.println(i); }
		 * 
		 */
		
		Scanner teclado = new Scanner(System.in); 
	
		int i;
	//int i= 5;
		do {
		//while(i!=0) {
			System.out.println("Elige un numero");
			i=teclado.nextInt();

		}	while(i!=0);
		System.out.println("Acabo el bucle");
		teclado.close();
	}
}
