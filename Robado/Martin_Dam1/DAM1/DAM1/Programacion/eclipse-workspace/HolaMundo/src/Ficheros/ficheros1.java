package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ficheros1 {

	public static void main(String[] args) {
		metodo1();
		System.out.println();
		metodo2();
		System.out.println();
		metodo3();
		System.out.println();
		metodo4();
		
		

	}

	public static void metodo1() {
		try {
			// FileReader fichero = new
			// FileReader("/home/alumno/DAM1/DAM1/Programacion/ficheros/fichero1/primero.txt");
			BufferedReader lector = new BufferedReader(
					new FileReader("/home/alumno/DAM1/DAM1/Programacion/ficheros/fichero1/primero.txt"));
			String linea;
			/*
			 * do { linea = lector.readLine(); if (linea != null) System.out.println(linea);
			 * } while (linea != null); System.out.println();
			 */
			while ((linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
	}

	public static void metodo2() {
		try {
			File fichero = new File("/home/alumno/DAM1/DAM1/Programacion/ficheros/fichero1/primero.txt");
			Scanner lector = new Scanner(fichero);
			String linea;
			while (lector.hasNextLine()) {
				linea = lector.nextLine();
				System.out.println(linea);
			}
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
	}

	public static void metodo3() {
		ArrayList<String> lineas= null;
		try {
			//Esto tambien funciona si pones sin ArrayList y solo List, y así no hace falta un casteo
			
			Path fichero = Path.of("/home/alumno/DAM1/DAM1/Programacion/ficheros/fichero1/primero.txt");
			lineas = (ArrayList) Files.readAllLines(fichero);
		} catch (Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage()); 

		}
		for (String linea: lineas) {
			System.out.println(linea);
		}
	}
	public static void metodo4() {
		Path fichero = Path.of("/home/alumno/DAM1/DAM1/Programacion/ficheros/fichero1/primero.txt");
		String contenido = null;
		try {
			contenido = Files.readString(fichero);
		}catch(Exception e) {
			System.out.println("Error con el fichero");
			System.out.println(e.getMessage());
		}
		System.out.println(contenido);
	}
}
