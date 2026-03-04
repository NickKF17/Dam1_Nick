package def;

public class Cuentas_Corrientes {
private Clientes titulares; /*(1 o 2)*/
private Clientes titulares2; /*(1 o 2)*/
private float saldo;
private Sucursal sucursal;
private String codigo; /*9(12)*/
public Cuentas_Corrientes(Clientes titulares, float saldo,Sucursal sucursal, String codigo){
	this.titulares=titulares;
	this.saldo=saldo;
	this.sucursal=sucursal;
	this.codigo=codigo;
	titulares.addCuenta(this);
}
public Cuentas_Corrientes(Clientes titulares, Clientes titulares2, float saldo,Sucursal sucursal, String codigo){
	this.titulares=titulares;
	this.titulares2=titulares2;
	this.saldo=saldo;
	this.sucursal=sucursal;
	this.codigo=codigo;
	titulares.addCuenta(this);
	titulares2.addCuenta(this);
}

public void mostrarcuenta() {
	System.out.println("Titular/es: "+ titulares.getNombre() +" "+ titulares.getApellido()+ " Saldo: "+ saldo+"€"+" Sucursal: " +sucursal.getciudad()+ " Codigo: "+codigo);
}
public void mostrarcuentas() {

	System.out.println("Titular/es: "+ titulares.getNombre()+ " " + titulares.getApellido() + " , "+titulares2.getNombre() +" "+ titulares2.getApellido()+ " Saldo: "+ saldo+"€"+" Sucursal: " +sucursal.getciudad()+ " Codigo: "+codigo);
}

}
