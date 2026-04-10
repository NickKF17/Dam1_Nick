package Pinguinder;

import java.util.ArrayList;
import java.util.HashSet;

public class Guinder {
	private HashSet<Onvre> quienEsEseHombre = new HashSet<>();
	private HashSet<Mujeh> quienEsEsaMujer = new HashSet<>();
	private HashSet<Otros> quienEsEseOtros = new HashSet<>();

	public void anyade(Onvre h) {
		quienEsEseHombre.add(h);
	}

	public void anyade(Mujeh m) {
		quienEsEsaMujer.add(m);
	}

	public void anyade(Otros o) {
		quienEsEseOtros.add(o);
	}

	public void listaMatches(Onvre h) {
		ArrayList<Persona> matches = new ArrayList<>();
		
		if (h.getQueBusco()!= 2) {
			for(Onvre on:this.quienEsEseHombre)
				if (this.quienEsEseHombre.contains(h)==false)
					if((on.queBusco==0 || on.queBusco ==2) && h.esMatch(on))
						matches.add(on);
				
		} else if (h.getQueBusco() == 1) {
			for(Mujeh m: this.quienEsEsaMujer)
				if ((m.queBusco == 0 || m.queBusco ==2) && h.esMatch(m))
					matches.add(m);
		} else {
			for(Otros o: this.quienEsEseOtros)
				if((o.queBusco == 1 || o.queBusco ==2) && h.esMatch(o))
					matches.add(o);
		}
		if(matches.size()==0)
			System.out.println("No tengo personas que matcheen contigo brohter :(");
		else
			for(Persona p: matches)
				p.mostrarDatos();
	}

	public void listaMatches(Mujeh m) {
		ArrayList<Persona> matches = new ArrayList<>();
		if (m.getQueBusco() == 0) {
			for(Onvre o:this.quienEsEseHombre)
				if(m.queBusco!=1)
					matches.add(m);
		} else if (m.getQueBusco() == 1) {

		} else {

		}
		if(matches.size()==0)
			System.out.println("No tengo personas que matcheen contigo mi ñaña :(");
		else
			for(Persona p: matches)
				p.mostrarDatos();
	}

	public void listaMatches(Otros o) {
		ArrayList<Persona> matches = new ArrayList<>();
		if (o.getQueBusco() == 0) {

		} else if (o.getQueBusco() == 1) {

		} else {

		}
		if(matches.size()==0)
			System.out.println("No tengo personas que matcheen contigo br... no sé que eres :((");
		else
			for(Persona p: matches)
				p.mostrarDatos();
	}
}
