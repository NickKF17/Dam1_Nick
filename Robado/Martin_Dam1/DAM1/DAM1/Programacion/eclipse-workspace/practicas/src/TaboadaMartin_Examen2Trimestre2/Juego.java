package TaboadaMartin_Examen2Trimestre2;

import java.util.ArrayList;


public class Juego {
	private ArrayList<Jugador> jugadores = new ArrayList<>();
	private ArrayList<Prueba> pruebas = new ArrayList<>();
	private int numPrueba = 0;

	public Juego(int jugadores) {
		for (int i = 1; i <= jugadores; i++) {
			Jugador j = new Jugador(i);
			this.jugadores.add(j);
		}
	}

	public void verJugadores() {
		int j = 1;
		if(this.numPrueba==0) {
			System.out.println("¡Empieza el juego de la Gamba!\n¡Tenemos a todos estos jugadores!");
		}
		else {
		System.out.printf("Número de pruebas Jugadas: %d\nNúmero de jugadores activos: %d\n", this.numPrueba,
				this.jugadoresActivos());
		}
		System.out.println("-------------------------------------------------------------");
		for (Jugador jugador : jugadores) {
			if (jugador.getActivo())
				System.out.printf(" %03d ", jugador.getNumero());
			else
				System.out.print(" --- ");
			if (j == 12) {
				System.out.println();
				j = 0;
			}
			j++;
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println();
	}

	public void nuevaPrueba(int num) {
		int jugAct = this.jugadoresActivos();
		if (num < jugAct) {
			this.numPrueba++;
			System.out.printf("Empieza la prueba número %d\nVamos a expulsar a %d jugadores\n", this.numPrueba, num);
			int i = 0;
			while (i < num) {
				Jugador jugador = jugadores.get((int) (Math.random() * this.jugadores.size()));
				if (jugador.getActivo()) {
					jugador.setInactivo();
					i++;
				}
			}
			jugAct = this.jugadoresActivos();
			int jugExp = jugadores.size() - jugAct;
			Prueba p = new Prueba(this.numPrueba, jugExp, jugAct);

			this.pruebas.add(p);
			if (jugAct == 1) {
				Jugador jugadorG = this.ultimoJugador();
				System.out.printf("El Juego de la Gamba ha terminado!\nEl ganador es el jugador %d\n",
						jugadorG.getNumero());
			}

		} else {
			System.out.println("¡¡Que nos que damos sin ganador!!!");
		}
		System.out.println();

	}

	public void verPruebas() {
		System.out.printf("Número de pruebas hasta el momento: %d\n\n", this.numPrueba);
		for (Prueba prueba : pruebas) {
			prueba.mostrarPueba();
		}
		System.out.println();
	}

	public int jugadoresActivos() {
		int contador = 0;
		for (Jugador j : this.jugadores) {
			if (j.getActivo())
				contador++;
		}
		return contador;
	}

	public Jugador ultimoJugador() {
		Jugador ultJug = null;
		for (Jugador j : this.jugadores) {
			if (j.getActivo())
				ultJug = j;
		}
		return ultJug;
	}
}
