package def;

import java.util.Scanner;

public class cases {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
	/*	
	
		System.out.println("Escribe un numero del 2 al 4: ");
		int numero=teclado.nextInt();
		
		
		switch(numero) {
		case 2:
			System.out.println("Es un patito feo");
			break;
		case 3:
			System.out.println("Es una serpiente");
			break;
		case 4:
		case 6:
			System.out.println("Es una silla o un globito");
			break;
		default:
			System.out.println("No se que es ese numero");
			}
			
			*/
		
			
			
	System.out.println("Pulsa una letra, P para jugar , C para configurar o X para salir: ");
			String texto=teclado.nextLine();
			
			
	switch(texto) {
			case "p":
			case "P":
				System.out.println("Vamos a jugar, Partida nueva");
				break;
			case "c":
			case "C":
				System.out.println("Entrando en la configuracion");
				break;
			case "x":
			case "X":
				System.out.println("Hasta la proxima");
				break;
			default:
				System.out.println("Esa letra no hace nada");
		}
	}}