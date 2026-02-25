package def;
import java.nio.file.spi.FileSystemProvider;
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

	if (h1.getQueBusco()==0) {
		
		for(Hombre h:this.listaHombres) {
			if(h.getQueBusco()!=2 && h1.esMatch(h)==true && h!=h1)
		matches.add(h);
		}
	

	for(Mujer mujer:this.listaMujeres)
		if(mujer.getQueBusco()!=2 && h1.esMatch(mujer)==true)
			matches.add(mujer);

	for(Otro o:this.listaOtro)
		if(o.getQueBusco()!=2 && h1.esMatch(o)==true)
	matches.add(o);
}
	else if (h1.getQueBusco()==1) {
		for(Hombre hombre:this.listaHombres)
			if(hombre.getQueBusco()!=2 && h1.esMatch(hombre)==true && hombre!=h1)
		matches.add(hombre);

		}else {
			for(Mujer m:this.listaMujeres)
				if(m.getQueBusco()!=2 && h1.esMatch(m)==true)
			matches.add(m);
		}


	if (matches.size()==0)
		System.out.println("No hay nadie que haga match contigo");

	else 
		for(Persona persona:matches)
			persona.mostrarDatos();
}


public  void listaMatches(Mujer m1) { 
	
}

public  void listaMatches(Otro o1) {
	
}
}
