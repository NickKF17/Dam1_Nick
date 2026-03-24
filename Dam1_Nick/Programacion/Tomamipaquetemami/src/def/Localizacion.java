package def;

public class Localizacion {
	private int x;
	private int y;
public Localizacion(int x, int y) {
this.x=x;
this.y=y;
}

public double distancia(Localizacion destino) {
	int a1=this.x;
	int b1=this.y;
	
	int a2=destino.x;
			int b2=destino.y;
			double distancia=Math.hypot(a2-a1, b2-b1);
	return distancia;
}
public int getx() {
	return this.x;
}
public int gety() {
	return this.y;
}
}
