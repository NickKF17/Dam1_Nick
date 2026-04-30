package examen2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ejercicio2 {
	public static void main(String[] args) {
		String ciudad="Tokyo";
		String ciudad2="Paris";
		moverEmpleados(ciudad,ciudad2);
	}
	
	
	public static void moverEmpleados(String ciudad,String ciudad2) {
		String usuario = "admin";
		String contraseña = "1234";
		String server = "jdbc:mysql://localhost:3306/classicmodels";
		try (Connection conexion = DriverManager.getConnection(server, usuario, contraseña)) {
			//Codigo de oficina de la ciudad 1 resultado
			PreparedStatement query=conexion.prepareStatement("SELECT officeCode FROM employees join offices using (officeCode) where city like ? limit 1");
			query.setString(1, ciudad);
			
			ResultSet resultado =query.executeQuery();	
			
			String codigo1=resultado.getString("officeCode");
				
			//codigo de oficina de la ciudad 2 resultado3
	PreparedStatement query3=conexion.prepareStatement("SELECT officeCode FROM employees join offices using (officeCode) where city like ? limit 1");
	query3.setString(1, ciudad2);
	
	ResultSet resultado3 =query3.executeQuery();
	String codigo2=resultado3.getString("officeCode");
	//Update de la base de datos
	
	
	String consulta="Select officeCode from employees where officeCode like ?";
	
	PreparedStatement query2=conexion.prepareStatement(consulta);
	query2.setString(1, codigo1);
	
	ResultSet resultadofinal =query2.executeQuery();	

	while(resultadofinal.next()) {
	resultadofinal.updateString("officeCode", codigo2); // Cambiamos el valor en memoria
	resultado.updateRow(); // ¡IMPORTANTE! Aplica el cambio en la BBDD (si no, se pierde)
	
	}
	System.out.println("Moviendo todos los empleados de "+ciudad+ " a "+ciudad2);
	System.out.println("Se van a mover "+ query2.executeUpdate(consulta) +" empleados de "+ciudad+ " a "+ciudad2);
	System.out.println("La oficina de " +ciudad2+" tiene ahora "+ " Empleados");
		}catch(SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
	}
}