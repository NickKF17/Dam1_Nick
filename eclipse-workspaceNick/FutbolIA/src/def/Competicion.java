package def;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Competicion {
    private String nombre;
    private HashSet<Equipo> listaEquipos = new HashSet<>();

    public Competicion(String nombre) {
        this.nombre = nombre;
    }

    public void anyadeEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    public List<Jornada> generarCalendario() {
        List<Equipo> equipos = new ArrayList<>(listaEquipos);
        List<Jornada> calendario = new ArrayList<>();
        int numEquipos = equipos.size();

        // Algoritmo Round Robin para 38 jornadas
        for (int i = 0; i < (numEquipos - 1) * 2; i++) {
            Jornada jor = new Jornada(i + 1);
            for (int k = 0; k < numEquipos / 2; k++) {
                Equipo local = equipos.get(k);
                Equipo visitante = equipos.get(numEquipos - 1 - k);
                
                if (i < numEquipos - 1) jor.agregarPartido(new Partido(local, visitante));
                else jor.agregarPartido(new Partido(visitante, local));
            }
            // Rotar
            Equipo ultimo = equipos.remove(numEquipos - 1);
            equipos.add(1, ultimo);
            calendario.add(jor);
        }
        return calendario;
    }

    public void verClasificacion() {
        LocalDate fecha = LocalDate.now();
        ArrayList<Equipo> liga = new ArrayList<>(listaEquipos);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yy");
        String fechaDeHoy = fecha.format(formato);

        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.println("Competición: " + nombre + " | Clasificación a día " + fechaDeHoy);
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-30s | %3s | %2s | %2s | %2s | %2s | %3s | %3s | %3s\n",
                "EQUIPO", "PTS", "PJ", "PG", "PE", "PP", "GF", "GC", "DG");
        System.out.println("-----------------------------------------------------------------------------------");
    	int i=0;
        for (Equipo e : ordenarClasificacion(liga)) {
        
        	i++;
            System.out.printf("%2d.- %-25s | %3d | %2d | %2d | %2d | %2d | %3d | %3d | %3d\n", 
               i, e.getNombre(), e.getPuntos(), e.getPJ(), e.getPG(), e.getPE(), e.getPP(), e.getGF(), e.getGC(), e.getDG());
        }
    }

    public ArrayList<Equipo> ordenarClasificacion(ArrayList<Equipo> liga) {
        boolean cambio;
        do {
            cambio = false;
            for (int i = 0; i < liga.size() - 1; i++) {
                Equipo e1 = liga.get(i);
                Equipo e2 = liga.get(i + 1);
                // Criterio: Puntos, luego Diferencia de Goles
                if (e1.getPuntos() < e2.getPuntos() || (e1.getPuntos() == e2.getPuntos() && e1.getDG() < e2.getDG())) {
                    Collections.swap(liga, i, i + 1);
                    cambio = true;
                }
            }
        } while (cambio);
        return liga;
    }
}