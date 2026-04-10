package TaboadaMartin_Examen2Trimestre2;

public class Jugador {
	private boolean activo = true;
	private int numero;
	
	public Jugador(int numero) {
		this.numero=numero;
	}
	
	public boolean getActivo() {
		return this.activo;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setInactivo() {
		this.activo= false;
	}
	
}
