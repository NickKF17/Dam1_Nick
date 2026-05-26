package RA3;

public class Sumanumeros {
public static void main(String[] args) {
	System.out.println(sumatodo(10));
	
}

public static int sumatodo(int num) {
	int suma=0;
	
	for(int i=1;i<=num;i++) {
		
		suma+=i;
	}
	
	return suma;
}
}
