package Paquete;

public class Main {
	public static void main(String[] args) {
		Furgo gabrielneta = new Furgo(300000, 200);
		Paquete estaaaaa= new Paquete(300,2,1);
		Paquete p1 = new Paquete(150, 5, 3);
		Paquete p2 = new Paquete(820, 10, 7);
		Paquete p3 = new Paquete(450, 0, 12);
		Paquete p4 = new Paquete(1200, 8, 1);
		Paquete p5 = new Paquete(275, 4, 9);
		
		Localizacion l1 = new Localizacion(1, 1);
		Localizacion l2 = new Localizacion(6, 2);
		System.out.println(l1.distancia(l2));
		System.out.println(l2.distancia(l1));  
		
		gabrielneta.calcularRuta();
		gabrielneta.mostrarRuta();
		
		
	}
}
