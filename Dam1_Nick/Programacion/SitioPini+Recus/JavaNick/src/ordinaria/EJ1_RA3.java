package ordinaria;

import java.util.Scanner;

public class EJ1_RA3 {

	public static void main(String[] args) {

		boolean esfeliz=false;
			Scanner teclado= new Scanner(System.in);
			int mayor=0;
			int total=0;
	System.out.println();
				System.out.print("Escribe un número y te dire si es feliz : ");
				String numString=teclado.nextLine();
				String numemio=numString;
				int num1=0;
				int num2=0;
				int num3=0;
				int cont=0;
				int pasos=0;
					int suma=0;
					try {
						num1=Integer.parseInt(numString.substring(0,1));
					do {
						if(numString.length()==2) {
							num1=Integer.parseInt(numString.substring(0,1));
							num2=Integer.parseInt(numString.substring(1));
							
							int cuad1=(num1*num1);
							int cuad2=(num2*num2);
							
							suma=cuad1+cuad2;
						}
							if(numString.length()==3) {
								num1=Integer.parseInt(numString.substring(0,1));
								num2=Integer.parseInt(numString.substring(1,2));
								num3=Integer.parseInt(numString.substring(2));
								int cua1=(num1*num1);
								int cua2=(num2*num2);
								int cua3=(num3*num3);
								
								suma=cua1+cua2+cua3;
							}
				if(suma==1)
					esfeliz=true;
				
					numString=String.valueOf(suma);
						cont++;
					}while(cont<50);
					if(esfeliz==true)
					System.out.println("El numero "+numemio+" es feliz en "+pasos+" pasos");
					
	}catch(Exception e) {
		System.out.println(numString+" no es un entero");
	}
	}

}
