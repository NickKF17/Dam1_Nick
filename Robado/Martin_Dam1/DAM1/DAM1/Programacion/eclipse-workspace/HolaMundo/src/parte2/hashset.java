package parte2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class hashset {

	public static void main(String[] args) {
		ArrayList <Integer> conjuntoNumeros = new ArrayList<>(List.of(22,55,6,2,3,77,8,55,1,2,6));
		HashSet <Integer> listaNumeros = new HashSet<>(Arrays.asList(1, 44, 55, 67, 77, 23, 15));
		//para transformar de un Array a un arraylist o un hashset
		int[] vector = {4, 5, 6, 22, 4, 1, 7, 9};
		ArrayList<Integer> vectorLista = new ArrayList<>();
		for(int n:vector)
			vectorLista.add(n);
		System.out.println(vectorLista);
		
		HashSet<Integer> conjuntoLista = new HashSet<>();
		for(int n:vector)
			conjuntoLista.add(n);
		System.out.println(conjuntoLista);
		//para transformar de hashset o arraylist a un array normal
		int[] vectorListaNumeros = new int[conjuntoNumeros.size()];
		int i=0;
		for(int n:conjuntoNumeros) {
			vectorListaNumeros[i]=n;
					i++;
		}
		for (int n:vectorListaNumeros)
			System.out.print(n+" - ");
		
		System.out.println();
		int[] vectorConjuntoNumeros = new int[listaNumeros.size()];
		i=0;
		for(int n:listaNumeros) {
			vectorConjuntoNumeros[i]=n;
					i++;
		}
		for (int n:vectorConjuntoNumeros)
			System.out.print(n+" - ");
	}

}
