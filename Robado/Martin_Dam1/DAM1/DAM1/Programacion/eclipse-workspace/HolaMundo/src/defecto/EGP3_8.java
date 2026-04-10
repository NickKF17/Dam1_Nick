package defecto;

public class EGP3_8 {

	public static void main(String[] args) {
		String texto = "Hola mundo cruel, NECESITO IR A MEAR A LA DE YA!";
		String sinVocales="";
		String texto2 = texto.toLowerCase();
		for(int i=0; i<texto.length(); i++) {
			char c = texto2.charAt(i);
			if(c !='a' && c != 'e' && c!='i' && c != 'o' && c !='u')
				sinVocales += texto.charAt(i);
		}
		System.out.println(sinVocales);
		for(int i=0; i<texto.length(); i++) {
			char c = texto2.charAt(i);
			switch(c) {
			case 'a':
				break;
			case 'i':
			break;
			case 'u':
			break;
			case 'e':
			break;
			case 'o':
			break;
			default:
				sinVocales = sinVocales +texto.charAt(i);
			}
		}
		System.out.println(sinVocales);
	}

}
