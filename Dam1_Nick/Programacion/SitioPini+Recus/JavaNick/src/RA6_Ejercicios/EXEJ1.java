package RA6_Ejercicios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EXEJ1 {

	public static void main(String[] args) {
		String frase="Como quieres que te quiera Si el que quiero que me quiera No me quiere como quiero que me quiera";
		HashMap  <String,Integer>contador = new HashMap <>();
		String [] lista =frase.split(" ");
		int contadork=0;
		for (String palabra : lista){
		
            String palabraLimpia = palabra.toLowerCase(); 
			if(contador.containsKey(palabraLimpia)==false)
			contador.put(palabraLimpia, 1);
			else {
			contadork =contador.get(palabra);
			
			contador.put(palabra, contadork+1);
			}
				}
		System.out.println("Texto a analizar: “Como quieres que te quiera Si el que\n"
				+ "quiero que me quiera No me quiere como quiero que me quiera”\n");
		
		System.out.println("Total de palabras: "+ lista.length);
		
		System.out.println("Palabras repetidas mas de una vez: ");
	
		for(Map.Entry<String, Integer> palabras:contador.entrySet()) {
			if(palabras.getValue()>1){
			System.out.println(palabras.getKey()+": "+palabras.getValue()+" veces");
			}
		}
		String frasenueva=frase.replace(" ", "");
		double media=(double)frasenueva.length()/lista.length;
	
		System.out.printf("Longitud media de las palabras del texto: + %.2f ",media);
		
		System.out.println("Palabras agrupadas por veces que aparecen:");
		int mayor=0;
		for(Map.Entry<String, Integer> ultimo:contador.entrySet()) {
			if(ultimo.getValue()>mayor)
			mayor=ultimo.getValue();
		}
		for(int i=mayor;i>=1;i--) {
		String sincorche =arraypalabras(i, contador).toString();
		sincorche=sincorche.replace("[", "").replace("]", "");
		if(i==1)
		System.out.println("Aparecen una sola vez " +sincorche);
			else
			System.out.println("Aparecen "+i+" veces: "+sincorche);
			
		}
	}
	public static  ArrayList<String> arraypalabras(int frecuencia,HashMap<String,Integer> diccionario) {
		ArrayList<String> palabras=new ArrayList<>();
		for(Map.Entry<String, Integer> pal:diccionario.entrySet()) {
			if(pal.getValue()==frecuencia)
				palabras.add(pal.getKey());
		}
		
		return palabras;
	}
	}


