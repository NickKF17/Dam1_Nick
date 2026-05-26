package RA5_8;

import java.io.Serializable;
import java.util.ArrayList;

public class Producto implements Serializable {
	private String nombre;
	private double precio;
	private int stock;
	public Producto(String nombre,Double precio,int stock) {
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
		
		
	}
	@Override
	public String toString() {
	    return "Producto: "+nombre+" Precio: "+precio+" Stock:"+stock;
	}

}
