package Banco;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String apellidos;
	private String nif;
	private int telefono;
	private Sucursal sucursal;
	private ArrayList<CuentasCorrientes> cuentas= new ArrayList<>();
	
	
	
	public Cliente(String nombre, String apellidos, String nie, int telefono, Sucursal sucubo) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.nif=nie;
		this.telefono=telefono;
		this.sucursal=sucubo;
		sucubo.addCliente(this);
	}
	
	public void addCuenta(CuentasCorrientes cuenta) {
		cuentas.add(cuenta);
		
	}
	
	public void mostrarCuentas() {
		System.out.printf("Las cuentas para el cliente %s, %s (%s) son: \n",this.apellidos,this.nombre, this.nif);
		for(CuentasCorrientes cuenta : cuentas) {
			System.out.printf(" - Código: %s / Saldo: %.2f\n", cuenta.getCodigo(), cuenta.getSaldo());
		}
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellidos;
	}
	public String getNif() {
		return this.nif;
	}
}
