package Paquete;

import java.util.ArrayList;
import java.util.Iterator;

public class Furgo {
	private ArrayList<Paquete> paquetes = new ArrayList<>();
	private int pesoMax;
	private int kmMax;
	private static Localizacion almacen = new Localizacion (0,0);
	
	public Furgo(int pesoMax, int kmMax){
		this.pesoMax = pesoMax;
		this.kmMax = kmMax;
	}
	
	public void setPaquete(Paquete p) {
		this.paquetes.add(p);
	}
	public void calcularRuta() {
		int peso=0;
		int distancia = 0;
		Paquete destino = Paquete.destinoMasCercano(almacen);
		while (destino != null) {
			paquetes.add(destino);
			Localizacion nuevoOrigen = destino.getLocalizacion();
			Paquete.borrarDestino(destino);
			destino = Paquete.destinoMasCercano(nuevoOrigen);
		}
		
	}
	public void mostrarRuta(){
		int i =1;
		for (Paquete p: this.paquetes) {
			System.out.printf("%d - La siguiente entrega será en la localizacion %d:%d\n", i, p.getX(), p.getY());
			i++;
		}
	}
}
