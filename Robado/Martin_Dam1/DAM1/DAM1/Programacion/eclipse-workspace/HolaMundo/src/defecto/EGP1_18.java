package defecto;

public class EGP1_18 {

	public static void main(String[] args) {
		int fin = 1000;
		int contador = 0;
		int azar;
		System.out.println("elfindemundoinador versión 1.0");
		System.out.println("100111001101001010001101");
		System.out.println(".........................");
		do {
			azar = (int) (Math.random()*fin)+1;
			System.out.println(azar);
			contador++;
		} while (azar!=666);
		System.out.println("OOOHHHHHH, EL FIN DEL MUNDO SERÁ EN " + contador + " DÍAS, ¡¡APÚRATE CABRÓN, QUE YA MISMO SE ACABA EL PAPEL EN LOS SUPERMERCADOS!!");
		

	}

}
