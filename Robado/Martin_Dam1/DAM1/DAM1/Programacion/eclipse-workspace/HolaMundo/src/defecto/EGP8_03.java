package defecto;
import java.util.*;
public class EGP8_03 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("mensajecifradoinador versión 1.0");
		System.out.print("Introduce la frase que se desea cifrar:");
		String frase= teclado.nextLine();
		teclado.close();
		System.out.println("La clave cifrada es: "+cifrado(frase));
		

	}
	static String cifrado(String m) {
		int i=0;
		int j=m.length()-1;
		String clave="";
		while(i<=j) {
			if(i==j)
				clave+=m.charAt(j);
			else {
			clave+=m.charAt(j);
			clave+=m.charAt(i);
			i++;
			j--;
			}
		}
	
		System.out.println(clave);
		return clave;
	}
}
