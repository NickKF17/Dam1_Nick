package def;

public class Main {

	public static void main(String[] args) {
		Banco banco=new Banco("Banaco","ES17 0417");
		Banco banco2=new Banco("Banaco","ES17 0417");
		
		Sucursal madrid = new Sucursal(banco,"Calle Kagari", 17,28017,"Madrid","0417");
		Sucursal sevilla = new Sucursal(banco2,"Calle Kagari", 17,28017,"Sevilla","0417");
	
		Clientes cliente1=new Clientes("Kagari","Fuyukawa","02156914K",47262868,madrid);
		Clientes cliente2=new Clientes("Nick","Constante","02394425Q",47262868,madrid);
		Clientes cliente3=new Clientes("Nick","Constante","02394425Q",47262868,sevilla);
		
		Cuentas_Corrientes cuenta1=new Cuentas_Corrientes(cliente1, 747426, madrid, "46425756");
		Cuentas_Corrientes cuenta2=new Cuentas_Corrientes(cliente1,cliente2,10, sevilla, "46425756");
	
		
	

		madrid.listarclientes();
		sevilla.listarclientes();
		
	
cuenta2.mostrarcuentas();
cuenta1.mostrarcuenta();
	
	}

}
