package defecto;
import java.util.Scanner;
public class EjAparte02 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double importe =0;
		int personas = 0;
		try {
		System.out.println("Cuánto ha costado la cena?: ");
		importe = teclado.nextDouble();
		//teclado.nextLine();//Para limpiar el buffer del teclado
		System.out.println("Cuántos habéis cenado?: ");
		personas = teclado.nextInt();
		}catch(Exception e) {
			System.out.println("Ha ocurrido un error");
		}
		//El finally se ejecuta haya o no haya excepcion
		finally {
			teclado.close();
		}
		//teclado.close();
		if(importe!=0 && personas !=0){
		double porPersona = importe/personas;
		System.out.printf("Tocais a %.2f € por cabeza", porPersona );
		}
		else
			System.out.println("Ni el importe ni los comenzales pueden ser 0");
	}

}
