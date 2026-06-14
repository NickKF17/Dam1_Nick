package InterfacesPersona;


import java.nio.file.spi.FileSystemProvider;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Persona implements Bajas,Jubilacion,Accidente,Casamiento{
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
public void HayBoda(Persona p){
	LocalDate hoy = LocalDate.now();
	Period edad=Period.between(this.nacimiento,hoy);
	if(edad.getYears()<=Casamiento.edadMinimaCasamiento)
		System.out.printf("Felicidades %s y %s, habrá boda y unos niños muy sanos en el futuro\n",this.nombre,p.nombre);
	else
		System.out.println("Pa la carcel pa");
	
}
@Override 
public void darDeBaja() {
	LocalDate hoy = LocalDate.now();
	Period edad=Period.between(this.nacimiento,hoy);
	
	if(this.fallecimiento!=null)
		System.out.println("No puedes dar de baja a alguien que ya ha fallecido");
	else if (this.jubilacion!=null)
		System.out.println("No puedes dar de baja a alguien que ya esta jubilado");
	else if(this.baja!=null)
		System.out.println("No puedes dar de baja a alguien que ya esta dado de baja");
	else if(edad.getYears()>Bajas.edadBaja)
	System.out.printf("El cotizante se ha dado de baja con fecha %s \n",hoy);
	else
		System.out.println("No puedes darte de baja si no trabajas");
	this.baja=hoy;
}
@Override
public void consultaJubilacion() {
	if(this.jubilacion !=null)
		System.out.println("El cotizante ya esta jubilado");
	else if (this.fallecimiento!=null)
		System.out.println("El cotizante ya ha fallecido");
	else {
		LocalDate hoy = LocalDate.now();
	Period edad=Period.between(nacimiento, hoy);
	if(edad.getYears()<Jubilacion.EDAD_MINIMA_JUBILACION) {
		System.out.println("El jubilante no puede jubilarse sin penalizacion economica");
		System.out.printf("Le faltan %d años\n",Jubilacion.EDAD_MINIMA_JUBILACION-edad.getYears());
	}
	else if(this.cotizados>=Jubilacion.Anyos_MINIMO_COTIZADOS_100)
		System.out.println("El cotizante puede jubilarse sin penalizacion");
	else if(this.cotizados>=Jubilacion.Anyos_MINIMO_COTIZADOS_50)
		System.out.println("El cotizante puede jubilarse con penalizacion del 50%");
	else System.out.println("Insuficientes años cotizados");
	}
	
}
@Override
public void HuboAccidente() {
	boolean nomiembro=false;
	
	Scanner teclado=new Scanner(System.in);
	
	System.out.printf("El cotizante: %s ha sufrido algun accidente?(si/no)",this.nombre);
	String respuesta=teclado.nextLine();
	
	
	switch(respuesta) {
	case "si":
		System.out.printf("El cotizante: %s ha perdido un miembro o ha muerto?(1/2)",this.nombre);
		String respuesta2=teclado.nextLine();
		if(respuesta2.equals("1"))
			nomiembro=true;
		else if(respuesta2.equals("2"))
			this.fallecimiento=LocalDate.now();

		else
			System.out.println("Introduce un numero valido");
		break;
	case "no":
		System.out.println("Sigue con su dia a dia");
		break;
		default:
			System.out.println("Elige una opcion correcta");
			break;
	}
	
	
if(this.fallecimiento!=null) {
	System.out.println("El cotizante tuvo un accidente y ha fallecido");
}
else if(nomiembro=true)
	System.out.println("El cotizante sufre de una discapacidad permanente debido a la perdida de uno o mas miembros en un accidente");
else
	System.out.println("Vivo y coleando");
}

@Override
public String toString() {
	String linea1="Cotizante: "+this.apellidos;
	String linea2=" ,"+this.nombre+"\n";
	String linea3="";
	DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-M-yyyy");
	if(this.fallecimiento!=null) {
		String fechaformateada = this.fallecimiento.format(formato);
		linea3="Estado: Fallecido. Fecha de defuncion: "+fechaformateada+"\n";
	}
	else if(this.jubilacion!=null) {
		String fechaFormateada=this.jubilacion.format(formato);
		linea3="Estado: Jubilado. Fecha de jubilacion: "+fechaFormateada+"\n";
	}
	else if(this.baja!=null) {
		String fechaFormateada=this.baja.format(formato);
		linea3="Estado: De baja. Fecha de baja: "+fechaFormateada+"\n";
	}else linea3="Estado: en Activo\n";
		
			return linea1+linea2+linea3;
}
}
