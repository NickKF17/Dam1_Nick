package Pinguinder;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

abstract class Persona {
	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected int edadMinima = 18;
	protected int edadMaxima = 200;
	protected int queBusco;// 0- no me importa, 1- hombres, 2- mujereh,

	public Persona(Guinder g, String nombre, String nacimiento, int busco) {
		this.nombre = nombre;
		this.queBusco = busco;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.fechaNacimiento = LocalDate.parse(nacimiento, formato);

	}

	public Persona(Guinder g, String nombre, String nacimiento, int busco, int minimo, int maximo) {
		this(g, nombre, nacimiento, busco);
		if (minimo > 18) {
			this.edadMinima = minimo;
			this.edadMaxima = maximo;
		}
	}

	public int getEdad() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		return periodo.getYears();
	}

	public int getQueBusco() {
		return this.queBusco;
	}
	
	public boolean esMatch(Persona p) {
		boolean si= false;
		int edad1 = this.getEdad(); 
		int edad2 = p.getEdad();
		if((edad1 > p.edadMinima && edad1 < p.edadMaxima) && (edad2 > this.edadMinima && edad2 < this.edadMaxima) )
			si= true;
		return si;
	}

	public void mostrarDatos() {
		System.out.println("------------------------------------------------------\n");
		System.out.printf(
				 "Nombre: %s\n "
						+ "Edad: &d\n",
				this.nombre, this.getEdad());
		if(this instanceof Onvre)
			System.out.printf("Soy un Onvre que busca ");
		else if(this instanceof Mujeh)
			System.out.print("Soy una Mujeh que busca ");
		else
			System.out.print("No tengo identidad sexual definida y busco ");
		
		if (this.queBusco==0)
			System.out.print("mujeres\n ");
		else if (this.queBusco==1)
			System.out.print("Onvres\n");
		else
			System.out.print("de todo 7w7\n");
		if(this.edadMinima==18 && this.edadMaxima ==200)
			System.out.print("No tengo preferencias de edad\n");
		else
			System.out.printf("L@s busco entre %d y %d\n", this.edadMinima, this.edadMaxima);
		System.out.println("------------------------------------------------------\n");
		
	}
}
