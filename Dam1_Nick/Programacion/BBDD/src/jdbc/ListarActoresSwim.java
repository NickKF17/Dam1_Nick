package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ListarActoresSwim {
public static void main(String[] args) {
	String usuario ="admin";
	String password="1234";
	String server="jdbc:mysql://localhost:3306/sakila";
	Scanner teclado = new Scanner(System.in);
	try (Connection conexion=DriverManager.getConnection(server,usuario,password)){
		System.out.println("Conexion con exito");
		Statement consulta=conexion.createStatement();
		ResultSet resultado = consulta.executeQuery("Select * from actor");
		
		JFrame ventana = new JFrame("Tabla actor");
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tabla = new JTable(modelo);
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		
		JScrollPane scroll = new JScrollPane(tabla);
		ventana.getContentPane().add(scroll);
		
		while(resultado.next()) {
			Object[] fila = new Object[3];
			fila[0]=resultado.getInt("actor_id");
			fila[1]=resultado.getString("first_name");
			fila[2]=resultado.getString("last_name");
			
			modelo.addRow(fila);
			
			}
		
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		
		
}catch(Exception e) {
System.out.println("Error: "+e.getMessage());	
}

}
}
