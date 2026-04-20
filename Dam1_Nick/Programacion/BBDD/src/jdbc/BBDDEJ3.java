package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BBDDEJ3 {
	public static void main(String[] args) {

        String admin = "admin";
        String password = "1234";
        String server = "jdbc:mysql://localhost:3306/classicmodels";
        int stockMinimo=500;
        
        try(Connection conexion= DriverManager.getConnection(server,admin,password)){
        	System.out.println("Conexion realizada con exito");
        	
        	productosConStockMinimo(conexion,stockMinimo);
        }catch(SQLException e) {
        	System.out.println("Error: "+ e.getMessage());
        }
	}

	private static void productosConStockMinimo(Connection conexion, int stockMinimo) throws SQLException {
		PreparedStatement query=conexion.prepareStatement("Select productCode,productName,quantityInStock from products where quantityInStock<=?");
		query.setInt(1, stockMinimo);
	ResultSet resultado=query.executeQuery();
	while(resultado.next()){
	System.out.println(resultado.getString("productCode"));
	PreparedStatement query2 =conexion.prepareStatement("Select count(*) from orderdetails where productCode=?");
	query2.setString(1, resultado.getString("productCode"));
	ResultSet resultado2 =query2.executeQuery();
	resultado2.next();
	System.out.println(resultado2.getInt(1));
	}
	}

}
