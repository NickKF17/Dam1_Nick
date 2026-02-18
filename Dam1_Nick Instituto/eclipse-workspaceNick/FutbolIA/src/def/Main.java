package def;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Competicion laLiga = new Competicion("La Liga EA Sports");

        // Creamos los 20 equipos con su "Potencia" (del 1 al 10)
        laLiga.anyadeEquipo(new Equipo("FC Barcelona", 10));
        laLiga.anyadeEquipo(new Equipo("Real Madrid", 6));
        laLiga.anyadeEquipo(new Equipo("Atletico Madrid", 6));
        laLiga.anyadeEquipo(new Equipo("Villarreal", 6));
        laLiga.anyadeEquipo(new Equipo("Real Betis", 6));
        laLiga.anyadeEquipo(new Equipo("Athletic Club", 6));
        laLiga.anyadeEquipo(new Equipo("Real Sociedad", 6));
        laLiga.anyadeEquipo(new Equipo("Sevilla FC", 6));
        laLiga.anyadeEquipo(new Equipo("Valencia CF", 6));
        laLiga.anyadeEquipo(new Equipo("Girona FC", 6));
        laLiga.anyadeEquipo(new Equipo("Getafe CF", 4));
        laLiga.anyadeEquipo(new Equipo("Rayo Vallecano", 4));
        laLiga.anyadeEquipo(new Equipo("Osasuna", 5));
        laLiga.anyadeEquipo(new Equipo("Celta de Vigo", 5));
        laLiga.anyadeEquipo(new Equipo("Mallorca", 4));
        laLiga.anyadeEquipo(new Equipo("Alaves", 3));
        laLiga.anyadeEquipo(new Equipo("Espanyol", 3));
        laLiga.anyadeEquipo(new Equipo("Las Palmas", 3));
        laLiga.anyadeEquipo(new Equipo("Leganes", 2));
        laLiga.anyadeEquipo(new Equipo("Valladolid", 2));

        // Generamos el calendario de 38 jornadas automáticamente
        List<Jornada> temporada = laLiga.generarCalendario();

        // Simulamos la temporada completa
        for (Jornada j : temporada) {
            j.mostrarEmparejamientos(); // Dice quién juega
            j.jugarJornada();           // Resultados al azar con potencia
            j.mostrarResultados();      // Muestra marcadores reales
        }

        // Imprime la tabla final con tu estructura exacta
        laLiga.verClasificacion();
    }
}