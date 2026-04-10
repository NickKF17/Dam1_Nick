package defecto;

import java.util.*;

public class EGP5_4 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe una frase: ");
		String entrada = teclado.nextLine();
		teclado.close();
		String[] lista = entrada.split(" ");
		int contador =0;
		for(String palabra:lista)
			//System.out.println(palabra);
			if(tieneCuatrooMasVocales(palabra))
					contador++;
		System.out.println("Hay "+contador + " palabras con 4 o mas vocales diferentes");	

	}
	
	public static boolean tieneCuatrooMasVocales(String p) {
		int cuentaVocales = 0;
		boolean tieneCuatroVocales = false;
		String[] letras = {"a","e","i","o","u"};
		for(String letra:letras)
			cuentaVocales+=buscaLetra(p,letra);
		if(cuentaVocales>=4)
			tieneCuatroVocales= true;
		return tieneCuatroVocales;
	}
	
	public static int buscaLetra (String p, String l) {
		int hayLetra = 1;
		if(p.indexOf(l)==-1)
			hayLetra =0;
		return hayLetra;
	}
	

}
