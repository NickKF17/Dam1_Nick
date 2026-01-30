package def;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class digitos {

	public static void main(String[] args) {
		
		/*
		Pattern patron =Pattern.compile("[6-8][0-9]{8}");
		Matcher coincidencia = patron.matcher("635467893");
	
		if(coincidencia.find()==true)
System.out.println("Es un numero de telefono valido");
else
	System.out.println("No es un numero de telefono valido");
	*/
		
String telefono="635467893";
	
		if(telefono.matches("[6-8][0-9]{8}")==true)
System.out.println("Es un numero de telefono valido");
else
	System.out.println("No es un numero de telefono valido");
		
	}}