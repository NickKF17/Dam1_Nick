package def;

public class Main {

	public static void main(String[] args) {
		Juego laGamba=new Juego(456);

		laGamba.nuevaPrueba(200);
System.out.println();
		laGamba.nuevaPrueba(150);
		System.out.println();
laGamba.verPruebas();
		System.out.println();
		laGamba.verJugadores();
		
		laGamba.nuevaPrueba(105);
		
	
	}

}
