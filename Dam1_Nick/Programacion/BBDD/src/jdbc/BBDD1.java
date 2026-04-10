package jdbc;

import java.sql.*;

public class BBDD1 {

	public static void main(String[] args) {
		String usuario ="admin";
		String password="1234";
		String server="jdbc:mysql://localhost:3306/sakila";
		
		try {
			Connection conexion;
			conexion=DriverManager.getConnection(server,usuario,password);
			
			conexion.close();
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

}
