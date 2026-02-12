
	package def;

	class Jugador extends Persona {
	    private int dorsal;
	    private Equipo equipo;
	    public Jugador(String nombre, int dorsal, Equipo equipo) {
	        super(nombre);
	        this.dorsal = dorsal;
	        this.equipo = equipo;
	        this.equipo.anyadeJugador(this);
	    }
	}

	class Entrenador extends Persona {
	    private Equipo equipo;
	    public Entrenador(String nombre, Equipo equipo) {
	        super(nombre);
	        this.equipo = equipo;
	    }
	}

	class Arbitro extends Persona {
	    public Arbitro(String nombre) {
	        super(nombre);
	    }
	}
