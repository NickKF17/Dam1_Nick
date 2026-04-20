package PooLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainLogin {
	private static final Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		
		Usuario usuario=null;
		
		int opcion =menu();
		
		switch(opcion) {
		case 1:
			registro();
			break;
		case 2:
			Login();
			break;
		
		}
		
	}
public static int menu() {
	int opcion=0;
	while(opcion!=1 && opcion!=2) {
	System.out.println("¿Quieres registrarte(1) o Loggearte un usuario(2)?");
	String respuesta=teclado.nextLine();
	
	if(respuesta.trim().equals("1"))
		opcion=1;
	else if(respuesta.trim().equals("2")) {
	opcion=2;	
	}
	else
	opcion=5;
	
	}
	return opcion;
}
private static void registro() {
	int contador=0;
	do {
    System.out.print("Nombre de usuario: ");
    String user = teclado.nextLine();
    System.out.print("Email: ");
    String email = teclado.nextLine();
    System.out.print("Contraseña: ");
    String c1 = teclado.nextLine();
    System.out.print("Repita contraseña: ");
    String c2 = teclado.nextLine();
	
    if (c1.equals(c2)) {
        // Al hacer 'new', se ejecuta CrearBBDD() automáticamente
        Usuario u = new Usuario(user, email, c1); 

        String admin = "admin";
        String password = "1234";
        String server = "jdbc:mysql://localhost:3306/LoginBBDD";

        try (Connection conexion = DriverManager.getConnection(server, admin, password)) {
            // Comprobar si existe (Mejor con PreparedStatement)
            PreparedStatement consulta = conexion.prepareStatement("SELECT nombre FROM usuarios WHERE nombre = ? OR email = ?");
            consulta.setString(1, user);
            consulta.setString(2, email);
            
            if (consulta.executeQuery().next()) {
                System.out.println("Usuario o email ya registrado.");
            } else {
                // INSERT completo con hash y salt
                String sql = "INSERT INTO usuarios (id,nombre, email, password_hash, salt, privilegios) VALUES (null,?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sql);
                ps.setString(1, u.getUsuario());
                ps.setString(2, u.getEmail());
                ps.setString(3, u.getHash());
                ps.setString(4, u.getSalt());
                ps.setInt(5, u.getPrivilegios());
                ps.executeUpdate();
                contador=1;
                System.out.println("¡Registro exitoso!");
            }   
            
            }
        catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
    } else {
        System.out.println("Las contraseñas no coinciden.");
    }
	}while(contador!=1);
}

	public static void Login() {
		int contador=0;
		do {
	    System.out.print("Usuario: ");
	    String usuario = teclado.nextLine();
	    System.out.print("Contraseña: ");
	    String c1 = teclado.nextLine();
 
	    String admin = "admin";
        String password = "1234";
        String server = "jdbc:mysql://localhost:3306/LoginBBDD";

        try (Connection conexion = DriverManager.getConnection(server, admin, password)) {

    
    PreparedStatement query1 = conexion.prepareStatement("Select password_hash,salt from usuarios where nombre = ? ");
    query1.setString(1, usuario);
    
    ResultSet resultado=query1.executeQuery();
    
    if(resultado.next()) {
    String HashAlmacenado= resultado.getString("password_hash");
    String SaltUsuario=resultado.getString("salt");
    

    if(Usuario.generarHash(SaltUsuario+c1).equals(HashAlmacenado)) {
    	System.out.println("Iniciando Sesion");
    	contador=1;
    }
    else {
    	System.out.println("Contraseña Invalida");
    }
    
    }else {
    	System.out.println("Usuario no encontrado");
    } 
    }catch(SQLException e) {
        	System.out.println("Error: "+e.getMessage());
        }
		

	}while(contador!=1);
}
}

