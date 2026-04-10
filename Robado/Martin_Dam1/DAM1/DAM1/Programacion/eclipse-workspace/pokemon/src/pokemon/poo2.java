
package pokemon;


public class poo2 {

	public static void main(String[] args) {
		
		Pokemon p1= new Pokemon("Charmander", 1010 , "Fuego","volador");
		Pokemon p2= new Pokemon("Bulbasur", 1014, "Planta");
		Pokemon p3 = new Pokemon("Ivysaur", 1015, "Planta");
		Pokemon pokemon1 = new Pokemon( "Bulbasaur",8, "Planta");
		Pokemon pokemon2 = new Pokemon( "Pidgeot",6, "Volador", "Fuego");
		Pokemon pokemon3 = new Pokemon( "Ivysaur",2, "Planta");
		Pokemon pokemon4 = new Pokemon( "Pikachu",23, "Eléctrico");
		Pokemon pokemon5 = new Pokemon( "Bulbasaur",1, "Planta");
		Pokemon pokemon6 = new Pokemon("Pidgeot", 6, "Volador", "Fuego");
		
		Equipo equipo1 = new Equipo("José María", p1, p2, p3);
		Equipo equipo2 = new Equipo ("Ash Ketchum", pokemon1,pokemon2,pokemon3);
		equipo2.mostrar();
		
		p1.mostrar();
		
		p2.mostrar();
		p2.setEvolucion(p3);
		p2 = p2.evoluciona();
		p2.mostrar();
		p1.evoluciona();
		p1.mostrar();
		p3.mostrar();
		p1.combateContra(p3);
		
		
	}

}
