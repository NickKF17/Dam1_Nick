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
public String getNombre() {
	return this.nombre;
}

public int getQueBusco() {
	return this.queBusco;
}
public int getEdad() {
	LocalDate hoy =LocalDate.now();
	Period periodo=Period.between(this.fechaNacimiento, hoy);
	return periodo.getYears();
}
public void mostrarDatos(){
	System.out.println("Nombre: "+this.getNombre()+" Edad: "+this.getEdad());
	if (this instanceof Hombre)
		System.out.println("Soy un hombre que busco: ");
	else if (this instanceof Mujer)
		System.out.println("Soy una mujer que busco: ");
	else
			System.out.println("No tengo identidad sexual definida que busco: ");
	
	if(this.queBusco==0)
		System.out.println("A una persona sin importarme su orientacion\n");
	else if(this.queBusco==1)
		System.out.println("a un hombre\n");
	else 
		System.out.println("a una mujer\n");


if (this.edadminima==18 && this.edadmaxima==200)
	System.out.println("No tengo preferencias de edad");
else
	System.out.println("Busco a una persona entre "+this.edadminima+" y "+this.edadmaxima);
}
}
