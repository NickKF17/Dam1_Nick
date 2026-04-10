package parte2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Listas {

	public static void main(String[] args) {
		ArrayList<String> textos = new ArrayList<>();
		ArrayList<Double> notas = new ArrayList<>();
		ArrayList<Integer> numeros = new ArrayList<>(List.of(5,3,8,9,10,6));
		
		ArrayList<Double> precios = new ArrayList<>(List.of(33.5, 56.33, 175.0));
		
		textos.add("HolaMundo");
		textos.add("Adios, adios");
		notas.add(9.5);
		precios.add(23.12);
		
		
		
		System.out.println(precios);
		System.out.println(textos);
		System.out.println(notas);
		
		System.out.println(textos.get(1));//recupera un elemento, no lo elimina
		
		System.out.println(textos.size());
		
		ArrayList<String> alumnos = new ArrayList<>(List.of("Jaime","Lucía", "Adrian","Lucía","Óscar"));
		if(alumnos.contains("Pepe"))
			System.out.println("Está en la lista");
		else
			System.out.println("No está en la lista");
		
		System.out.println(alumnos.indexOf("Lucía"));
		System.out.println(alumnos.indexOf("Pepe"));
		System.out.println(alumnos.lastIndexOf("Lucía"));
		System.out.println(alumnos.remove("Lucía"));
		System.out.println(alumnos.remove(3));
		System.out.println(alumnos);
		
		System.out.println(numeros);
		System.out.println(numeros.remove(3));
		System.out.println(numeros.remove((Integer)3));
		System.out.println(numeros);
		
		numeros.clear();
		System.out.println(numeros);
		System.out.println(numeros.size());
		if(numeros.isEmpty())
			System.out.println("El Array está vacío broer");
		
		ArrayList alumnos2=(ArrayList) alumnos.clone();//the copy of Array is totally independent
		System.out.println(alumnos2);
		
		List<Integer> tupla = List.of(9,8,7,6,5,4,3,2,1);
		System.out.println(tupla);
		
		
		for(int i=0; i<alumnos.size(); i++)
			System.out.println(alumnos.get(i));
		
		Iterator<String> iterador = textos.iterator();
		while(iterador.hasNext()) {
			System.out.println(iterador.next());
		}

	}

}
