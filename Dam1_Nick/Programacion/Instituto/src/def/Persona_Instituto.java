package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


abstract class Persona_Instituto {

	protected String nombre;
	protected String apellido;

    
    
    boolean edad18=false;
		public Persona_Instituto(String nom ,String ape) {
			this.nombre=nom;
			this.apellido=ape;
		}
		}
			class Profesor extends Persona_Instituto{
				private Grupo tutoria=null;
				private String depar=null;
				public Profesor(String nom,String ape,String depar,Grupo grupo) {
					super(nom,ape);
					if(!depar.equalsIgnoreCase("Informatica") && !depar.equalsIgnoreCase("Empresa") && !depar.equalsIgnoreCase("Ingles"))
				System.out.println("Error, Departamento no valido");
					else
						this.depar=depar.toUpperCase();

				}
		public void setTutoria(Grupo grupo) {
			this.tutoria=grupo;
		}
		public String getnombre() {
			return this.nombre;
		}
		public String getapellido() {
			return this.apellido;
		}
		}

			class Alumno extends Persona_Instituto{
				private String ciclo;
				private String grupo;
				private int edad;
				private boolean edad18=false;
				public Alumno(String nom,String ape,String ciclo, String grupo,int edad){
					super(nom,ape);
				this.ciclo=ciclo;
				this.grupo=grupo;
				this.edad=edad;
				if (edad>=18)
					this.edad18=true;				
				}
				public String getnombre() {
					return this.nombre;
				}
				public String getapellido() {
					return this.apellido;
				}
		}