package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Modulo {
	private String nombre;
   protected int Curso;
   protected int horas;
  private int numModulo;
   boolean optativo;

   public Modulo (String nombre,int horas,int curso, boolean optativo){
	   this.nombre=nombre;
	   this.horas=horas;
	   this.Curso=curso;
	   this.optativo=optativo;
	   
	   
   }
   public int getCurso(){
		return this.Curso;
	   
   }
public String getnombre() {
	return this.nombre;
}
}