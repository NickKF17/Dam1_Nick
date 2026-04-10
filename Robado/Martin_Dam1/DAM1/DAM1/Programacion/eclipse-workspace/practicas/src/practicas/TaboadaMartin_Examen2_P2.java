package practicas;
import java.util.*;
public class TaboadaMartin_Examen2_P2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String[] clientes= {"Larry Capija", "Armando Paredes", "Alvin yaquitory", "Jefferson Gutierritos", "Inés Perado","Rubén Todidad","Germán Tequilla"};
		System.out.print("Cuántos premios vas a repartir? ");
		int numPremios= validadorDeNumero(teclado);
		if(numPremios==0) {
			System.out.println("Que codo.");
			
		}
		else if(numPremios>=clientes.length) {
			System.out.printf("Tienes solo %d clientes. Les puedes dar un premio a cada uno.\n",clientes.length);
			if(numPremios>clientes.length) {
				System.out.printf("Te sobran %d premios sin repartir. ¡Guárdalos para el sigueinte sorteo!",(numPremios-clientes.length));
			}
		
		}
		else {
			int[] clientesprem= new int[clientes.length];
		System.out.println("Los afortunados son: ");
		
		int i=0;
				
		while(i<numPremios) {
			int NumAzar= (int)((Math.random()*clientes.length)+1)-1;
			clientesprem[NumAzar]++;
			if(clientesprem[NumAzar]>1) {
				clientesprem[NumAzar]=1;
			}
			else if(clientesprem[NumAzar]<=1) {
				i++;
			}
		}
		int clientsinprem=0;
		for(int j=0; j<clientes.length; j++) {
			if(clientesprem[j]==1)
				System.out.println(clientes[j]);
			if(clientesprem[j]==0) {
				clientsinprem++;
			}
		}
		System.out.println(clientsinprem+" clientes se han quedado sin premio.¡Mucha suerte para el siguiente sorteo!");
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
		if(num<0) {
			System.out.println("Error: El número no puede ser negativo\nVuelve a intentarlo: ");
			todoposi=false;
		}
		}while(todoposi==false);
	
		return num;
	}
}
