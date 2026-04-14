package jdbc;

import java.sql.*;
import java.util.Scanner;

public class BBDD1 {

	public static void main(String[] args) {
		String usuario ="admin";
		String password="1234";
		String server="jdbc:mysql://localhost:3306/sakila";
		Scanner teclado = new Scanner(System.in);
		try (Connection conexion=DriverManager.getConnection(server,usuario,password)){
			System.out.println("Conexion con exito");
			
			//TYPE_FORWARD_ONLY , TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE sin esto (INSENSITIVE) no podrias ir hacia arriba en la query
			//CONCUR_READ_ONLY , CONCUR_UPDATABLE
			
			//absolute() te mueves a la query que quieres desde el principio
			//relative() te mueves a la query que quieres desde la que estas
			
			
			/*
			Statement query =conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String consulta="Select * from actor where first_name ='MARY'";
			ResultSet resultado= query.executeQuery(consulta);
			*/
//String consulta="Select actor_id,first_name,last_name,count(film_id) from actor JOIN film_actor using (actor_id) JOin film using (film_id) group by actor_id";
			
//String consulta="Select * from actor";
			
			System.out.println("¿Que actor quieres buscar?");
			String actor=teclado.nextLine();
			//String querys="Select * from actor where first_name="+actor+" and last_name=" +actor;
			String querys="Select * from actor where first_name=?";
			
			
			
			PreparedStatement query =conexion.prepareStatement(querys,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			query.setString(1, actor);
		
			ResultSet resultado =query.executeQuery();	
			
			
			
			
			resultado.last();
			System.out.println("El query tiene "+resultado.getRow()+" filas");
			// resultado.afterLast();
			
			
			
			
			//resultado.absolute(67);
			/*
			resultado.updateString("first_name", "Inés");
			resultado.updateString("last_name", "Perado");
			resultado.updateRow();
			*/
			
			resultado.afterLast();
			/*
			while(resultado.next()) {
				System.out.printf("Actor : %s %-10s| Peliculas actuadas : %d\n", resultado.getString("first_name"),resultado.getString("last_name"),resultado.getInt("count(film_id)"));
			}
			
			*/
			while(resultado.previous()) {
				//System.out.printf("%d Actor : %s %-10s| Peliculas actuadas : %d\n",resultado.getInt("actor_id") ,resultado.getString("first_name"),resultado.getString("last_name"),resultado.getInt("count(film_id)"));
				System.out.printf("%d Actor : %s %s (%d)\n",resultado.getRow(),resultado.getString("first_name"),resultado.getString("last_name"),resultado.getInt("actor_id") );
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
