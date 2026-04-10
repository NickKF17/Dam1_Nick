package parte2;

public class poo2 {
	public static void main(String[]args) {
		Profesor pr1 = new Profesor("José María", "Morales");
		System.out.println(pr1.getNombre());
		System.out.println(pr1.getNombreCompleto());
		Alumno a1 = new Alumno("Andrés", "Ortega", 20);
		System.out.println(a1.getNombre());
		System.out.println(a1.getNombreCompleto());
		Persona pe1 = new Persona("Jonathan", "Morales");
		System.out.println(pe1.getNombre());
		System.out.println(pe1.getNombreCompleto());
		
		
		
	}

}
