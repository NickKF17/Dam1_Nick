package parte2;

abstract class Persona {
	// El private hace que los datos no se puean manipular de forma directa
	protected String nombre;
	protected String apellidos;

	public Persona(String nom, String ape) {
		this.nombre = nom;
		this.apellidos = ape;
	}
	//abstract void funcionObligatoria(int x);

	public void mostrar() {
		System.out.println(this.apellidos + ", " + this.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCompleto() {
		return this.nombre + " " + this.apellidos;
	}
}

class Profesor extends Persona {
	public Profesor(String nom, String ape) {
		super(nom, ape);
	}

	public String getNombreCompleto() {
		return "Señor Don " + super.getNombreCompleto();
	}
}

class Alumno extends Persona {
	private int edad;

	public Alumno(String nom, String ape, int edad) {
		super(nom, ape);
		this.edad = edad;

	}
}