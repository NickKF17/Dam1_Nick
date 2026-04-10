package practicas;
import java.util.*;
public class TaboadaMartin_Examen2_P3 {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		System.out.println("Por favor, introduce dos números para comprobar los números capicúa entre ellos.");
		System.out.println("Introduce el primero:");
		int num1= validadorDeNumero(teclado);
		System.out.println("Introduce el segundo:");
		int num2=validadorDeNumero(teclado);
		int temp=0;
		if(num1>num2) {
			temp=num1;
			num1=num2;
			num2=temp;
		}
		int contador=0;
		System.out.printf("Los números capicúas entre %d y %d:\n",num1,num2);
		for(int i=num1; i<=num2; i++) {
			if (escapicua(i)) {
				System.out.println(i);
				contador++;
			}
			
		}
		if(contador==0) {
			System.out.println("No hay ningún número capicúa.");
		
		}
		else
		{
		System.out.printf("Hay un total de %d numeros capicúas.\n",contador);}
		System.out.println("Por favor, introduce un número para comprobar si es capicúa o no:");
		int num3=validadorDeNumero(teclado);
		teclado.close();
		if(escapicua(num3)) {
			System.out.printf("El %d es un número capicúa.",num3);
		}
		else
		{
			System.out.printf("El %d no es un número capicúa.",num3);
		}
		
		
		
	}
static boolean escapicua(int num) {
	boolean si=false;
	String num1Cad= String.valueOf(num);
	String num1CadRev="";
	for(int i=num1Cad.length()-1; i>=0; i--) {
		num1CadRev+=num1Cad.charAt(i);
	}
	if(num1Cad.equals(num1CadRev)) 
		si=true;
	return si;
}
static int validadorDeNumero(Scanner teclado) {
	int num=0;
	boolean todoposi= false;
	do {
	while(todoposi==false) {
		todoposi=true;
		try {
			num= teclado.nextInt();
		}
		catch(Exception e) {
			System.out.println("Entrada incorrecta, tiene que ser un número entero\nVuelve a intentarlo: ");
			todoposi=false;
			teclado.nextLine();
		}
	}
	if(num<0) {
		System.out.println("Error: El número no puede ser negativo\nVuelve a intentarlo: ");
		todoposi=false;
	}}while(todoposi==false);

	return num;
}
}
