package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Instituto {
	
	public static void main(String[] args) {

	Modulo programacion= new Modulo("Programacion",8,1,false);
	Modulo fundamentos= new Modulo("Fundamentos de programacion",2,1,false);
	Modulo python=new Modulo("Programacion en Python",3,2,true);
	
	Ciclo dam = new Ciclo("Desarrollo de Aplicaciones multiplataforma","Superior");
	
	dam.anyadeModulo(programacion);
	dam.anyadeModulo(fundamentos);
	dam.anyadeModulo(python);
	
	Grupo dam1= new Grupo("Dam1",dam,1,4);


	
	Profesor profe1 = new Profesor("Jose Maria","Morales","Informatica",dam1);
	//Profesor profe2 = new Profesor("Pepa","Cano","Filosofia","");
	
	Alumno alumno1= new Alumno("Mario","Carcalete","Dam","1",17);
	Alumno alumno2= new Alumno("Lucia","Sanz","Dam","1",17);
	
	dam1.anyadetutor(profe1);
	
	dam1.anyadealumno(alumno1);
	dam1.anyadealumno(alumno2);
	dam1.anyadealumno(alumno1);
	dam1.anyadealumno(alumno2);
	dam1.anyadealumno(alumno1);

	dam1.verGrupo();
	}
	}