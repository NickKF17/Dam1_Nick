package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BBDD2 {

	public static void main(String[] args) {
		String usuario ="admin";
		String password="1234";
		String server="jdbc:mysql://localhost:3306/sakila";
		Scanner teclado = new Scanner(System.in);
		try (Connection conexion=DriverManager.getConnection(server,usuario,password)){
			System.out.println("Conexion con exito");
		// insertar//	PreparedStatement query =conexion.prepareStatement("Insert into actor values (Null,?,?,?)");
		/*	
			query.setString(1,"Nick");
			query.setString(2, "Constante");
			
			LocalDateTime fechayHora=LocalDateTime.now();
			DateTimeFormatter formato= DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
			
			String fechaFormateada= fechayHora.format(formato);
			query.setString(3, fechaFormateada);
			
			query.executeUpdate();
			*/
			
			
			Statement query =conexion.createStatement();
			query.executeUpdate("Delete from actor where last_name='Morales'");
}catch(Exception e) {
System.out.println("Error: "+e.getMessage());	
}
	}
}
