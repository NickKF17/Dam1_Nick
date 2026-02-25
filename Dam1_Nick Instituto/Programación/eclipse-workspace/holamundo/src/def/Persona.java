package def;

public class Persona {

private String nombre;
private String apellido;
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
