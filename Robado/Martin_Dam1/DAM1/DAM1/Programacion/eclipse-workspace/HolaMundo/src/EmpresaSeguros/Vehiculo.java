package EmpresaSeguros;
import java.time.LocalDate;
abstract class Vehiculo {
	protected String matricula;
	protected int yFabricación;
	protected conductor conductor;
	
	public Vehiculo(String mat, int yFab, conductor c) {
		this.matricula= mat;
		this.yFabricación=yFab;
		this.conductor= c;
		
	}
	
	public int antiguedad() {
		LocalDate fechaActual= LocalDate.now();
		int actualYear = fechaActual.getYear();
		int Antiguedad = actualYear-this.yFabricación;
		return Antiguedad;
	}
	
	public void stats() {
		int antiguedad= antiguedad();
		System.out.printf("-------------------\nINFO SOBRE VEHÍCULO.\nAntigüedad: %d años\n-------------------\n",antiguedad);
		
	}
	
}
class Moto extends Vehiculo{
	public Moto(String mat, int yFab, conductor c){
		super(mat, yFab, c);
	}
	public void calcSegaTerc() {
		int edadCond=this.conductor.edad();
		int ptsCarnet=this.conductor.getPtsCarnet();
		int calculo =200;
		if(ptsCarnet<8)
			calculo+=200;
		if(edadCond<24)
			calculo+=100;
		System.out.printf("El total del seguro a terceros es de %d €",calculo);
		System.out.println();
	}
}

class Coche extends Vehiculo{
	public Coche(String mat, int yFab, conductor c) {
		super(mat, yFab, c);
	}
	public void calcSegTodRiesg() {
		int edadCond=this.conductor.edad();
		int ptsCarnet=this.conductor.getPtsCarnet();
		int yCarntet=this.conductor.yCarnet();
		int antiguedad= antiguedad()+1;
		int calculo =0;
		if(antiguedad==1) {
			calculo+=400;
		}
		else if(antiguedad==2) {
			calculo+=550;
		}
		else if(antiguedad==3) {
			calculo+=750;
		}
		else if(antiguedad>=4) {
			calculo+=250*antiguedad;
		}
		if(ptsCarnet<8)
			calculo+=100;
		if(edadCond<24)
			calculo+=50;
		System.out.printf("El total del seguro a todo riesgo será de %d €",calculo);
		System.out.println();
	}
	public void calcSegaTerc() {
		int edadCond=this.conductor.edad();
		int ptsCarnet=this.conductor.getPtsCarnet();
		int calculo =250;
		if(ptsCarnet<8)
			calculo+=100;
		if(edadCond<24)
			calculo+=50;
		System.out.printf("El total del seguro de terceros es de %d €",calculo);
		System.out.println();
	}
}
