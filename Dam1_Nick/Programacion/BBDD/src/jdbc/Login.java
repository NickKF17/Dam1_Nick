package jdbc;

import javax.crypto.*;
import java.security.*;
import java.util.Base64;


public class Login {

	public static void main(String[] args) {
		//Guardamos en la base de datos:
		//usuario
		//saltTxt
		//hash
		String usuario="Nick";
		String password="abc123";
		
		//Generar Salt
	
		SecureRandom azar=new SecureRandom();
		
		byte[] salt = new byte[16];
		
		azar.nextBytes(salt);
	
		
		String saltTxt = Base64.getEncoder().encodeToString(salt);
		System.out.println(saltTxt);
		
		String passwordConSalt=saltTxt+password;
		System.out.println(passwordConSalt);
		
		
	}
}
