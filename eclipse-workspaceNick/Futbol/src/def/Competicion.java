package def;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Competicion {
	private String nombre;
	HashSet<Equipo> listaEquipos=new HashSet<>();
	public Competicion(String nombre){
		this.nombre=nombre;
	}
	public void anyadeEquipo(Equipo equipo){
		listaEquipos.add(equipo);
	}
	public void anyadeEquipos(HashSet<Equipo> equipos) {
		listaEquipos.addAll(equipos);
	}
	public void verClasificacion() {
		LocalDate fecha =LocalDate.now();
		ArrayList<Equipo> liga = new ArrayList<>(listaEquipos);
	DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yy") ;
	String fechaDeHoy=fecha.format(formato);
	System.out.println("-----------------------------------------------------------------------------------");
	System.out.println("Competición: " + nombre + " | Clasificación a día " + fechaDeHoy);
	System.out.println("-----------------------------------------------------------------------------------");
	System.out.printf("%-25s | %3s | %2s | %2s | %2s | %2s | %3s | %3s | %3s\n",
			"EQUIPO", "PTS", "PJ", "PG", "PE", "PP", "GF", "GC","DG");
			System.out.println("-----------------------------------------------------------------------------------");
			for (Equipo e : ordenarClasificacion(liga)) {
			System.out.printf("%-25s | %3d | %2d | %2d | %2d | %2d | %3d | %3d | %3d\n", e.getNombre(),e.getPuntos(),e.getPJ(),e.getPG(),e.getPE(),e.getPP(),e.getGF(),
			e.getGC(),e.getDG()
			);
	}
}
	public  ArrayList<Equipo> ordenarClasificacion(ArrayList<Equipo> liga2) {
		boolean cambio;
		Equipo equi1;
		Equipo equi2;
		ArrayList<Equipo> liga = new ArrayList<>(this.getEquipos());
		do {
			cambio = false;
			for (int i = 0; i < liga.size() - 1; i++) {
				equi1 = (Equipo) liga.get(i);
				equi2 = (Equipo) liga.get(i + 1);

				if (equi1.getPuntos() < equi2.getPuntos()) {
					Collections.swap(liga, liga.indexOf(equi1), liga.indexOf(equi2));
					cambio = true;
					}

				else if(equi1.getPuntos()==equi2.getPuntos()){
					if(equi1.getDG()<equi2.getDG())
						Collections.swap(liga, liga.indexOf(equi1), liga.indexOf(equi2));	
				
				}

			}
		} while (cambio == true);

		return liga;
	}
	
	public  ArrayList<Equipo> ordenarClasificacionPorGoles(ArrayList<Equipo> liga2) {
		boolean cambio;
		Equipo equi1;
		Equipo equi2;
		ArrayList<Equipo> liga = new ArrayList<>(this.getEquipos());
		do {
			cambio = false;
			for (int i = 0; i < liga.size() - 1; i++) {
				equi1 = (Equipo) liga.get(i);
				equi2 = (Equipo) liga.get(i + 1);

				if (equi1.getDG() < equi2.getDG()) {
					Collections.swap(liga, liga.indexOf(equi1), liga.indexOf(equi2));
					cambio = true;
				}

			}
		} while (cambio == true);

		return liga;
	}
	
		public void quienVaPrimero(Equipo equi1, Equipo equi2) {
		    Equipo mayor;

		    if (equi1.getPuntos() > equi2.getPuntos()) {
		        mayor = equi1;
		    } else if (equi1.getPuntos() < equi2.getPuntos()) {
		        mayor = equi2;
		    } else { // mismos puntos
		        if (equi1.getDG() > equi2.getDG()) {
		            mayor = equi1;
		        } else if (equi1.getDG() < equi2.getDG()) {
		            mayor = equi2;
		        } else {
		            // Empate total
		            System.out.println("Están completamente empatados");
		            return;
		        }
		    }

		    System.out.println(mayor.getNombre());
		}
	public Equipo QuienvaprimeroParaOrdenar(Equipo equi1,Equipo equi2) {
		Equipo mayor=null;
		if (equi1.getPuntos() < equi2.getPuntos()) {
			mayor=equi2;
			}
		if (equi1.getPuntos() > equi2.getPuntos()) {
			mayor=equi2;
			}
		else if(equi1.getPuntos()==equi2.getPuntos()){
			if(equi1.getDG()<equi2.getDG())
				mayor=equi2;
		}
		return mayor;

	}
	public HashSet<Equipo> getEquipos(){
		return this.listaEquipos;
	}
}
