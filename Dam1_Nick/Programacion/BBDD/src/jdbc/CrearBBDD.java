package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CrearBBDD {

	public static void main(String[] args) {
		String usuario ="admin";
		String password="1234";
		String server="jdbc:mysql://localhost:3306/";
		Scanner teclado = new Scanner(System.in);
		try (Connection conexion=DriverManager.getConnection(server,usuario,password)){
			System.out.println("Conexion con exito");
		String query1="Create database if not exists agenda";
		String query2="Use agenda";
		String query3= "Create table if not exists personas(telefono int(9) primary key,nombre varchar(50))";
		
		
		Statement consulta=conexion.createStatement();
		consulta.executeUpdate(query1);
		consulta.executeUpdate(query2);
		consulta.executeUpdate(query3);
}catch(Exception e) {
System.out.println("Error: "+e.getMessage());	
}
	}
}