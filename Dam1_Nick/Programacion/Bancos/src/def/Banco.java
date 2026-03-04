package def;

import java.util.ArrayList;
import java.util.*;

public class Banco {
private String nombre;
private String codigo /*(ESXX XXXX)*/;

public Banco(String nombre,String codigo) {
	this.nombre=nombre;
	this.codigo=codigo;
	
	
}
private static ArrayList<Sucursal> sucursales= new ArrayList<>();

public void nuevasucursal(Sucursal sucursal) {
	this.sucursales.add(sucursal);
	
}
public void mostrarsucu() {
for(Sucursal Sucu:sucursales) {
	Sucu.mostrar();
	System.out.println();
}
}
public void listarsucursales() {
	System.out.println("Banco: " + nombre + " / "+"Codigo: " + "("+codigo+")");
	for(Sucursal Sucu:sucursales) {
		System.out.print("-");
		Sucu.getciudad();
		System.out.print("(");
		Sucu.getcodigo();
		System.out.println(")");
	
	}
}
}
