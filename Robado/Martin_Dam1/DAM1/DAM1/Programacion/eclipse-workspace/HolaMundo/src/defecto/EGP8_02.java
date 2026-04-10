package defecto;
import java.util.regex.*;
import java.util.*;

public class EGP8_02 {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		boolean claveBien= false;
		String contraseña = "";
		while(claveBien==false){
		System.out.println("Introduce la contraseña: ");
		contraseña = teclado.nextLine();
		if(longitudCorrecta(contraseña)==false||longitudCorrecta2(contraseña)==false)
			System.out.println("La longitud no es correcta, recuerda que debe de tener entre 8 a 20 caracteres.\n");
		else {
			//COn mayusculas y minúsculas
			if (alMenos1MinyMay(contraseña)==false)
				System.out.println("Clave invlálida\nRecuerda que tiene que tener al menos un catacter en mayúscula y uno en minúscula.\n");
			else {
				if(AlmenosunNum(contraseña)==false)
					System.out.println("Clave inválida\nRecuerda que tiene que tener al menos un número.\n");
				
					if(simbolosEspeciales(contraseña)==false)
						System.out.println("Clave inválida\nLa clave tiene que tener alguno de estos símbolos: _,-,*,?.\n");
					else
						claveBien=true;
				
			
		}
		}	
		}
		System.out.println("La clave introducida es válida\nAhora introduce otra contraseña por favor:");
		String clave2= teclado.nextLine();
			if(clavesCoinciden(contraseña,clave2)==false)
				System.out.println("Las claves no coinciden, vuelve a intentarlo.");

		

	}
	static boolean longitudCorrecta(String c) {
		boolean longit=false;
		if (c.length()>=8 && c.length()<=20)
			longit= true;
		return longit;
	}

	static boolean longitudCorrecta2(String c) {
		//Otra forma de validarlo con expresiones regulares
		return(c.matches(".{8,20}"));
	}
	
	static boolean alMenos1MinyMay(String c) {
		String cMin= c.toLowerCase();
		String cMax= c.toUpperCase();
		boolean si= true;
		if (c.equals(cMax)||c.contentEquals(cMin))
			si=false;
		return si;
	}
	
	static boolean AlmenosunNum(String c) {
		Pattern unnumero= Pattern.compile("\\d+");
		Matcher coincidencia = unnumero.matcher(c);
		return (coincidencia.matches());
	}
	
	static boolean simbolosEspeciales(String c) {
		Pattern simbolo = Pattern.compile("[_\\-*?]+");
		Matcher siSimbolo = simbolo.matcher(c);
		return(siSimbolo.find());
	}
	
	static boolean clavesCoinciden(String c, String c2) {
		
		return false;
	}
}
