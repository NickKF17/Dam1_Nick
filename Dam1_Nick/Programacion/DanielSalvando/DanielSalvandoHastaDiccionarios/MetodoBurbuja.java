import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetodoBurbuja {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> numeros = new ArrayList<>(List.of(5, 9, 6, 4, 7, 8, 2, 3, 1));
		
		System.out.println(numeros);
		boolean cambio;
		do {
			cambio = false;
			for (int i = 0; i <= numeros.size() - 2; i++) {
				int n1 = numeros.get(i);
				int n2 = numeros.get(i + 1);
				if (n1 < n2) {
					n1 = numeros.indexOf(n1);
					n2 = numeros.indexOf(n2);
					Collections.swap(numeros, n1, n2);
					cambio = true;
				}
			}
		} while (cambio == true);
		System.out.println(numeros);
		
	}
}
