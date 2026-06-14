package InterfazAlfabeticamente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> invitados = new ArrayList<>();
        invitados.add("Zulema");
        invitados.add("Carlos");
        invitados.add("Bernardo");
        invitados.add("Ana");

        OrdenadorNombres miOrdenador = new OrdenadorAlfabetico();
        miOrdenador.ordenar(invitados);

        System.out.println("Lista ordenada: " + invitados);
    }
}