package furbo;

class Jugador extends Persona {
	private int dorsal = 0;
	private Equipo equipo = null;

	public Jugador(String nombre) {
		super(nombre);
	}

	public Jugador(String nombre, int numero) {
		super(nombre);
		this.dorsal=numero;
	}

	public Jugador(String nombre, Equipo equipo) {
		super(nombre);
		this.equipo=equipo;
		this.equipo.addPlayer(this);
	}

	public Jugador(String nombre, int numero, Equipo equipo) {
		super(nombre);
		this.dorsal = numero;
		this.equipo = equipo;
		this.equipo.addPlayer(this);

	}

}
