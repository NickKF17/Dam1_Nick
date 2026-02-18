package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Clases {
	
	public static void main(String[] args) {
		
		Persona persona1=new Persona("Lucia", "Sanz");
//		persona1.mostrar();
		
		Persona persona2;
		persona2=new Persona("Daniel","Rodriguez", 19);
//		persona2.mostrar();
		

		Profesor profesor1=new Profesor("Jose Maria", "Morales");
		System.out.println(profesor1.getNombre());
		System.out.println(profesor1.getNombreCompleto());

		Alumno alumno1=new Alumno("Lucia", "Sanz",18);
		System.out.println(alumno1.getNombre());
		System.out.println(alumno1.getNombreCompleto());
		
		

//		persona2=null;//Borro de esta manera
//		persona2.mostrar();
//		
//	System.out.println(persona1.getnumPersonas());
//	System.out.println(persona2.getnumPersonas());
	}
}