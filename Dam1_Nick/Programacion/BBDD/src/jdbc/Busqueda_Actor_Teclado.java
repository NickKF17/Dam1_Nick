package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Busqueda_Actor_Teclado {

	public static void main(String[] args) {
		String usuario ="admin";
		String password="1234";
		String server="jdbc:mysql://localhost:3306/sakila";
		Scanner teclado = new Scanner(System.in);
		try (Connection conexion=DriverManager.getConnection(server,usuario,password)){
			System.out.println("Conexion con exito");
			
			System.out.println("¿Que actor quieres buscar?");
			String actor=teclado.nextLine();
			String querys="Select * from actor where first_name=?";
			
			
			PreparedStatement query =conexion.prepareStatement(querys,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			query.setString(1, actor);
		
			ResultSet resultado =query.executeQuery();	
			
			
			
			resultado.last();
			System.out.println("El query tiene "+resultado.getRow()+" filas");
			
			while(resultado.previous()) {
				
				System.out.printf("%d Actor : %s %s (%d)\n",resultado.getRow(),resultado.getString("first_name"),resultado.getString("last_name"),resultado.getInt("actor_id") );
			}
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

}
