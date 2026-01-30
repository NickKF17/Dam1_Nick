package def;

import java.util.*;
public class HashSet_Conjuntos {

	public static void main(String[] args) {
		HashSet<String> alumnos=new HashSet<>();
		HashSet<String> profes=new HashSet<>(Arrays.asList("Jose Maria Morales","Yago Navarrete"));
	
		System.out.println(profes);
	
		alumnos.add("Nick Constante");
		alumnos.add("Kagari");
		alumnos.add("Messi");
		alumnos.add("Messi");
		
		System.out.println(alumnos);
		
		System.out.println(alumnos.add("Kagari"));
		System.out.println(alumnos.add("Fuyukawa"));
		
		alumnos.remove("Messi");
		System.out.println(alumnos);
		System.out.println(alumnos.remove("Messi"));
	
	
		int i=0;
		for(String alumno:alumnos) {
			if(i!=alumnos.size()-1)
				System.out.println(alumno+", ");
			else 
				System.out.println(alumno);
			i++;
		}
	ArrayList<Integer> numeros=new ArrayList<>(List.of
			(1,1,2,3,34,65,5,6,7,88,9,9));
	System.out.println(numeros);
	HashSet<Integer> numerosUnicos=new HashSet<>(numeros);
	System.out.println(numerosUnicos);
	numeros=new ArrayList<>(numerosUnicos);
	System.out.println(numeros);
		
	
	
	
	
	HashSet<Integer> conjunto1=new HashSet<>(Arrays.asList(1,2,3,4,5,9));
	HashSet<Integer> conjunto2=new HashSet<>(Arrays.asList(7,8,4,5));
	
	// union
	conjunto2.addAll(conjunto1);
	System.out.println(conjunto2);
	
	// Interseccion
	
	conjunto1.retainAll(conjunto2);
	System.out.println(conjunto1);
	
	//diferencia
	conjunto2.removeAll(conjunto1);
	System.out.println(conjunto2);
	
	
	
	
	HashSet<Integer> primitiva=new HashSet<>();
	int numero ;
	
	
do {
		numero = (int)(Math.random() * 49)+1;
		primitiva.add(numero);
	
	}while(primitiva.size()!=6);
	
	System.out.println(primitiva);
	}

}
