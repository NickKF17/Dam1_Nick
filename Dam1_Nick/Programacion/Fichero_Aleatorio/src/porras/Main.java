package porras;

import java.io.RandomAccessFile;

public class Main {
static final int numBoletos=100;
static final int tamanyoNombre=30;
static final int tamanyoRegistro=tamanyoNombre*2;
	public static void main(String[] args) {
	String fichero = "porra.dat";
	try {
	crearFichero(fichero);
	apuestaPorNumero(11,"Pepe",fichero);
	apuestaPorNumero(17,"Nick",fichero);
	/*String ganador=hacerSorteo(fichero);
	if(ganador!=null)
		System.out.println("El ganador o ganadora es: "+ganador);
	*/
	}catch (Exception e) {
		System.out.println("Error: "+e.getMessage());
	}
	

			
	
	
	
	}
	public static void apuestaPorNumero(int num, String nombre, String fichero) throws Exception {
	    try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			
	        long posicion = (num - 1) * tamanyoRegistro;

	        if (num > numBoletos) {
	            System.out.println("El número " + num + " no está disponible");
	        }
	        

	        raf.seek(posicion);

	        // Comprobar si está libre
	        char c = raf.readChar();
	        if (c != '*') {
	            System.out.println("Alguien ya ha cogido ese número");
	            return;
	        }

	        // Volver al inicio del registro
	        raf.seek(posicion);

	        // Escribir nombre con tamaño fijo
	        String nombreFijo = String.format("%-" + tamanyoNombre + "s", nombre);

	        for (int i = 0; i < tamanyoNombre; i++) {
	            raf.writeChar(nombreFijo.charAt(i));
	        }
	    }
	}
	public static  void crearFichero(String fichero) throws Exception {
		try(RandomAccessFile raf=new RandomAccessFile(fichero,"rw")){
			
			for(int i=0;i<=numBoletos;i++)
			raf.writeChar('*');
			
		}	
		
	}

	}

