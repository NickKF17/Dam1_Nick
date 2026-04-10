package Paquete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Paquete {
	
	private static ArrayList<Paquete> listaPaquetes = new ArrayList<>();
	private static Localizacion loc= new Localizacion(0,0);
	private int peso;
	private Localizacion direccion;
		
	
	public Paquete(int peso, int x, int y) {
		this.direccion = new Localizacion(x,y);
		this.peso = peso;
		Paquete.listaPaquetes.add(this);
	}
	
	public static Paquete destinoMasCercano(Localizacion punto) {
		HashMap<Paquete, Double> distancias = new HashMap<Paquete, Double>();
		Paquete destino = null;
		for (Paquete p: listaPaquetes) {
			double dist = p.direccion.distancia(punto);
			distancias.put(p, dist);
		}
		double menor = Double.MAX_VALUE;
		for (Map.Entry<Paquete, Double> entrega : distancias.entrySet()) {
			if(entrega.getValue()<menor) {
				menor = entrega.getValue();
				destino = entrega.getKey();
			}
		}
		return destino;
	}
	
	public Localizacion getLocalizacion() {
		return this.direccion;
	}
	
	public static void borrarDestino(Paquete p) {
		listaPaquetes.remove(p);
	}
	
	public int getX() {
		return this.direccion.getX();
	}
	public int getY() {
		return this.direccion.getY();
	}
	
	
}
