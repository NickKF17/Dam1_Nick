package Documentacion;

import java.util.*;

/**
 * Clase principal que demuestra el uso de algoritmos de ordenación.
 * <p>
 * Contiene implementaciones de ordenación por selección y por burbuja
 * aplicadas sobre listas de enteros.
 * </p>
 *
 * @author Nick Constante
 * @version 1.0
 * @since 2026-05-05
 */
public class Algoritmos {

    /**
     * Punto de entrada de la aplicación.
     * <p>
     * Inicializa una lista de enteros desordenada y aplica el algoritmo
     * de ordenación por burbuja, mostrando el resultado por consola.
     * </p>
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList(List.of(7, 1, 3, 5, 4, 6, 14));
        // ArrayList<Integer> ordenada1 = ordenarPorSeleccion(numeros);
        // System.out.println(ordenada1);

        ArrayList<Integer> ordenada2 = ordenarPorBurbuja(numeros);
        System.out.println(ordenada2);
    }

    /**
     * Ordena una lista de enteros de mayor a menor mediante el algoritmo de selección.
     * <p>
     * En cada iteración busca el valor máximo de la lista original,
     * lo extrae y lo añade a la lista resultado, repitiéndolo hasta
     * vaciar la lista de entrada.
     * </p>
     * <p>
     * <b>Nota:</b> Este método modifica y vacía la lista {@code desordenada} recibida.
     * </p>
     *
     * @param desordenada lista de enteros a ordenar (será vaciada durante el proceso)
     * @return nueva lista con los elementos ordenados de mayor a menor
     * @deprecated Usar {@link #ordenarPorBurbuja(ArrayList)} como alternativa.
     *             Este método destruye la lista original como efecto secundario.
     */
    @Deprecated
    public static ArrayList<Integer> ordenarPorSeleccion(ArrayList<Integer> desordenada) {
        ArrayList<Integer> ordenada = new ArrayList<>();
        int mayor = -1;
        do {
            for (int n : desordenada) {
                if (n > mayor)
                    mayor = n;
            }
            desordenada.remove((Integer) mayor);
            ordenada.add(mayor);
            mayor = -1;
        } while (desordenada.size() != 0);

        return ordenada;
    }

    /**
     * Ordena una lista de enteros de mayor a menor mediante el algoritmo de burbuja.
     * <p>
     * Recorre la lista repetidamente comparando pares de elementos adyacentes
     * e intercambiándolos si están en el orden incorrecto. El proceso se repite
     * hasta que no se produzca ningún intercambio en una pasada completa.
     * </p>
     *
     * @param numeros lista de enteros a ordenar
     * @return la misma lista recibida con los elementos ordenados de mayor a menor
     */
    public static ArrayList ordenarPorBurbuja(ArrayList numeros) {
        boolean cambio;
        int num1;
        int num2;
        do {
            cambio = false;
            for (int i = 0; i < numeros.size() - 1; i++) {
                num1 = (int) numeros.get(i);
                num2 = (int) numeros.get(i + 1);

                if (num1 < num2) {
                    Collections.swap(numeros, numeros.indexOf(num1), numeros.indexOf(num2));
                    cambio = true;
                }
            }
        } while (cambio == true);

        return numeros;
    }
}