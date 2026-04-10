package defecto;

public class EGP1_22 {

	public static void main(String[] args) {
		boolean esPrimo7u7;
		int azar;
		do {
			azar = (int)(Math.random()*400000000+1)+1000000000;
			esPrimo7u7=true;
			int raiz = (int)Math.sqrt(azar)+1;
			System.out.println("Probando el número" + azar + "...");
			if (azar%2 == 0)
				esPrimo7u7 = false;
			for (int divisor=3; divisor<raiz && esPrimo7u7 == true;  divisor+=2)
				if (azar%divisor==0)
					esPrimo7u7 = false;
		}while(esPrimo7u7==false);
		System.out.println("El número "+ azar + " es primo");
		
	}

}
