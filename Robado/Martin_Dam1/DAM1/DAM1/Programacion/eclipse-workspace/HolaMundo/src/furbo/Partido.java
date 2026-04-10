package furbo;

public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo ganador;
	
	public Partido(Equipo equipo1, Equipo equipo2) {
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		
		int goles1 = (int)(Math.random()*(4-1+1)+1);
		int goles2 = (int)(Math.random()*(4-1+1)+1);
		
		equipo1.añadeGoles(goles1, goles2);
		equipo2.añadeGoles(goles2, goles1);
		
		if(goles1>goles2)
			this.ganador = equipo1;
		else if(goles2>goles1)
			this.ganador = equipo2;
		else
			this.ganador = null;
		
		if(this.ganador==equipo1)
			equipo1.añadePuntos(3);
		else if(this.ganador==equipo2)
			equipo2.añadePuntos(3);
		else {
			equipo1.añadePuntos(1);
			equipo2.añadePuntos(1);
		}
		
		
	}
}
