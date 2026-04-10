package Paquete;

import java.util.HashMap; 

public class Localizacion {
	private int x;
	private int y;
	private static HashMap<Localizacion, Double> distancias = new HashMap<Localizacion, Double>();
	
	public Localizacion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public double distancia(Localizacion destino) {
		int a1 = this.x;
		int b1 = this.y;
		int a2 = destino.x;
		int b2 = destino.y;
		//double distancia = Math.sqrt(Math.pow((a2-a1),2)+ Math.pow((b2-b1), 2)); el de abajo es lo mismo pero mas mejor
		double distancia = Math.hypot(a2-a1, b2-b1); 
		return distancia;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
