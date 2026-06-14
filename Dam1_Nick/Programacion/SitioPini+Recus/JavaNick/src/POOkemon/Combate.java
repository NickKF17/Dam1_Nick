package POOkemon;

public interface Combate {
	// public ,static,final
	
	int SALUD_MINIMA=25;
	
	
 // void fueraDeCombate();
default void fueraDeCombate(){
	System.out.println("El pokemon se encuentra fuera de combate");
}

static void finDelCombate() {
	System.out.println("El combate a terminado");
}
}
