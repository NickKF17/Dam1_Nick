package jdbc;

import java.sql.*;

public class BBDD1 {

	public static void main(String[] args) {
		String usuario ="admin";
		String password="1234";
		String server="jdbc:mysql://localhost:3306/sakila";
		
		try (Connection conexion=DriverManager.getConnection(server,usuario,password)){
			System.out.println("Conexion con exito");
			
			Statement query =conexion.createStatement();
			String consulta="Select first_name,last_name,count(film_id) from actor JOIN film_actor using (actor_id) JOin film using (film_id) group by actor_id";
			ResultSet resultado= query.executeQuery(consulta);
			
			while(resultado.next()) {
				System.out.printf("Actor : %s %-10s| Peliculas actuadas : %d\n", resultado.getString("first_name"),resultado.getString("last_name"),resultado.getInt("count(film_id)"));
			}
			
			/*
			 next() siguiente
			 previus() anterior
			 first() primero
			 last() ultimo
			 getrow() numero de filas que tengo
			 beforefirst() antes del 1
			 afterlast() desde el ultimo
			 */
			
			
			// conexion.close();
		}catch(SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

}
