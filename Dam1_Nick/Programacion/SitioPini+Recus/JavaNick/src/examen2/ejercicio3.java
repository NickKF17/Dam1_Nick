package examen2;

import java.util.ArrayList;
import java.util.Collections;

import POOkemon.Pokemon;

public class ejercicio3 {

	public static void main(String[] args) {
		
		Carta c1=new Carta("Black Lotus","Artefacto",1,"Sacrifica el Black Lotus...");
		Carta c2 =new Carta("White Milka","Artefacto",2,"Sacrifica el White Milka...");
		Carta c3 =new Carta("Green Dubai","Artefacto",3,"Sacrifica el Black Dubai...");

		//Estas son para probar el .cementerio() por lo tanto no los meto en el arrayList
		Carta c4 =new Carta("Green Dubai","Artefacto",3,"Sacrifica el Black Dubai...");
		Carta c5 =new Carta("Green Dubai","Artefacto",3,"Sacrifica el Black Dubai...");
		
		
		ArrayList<Carta> cartas=new ArrayList<>();
		cartas.add(c1);
		cartas.add(c2);
		cartas.add(c3);	
	
		Collections.sort(cartas);
		for(Carta cart :cartas) {
			System.out.println(cart);
		}		
		
		c4.cementerio();
		c5.mano();
		System.out.println(c4);
		System.out.println(c5);
		
	}

}
