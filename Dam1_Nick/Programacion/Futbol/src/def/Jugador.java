package def;

 class Jugador extends Persona{
	 private int Dorsal=0;
	 private Equipo equipo=null;
public Jugador(String nombre,int dorsal,Equipo equipo) {
	super(nombre);
	this.Dorsal=dorsal;
	this.equipo=equipo;
	
	this.equipo.anyadeJugador(this);
}
public Jugador(String nombre) {
	super(nombre);
}
}
