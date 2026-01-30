package def;

abstract class vehiculo {
protected String matricula;
protected int anyofabricacion;
protected conductor conductor;

public vehiculo(String matri, int anyofabri,conductor conductor){
	this.matricula=matri;
	this.anyofabricacion=anyofabri;
	this.conductor=conductor;
}
abstract class mostrar {
	protected String contrato;
	public mostrar(String contrato){
		this.contrato=contrato;
		
		contrato="terceros";
			
	}
	
}
}
