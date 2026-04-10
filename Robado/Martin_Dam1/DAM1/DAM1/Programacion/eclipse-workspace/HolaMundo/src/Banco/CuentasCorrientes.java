package Banco;
import java.util.*;
public class CuentasCorrientes {
	private ArrayList<Cliente> titulare= new ArrayList<>();
	private float saldo;
	private Sucursal sucursal;
	private String codigo;
	
	public CuentasCorrientes(Cliente c1, float saldo, Sucursal sucursal, String codigo) {
		titulare.add(c1);
		c1.addCuenta(this);
		this.saldo=saldo;
		this.sucursal=sucursal;
		sucursal.addCuenta(this);
		this.codigo=codigo;
	}
	public CuentasCorrientes(Cliente c1, Cliente c2, float saldo, Sucursal sucursal, String codigo) {
		this.titulare.add(c1);
		this.titulare.add(c2);
		if(c1==c2) {
			System.out.println("El titular no se podrá repetir en la misma cuenta");
			c1.addCuenta(this);
		}
		else {
		c1.addCuenta(this);
		c2.addCuenta(this);
		}
		this.saldo=saldo;
		this.sucursal=sucursal;
		sucursal.addCuenta(this);
		this.codigo=codigo;
	}
	public void mostrarIban() {
		System.out.println(this.sucursal.getCodigoGlande()+" "+ this.codigo);
	}
	public String getCodigo() {
		return this.codigo;
	}
	public float getSaldo() {
		return this.saldo;
	}
}
