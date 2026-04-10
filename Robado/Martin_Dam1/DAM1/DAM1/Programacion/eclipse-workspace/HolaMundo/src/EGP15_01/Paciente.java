package EGP15_01;
import java.util.ArrayList;
class Paciente extends Persona{
	private String dni;
	private int tel;
	private CentroMedico centro;
	private ArrayList<Consulta> consultas = new ArrayList<>();
	
	public Paciente(String fname, String lname, String dni, int tel, CentroMedico centro) {
		super(fname, lname);
		this.dni=dni;
		this.tel=tel;
		this.centro=centro;
		centro.addPaciente(this);
		
	}
	public void listarConsultas() {
		System.out.println("----------------------------------");
		System.out.printf("Las consultas del médico %s %s son:\n", this.nombre,this.apellidos);
		for(Consulta c : consultas) {
			System.out.printf("Médico: %s\n", c.getMedico());
			c.mostrarGen();
		}
		System.out.println("----------------------------------");
	}
	public void changeCenter(CentroMedico cm2) {
		this.centro.chanceCenter(cm2, this);
		this.centro= cm2;
	}
	public String getNombre() {
		return this.nombre+" "+this.apellidos;
	}
	
	public void mostrar() {
		System.out.printf("Datos del paciente:\n - Nombre: %s %s\n - DNI: %s\n - Numero de telefono: %d \nCentro medico: %s\n\n\n",  this.nombre, this.apellidos, this.dni, this.tel, this.centro.getName());
	}
	public void addConsulta(Consulta c) {
		consultas.add(c);
	}
}
