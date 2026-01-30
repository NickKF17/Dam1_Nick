package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Grupo {
	private String nombre;
	private Ciclo ciclo;
	private int curso;
	private int numalumnos;
	private int alumnosmatriculados=0;
	private Alumno[] listaAlumnos;
	private Profesor tutor=null;
	public Grupo(String nombre,Ciclo ciclo,int curso,int numalumnos){
		this.nombre=nombre;
		this.ciclo=ciclo;
		this.curso=curso;
		this.listaAlumnos= new Alumno [numalumnos];
		this.numalumnos=numalumnos;
	}
	public void anyadetutor(Profesor tutor) {
		this.tutor=tutor;
		tutor.setTutoria(this);
		
	}
public void anyadealumno(Alumno alumno) {
	if(this.numalumnos==this.alumnosmatriculados)
		System.out.println("Grupo completo. Ya hay " + this.alumnosmatriculados +" matriculados");
	else {
		this.listaAlumnos[this.alumnosmatriculados]=alumno;
	this.alumnosmatriculados++;						
	}
	}	
public void verGrupo() {
	System.out.println("Nombre del grupo: " + this.nombre);
	System.out.println("Ciclo: "+ this.ciclo.getnombre()+ " - Curso: "+ this.curso);
	System.out.println("Nombre del tutor: ");
	System.out.println("Total alumnos: "+ this.numalumnos);
	
	if(this.tutor!=null)
		System.out.println("Tutor: "+ this.tutor.getnombre() + " "+ this.tutor.getapellido());
	else
		System.out.println("No hay tutor asignado");
	System.out.println("\nLista de Alumnos del grupo: " );
for(int i =0;i<this.alumnosmatriculados;i++)
	System.out.println("- "+this.listaAlumnos[i].getnombre()+" "+this.listaAlumnos[i].getapellido());


Modulo [] modulos =this.ciclo.getModulos(this.curso);
int posicion=0;
Modulo m= modulos[posicion];
System.out.println("Listado de Modulos del grupo: ");
while(m!=null) {
	System.out.println("- "+m.getnombre());
	posicion++;
	m=modulos[posicion];
}
}

}