import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Ejercicios23 {

    static Scanner sc = new Scanner(System.in);

    // EJERCICIO 1
    public static void ejercicio1() {
        String nombre = "";
        BufferedReader br = null;
        boolean archivoValido = false;

        while (!archivoValido) {
            System.out.print("Introduce el nombre del fichero: ");
            nombre = sc.nextLine();
            try {
                br = new BufferedReader(new FileReader(nombre));
                archivoValido = true;
            } catch (IOException e) {
                System.out.println("El fichero " + nombre + " no existe");
            }
        }

        System.out.print("Introduce la palabra a buscar: ");
        String palabra = sc.nextLine();

        int numLineas = 0;
        int contador = 0;
        String linea;

        try {
            while ((linea = br.readLine()) != null) {
                numLineas++;
                int pos = 0;
                while (pos < linea.length()) {
                    int encontrado = linea.indexOf(palabra, pos);
                    if (encontrado != -1) {
                        contador++;
                        pos = encontrado + 1;
                    } else {
                        pos = linea.length();
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
        }

        System.out.println("El fichero tiene " + numLineas + " líneas");
        System.out.println("La palabra " + palabra + " aparece " + contador + " veces");
    }

    // EJERCICIO 2
    public static void estadisticas(String nombreFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            int numLineas = 0;
            int lineasBlanco = 0;
            int totalCaracteresSinEspacios = 0;
            int totalEspacios = 0;

            while ((linea = br.readLine()) != null) {
                numLineas++;
                String lineaSinEspacios = "";
                for (int i = 0; i < linea.length(); i++) {
                    char c = linea.charAt(i);
                    if (c == ' ') {
                        totalEspacios++;
                    } else {
                        lineaSinEspacios = lineaSinEspacios + c;
                    }
                }
                totalCaracteresSinEspacios = totalCaracteresSinEspacios + lineaSinEspacios.length();

                boolean esBlanco = true;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) != ' ' && linea.charAt(i) != '\t') {
                        esBlanco = false;
                    }
                }
                if (esBlanco) {
                    lineasBlanco++;
                }
            }

            System.out.println("Número de líneas: " + numLineas);
            System.out.println("Líneas en blanco: " + lineasBlanco);
            System.out.println("Cantidad de caracteres sin contar los espacios: " + totalCaracteresSinEspacios);
            System.out.println("Cantidad de espacios: " + totalEspacios);

        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }

    // EJERCICIO 3
    public static void ejercicio3() {
        System.out.print("Introduce el nombre del fichero: ");
        String nombre = sc.nextLine();

        int totalPalabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                boolean enPalabra = false;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == ' ') {
                        if (enPalabra) {
                            totalPalabras++;
                            enPalabra = false;
                        }
                    } else {
                        enPalabra = true;
                    }
                }
                if (enPalabra) {
                    totalPalabras++;
                }
            }
            System.out.println("Número de palabras: " + totalPalabras);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }

    // EJERCICIO 4
    public static boolean compararFicheros(String fichero1, String fichero2) {
        boolean sonIguales = true;

        try (BufferedReader br1 = new BufferedReader(new FileReader(fichero1));
             BufferedReader br2 = new BufferedReader(new FileReader(fichero2))) {
            String linea1, linea2;

            while (sonIguales && (linea1 = br1.readLine()) != null) {
                linea2 = br2.readLine();
                if (linea2 == null) {
                    sonIguales = false;
                } else {
                    if (linea1.length() != linea2.length()) {
                        sonIguales = false;
                    } else {
                        for (int i = 0; i < linea1.length() && sonIguales; i++) {
                            if (linea1.charAt(i) != linea2.charAt(i)) {
                                sonIguales = false;
                            }
                        }
                    }
                }
            }

            if (sonIguales && br2.readLine() != null) {
                sonIguales = false;
            }

        } catch (IOException e) {
            sonIguales = false;
        }

        return sonIguales;
    }

    // EJERCICIO 5
    public static void ejercicio5() {
        try (BufferedReader br = new BufferedReader(new FileReader("estadisticas.txt"))) {
            String linea;
            int hombres = 0;
            int mujeres = 0;
            double sumaAlturas = 0.0;
            int totalPersonas = 0;

            while ((linea = br.readLine()) != null) {
                String sexo = "";
                String alturaStr = "";
                boolean esSexo = true;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == ' ') {
                        esSexo = false;
                    } else {
                        if (esSexo) {
                            sexo = sexo + linea.charAt(i);
                        } else {
                            alturaStr = alturaStr + linea.charAt(i);
                        }
                    }
                }

                double altura = 0.0;
                int puntoDecimal = -1;
                for (int i = 0; i < alturaStr.length(); i++) {
                    if (alturaStr.charAt(i) == '.') {
                        puntoDecimal = i;
                    }
                }
                if (puntoDecimal != -1) {
                    String parteEntera = "";
                    String parteDecimal = "";
                    for (int i = 0; i < alturaStr.length(); i++) {
                        if (i < puntoDecimal) {
                            parteEntera = parteEntera + alturaStr.charAt(i);
                        } else if (i > puntoDecimal) {
                            parteDecimal = parteDecimal + alturaStr.charAt(i);
                        }
                    }
                    double entero = 0;
                    for (int i = 0; i < parteEntera.length(); i++) {
                        entero = entero * 10 + (parteEntera.charAt(i) - '0');
                    }
                    double decimal = 0;
                    for (int i = 0; i < parteDecimal.length(); i++) {
                        decimal = decimal * 10 + (parteDecimal.charAt(i) - '0');
                    }
                    for (int i = 0; i < parteDecimal.length(); i++) {
                        decimal = decimal / 10;
                    }
                    altura = entero + decimal;
                } else {
                    for (int i = 0; i < alturaStr.length(); i++) {
                        altura = altura * 10 + (alturaStr.charAt(i) - '0');
                    }
                }

                if (sexo.equals("Hombre")) {
                    hombres++;
                } else if (sexo.equals("Mujer")) {
                    mujeres++;
                }
                sumaAlturas = sumaAlturas + altura;
                totalPersonas++;
            }

            double media = 0.0;
            if (totalPersonas > 0) {
                media = sumaAlturas / totalPersonas;
            }

            System.out.print("Hombres: " + hombres + ". Mujeres: " + mujeres + ". Estatura media: ");
            int enteroMedia = (int) media;
            int decimalMedia = (int) ((media - enteroMedia) * 100);
            System.out.println(enteroMedia + "." + decimalMedia);

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
        }
    }

    // EJERCICIO 6
    public static void ejercicio6() {
        System.out.print("Introduce el nombre del fichero agenda: ");
        String nombre = sc.nextLine();

        boolean correcto = true;
        int contadorLineas = 0;
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                contadorLineas++;
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
            correcto = false;
        }

        if (correcto && contadorLineas % 3 != 0) {
            correcto = false;
        }

        for (int i = 0; i < lineas.size() && correcto; i++) {
            int resto = (i + 1) % 3;
            if (resto == 0) {
                String edadStr = lineas.get(i);
                boolean esNumero = true;
                for (int j = 0; j < edadStr.length() && esNumero; j++) {
                    if (edadStr.charAt(j) < '0' || edadStr.charAt(j) > '9') {
                        esNumero = false;
                    }
                }
                if (!esNumero) {
                    correcto = false;
                }
            } else {
                String texto = lineas.get(i);
                boolean soloLetras = true;
                for (int j = 0; j < texto.length() && soloLetras; j++) {
                    char c = texto.charAt(j);
                    if (c != ' ' && !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                                       c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                                       c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                                       c == 'ñ' || c == 'Ñ')) {
                        soloLetras = false;
                    }
                }
                if (!soloLetras) {
                    correcto = false;
                }
            }
        }

        if (correcto) {
            System.out.println("El formato del fichero es correcto");
        } else {
            System.out.println("El formato del fichero es incorrecto");
        }
    }

    // EJERCICIO 7
    static class Persona {
        String nombre;
        String apellido;
        int edad;

        Persona(String nombre, String apellido, int edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
        }

        void mostrar() {
            System.out.println(this.nombre + " " + this.apellido + ", " + this.edad + " años");
        }
    }

    public static void ejercicio7() {
        System.out.print("Introduce el nombre del fichero agenda: ");
        String nombre = sc.nextLine();

        ArrayList<Persona> contactos = new ArrayList<>();
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
        }

        for (int i = 0; i + 2 < lineas.size(); i = i + 3) {
            String nom = lineas.get(i);
            String ape = lineas.get(i + 1);
            String edadStr = lineas.get(i + 2);

            boolean nombreValido = true;
            for (int j = 0; j < nom.length(); j++) {
                char c = nom.charAt(j);
                if (c != ' ' && !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                    nombreValido = false;
                }
            }

            boolean apellidoValido = true;
            for (int j = 0; j < ape.length(); j++) {
                char c = ape.charAt(j);
                if (c != ' ' && !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                    apellidoValido = false;
                }
            }

            boolean edadValida = true;
            int edad = 0;
            for (int j = 0; j < edadStr.length(); j++) {
                if (edadStr.charAt(j) >= '0' && edadStr.charAt(j) <= '9') {
                    edad = edad * 10 + (edadStr.charAt(j) - '0');
                } else {
                    edadValida = false;
                }
            }

            if (nombreValido && apellidoValido && edadValida) {
                contactos.add(new Persona(nom, ape, edad));
            }
        }

        for (int i = 0; i < contactos.size(); i++) {
            contactos.get(i).mostrar();
        }
    }

    // EJERCICIO 8
    public static void ejercicio8() {
        System.out.print("Introduce el nombre del fichero agenda: ");
        String nombre = sc.nextLine();

        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
        }

        for (int i = 0; i + 2 < lineas.size(); i = i + 3) {
            String nombreCompleto = lineas.get(i);
            String categoria = lineas.get(i + 1);
            String edadStr = lineas.get(i + 2);

            boolean edadValida = true;
            for (int j = 0; j < edadStr.length(); j++) {
                if (edadStr.charAt(j) < '0' || edadStr.charAt(j) > '9') {
                    edadValida = false;
                }
            }

            boolean categoriaValida = false;
            if (categoria.equals("Familia") || categoria.equals("Amigo") || categoria.equals("Conocido")) {
                categoriaValida = true;
            }

            if (edadValida && categoriaValida) {
                System.out.println("Válido: " + nombreCompleto + " - " + categoria + " - " + edadStr + " años");
            } else {
                System.out.println("Error en registro: " + nombreCompleto + ", " + categoria + ", " + edadStr);
            }
        }
    }

    // EJERCICIO 9
    public static void ejercicio9(String nombreFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            String modulo = "";
            for (int i = 0; i < nombreFichero.length(); i++) {
                if (nombreFichero.charAt(i) == '.') {
                    break;
                }
                modulo = modulo + nombreFichero.charAt(i);
            }
            System.out.println("Módulo: " + modulo);

            ArrayList<String> aprobadosTodo = new ArrayList<>();
            ArrayList<String> suspensosRA1 = new ArrayList<>();
            ArrayList<String> suspensosRA2 = new ArrayList<>();
            ArrayList<String> suspensosRA3 = new ArrayList<>();
            ArrayList<String> suspensosRA4 = new ArrayList<>();
            ArrayList<String> suspensosRA5 = new ArrayList<>();

            while ((linea = br.readLine()) != null) {
                String nombre = "";
                int i = 0;
                while (i < linea.length() && linea.charAt(i) != ':') {
                    nombre = nombre + linea.charAt(i);
                    i++;
                }
                i = i + 2; // saltar ': '

                double[] notas = new double[5];
                for (int notaIndex = 0; notaIndex < 5; notaIndex++) {
                    String numStr = "";
                    while (i < linea.length() && linea.charAt(i) != ',' && linea.charAt(i) != '.') {
                        numStr = numStr + linea.charAt(i);
                        i++;
                    }
                    if (i < linea.length() && linea.charAt(i) == '.') {
                        numStr = numStr + '.';
                        i++;
                        while (i < linea.length() && linea.charAt(i) >= '0' && linea.charAt(i) <= '9') {
                            numStr = numStr + linea.charAt(i);
                            i++;
                        }
                    }
                    double nota = 0.0;
                    int puntoPos = -1;
                    for (int j = 0; j < numStr.length(); j++) {
                        if (numStr.charAt(j) == '.') {
                            puntoPos = j;
                        }
                    }
                    if (puntoPos != -1) {
                        double entero = 0;
                        for (int j = 0; j < puntoPos; j++) {
                            entero = entero * 10 + (numStr.charAt(j) - '0');
                        }
                        double decimal = 0;
                        for (int j = puntoPos + 1; j < numStr.length(); j++) {
                            decimal = decimal * 10 + (numStr.charAt(j) - '0');
                        }
                        for (int j = puntoPos + 1; j < numStr.length(); j++) {
                            decimal = decimal / 10;
                        }
                        nota = entero + decimal;
                    } else {
                        for (int j = 0; j < numStr.length(); j++) {
                            nota = nota * 10 + (numStr.charAt(j) - '0');
                        }
                    }
                    notas[notaIndex] = nota;
                    if (i < linea.length() && linea.charAt(i) == ',') {
                        i = i + 2;
                    }
                }

                boolean todoAprobado = true;
                if (notas[0] < 5) {
                    todoAprobado = false;
                    suspensosRA1.add(nombre);
                }
                if (notas[1] < 5) {
                    todoAprobado = false;
                    suspensosRA2.add(nombre);
                }
                if (notas[2] < 5) {
                    todoAprobado = false;
                    suspensosRA3.add(nombre);
                }
                if (notas[3] < 5) {
                    todoAprobado = false;
                    suspensosRA4.add(nombre);
                }
                if (notas[4] < 5) {
                    todoAprobado = false;
                    suspensosRA5.add(nombre);
                }

                if (todoAprobado) {
                    aprobadosTodo.add(nombre);
                }
            }

            System.out.println("Alumnos/as con todo aprobado:");
            for (int i = 0; i < aprobadosTodo.size(); i++) {
                System.out.println(aprobadosTodo.get(i));
            }

            System.out.println("Resultados de aprendizaje y alumnos suspensos:");
            System.out.print("RA1: ");
            if (suspensosRA1.size() == 0) {
                System.out.println("Todos aprobados");
            } else {
                for (int i = 0; i < suspensosRA1.size(); i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(suspensosRA1.get(i));
                }
                System.out.println();
            }

            System.out.print("RA2: ");
            if (suspensosRA2.size() == 0) {
                System.out.println("Todos aprobados");
            } else {
                for (int i = 0; i < suspensosRA2.size(); i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(suspensosRA2.get(i));
                }
                System.out.println();
            }

            System.out.print("RA3: ");
            if (suspensosRA3.size() == 0) {
                System.out.println("Todos aprobados");
            } else {
                for (int i = 0; i < suspensosRA3.size(); i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(suspensosRA3.get(i));
                }
                System.out.println();
            }

            System.out.print("RA4: ");
            if (suspensosRA4.size() == 0) {
                System.out.println("Todos aprobados");
            } else {
                for (int i = 0; i < suspensosRA4.size(); i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(suspensosRA4.get(i));
                }
                System.out.println();
            }

            System.out.print("RA5: ");
            if (suspensosRA5.size() == 0) {
                System.out.println("Todos aprobados");
            } else {
                for (int i = 0; i < suspensosRA5.size(); i++) {
                    if (i > 0) System.out.print(", ");
                    System.out.print(suspensosRA5.get(i));
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
        }
    }

    // EJERCICIO 10
    public static void ejercicio10(String nombreFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            double min = 999999999.0;
            double max = -999999999.0;
            double suma = 0.0;
            int validos = 0;
            int invalidos = 0;

            while ((linea = br.readLine()) != null) {
                String numeroActual = "";
                for (int i = 0; i <= linea.length(); i++) {
                    if (i == linea.length() || linea.charAt(i) == ' ' || linea.charAt(i) == '\t') {
                        if (numeroActual.length() > 0) {
                            boolean esNumero = true;
                            int puntos = 0;
                            for (int j = 0; j < numeroActual.length(); j++) {
                                char c = numeroActual.charAt(j);
                                if (c == '.') {
                                    puntos++;
                                    if (puntos > 1) {
                                        esNumero = false;
                                    }
                                } else if (c < '0' || c > '9') {
                                    esNumero = false;
                                }
                            }
                            if (esNumero && puntos <= 1) {
                                double num = 0.0;
                                int puntoPos = -1;
                                for (int j = 0; j < numeroActual.length(); j++) {
                                    if (numeroActual.charAt(j) == '.') {
                                        puntoPos = j;
                                    }
                                }
                                if (puntoPos != -1) {
                                    double entero = 0;
                                    for (int j = 0; j < puntoPos; j++) {
                                        entero = entero * 10 + (numeroActual.charAt(j) - '0');
                                    }
                                    double decimal = 0;
                                    for (int j = puntoPos + 1; j < numeroActual.length(); j++) {
                                        decimal = decimal * 10 + (numeroActual.charAt(j) - '0');
                                    }
                                    for (int j = puntoPos + 1; j < numeroActual.length(); j++) {
                                        decimal = decimal / 10;
                                    }
                                    num = entero + decimal;
                                } else {
                                    for (int j = 0; j < numeroActual.length(); j++) {
                                        num = num * 10 + (numeroActual.charAt(j) - '0');
                                    }
                                }
                                validos++;
                                suma = suma + num;
                                if (num < min) {
                                    min = num;
                                }
                                if (num > max) {
                                    max = num;
                                }
                            } else {
                                invalidos++;
                            }
                            numeroActual = "";
                        }
                    } else {
                        numeroActual = numeroActual + linea.charAt(i);
                    }
                }
            }

            if (validos > 0) {
                double media = suma / validos;
                int mediaEntero = (int) media;
                int mediaDecimal = (int) ((media - mediaEntero) * 1000);
                System.out.println("Número de datos válidos: " + validos);
                System.out.println("Número de datos inválidos: " + invalidos);
                System.out.println("Mínimo: " + (int)min + "." + (int)((min - (int)min)*100));
                System.out.println("Máximo: " + (int)max + "." + (int)((max - (int)max)*100));
                System.out.println("Media aritmética: " + mediaEntero + "." + mediaDecimal);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero");
        }
    }

    // EJERCICIO 11
    public static void ejercicio11() {
        String fichero = "/home/josemaria/login.txt";
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = sc.nextLine();

        boolean archivoExiste = true;
        boolean vacio = true;
        boolean encontrado = false;
        boolean contrasenaCorrecta = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                vacio = false;
                int dosPuntos = -1;
                for (int i = 0; i < linea.length(); i++) {
                    if (linea.charAt(i) == ':') {
                        dosPuntos = i;
                    }
                }
                if (dosPuntos != -1) {
                    String user = "";
                    for (int i = 0; i < dosPuntos; i++) {
                        user = user + linea.charAt(i);
                    }
                    String pwd = "";
                    for (int i = dosPuntos + 1; i < linea.length(); i++) {
                        pwd = pwd + linea.charAt(i);
                    }
                    if (user.equals(usuario)) {
                        encontrado = true;
                        if (pwd.equals(contrasena)) {
                            contrasenaCorrecta = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            archivoExiste = false;
        }

        if (!archivoExiste) {
            System.out.println("Fichero inexistente o imposible acceder a él");
        } else if (vacio) {
            System.out.println("Fichero vacío");
        } else if (!encontrado) {
            System.out.println("Usuario no encontrado");
        } else if (!contrasenaCorrecta) {
            System.out.println("Contraseña incorrecta");
        } else {
            System.out.println("Login correcto");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1 ===");
        ejercicio1();

        System.out.println("\n=== EJERCICIO 2 ===");
        estadisticas("fichero1.txt");

        System.out.println("\n=== EJERCICIO 3 ===");
        ejercicio3();

        System.out.println("\n=== EJERCICIO 4 ===");
        if (compararFicheros("fichero1.txt", "fichero2.txt")) {
            System.out.println("El contenido de los ficheros es el mismo");
        } else {
            System.out.println("El contenido de los ficheros no es el mismo");
        }

        System.out.println("\n=== EJERCICIO 5 ===");
        ejercicio5();

        System.out.println("\n=== EJERCICIO 6 ===");
        ejercicio6();

        System.out.println("\n=== EJERCICIO 7 ===");
        ejercicio7();

        System.out.println("\n=== EJERCICIO 8 ===");
        ejercicio8();

        System.out.println("\n=== EJERCICIO 9 ===");
        ejercicio9("Redes.txt");

        System.out.println("\n=== EJERCICIO 10 ===");
        ejercicio10("datos.txt");

        System.out.println("\n=== EJERCICIO 11 ===");
        ejercicio11();
    }
}