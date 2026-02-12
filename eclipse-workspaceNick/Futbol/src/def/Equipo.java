package def;

import java.util.HashSet;

public class Equipo {
private String nombre;
private Entrenador entrenador;
private HashSet<Jugador>plantilla=new HashSet<>();
private int ganados=0;
private int perdidos=0;
private int golesAfavor=0;
private int golesEncontra=0;
private int puntos=0;
private int empatados=0;


public Equipo(String nombre){
	this.nombre=nombre;
}
public void setEntrenador(Entrenador entrenador) {
	
	
}
public void anyadeJugador(Jugador jugador) {
	this.plantilla.add(jugador);
}

public int getPG() {
	return this.ganados;
}

public String getNombre() {
	return this.nombre;
}
public int getPP() {
	return this.perdidos;
}
public int getGF() {
	return this.golesAfavor;
}
public int getGC() {
	return this.golesEncontra;
}
public int getPuntos() {
	return this.puntos;
}
public int getDG() {
	return this.golesAfavor-this.golesEncontra;
}
public void setPuntos(int puntillos) {
	this.puntos=puntillos;
}

public int getPE() {
	return this.empatados;
}
public int getPJ() {
	return (this.empatados+this.ganados+this.perdidos);
}

public void ganaPartido() {
	this.ganados++;
	this.puntos=this.puntos+3;
}
public void pierdePartido() {
	this.perdidos++;
}
public void empataPartido() {
	this.empatados++;
	this.puntos=this.puntos+1;
}
public void cambiaGoles(int Afavor,int Encontra) {
	this.golesAfavor=this.golesAfavor+Afavor;
	this.golesEncontra=this.golesEncontra+Encontra;
	
}
}


