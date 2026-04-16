package jdbc;

import javax.crypto.*;

import java.nio.charset.StandardCharsets;
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
		
		String salt=generarSalt();
		System.out.println(salt);
		System.out.println("Longitud de la salt: " +salt.length());
		String hash = generarHash(salt+password);
		System.out.println(hash);
		System.out.println("Longitud de la hash: " +hash.length());
		
	}
		
		public static String generarSalt() {
			//Generar Salt
			
			SecureRandom azar=new SecureRandom();
			
			byte[] salt = new byte[16];
			
			azar.nextBytes(salt);
		
			
			String saltTxt = Base64.getEncoder().encodeToString(salt);
			return saltTxt;
		}
		private static String generarHash(String txt) {
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
