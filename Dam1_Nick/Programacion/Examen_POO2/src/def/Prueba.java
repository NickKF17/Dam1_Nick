package def;
import java.util.*;
import java.util.Map.Entry;
public class Prueba {
	private int contador=1;
	private int eliminados;
	private int restantes;
	public static HashMap<Integer,Prueba> pruebas=new HashMap<>(); 
	public Prueba(int eliminados,int num) {
		this.eliminados=eliminados;	
		this.restantes=num;
		
pruebas.put(contador, this);
contador++;
	}
	public int getEliminados() {
		return this.eliminados;
	}
	
	public int getRestantes() {
		return this.restantes;
	}
	
}
