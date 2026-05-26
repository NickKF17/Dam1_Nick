package RA3;

import java.util.Scanner;

public class ifelses {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	
	System.out.println("Escribe el numero a estudiar");
	
int numero = teclado.nextInt();

if (numero<0)
	System.out.println("El "+ numero+" es negativo");
else if(numero>0) {
	if (numero%2==0)
System.out.println("El "+numero+" es positivo y par");
	else
		System.out.println("El "+numero+" es positivo e impar");
}
else
	System.out.println("El numero es 0");
}
}
