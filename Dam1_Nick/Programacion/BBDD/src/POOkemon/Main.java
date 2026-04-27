package POOkemon;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Pokemon p1=new Pokemon(1,"Bulbasaur","Planta");
		Pokemon p2=new Pokemon(2,"Ivysaur","Planta","Veneno");
		Pokemon p3=new Pokemon(3,"Venasaur","Planta","Veneno");
		Pokemon p4=new Pokemon(1,"Bulbasaur","Planta");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		if(p1==p4)
			System.out.println("Iguales");
		else
			System.out.println("No iguales");
		
		
		if(p1.equals(p4))
			System.out.println("Iguales");
		else
			System.out.println("No iguales");
		
		
		ArrayList<Pokemon> listaPokemon =new ArrayList<>();
		
		listaPokemon.add(p1);
		listaPokemon.add(p2);
		listaPokemon.add(p3);
		listaPokemon.add(p4);
		
		Collections.sort(listaPokemon);
		
		for(Pokemon poke :listaPokemon)
			System.out.println(poke );
		
		p1.fueraDeCombate();
		Combate.finDelCombate();
	}

}
