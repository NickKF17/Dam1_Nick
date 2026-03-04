package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;


public class uno {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
	System.out.print("Introduce una frase: ");
	String frase= teclado.nextLine();
	System.out.print("Letra a mantener: ");
	String letra = teclado.next();
	String textoTempo= "";
	
	
	for (int i=0;i<frase.length();i++) {
		char c = letra.charAt(0);	
		if(c == frase.charAt(i) || frase.charAt(i)== ' ') {
	textoTempo= textoTempo +frase.charAt(i);
		}
		else
			textoTempo= textoTempo + "*";
	}
	System.out.println(textoTempo);
	//Hasta aqui la primera parte
	
	/* Incompleta
	int contadorIntentos=0;
	boolean fraseTerminada=false;
	while(fraseTerminada==false){
		int contadorAsteriscos = 0;
		System.out.println("Introduce una letra: ");
		letra= teclado.nextLine();
		int contadorLetra=0;
		contadorIntentos++;
		String fraseNueva="";
		for(int i=0; i<frase.length();i++)
			if(frase.charAt(i)==letra.charAt(0)) {
				fraseNueva=fraseNueva + frase.charAt(i);
				contadorLetra++;
			}
			else {
				fraseNueva=fraseNueva+frase.charAt(i);
		if(frase.charAt(i)=='*')
			contadorAsteriscos++;
	}
		frase=fraseNueva;
		System.out.println("La letra " + letras + " aparece en " + contadorLetra + " ocasiones");
	System.out.println("Resultado " + frase);
	if(contadorAsteriscos==0) {
		fraseTerminada=;
		
	}
	*/
	
	}}