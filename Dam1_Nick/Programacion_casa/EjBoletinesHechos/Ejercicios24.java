import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicios24 {

    static Scanner sc = new Scanner(System.in);

    // EJERCICIO 1
    public static void ejercicio1() {
        System.out.print("Número entre 1 y 10: ");
        int n = sc.nextInt();

        try (PrintWriter pw = new PrintWriter(new FileWriter("tabla-" + n + ".txt"))) {
            for (int i = 1; i <= 10; i++) {
                pw.println(n + " x " + i + " = " + (n * i));
            }
            System.out.println("Tabla guardada en tabla-" + n + ".txt");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero");
        }
    }

    // EJERCICIO 2
    public static void ejercicio2() {
        System.out.print("Número entre 1 y 10: ");
        int n = sc.nextInt();

        try (BufferedReader br = new BufferedReader(new FileReader("tabla-" + n + ".txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("El fichero no existe");
        }
    }

    // EJERCICIO 3
    public static void ejercicio3() {
        System.out.print("Cantidad de números de Fibonacci: ");
        int n = sc.nextInt();

        if (n < 1) {
            System.out.println("Error: el número debe ser >= 1");
            return;
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("fibonacci.txt"))) {
            int a = 0;
            int b = 1;

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    pw.print(", ");
                }
                pw.print(a);
                int siguiente = a + b;
                a = b;
                b = siguiente;
            }
            pw.println();
            System.out.println("Fibonacci guardado en fibonacci.txt");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero");
        }
    }

    // EJERCICIO 4
    public static void darlavuelta(String origen, String destino) {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(origen))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero origen");
            return;
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(destino))) {
            for (int i = lineas.size() - 1; i >= 0; i--) {
                String lineaOriginal = lineas.get(i);
                String lineaInvertida = "";
                for (int j = lineaOriginal.length() - 1; j >= 0; j--) {
                    lineaInvertida = lineaInvertida + lineaOriginal.charAt(j);
                }
                pw.println(lineaInvertida);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero destino");
        }
    }

    // EJERCICIO 5
    public static void ejercicio5() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("compra.txt"))) {
            int numArticulos = 0;
            double precioTotal = 0.0;
            boolean continuar = true;

            while (continuar) {
                System.out.print("Introduce un artículo: ");
                String articulo = sc.nextLine();

                System.out.print("Introduce la cantidad: ");
                double cantidad = sc.nextDouble();
                sc.nextLine();

                System.out.print("Introduce el precio: ");
                double precio = sc.nextDouble();
                sc.nextLine();

                pw.println(cantidad + " " + articulo);
                numArticulos++;
                precioTotal = precioTotal + (cantidad * precio);

                System.out.print("Quieres seguir introduciendo artículos (si/no): ");
                String respuesta = sc.nextLine();
                if (respuesta.equals("no")) {
                    continuar = false;
                }
            }

            pw.println("Total artículos en la lista: " + numArticulos);
            pw.println("Precio de la compra: " + precioTotal);

            System.out.println("Tu lista de la compra se encuentra en el fichero compra.txt");

        } catch (IOException e) {
            System.out.println("Error al guardar la lista de la compra");
        }
    }

    // EJERCICIO 6
    public static void ejercicio6() {
        String[] soluciones = new String[10];
        boolean errorSoluciones = false;

        try (BufferedReader br = new BufferedReader(new FileReader("soluciones.txt"))) {
            String linea = br.readLine();
            if (linea != null) {
                int pos = 0;
                int inicio = 0;
                int indiceSol = 0;
                while (pos < linea.length() && indiceSol < 10) {
                    if (linea.charAt(pos) == ',' || pos == linea.length() - 1) {
                        String sol = "";
                        int fin = pos;
                        if (pos == linea.length() - 1) {
                            fin = pos + 1;
                        }
                        for (int i = inicio; i < fin; i++) {
                            if (linea.charAt(i) != ' ' && linea.charAt(i) != ',') {
                                sol = sol + linea.charAt(i);
                            }
                        }
                        if (sol.length() == 1 && (sol.equals("A") || sol.equals("B") || sol.equals("C") || sol.equals("D"))) {
                            soluciones[indiceSol] = sol;
                            indiceSol++;
                        } else {
                            errorSoluciones = true;
                        }
                        inicio = pos + 1;
                    }
                    pos++;
                }
                if (indiceSol != 10) {
                    errorSoluciones = true;
                }
            } else {
                errorSoluciones = true;
            }
        } catch (IOException e) {
            errorSoluciones = true;
        }

        if (errorSoluciones) {
            System.out.println("Error en el fichero de soluciones");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader("respuestas.txt"));
             PrintWriter pw = new PrintWriter(new FileWriter("notas.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                int dosPuntos = -1;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == ':') {
                        dosPuntos = i;
                    }
                }
                if (dosPuntos == -1) {
                    continue;
                }

                String nombre = "";
                for (int i = 0; i < dosPuntos; i++) {
                    nombre = nombre + linea.charAt(i);
                }

                String respuestasStr = "";
                for (int i = dosPuntos + 2; i < linea.length(); i++) {
                    respuestasStr = respuestasStr + linea.charAt(i);
                }

                String[] respuestas = new String[10];
                int pos = 0;
                int inicio = 0;
                int indiceResp = 0;
                boolean errorRespuesta = false;

                while (pos < respuestasStr.length() && indiceResp < 10 && !errorRespuesta) {
                    if (respuestasStr.charAt(pos) == ',' || pos == respuestasStr.length() - 1) {
                        String resp = "";
                        int fin = pos;
                        if (pos == respuestasStr.length() - 1) {
                            fin = pos + 1;
                        }
                        for (int i = inicio; i < fin; i++) {
                            if (respuestasStr.charAt(i) != ' ' && respuestasStr.charAt(i) != ',') {
                                resp = resp + respuestasStr.charAt(i);
                            }
                        }
                        if (resp.length() == 1 && (resp.equals("A") || resp.equals("B") || resp.equals("C") || resp.equals("D"))) {
                            respuestas[indiceResp] = resp;
                            indiceResp++;
                        } else {
                            errorRespuesta = true;
                        }
                        inicio = pos + 1;
                    }
                    pos++;
                }

                if (errorRespuesta || indiceResp != 10) {
                    continue;
                }

                double nota = 0.0;
                for (int i = 0; i < 10; i++) {
                    if (respuestas[i].equals(soluciones[i])) {
                        nota = nota + 1.0;
                    } else {
                        nota = nota - 0.3;
                    }
                }

                pw.println(nombre + ": " + nota);
            }

        } catch (IOException e) {
            System.out.println("Error al procesar los ficheros");
        }
    }

    // EJERCICIO 7
    public static void ejercicio7() {
        String fichero = "/home/josemaria/login.txt";

        System.out.print("Introduce el nombre del usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Introduce la contraseña: ");
        String pwd1 = sc.nextLine();

        System.out.print("Vuelve a introducir la contraseña de nuevo: ");
        String pwd2 = sc.nextLine();

        if (pwd1.equals(pwd2)) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(fichero, true))) {
                pw.println(usuario + ":" + pwd1);
                System.out.println("Cuenta de usuario grabada correctamente");
            } catch (IOException e) {
                System.out.println("Error al guardar la cuenta");
            }
        } else {
            System.out.println("Las contraseñas no son iguales. No se puede grabar la nueva cuenta");
        }
    }

    // EJERCICIO 8
    public static void ejercicio8() {
        String origen = "/home/josemaria/origen.txt";
        String destino = "/home/josemaria/salida.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(origen));
             PrintWriter pw = new PrintWriter(new FileWriter(destino))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                boolean esCorrecta = true;

                int puntoComa1 = -1;
                int puntoComa2 = -1;
                int contPuntoComa = 0;

                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == ';') {
                        contPuntoComa++;
                        if (contPuntoComa == 1) {
                            puntoComa1 = i;
                        } else if (contPuntoComa == 2) {
                            puntoComa2 = i;
                        }
                    }
                }

                if (contPuntoComa != 2) {
                    esCorrecta = false;
                } else {
                    String nombreApellido = "";
                    for (int i = 0; i < puntoComa1; i++) {
                        nombreApellido = nombreApellido + linea.charAt(i);
                    }

                    int coma = -1;
                    for (int i = 0; i < nombreApellido.length(); i++) {
                        if (nombreApellido.charAt(i) == ',') {
                            coma = i;
                        }
                    }

                    if (coma == -1) {
                        esCorrecta = false;
                    } else {
                        String apellidos = "";
                        for (int i = 0; i < coma; i++) {
                            if (nombreApellido.charAt(i) != ' ') {
                                apellidos = apellidos + nombreApellido.charAt(i);
                            }
                        }
                        String nombre = "";
                        for (int i = coma + 1; i < nombreApellido.length(); i++) {
                            if (nombreApellido.charAt(i) != ' ') {
                                nombre = nombre + nombreApellido.charAt(i);
                            }
                        }

                        boolean soloLetrasApellidos = true;
                        for (int i = 0; i < apellidos.length() && soloLetrasApellidos; i++) {
                            char c = apellidos.charAt(i);
                            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                                  c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                                  c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                                  c == 'ñ' || c == 'Ñ')) {
                                soloLetrasApellidos = false;
                            }
                        }

                        boolean soloLetrasNombre = true;
                        for (int i = 0; i < nombre.length() && soloLetrasNombre; i++) {
                            char c = nombre.charAt(i);
                            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                                  c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                                  c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                                  c == 'ñ' || c == 'Ñ')) {
                                soloLetrasNombre = false;
                            }
                        }

                        if (!soloLetrasApellidos || !soloLetrasNombre) {
                            esCorrecta = false;
                        }
                    }

                    if (esCorrecta) {
                        String salarioStr = "";
                        for (int i = puntoComa2 + 1; i < linea.length(); i++) {
                            salarioStr = salarioStr + linea.charAt(i);
                        }

                        boolean esNumero = true;
                        int puntos = 0;
                        for (int i = 0; i < salarioStr.length() && esNumero; i++) {
                            char c = salarioStr.charAt(i);
                            if (c == '.') {
                                puntos++;
                                if (puntos > 1) {
                                    esNumero = false;
                                }
                            } else if (c < '0' || c > '9') {
                                esNumero = false;
                            }
                        }

                        if (!esNumero) {
                            esCorrecta = false;
                        }
                    }
                }

                if (esCorrecta) {
                    pw.println(linea);
                } else {
                    System.out.println("Línea errónea: " + linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al procesar los ficheros");
        }
    }

    // EJERCICIO 9
    public static void ejercicio9() {
        String fichero = "/home/josemaria/empleados.txt";
        ArrayList<String> lineasOriginales = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasOriginales.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
            return;
        }

        ArrayList<String> lineasConEdad = new ArrayList<>();

        for (int i = 0; i < lineasOriginales.size(); i++) {
            String linea = lineasOriginales.get(i);

            int puntoComa = -1;
            for (int j = 0; j < linea.length(); j++) {
                if (linea.charAt(j) == ';') {
                    puntoComa = j;
                    break;
                }
            }

            String nombreApellido = "";
            for (int j = 0; j < puntoComa; j++) {
                nombreApellido = nombreApellido + linea.charAt(j);
            }

            int coma = -1;
            for (int j = 0; j < nombreApellido.length(); j++) {
                if (nombreApellido.charAt(j) == ',') {
                    coma = j;
                }
            }

            String apellidos = "";
            for (int j = 0; j < coma; j++) {
                if (nombreApellido.charAt(j) != ' ') {
                    apellidos = apellidos + nombreApellido.charAt(j);
                }
            }

            String nombre = "";
            for (int j = coma + 1; j < nombreApellido.length(); j++) {
                if (nombreApellido.charAt(j) != ' ') {
                    nombre = nombre + nombreApellido.charAt(j);
                }
            }

            int edad = 0;
            boolean edadValida = false;

            while (!edadValida) {
                System.out.print(nombre + " " + apellidos + ". ¿Cuál es su edad? ");
                if (sc.hasNextInt()) {
                    edad = sc.nextInt();
                    if (edad >= 18 && edad < 67) {
                        edadValida = true;
                    } else {
                        System.out.println("Edad fuera de rango (18-66)");
                    }
                } else {
                    System.out.println("Debe ser un número entero");
                    sc.next();
                }
            }
            sc.nextLine();

            lineasConEdad.add(linea + ";" + edad);
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(fichero))) {
            for (int i = 0; i < lineasConEdad.size(); i++) {
                pw.println(lineasConEdad.get(i));
            }
            System.out.println("Edades añadidas correctamente");
        } catch (IOException e) {
            System.out.println("Error al guardar el fichero");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1 ===");
        ejercicio1();

        System.out.println("\n=== EJERCICIO 2 ===");
        ejercicio2();

        System.out.println("\n=== EJERCICIO 3 ===");
        ejercicio3();

        System.out.println("\n=== EJERCICIO 4 ===");
        darlavuelta("fichero1.txt", "fichero2.txt");
        System.out.println("Fichero invertido correctamente");

        System.out.println("\n=== EJERCICIO 5 ===");
        ejercicio5();

        System.out.println("\n=== EJERCICIO 6 ===");
        ejercicio6();

        System.out.println("\n=== EJERCICIO 7 ===");
        ejercicio7();

        System.out.println("\n=== EJERCICIO 8 ===");
        ejercicio8();

        System.out.println("\n=== EJERCICIO 9 ===");
        ejercicio9();
    }
}