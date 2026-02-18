package def;

public class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private int goles1; // Guardamos el resultado real
    private int goles2;

    public Partido(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public void resultado(int g1, int g2) {
        this.goles1 = g1;
        this.goles2 = g2;

        if (goles1 > goles2) {
            equipo1.ganaPartido();
            equipo2.pierdePartido();
        } else if (goles2 > goles1) {
            equipo1.pierdePartido();
            equipo2.ganaPartido();
        } else {
            equipo1.empataPartido();
            equipo2.empataPartido();
        }
        equipo1.cambiaGoles(goles1, goles2);
        equipo2.cambiaGoles(goles2, goles1);
    }

    public Equipo getEquipo1() { return equipo1; }
    public Equipo getEquipo2() { return equipo2; }
    public int getGoles1() { return goles1; }
    public int getGoles2() { return goles2; }
}