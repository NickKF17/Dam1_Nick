package EGP15_01;
import java.util.*;
public class CentroMedico {
	private String nombre;
	private String codigo;
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	private ArrayList<Medico> matasanos = new ArrayList<>();
	private ArrayList<Consulta> consultas = new ArrayList<>();
	
	public CentroMedico(String nombre, String codigo) {
		this.nombre= nombre;
		this.codigo= codigo;
	}
	
	public void addMedico(Medico m) {
		matasanos.add(m);
	}
	public void addPaciente(Paciente p) {
		pacientes.add(p);
	}
	public void addConsulta(Consulta c) {
		consultas.add(c);
	}
	public void chanceCenter(CentroMedico cm2, Paciente p) {
		this.pacientes.remove(p);
		cm2.pacientes.add(p);
	}
	public void chanceCenter(CentroMedico cm2, Medico m) {
		this.matasanos.remove(m);
		cm2.matasanos.add(m);
	}
	public String getName() {
		return this.nombre;
	}
	
	public void listarPacientes() {
		System.out.println("----------------------------");
		System.out.printf("Los pacientes del hospital %s son: \n", this.nombre);
		Iterator <Paciente> iterador = pacientes.iterator();
		while(iterador.hasNext()) {
			Paciente p = iterador.next();
			p.mostrar();
		}
		System.out.println("----------------------------");
		System.out.println();
	}
	public void listarMedicos() {
		System.out.println("----------------------------");
		System.out.printf("Los médicos del hospital %s son: \n", this.nombre);
		Iterator <Medico> iterador = matasanos.iterator();
		while(iterador.hasNext()) {
			Medico m = iterador.next();
			m.mostrar();
		}
		System.out.println("----------------------------");
		System.out.println();
	}
}
