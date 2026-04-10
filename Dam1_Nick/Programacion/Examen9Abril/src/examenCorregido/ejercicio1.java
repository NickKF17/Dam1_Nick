package examenCorregido;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class ejercicio1 {

	public static void main(String[] args) {
		String fAnimes="animes.txt";
		String fPersonajes="personajes.txt";
		try {
			HashMap<Integer,String> animes = leerDatosAnimes(fAnimes);
			
			for(Map.Entry<Integer, String> anime : animes.entrySet()) {
				ArrayList<String> personajes =leerPersonajes(anime.getKey(),fPersonajes);
				System.out.println(anime.getValue());
				if(personajes.size()==0)
					System.out.println("No hay personajes");
				else
					for(String p :personajes)
						System.out.println("- "+p);
				System.out.println();
			
			}
			ArrayList<String>personajes=leePersonajesSinAnime(animes, fPersonajes);
			if(personajes.size()!=0) {
			System.out.println("Personajes sin anime");	
			for(String p:personajes) {
			System.out.println("- "+p);
			
			}
			}
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		}
static HashMap<Integer,String> leerDatosAnimes(String fichero) throws Exception{
	HashMap<Integer,String> animes = new HashMap<>();
	try(BufferedReader br =new BufferedReader(new FileReader(fichero))){
		String linea;
		while((linea=br.readLine()) !=null) {
			int posicion =linea.indexOf(' ');
			int num= Integer.parseInt(linea.substring(0,posicion));
		String titulo=linea.substring(posicion+1);
		animes.put(num, titulo);
		}
		
	}
	return animes;
}
	
static ArrayList<String>leerPersonajes(int codigo,String fichero) throws Exception{
	ArrayList<String> personajes =new ArrayList<>();
			
	try(BufferedReader br =new BufferedReader(new FileReader(fichero))){
		String linea;
		while((linea=br.readLine()) !=null) {
			int posicion =linea.indexOf(' ');
			int num= Integer.parseInt(linea.substring(0,posicion));
			if(num==codigo) {
		String nombre=linea.substring(posicion+1);
		personajes.add(nombre);
		}
		}
	}
	return personajes;

}
static ArrayList<String> leePersonajesSinAnime(HashMap<Integer,String> animes,String fichero) throws Exception {
	ArrayList<String> personajes =new ArrayList<>();
	try(BufferedReader br =new BufferedReader(new FileReader(fichero))){
		String linea;
		while((linea=br.readLine()) !=null) {
			int posicion =linea.indexOf(' ');
			int num= Integer.parseInt(linea.substring(0,posicion));
			if(!animes.containsKey(num)) {
		String nombre=linea.substring(posicion+1);
		personajes.add(nombre);
		}
		}
	}
	return personajes;
	
}
}
