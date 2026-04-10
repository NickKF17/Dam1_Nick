package Bucaminas_1;

import java.util.Arrays;

public class Tablero {
	private int lado;
	private int minas;
	private Casilla[][] tabla;
	private int[][] tablasec;
	final static int MINA = -1;

	public Tablero(int lados, int minas) {
		this.lado = lados;
		this.minas = minas;
		this.tabla = new Casilla[lado][lado];
		this.rellenarTablero();
	}

	public void rellenarTablero() {
		for (int i = 0; i < this.lado; i++) {
			for (int j = 0; j < this.lado; j++) {
				this.tabla[i][j] = Casilla.crearCasilla(0, false);
			}
		}

	}

	public void creadorDeZonas() {
		for (int i = 0; i < this.lado; i++) {
			for (int j = 0; i < this.lado; j++) {
				// acabar el analizador para que cree las zonas
				Casilla casilla = this.tabla[i][j];
				Zona zona = new Zona();
				if (casilla.getNumero() == 0) {
					if (Zona.isInArea(casilla)) // funcion para saber si la casilla está en alguna de las
						// zonas0
						zona = Zona.getZona(casilla);

					if (i == 0 && j == 0) {
						if (this.tabla[i][j + 1].getNumero() == 0)
							zona.setCasilla(this.tabla[i][j + 1]);
						if (this.tabla[i + 1][j].getNumero() == 0)
							zona.setCasilla(this.tabla[i + 1][j]);
					}

					else if (i == 0 && j != 0 && j != this.lado - 1) {// para analizar las de centro arriba
						// hay que acabar el analizador y tabien hay que hacer un unificador de zonas si
						// es que dos zonas coinciden
						// tambien sería bueno hacer solo zonas donde la casilla está vacía, o sea sea 0
						// estos ifs son para por si queremos dividir las zonas
						if (this.tabla[i][j - 1].getNumero() == casilla.getNumero()
								&& this.tabla[i][j - 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j - 1]);
						else {
							Zona.combineZona(casilla, this.tabla[i][j - 1]);
						}
						if (this.tabla[i + 1][j].getNumero() == casilla.getNumero()
								&& this.tabla[i + 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i + 1][j]);
						if (this.tabla[i][j + 1].getNumero() == casilla.getNumero()
								&& this.tabla[i][j + 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j + 1]);
					} else if (i == 0 && j == this.lado - 1) {// parte de esquina derecha superior
						if (this.tabla[i][j - 1].getNumero() == 0 && this.tabla[i][j - 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j - 1]);
						if (this.tabla[i + 1][j].getNumero() == 0 && this.tabla[i + 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i + 1][j]);
					} else if (i != 0 && j == 0 && i != this.lado - 1) {// parte izquierda centro
						if (this.tabla[i - 1][j].getNumero() == 0 && this.tabla[i - 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i - 1][j]);
						if (this.tabla[i][j + 1].getNumero() == 0 && this.tabla[i][j + 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j + 1]);
						if (this.tabla[i + 1][j].getNumero() == 0 && this.tabla[i + 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i + 1][j]);
					} else if (j == this.lado - 1 && i != 0 && i != this.lado - 1) {// lado de centroderecha
						if (this.tabla[i - 1][j].getNumero() == 0 && this.tabla[i - 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i - 1][j]);
						if (this.tabla[i + 1][j].getNumero() == 0 && this.tabla[i + 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i + 1][j]);
						if (this.tabla[i][j - 1].getNumero() == 0 && this.tabla[i][j - 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j - 1]);
					} else if (i == this.lado - 1 && j == 0) {// lado ezquina izquierda
						if (this.tabla[i - 1][j].getNumero() == 0 && this.tabla[i - 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i - 1][j]);
						if (this.tabla[i][j + 1].getNumero() == 0 && this.tabla[i][j + 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j + 1]);
					} else if (i == this.lado - 1 && j != 0 && j != this.lado - 1) { // lado abajo centro

						if (this.tabla[i - 1][j].getNumero() == 0 && this.tabla[i - 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i - 1][j]);
						if (this.tabla[i][j + 1].getNumero() == 0 && this.tabla[i][j + 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j + 1]);
						if (this.tabla[i][j - 1].getNumero() == 0 && this.tabla[i][j - 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j - 1]);
					} else if (i == this.lado - 1 && j == this.lado - 1) {// esquina inferior izquierda
						if (this.tabla[i - 1][j].getNumero() == 0 && this.tabla[i - 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i - 1][j]);
						if (this.tabla[i][j - 1].getNumero() == 0 && this.tabla[i][j - 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j - 1]);
					} else { // centro centralito

						if (this.tabla[i - 1][j].getNumero() == 0 && this.tabla[i - 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i - 1][j]);
						if (this.tabla[i][j + 1].getNumero() == 0 && this.tabla[i][j + 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j + 1]);
						if (this.tabla[i + 1][j].getNumero() == 0 && this.tabla[i + 1][j].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i + 1][j]);
						if (this.tabla[i][j - 1].getNumero() == 0 && this.tabla[i][j - 1].isInZona(casilla) == false)
							zona.setCasilla(this.tabla[i][j - 1]);
					}
				}
			}
		}
	}

	

	public void mostrarTablero() {
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				Casilla casilla = tabla[i][j];
				if (casilla.getNumero() == -1) {
					System.out.print(" " + casilla.getNumero() + "  ");
				} else {
					System.out.print("  " + casilla.getNumero() + "  ");
				}
			}
			System.out.println();
		}
	}

	public void mostrarTablero2() {
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				if (tablasec[i][j] == -1) {
					System.out.print(" " + tablasec[i][j] + "  ");
				} else {
					System.out.print("  " + tablasec[i][j] + "  ");
				}
			}
			System.out.println();
		}
	}

	public void mostrarTableroSec() {

		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				Casilla casilla = tabla[i][j];
				if (casilla.getBoolean() == false)
					System.out.print("*" + "  ");
				else
					System.out.print(casilla.getNumero() + "  ");
			}
			System.out.println();
		}
	}

	public void colocarMina() {
		int numMina = 0;
		while (numMina != minas) {
			int fila = (int) (Math.random() * this.lado);
			int columna = (int) (Math.random() * this.lado);
			Casilla casilla = tabla[fila][columna];
			if (casilla.getNumero() == 0) {
				casilla.setNumero(MINA);
				numMina++;
			}

		}
	}

	public boolean HayMinas(int f, int c) {
		boolean haymina = false;
		Casilla casilla = tabla[f][c];
		if (casilla.getNumero() == MINA) {
			haymina = true;
		}
		return haymina;
	}

	public void seguirJugando(int f, int c) {
		Casilla casilla = tabla[f][c];
		if (casilla.getNumero() != MINA)
			casilla.setBoolean(true);
	}

	public void contadorMinas() {

		for (int i = 0; i < this.lado; i++) {
			for (int j = 0; j < this.lado; j++) {
				int contador = 0;
				if (i != 0 && j != 0 && i != this.lado - 1 && j != this.lado - 1) {
					int valor = this.tabla[i][j].getNumero();
					// Analizador en centro
					if (valor != MINA) {

						if (this.tabla[i - 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j - 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}

				}
				// parte de arriba y centro
				else if (i == 0 && j != 0 && j != this.lado - 1) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j - 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
				// parte de la izquierda centro
				else if (i != 0 && j == 0 && i != this.lado - 1) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i - 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j + 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
				// parte de abajo y centro
				else if (i == this.lado - 1 && j != 0 && j != this.lado - 1) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i - 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j - 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
				// parte derecha centro
				else if (j == this.lado - 1 && i != 0 && i != this.lado - 1) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i - 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j - 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
				// esquina izquierda superior
				else if (i == 0 && j == 0) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j + 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
				// esquina izquierda inferior
				else if (i == this.lado - 1 && j == 0) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i - 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j + 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j + 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
				// Esquina derecha inferior
				else if (i == this.lado - 1 && j == this.lado - 1) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i - 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i - 1][j - 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
				// esquina derecha superior
				else if (i == 0 && j == this.lado - 1) {
					if (this.tabla[i][j].getNumero() != MINA) {
						if (this.tabla[i + 1][j].getNumero() == MINA)
							contador++;
						if (this.tabla[i][j - 1].getNumero() == MINA)
							contador++;
						if (this.tabla[i + 1][j - 1].getNumero() == MINA)
							contador++;
						this.tabla[i][j].setNumero(contador);
					}
				}
			}

		}
	}

}