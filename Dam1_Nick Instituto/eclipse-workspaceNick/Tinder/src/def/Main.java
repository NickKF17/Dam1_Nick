package def;

public class Main {

	public static void main(String[] args) {
		Tinder tinder=new Tinder();
		
		Hombre h1 = new Hombre(tinder,"Pepe", "12/08/1998", 1);
		Mujer m1 = new Mujer(tinder,"Maria", "23/02/1970", 1, 20, 100);
		Hombre h2 = new Hombre(tinder,"Antonio", "22/10/1965", 2, 20, 80);
		Mujer m2 = new Mujer(tinder,"Ines", "12/08/1998", 2);
		Otro o1 = new Otro(tinder,"Jorge", "23/02/1970", 1, 50, 60);
		Otro o2 = new Otro(tinder,"Valentina", "22/10/1965", 2);
		
		
tinder.listaMatches(h2);
	
	}

}
