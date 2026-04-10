import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	static final int RANGO_MIN_ANIO_ALEATORIO = 1900;
	static final int RANGO_MAX_ANIO_ALEATORIO = 2022;

	public static void main(String[] args) throws IOException {

		arrayUnidimensional();

		arrayMultidemensional();

	}

	private static void arrayUnidimensional() throws IOException {
		Disco[] listaDiscos = new Disco[5];
		Scanner t = new Scanner(System.in);
		//Se recorre el array desde la posición 0 hasta su número de elementos-1
		for (int i = 1; i < listaDiscos.length; i++) {
			System.out.println("Dime un titulo");
			//Se asigna un valor a cada una de las posiciones del array
			//Se instancia un objeto de la clase Disco con el constructor con parámetros
			//El parametro String nombre se le da valor mediante teclado
			//El parámetro int anioPublicacion se le da un valor aleatorio mediente Math.random entre dos valores que vienen determinados por las cosntantes
			listaDiscos[i] = new Disco(t.nextLine(), (int) (Math.random() * (RANGO_MAX_ANIO_ALEATORIO - RANGO_MIN_ANIO_ALEATORIO + 1) + RANGO_MIN_ANIO_ALEATORIO));
		}

		BufferedWriter writer = null;
		try {
			//Se instancia un objeto de la clase BufferedWriter con el nombre de fichero arrayUnidimensional.txt
			writer = new BufferedWriter(new FileWriter("fichero1.txt"));
			//Se vuelve a recorrer el array, en este caso para imprimir cada uno de sus valores en el fichero
			for (int i = 0; i < listaDiscos.length; i++) {
				//Por cada posición del array se escribe la siguiente linea en el fichero
				//Por cada uno de los valores del array (que son objetos Disco) se recupera (getXXX()) el nombre, el anioPublicacion y el método de calcular anios de diferencia
				writer.write("Nombre disco " + listaDiscos[i].getNombre() //Se recupera el nombre del objeto Disco almacenado en la posicion del array [i]
						 + " Anio publicaon " + listaDiscos[i].getAnioPublicaion()//Se recupera el anioPublicacion del objeto Disco almacenado en la posicion del array [i]
						 + " Diferencia " + listaDiscos[i].calcularAniosPublicacion() + "\n");//Se recupera la diferencia de años del objeto Disco almacenado en la posicion del array [i]

			}
			System.out.println("Fichero creado con exito");

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			//Al terminar el bloque try-catch, se cierra el fichero
			if (writer != null) {
				writer.close();
			}
		}
	}

	/**
	 * Método que no recibe parámetros y no tiene valor de retorno Crea un array de
	 * 2 dimensiones. 2 filas y 2 columnas Pide el nombre de la clase Disco por
	 * teclado El anio de publicación de la clase Disco los asigna con un número
	 * aleatorio entre los valores de las constantes RANGO_MIN_ANIO_ALEATORIO y
	 * RANGO_MAX_ANIO_ALEATORIO
	 * 
	 * Tras grabar los datos en el array, lo escribe en fichero.
	 * @throws IOException
	 */
	private static void arrayMultidemensional() throws IOException {
		Disco[][] listaDiscos = new Disco[2][2];
		Scanner t = new Scanner(System.in);
		//Se recorren las filas del array desde la posición 0 a numeroFilas-1
		for (int i = 0; i < listaDiscos.length; i++) {
			//Se recorren las columnas del array desde la posición 0 a numeroColumnas-1
			for (int j = 0; j < listaDiscos[i].length; j++) {
				System.out.println("Dime un titulo");
				//Se asigna un valor a cada una de las posiciones del array
				//Se instancia un objeto de la clase Disco con el constructor con parámetros
				//El parametro String nombre se le da valor mediante teclado
				//El parámetro int anioPublicacion se le da un valor aleatorio mediente Math.random entre dos valores que vienen determinados por las cosntantes
				listaDiscos[i][j] = new Disco(t.nextLine(), (int) (Math.random() * (RANGO_MAX_ANIO_ALEATORIO - RANGO_MIN_ANIO_ALEATORIO + 1) + RANGO_MIN_ANIO_ALEATORIO));
			}
		}

		BufferedWriter writer = null;
		try {
			//Se instancia un objeto de la clase BufferedWriter con el nombre de fichero arrayMultidimensional.txt
			writer = new BufferedWriter(new FileWriter("fichero2.txt"));
			//Se vuelve a recorrer el array, en este caso para imprimir cada uno de sus valores en el fichero
			for (int i = 0; i < listaDiscos.length; i++) {
				for (int j = 1; j < listaDiscos[i].length; j++) {
					//Por cada posición del array se escribe la siguiente linea en el fichero
					//Por cada uno de los valores del array (que son objetos Disco) se recupera (getXXX()) el nombre, el anioPublicacion y el método de calcular anios de diferencia
					writer.write("Nombre disco " + listaDiscos[i][j].getNombre() //Se recupera el nombre del objeto Disco almacenado en la posicion del array [i][j]
							+ " Anio publicaon " + listaDiscos[i][j].getAnioPublicaion() //Se recupera el anioPublicacion del objeto Disco almacenado en la posicion del array [i][j]
							 + " Diferencia " + listaDiscos[i][j].calcularAniosPublicacion() + "\n"); //Se recupera la diferencia de años del objeto Disco almacenado en la posicion del array [i][j]

				}
			}
			System.out.println("Fichero creado con exito");

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			//Al terminar el bloque try-catch, se cierra el fichero
			if (writer != null) {
				writer.close();
			}
			
		}

	}

}
