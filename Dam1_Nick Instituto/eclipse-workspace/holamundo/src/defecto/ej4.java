package defecto;

public class ej4 {

	public static void main(String[] args) {
		
		String texto1 = "Examen 1T01";
		String texto2 = "Octubre-2025";
		String textoCompleto="";
		
		int posicion1 = texto1.indexOf(" ");
		int posicion2 = texto2.indexOf("-");
		textoCompleto +=texto1.substring(posicion1)+texto2.substring(posicion2);
		textoCompleto +=" "+texto1.substring(0,posicion1)+" "+texto2.substring(0,posicion2);
		textoCompleto+= "("+textoCompleto.length()+")";
		System.out.println(textoCompleto);
	}

}
