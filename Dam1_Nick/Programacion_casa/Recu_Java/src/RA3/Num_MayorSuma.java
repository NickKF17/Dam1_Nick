package RA3;

import java.util.Scanner;

public class Num_MayorSuma {
public static void main(String[] args) {
boolean escero=false;
	Scanner teclado= new Scanner(System.in);
	int mayor=0;
	int total=0;
	do {
		System.out.println("Introduce un numero, se sumaran hasta que sea 0 y se mostrara el mayor introducido");
		int num=teclado.nextInt();
		total+=num;
		
		if(num>mayor)
			mayor=num;
		if(num==0)
			escero=true;
	
	}while(escero==false);
	System.out.println("Numero mayor :"+mayor+" Total sumado :" +total);
}
}
