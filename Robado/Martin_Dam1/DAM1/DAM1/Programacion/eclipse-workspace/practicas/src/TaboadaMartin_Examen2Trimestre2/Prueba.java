package TaboadaMartin_Examen2Trimestre2;

import java.util.HashMap;

public class Prueba {
	private HashMap<String, Integer> prueba = new HashMap<String, Integer>();
	
	
	public Prueba(int numPrueba, int expulsados, int restantes) {
		prueba.put("Prueba número", numPrueba);
		prueba.put("Expulsados", expulsados);
		prueba.put("Restantes", restantes);
	}
	public void mostrarPueba() {
		for(String k: prueba.keySet()) {
			System.out.printf("|   %s: %d\n",k, this.prueba.get(k));
		}
		System.out.println();
	}
}
