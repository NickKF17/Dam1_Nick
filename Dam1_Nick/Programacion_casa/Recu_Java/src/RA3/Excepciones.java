package RA3;

public class Excepciones {

	public static void main(String[] args) {
		String[] nombres = {"Ana", "Luis"};
		
		try {		
			System.out.println(nombres[33]);
		}catch(Exception e){
				System.out.println("No hay ni un registro en esa posición del array");
			}

	}

}
