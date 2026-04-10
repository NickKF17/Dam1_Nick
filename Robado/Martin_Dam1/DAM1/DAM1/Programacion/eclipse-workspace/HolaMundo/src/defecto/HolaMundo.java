
package defecto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HolaMundo {

	public static void main(String[] args) {
		int diasDelMes[] = new int[12];
		Arrays.fill(diasDelMes, 30);
		for (int mes : diasDelMes)
			System.out.print(mes + ", ");
		String texto = Arrays.toString(diasDelMes);
		texto = texto.replace("[", "");
		texto = texto.replace("]", "");
		System.out.println(texto);

	}
}
