package def;

import java.util.Scanner;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;



public class Ejercicios4 {

	public static void main(String[] args) {

		/*
		 * Ej 1 Scanner teclado = new Scanner(System.in);
		 * 
		 * System.out.println("Di un numero natural"); double numero =
		 * teclado.nextInt();
		 * 
		 * double factorial=1; for (double i = numero; i>=1;i--) {
		 * System.out.println(i); factorial= i*factorial; }
		 * System.out.println("El factorial de " + numero + " es: " + factorial);
		 * 
		 */

		/*
		 * Scanner teclado = new Scanner(System.in);
		 * 
		 * 
		 * System.out.print("Introduce un número: "); int num = teclado.nextInt();
		 * 
		 * 
		 * String numStr = Integer.toString(num);
		 * 
		 * String reversed = ""; for (int i = numStr.length() - 1; i >= 0; i--) {
		 * reversed += numStr.charAt(i); }
		 * 
		 * if (numStr.equals(reversed)) { System.out.println("El número es capicúa."); }
		 * else { System.out.println("El número NO es capicúa."); }
		 * 
		 * teclado.close();
		 * 
		 */

		/*
		 * Ej 2
		 * 
		 * Scanner teclado= new Scanner(System.in); System.out.
		 * println("Introduce el numero de veces que se efectue la sucesion de fibonacci"
		 * ); int numero = teclado.nextInt(); int a=0; int b=1; for(int
		 * i=0;i<numero;i++) {
		 * 
		 * System.out.println(a); int siguiente = a + b; a = b; b = siguiente;
		 * 
		 * } teclado.close();
		 * 
		 */

		/*
		 * Ej 14
		 * 
		 * 
		 * Scanner teclado= new Scanner(System.in);
		 * System.out.println("Introduce una hora en formato 24H"); String hora =
		 * teclado.nextLine(); teclado.close(); boolean correcto = true; int hhEntero =
		 * Integer.parseInt(hora.substring(0,2)); int mmEntero =
		 * Integer.parseInt(hora.substring(3,5)); if (hora.length() == 5) {
		 * if(hora.charAt(2) == ':') { /* String hh = hora.substring(0,2); String mm =
		 * hora.substring(3,5); int hhEntero = Integer.parseInt(hh); int mmEntero =
		 * Integer.parseInt(mm); 2/ correcto=true;
		 * 
		 * if (hhEntero>=0 && hhEntero<=23) { if(mmEntero>=0 && mmEntero<=23) {
		 * correcto=true; } else correcto=false;
		 * 
		 * } else correcto=false; } else correcto= false; } else correcto=false; if
		 * (correcto = true) { System.out.println("La hora " + hora +
		 * " esta en un formato correcto"); if(hhEntero >= 0 && hhEntero <=5)
		 * System.out.println("Estas en horario de madrugada"); if(hhEntero >= 6 &&
		 * hhEntero <=11) System.out.println("Estas en horario de mañana"); if(hhEntero
		 * >= 12 && hhEntero <=19) System.out.println("Estas en horario de tarde");
		 * if(hhEntero >= 20 && hhEntero <=23)
		 * System.out.println("Estas en horario de noche");
		 * 
		 * } else System.out.println("La hora " + hora +
		 * " no esta en un formato correcto");
		 * 
		 */

		/*
		 * Ej 13
		 *
		 * 
		 * Scanner teclado= new Scanner(System.in);
		 * System.out.println("Introduce un caracter: "); String caracter =
		 * teclado.nextLine();
		 * System.out.println("Introduce un numero de repeticiones:  "); int
		 * repeticiones = teclado.nextInt(); teclado.close();
		 * 
		 * for(int i=0 ;i<repeticiones;i++ ) { System.out.print(caracter); for(int j=0
		 * ;j<repeticiones;j++ ) { System.out.print(caracter); } System.out.println(); }
		 * 
		 */

		/*
		 * Ej 9 hoja 2
		 * 
		 * 
		 * Scanner teclado=new Scanner(System.in); String entrada=""; int contador= 0;
		 * do { System.out.println("Introduce un numero entre 1-100 o FIN: ");
		 * entrada=teclado.nextLine(); if (entrada.equals("FIN")==false) { int numero =
		 * Integer.parseInt(entrada); if(numero>=1 && numero<=100) contador++; }
		 * }while(entrada.equals("FIN")==false); System.out.println("Has metido "+
		 * contador + " numeros entre 1 y 100");
		 */

		/*
		 * Scanner teclado=new Scanner(System.in);
		 * System.out.println("Introduce el radio de tu circunferencia"); //como nos
		 * dice que tiene que admitir decimales lo hacemos con double double
		 * radio=teclado.nextDouble();
		 * 
		 * double longitud= 2 * 3.141519 * radio; double area= 3.141519 * radio*radio;
		 * teclado.close(); //Damos salida para ver los datos en la consola
		 * 
		 * System.out.println("La longitud de la circunferencia es: " + longitud);
		 * System.out.println("El area del circulo es: " + area);
		 * 
		 * 
		 * //Para Conseguuir cinco cifras decimales: // 1- Multiplicamos por 1 seguido
		 * de cinco ceros //2- Convertimos a entero //3- Dividimos por 1 seguido de
		 * cinco ceros longitud = Math.round(longitud * 100000.0) / 100000.0; area =
		 * Math.round(area * 100000.0) / 100000.0;
		 * 
		 * System.out.println(longitud); System.out.println(area);
		 */

		/*
		 * String texto = "Esto es una cadena de prueba"; String textoPares="";
		 * 
		 * for (int posicion=0 ; posicion<texto.length();posicion++) if(posicion%2==0)
		 * textoPares = textoPares+ texto.charAt(posicion);
		 * System.out.println(textoPares);
		 */

		/*
		 * String texto = "Esto es una cadena de prueba"; String textoPares="" +
		 * texto.charAt(0); for (int posicion =1 ;posicion< texto.length();posicion++) {
		 * textoPares=textoPares + "-" + texto.charAt(posicion); }
		 * textoPares=textoPares.replace("- -", " "); System.out.println(textoPares);
		 */

		/*
		 * Ejercicio 15 hoja 3 String fecha="02/10/2024"; boolean fechaCorrecta=true; if
		 * (fecha.length()!=10) fechaCorrecta=false; else if (fecha.charAt(2)!='/' ||
		 * fecha.charAt(5) !='/') fechaCorrecta=false; else { int dia=
		 * Integer.parseInt(fecha.substring(0,2)); int mes=
		 * Integer.parseInt(fecha.substring(3,5)); if(dia<1 || dia>31)
		 * fechaCorrecta=false; else if (mes<1 || mes>12) fechaCorrecta=false; } if
		 * (fechaCorrecta==true) System.out.println("La fecha " + fecha +
		 * " es correcta"); else System.out.println("La fecha " + fecha +
		 * " es incorrecta");
		 */

		/*
		Scanner teclado = new Scanner(System.in);
		System.out.print("Escribe un texto: ");
		String texto = teclado.nextLine();
		System.out.print("Escribe un caracter: ");
		String caracter = teclado.nextLine();
		teclado.close();
		String posiciones="";
		int contador = 0;
		for (int i = 0; i < texto.length(); i++)
						if (texto.charAt(i) == caracter.charAt(0))
				contador++;
		System.out.println("El caracter '" + caracter + "' aparece en " + contador + " ocasiones");
		if(contador !=0) {
		System.out.print("Las posiciones en las que aparece son : ");
		int contador2 = 0;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == caracter.charAt(0)) {
				posiciones= posiciones + i + ", ";
			}
		}
		
		posiciones=posiciones.substring(0,posiciones.length()-2);
		}
		*/
		
			/*
		Scanner teclado= new Scanner(System.in);
		System.out.println("¿Cuantas veces quieres que se repita la sucesion de fibonacci?");
		int veces= teclado.nextInt();
		teclado.close();
		System.out.print("Los primeros " + veces + " numeros de la sucesion de fibonacci: 0, 1");
		int num1=0;
		int num2=1;
		if (veces>=1)
			System.out.println(0);
		if (veces>=2) {
		System.out.println(", 1");
		
		for (int i =2 ; i < veces ; i++) {
			int nuevoNumero = num1+ num2;
		System.out.print(", " + nuevoNumero);
		num1=num2;
				num2=nuevoNumero;
		}}
		*/
		/* Ej Hoja 4
		
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce un texto con cifras y letras: ");
		String texto = teclado.nextLine();
		teclado.close();
	for (int i=0;i<texto.length();i++) {
		char caracter = texto.charAt(i);
	switch(caracter) {
	case '0' , '1' , '2' , '3','4','5','6','7','8','9':
		System.out.print(caracter);
	}
	}
	
	*/
		
/*
 
		Scanner teclado= new Scanner(System.in);
		System.out.println("Introduce una temperatura: ");
		String temperatura = teclado.nextLine();
		teclado.close();
		
		double numero = Double.parseDouble(temperatura.substring(0,temperatura.length()-1));
		char unidad = temperatura.charAt(temperatura.length()-1);
		double calculo=0;
		switch(unidad) {
		case 'c','C':
			calculo=(numero* 1.8)+32;
		System.out.println(temperatura + " equivale a "+ calculo + "F");
		calculo= numero + 273.15;
		System.out.println(temperatura + " equivale a "+ calculo + "K");
			break;
		case 'k','K':
			calculo= numero-273.15;
		System.out.println(temperatura + " equivale a "+ calculo + "C");
		calculo=1.8*(numero-273.15) + 32;
		System.out.println(temperatura + " equivale a "+ calculo + "F");
			break;
		case 'f','F':
			calculo=(numero-32)/1.8;
		System.out.println(temperatura + " equivale a "+ calculo + "C");
		calculo=5/9*(numero-32)+273.15;
		System.out.println(temperatura + " equivale a "+ calculo + "K");
			
		break;
		default:
			System.out.println("La unidad no esta reconocida");
		}
		
		*/
		
		/* Ej 9 Hoja 2
		boolean seacabo= false;
		
		Scanner teclado = new Scanner(System.in);
		String patronNumerico = "[0-9]+";
		int contador=0;
		do {
			System.out.println("Introduce un numero entre 1 y 100 o Fin para salir");
			String entrada = teclado.nextLine();
			if (entrada.equals("FIN") || entrada.equals("Fin") || entrada.equals("fin") || entrada.equals("fIn") || entrada.equals("fiN")
					|| entrada.equals("FIn")|| entrada.equals("fIN")|| entrada.equals("FiN"))
				seacabo=true;
			else if (entrada.matches(patronNumerico)== true) {
				System.out.println("Es un numero entero");
			int numero = Integer.parseInt(entrada);
			if (numero >= 1 && numero <= 100)
			contador++;
			else 
				System.out.println("Pero no es un numero entero entre 1 y 100");
			}
			else 
				System.out.println("Es otra cosa");
			
		}while (seacabo==false);
		System.out.println("Has introducido " + contador + " números validos");
		
		
		
*/		
		
		
		int [] numeros = {14, 145, 5, 23, 37, 1, 456, 44};
		Arrays.sort(numeros);
		//for (int i=0 ; i<numeros.length;i++)
		int[] nuevoArray = new int[numeros.length];
		int j=0;
		for (int i=numeros.length-1;i>=0;i--) {
			nuevoArray[j]=numeros[i];
			j++;
		}
			for (int n : nuevoArray)
				System.out.println(n);
			
		}
	
}