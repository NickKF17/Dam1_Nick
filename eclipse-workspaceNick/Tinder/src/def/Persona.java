package def;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public abstract class Persona {
protected String nombre;
protected LocalDate fechaNacimiento;
protected int edadminima=18;
protected int edadmaxima=200;
protected int queBusco; // 0 - no me importa 1 - Hombres 2 - Muyeres
public Persona(String nombre,String nacimiento,int busco) {
	this.nombre=nombre;
	this.queBusco=busco;
	DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	this.fechaNacimiento= LocalDate.parse(nacimiento,formato);
	
}

public Persona(String nombre,String nacimiento,int busco,int minimo, int maximo) {
	this(nombre,nacimiento,busco);
	if (minimo>18)
		this.edadminima=minimo;
	this.edadmaxima=maximo;
}
}
