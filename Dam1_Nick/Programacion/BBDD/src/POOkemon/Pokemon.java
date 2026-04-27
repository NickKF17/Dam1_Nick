package POOkemon;

import java.io.Serializable;

public class Pokemon implements Comparable<Pokemon>,Serializable,Combate{
	private int codigo;
	private String nombre;
	private String[] tipo= new String[2];
	private int salud=100;
	public Pokemon(int c1,String nombre,String tipo) {
	this.codigo=c1;
	this.nombre=nombre;
	this.tipo[0]=tipo;
		
	}
	public Pokemon(int c1,String nombre,String tipo1,String tipo2) {
	this.codigo=c1;
	this.nombre=nombre;
	this.tipo[0]=tipo1;
	this.tipo[1]=tipo2;
		
	}
	/*
	@Override
	public void fueraDeCombate() {
		this.salud=0;
	}
	*/
	@Override
	public String toString() {
		return "("+this.codigo+") "+this.nombre;
	}
	@Override
	public boolean equals(Object objeto) {
		
		Pokemon otro=(Pokemon) objeto;
		boolean iguales=false;
		 if(this.codigo==otro.codigo)
			 iguales=true;
		return iguales;
	}
	@Override
	public int compareTo(Pokemon otro) {
		int devolver=0;
		if(this.codigo>otro.codigo)
			devolver=1;
		else if(this.codigo<otro.codigo)
			devolver =-1;
		return devolver;
	}
}
