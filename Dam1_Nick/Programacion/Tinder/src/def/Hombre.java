package def;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hombre extends Persona{
	public Hombre(Tinder app,String nombre,String nacimiento,int busco) {
		super(nombre,nacimiento,busco);
	app.anyade(this);
	}

	public Hombre(Tinder app,String nombre,String nacimiento,int busco,int minimo, int maximo) {
		super(nombre,nacimiento,busco,minimo,maximo);
		app.anyade(this);
	}
}
