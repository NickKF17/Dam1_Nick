package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ejercicio1 {

	
	public static void main(String[] args) {

		
		
		try {
	Scanner tcl = new Scanner(System.in);
	System.out.print("Cuantos dados vas a tirar? ");
	int num_dados = tcl.nextInt();
	tcl.close();
	int contador =0;
	int arraycontador[]= {0,0,0,0,0,0,0};
	int arraydados[]=new int [num_dados];
	int suma=0;
	
	
	if (num_dados>1) {
	
	for (int i =0 ;i<num_dados;i++) {
	int dado = (int)(Math.random()*6)+1;
	arraydados[i]+=dado;
suma+=dado;
	if (i<num_dados-1)
	System.out.print(dado+", ");
	else
		System.out.print(dado);
	if(dado==1)
		arraycontador[1]++;
	if(dado==6)
		arraycontador[6]++;
	}
	
	System.out.println();
	System.out.println("Has tirado " + num_dados + " dados y ha salido lo siguiente:");
	System.out.println("En "+ arraycontador[1]+ " ha salido un 1");
	System.out.println("En "+ arraycontador[6]+ " ha salido un 6");
System.out.println("La suma de todos los dados da "+ suma);
int mitad= (num_dados*6)/2;
if(suma>mitad)
System.out.println("Tu tirada está por encima de la mitad"+ " ("+mitad+")");
else if (suma<mitad)
	System.out.println("Tu tirada está por debajo de la mitad"+ " ("+mitad+")");
else
	System.out.println("Tu tirada es exactamente la mitad"+ " ("+mitad+")");
		}
	else 
		System.err.println("Introduce un numero entero que sea superior a 1");;
}catch(Exception e) {
	System.err.println("Introduce un numero entero que sea superior a 1");
}
	
		
	}
	}