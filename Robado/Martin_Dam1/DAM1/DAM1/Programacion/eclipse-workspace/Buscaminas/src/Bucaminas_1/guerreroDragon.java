package Bucaminas_1;

import java.util.*;

public class guerreroDragon {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int lados = 0;
		int minas = 0;
		boolean perdiste = false;
		System.out.println("Buscaminasinador versión 1.0");
		System.out.println("Tell me, de cuantos lados será tu tablero?: ");
		lados = validadorLados(teclado);
		System.out.println(lados);
		System.out.println("Now, dime cuántas minas tendrá tu tablero: ");
		minas = validadorMinas(teclado, lados);
		System.out.println(minas);
		// Hay que moverlo cuando hagamos otras cosillas

		Tablero tablos = new Tablero(lados, minas);
		System.out.println("--------------");
		tablos.colocarMina();
		tablos.mostrarTablero();
		System.out.println("--------------");
		System.out.println("Creando tablero...");
		tablos.mostrarTableroSec();
		//tablos.mostrarTablero2();
		System.out.println();
		tablos.contadorMinas();
		System.out.println();
		tablos.creadorDeZonas();
		//tablos.mostrarTablero();
		//tablos.mostrarTablero2();
		tablos.mostrarTableroSec();
		tablos.mostrarTablero();
		while (perdiste == false) {
			System.out.println("Elige donde no hay minas...");
			System.out.println("Elige la fila: ");
			int fila = validadorFilCol(teclado);
			System.out.println("Ahora elige la columna: ");
			int columna = validadorFilCol(teclado);
			perdiste = tablos.HayMinas(fila, columna);
			if(perdiste==false) {
				tablos.seguirJugando(fila,columna);
				tablos.mostrarTableroSec();
			}
			else  {
				System.out.println("perdiste we");
				tablos.mostrarTablero();
			}
			
		}
		teclado.close();
		
	}

	public static int validadorLados(Scanner teclado) {
		int lado = 0;
		boolean si = false;
		while (si == false) {
			while (si == false) {
				si = true;
				try {
					lado = teclado.nextInt();
				} catch (Exception e) {
					System.out.println("Error: dame un número:");
					teclado.nextLine();
					si = false;
				}
			}
			if (lado == 0) {
				System.out.println("No puedo crear un tablero de 0 lados...\nVuelve a intentarlo: ");
				si = false;
			} else if (lado <= 0) {
				System.out.println("No puedo crear un tablero de lados negativos...\nVuelve a intentarlo: ");
				si = false;
			}
		}
		return lado;
	}

	public static int validadorMinas(Scanner teclado, int l) {
		int minas = 0;
		boolean si = false;
		while (si == false) {
			while (si == false) {
				si = true;
				try {
					minas = teclado.nextInt();
				} catch (Exception e) {
					System.out.println("Bro, dame un número pls:");
					teclado.nextLine();
					si = false;
				}
			}
			if (minas < 0) {
				System.out.println("No puedo poner minas de signos negativos\nVuelve a intentarlo: ");
				si = false;
			} else if (minas == 0) {
				System.out.println("noooooooo, te gusta el pedazo!\nVuelve a intentarlo: ");
				si = false;
			} else if (minas >= l * l) {
				System.out.println(
						"No puedo poner mas minas que el número total del área del lado\nVuelve a intentarlo: ");
				si = false;
			}
		}
		return minas;

	}

	public static int validadorFilCol(Scanner teclado) {
		int FilCol = 0;
		boolean si = false;
		while (si == false) {
			while (si == false) {
				si = true;
				try {
					FilCol = teclado.nextInt();
				} catch (Exception e) {
					System.out.println("Error: dame un número:");
					teclado.nextLine();
					si = false;
				}
			}

			 if (FilCol < 0) {
				System.out.println("No puedo seleccionar filas/columnas negativas...\nVuelve a intentarlo: ");
				si = false;
			}
		}
		return FilCol;
	}
}
