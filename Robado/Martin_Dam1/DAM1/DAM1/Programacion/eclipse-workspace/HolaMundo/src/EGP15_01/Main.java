package EGP15_01;
import java.time.*;
public class Main {

	public static void main(String[] args) {
		CentroMedico cm1= new CentroMedico("Gregorio MArañon", "CM-0001");
		CentroMedico cm2= new CentroMedico("Beata", "CM-0002");
		CentroMedico cm3= new CentroMedico("RAmón y Cajañ", "CM-0003");
		
		Paciente p1= new Paciente("Juan Ramón", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p2= new Paciente("Juan", "Díaz", "46068658N", 608553440, cm1);
		Paciente p3= new Paciente("Pepe", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p4= new Paciente("Ramón", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p5= new Paciente("Carlos", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p6= new Paciente("REynaldo", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p7= new Paciente("Andres", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p8= new Paciente("María", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p9= new Paciente("Marta", "Jiménez Díaz", "46068652N", 608553410, cm1);
		Paciente p10= new Paciente("Jimena", "Jiménez Díaz", "46068652N", 608553410, cm1);
		
		Medico m1 = new Medico ("Juan Martin", "Robles Landa", "Neurología", "000001", cm1);
		Medico m2 = new Medico("Ana Lucia", "Gomez Perez", "Cardiología", "000002", cm2);
		Medico m3 = new Medico("Carlos Alberto", "Hernandez Ruiz", "Pediatría", "000003", cm3);
		Medico m4 = new Medico("Maria Fernanda", "Lopez Castro", "Ginecología", "000004", cm1);
		Medico m5 = new Medico("Luis Eduardo", "Martinez Soto", "Traumatología", "000005", cm2);
		Medico m6 = new Medico("Paola Andrea", "Ramirez Flores", "Dermatología", "000006", cm3);
		Medico m7 = new Medico("Jorge Ivan", "Salinas Cruz", "Psiquiatría", "000007", cm1);
		
		
		cm1.listarMedicos();
		System.out.println();
		System.out.println();
		cm3.listarMedicos();
		
		m1.changeCenter(cm3);
		
		cm1.listarMedicos();
		System.out.println();
		System.out.println();
		cm3.listarMedicos();
		
		cm1.listarPacientes();
		
		Consulta cons1= new Consulta(p3, m1,LocalDate.now(), "Lele pancha", "Tome awita");
		Consulta cons11  = new Consulta(p1, m1, LocalDate.now(), "Dolor abdominal", "Tomar agua y reposo");
		Consulta cons2  = new Consulta(p2, m4, LocalDate.now(), "Dolor de cabeza", "Paracetamol cada 8 horas");
		Consulta cons3  = new Consulta(p3, m7, LocalDate.now(), "Fiebre", "Ibuprofeno y reposo");
		Consulta cons4  = new Consulta(p4, m4, LocalDate.now(), "Alergia", "Antihistamínico diario");
		Consulta cons5  = new Consulta(p5, m1, LocalDate.now(), "Dolor de espalda", "Ejercicios y analgésico");
		Consulta cons6  = new Consulta(p6, m4, LocalDate.now(), "Tos persistente", "Jarabe y líquidos");
		Consulta cons7  = new Consulta(p7, m7, LocalDate.now(), "Presión alta", "Control diario y dieta");
		Consulta cons8  = new Consulta(p8, m7, LocalDate.now(), "Gastritis", "Omeprazol en ayunas");
		Consulta cons9  = new Consulta(p9, m1, LocalDate.now(), "Ansiedad", "Terapia y respiración");
		Consulta cons10 = new Consulta(p10, m4, LocalDate.now(), "Dolor muscular", "Reposo y calor local");

		
		//cons1.mostrarGen();
		
		//m1.listarConsultas();
		
		p1.listarConsultas();
		
		//c

		
	}

}
