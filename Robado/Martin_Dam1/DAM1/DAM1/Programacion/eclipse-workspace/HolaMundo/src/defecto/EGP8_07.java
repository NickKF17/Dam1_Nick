package defecto;
import java.util.*;
import java.util.regex.*;
public class EGP8_07 {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		String numero= validacion(teclado);
		if(comprobadorNarcisista(numero)==true)
			System.out.println("Es un  número narcicista.");
		else
			System.out.println("No es un número narcisista.");
		
	}
	static String validacion(Scanner teclado) {
		String num= "";
		boolean si= false;
		Pattern patron= Pattern.compile("\\d+");
		while(si==false) {
			num=teclado.nextLine();
			Matcher coincidencia= patron.matcher(num);
			si=coincidencia.matches();
			if (si==false)
				System.out.println("Entrada incorrecta, tienes que introducir un número\nVuelve a intentarlo:");
		}
		
		return num;
	}
	static boolean comprobadorNarcisista(String numero) {
		int suma=0;
		int exponente = numero.length();
		boolean si= false;
		for(int i=0; i<numero.length(); i++) {
			//int n= numero.charAt(i)-'0';-->Esto se hace por la codificaciòn ascii de los numeros, tambien se puede restar por 48, porque es el còdigo ascii del 0
			int n= Character.getNumericValue(numero.charAt(i));
			suma+=Math.pow(n, exponente);
		}
		if(suma==Integer.parseInt(numero))
			si=true;
		return si;
	}
}
