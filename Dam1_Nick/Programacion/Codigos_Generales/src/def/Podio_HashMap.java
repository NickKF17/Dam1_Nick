package def;
import java.util.*;

	public class Podio_HashMap{
	    public static void main(String[] args) {

	        HashMap<String, Integer> puntos = new HashMap<>();
	        puntos.put("Ana", 90);
	        puntos.put("Luis", 120);
	        puntos.put("Marta", 110);
	        puntos.put("Carlos", 80);

	        String primero = null, segundo = null, tercero = null;

	        // Buscar el mayor (1º)
	        for (String nombre : puntos.keySet()) {
	            if (primero == null || puntos.get(nombre) > puntos.get(primero)) {
	                primero = nombre;
	            }
	        }

	        // Buscar el segundo mayor (2º)
	        for (String nombre : puntos.keySet()) {
	            if (!nombre.equals(primero)) {
	                if (segundo == null || puntos.get(nombre) > puntos.get(segundo)) {
	                    segundo = nombre;
	                }
	            }
	        }

	        // Buscar el tercer mayor (3º)
	        for (String nombre : puntos.keySet()) {
	            if (!nombre.equals(primero) && !nombre.equals(segundo)) {
	                if (tercero == null || puntos.get(nombre) > puntos.get(tercero)) {
	                    tercero = nombre;
	                }
	            }
	        }

	        System.out.println("1º: " + primero + " - " + puntos.get(primero));
	        System.out.println("2º: " + segundo + " - " + puntos.get(segundo));
	        System.out.println("3º: " + tercero + " - " + puntos.get(tercero));

}
}
