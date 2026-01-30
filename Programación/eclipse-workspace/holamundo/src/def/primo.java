package def;

import java.util.Scanner;

public class primo {
	public static void main(String[] args) {

boolean esPrimo;
int azar;

do{
	azar=(int)(Math.random()*(400000000+1))+1000000;
	esPrimo=true;
	int raiz = (int)Math.sqrt(azar)+1;
System.out.println("Probando el numero " + azar + "...");
if (azar%2==0)
	esPrimo = false;
else {
for(int divisor=3;divisor<raiz && esPrimo == true;divisor+=2)
if(azar%divisor==0)
esPrimo=false;
}
}while(esPrimo==false);
System.out.println("El numero " + azar + " es primo");

}
	}	