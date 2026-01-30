package def;

import java.util.Scanner;

public class Ejercicios3 {

	public static void main(String[] args) {
		
		/* Ej 1 y 2
		String nombre1;
		String nombre2;
		int contador=0;
		
		System.out.println("Escribe una contraseña");
		nombre1=teclado.next();
		System.out.println("Escribe una contraseña");
		nombre2=teclado.next();

		do {
			contador++;
		if(nombre1.compareTo(nombre2) != 0) {
			System.out.println("No son iguales");
			System.out.println("Escribe una contraseña");
			nombre1=teclado.next();
			System.out.println("Escribe una contraseña");
			nombre2=teclado.next();
		}
		}while(nombre1.compareTo(nombre2)!=0);
		System.out.println("Las contraseñas son iguales");
		System.out.println("Se han introducido " + contador + " veces contraseñas que no son iguales");
		*/
		
		
		/* Ej 3
		
		String nombre;
		String nombre2;
		String apellido;
		String apellido2;
		
		System.out.println("Dime tu primer nombre");
		nombre=teclado.next();
		System.out.println("Dime tu segundo nombre");
		nombre2=teclado.next();
		
		System.out.println("Dime tu primer apellido");
		apellido=teclado.next();
		System.out.println("Dime tu segundo apellido");
		apellido2=teclado.next();
		
		System.out.println(apellido + " " + apellido2 + ", " + nombre + " " +nombre2);
		
		*/ 

		
		/*  Ej 12.1 de ejercicios 2
		 
		 
		Scanner teclado= new Scanner(System.in);
		int azar=(int)(Math.random()*50)+1;

		
		boolean acertado= false;
		for(int intentos=1;intentos<1000000 && acertado==false;intentos++) 
		do{
			System.out.println("Intento numero " + intentos + "¿En que numero estoy pensando?");
			int eleccion = teclado.nextInt();
			if(eleccion==azar) {
				System.out.println("Has acertado");
			acertado=true;
		}
			else if (eleccion>azar)
	
				System.out.println("Te has pasado");
			else 
				System.out.println("Te has quedado corto");
		}while(acertado==false);
		if(acertado==false)
		System.out.println("Has agotado tus intentos, el numero era " + azar);
		
		*/
		
		/* Ej 12.2 de ejercicios 2
		
		Scanner teclado= new Scanner(System.in);
		int azar=(int)(Math.random()*50)+1;
int intentos=0;
		int numeroMasBajo=0;
		boolean acertado= false;
		do {
			intentos++;
			System.out.println("Intento numero " + intentos + "¿En que numero estoy pensando?");
			int eleccion = teclado.nextInt();
			if(eleccion==azar) {
				System.out.println("Has acertado");
			acertado=true;
		}
			else if (eleccion>azar)
	
				System.out.println("Te has pasado");
			else {
				System.out.println("Te has quedado corto");
		    }

		}while(acertado==false);
		
		*/
		
/* ej 6
String texto;

        Scanner teclado = new Scanner(System.in);

        // Pedir al usuario el texto
        System.out.print("Introduce una cadena de texto: ");
        texto = teclado.nextLine();

        // Cadenas para pares e impares
        StringBuilder pares = new StringBuilder();
        StringBuilder impares = new StringBuilder();

        // Recorrer el texto carácter por carácter
        for (int i = 0; i < texto.length(); i++) {
            if (i % 2 == 0) {
                pares.append(texto.charAt(i));    // posición par
            } else {
                impares.append(texto.charAt(i));  // posición impar
            }
        }

        // Mostrar resultados
        System.out.println("Cadena de posiciones pares: " + pares);
        System.out.println("Cadena de posiciones impares: " + impares);

        teclado.close();
        */
		
		/* ej 7
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escribe una linea de texto");
		String texto=teclado.nextLine();
		String Nuevotexto="";
		
		for (int i = 0; i < texto.length(); i++) {
		    char c = texto.charAt(i);
		    if (c == 'a' || c=='A')
		        Nuevotexto += '4';
		    else if (c == 'e' || c=='E')
		        Nuevotexto += '3';
		    else if (c == 'i' || c== 'I')
		        Nuevotexto += '1';
		    else if (c == 'o' || c== 'O')
		        Nuevotexto += '0';
		    else
		        Nuevotexto += c;
		}
		System.out.println(Nuevotexto);
		*/

		
		
		
		
		
		/* Ej 10
		  
		  
		 Scanner teclado = new Scanner(System.in);
		        System.out.print("Introduce un NIF: ");
		        String nif = teclado.nextLine();

		        if (nif.length() == 9
		            && nif.substring(0,8).chars().allMatch(Character::isDigit)
		            && Character.isLetter(nif.charAt(8))) {
		            System.out.println("NIF válido");
		        } else {
		            System.out.println("NIF no válido");
		        }

		        teclado.close();
		        
		        */
		/* Trim
		 
		String dni = "  28666555Z  ";
				System.out.println(dni);
				dni = dni.trim();
				System.out.println(dni);
				
				*/
	
		    }

			}