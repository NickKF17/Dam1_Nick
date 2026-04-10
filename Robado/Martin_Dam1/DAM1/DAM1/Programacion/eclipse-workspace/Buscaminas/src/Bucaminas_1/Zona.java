package Bucaminas_1;
import java.util.ArrayList;
public class Zona {
	private ArrayList<Casilla> area= new ArrayList<>();
	private static ArrayList<Zona> zonas = new ArrayList<>();
	public Zona(Casilla casilla) {
		this.area.add(casilla);
		this.zonas.add(this);
	}
	public Zona() {
	}
	
	public static Zona crearZona(Casilla c) {
		return new Zona(c);
	}
	
	public void setCasilla(Casilla casilla) {
		area.add(casilla);
	}
	
	public static Zona getZona(Casilla casilla) {
		Zona zona = null;
		for(Zona z: zonas) 
			if (z.area.contains(casilla))
				zona = z;
		
		return zona;
	}
	public static boolean isInArea(Casilla casilla) {
		boolean si = false;
		for(Zona z: zonas)
			if(z.area.contains(casilla))
				si= true;
		return si;
	}
	public static void combineZona(Casilla casilla1, Casilla casilla2) {
		Zona zona1= Zona.getZona(casilla1);
		Zona zona2 = Zona.getZona(casilla2);
		zona1.area.addAll(zona2.area);
		zonas.remove(zona2);
	}
}
