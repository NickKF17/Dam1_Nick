package RA5_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Frases {
public static void main(String[] args) {
	Scanner teclado = new Scanner(System.in);
	String fichero="frases.txt";
	/*
	System.out.println("Dame tus 3 mejores frases");
	String frase1=teclado.nextLine();
	String frase2=teclado.nextLine();
	String frase3=teclado.nextLine();
	teclado.close();
	
	ArrayList<String> frases=new ArrayList<String>();
	frases.add(frase1);
	frases.add(frase2);
	frases.add(frase3);
	*/
	
	//escribirFichero(fichero, frases);
	leerymostrarfichero(fichero);
}

public static void escribirFichero(String fichero,ArrayList<String> frases) {
	try(BufferedWriter  bw=new BufferedWriter(new FileWriter(fichero,true))) {
	
		bw.write(frases.get(0)+"\n");
		bw.write(frases.get(1)+"\n");
		bw.write(frases.get(2)+"\n");
		
		bw.close();
	}catch(Exception e) {
		System.out.println("Error: "+e.getMessage());
	}
}

public static void leerymostrarfichero(String fichero) {
	
	try(BufferedReader br =new BufferedReader(new FileReader(fichero))){
		String linea;
		
		while((linea=br.readLine()) !=null) {
			System.out.println(linea);
		}
		br.close();
	}catch(Exception e){
		System.out.println("Error: "+e.getMessage());
	}
	
	
}
}

