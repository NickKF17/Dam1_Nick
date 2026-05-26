package RA6;

import java.util.Arrays;

public class OrdenarArrays {
public static void main(String[] args) {
	
	int[] numeros = {3, 7, 6 ,1, 9, 4, 2};
	Arrays.sort(numeros);
	for(int n : numeros)
	System.out.print(n);
	
	
	System.out.println();
	
	int resultado=Arrays.binarySearch(numeros, 6);
	System.out.println(resultado);
	
	
	System.out.println(Arrays.toString(numeros));
	
	
	
}
}
