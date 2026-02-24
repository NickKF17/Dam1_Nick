package def;

public class Main {
	public static void main(String[] args) {
	new Paquete(20.7,5,8);
	new Paquete(2.1,6,7);
	new Paquete(3.5,10,15);


	
	Localizacion l1=new Localizacion(0,0);
	Localizacion l2=new Localizacion(5,1);
	
	
	Camioneta c1=new Camioneta(100.0,l1);
	
	
	c1.calcularRuta();
	c1.mostrarRuta();
	
	}

}
