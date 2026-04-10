
package MEdiCOS;

public class Main {

	public static void main(String[] args) {
		Especialidad especialidad1= new Especialidad("Traumatología");
		Especialidad especialidad2 = new Especialidad("Urología");
		Especialidad especialidad3 =  new Especialidad("Dermatología");
		Especialidad especialidad4 = new Especialidad("Oftanmología");
		
		Medico medico1 = new Medico (especialidad1, "Jorge Pérez");
		Medico medico2 = new Medico (especialidad1, "Ana López");
		Medico medico3 = new Medico (especialidad3, "Elena García");
		
		Paciente paciente1 = new Paciente("Antonio Costa");
		Paciente paciente2 =  new Paciente("Inés Rodrigo");
		
		especialidad1.listarMedicos();
		especialidad2.listarMedicos();
		especialidad3.listarMedicos();
		especialidad4.listarMedicos();
		
		/*
		paciente1.pideCita(especialidad3);
		paciente1.pideCita(especialidad1);
		paciente2.pideCita(especialidad2);
		paciente2.pideCita(especialidad1);
		paciente2.pideCita(especialidad1);
		*/

	}

}
