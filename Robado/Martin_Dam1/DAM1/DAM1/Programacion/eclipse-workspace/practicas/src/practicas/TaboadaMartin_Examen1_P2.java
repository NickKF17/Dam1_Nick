package practicas;
import java.util.*;
public class TaboadaMartin_Examen1_P2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double euCu=27.93;
		double euRu=102.81;
		double euFr=0.93;
		double Euro = 0;
		double Rupia = 0;
		double Cuba = 0;
		double Franco = 0;
		System.out.println("Por favor introduce la divisa que desar transformar: ");
		String monto = teclado.nextLine();
		teclado.close();
		monto.trim();
		String divisa= "";
		String cantidadC = "";
		int posDivisa = monto.length()-1;
		divisa += monto.charAt(posDivisa);
		for(int i= 0; i<posDivisa; i++) {
			cantidadC+= monto.charAt(i);
		}
		double cantidadNum= Double.parseDouble(cantidadC);
		System.out.println(divisa);
		switch(divisa) {
		  case "e":
		  case "E":		
			  	Euro = cantidadNum;
				Cuba = Euro*euCu;
				Rupia = Euro*euRu;
				Franco = Euro*euFr;
				System.out.println(Euro+ "Euros equivalen a:");
				System.out.println(Cuba+" Pesos cubanos");
				System.out.println(Franco+ "Francos suizos");
				System.out.println(Rupia+ "Rupias");
		    break;
		  case "p":
		  case "P":
			    Cuba= cantidadNum;
			    Euro = Cuba/euCu;
			    System.out.println(Cuba+ " Pesos equivalen a:");
			    System.out.println(Euro+ "Euros");
			    break;
			  case "r":
			  case "R":
				  Rupia=cantidadNum;
				    Euro = Rupia/euRu;
				    System.out.println(Rupia+ " Rupias equivalen a:");
				    System.out.println(Euro+ "Euros");
			    break;
			  case "f":
			  case "F":
				  Franco=cantidadNum;
				    Euro = Franco/euFr;
				    System.out.println(Franco+ "Francos equivalen a:");
				    System.out.println(Euro+ "Euros");
				    break;
		}
		System.out.println("Fin del programa");
	}

}
