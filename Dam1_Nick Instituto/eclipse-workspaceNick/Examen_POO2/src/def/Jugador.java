package def;
import java.util.*;

public class Jugador {
	private int codigo=0;
	private Juego juego;

	private boolean activo;
	public Jugador(int codigo) {
this.codigo=codigo;

	}
	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}
public int getCodigo() {
	return this.codigo;
}
public void eliminarJugadores() {
	this.activo=false;

}
}
