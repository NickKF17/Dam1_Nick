package BBDD;

//---IMPORTS NECESARIOS---

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Apuntes {

	// ---CONECTARSE A BASE DE DATOS---

	public static void main(String[] args) {
		// 1. Definir credenciales y URL (Protocolo:Gestor://Host:Puerto/BaseDeDatos)
		String url = "jdbc:mysql://localhost:3306/nombre_base_datos";
		String usr = "usuario";
		String pswd = "contraseña";

		// 2. Conectar usando try-with-resources (cierra la conexión automáticamente)
		try (Connection conexion = DriverManager.getConnection(url, usr, pswd)) {
			System.out.println("Conexión exitosa");
			// Aquí irían las llamadas a los métodos de consultas o modificaciones
		} catch (SQLException e) {
			System.err.println("Error de SQL: " + e.getMessage());
			// Información extra sobre el error:
			// e.getErrorCode(), e.getSQLState(), e.printStackTrace()
		}
	}

	// ---CONSULTA DE SELECT---

	public static void consultaBasica(Connection conexion) throws SQLException {
		// 1. Crear el objeto Statement
		Statement sql = conexion.createStatement();

		// 2. Ejecutar la query y guardar el resultado
		ResultSet resultado = sql.executeQuery("SELECT * FROM nombre_tabla");

		// 3. Recorrer los resultados iterando hacia adelante (modo por defecto)
		while (resultado.next()) {
			// Recuperar datos por nombre de columna (recomendado) o por índice (empieza en
			// 1)
			int id = resultado.getInt("id_columna");
			String texto = resultado.getString("nombre_columna");

			System.out.printf("ID: %d - Valor: %s\n", id, texto);
		}
	}

	// ---CONSULTAS PARAMETRIZADAS---

	public static void consultaParametrizada(Connection conexion) throws SQLException {
		// 1. Preparar la query usando "?" como incógnitas
		String query = "SELECT * FROM tabla WHERE columna1 = ? AND columna2 = ?";
		PreparedStatement sql = conexion.prepareStatement(query);

		// 2. Sustituir las incógnitas (el índice empieza en 1)
		sql.setString(1, "Valor1");
		sql.setInt(2, 100);

		// 3. Ejecutar y recorrer
		ResultSet resultado = sql.executeQuery();
		while (resultado.next()) {
			System.out.println(resultado.getString("columna_deseada"));
		}
	}

	// ---NAVEGACION Y MODIFICACION AVANZADA (ResultSet CONFIGURABLE)

	public static void consultaAvanzada(Connection conexion) throws SQLException {
		// 1. Crear Statement o PreparedStatement con modificadores:
		// TYPE_SCROLL_INSENSITIVE: Permite moverse libremente (adelante, atrás).
		// CONCUR_UPDATABLE: Permite modificar la BBDD desde el ResultSet.
		Statement sql = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet resultado = sql.executeQuery("SELECT * FROM tabla");

		// --- NAVEGACIÓN ---
		resultado.last(); // Va a la última fila
		int totalFilas = resultado.getRow(); // Obtiene el número de fila actual (equivale al size total si estamos en
												// la última)

		resultado.afterLast(); // Se coloca DESPUÉS de la última fila
		while (resultado.previous()) { // Recorre hacia atrás
			// ... leer datos ...
		}

		resultado.absolute(3); // Salta a la fila 3 desde el principio
		resultado.relative(-2); // Retrocede 2 filas desde la posición actual

		// --- MODIFICACIÓN DIRECTA ---
		resultado.absolute(1); // Nos situamos en la fila a modificar
		resultado.updateString("nombre_columna", "Nuevo Valor"); // Cambiamos el valor en memoria
		resultado.updateRow(); // ¡IMPORTANTE! Aplica el cambio en la BBDD (si no, se pierde)
	}

	// ---INSERT, UPDATE, DELETE, CREATE

	public static void modificarDatos(Connection conexion) throws SQLException {
		// --- EJEMPLO INSERT CON PREPARED STATEMENT ---
		PreparedStatement insert = conexion.prepareStatement("INSERT INTO tabla VALUES (NULL, ?, ?)");
		insert.setString(1, "Dato 1");
		insert.setString(2, "Dato 2");

		// executeUpdate() devuelve un int con el número de filas afectadas
		int filasInsertadas = insert.executeUpdate();

		// --- EJEMPLO DDL (CREAR TABLAS/BBDD) O DELETE CON STATEMENT ---
		Statement consulta = conexion.createStatement();
		// Para CREATE, DROP, ALTER, devuelve 0.
		consulta.executeUpdate("CREATE DATABASE IF NOT EXISTS mi_bd");
		consulta.executeUpdate("USE mi_bd");

		// Para DELETE o UPDATE devuelve filas afectadas
		consulta.executeUpdate("DELETE FROM tabla WHERE condicion = 'valor'");
	}

	// ---VOLCAR DATOS EN UNA INTERFAZ GRÁFICA (Seguramente no lo pida pero por si
	// acaso)

	public static void mostrarEnTabla(Connection conexion) {
		try {
			Statement sql = conexion.createStatement();
			ResultSet rs = sql.executeQuery("SELECT id, nombre, edad FROM personas");

			// 1. Configurar la ventana (JFrame)
			JFrame ventana = new JFrame("Título de la Ventana");

			// 2. Configurar el modelo y la tabla (JTable)
			DefaultTableModel modelo = new DefaultTableModel();
			JTable tabla = new JTable(modelo);

			// 3. Añadir las cabeceras (columnas) al modelo
			modelo.addColumn("ID");
			modelo.addColumn("Nombre");
			modelo.addColumn("Edad");

			// 4. Llenar el modelo recorriendo el ResultSet
			while (rs.next()) {
				Object[] fila = new Object[3]; // Tamaño = número de columnas
				fila[0] = rs.getInt("id");
				fila[1] = rs.getString("nombre");
				fila[2] = rs.getInt("edad");

				modelo.addRow(fila); // Añade la fila a la tabla
			}

			// 5. Añadir Scroll y empaquetar en la ventana
			JScrollPane scroll = new JScrollPane(tabla);
			ventana.getContentPane().add(scroll);

			// 6. Hacer visible
			ventana.pack();
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setVisible(true);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// ---IMPIRMIR FORMATO TABLA---

	// El formato %-15s significa: String(s), alineado a la izquierda (-), ocupando
	// 15 caracteres.
	// El formato %5d significa: Entero(d), alineado a la derecha, ocupando 5
	// caracteres.

	public static void imprimirTablaConsola(ResultSet resultado) throws SQLException {
		// 1. Imprimir cabecera de la tabla a mano
		System.out.println("---------------------------------------------");
		System.out.printf("| %-5s | %-15s | %-15s |\n", "ID", "Nombre", "Apellido");
		System.out.println("---------------------------------------------");

		// 2. Imprimir datos en el bucle alineándolos con los mismos números
		while (resultado.next()) {
			System.out.printf("| %-5d | %-15s | %-15s |\n", resultado.getInt("actor_id"),
					resultado.getString("first_name"), resultado.getString("last_name"));
		}
		System.out.println("---------------------------------------------");
	}

	// ---LOCALDATETIME---

	LocalDateTime fechayHora = LocalDateTime.now();
	// Ojo: en Java los años suelen ir con 'y' minúscula, aunque tu profe puso 'Y'
	// mayúscula.
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String fechaListaParaInsertar = fechayHora.format(formato);

}