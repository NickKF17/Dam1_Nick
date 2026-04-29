package FuncionesLambda;

import java.util.ArrayList;
import java.util.HashSet;

public class LambdaMain2 {

	public static void main(String[] args) {
		Lambda2 random=(inicio,fin,cuantos)->{
			HashSet<Integer> numeros=new HashSet<>();
			
			do {
			int azar=(int)(Math.random()*fin-inicio+1)+inicio;
			
				numeros.add(azar);
			}while(numeros.size()!=cuantos);
			ArrayList <Integer> arraynum =new ArrayList<>(numeros);
			
			for(int num:arraynum)
				System.out.println(num);
		};
		
		random.numerosRandom(2, 7, 3);
	}

}
