package Ej9;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import binarios.Tarea;

public class Alumno implements Serializable{
	private String alumno;
	private double[]ras=new double[5];
	private static String nombreModulo;
	private static  ArrayList<Alumno> listaAlumnos =new ArrayList<>();
	public Alumno(String nombre,double ras[]) {
		this.alumno=nombre;
this.ras=ras;
			
	}
	public static void leerAlumnos(String fichero) {
			try {
				BufferedReader lector =new BufferedReader(new FileReader(fichero));
				nombreModulo=fichero.substring(fichero.lastIndexOf("/")+1,fichero.indexOf("."));
				String linea;
				while((linea = lector.readLine())!=null) {
					String[]elementos=linea.split(": ");
					String nombre=elementos[0];
					String[] ras =elementos[1].split(", ");
					double notas[]= new double[5];
					for(int i=0;i<5;i++)
						notas[i]=Double.parseDouble(ras[i]);
					Alumno alumno =new Alumno(nombre,notas);
					listaAlumnos.add(alumno);
				}
			}catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
	}
	public boolean todoAprobado() {
		boolean aprobado=true;
		
		for (double notas :ras)
			if (notas<5)
			aprobado=false;
		return aprobado;
	}
	
	public static void procesarNotasAlumnos() {
		System.out.printf("Módulo: %s\n",Alumno.nombreModulo);
		System.out.println("Alumnos con todo aprobado: ");
		int contador=0;
		for(Alumno alumno:Alumno.listaAlumnos)
			if(alumno.todoAprobado()==true) {
				System.out.println(alumno.alumno);
				contador++;
			}
		if(contador==0)
			System.out.println("No hay ningún alumno con todos los RAs aprobados");
		
		System.out.println("\nResultados de aprendizaje y alumnos suspensos:");
		for(int i=1;i<=5;i++) {
			System.out.printf("RA%d: ",i);
			Alumno.suspensosPorRa(i-1);
			System.out.println();
		}
			
	}
public static void suspensosPorRa(int n) {
	int contador=0;
	for (Alumno alumno:Alumno.listaAlumnos)
		if(alumno.ras[n]<5) {
			if(contador==0)
				System.out.printf("%s ",alumno.alumno);
			else
			System.out.printf(",%s ",alumno.alumno);
	contador++;
}
	if(contador==0)
		System.out.println("Todos aprobados");
}
public static void salvarAlumnosBinario(String ficheroBinario) {
		try(ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(ficheroBinario))){
			binario.writeObject(listaAlumnos);
			
			}catch(Exception e){
				System.out.println("Error: " +e.getMessage());
				
			}
		}
}

