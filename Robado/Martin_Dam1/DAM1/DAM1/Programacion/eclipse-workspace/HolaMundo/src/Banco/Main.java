package Banco;

public class Main {
	public static void main(String[] args) {
		Banco banco1= new Banco("Créditos informáticos", "ES68 1234");
		Sucursal madrid1 = new Sucursal(banco1, "Calle de la percha foja", 10,28032, "Madrid",  "0078");
		Sucursal sevilla1= new Sucursal(banco1, "Calle de la espada destructora de mundos", 6, 38575, "Sevilla", "9596");
		Cliente c1= new Cliente("Juan Pablo", "Muñoz Giménez", "123456789Z", 604885599, madrid1);
		Cliente c2= new Cliente("Pablo Emilio","Escobar Gavidia", "123458679A", 606885723, sevilla1);
		Cliente c3 = new Cliente("Pepe","Domingo Castaño","123456666B",606456895, madrid1);
		CuentasCorrientes cuenta1 = new CuentasCorrientes(c1, 100, madrid1, "123456789123");
		CuentasCorrientes cuenta2= new CuentasCorrientes(c2, 1000000000, sevilla1, "987654321124");
		CuentasCorrientes cuenta3= new CuentasCorrientes(c2, 1000000000, sevilla1, "987654321125");
		CuentasCorrientes cuenta4= new CuentasCorrientes(c2, 1000000000, sevilla1, "987654321126");
		CuentasCorrientes cuenta5= new CuentasCorrientes(c2, c2, 1000000000, sevilla1, "987654321123");
		CuentasCorrientes cuenta6= new CuentasCorrientes(c2, 1000000000, sevilla1, "987654321127");
		CuentasCorrientes cuenta7= new CuentasCorrientes(c2, 1000000000, sevilla1, "987654321128");
		
		banco1.listarSucursales();
		banco1.listarSucursalesSimp();
		
		System.out.println("\n\n");
		madrid1.listarClientes();
		
		c2.mostrarCuentas();
		
		
		cuenta1.mostrarIban();
	}
}
