package RA6_Ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EXEJ2 {


public static void main(String[] args) {
	String [] alumnos = {"Ana","Luis","Marta","Carlos","Elena","Pablo","Laura","David","Sofia","Javier"};
	HashMap <String,Integer> notas=new HashMap<String,Integer>();
	ArrayList<Integer> numeros=new ArrayList<Integer>();
	System.out.println("===== NOTAS DE LA CLASE =====");
	for(String alumno:alumnos) {
		
	int azar=(int)(Math.random()*11)+0;	
	notas.put(alumno, azar);
	numeros.add(azar);
		System.out.printf("%-15s: %d\n",alumno,azar);
	}
	int total=0;
	int mayor=0;
	
	for(int nota:numeros) {
		if(nota>mayor) {
			mayor=nota;
		}
		total+=nota;
		}

	double media=(double) total/notas.size();
	double mediare=(double)Math.round((media) * 100) /100;
	
	Collections.sort(numeros);
	int alta=numeros.getLast();
	int baja=numeros.getFirst();
	int suspensos=0;
	int aprobados=0;
	for(int nota:numeros) {
		if(nota<5)
			suspensos++;
		else
			aprobados++;
	}
	String suspenso="";
	String aprobado="";
	String notable="";
	String sobresaliente="";
	for(Map.Entry<String, Integer> nota: notas.entrySet()) {
		if(nota.getValue()<5)
			suspenso+=nota.getKey()+", ";
		else if(nota.getValue()<=6)
			aprobado+=nota.getKey()+", ";
		else if(nota.getValue()<=8)
			notable+=nota.getKey()+", ";
		else if(nota.getValue()<=10)
			sobresaliente+=nota.getKey()+", ";
	}
	if(suspenso.length()>0)
	suspenso=suspenso.substring(0,suspenso.lastIndexOf(","));
	else suspenso="";
	if(aprobado.length()>0)
	aprobado=aprobado.substring(0,aprobado.lastIndexOf(","));
	else
		aprobado="";
	if(notable.length()>0)
	notable=notable.substring(0,notable.lastIndexOf(","));
	else notable="";
	if(sobresaliente.length()>0)
	sobresaliente=sobresaliente.substring(0,sobresaliente.lastIndexOf(","));
	else sobresaliente="";
	System.out.println("===== ESTADISTICAS =====");
	System.out.println("Nota media: "+mediare+"0");
	System.out.println("Nota mas alta: " + alta);
	System.out.println("Nota mas baja: "+baja);
	System.out.println("Aprobados: " + aprobados);
	System.out.println("Suspensos: " +suspensos);
	System.out.println("===== AGRUPACION POR CALIFICACION =====");
	System.out.printf("Suspenso     (0-4) :  %s\n",suspenso);
	System.out.printf("Aprobado     (5-6) :  %s\n",aprobado);
	System.out.printf("Notable      (7-8) :  %s\n",notable);
	System.out.printf("Sobresaliente(9-10) :  %s\n",sobresaliente);
}
}
