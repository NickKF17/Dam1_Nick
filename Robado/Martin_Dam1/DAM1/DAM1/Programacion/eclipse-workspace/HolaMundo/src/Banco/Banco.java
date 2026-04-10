package Banco;
import java.util.*;
public class Banco {
	private String nombre;
	private String codigo;
	
	private static ArrayList<Sucursal> sucursales= new ArrayList<>();
	
	public Banco(String nombre, String codigo) {
		this.nombre= nombre;
		//como pendiente valida el código de banco
		this.codigo=codigo;
	}
	
	public void addSuc(Sucursal s){
		sucursales.add(s);
	}
	public void listarSucursales() {
		System.out.println("-----------------------------\nLas sucursales implantadas para el banco"+this.nombre+"("+this.codigo+")"+" son: \n-----------------------------");
		for(Sucursal s:sucursales) {
			s.mostrar();
		}
	}
	public void listarSucursalesSimp() {
		System.out.printf("Sucursales de %S(%s):\n",this.nombre,this.codigo);
		for(Sucursal s:sucursales) {
			System.out.printf(" - %S: (%s)\n",s.getCiudad(),s.getCodigo());
		}
	}
	public String getCodigo() {
		return this.codigo;
	}
}
