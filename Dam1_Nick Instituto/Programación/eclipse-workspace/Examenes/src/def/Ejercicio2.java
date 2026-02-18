package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ejercicio2 {
	
	public static void main(String[] args) {
	String clientes[]= {"Diego Norrea","Leonel Messi","Cristiano Ronaldo","Neymar Junior","Roberto Carlos","Andrés Iniesta"};
	Scanner tcl = new Scanner(System.in);
	
	int pdados=0;
	System.out.print("Cuantos premios vas a repartir? ");
	int num_premios = tcl.nextInt();
	tcl.close();
	int res =clientes.length-num_premios;
if (num_premios<clientes.length) {
do{
		int suerte = (int)(Math.random()*clientes.length);
		
		if (clientes[suerte]!="") {
		System.out.println(clientes[suerte]);
		num_premios--;
		clientes[suerte]="";
		}
		
		
	}	while(pdados!=num_premios);

	

	System.out.println(res+ " Se han quedado sin premio, mucha suerte para el proximo sorteo");
	}else if (num_premios==clientes.length) 
	System.out.println("Tienes solo "+ num_premios+". Les puedes dar un premio a cada uno.");
	
else {
	System.out.println("Tienes solo "+ num_premios+". Les puedes dar un premio a cada uno.");
	int resta=num_premios-clientes.length;
System.out.println("Te sobran "+ resta +" premios sin repartir. ¡Guardatelos para el siguiente sorteo");
}
	
	}}