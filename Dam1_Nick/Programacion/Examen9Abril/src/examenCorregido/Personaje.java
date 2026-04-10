package examenCorregido;

import java.io.Serializable;

public class Personaje implements Serializable{

	private String nombre;
	private String titulo;
	public Personaje(String titulo,String nombre) {
		this.titulo	= titulo;
		this.nombre=nombre;
		
	}
	
	public String mostrarPersonaje() {
		return nombre + " "+(titulo);
	}
}
