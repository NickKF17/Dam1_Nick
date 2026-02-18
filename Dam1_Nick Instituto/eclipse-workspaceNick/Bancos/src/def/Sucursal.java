package def;

import java.util.ArrayList;
import java.util.*;

public class Sucursal {
	private Banco banco;
private String calle;
private int numerocalle;
private int codigopostal;
private String ciudad;
private String codigo; /*(XXXX)*/
private  ArrayList<Clientes> clientes= new ArrayList<>();

private  ArrayList<Cuentas_Corrientes> cuentas= new ArrayList<>();


public Sucursal(Banco banco , String calle,int numerocalle, int postal , String ciudad, String codigo){

	

	this.banco=banco; 
		this.calle=calle;
		this.numerocalle=numerocalle;
		this.codigopostal=postal;
		this.ciudad=ciudad;
		this.codigo=codigo;
				banco.nuevasucursal(this);
	}
public void mostrar(){
	System.out.println(calle+","+numerocalle+"  "+codigopostal+"\n"+ciudad+"  "+ codigo);
}
public String getciudad() {
return ciudad;
}
public String getcodigo() {
	return codigo;
}
public void addCliente(Clientes clienteses) {
	clientes.add(clienteses);
}

public void listarclientes() {
	System.out.println("Sucursal: " + this.ciudad + " / "+"Codigo: " + "("+this.codigo+")");
	for(Clientes clien:clientes) {
		
		
		
		System.out.println("-"+clien.getApellido()+" , "+clien.getNombre() +"    Nif: "+clien.getNif());
	
	
	}
}

public void addCuenta(Cuentas_Corrientes cuenta) {
	cuentas.add(cuenta);
}


}
