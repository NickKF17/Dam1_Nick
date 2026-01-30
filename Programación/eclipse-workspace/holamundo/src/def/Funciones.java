package def;

import java.util.Scanner;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class Funciones{

	public static void muestraNumero(int numero) {
		System.out.println(numero);
	}
	public static String creaLinea(int veces,char caracter) {
		String cadena="";
		for (int i=0;i<veces;i++)
			cadena +=caracter;
		return cadena;
	}
	
	public static void main(String[] args) {
		muestraNumero(5);
		int n=6;
		muestraNumero(n);
		String texto =creaLinea(5,'X');
		System.out.println(texto);
		texto = creaLinea(10,'E');
		System.out.println(texto);
	}

	}