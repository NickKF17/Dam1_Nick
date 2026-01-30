package defecto;

import java.util.Scanner;

import javax.security.auth.callback.TextOutputCallback;

public class uno {
	public static void main(String[] args) {
	
	/// 1
		
	Scanner frase = new Scanner(System.in);
	System.out.println("Escribe la frase para jugar:");
	String fraseEscrita = frase.nextLine();
	
	Scanner letra = new Scanner(System.in);
	System.out.println("Escribe la letra que quieras mentener:");
	String letraMantener = letra.nextLine();
	
	while(letraMantener.length() >1) {
		System.out.println("Escribe una sola letra:");
		letraMantener = letra.nextLine();
	}
	
	String al="";
	for(int i=0;i<fraseEscrita.length();i++) {
			char c = letraMantener.charAt(0);
			if(c == fraseEscrita.charAt(i)) {
				al = al + fraseEscrita.charAt(i);
//				System.out.println(al);
				}
				else {
					al += "*";
				}
	if(al.length()==fraseEscrita.length()) {		
	System.out.println(al);
	}
	
	int contadorIntentos = 0;
	boolean fraseTerminada = false;
	while(fraseTerminada==false){
		int contadorAsteriscos = 0;
		System.out.println("Introduce una letra:");
		letraMantener = frase.nextLine();
		int contadorLetra = 0;
		contadorIntentos++;
		String fraseNueva ="";
		for(i=0;i<fraseEscrita.length();i++) 
			if(fraseEscrita.charAt(i) == letraMantener.charAt(0)){
			fraseNueva += fraseEscrita.charAt(i);
			contadorLetra++;
			}
		else {
			fraseNueva += al.charAt(i);
			if(al.charAt(i) == '*')
				contadorAsteriscos++;
		}
		
	al = fraseNueva;
	System.out.println("La letra "+letraMantener+" aparece en "+contadorLetra);
	System.out.println("Resultado: "+al);
	
	}
	
	
	
	
	
		}
	}
}
