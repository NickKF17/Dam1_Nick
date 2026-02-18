package defecto;

import java.util.Scanner;

public class buscaminas01 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Largo:");
		int largo=teclado.nextInt();
		System.out.println("Ancho:");
		int ancho=teclado.nextInt();
		int[][] matriz = new int[largo][ancho];
		int[][] traspuesta = new int[largo][ancho];
		int cont1=1;
		int cont2=1;
		for(int x=0;x<largo;x++) {
			for(int y=0;y<ancho;y++) {
				matriz[x][y]=cont1;
				cont1++;
			}
		}
		for(int x=0;x<ancho;x++) {
			for(int y=0;y<largo;y++) {
				traspuesta[y][x]=cont2;
				cont2++;
			}
		}
		for(int x=0;x<largo;x++) {
			System.out.print("|");
			for(int y=0;y<ancho;y++) {
				System.out.print(" "+matriz[x][y]+" ");
			}
			System.out.println("|");
		}
		System.out.println();
		for(int x=0;x<largo;x++) {
			System.out.print("|");
			for(int y=0;y<ancho;y++) {
				System.out.print(" "+traspuesta[x][y]+" ");
			}
			System.out.println("|");
		}
		
	}
}
