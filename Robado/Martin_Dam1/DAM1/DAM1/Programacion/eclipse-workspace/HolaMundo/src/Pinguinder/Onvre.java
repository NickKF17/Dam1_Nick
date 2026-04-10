package Pinguinder;

class Onvre extends Persona{
	public Onvre(Guinder g, String nombre,String nacimiento, int busco) {
		super(g, nombre,nacimiento,busco);
		g.anyade(this);
		
	}
	
	public Onvre(Guinder g, String nombre,String nacimiento, int busco, int minimo, int maximo) {
		super(g, nombre,nacimiento,busco, minimo, maximo);
		g.anyade(this);
	}


}
