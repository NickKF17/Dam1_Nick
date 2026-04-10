package examen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.Map.Entry;


public class Ejercicio1 {
	public static void main(String[] args) {
		/*String linea="22 Hola adios";
		linea=linea.substring(0,linea.indexOf(" "))+"-"+linea.substring(linea.indexOf(" ")+1);
		System.out.println(linea);
		*/
		String animes="animes.txt";
		String personajes="personajes.txt";
		HashMap<Integer, String> diccionario=new HashMap<>();
		diccionario=leeAnimes(animes);
	

		ArrayList<String> lista=new ArrayList<>();
		ArrayList<String> lista2=new ArrayList<>();
			
		for(Map.Entry<Integer, String> anime : diccionario.entrySet()) {
				System.out.println(anime.getValue());
			
				lista=listapersonajes(anime.getKey(), personajes);
				for(String num : lista) {
				int num2=Integer.parseInt(num.substring(0,num.indexOf(" ")));
				if(num2==anime.getKey()) {
					System.out.println("-"+num.substring(num.indexOf(" ")));
				
				}
				
				}
				}
		System.out.println("Personajes sin anime");
		for(Map.Entry<Integer, String> anime : diccionario.entrySet()) {
		lista2=listasinpersonajes(anime.getKey(), personajes);
		for(String num : lista2) {
			//System.out.println("- "+num);
		
		}
		}
		}
		    		
	
		
		

	public static HashMap<Integer, String> leeAnimes(String fichero) {
        HashMap<Integer, String> diccionario = new HashMap<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {
            String linea;
            
            while ((linea = lector.readLine()) != null) {
            	
            	linea=linea.substring(0,linea.indexOf(" "))+"-"+linea.substring(linea.indexOf(" ")+1);
                if (linea.contains("-")) {
                    String[] partes = linea.split("-");
                    int numero  =  Integer.parseInt(partes[0].trim());
                    String anime = partes[1].trim();
                    diccionario.put((Integer)numero, anime);
                   
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo respuestas: " + e.getMessage());
        }
        return diccionario;
    }
	
	public static ArrayList<String> listapersonajes(int codigo,String fichero){
		ArrayList<String> lista=new ArrayList<>();
		try {
			BufferedReader lector =new BufferedReader(new FileReader(fichero));
		
			String linea;
			while((linea = lector.readLine())!=null) {
				int persocodigo=Integer.parseInt(linea.substring(0,linea.indexOf(" ")));
				if(persocodigo==codigo)
				lista.add(linea);
						
			}
			
		}catch (Exception e) {
			System.out.println("Error con el fichero");
		}
return lista;
	}
	
	public static ArrayList<String> listasinpersonajes(int codigo,String fichero){
		ArrayList<String> lista=new ArrayList<>();
		try {
			BufferedReader lector =new BufferedReader(new FileReader(fichero));
		
			String linea;
			while((linea = lector.readLine())!=null) {
				int persocodigo=Integer.parseInt(linea.substring(0,linea.indexOf(" ")));
				if(persocodigo!=codigo)
				lista.add(linea.substring(linea.indexOf(" ")));
						
			}
			
		}catch (Exception e) {
			System.out.println("Error con el fichero");
		}
return lista;
	}
	}


