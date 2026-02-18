package def;
import java.util.HashMap;
import java.util.ArrayList;
class Medico extends Persona{
	private Especialidad especialidad;
	private ArrayList<String> nananana = new ArrayList<>();
	private int contadorCitas = 0;
	
	
	public Medico(Especialidad espe, String nombre) {
		super(nombre);
		espe.addMedico(this);
	}
	
	public void incrementarContadorCitas() {
		this.contadorCitas++;
	}
	public int getNumCitas() {
		return contadorCitas;
	}
	
}