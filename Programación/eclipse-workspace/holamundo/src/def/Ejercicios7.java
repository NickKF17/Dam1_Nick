package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;


public class Ejercicios7 {
	final static int MINA=1;
	
	
	public static void main(String[] args) {
		/* Busca Minas
try {
	
		Scanner teclado=new Scanner(System.in);
		System.out.println("Elige la extensión del tablero: ");
		int numero=teclado.nextInt();
		
		System.out.println("Elige cuantas minas quieres que hayan: ");
		int minas=teclado.nextInt();
		
		int tablero[][]=new int[numero][numero];
	
		colocarMinas(tablero, minas,numero);
		mostrarTablero(tablero,minas, numero);
		teclado.close();
}
catch(Exception e) {
	System.err.println("Introduce solo caracteres numéricos");
}

	}
	public static void colocarMinas(int[][] tablero, int minas, int numero) {

		int numMinas=0;
		if (minas>numero*numero) {
			System.out.println("Las minas no pueden ser mayores al número de casillas: ");
		}else {
	while(numMinas!=minas) {
		int fila=(int)(Math.random()*numero);
		int columna=(int)(Math.random()*numero);
		if(tablero[fila][columna]==0) {
		tablero[fila][columna]=MINA;
		numMinas++;
		}
	}
	}
	}
	public static void mostrarTablero(int[][] tablero, int minas,int numero){
		if (minas<=numero*numero) {
		for(int i=0;i<numero;i++) {
			System.out.println();
			for(int j=0;j<numero;j++)
				System.out.print(tablero[i][j] + " ");
}}
*/
		/*
		Scanner teclado=new Scanner(System.in);
		System.out.println("Di un número");
		try {
		
		int numero= teclado.nextInt();
		
		
		int array_num[]=new int[numero];
		for(int i=0; i<numero;i++) {
		array_num[i]=(int)(Math.random() * (1000 - 10 + 1)) + 10;
		}
		String texto_array= Arrays.toString(array_num);
		System.out.println(texto_array.replace("[", "").replace("]", "").replace(",", " -"));
	
		
		
		System.out.println("¿Di la posición que quieres saber?");
		int numero2=teclado.nextInt();
		int real=numero2--;
		
		if(numero2<0 || numero2>numero) {
			System.err.println("Esa posición no existe");
		}else{
			System.out.println("Posición " + real + ": "+ array_num[numero2]);
	
	
		}
		}catch(Exception e) {
			System.err.println("Número invalido");
			
		}finally {
			teclado.close();
		
			}
			*/
		
		
		Scanner teclado=new Scanner(System.in);
		System.out.print("Escribe una frase: ");
		String frase = teclado.nextLine();
		
		
		String lista[] = frase.split(" ");
		int contador=0;
		for(String palabra:lista)
			//System.out.println(palabra);
		if(cuatroomas(palabra)) {
		contador++;
		}
		System.out.println("Hay "+ contador + " palabras con 4 o mas vocales");
		}
	public static boolean cuatroomas(String palabra) {
		int contadorvocales=0;
		boolean cuatroomas=false;
		String[] letras={"a","e","i","o","u"};
		for(String letra:letras) {
			contadorvocales+=buscaletras(palabra,letra);
		}
		if(contadorvocales>=4)
			cuatroomas=true;
		return cuatroomas;
	}
	public static int buscaletras(String palabra,String letra) {
		
		int hayletra=1;
		if(palabra.indexOf(letra)==-1)
			hayletra=0;
		return hayletra;

	}
}