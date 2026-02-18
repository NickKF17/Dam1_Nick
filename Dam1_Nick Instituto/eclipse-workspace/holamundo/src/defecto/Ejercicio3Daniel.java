package defecto;

public class Ejercicio3Daniel {

	public static void main(String[] args) {
		int num1=8;
		int num2=50;
		capicuaEntre(num1, num2);
	}
	public static void capicuaEntre(int num1,int num2) {
		System.out.println("Números capicúas entre "+num1+" y "+num2+":");
		int cont=0;
		for(int j=num1;j<=num2;j++) {
			String numStr=Integer.toString(j);
			String numStrReversa="";
			for(int i=numStr.length()-1;i>=0;i--) {
				numStrReversa+=numStr.charAt(i);
			}
			if(numStr.equals(numStrReversa)) {
				System.out.println(j);
				cont++;
			}
		}
		if(cont==0)
			System.out.println("No hay ningún número capicúa");
		else
			System.out.println("Hay un total de "+cont+" números capicúas");
	}

}
