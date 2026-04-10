package furbo;
import java.util.HashSet;
public class Competicion {
	private String nombre;
	private HashSet<Equipo> equipos= new HashSet<>() ;
	
	public Competicion(String nombre) {
		this.nombre= nombre;
		
	}
	
	public void addEquipo(Equipo equipo) {
		this.equipos.add(equipo);
	}
	
	public void addEquipos(HashSet<Equipo> equipos) {
		this.equipos.addAll(equipos);
	}
	
	public void verClasificacion() {
		System.out.println("-------------------------------");
		System.out.println("*-                           -*");
		System.out.println("         CLASIFICACIÓN         ");
		System.out.println("*-                           -*");
		
		System.out.println("-------------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
