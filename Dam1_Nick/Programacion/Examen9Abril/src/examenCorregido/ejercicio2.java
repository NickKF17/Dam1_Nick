package examenCorregido;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.*;
public class ejercicio2 {

	public static void main(String[] args) {
		String fAnimes="animes.txt";
		String fPersonajes="personajes.txt";
		String fBinario="personajes.dat";
		try {
			HashMap<Integer,String> animes = leerDatosAnimes(fAnimes);
			ArrayList<Personaje>listaPersonajes=new ArrayList<>();
			for(Map.Entry<Integer, String> anime : animes.entrySet()) {
				ArrayList<String> personajes =leerPersonajes(anime.getKey(),fPersonajes);
				if(personajes.size()!=0)
					for(String p :personajes) {
						Personaje objeto = new Personaje(anime.getValue(),p);
						listaPersonajes.add(objeto);
					}
			}
			escribirBinario(listaPersonajes,fBinario);
			ArrayList<Personaje> listaFichero = leerBinario(fBinario);
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
static void escribirBinario(ArrayList<Personaje>lista,String fichero) throws Exception{
	try(ObjectOutputStream pluma = new ObjectOutputStream(new FileOutputStream(fichero))){
		pluma.writeObject(lista);
		System.out.println("Fichero "+ fichero+" escrito con "+lista.size()+" objetos");
	}
}
static ArrayList<Personaje>leerBinario(String fichero) throws Exception{
	ArrayList<Personaje>lista=new ArrayList<>();
	try(ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))){
lista=(ArrayList<Personaje>)lector.readObject();
System.out.println(lista.size()+" objetos leidos del fichero "+ fichero);
	}
	return lista;
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
