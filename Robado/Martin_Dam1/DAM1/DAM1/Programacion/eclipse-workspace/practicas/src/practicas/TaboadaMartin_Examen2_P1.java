package practicas;

import java.util.*;

public class TaboadaMartin_Examen2_P1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Cuántos dados vas a tirar? ");
		int numDados = validadorDeNumero(teclado);
		teclado.close();
		System.out.println(numDados);
		int[] lanzada= new int[numDados];
		int[] conteoNumeros= new int[6];
		int suma= 0;
		int mitad=numDados*3;
		for(int i=0; i<numDados; i++) {
			int NumAzar= (int)(Math.random()*6)+1;
			lanzada[i]= NumAzar;
			if (NumAzar==1) {
				conteoNumeros[NumAzar-1]++; 
			}
			if (NumAzar==6) {
				conteoNumeros[NumAzar-1]++; 
			}
		}
		System.out.println("Has tirado "+numDados+" dados y ha salido lo siguiente: ");
		for(int i=0; i<lanzada.length; i++) {
			System.out.print(lanzada[i]);
			if(i<lanzada.length-1) {
				System.out.print(" ,");
			}
			suma+=lanzada[i];
		
		}
		System.out.println();
		for(int numVeces=0; numVeces<conteoNumeros.length; numVeces++) {
			if(conteoNumeros[numVeces]!=0)
				System.out.println("En "+conteoNumeros[numVeces]+" dados ha salido un "+ (numVeces+1));
		}
		System.out.println("La suma de todos los dados da "+suma);
		if(suma<mitad) {
			System.out.printf("Tu tirada está por debajo de la mitad(%d)",mitad);
		}
		else if(suma==mitad) {
			System.out.printf("Tu tirada es exactamente la mitad(%d)",mitad);
		}
		else {
			System.out.printf("Tu tirada está por encima de la mitad(%d)",mitad);
		}
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
		if(num<1) {
			System.out.println("Error: El número no puede ser negativo o ser un cero\nVuelve a intentarlo: ");
			todoposi=false;
		}}while(todoposi==false);
	
		return num;
	}
}
