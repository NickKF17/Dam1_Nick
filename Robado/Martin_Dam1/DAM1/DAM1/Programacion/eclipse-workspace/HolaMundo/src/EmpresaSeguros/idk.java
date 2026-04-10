package EmpresaSeguros;

public class idk {

	public static void main(String[] args) {
		conductor Juan= new conductor("12345678P", 2006, 2017,85);
		conductor Pedro= new conductor("12345678P", 1990, 2024,25);
		conductor Laura= new conductor("12345678P", 2005, 2020,30);
		conductor Diana= new conductor("12345678P", 2005, 2019,7);
		
		
		Moto susuki1= new Moto("NFSMW", 2005, Juan);
		Coche BMWm3= new Coche("NFSMW05",2023, Laura);
		Moto daytona1= new Moto("ABS123", 2019, Juan);
		Coche Panda= new Coche("NFSC",2025, Diana);
		
		Juan.stats();
		Pedro.stats();
		Laura.stats();
		Diana.stats();
		
		
		susuki1.stats();
		BMWm3.stats();
		daytona1.stats();
		Panda.stats();
		
		BMWm3.calcSegTodRiesg();
		Panda.calcSegTodRiesg();
		daytona1.calcSegaTerc();
		susuki1.calcSegaTerc();
		BMWm3.calcSegaTerc();
		Panda.calcSegaTerc();
		
	}

}
