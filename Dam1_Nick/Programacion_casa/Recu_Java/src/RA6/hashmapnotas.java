package RA6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hashmapnotas {
public static void main(String[] args) {
	HashMap<String, Double> alumnosNotas= new HashMap<>(Map.of("Luis",1.2,"Messi",2.2,"Nick",9.9,"Kagari",10.0));
	
	alumnosNotas.put("Nana-Kun", 9.9);
	
	alumnosNotas.put("Messi", 6.7);
	
	alumnosNotas.remove("Luis");
	
	for(Map.Entry <String, Double> alumno : alumnosNotas.entrySet())
		System.out.println("Alumno: "+ alumno.getKey()+" Nota: "+alumno.getValue());
	
}
}
