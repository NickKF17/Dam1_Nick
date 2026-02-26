package def;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Juego {
	private int num_participantes;
	private int num_pruebas=1;
	private ArrayList<Jugador> jugadores= new ArrayList<>();

	public Juego(int num_participantes) {
		this.num_participantes=num_participantes;


		for(int i=1;i<= num_participantes;i++) {
			int codigo=i;
		jugadores.add(new Jugador(codigo));
		
		}
	}
	
	
	
	
	public void nuevaPrueba(int eliminados) {
		
		Prueba.pruebas.put(num_pruebas, new Prueba(eliminados,num_participantes));
		
		
		if (eliminados>num_participantes)
		System.out.println("No pueden eliminarse mas jugadores que jugadores activos");
			else {
		System.out.println("Empieza la prueba "+ this.num_pruebas  + "\nVamos a expulsar a "+eliminados+" Jugadores");
		this.num_pruebas++;
		if(num_participantes==1) {
			System.out.println("El juego de la Gamba ha terminado!");
			System.out.println("El ganador es el jugador " );
		}
			}
		this.num_participantes=num_participantes-eliminados;

	
	}
	

	public Integer getNumPruebas() {
		return this.num_pruebas;
	}
public int getParticipantes() {
	return this.num_participantes;
}
public void verPruebas() {
	System.out.println("Numero de pruebas hasta el momento: "+ Prueba.pruebas.size());
	for (Entry<Integer, Prueba> prueba:Prueba.pruebas.entrySet()) {
		System.out.println("Prueba número: "+ prueba.getKey()+". Expulsados: "+prueba.getValue().getEliminados() + ". Restantes: "+ prueba.getValue().getRestantes());
		prueba.getValue().getEliminados();
	}

}
public void verJugadores() {
	System.out.println("Numero de pruebas Jugadas: "+ Prueba.pruebas.size());
	System.out.println("Numero de Jugadores Activos: "+jugadores.size());
}
}
