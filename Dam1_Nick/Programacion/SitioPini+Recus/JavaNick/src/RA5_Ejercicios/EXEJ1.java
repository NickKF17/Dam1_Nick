package RA5_Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class EXEJ1 {
	    public static void main(String[] args) {
	        String rutaArchivo = "paises.csv";
	        String linea;
	        String separador = ",";
ArrayList<String>paises=new ArrayList<>();
ArrayList<String>capitales=new ArrayList<>();
ArrayList<String>monedas=new ArrayList<>();
ArrayList<String>animales=new ArrayList<>();
	        // Usamos try-with-resources para que el BufferedReader se cierre solo
	        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	        	 String[] columnas= {};
	        	 int contador=0;
	            // br.readLine() lee la línea. Si devuelve null, significa que llegamos al final del archivo.
	            while ((linea = br.readLine()) != null) {
	                
	                // Separamos los valores por la coma
	                columnas = linea.split(separador);
	                if(columnas.length==4) {
	                if(contador!=0) {
	                paises.add(columnas[0]);
	                capitales.add(columnas[1]);
	                monedas.add(columnas[2]);
	                animales.add(columnas[3]);
	                }
	                }
	                contador++;
	                /*
	                // Imprimimos los datos (verificando que la línea no esté vacía)
	                if (columnas.length > 0) {
	                    System.out.println("Columna 1: " + columnas[0]);
	                }
	          
	            */
	              
	            }
	            if(paises.size()==0)
	           System.out.println("No hay datos de ningún país en el fichero");
	            else {
	            	
	            System.out.println("Paises en el fichero : "+paises.size());
	            String paisesformat=paises.toString().replace("[","").replace("]","");
	            if(paises.toString().contains(",")) {
	            System.out.println("Nombres: "+paisesformat.substring(0, paisesformat.lastIndexOf(","))+" y"+paisesformat.substring(paisesformat.lastIndexOf(",")+1));
	            
	            System.out.println("Las capitales de los mismos: "+capitales.toString().replace("[","").replace("]",""));
	            
	            System.out.println("Sus monedas oficiales son: "+monedas.toString().replace("[","").replace("]",""));
	            
	            System.out.println("Sus animales mas representativos son "+animales.toString().replace("[","").replace("]",""));
	            }
	            else
	            {
	            	 System.out.println("Nombres: "+paisesformat);
	 	            
	 	            System.out.println("Las capitales de los mismos: "+capitales.toString().replace("[","").replace("]",""));
	 	            
	 	            System.out.println("Sus monedas oficiales son: "+monedas.toString().replace("[","").replace("]",""));
	 	            
	 	            System.out.println("Sus animales mas representativos son "+animales.toString().replace("[","").replace("]",""));
	            }
	            }
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo: " + e.getMessage());
	        }
	   
}
}
