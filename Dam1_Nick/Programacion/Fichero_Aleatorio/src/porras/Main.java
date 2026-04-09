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

	        if (num < 1 || num > numBoletos) {
	            System.out.println("Número no válido");
	            return;
	        }

	        long pos = (num - 1) * tamanyoRegistro;
	        raf.seek(pos);

	        int estado = raf.readInt();
	        if (estado != 0) {
	            System.out.println("Ese número ya está cogido");
	        }

	        raf.seek(pos);
	        raf.writeInt(num);
	        escribirNombre(raf, nombre);
	    }
	}


	public static void crearFichero(String fichero) throws Exception {
	    try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
	        for (int i = 0; i < numBoletos; i++) {
	            long pos = i * tamanyoRegistro;
	            raf.seek(pos);
	            raf.writeInt(0); // 0 = libre
	            for (int j = 0; j < tamanyoNombre; j++) {
	                raf.writeChar(' ');
	            }
	        }
	    }
	}



	
	public static void leerFichero(String fichero) throws Exception {
	    try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {

	        for (int i = 0; i < numBoletos; i++) {
	            long pos = i * tamanyoRegistro;
	            raf.seek(pos);

	            int numero = raf.readInt();
	            StringBuilder nombre = new StringBuilder();

	            for (int j = 0; j < tamanyoNombre; j++) {
	                nombre.append(raf.readChar());
	            }

	            System.out.println("Boleto " + (i + 1) + ": " +
	                (numero == 0 ? "LIBRE" : nombre.toString().trim()));
	        }
	    }
	}


	
	public static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception {
	    for (int i = 0; i < tamanyoNombre; i++) {
	        if (i < nombre.length()) {
	            raf.writeChar(nombre.charAt(i));
	        } else {
	            raf.writeChar(' ');
	        }
	    }
	}

}
