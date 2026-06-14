package examen2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import POOkemon.Pokemon;

public class Carta implements Comparable<Carta>,Ubicacion{
	private String nombre;
	private String tipo;
	private int coste;
	private String descripcion;
	private String ubicacion;
	public Carta(String nombre,String tipo,int coste,String descripcion) {
	this.nombre=nombre;
	this.tipo=tipo;
	this.coste=coste;
	this.descripcion=descripcion;
	this.ubicacion="Biblioteca";		
	}
	@Override
	public String toString() {
		String linea1="Nombre: "+this.nombre +"\n";
		String linea2="Tipo: "+this.tipo+"\n";
		String linea3="Coste: "+this.coste+"\n";
		String linea4="Descripcion: "+this.descripcion+"\n";
		String linea5="Ubicacion: "+this.ubicacion+"\n";
	return linea1+linea2+linea3+linea4+linea5;
}
	
	
	@Override
	public int compareTo(Carta otro) {
		
		int devolver=0;
		if(this.nombre.compareTo(otro.nombre)>0)
			devolver=1;
		else if(this.nombre.compareTo(otro.nombre)<0)
			devolver =-1;
		return devolver;
	}
	@Override
	public void cementerio() {this.ubicacion="Cementerio";}
	public void mano() {this.ubicacion="Mano";}
	public void biblioteca() {this.ubicacion="Biblioteca";}
	
			
}