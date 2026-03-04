package def;
import java.util.*;

public class Jornada {
    private int numero;
    private List<Partido> partidos = new ArrayList<>();

    public Jornada(int numero) {
        this.numero = numero;
    }

    public void agregarPartido(Partido p) {
        partidos.add(p);
    }

    public void mostrarEmparejamientos() {
        System.out.println("\n>>> EMPAREJAMIENTOS JORNADA " + numero);
        for (Partido p : partidos) {
            System.out.printf("%20s vs %-20s\n", p.getEquipo1().getNombre(), p.getEquipo2().getNombre());
        }
    }

    public void jugarJornada() {
        Random rand = new Random();
        for (Partido p : partidos) {
            // Lógica de azar: probabilidad base + bonus por potencia del equipo
            int bonus1 = p.getEquipo1().getPotencia() / 3;
            int bonus2 = p.getEquipo2().getPotencia() / 3;
            
            int g1 = rand.nextInt(3) + rand.nextInt(bonus1 + 1);
            int g2 = rand.nextInt(3) + rand.nextInt(bonus2 + 1);
            
            p.resultado(g1, g2);
        }
    }

    public void mostrarResultados() {
        System.out.println("\n=== RESULTADOS JORNADA " + numero + " ===");
        for (Partido p : partidos) {
            System.out.printf("%20s %d - %d %-20s\n", 
                p.getEquipo1().getNombre(), p.getGoles1(), p.getGoles2(), p.getEquipo2().getNombre());
        }
    }
}