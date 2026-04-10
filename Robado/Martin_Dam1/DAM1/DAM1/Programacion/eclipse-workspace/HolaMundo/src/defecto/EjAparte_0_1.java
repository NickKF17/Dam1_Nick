package defecto;
import java.util.*;
public class EjAparte_0_1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("lanzadordedadoshastaqueseantodosigualesinador versión 1.0");
		System.out.print("Introduce los dados a tirar: ");
		int dados = teclado.nextInt();
		teclado.close();
		boolean tresIguales= false;
		int contador = 0;
		int tandaNumeros[] = new int[dados];
		int estasdisticas[] = new int[6];
		
		do {
		for (int i=0; i<dados; i++) {
			
			int random = (int)(Math.random()*7)+1;
			if (random==7)
				random=6;
			tandaNumeros[i] = random;
			estasdisticas[random-1]++;
			System.out.print(random);
			if(i<dados-1)
				System.out.print(" - ");
			else 
				System.out.println();
			}
		tresIguales=true;
		for(int i=1; i<dados; i++) {
			if(tandaNumeros[0]!=tandaNumeros[i])
				tresIguales=false;
		}
		contador++;
		}while(tresIguales==false);
		for(int i=0; i<6; i++) {
			float porcentaje= (100*(estasdisticas[i])/(float)(contador*dados));
			System.out.printf("El número %d ha salido el %.2f%% de las veces\n",i+1,porcentaje);
		}
	
		
		System.out.println("Ha tomado " + contador + " tiradas para que todos los dados sean iguales.");
	

	}

}
