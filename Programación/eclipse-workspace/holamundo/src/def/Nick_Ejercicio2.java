package def;

import java.util.Scanner;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class Nick_Ejercicio2{

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Introduce la cantidad?");
		String dinero= teclado.nextLine();
		double euro_peso=27.93;
		double euro_rupias=102.81;
		double euro_francos=0.93;

		
		double dineronum= Double.parseDouble(dinero.substring(0,dinero.length()-1));
		
		double cambio1 = dineronum * euro_peso;
		double decimalesp = (double) Math.round(cambio1*10000)/10000;
		
		double cambio2 = dineronum * euro_rupias;
		double decimalesr = (double) Math.round(cambio2*10000)/10000;
		
		double cambio3 = dineronum * euro_francos;
		double decimalesf = (double) Math.round(cambio3*10000)/10000;
		
		
		
		switch(dinero.substring(dinero.length()-1)) {
		case "E" , "e":
			System.out.println(dineronum + " euros equivale a " + decimalesp+" pesos cubanos," + decimalesr + " rupias o " + decimalesf + " francos suizos" );
		break;
		case "P","p":
			System.out.println(dineronum + " Pesos Cubanos  equivale a " + (double) Math.round(((decimalesp/euro_peso)/euro_peso)*10000)/10000 +" euros");
			break;
			
		case "R","r":
		System.out.println(dineronum + " Rupias  equivale a " + (double)Math.round(((decimalesr/euro_rupias)/euro_rupias)*10000/10000) +" euros");
			break;
		case "F","f":
		
		System.out.println(dineronum + " Francos  equivale a " + (double)Math.round(((decimalesf/euro_francos)/euro_francos)*10000/10000) +" euros");
			break;
		}
		
	}}
	