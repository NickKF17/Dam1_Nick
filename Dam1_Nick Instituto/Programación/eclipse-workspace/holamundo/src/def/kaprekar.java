package def;

import java.util.Scanner;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class kaprekar{

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
	
		char ordenar[]=new char[4];
		int contador=0;
		int resultado=0;
		String comprobacion="";
		boolean diferentes=false;
		System.out.println("Elije un numero de 4 cifras");
		String numero=teclado.nextLine();
		
		
		if (numero.length()!=4) 
			System.out.println("Pon un numero de 4 cifras");
			else{
		do {
		
				
		for (int i=0;i<=3;i++) {
			ordenar[i]=numero.charAt(i);
			
		}
		Arrays.sort(ordenar);
		
		String texto=Arrays.toString(ordenar);
		
		
		String textoAsc="";
		for (int i=0;i<ordenar.length;i++)
			textoAsc+=ordenar[i];
		int numasc= Integer.parseInt(textoAsc);
		
		
		String textodesc="";
		for (int i=ordenar.length-1;i>=0;i--) {
			textodesc+=ordenar[i];
		}
		int numdesc=Integer.parseInt(textodesc);
		
		
			
			resultado=numdesc-numasc;
			contador++;
			System.out.printf("Paso %4d: %4d - %4d = %4d \n",contador,numdesc,numasc,resultado);


			String resultadoString = String.valueOf(resultado);
		if (resultadoString.length() < 4) {
				resultadoString = "0" + resultadoString;
		}
			numero=resultadoString;
		}while(resultado!=6174);
			System.out.println("Kaprecar te ha encontrado y solo ha necesitado " + contador + " veces");
		
			teclado.close();}
			
		}}