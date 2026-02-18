package def;

import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Ciclo{
	private Modulo[] primero =new Modulo[8];
	private Modulo[] segundo= new Modulo[8];
	private String Nombre;
	private String grado;
	private int contmodupri=0;
	private int contmoduseg=0;
	
public Ciclo(String nombre, String grado) {
	this.Nombre=nombre;
	this.grado=grado;
}

public void anyadeModulo(Modulo m){
	if(m.getCurso()==1) {
		primero[this.contmodupri]=m;
		contmodupri++;
	}	
	else {
		segundo[this.contmoduseg]=m;
		contmoduseg++;
	}
	
}
public String getnombre() {
	return this.Nombre;
}
public Modulo[] getModulos(int curso) {
	Modulo[] modulos;
	if(curso==1)
		modulos= primero;
	else
		modulos= segundo;
return modulos;
}
	}