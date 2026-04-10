package defecto;
import java.util.Scanner; 
import java.util.regex.*;
public class EGP2_16 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce el radio de tu circunferencia");
		String radio = teclado.nextLine();
		radio.trim();
		Pattern numero = Pattern.compile("\\d+||^\\d+(\\.\\d+)$");
		Matcher coincidencia = numero.matcher(radio);
		boolean siNum = coincidencia.matches();
		//System.out.println(siNum);
		while(siNum==false) {
			System.out.println("No has introducido un numero");
			System.out.println("Introduce el radio de tu circunferencia");
			radio = teclado.nextLine();
			radio.trim();
			coincidencia = numero.matcher(radio);
			siNum = coincidencia.matches();
		}
		double radioNum = Double.parseDouble(radio);
		double longitud= 2*3.14159265 * radioNum;
		double area = 3.14159265*radioNum*radioNum;
		longitud = Math.round(longitud*100000)/100000.00;
		area = Math.round(area*100000)/100000.00;
		System.out.println("La longitud de la circunferencia es: " + longitud);
		System.out.println("El área del círculo es: " + area);
		
		teclado.close();

	}

}
