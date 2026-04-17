package jdbc;

import javax.crypto.*;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;


public class Login {
public static HashMap<String,String> usuarios=new HashMap<>();

	public static void main(String[] args) {
		//Guardamos en la base de datos:
		//usuario
		//saltTxt
		//hash
		Scanner teclado = new Scanner(System.in);
		String usuario="Nick";
		String password="abc123";
		
		
		registro();
		registro();
		/*
		String salt=generarSalt();
		System.out.println(salt);
		System.out.println("Longitud de la salt: " +salt.length());
		String hash = generarHash(salt+password);
		System.out.println(hash);
		System.out.println("Longitud de la hash: " +hash.length());
		*/
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
		private static void registro() {
			Scanner teclado = new Scanner(System.in);
			System.out.print("Introduzca un nombre de usuario: ");
			String user=teclado.nextLine();
			
			System.out.print("Introduzca su contraseña: ");
			String c1= teclado.nextLine();
			System.out.print("Vuelve a introducir su contraseña: ");
			String c2 = teclado.nextLine();
			
			if(c1.equals(c2)) {
				if(usuarios.containsKey(user)==false) {
				System.out.println("Registro completo");
		
			String salt=generarSalt();
			System.out.println(salt);
			String hash = generarHash(salt+c1);
			System.out.println(hash);
			usuarios.put(user,hash);
				}
			else {
				System.out.println("Nombre de usuario invalido");
			}
			}
			else {
				System.out.println("Las contraseñas no coinciden");
			}
			
			
		}
		
	
}
