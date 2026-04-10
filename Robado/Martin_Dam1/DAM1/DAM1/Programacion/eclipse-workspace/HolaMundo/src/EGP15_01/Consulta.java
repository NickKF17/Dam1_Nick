package EGP15_01;
import java.time.LocalDate;

public class Consulta {
	private int codigo;
	private Paciente paciente;
	private Medico medico;
	private LocalDate fecha;
	private String motivo;
	private String consejo;
	
	public Consulta(Paciente p, Medico m, LocalDate fecha, String mot, String conse) {
		this.paciente= p;
		this.medico= m;
		this.fecha=fecha;
		this.motivo=mot;
		this.consejo=conse;
		CentroMedico centro = this.medico.getCentro();
		centro.addConsulta(this);
		p.addConsulta(this);
		m.addConsulta(this);		
	}
	public String getPaciente() {
		return this.paciente.getNombre();
	}
	public String getMedico() {
		return this.medico.getNombre();
	}
	public void mostrarGen() {
		System.out.println("Fecha: "+this.fecha);
		System.out.printf("Motivo: %s\nConsejo: %s\n", this.motivo, this.consejo);
		
	}
}
