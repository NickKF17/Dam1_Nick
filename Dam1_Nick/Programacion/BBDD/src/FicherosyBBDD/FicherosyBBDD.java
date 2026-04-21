	package FicherosyBBDD;
	
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.Reader;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.util.ArrayList;
import java.util.Arrays;
	
	public class FicherosyBBDD {
	public static void main(String[] args) {
		
		String usuario="admin";
		String password="1234";
		String server="FicherosyBBDD:mysql://localhost:3306/";
		String fichero="exceljava.csv";
	
		leerDatos(fichero);
		
	}
	
	
	public static void leerDatos(String fichero) {
		 try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {
			
			String linea=null;
			ArrayList<String> todo=new ArrayList<>();
			int contador=1;
			while((linea = lector.readLine())!=null) {
				if(contador>4) {
				String [] partes = linea.split(",");
	            contador++;
	           todo.addAll(Arrays.asList(partes));
	            System.out.println();
			}
			}
		}catch (Exception e) {
			System.out.println("Error con el fichero");
		}
	}
}