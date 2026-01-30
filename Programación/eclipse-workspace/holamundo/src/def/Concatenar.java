package def;

import java.util.Scanner;

public class Concatenar {

	public static void main(String[] args) {
		
String texto1  ="Hola Mundo";
String texto2 = new String("Hola mundo cruel");
texto1=texto1 + " cruel";
System.out.println(texto1);

texto1.concat(" Bienvenidos al goya");

System.out.println(texto1.concat(" Bienvenidos al goya"));

int precio= 55;
System.out.println("El precio es de " + precio + " euros");

for(int i=0; i<texto2.length();i++)
	System.out.println(texto2.charAt(i));


System.out.println(texto2.toLowerCase());
System.out.println(texto2.toUpperCase());

String nombre1 ="Nick";
String nombre2 ="NICK";

if(nombre1.equalsIgnoreCase(nombre2) == true)
	System.out.println("Son iguales");
else
	System.out.println("No son iguales");


String nombre3 ="Constante";
String nombre4 ="Santos";

if(nombre3.compareTo(nombre4) == 0)
	System.out.println("Son iguales");
else if (nombre3.compareTo(nombre4)>0)
	System.out.println(nombre3 + " va detras de " + nombre4);
else
	System.out.println(nombre3 + " va delante de " + nombre4);



System.out.println(nombre1.substring(1));
System.out.println(nombre2.substring(2));
System.out.println(nombre3.substring(3,6));
System.out.println(nombre4.substring(4));


String cadenaVacia="";
String cadenaNula;
String cadenaNUla2 = null;


if(cadenaVacia.isEmpty()==true)
	System.out.println("La cadena esta vacia");
if (cadenaVacia.equals(""))
	System.out.println("La cadena esta vacia");
if (cadenaVacia.compareTo("")==0)
System.out.println("La cadena esta vacia");




String texto= "Hola mundo cruel";
System.out.println(texto.indexOf("ru"));


System.out.println(texto.replace(" ","-"));
System.out.println(texto);

texto=texto.replace(" ", "-");
System.out.println(texto);
	}}