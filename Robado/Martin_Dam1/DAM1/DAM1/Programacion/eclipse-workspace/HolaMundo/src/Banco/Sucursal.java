package Banco;

import java.util.ArrayList;

public class Sucursal {
	private Banco banco;
	private String calle;
	private int numero;
	private int codigoPostal;
	private String ciudad;
	private String codigo;
	
	private static ArrayList<CuentasCorrientes> cuentas= new ArrayList<>();
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	public Sucursal(Banco banco, String calle, int numero, int codigoPostal, String ciudad, String codigo) {
		this.banco= banco;
		banco.addSuc(this);
		this.calle= calle;
		this.numero=numero;
		this.codigoPostal=codigoPostal;
		this.ciudad=ciudad;
		this.codigo=codigo;
		
		
	}
	
	public void addCliente(Cliente c1) {
		clientes.add(c1);
	}
	
	public void addCuenta(CuentasCorrientes c1) {
		cuentas.add(c1);
	}
	
	public void mostrar() {
		System.out.println("-----------------------------");
		System.out.print(this.calle+ " ");
		System.out.println(this.numero);
		System.out.println(this.codigoPostal);
		System.out.println(this.ciudad);
		System.out.println(this.codigo);
		System.out.println("-----------------------------");
	}
	public void listarClientes() {
		System.out.printf("Sucursal: %S / Código: (%s)\n", this.ciudad, this.codigo);
		for(Cliente c: clientes)
			System.out.printf(" - %s, %s(%s)\n",c.getApellido(),c.getNombre(),c.getNif());
	}
	public String getCodigoGlande() {
		return this.banco.getCodigo()+" "+ this.codigo;
	}
	public String getCiudad() {
		return this.ciudad;
	}
	public String getCodigo() {
		return this.codigo;
	}
	
}
