package PooLogin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;

public class Usuario {
    private String usuario;
    private String salt;
    private String hash;
    private String email;
    private int privilegios;

    public Usuario(String usuario, String email, String contraseña) {
        // 1. Primero preparamos la infraestructura
        CrearBBDD(); 
        
        this.usuario = usuario;
        this.email = email;
        this.salt = generarSalt();
        // IMPORTANTE: El hash debe hacerse sobre la contraseña + el salt
        this.hash = generarHash(this.salt+(contraseña)); 
        this.privilegios = 1;
    }

    // Necesitas estos getters para que el Main pueda leer los valores generados
    public String getUsuario() { return usuario; }
    public String getEmail() { return email; }
    public String getSalt() { return salt; }
    public String getHash() { return hash; }
    public int getPrivilegios() { return privilegios; }
    
    private static void CrearBBDD() {
        String admin = "admin";
        String password = "1234";
        String server = "jdbc:mysql://localhost:3306/";
        
        try (Connection conexion = DriverManager.getConnection(server, admin, password)) {
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("CREATE DATABASE IF NOT EXISTS LoginBBDD");
            consulta.executeUpdate("USE LoginBBDD");
            
            // Tabla actualizada con campos para seguridad
            String queryTabla = "CREATE TABLE IF NOT EXISTS usuarios (" +
                                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                "nombre VARCHAR(50), " +
                                "email VARCHAR(50), " +
                                "password_hash VARCHAR(255), " +
                                "salt VARCHAR(255), " +
                                "privilegios INT)";
            consulta.executeUpdate(queryTabla);
        } catch (Exception e) {
            System.out.println("Error al preparar BBDD: " + e.getMessage());
        }
    }
    
    // ... mantén tus métodos generarSalt() y generarHash() igual ...
	public static String generarSalt() {
		//Generar Salt
		
		SecureRandom azar=new SecureRandom();
		
		byte[] salt = new byte[16];
		
		azar.nextBytes(salt);
	
		
		String saltTxt = Base64.getEncoder().encodeToString(salt);
		return saltTxt;
	}
	public static String generarHash(String txt) {
		String hashtxt=null;
		String algoritmo="SHA-512";
		try {
		MessageDigest digest = MessageDigest.getInstance(algoritmo);
		byte [] hash = digest.digest(txt.getBytes(StandardCharsets.UTF_8));
		hashtxt=Base64.getEncoder().encodeToString(hash);
	}catch(Exception e) {
		System.out.println("El algoritmo "+algoritmo+" no esta disponible");
	}
		return hashtxt;
	}
	
}


