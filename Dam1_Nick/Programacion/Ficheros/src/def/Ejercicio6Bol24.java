package def;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio6Bol24 {

    public static void main(String[] args) {
        String fSoluciones = "soluciones.txt";
        String fRespuestas = "respuestas.txt";
        String fNotas = "notas.txt";

        String[] soluciones = leeSoluciones(fSoluciones);
        HashMap<String, String[]> respuestas = leeRespuestas(fRespuestas);
        
        // Solo procedemos si hemos podido leer los datos
        if (soluciones != null && respuestas != null) {
            grabaNotas(fNotas, soluciones, respuestas);
            System.out.println("Proceso finalizado. Revisa el archivo: " + fNotas);
        }
    }

    public static String[] leeSoluciones(String fichero) {
        try {
            Path ruta = Path.of(fichero);
            String contenido = Files.readString(ruta).trim(); // trim() quita espacios/saltos al final
            return contenido.split(",\\s*"); // "\\s*" permite que funcione con o sin espacio tras la coma
        } catch (Exception e) {
            System.err.println("Error leyendo soluciones: " + e.getMessage());
            return null;
        }
    }

    public static HashMap<String, String[]> leeRespuestas(String fichero) {
        HashMap<String, String[]> diccionario = new HashMap<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.contains(":")) {
                    String[] partes = linea.split(":");
                    String alumno = partes[0].trim();
                    String respuestasStr = partes[1].trim();
                    diccionario.put(alumno, respuestasStr.split(",\\s*"));
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo respuestas: " + e.getMessage());
        }
        return diccionario;
    }

    public static void grabaNotas(String fichero, String[] soluciones, HashMap<String, String[]> respuestas) {
        // Usamos try-with-resources para asegurar que el archivo se cierre y guarde
        try (PrintWriter escritor = new PrintWriter(new FileWriter(fichero))) {
            for (Map.Entry<String, String[]> entrada : respuestas.entrySet()) {
                double nota = calcularNota(soluciones, entrada.getValue());
                escritor.println(entrada.getKey() + ": " + nota);
                
            }
        } catch (Exception e) {
            System.err.println("Error al grabar notas: " + e.getMessage());
        }
    }

    public static double calcularNota(String[] soluciones, String[] respuesta) {
        double nota = 0;
        // Comparamos hasta el mínimo de los dos para evitar errores de índice
        int limite = Math.min(soluciones.length, respuesta.length);
        
        for (int i = 0; i < limite; i++) {
            if (soluciones[i].equalsIgnoreCase(respuesta[i].trim())) {
                nota += 1;
            } else {
                nota -= 0.3;
            }
        }
      //  return Math.round(nota*10.0)/10.0;
       return Math.max(0, nota); // Opcional: evita notas negativas si quieres
    }
}