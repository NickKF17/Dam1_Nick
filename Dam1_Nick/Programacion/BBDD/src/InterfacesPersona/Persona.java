package InterfacesPersona;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona implements Bajas,Jubilacion,Accidente{
	private String nombre;
	private int cotizados;
	private String apellidos;
	private LocalDate nacimiento;
	private LocalDate jubilacion=null;
	private LocalDate baja=null;
	private LocalDate fallecimiento=null;
	
	public Persona(String nombre,String apellidos,LocalDate nacimiento) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.nacimiento=nacimiento;
	}
	
public Persona(String nombre,String apellidos,LocalDate nacimiento,int cotizados) {
	this.nombre=nombre;
	this.apellidos=apellidos;
	this.nacimiento=nacimiento;
	this.cotizados=cotizados;	
	}

@Override
public String toString() {
	String linea1="Cotizante: "+this.apellidos;
	String linea2=" ,"+this.nombre+"\n";
	String linea3="";
	DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-M-yyyy");
	if(this.nacimiento!=null) {
		String fechaformateada = this.fallecimiento.format(formato);
		linea2="Estado: Fallecido. Fecha de defuncion: "+fechaformateada+"\n";
	}
	else if(this.jubilacion!=null) {
		String fechaFormateada=this.jubilacion.format(formato);
		linea2="Estado: Jubilado. Fecha de jubilacion: "+fechaFormateada+"\n";
	}
	else if(this.baja!=null) {
		String fechaFormateada=this.baja.format(formato);
		linea2="Estado: De baja. Fecha de baja: "+fechaFormateada+"\n";
	}else linea2="Estado: en Activo\n";
		
			return linea1+linea2+linea3;
}
}
