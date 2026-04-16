package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MostrarDBS {

	public static void main(String[] args) {
		String usuario ="admin";
		String password="1234";
		String server="jdbc:mysql://localhost:3306/sakila";
		Scanner teclado = new Scanner(System.in);
		try (Connection conexion=DriverManager.getConnection(server,usuario,password)){
			System.out.println("Conexion con exito");
			Statement consulta=conexion.createStatement();
			ResultSet resultado = consulta.executeQuery("Show Tables");
			while(resultado.next())
				System.out.println(resultado.getString(1));
		
			
}catch(Exception e) {
System.out.println("Error: "+e.getMessage());	
}
	}
}