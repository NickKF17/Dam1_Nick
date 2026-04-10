package defecto;
import java.util.*;
public class EGP5_6 {

	public static void main(String[] args) {
		String numero = "0524325498435489434478";
		int[] contador= new int[10];
		for(int n=0; n<numero.length(); n++) {
			String cifra = ""+numero.charAt(n);
			int posicion = Integer.parseInt(cifra);
			contador[posicion]+=1;
		}
			for(int n=0; n<contador.length; n++) {
				if(contador[n]!=0)
					System.out.println("la cifra "+ n + " aparece " + contador[n] + " veces");
			}

	}

}
