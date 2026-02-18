package defecto;

public class pool2 {

	public static void main(String[] args) {
		
		pokemon p1 = new pokemon("Bulbasaur", "Planta",1);
		pokemon p2 = new pokemon("Charizard", "Fuego", "Volador",6);
		pokemon p3 = new pokemon("Ivysaur", "Planta",2);
		
		p1.mostrar();
		p2.mostrar();
		//p1.setEvolucion(p3);
		//p1 = p1.evoluciona();
		p1.mostrar();
	}

}
