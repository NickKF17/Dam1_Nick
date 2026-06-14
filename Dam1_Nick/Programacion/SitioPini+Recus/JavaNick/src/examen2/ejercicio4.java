package examen2;

import FuncionesLambda.Operacion;

public class ejercicio4 {

	public static void main(String[] args) {
		
		 Operacion perimetro= (a,b) -> (a*2)+(b*2);
				
				
				Operacion area= (a,b) -> a*b;
				
				System.out.println(perimetro.ejecutar(5, 6));
				System.out.println(area.ejecutar(5, 6));
				
				System.out.println(perimetro.ejecutar(1, 1));
				System.out.println(area.ejecutar(1, 1));
			}
	}
