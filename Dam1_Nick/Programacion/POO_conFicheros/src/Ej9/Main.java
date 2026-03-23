package Ej9;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
	
		File nombrearchivo = new File("Redes.txt");
		String fichero=nombrearchivo.getAbsolutePath();
		String ficheroBinario="Redes.bin";
	Alumno.leerAlumnos(fichero);
	Alumno.procesarNotasAlumnos();
	Alumno.salvarAlumnosBinario(ficheroBinario);

	}

}
