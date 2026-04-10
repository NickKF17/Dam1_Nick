package EGP13_01;

public class idk {

	public static void main(String[] args) {
		Modulo programacion = new Modulo("Programacion", 8, 1, false);
		Modulo bases = new Modulo("Bases de datos", 6, 1, false);
		Modulo Sist = new Modulo("Sistemas informáticos", 6, 1, false);
		Modulo fund = new Modulo("Fundamentos de programacion", 2, 1, true);
		Modulo progPhy = new Modulo("Programacion en Phyton", 8, 2, false);
	
		Ciclo c1= new Ciclo("DAM", 2);
		c1.anyadeModulo(programacion);
		c1.anyadeModulo(progPhy);
		c1.anyadeModulo(fund);
		c1.anyadeModulo(Sist);
		c1.anyadeModulo(bases);
		
		
		Grupo g1 = new Grupo("DAM1",c1,2,4);
		
		Alumno A1= new Alumno("Juan", "Perez", 19);
		Alumno A2= new Alumno("ssss","sdawd",20);
		Alumno A3= new Alumno("aaaa","eeeee",18);
		
		Profesor p1= new Profesor("Alvin", "De la Concepcion",  "Informática");
		
		
		A1.mostrar();
		p1.setTutoria(g1);
		g1.anyadeTutor(p1);
		g1.anyadeAlumno(A1);
		g1.anyadeAlumno(A1);
		g1.anyadeAlumno(A1);
		g1.anyadeAlumno(A1);
		g1.verGrupo();
	

	}

}
