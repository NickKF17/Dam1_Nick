package def;

class moto extends vehiculo{
	
	
	public moto(String matri,int fabri,conductor conductor) {
		super(matri,fabri,conductor);
	}
	public int precioterceros() {
		int precio=250;

		if (conductor.getedad()<24)
		precio+=100;
		if(conductor.getpuntoscarnet()<8)
			precio+=2000;
		
		return precio;
	}
}