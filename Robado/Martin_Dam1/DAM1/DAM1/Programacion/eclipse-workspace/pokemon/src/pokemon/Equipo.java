package pokemon;

public class Equipo {

	private String entrenador ;
	private Pokemon[] equipo = new Pokemon[3];
	
	public Equipo(String entrenador,Pokemon pokemon1, Pokemon pokemon2,Pokemon pokemon3) {
		this.entrenador = entrenador;
		this.equipo[0]= pokemon1;
		this.equipo[1]= pokemon2;
		this.equipo[2]= pokemon3;
	}
	
	public void mostrar() {
		System.out.println("Entrenador: "+this.entrenador);
		for(int i = 0; i<3; i++) {
			this.equipo[i].mostrar();
		}
			
	}
}
