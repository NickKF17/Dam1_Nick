package EGP15_01;

import java.util.ArrayList;

class Medico extends Persona{
	private String especialidad;
	private String colegiado;
	private CentroMedico centro;
	private ArrayList<Consulta> consultas = new ArrayList<>();
	
	public Medico(String fname, String lname, String esp, String colegiado, CentroMedico centro) {
		super(fname,lname);
		this.especialidad=esp;
		this.colegiado=colegiado;
		centro.addMedico(this);
		this.centro=centro;
	}
	public void addConsulta(Consulta c) {
		consultas.add(c);
	}
	
	public void changeCenter(CentroMedico cm2) {
		this.centro.chanceCenter(cm2, this);
	}
	public void mostrar() {
		System.out.printf("Datos del médico:\n - Nombre: %s %s\n - Colegiado: %s\n - Especialidad: %s\nCentro Médico: %s\n\n", this.nombre, this.apellidos, this.colegiado, this.especialidad, this.centro.getName());
	}
	public void mostrarConsultas() {
		for(Consulta c: consultas) {
			System.out.println();
		}
	}
	public void listarConsultas() {
		System.out.printf("Las consultas del médico %s %s son:\n", this.nombre,this.apellidos);
		for(Consulta c : consultas) {
			System.out.printf("Paciente: %s\n", c.getPaciente());
			c.mostrarGen();
		}
	}
	public CentroMedico getCentro(){
		return this.centro;
	}
	public String getNombre() {
		return this.nombre+" "+this.apellidos;
	}
	
}
