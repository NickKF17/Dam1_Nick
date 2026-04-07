package porras;

import java.io.RandomAccessFile;

public class Main {
	static final int numBoletos = 10;
	static final int tamanyoNombre = 30;
	static final int tamanyoRegistro = (tamanyoNombre * 2) + 4;

	public static void main(String[] args) {
		String fichero = "porra.dat";
		try {
			crearFichero(fichero);
			apuestaPorNumero(1, "Pepe", fichero);
			apuestaPorNumero(7, "Nick", fichero);
			/*
			 * String ganador=hacerSorteo(fichero); if(ganador!=null)
			 * System.out.println("El ganador o ganadora es: "+ganador);
			 */
			leerFichero(fichero);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void apuestaPorNumero(int num, String nombre, String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long posicion = (num - 1) * tamanyoRegistro;

			if (num > numBoletos) {
				System.out.println("El número " + num + " no está disponible");
			} else {
				raf.seek(posicion);
				// Comprobar si está libre
				char c = raf.readChar();
				if (c != '*') {
					System.out.println("Alguien ya ha cogido ese número");
				} else {
					raf.seek(posicion);
					raf.writeInt(num);
					escribirNombre(nombre, fichero);
				}
			}
		}
	}

	public static void crearFichero(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {

			for (int i = 0; i <= numBoletos; i++) {
				long posi = (i * tamanyoRegistro);
				raf.seek(posi);
				raf.writeChar('*');
				/*
				 * for(int j=0;j<tamanyoRegistro-1;j++) { raf.writeChar(' ');
				 * 
				 * }
				 */
			}
		}

	}

	public static void leerFichero(String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			String resultado = "";
			for (int i = 0; i < tamanyoRegistro; i++) {
				resultado += raf.readChar();
			}
			// .trim() quita los espacios que añadimos al final
			System.out.println("Nombre: " + resultado.trim());

		}
	}

	public static void escribirNombre(String nombre, String fichero) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			for (int i = 0; i < tamanyoRegistro - 4; i++) {
				if (i < nombre.length()) {
					raf.writeChar(nombre.charAt(i));
				} else {
					raf.writeChar(' '); // Relleno para completar los 40 bytes
				}
			}

		}
	}
}
