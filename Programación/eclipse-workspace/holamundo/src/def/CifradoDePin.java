package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class CifradoDePin {

		public static void main(String[] args) {
			Scanner teclado=new Scanner(System.in);
			
			System.out.println("Di tu pin: ");
			int pin = teclado.nextInt();
			if (pin < 0 || pin > 9999)
				System.out.println("Tu pin es negativo o tiene mas de 4 cifras");
			else {
				String[] codigo = cifraPin(pin);
				for (String linea : codigo)
					System.out.println(linea);
			}
			teclado.close();
		}

		public static String[] cifraPin(int pin) {

			String[] codigo = new String[4];
			String txtPin = Integer.toString(pin);
			
			if (txtPin.length() != 4)
				for (int i = txtPin.length(); i < 4; i++)
					txtPin = "0" + txtPin;

			for (int i = 0; i < txtPin.length(); i++) {
				
				int cifra = (int) txtPin.charAt(i) - 48;
				codigo[i]=cifraNumero2(cifra);
			}
			return codigo;
		}

		public static String cifraNumero(int num) {
			String linea = " ";
			if (num == 0)
				num = 10;
			for (int i = 0; i < 10; i++)
				if (i == num - 1)
					linea += "O";
				else
					linea += "X";

			return linea;
		}
		public static String cifraNumero2(int num) {
			String linea = "";
			if (num == 0)
				num = 10;
			for(int i=0; i<num; i++)
				linea+="0";
			for(int i=0;i<10-num;i++)
				linea = "X" + linea;
			
			return linea;
		}

	}
