package EmpresaSeguros;
import java.time.LocalDate;

public class conductor {
	private String nif;
	private int Nacimiento;
	private int ptsCarnet;
	private int añoCarnet;
	
	public conductor(String nif, int nacimiento, int yCarnet, int ptsCarnet){
		this.nif=nif;
		this.Nacimiento=nacimiento;
		this.añoCarnet=yCarnet;
		this.ptsCarnet=ptsCarnet;
	}
	public int edad() {
		LocalDate fechaActual= LocalDate.now();
		int actualYear = fechaActual.getYear();
		int edad = actualYear-this.Nacimiento;
		return edad;
	}
	public int yCarnet() {
		LocalDate fechaActual= LocalDate.now();
		int actualYear = fechaActual.getYear();
		int yCarnet = actualYear-this.Nacimiento;
		return yCarnet;
	}
	public int getPtsCarnet() {
		return this.ptsCarnet;
	}
	
	public void stats() {
		int edad = edad();
		int yCarnet= yCarnet();
		System.out.printf("-------------------\nINFO SOBRE CONDUCTOR.\nEdad: años%d\nAños de Carnet: %d\nPuntos de carnet: %d pts\n-------------------\n",edad,yCarnet,this.ptsCarnet);
	}
	
	
}
