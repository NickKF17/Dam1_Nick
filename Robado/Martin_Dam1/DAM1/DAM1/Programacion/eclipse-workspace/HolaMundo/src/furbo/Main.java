package furbo;
import java.util.ArrayList;
import java.util.List;
public class Main {
	public static void main(String[] args) {
		Competicion laLiga = new Competicion("La liga eaSports");
		
		Equipo elMadrid = new Equipo("Real Madrid FC");
		Equipo Betis = new Equipo("Real Betis CF");
		Equipo idolosh =  new Equipo("Barcelona SC");
		Equipo atletico = new Equipo("Atlético de Madrid");
		Equipo sevilla  = new Equipo("Sevilla FC");
		Equipo valencia = new Equipo("Valencia CF");
		
		ArrayList<Equipo> listaEquipos =  new ArrayList<>(List.of(elMadrid, Betis, idolosh,atletico,sevilla,valencia));

		laLiga.addEquipo(atletico);
		laLiga.addEquipo(sevilla);
		laLiga.addEquipo(valencia);
		laLiga.addEquipo(atletico);
		laLiga.addEquipo(sevilla);
		laLiga.addEquipo(valencia);
		laLiga.addEquipo(elMadrid);
		laLiga.addEquipo(Betis);
		
		
		Jugador j1 = new Jugador("Griezmann", 7, atletico);
		Jugador j2 = new Jugador("Morata", 9, atletico);
		Jugador j3 = new Jugador("Koke", 6, atletico);
		Jugador j4 = new Jugador("Oblak", 1, atletico);
		Jugador j5 = new Jugador("De Paul", 5, atletico);
		Jugador j6 = new Jugador("Llorente", 14, atletico);
		Jugador j7  = new Jugador("Rakitic", 10, sevilla);
		Jugador j8  = new Jugador("Ocampos", 5, sevilla);
		Jugador j9  = new Jugador("Navas", 16, sevilla);
		Jugador j10 = new Jugador("En-Nesyri", 15, sevilla);
		Jugador j11 = new Jugador("Fernando", 20, sevilla);
		Jugador j12 = new Jugador("Suso", 7, sevilla);
		Jugador j13 = new Jugador("Gayà", 14, valencia);
		Jugador j14 = new Jugador("Hugo Duro", 9, valencia);
		Jugador j15 = new Jugador("Solér", 8, valencia);
		Jugador j16 = new Jugador("Mamardashvili", 25, valencia);
		Jugador j17 = new Jugador("Almeida", 23, valencia);
		Jugador j18 = new Jugador("Foulquier", 12, valencia);
		Jugador rm1 = new Jugador("Benzema", 9, elMadrid);
		Jugador rm2 = new Jugador("Modric", 10, elMadrid);
		Jugador rm3 = new Jugador("Kroos", 8, elMadrid);
		Jugador rm4 = new Jugador("Vinicius", 7, elMadrid);
		Jugador rm5 = new Jugador("Courtois", 1, elMadrid);
		Jugador rm6 = new Jugador("Valverde", 15, elMadrid);
		Jugador b1 = new Jugador("Fekir", 8, Betis);
		Jugador b2 = new Jugador("Canales", 10, Betis);
		Jugador b3 = new Jugador("Borja Iglesias", 9, Betis);
		Jugador b4 = new Jugador("Guido Rodríguez", 5, Betis);
		Jugador b5 = new Jugador("Bravo", 1, Betis);
		Jugador b6 = new Jugador("Ayoze Pérez", 11, Betis);
		Jugador bs1 = new Jugador("Messi", 10, idolosh);
		Jugador bs2 = new Jugador("Suárez", 9, idolosh);
		Jugador bs3 = new Jugador("Busquets", 5, idolosh);
		Jugador bs4 = new Jugador("Alba", 18, idolosh);
		Jugador bs5 = new Jugador("Ter Stegen", 1, idolosh);
		Jugador bs6 = new Jugador("Pedri", 16, idolosh);

		

		
		Entrenador entrenador1 = new Entrenador("Simeone", elMadrid);
		Entrenador entrenadorBetis = new Entrenador("Pellegrini", Betis);
		Entrenador entrenadorBS = new Entrenador("Xavi", idolosh);
		Entrenador entrenadorAtletico = new Entrenador("Diego Simeone", atletico);
		Entrenador entrenadorSevilla  = new Entrenador("José Luis Mendilibar", sevilla);
		Entrenador entrenadorValencia = new Entrenador("Rubén Baraja", valencia);


		
		Arbitro arbitro1 = new Arbitro("Alexandru");
		Arbitro arbitro2 = new Arbitro ("Andrea");
		Arbitro arbitro3 = new Arbitro("Mateu");
		Arbitro arbitro4 = new Arbitro("Lahoz");
		
	}
}
