package def;

public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int golesLocal;
	private int golesVisitante;
	public Partido(Equipo equipo1, Equipo equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public void resultado(int goles1, int goles2) {
if (goles1>goles2) {
	equipo1.ganaPartido();
	equipo2.pierdePartido();
}else if (goles2>goles1) {
	equipo1.pierdePartido();
	equipo2.ganaPartido();
}else {
	equipo1.empataPartido();
	equipo2.empataPartido();
}
equipo1.cambiaGoles(goles1,goles2);
equipo2.cambiaGoles(goles2,goles1);

	}
	// Añadir estos métodos a tu clase Partido.java
	public Equipo getEquipo1() { return equipo1; }
	public Equipo getEquipo2() { return equipo2; }

	public String getResumen() {
		if (golesLocal>golesVisitante) {
			equipo1.ganaPartido();
			equipo2.pierdePartido();
		}else if (golesVisitante>golesLocal) {
			equipo1.pierdePartido();
			equipo2.ganaPartido();
		}else {
			equipo1.empataPartido();
			equipo2.empataPartido();
		}
		equipo1.cambiaGoles(golesLocal,golesVisitante);
		equipo2.cambiaGoles(golesVisitante,golesLocal);

	    // Esto requiere que guardes los goles en variables locales en Partido al ejecutar resultado()
	    return equipo1.getNombre() + " [" + golesLocal + " - " + golesVisitante + "] " + equipo2.getNombre();
	    
	}
}
