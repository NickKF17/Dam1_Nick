package RA5_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainProductos {

	public static void main(String[] args) {
		String fichero="productos.dat";
		ArrayList<Producto> productos=new ArrayList<>();
		Producto p1 =new Producto("Balón",2.2,2);
		Producto p2 =new Producto("Chicle",1.0,1);

		productos.add(p1);
		productos.add(p2);
		
		ficherobinario(fichero, productos);
		leerFicheroBinario(fichero);
	}

	public static void ficherobinario(String fichero,ArrayList<Producto> productos) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))){
			
			oos.writeObject(productos);
			
		
	}catch(IOException e) {
		System.out.println("Error: "+e.getMessage());
		}
	}
	

	private static void leerFicheroBinario(String fichero) {
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))){
			
			ArrayList<Producto> recuperados = (ArrayList<Producto>) ois.readObject();
			for(Producto producto:recuperados)
				System.out.println(producto.toString());
		}catch(Exception e){
			System.out.println("Error:"+e.getMessage());
		}
		
	}
}
