package RA8_Ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;

public class BOL24EJ8 {

	public static void main(String[] args) {
		String origen="origen.txt";
		String destino="destino.txt";
		grabarFichero(origen, destino);
		
	}
	
	public static String leerFichero(String origen) {
		String todo="";
		try (BufferedReader br=new BufferedReader(new FileReader(origen))){
			
			while((todo=br.readLine()) !=null) {
			}
System.out.println(todo);
		}catch(Exception e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		
		return todo;
	}
public static void grabarFichero(String origen ,String destino) {
	try (BufferedWriter bw=new BufferedWriter(new FileWriter(destino))){
		if(esValido(origen)==true)
			bw.write(leerFichero(origen));
}catch(Exception e) {
	System.out.println("ERROR: "+e.getMessage());
}
}
	public static boolean esValido(String origen) {
		boolean valido=true;
		try (BufferedReader br=new BufferedReader(new FileReader(origen))){
			String lineas;
			
			Pattern patronNombre = Pattern.compile("[A-Za-zÁÉÍÓÚáéíóúÑñ]+(\\s+[A-Za-zÁÉÍÓÚáéíóúÑñ]+)*,\\s[A-Za-zÁÉÍÓÚáéíóúÑñ]+(\\s+[A-Za-zÁÉÍÓÚáéíóúÑñ]+)*");
			Pattern patronPuesto = Pattern.compile("[A-Za-zÁÉÍÓÚáéíóúÑñ0-9]+(\\s+[A-Za-zÁÉÍÓÚáéíóúÑñ0-9]+)*");
			Pattern patronSalario = Pattern.compile("\\d+(\\.\\d+)?");
			
		
			while ((lineas = br.readLine()) != null) {

			    String[] linea = lineas.split(";");

			    if (linea.length != 3) {
			        valido = false;
			    }

			    if (!patronNombre.matcher(linea[0]).matches())
			        valido = false;

			    if (!patronPuesto.matcher(linea[1]).matches())
			        valido = false;

			    if (!patronSalario.matcher(linea[2]).matches())
			        valido = false;
			}
				
		}catch(Exception e) {
			System.out.println("ERROR: "+ e.getMessage());
			valido=false;
		}
		return valido;
	}
}
