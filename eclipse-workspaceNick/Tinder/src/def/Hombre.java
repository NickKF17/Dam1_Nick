package def;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hombre extends Persona{
	public Hombre(String nombre,String nacimiento,int busco) {
		super(nombre,nacimiento,busco);
	
	}

	public Hombre(String nombre,String nacimiento,int busco,int minimo, int maximo) {
		super(nombre,nacimiento,busco,minimo,maximo);
	}
}
