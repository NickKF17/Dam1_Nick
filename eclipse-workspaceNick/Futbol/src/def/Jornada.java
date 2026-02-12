package def;
import java.util.*;

public class Jornada {
    int numero;
    List<Partido> partidos;

    public Jornada(int numero) {
        this.numero = numero;
        this.partidos = new ArrayList<>();
    }

    public void agregarPartido(Partido p) {
        partidos.add(p);
    }

    public void mostrarEmparejamientos() {
        System.out.println("--- EMPAREJAMIENTOS JORNADA " + numero + " ---");
        for (Partido p : partidos) {
            System.out.println(p.getEquipo1().getNombre() + " vs " + p.getEquipo2().getNombre());
        }
    }

    public void jugarJornada() {
        Random rand = new Random();
        for (Partido p : partidos) {
            // Genera goles aleatorios (0 a 4)
            p.resultado(rand.nextInt(5), rand.nextInt(5));
        }
    }

    public void mostrarResultados() {
        System.out.println("=== RESULTADOS JORNADA " + numero + " ===");
        for (Partido p : partidos) {
            System.out.println(p.getResumen());
        }
        System.out.println();
    }
}