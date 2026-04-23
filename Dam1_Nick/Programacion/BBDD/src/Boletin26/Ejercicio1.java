package Ejercicio1_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		String usuario = "admin";
		String contraseña = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
			try (Connection conexion = DriverManager.getConnection(server, usuario, contraseña)) {
				PreparedStatement query33=conexion.prepareStatement("SELECT * FROM employees where lastname= ?",ResultSet.TYPE_SCROLL_INSENSITIVE, 
				        ResultSet.CONCUR_READ_ONLY);
				
				String ape="Patterson";
				query33.setString(1, ape);
				ResultSet resultado =query33.executeQuery();
				resultado.last();
				if(resultado.getRow()==0) {
					System.out.println("No hay empleados con ese apellido");
				}else {
					resultado.beforeFirst();
while(resultado.next()) {
					
					System.out.printf("firstname: %s | lastname: %s\n",resultado.getString("firstname"),resultado.getString("lastname"));
					
					PreparedStatement query34=conexion.prepareStatement("SELECT * FROM employees where reportsTo= ?");
					query34.setInt(1, resultado.getInt("employeeNumber"));
					ResultSet resultado2 =query34.executeQuery();	
					
					boolean tienereportes=false;
					while(resultado2.next()) {
						
						tienereportes=true;
						System.out.printf("Le hace report:  %s %s\n",resultado2.getString("firstname"),resultado2.getString("lastname"));
							
					}
					if(tienereportes==false) {
					System.out.printf("Al empleado %s %s no le reporta nadie\n",resultado.getString("firstname"),resultado.getString("lastname"));
						
					}
}
				}
			
			} catch (SQLException e) {
				System.out.println("Error: " + e.getMessage());
			}
		
	}

}
