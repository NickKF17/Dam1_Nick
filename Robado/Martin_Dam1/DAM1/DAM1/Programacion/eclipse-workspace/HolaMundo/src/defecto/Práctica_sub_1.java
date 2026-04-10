
package defecto;

import java.util.Scanner;

public class Práctica_sub_1 {
	
	public static void main(String[] args) {
		String texto1 = "Hola mundo";
		String texto2 = new String("Hola mundo cruel");
		texto1 = texto1 + " cruel!";
		System.out.println(texto1);
		texto1 = texto2.concat(" Bienvenidos al Goya");
		System.out.println(texto1);
		
		for(int i=0; i<texto2.length(); i++)
			System.out.println(texto2.charAt(i));
		
		System.out.println(texto2.toLowerCase());
		System.out.println(texto2.toUpperCase());
		
		String nombre1 = "Rodríguez";
		String nombre2 = "Romero";
		if(nombre1.compareTo(nombre2) == 0)
			System.out.println("Son iguales");
		else if(nombre1.compareTo(nombre2)>0)
			System.out.println(nombre1 + " va detrás de " + nombre2);
		else
			System.out.println(nombre1 + " va delante de " + nombre2);
		System.out.println(nombre1.substring(3));
		System.out.println(nombre1.substring(3,7));
		
		String cadenaVacia="";
		String cadenaNula;
		String CadenaNula2 = null;
		if(cadenaVacia.isEmpty()== true)
			System.out.println("La cadena está vacía");
		if(cadenaVacia.equals("") == true)
			System.out.println("La cadena está vacía");
		if(cadenaVacia.compareTo("") == 0)
			System.out.println("La cadena está vacía");
		
		String texto = "Hola mundo cruel";
		System.out.println(texto.indexOf("0"));
		
		System.out.println(texto.replace(" ", "-"));
		System.out.println(texto);
		texto = texto.replace(" ", "-");
		System.out.println(texto);
		Scanner teclado = new Scanner(System.in);
		System.out.println("Pulsa P para jugar, C para configurar o X para salir:  ");
		String opcion = teclado.nextLine();
		switch(opcion) {
		case "P":
		case "p":
			System.out.println("En un momento se cargará el juego....");
			break;
		case "C":
		case "c":
			System.out.println("Abriendo configuración.......");
			break;
		case "X":
		case "x":
			System.out.println("Saliendo del programa......");
			break;
		default:
			System.out.println("Las letras que te dije we!");
			break;
			
		}
		teclado.close();
		}
	}

