package InterfazAlfabeticamente;

import java.util.Arrays;
import java.util.Collections;

public class TestInverso {
    public static void main(String[] args) {
        String[] nombres = {"Ana", "Carlos", "Bernardo", "Zulema"};

        // Ordenar de Z a A
        Arrays.sort(nombres, Collections.reverseOrder());

        System.out.println(Arrays.toString(nombres)); 
        // Salida: [Zulema, Carlos, Bernardo, Ana]
    }
}