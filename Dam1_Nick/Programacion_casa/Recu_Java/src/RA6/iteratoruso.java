package RA6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iteratoruso {

	public static void main(String[] args) {

ArrayList<Integer> numeros = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));  

Iterator it = numeros.iterator();

while(it.hasNext()) {
	int num=(int) it.next();	
	if(num%2==0)
		it.remove();
}
System.out.println(numeros);
	}

}
