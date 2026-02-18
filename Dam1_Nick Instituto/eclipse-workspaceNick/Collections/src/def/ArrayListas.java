package def;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ArrayListas {

	public static void main(String[] args) {
ArrayList<String> textos =new ArrayList<>();
ArrayList<Double> notas =new ArrayList<>();
ArrayList<Integer> numeros =new ArrayList<>(List.of(1,2,3,4,5,6));

ArrayList<Double> precios =new ArrayList<>(List.of(33.5,56.33,175.0));

textos.add("Hola Mundo");
textos.add("Adios,adios");

notas.add(9.5);
precios.add(23.12);

System.out.println(precios);
System.out.println(textos);
System.out.println(notas);

System.out.println(textos.get(1));

System.out.println(textos.size());

ArrayList<String> alumnos = new ArrayList<>(List.of("Jaime","Adrian","Lucia","Oscar","Lucia"));	
if(alumnos.contains("pepe"))
	System.out.println("Esta en la lista");
else
	System.out.println("No esta en la lista");


System.out.println(alumnos.indexOf("Pepe"));
System.out.println(alumnos.lastIndexOf("Lucia"));

alumnos.remove("Lucia");
System.out.println(alumnos);

numeros.remove(2);
System.out.println(numeros);
System.out.println(numeros.remove((Integer)2));
System.out.println(numeros);


numeros.clear();
System.out.println(numeros);
System.out.println(numeros.size());
System.out.println(numeros.isEmpty());


ArrayList alumnos2 = (ArrayList) alumnos.clone();

System.out.println(alumnos2);

List<Integer> tupla = List.of(9,8,7,6,5,4,3,2,1);
System.out.println(tupla);

for(int i=0;i<alumnos.size();i++)
	System.out.println(alumnos.get(i));


Iterator<String> iterador =textos.iterator();
while(iterador.hasNext()) {
	System.out.println(iterador.next());
	
}

	}

}
