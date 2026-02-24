package def;

import java.util.*;

public class Paquete {
	
	private static ArrayList<Paquete> listaPaquetes=new ArrayList<>();
	private double peso;
	private int localizacionx;
	private int localizaciony;
	
	public Paquete(double peso,int localizacionx,int localizaciony){
		
	this.peso=peso;
	this.localizacionx=localizacionx;
	this.localizaciony=localizaciony;
	
	Paquete.listaPaquetes.add(this);
		
	}

}
