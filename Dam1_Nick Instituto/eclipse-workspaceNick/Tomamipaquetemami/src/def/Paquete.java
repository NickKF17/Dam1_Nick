package def;

import java.util.*;

public class Paquete {
	
	private static ArrayList<Paquete> listaPaquetes=new ArrayList<>();
	private double peso;
	private Localizacion direccion;
	
	public Paquete(double peso,int localizacionx,int localizaciony){
		
	this.peso=peso;
	this.direccion= new Localizacion(localizacionx,localizaciony);
	
	
	Paquete.listaPaquetes.add(this);
		
	}
	
	public static Paquete destinoMasCercano(Localizacion punto) {
		HashMap<Paquete, Double> distancias=new HashMap<>();
		
		Paquete destino= null;
		if (Paquete.listaPaquetes.size()!=0)
		
		for(Paquete paquete: Paquete.listaPaquetes) {
			double distancia=punto.distancia(paquete.direccion);
			distancias.put(paquete, distancia);
		}
		double minimo =Double.MAX_VALUE;
		for(Map.Entry<Paquete, Double> entrega : distancias.entrySet()) {
			
			if(entrega.getValue()<minimo) {
				minimo=entrega.getValue();
				destino=entrega.getKey();
			}
		}
		
			return destino;
	}
public int getx() {
	return direccion.getx();
}
public int gety() {
	return direccion.gety();
}

public Localizacion getLocalizacion() {
	
	return direccion;
}

public static void borrarDestino(Paquete entrega) {
Paquete.listaPaquetes.remove(entrega);
	
}
}
