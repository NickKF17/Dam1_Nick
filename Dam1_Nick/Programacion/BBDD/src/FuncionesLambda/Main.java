package FuncionesLambda;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Operacion suma= (a,b) -> a+b; La forma mas simple de definirla
		Operacion suma= (a,b) -> { 
			int x = a+b;
			return x;
		};
		
		
		Operacion resta= (a,b) -> { 
			int x = a-b;
			return x;
		};
		
		Operacion producto= (a,b) -> { 
			int x = a*b;
			return x;
		};
		
		System.out.println(suma.ejecutar(5, 6));
		System.out.println(resta.ejecutar(5, 6));
		System.out.println(producto.ejecutar(5, 6));
	}

}
