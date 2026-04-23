package BBDDCSV;

import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CSVBBDD {

	public static void main(String[] args) {
		String usuario = "admin";
		String contraseña = "1234";
		String server = "jdbc:mysql://localhost:3306/";

		ArrayList<String> lineas = leerFichero();
		crearBBDD(server, usuario, contraseña);

	
		
		int j = 0;
		for (String linea : lineas) {
			String[] array = linea.split(",");
			if (j!= 0) {
			for (int i=0; i<array.length; i++) {
				
				if (array[i].length() > 50)
					array[i] = array[i].substring(0, 50);
			}
			
			añadirRegistro(server, usuario, contraseña, array);
			}
			j++;
		}
	}

	public static ArrayList<String> leerFichero() {
		ArrayList<String> lineas = new ArrayList<>();
		try {
			Path fichero = Path.of("/home/alumno/agendaNick.csv");
			lineas = (ArrayList<String>) Files.readAllLines(fichero);
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}

		return lineas;
	}

	public static void crearBBDD(String server, String usuario, String contraseña) {
		try (Connection conexion = DriverManager.getConnection(server, usuario, contraseña)) {
			String consulta1 = "CREATE DATABASE IF NOT EXISTS agendaNick";
			String consulta2 = "USE agendaNick";
			String consulta3 = "CREATE TABLE IF NOT EXISTS registros (nombre VARCHAR(50) , apellidos VARCHAR(50), email VARCHAR(50), telefono VARCHAR(50))";

			System.out.println("Conexion realizada con exito");
			Statement consulta =  conexion.createStatement();

			consulta.executeUpdate(consulta1);
			consulta.executeUpdate(consulta2);
			consulta.executeUpdate(consulta3);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void añadirRegistro(String server, String usuario, String contraseña, String[] lista) {
		server += "agendaNick";
		try (Connection conexion = DriverManager.getConnection(server, usuario, contraseña)) {
			PreparedStatement query33=conexion.prepareStatement("SELECT * FROM registros where nombre = ? and email=?");
			
			
			
			query33.setString(1, lista[0].trim());
			query33.setString(2, lista[2].trim());
			
			
			
			ResultSet resultado =query33.executeQuery();
			if (!resultado.next()) {
			PreparedStatement query = conexion.prepareStatement("INSERT INTO registros VALUES (?, ?, ?, ?)");
			query.setString(1, lista[0]);	
			query.setString(2, lista[1]);
			query.setString(3, lista[2]);
			query.setString(4, lista[3]);

			query.executeUpdate();
			System.out.println("Contacto grabado con exito");
			}else {
				System.out.println("Ese registro ya existe");
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
