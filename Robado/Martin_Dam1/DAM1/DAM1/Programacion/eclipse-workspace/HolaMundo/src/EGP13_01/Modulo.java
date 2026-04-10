package EGP13_01;

public class Modulo {
	private String nombre;
	private int year;
	private int nHoras;
	private boolean optativo;

	public Modulo(String n, int y, int h, boolean o) {
		this.nombre = n;
		this.year = y;
		this.nHoras = h;
		this.optativo = o;
	}
	
	public int getCurso() {
		return this.year;
	}
	public String getNombre() {
		return this.nombre;
	}

}
