package def;
import java.util.*;
public class Tinder {
	private HashSet<Hombre> listaHombres =new HashSet<>();
	private HashSet<Mujer> listaMujeres=new HashSet<>();
	private HashSet<Otro> listaOtro=new HashSet<>();
public Tinder(){
	
}

public void anyade(Hombre hombre) {
listaHombres.add(hombre);	
}


public void anyade(Mujer mujer) {
listaMujeres.add(mujer);	
}


public void anyade(Otro otro) {
listaOtro.add(otro);	
}
public  void listaMatches(Hombre h1) {
	ArrayList<Persona> matches = new ArrayList<>();

for (Hombre onvre :listaHombres) {
	if (h1.getQueBusco()==0)
	System.out.println(onvre.getNombre());
	else if (h1.getQueBusco()==1) {
		System.out.println(onvre.getNombre());}
		else if (h1.getQueBusco()==2) {
			System.out.println(onvre.getNombre());
	}
}
}

public  void listaMatches(Mujer m1) { 
	
}

public  void listaMatches(Otro o1) {
	
}
}
