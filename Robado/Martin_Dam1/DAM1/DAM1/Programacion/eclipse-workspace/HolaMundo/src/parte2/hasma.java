package parte2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class hasma {

	public static void main(String[] args) {
		HashMap<String, Double> sueldos = new HashMap<>();
		sueldos.put("José María Morales", 3567.44);
		sueldos.put("Pepe Pótamo", 1755.44);
		sueldos.put("Inés Perado", 3454.00);
		
		System.out.println(sueldos);
		
		sueldos.put("José María Morales", 4567.44);
		System.out.println(sueldos);
		
		
		
		String nombre= "Pepe Pótamo";
		
		//sueldos.remove(nombre);
		
		
		if(sueldos.containsKey(nombre))
			System.out.printf("El sueldo de %s es %.2f\n",nombre, sueldos.get(nombre));
		else
			System.out.println("Esa clave no existe");
		
		System.out.println(sueldos);
		
		for (Map.Entry<String, Double> persona:sueldos.entrySet()) {
			System.out.printf("%s: %.2f\n", persona.getKey(), persona.getValue());
		}
		
		
		for(String persona: sueldos.keySet()) {
			System.out.printf("%s: %.2f\n", persona, sueldos.get(persona));
			
		}
		
		System.out.println();
		System.out.println();
		
		
		Iterator<Map.Entry<String, Double>> iterador = sueldos.entrySet().iterator();
		while(iterador.hasNext()) {
			Map.Entry<String,Double> persona = iterador.next();
			System.out.printf("it. %s: %.2f\n", persona.getKey(), persona .getValue());
		}
		
		
		System.out.println();
		
		System.out.println();
		
		System.out.println();
		
		Iterator<String> iterador2 = sueldos.keySet().iterator();
		while(iterador2.hasNext()) {
			String nombre3= iterador2.next();
			System.out.printf("it2-");
		}
		
		System.out.println();
		sueldos.forEach((nombre2, sueldo2)->System.out.println(nombre2+" : "+sueldo2));
		
		
		
	}

}
