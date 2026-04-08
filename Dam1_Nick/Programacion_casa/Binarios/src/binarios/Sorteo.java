package binarios;


	import java.io.*;

	public class Sorteo {

	    public static void main(String[] args) {
	        String archivo = "apuestas.dat";

	        // Creamos el archivo con 10 huecos disponibles
	        crearArchivo(archivo, 10);

	        // Hacemos apuestas
	        hacerApuesta(archivo, "Paco", 5);
	        hacerApuesta(archivo, "Lucia", 3);
	        
	        // Intentamos una que ya existe
	        hacerApuesta(archivo, "Pepe", 5);
	    }

	    // MÉTODO 1: Crea el archivo binario inicial
	    public static void crearArchivo(String nombre, int cantidad) {
	        try {
	            RandomAccessFile raf = new RandomAccessFile(nombre, "rw");
	            raf.setLength(0); // Borra lo que hubiera antes

	            for (int i = 1; i <= cantidad; i++) {
	                raf.writeUTF("*"); // El asterisco indica que está libre
	                raf.writeInt(i);   // El número de la apuesta
	            }
	            raf.close();
	            System.out.println("Archivo creado con " + cantidad + " números libres.");
	        } catch (IOException e) {
	            System.out.println("Error al crear.");
	        }
	    }

	    // MÉTODO 2: Realiza la apuesta leyendo el archivo
	    public static void hacerApuesta(String nombreArchivo, String nombrePersona, int numElegido) {
	        try {
	            RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw");
	            boolean encontradoYLibre = false;
	            
	            // Leemos todo el archivo para comprobar
	            while (raf.getFilePointer() < raf.length()) {
	                // Guardamos la posición justo ANTES de leer para poder volver ahí luego
	                long posicionInicio = raf.getFilePointer(); 
	                
	                String nombreLeido = raf.readUTF();
	                int numLeido = raf.readInt();

	                if (numLeido == numElegido) {
	                    if (nombreLeido.equals("*")) {
	                        // Si es un asterisco, volvemos atrás para escribir el nombre real
	                        raf.seek(posicionInicio);
	                        raf.writeUTF(nombrePersona);
	                        raf.writeInt(numElegido);
	                        
	                        System.out.println("Apuesta realizada: " + nombrePersona + " se queda el " + numElegido);
	                        encontradoYLibre = true;
	                    } else {
	                        System.out.println("Lo siento, el " + numElegido + " ya es de " + nombreLeido);
	                        encontradoYLibre = true; // Lo marcamos como "encontrado" para que no salte el error de abajo
	                    }
	                    break; 
	                }
	            }

	            if (!encontradoYLibre) {
	                System.out.println("Ese número no existe en el sistema.");
	            }

	            raf.close();
	        } catch (IOException e) {
	            System.out.println("Error en la apuesta.");
	        }
	    }
	}

