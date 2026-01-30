package def;

import java.util.Scanner;
import java.util.regex.Pattern;


import java.util.regex.Matcher;

public class digit_ej {

	public static void main(String[] args) {
		
		/* Ej 10 Hoja 4
		Scanner teclado=new Scanner(System.in);
		String new_tex="";
		
		System.out.println("Introduce texto con numeros");
		String texto = teclado.nextLine();
		for (int i=0;i<texto.length();i++) {
		String c = String.valueOf(texto.charAt(i));
			if (c.matches("[0-9]"))
	 new_tex = new_tex + texto.charAt(i);
		}
		System.out.println(new_tex);
		*/
		
		/*   Ej 10 Hoja 3
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce un DNI");
		String dni = teclado.nextLine();
		
		if (dni.matches("[0-9]{8}[A-Za-z]{1}"))
			System.out.println("El DNI es valido");
		else
			System.out.println("El DNI no es valido");
			*/
		
		/*
		
		Scanner teclado=new Scanner(System.in);
			System.out.println("Introduce la matricula");
		String textoValidar= teclado.nextLine();
		
		if(textoValidar.matches("[0-9]{4}[\\s-][A-Za-z&&[^AEIOUQaeiouq]]{3}"))
			System.out.println(textoValidar + " es una matricula valida");
		else
			System.out.println(textoValidar + " no es una matricula valida");
		
		*/
		
		/*
		
		int numero=10;
		boolean esPrimo;
		int anterior=0;
		
		boolean gemelos= false;
		for(int contador=0;contador<50;contador++) {
		do {
			int raiz= (int)Math.sqrt(numero)+1;
			esPrimo = true;
			for(int i =2;i<raiz;i++) {
							if(numero%i==0)
								esPrimo=false;
						
					}
					if(esPrimo == false) 
						numero++;
					}while(esPrimo==false);
	double numeroRaiz=Math.sqrt(numero);
	int cuadrado= numero*numero;	
	int cubo = numero*numero*numero;
	System.out.println(numero + " es primo " + " - " + numeroRaiz + " - " + cuadrado + " - " + cubo);
					numero++;
					
		}
*/
		/*
		
		int numero = 50;
		int anterior = 0;
		boolean gemelosEncontrados = false;
		while(gemelosEncontrados == false) {
		boolean esPrimo;
		for(int contador=0;contador<50;contador++) {
			do {
					esPrimo = true;
					int raiz = (int)Math.sqrt(numero) + 1;
		for(int i = 2; i <raiz;i++) {
				if(numero%i == 0)
		esPrimo = false;
		}
		if(esPrimo == false)
		numero++;
		}while(esPrimo == false);
		if(numero-anterior == 2)
		gemelosEncontrados = true;
		else {
anterior=numero;
numero++;
}
	}
		}
		
		System.out.println("Los primeros gemelos son " + anterior + " y " + numero);
		
		*/
		
		
		int lista[]=new int[6];
		String textos[]=new String[10];
		int[] vector;
	    double[] notas= {1,2,3,4,4.5,5,5.5,6,7,8,9,10};
	    lista[2]=5;
	    System.out.println(notas[1]);
	    notas[1]=9.2;
	    System.out.println(notas[1]);
	    
	    
	}}
