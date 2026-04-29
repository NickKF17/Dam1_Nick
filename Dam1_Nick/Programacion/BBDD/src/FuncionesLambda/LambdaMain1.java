package FuncionesLambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaMain1 {

	public static void main(String[] args) {
		Lambda1 product = (producto,precio,iva) -> {
			double precioFinal=precio + (precio * iva / 100);
			String resultado="PVP: "+producto+" : "+(double)Math.round(precioFinal*100)/100+" €";
		return resultado;
		};

		System.out.println(product.precioProducto("Tornillo", 300.4, 3));
	
		Runnable hola =() -> {
			System.out.println("Hola mundo");
		};
		hola.run();
		
		Consumer<String> adios =(nombre) ->{ System.out.println("Adios mundo cruel.\nFirmado - "+nombre);
		};
		adios.accept("Magnus Carlssen");
		
		Consumer<Integer> numeros=(num) -> {
			System.out.println("Veo " +num+" numeros numeros numeros");
		};
		numeros.accept(67);
	
		Supplier<String> saludo =() -> {
			return "Hola Mundo";
		};
		Supplier<Double> pi=() -> {
			return 3.14;
		};
		
		System.out.println(saludo.get());
		System.out.println(pi.get());
	}

}
