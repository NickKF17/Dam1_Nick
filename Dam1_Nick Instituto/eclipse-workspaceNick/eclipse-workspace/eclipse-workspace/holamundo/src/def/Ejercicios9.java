package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ejercicios9 {

		public static void main(String[] args) {
			
			
			
	
	 Scanner teclado=new Scanner(System.in);
			System.out.println("Escribe un numero");
		int numero=teclado.nextInt();
		System.out.println("Escribe otro numero");
			int numero2=teclado.nextInt();
			System.out.println(sonAmigos(numero,numero2));
	
			
			
			
		}
		
public static boolean sonAmigos(int numero,int numero2){

boolean iguales=true;
	int sumnum=0;
	int sumnum2=0;
	

	for (int i=1;i<numero-1;i++) {
		if(numero%i==0)
			sumnum=sumnum+i;
	}

	for (int i=1;i<numero2-1;i++) {

		if(numero2%i==0)
			sumnum2=sumnum2+i;
	}
	iguales=false;
	if(sumnum==numero2 && sumnum2==numero)
		iguales=true;
	
	return iguales;
}
}


