package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ejercicios9_2 {

		public static void main(String[] args) {
			
			int numero=0;
			Scanner teclado=new Scanner(System.in);

		try {
			do {
			System.out.println("Escribe un numero: ");
			numero=teclado.nextInt();

		
			System.out.println(sonAmigos(numero));
		
				}while(numero<0);
			}catch(Exception e) {
		
			System.err.println("Introduce un numero entero");
		}finally {
			teclado.close();
		}
			}
			
		
		public static boolean sonAmigos(int numero){

		boolean perfecto=true;
			int sumnum=0;
		
			

			for (int i=1;i<numero-1;i++) {
				if(numero%i==0)
					sumnum=sumnum+i;
			}

			perfecto=false;
			if(sumnum==numero)
				perfecto=true;
			
			return perfecto;
		}
		}

