package parte2;

import java.util.ArrayList;
import java.util.List;

public class algoritmos {
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList(List.of(7, 1, 3, 5, 4, 6));

		//AVERIGUAR POR QUË LAS DOS FUNCIONES NO PUEDEN FUNCIONAR A LA VEZ
		
		//ArrayList<Integer> ordenada1 = ordenarPorSeleccion(numeros);
		//System.out.println(ordenada1);

		ArrayList<Integer> ordenada2 = ordenarPorBurbuja(numeros);
		System.out.println(ordenada2);

	}

	public static ArrayList<Integer> ordenarPorSeleccion(ArrayList<Integer> desordenada) {
		ArrayList<Integer> desordenada2 = desordenada;
		ArrayList<Integer> ordenada = new ArrayList<>();
		//int initialSize = desordenada.size();
		while (desordenada.size()!=0) {
			int mayor = -1;
			int index = 0;
			for (int i=0; i<desordenada2.size();  i++) {
				if(mayor<desordenada2.get(i)) {
					mayor=desordenada2.get(i);
					index = i;
				}	
			}
			ordenada.add(mayor);
			desordenada2.remove(index);
			
		}
		return ordenada;
	}

	public static ArrayList<Integer> ordenarPorBurbuja(ArrayList<Integer> desordenada) {
		ArrayList<Integer> ordenada = desordenada;
		int temp = 0;
		int num1 = 0;
		int num2 = 0;
		boolean si = false;
		while (si == false) {
			si = true;
			for (int i = 0; i < ordenada.size(); i++) {
				if (i < ordenada.size() - 1) {
					if (ordenada.get(i) < ordenada.get(i + 1)) {
						si = false;
						temp = ordenada.get(i);
						
						num1 = ordenada.get(i + 1);
					ordenada.set(i, num1);
					ordenada.set(i+1, temp);
					}
				}
			}
		}
		return ordenada;
	}
}
