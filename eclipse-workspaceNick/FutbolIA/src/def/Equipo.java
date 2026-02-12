package def;
import java.util.HashSet;

public class Equipo {
    private String nombre;
    private int potencia; // Del 1 al 10 (influye en los goles)
    private HashSet<Jugador> plantilla = new HashSet<>();
    private int ganados = 0, perdidos = 0, empatados = 0;
    private int golesAfavor = 0, golesEncontra = 0, puntos = 0;

    public Equipo(String nombre, int potencia) {
        this.nombre = nombre;
        this.potencia = potencia;
    }

    public String getNombre() { return nombre; }
    public int getPuntos() { return puntos; }
    public int getPJ() { return ganados + perdidos + empatados; }
    public int getPG() { return ganados; }
    public int getPE() { return empatados; }
    public int getPP() { return perdidos; }
    public int getGF() { return golesAfavor; }
    public int getGC() { return golesEncontra; }
    public int getDG() { return golesAfavor - golesEncontra; }
    public int getPotencia() { return potencia; }

    public void ganaPartido() { this.ganados++; this.puntos += 3; }
    public void pierdePartido() { this.perdidos++; }
    public void empataPartido() { this.empatados++; this.puntos += 1; }
    
    public void cambiaGoles(int afavor, int encontra) {
        this.golesAfavor += afavor;
        this.golesEncontra += encontra;
    }
    
    public void anyadeJugador(Jugador jugador) {
        this.plantilla.add(jugador);
    }
}