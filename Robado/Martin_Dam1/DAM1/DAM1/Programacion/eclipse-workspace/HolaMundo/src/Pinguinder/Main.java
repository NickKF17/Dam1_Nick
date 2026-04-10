package Pinguinder;

public class Main {
	public static void main(String[] args) {
		Guinder guinder = new Guinder();
		Onvre h1 = new Onvre(guinder, "Pepe", "12/08/1975",2);
		Onvre h2 = new Onvre(guinder, "Antonio", "22/10/1965", 1, 50, 60);
		Mujeh m1 = new Mujeh(guinder, "Benito", "02/03/1956",0,70,100 );
		
		
		h1.mostrarDatos();
		guinder.listaMatches(m1);
		guinder.listaMatches(h1);
		
	}
}
