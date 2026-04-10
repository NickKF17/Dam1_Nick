package Bucaminas_1;

public class Casilla {
	private int numero=0;
	private boolean descubierto= false;
	
	public Casilla(int numero, boolean desc) {
		this.numero=numero;
		this.descubierto=desc;
	}
	public static Casilla crearCasilla(int n, boolean s) {
		return new Casilla(n,s);
	}
	
	public int getNumero(){
		return this.numero;
	}
	public boolean getBoolean() {
		return this.descubierto;
	}
	public void setNumero(int num) {
		this.numero=num;
	}
	public void setBoolean(boolean si) {
		this.descubierto=si;
	}
	public boolean isInZona(Casilla casilla) {
		return Zona.getZona(casilla)== Zona.getZona(this);
	}
}