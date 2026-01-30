package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;


public class ArraysNick {

	public static void main(String[] args) {

		/*
		 * 
		 * int lista[]=new int[6]; String textos[]=new String[10]; int[] vector;
		 * double[] notas= {1,2,3,4,4.5,5,5.5,6,7,8,9,10}; lista[2]=5;
		 * System.out.println(notas[1]); notas[1]=9.2; System.out.println(notas[1]); //2
		 * dimensiones, matrices int[][]matriz=new int [2][3]; matriz[1][2]=99;
		 * System.out.println(matriz[1][2]); System.out.println(matriz[1][1]);
		 * System.out.println(textos[5]);
		 * 
		 * 
		 * String[][] alumnos= {{"Ana","López"},{"Mario","Pérez"},{"Eva","Gutiérrez"}};
		 * System.out.println(alumnos[1][0] + " " + alumnos[1][1]);
		 * 
		 * 
		 */
		/*
		 * double[] notas = {7.5, 6 , 9.4 ,2.5 , 7.5}; String []profesNuevos2 ;
		 * 
		 * //Sumar dos a cada numero del array for(int
		 * posicion=0;posicion<notas.length;posicion++) notas[posicion]+=2; //Encontrar
		 * la longitud del array for(int posicion=0;posicion<notas.length;posicion++)
		 * System.out.println(notas[posicion]);
		 * 
		 * String[] profes = {"Natalia" ,"Victor" , "Eduardo" , "Felix" , "Jose Maria"};
		 * String[] profesNuevos;
		 * 
		 * //si igualamos serian practicamente lo mismo ya que si editas una editas la
		 * otra profesNuevos=profes;
		 * 
		 * for(int i=0;9<profesNuevos.length;i++) System.out.println(profesNuevos[i]);
		 * profesNuevos[3] = "Yago";
		 * 
		 * for(int i=0;i<profesNuevos.length;i++) System.out.println(profesNuevos[i]);
		 * 
		 * for(int i=0;i<profes.length;i++) System.out.println(profes[i]);
		 * 
		 * //Duplicar el array
		 * 
		 * profesNuevos = java.util.Arrays.copyOf(profes,profes.length);
		 * System.out.println(profesNuevos[2]);
		 * 
		 * 
		 * //Comparar dos arrays iguales
		 * 
		 * if(profes.equals(profesNuevos)==true) System.out.println("\n Son iguales");
		 * else System.out.println("\n No son iguales");
		 */

		
		/*
		String[] profes = { "Natalia", "Victor", "Eduardo", "Felix", "Jose Maria" };
		String[] profesNuevos;
		double[] notas = { 7.5, 6, 7.8, 3.4, 2.5 };
profesNuevos=profes;

Arrays.sort(profes);

for (String nombre:profes)
	System.out.println(nombre);

int posicion = Arrays.binarySearch(profes, "Eduardo");
if(posicion>=0 )
	profes[posicion] = "Gerardo";
else System.out.println("No esta en el array");

for (String nombre: profes)
	System.out.println(nombre);

*/
		
		/*
		String[] profes = { "Natalia", "Victor", "Eduardo", "Felix", "Jose Maria" };
		String[] profesNuevos;
		double[] notas = { 7.5, 6, 7.8, 3.4, 2.5 };
profesNuevos=profes;

		
		if (Arrays.binarySearch(profes,"Eduardo")<0) {
			System.out.println("No esta en el array");
		}else System.out.println("Esta en el array");
		
		*/

		
		/*
		String[] profes = { "Natalia", "Victor", "Eduardo", "Felix", "Jose Maria" };
		String[] profesNuevos;
		double[] notas = { 7.5, 6, 7.8, 3.4, 2.5 };
profesNuevos=profes;


		Arrays.sort(notas);
		
		for (double sysoNotas:notas) {
			System.out.println(sysoNotas);
		}
*/
		
	
		/*
		
		int DiadelMes[]= new int[12];
		Arrays.fill(DiadelMes,30);
		
		// for(int DiadelMes)
		//System.out.println(mes + ", ");

	

		String texto = Arrays.toString(DiadelMes);
		texto = texto.replace("[","");
		texto = texto.replace("]","");
		System.out.println(texto);
		
		
		String[] profes = { "Natalia", "Victor", "Eduardo", "Felix", "Jose Maria" , "Yago" };
		String[] profesNuevos;
		double[] notas = { 7.5, 6, 7.8, 3.4, 2.5 };
		
		Arrays.sort(profes);
		String profesores = Arrays.toString(profes);
		profesores = profesores.replace("[","");
		profesores = profesores.replace("]","");
		System.out.println(profesores);
		*/
		
		
		
		
	}}