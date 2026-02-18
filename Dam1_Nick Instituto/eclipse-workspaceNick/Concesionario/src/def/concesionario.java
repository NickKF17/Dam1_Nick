package def;

public class concesionario {
	public static void main(String[] args) {
		String terceros="terceros";
		String todoriesgo="todoriesgo";
	conductor c1=new conductor(385825253,2000,2000,12);
	
	coche coche1=new coche("31g4",2020,c1);
	moto moto1=new moto("der666",2017,c1);
	
	System.out.println(coche1.precioterceros());
	System.out.println(coche1.preciotodoriesgo());
	System.out.println(moto1.precioterceros());
	
	
	}

}
