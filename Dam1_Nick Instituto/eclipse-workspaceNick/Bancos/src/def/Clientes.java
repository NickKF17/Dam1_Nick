package def;

import java.util.ArrayList;

public class Clientes {
private String nombre;
private String apellidos;
private String nif;
private int telefono;
private Sucursal sucursal;
public Clientes(String nombre, String apellidos, String nif, int telefono,Sucursal sucursal) {
	this.nombre=nombre;
	this.apellidos=apellidos;
	this.nif=nif;
	this.telefono=telefono;
	this.sucursal=sucursal;
	this.sucursal.addCliente(this);
}
private  ArrayList<Cuentas_Corrientes> cuentas= new ArrayList<>();
public String getApellido() {
	return apellidos;
}

public String getNombre() {
	return nombre;
}

public String getNif() {
	return nif;
}
public void addCuenta(Cuentas_Corrientes cuenta) {
	cuentas.add(cuenta);
}


}
