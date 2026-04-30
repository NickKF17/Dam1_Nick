package examen2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ejercicio1 {
	public static void main(String[] args) {
		String ciudad="Paris";
		listarEmpleados(ciudad);
	}
	public static void listarEmpleados(String ciudad) {
		String usuario = "admin";
		String contraseña = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
		try (Connection conexion = DriverManager.getConnection(server, usuario, contraseña)) {
			
			PreparedStatement query33=conexion.prepareStatement("SELECT city FROM offices where city like ? ",ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY);
			

			query33.setString(1, ciudad);
			ResultSet resultado =query33.executeQuery();
			resultado.last();
			if(resultado.getRow()==0) {
				System.out.println("No existe oficina en "+ciudad);
			}else {
				resultado.beforeFirst();
				
while(resultado.next()) {

				
				
				PreparedStatement query34=conexion.prepareStatement("SELECT employees.firstName,employees.lastName,employees.email FROM employees join offices using (officeCode) where city like ? ");
				query34.setString(1, ciudad);
				ResultSet resultado2 =query34.executeQuery();	
				
				boolean tieneempleados=false;
	
				while(resultado2.next()) {
					int contador=0;
					if(contador==resultado2.getRow())
						System.out.println("Hay "+contador+" empleados en la oficina de "+ ciudad+ ". Sus datos son:");
					
	
					tieneempleados=true;
					System.out.printf("%s , %s (%s)\n",resultado2.getString("lastName"),resultado2.getString("firstName"),resultado2.getString("email"));
					contador++;	
				}
				if(tieneempleados==false) {
				System.out.printf("La oficina de "+ciudad+" no tiene empleados");
					
				}
}
			}
		
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

}
	
	public static void moverEmpleados(String ciudad,String ciudad2) {
		String usuario = "admin";
		String contraseña = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
		try (Connection conexion = DriverManager.getConnection(server, usuario, contraseña)) {
			
			PreparedStatement query=conexion.prepareStatement("SELECT officeCode FROM employees join offices using (officeCode) where city like ? ",ResultSet.TYPE_SCROLL_INSENSITIVE, 
			        ResultSet.CONCUR_READ_ONLY);
			query.setString(1, ciudad);
			
			ResultSet resultado =query.executeQuery();
			resultado.last();			
				resultado.beforeFirst();
while(resultado.next()) {
	PreparedStatement query2=conexion.prepareStatement("Update employees officeCode = from em");
	}
		}catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}
}