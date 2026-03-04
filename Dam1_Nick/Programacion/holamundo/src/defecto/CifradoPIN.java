package defecto;

public class CifradoPIN {
	private String nombre;
	private String apellido;
	private int edad;
	
	public CifradoPIN(String nom, String ape, int ed) {
		this.nombre = nom;
		this.apellido = ape;
		this.edad = ed;
	}
	
	public void incrementaEdad() {
		this.edad++;
	}
	
	public void mostrar() {
		System.out.println(this.apellido +", "+this.nombre);
	}
}
