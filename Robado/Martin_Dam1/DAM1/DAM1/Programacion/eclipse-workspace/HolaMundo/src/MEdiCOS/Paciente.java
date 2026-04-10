package MEdiCOS;
import java.util.HashMap;
class Paciente extends Persona{
	
	private HashMap<String, Medico> listaCitas = new HashMap<>();
	
	public Paciente (String nombre){
		super(nombre);
		
	}
	
	public void pideCita(Especialidad especialidad) {
		int numMedicosEspecialidad = especialidad.numMedicos();
		if(this.listaCitas.containsKey(especialidad.getNombre())) {
			Medico medico = listaCitas.get(especialidad.getNombre());
			System.out.printf("\nEste paciente ya tiene una cita para %s con %s\n", especialidad.getNombre(), medico.getNombre());
	}
		
		else if(numMedicosEspecialidad==0) 
			System.out.printf("No hay medicos para %s", especialidad.getNombre()); 
		else{
			Medico medico = especialidad.getMedico();
			medico.incrementarContadorCitas();
			listaCitas.put(especialidad.getNombre(), medico);
			System.out.printf("Cita asignada para la especialidad de %s con %s\n",especialidad.getNombre(), medico.getNombre());
		}
			
		
	}
	
	
}
