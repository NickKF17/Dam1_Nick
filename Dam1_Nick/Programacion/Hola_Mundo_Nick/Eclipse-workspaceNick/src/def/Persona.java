package def;

public class Persona {

protected String nombre;
protected String apellido;
private int edad;
private static int  numPersonas=0;

public Persona(String nom,String ape) {
	this.nombre=nom;
	this.apellido=ape;
	numPersonas++;
}
public int getnumPersonas() {
	return numPersonas++;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String Nombre) {
	this.nombre=nombre;
}

public String getNombreCompleto() {
	return nombre + " "+ this.apellido;
}
public static int getNumPersonas() {
	return numPersonas;
}
public static void setNumPersonas(int numPersonas) {
	Persona.numPersonas = numPersonas;
}
public Persona(String nom,String ape, int edad) {
	this.nombre=nom;
	this.apellido=ape;
	this.edad=edad;
	numPersonas++;
}

public void incrementaEdad() {
	this.edad++;

}
public void mostrar() {
	System.out.println(this.apellido+", "+this.nombre + "("+edad+")");
}

}
class Profesor extends Persona{
	public Profesor(String nom,String ape) {
		super(nom,ape);
	}
	public String getNombreCompleto() {
		return "Señor Don " + super.getNombreCompleto();
	}
	
}
class Alumno extends Persona{
	private int edad2;
	public Alumno(String nom,String ape,int edad) {
		super(nom,ape);
		this.edad2=edad;
		
	}
}
