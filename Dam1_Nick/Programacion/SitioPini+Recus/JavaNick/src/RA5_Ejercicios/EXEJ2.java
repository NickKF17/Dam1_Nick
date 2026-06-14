package RA5_Ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
public class EXEJ2 {
	static ArrayList<String> datosList=new ArrayList<>();
	static String cabe;
	public static void main(String[] args) throws FileNotFoundException, IOException {
	String fichero="paises.csv";    
	leerFichero(fichero);
	escribirFichero(fichero);
	    }
	//Funcion que lea el fichero
	public static void leerFichero(String fichero) {
		try(BufferedReader br=new BufferedReader(new FileReader(fichero))){
			String linea=br.readLine();
			if(linea==null)
				System.out.println("El fichero esta vacio");
			else {
				String[] cabecera=linea.split(",");
			cabe=cabecera[0]+","+cabecera[1]+","+cabecera[3];
		
			if(cabecera.length!=4)
				System.out.println("La cabecera es diferente de los 4 campos que deberian existir");
			else {
				while((linea = br.readLine()) != null) {
					String[] datos=linea.split(",");
					if(datos.length==4) {
						datosList.add(datos[0]+","+datos[1]+","+datos[3]);
						System.out.println(datos[0]+","+datos[1]+","+datos[3]);
					}
				}
			}
			}
			
		}catch(Exception e){
			System.out.println("El fichero no existe pero se esta creando");
		}
	}	
	//Funcion que sobreescriba el fichero
	public static void escribirFichero(String fichero) {
try(BufferedWriter bw=new BufferedWriter(new FileWriter(fichero))){
	bw.write(cabe);
	for(int i=0;i<datosList.size();i++)	{
	bw.newLine();
	bw.write(datosList.get(i).toString());
	}
}catch(Exception e) {

System.out.println("ERROR: "+e.getMessage());	}
	}
		
		
	}
	
	
	
	
	