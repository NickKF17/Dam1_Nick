package def;

import java.util.Scanner;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class Ejercicios5{

	public static void main(String[] args) {
		
		/*
		int[] primitiva = new int[6];
		int contador=0;
		int random;
	
		for (int i=0; i<6 ;) {
			random= (int) (Math.random()*49 )+1;
			boolean repetido= false ;
			
			for (int j=0 ; j < contador;j++) {
				if (primitiva[j]==random) {
				repetido=true;
				break;}}
			
				if (repetido==false) {
					primitiva[contador]=random;
					contador++;
					i++;
	
		}
				}
		Arrays.sort(primitiva);
		
		 System.out.print("Números de la lotería: ");
	        for (int n : primitiva)
	            System.out.print(n + " ");
	            
	            */
		
	/*
		        Scanner sc = new Scanner(System.in);

		 
		        System.out.print("Introduce el primer número: ");
		        int num1 = sc.nextInt();

		        System.out.print("Introduce el segundo número: ");
		        int num2 = sc.nextInt();

		        
		        int limite = Math.min(num1, num2);
		        int[] comunes = new int[limite];
		        int contador = 0;

		      
		        for (int i = 1; i <= limite; i++) {
		            if (num1 % i == 0 && num2 % i == 0) {
		                comunes[contador] = i;
		                contador++;
		            }
		        }


		        int[] resultado = Arrays.copyOf(comunes, contador);

		  
		        System.out.println("Divisores comunes de " + num1 + " y " + num2 + ": " + Arrays.toString(resultado));
		
		        */
		
		int azar;
		int numeros[] = new int[100];
			int contador=0;
			boolean mismo= true;
			int nuevocontador=0;
			int contador2=0;
		for (int i =0 ; i<100;i++) {
          numeros[i] = (int)(Math.random()*50)+1;
		}
		Arrays.sort(numeros);
		System.out.println("El menor es " + numeros[0] + " y el mayor es " + numeros[99]);
		
		for(int i=0;i<99;i++) {
			
		if (numeros[i]==numeros[i+1]) {
				
		System.out.println("El numero " + numeros[i] + " esta repetido con su contiguo" );
		contador2++;
		contador++;
		System.out.println(contador2);
			}
		else {
		System.out.println();
		}
		if(mismo ==false)
			break;
		}
		for (int i =0 ; i<100;i++) {
			System.out.print(numeros[i]+" ");
		}
		
		
}
}