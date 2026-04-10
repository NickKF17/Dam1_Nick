package EGP13_01;

abstract class Persona {
	protected String nombre;
	protected String apellidos;
	
	public Persona(String nom, String ape) {
		this.nombre=nom;
		this.apellidos=ape;
	}
	
	public void mostrar() {
		System.out.println(this.nombre+" "+this.apellidos);
	}
	
	
}

class Alumno extends Persona{
	private int edad;
	//private String ciclo;
	//private String grupo;
	public Alumno(String nom, String ape, int edad/*, Ciclo c, Grupo g*/) {
		super(nom, ape);
		this.edad=edad;
		//this.ciclo= c.Nom();
		//this.grupo= g.Nom();
	}
	public void mostrar(){
		super.mostrar();
		System.out.println(edad/*+"\n"+ciclo+"\n"+grupo*/);
	}
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}
}

class Profesor extends Persona{
	private Grupo tutoria= null;
	private String departamento;
	public Profesor(String nom, String ape/*, Grupo g*/, String dep) {
		super(nom, ape);
		if(!dep.equalsIgnoreCase("Informática") && !dep.equalsIgnoreCase("Empresa") && !dep.equalsIgnoreCase("Inglés") );
			System.out.println("Error: departamento no válido");
		//this.tutor=g.Nom();
		this.departamento=dep;
	}
	public void setTutoria(Grupo grupo) {
		this.tutoria = grupo;
	}
	public String getNombre() {
		return this.nombre;
	}
	
}
