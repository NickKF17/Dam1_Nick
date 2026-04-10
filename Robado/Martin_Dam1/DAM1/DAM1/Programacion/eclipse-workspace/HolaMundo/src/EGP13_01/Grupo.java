package EGP13_01;

public class Grupo {
	private String nombre;
	private Ciclo ciclo;
	private Profesor tutor;
	private int curso;
	private int numAlumn;
	private int alumnosMatriculados =0;
	private Alumno[] listaAlumnos;
	
	public Grupo(String nom, Ciclo c, int curso, int numAl){
		this.nombre=nom;
		this.ciclo=c;
		this.curso= curso;
		this.numAlumn=numAl;
		this.listaAlumnos= new Alumno[numAlumn];
		
	}
	public String Nom(){
		return this.nombre;
	}
	public void anyadeTutor(Profesor tutor) {
		this.tutor= tutor;
		tutor.setTutoria(this);
	}
	
	public void anyadeAlumno(Alumno alumno) {
		if(this.numAlumn == this.alumnosMatriculados)
			System.out.println("Grupo completo. Ya hay "+ this.alumnosMatriculados + " alumnos");
		else {
			this.listaAlumnos[this.alumnosMatriculados]=alumno;
			this.alumnosMatriculados++;
		}
	}
	public void verGrupo() {
		System.out.println("nombre del grupo: "+this.nombre);
		System.out.println("Ciclo: "+ this.ciclo.getNombre()+" - Curso: "+this.curso);
		System.out.println("Total alumnos: "+this.numAlumn+" / Alumnos matriculados: "+ this.alumnosMatriculados);
		if (this.tutor!=null)
			System.out.println("Tutor: "+ this.tutor.getNombre());
		else
			System.out.println("no hay tutor we");
		System.out.println("\nLISTADO DE ALUMNOS DEL GRUPO: ");
		for(int i=0; i<this.alumnosMatriculados; i++) {
			System.out.println("- "+this.listaAlumnos[i].getNombre());
		}
		System.out.println("\nLISTADO DE MODULOS DEL GRUPO: ");
		Modulo[] modulos= this.ciclo.getModulos(this.curso);
		int posicion=0;
		Modulo m = modulos[posicion];
		while(m!=null) {
			System.out.println("- "+m.getNombre());
			posicion++;
			m= modulos[posicion];
		}
	}

}
