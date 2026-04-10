package defecto;

import java.util.*;
import java.lang.*;

public class EGP7_8 {
	// Con esto, la variable se vuelve global, todas las funciones pueden entenderlo
	final static int MINA = 1;

	public static void main(String[] args) {
		int lado = 10;
		int minas = 7;
		boolean correcto =false;
		do {
			Scanner teclado = new Scanner(System.in);
			try {
				System.out.println("De cuantos lados es el tablero: ");
				lado = teclado.nextInt();
				System.out.println("Cuantas minas vas a poner: ");
				minas = teclado.nextInt();
				if(minas<lado*lado)
					correcto =true;
				else
					System.out.println("No puedo poner " + minas + " minas en un tablero de " + lado*lado + " casillas");
			}catch(Exception e){
				System.out.println("No puedes poner letras cuando pregunto numeros, animal");
			}
			
			
		}while(correcto == false);
		int[][] tablero = new int[lado][lado];
		//Así la variable solo existe en esta funcion 
		//final int MINA =1;
		mostrarTablero(tablero, lado);
		colocarMinas(tablero,lado, minas);
		
		tablero[2][3] =MINA;
		System.out.println();
		mostrarTablero(tablero, lado);
	}

	public static void mostrarTablero(int[][] tablero, int lado) {
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++)
				System.out.print(tablero[i][j] + " ");
			System.out.println();
		}
	}

	public static void colocarMinas(int[][] tablero, int lado, int minas) {
		int numMinas = 0;
		while (numMinas != minas) {
			int fila = (int) (Math.random() * lado);
			int columna = (int) (Math.random() * lado);
			if (tablero[fila][columna] == 0) {
				tablero[fila][columna] = MINA;
				numMinas++;
			}
		}
	}
	
	

}
