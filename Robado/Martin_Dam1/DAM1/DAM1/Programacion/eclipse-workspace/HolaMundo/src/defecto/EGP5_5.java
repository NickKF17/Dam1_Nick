package defecto;

import java.util.*;

public class EGP5_5 {
	public static void main(String[] args) {
		int tabla[] = new int[100];
		int contador[] = new int[50];
		for(int i=0; i<100; i++) {
			tabla[i]=(int)(Math.random()*50)+1;
		}
		Arrays.sort(tabla);
		System.out.println("El menor es " + tabla[0] + " y el mayor es " + tabla[99]);
		for(int n:tabla) {
			if (tabla[n]==tabla[n+1])
				contador[tabla[n]]+=1;
				
		}
		contador
		for(int n:contador)
			System.out.println(contador[n]);
	}
}
