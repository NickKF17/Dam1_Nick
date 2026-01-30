package def;

import java.util.Scanner;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class Split {

	public static void main(String[] args) {
		/*
		 * String texto1="Examen 1T01"; String texto2="Octubre-2025";
		 * 
		 * String[] elementos1= texto1.split(" ");
		 * 
		 * for (String elemento:elementos1) System.out.println(elemento);
		 * 
		 * String[] elementos2= texto2.split("-");
		 * 
		 * for (String elemento:elementos2) System.out.println(elemento);
		 * 
		 * String resultado = elementos1[1] + "-" + elementos2[1] + " " + elementos1[0]
		 * + " " + elementos2[0];
		 * 
		 * System.out.println(resultado + " (" + resultado.length() + ")");
		 */
		/*
		 * 
		 * String texto1
		 * ="En un lugar de         la Mancha    cuyo   nombre  no quiero"; String[]
		 * palabras = texto1.split("[ ]+"); String fraseCorrecta="";
		 * 
		 * for (String palabra:palabras) fraseCorrecta = fraseCorrecta + palabra + " ";
		 * fraseCorrecta=fraseCorrecta.trim(); System.out.println(fraseCorrecta);
		 */

		/*
		 * System.out.println("Esto va en una linea \nY esto en la de abajo"); String
		 * nombre="Nick"; String apellidos="Constante Santos"; int edad = 57; double
		 * salario = 1345.678;
		 * 
		 * System.out.printf("Tu nombre es %s, %s tienes %d y cobras %.2f euros \n",
		 * apellidos, nombre, edad , salario);
		 * 
		 * System.out.println("Fin del programa");
		 * 
		 * int n1 = 345; int n2 = 1245; int n3= 2; int n4= 32;
		 * 
		 * System.out.printf("Ingresos:\n%5d€\n%5d€\n%5d€\n%5d€\n", n1,n2,n3,n4);
		 * System.out.printf("Ingresos:\n%-5d€\n%-5d€\n%-5d€\n%-5d€\n", n1,n2,n3,n4);
		 * System.out.printf("Ingresos:\n%05d€\n%05d€\n%05d€\n%05d€\n", n1,n2,n3,n4);
		 * 
		 * double d1=345.12; double d2=-1245.1; double d3=2.0; double d4=-32.3456;
		 * 
		 * System.out.printf("Ingresos:\n%+9.3f€\n%+9.3f€\n%+9.3f€\n%+9.3f€ \n", d1,d2,
		 * d3,d4); //El + hace que aparezca el mas en los que son positivos, si pones un
		 * ( en su lugar los negativos seran impresos entre parentesis
		 * 
		 * System.err.printf("Ingresos:\n%+9.3f€\n%+9.3f€\n%+9.3f€\n%+9.3f€ \n", d1,d2,
		 * d3,d4);
		 */

		/*
		 * 
		 * double pi=3.141592653; double e= 2.71828;
		 * 
		 * Scanner teclado= new Scanner(System.in);
		 * System.out.print("Cuantos caracteres van a haber"); String
		 * ocupa=teclado.nextLine(); System.out.print("Cuantos decimales van a haber");
		 * String decimales=teclado.nextLine();
		 * 
		 * String formato="%"+ocupa+"."+decimales+"f€\n"; formato= formato+"\n"+formato;
		 * System.out.printf(formato,pi,e);
		 */

		/*
		 * Scanner teclado = new Scanner(System.in);
		 * System.out.println("¿Cuantos dados quieres que se lancen?"); int dados=
		 * teclado.nextInt(); int numeros []= new int[dados]; int random; int tiradas=0;
		 * int contador []=new int[7]; boolean iguales=false; do { tiradas++; for(int
		 * i=0;i<dados;i++) { random=(int) (Math.random()*7)+1; if (random==7) {
		 * random=6; } numeros[i]= random; contador[random]++;
		 * 
		 * System.out.print(random); if (i<dados-1) { System.out.print("-");}}
		 * System.out.println(); iguales=true; for (int j=0;j<dados;j++) {
		 * if(numeros[0]!=numeros[j]) iguales=false; } }while (iguales==false);
		 * System.out.println("Has necesitado " + tiradas +
		 * " tiradas para que salgan iguales"); System.out.println();
		 * 
		 * for(int i=1;i<7;i++) { double porcentaje=(100.0*contador[i])/(dados*tiradas);
		 * System.out.printf("El numero %d ha salido el %.2f %% de las veces \n",i,
		 * porcentaje); }
		 */

		Scanner teclado = new Scanner(System.in);
		double importe=0;
		int personas=0;
		try {
		System.out.println("Cuanto ha costado la cena");
		importe = teclado.nextDouble();
		System.out.println("Cuantas persona habeis ido?");
		 personas = teclado.nextInt();
		}catch(Exception e) {
			System.out.println("Ha ocurrido un error");
		}
		finally {
			System.out.println("Se ejecuta siempre haya o no haya error");
		}
		teclado.close();
		if(importe!=0 && personas !=0) {
		System.out.printf("Tocais a %.2f por persona", importe / personas);
		}
		else System.out.println("Ni el importe ni las personas puede ser 0");
	}
}
