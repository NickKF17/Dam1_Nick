package RA6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayAsignaturas {

	public static void main(String[] args) {
		ArrayList <String> asignaturas= new ArrayList<>(List.of("Programacion","Mates","Lengua","Biologia","Geologia"));
		
		asignaturas.add(2,"Anatomia");
System.out.println(asignaturas);
asignaturas.remove(0);
System.out.println(asignaturas);
System.out.println(asignaturas.contains("Dam"));

Collections.sort(asignaturas);

for(String asignatura:asignaturas)
	System.out.println(asignatura);
	}

}
