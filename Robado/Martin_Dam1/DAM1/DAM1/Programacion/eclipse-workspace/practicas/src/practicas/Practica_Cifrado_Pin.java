package practicas;

import java.util.*;

public class Practica_Cifrado_Pin {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int num = 0;
		boolean siNum = true;
		try {
			num = teclado.nextInt();
			teclado.close();
		} catch (Exception e) {
			System.out.println("No has escrito un número.");
			siNum = false;
		}
		if (siNum == true) {

			String numcad = String.valueOf(num);
			if (num>=0&&num<=999) {
				numcad = funcion3(numcad);
				String[] cifrado = funcion2(numcad);
				for (String nose : cifrado) {
					System.out.println(nose);
				}
			} else
				System.out.println("La clave solo tiene que tener 4 digitos y tampoco puede ser negativa: ");

		}

	}

	static String funcion1(int n) {
		String[] tuplaxd = new String[10];
		String tuplaxds = "";
		Arrays.fill(tuplaxd, "X");
		if (n != 0)
			tuplaxd[n - 1] = "O";
		else
			tuplaxd[9] = "O";
		for (int i = 0; i < tuplaxd.length; i++)
			tuplaxds += tuplaxd[i];
		return tuplaxds;
	}

	static String[] funcion2(String XO) {
		String[] cifrado = new String[4];
		for (int j = 0; j < XO.length(); j++) {
			for (int i = 0; i < cifrado.length; i++) {
				String pos = "";
				pos += XO.charAt(j);
				cifrado[j] = funcion1(Integer.parseInt(pos));
			}
		}
		return cifrado;
	}

	static String funcion3(String clave) {
		String claveBien = "";
		int numCeros = 4 - clave.length();
		if (numCeros != 0) {
			for (int i = 0; i < numCeros; i++) {
				claveBien += "0";
			}
		}
		claveBien += clave;
		return claveBien;
	}

}
