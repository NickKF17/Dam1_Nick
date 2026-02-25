package def;
import java.util.*;

public class Camioneta {

	private static Localizacion almacen =new Localizacion(0,0);
	private ArrayList<Paquete> listaPaquetes=new ArrayList<>();
	private double pesomax;
	private double kmax;
	private Ruta ruta=new Ruta();
	public Camioneta(double pesomax,double kmax) {
		this.pesomax=pesomax;
		this.kmax=kmax;
	}
	public void calcularRuta() {
		Paquete destino =Paquete.destinoMasCercano(almacen);
		while(destino!=null) {
			ruta.anyadirEntrega(destino);
			Localizacion nuevoOrigen=destino.getLocalizacion();
			Paquete.borrarDestino(destino);
			destino =Paquete.destinoMasCercano(nuevoOrigen);
		}
	}
	public void mostrarRuta() {
		int i=1;
		for (Paquete paquete :listaPaquetes)
			System.out.printf("%d - La siguiente entrega sera en la localizacion %d:%d\n",i,paquete.getx(),paquete.gety());
			
	}

}
