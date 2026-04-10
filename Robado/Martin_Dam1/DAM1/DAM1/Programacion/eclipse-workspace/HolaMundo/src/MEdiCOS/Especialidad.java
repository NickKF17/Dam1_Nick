package MEdiCOS;
import java.util.ArrayList;
import java.util.Collections;
public class Especialidad {
	private String nombre;
	private ArrayList <Medico> medicos= new ArrayList<>();
	
	public Especialidad(String nombre){
		this.nombre=nombre;
	}
	
	public void addMedico(Medico m) {
		medicos.add(m);
	}
	
	public void listarMedicos() {
		System.out.println("\n----------------------------------------------");
		System.out.printf("La lista de médicos de %s son:\n", this.nombre);
		if(medicos.size()==0)
			System.out.println("There's no doctors on this speciality");
		else
			for(Medico m: medicos) {
			
				System.out.printf(" - %s(%d).\n", m.getNombre(), m.getNumCitas());
		}
		System.out.println("----------------------------------------------\n");
		
	}
	public String getNombre(){
		return this.nombre;
	}
	public int numMedicos() {
		return this.medicos.size();
	}
	
	public Medico getMedico() {
		Medico medico= null;
		if(this.medicos.size()==1)
			medico = medicos.get(0);
		else {
			//1. Encontrar el menor numero de citas de los medicos
			int menor = Integer.MAX_VALUE;
			for(Medico m:medicos) {
				if(m.getNumCitas()<menor)
					menor = m.getNumCitas();
			}
			
			//2. Encontrar cuantos medicos tienen ese numero de citas menor
			ArrayList<Medico> medicosConMenosCitas = new ArrayList<>();
			for(Medico m:medicos) 
				if(m.getNumCitas()==menor)
					medicosConMenosCitas.add(m);
			
			//3. Elegir uno de ellos
			Collections.shuffle(medicosConMenosCitas);
			medico = medicosConMenosCitas.get(0);
		}
		return medico;
	}
}
