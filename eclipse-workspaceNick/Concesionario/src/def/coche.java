package def;

class coche extends vehiculo{
	


public coche(String matri,int fabri,conductor conductor){
	super(matri,fabri,conductor);

	
}
public int preciotodoriesgo(){
int precio=0;

	if (conductor.getedad()<24)
	precio+=50;
	if(conductor.getpuntoscarnet()<8)
		precio+=100;
	if(conductor.anyodecarnet()==1)
		precio+=400;
	if(conductor.anyodecarnet()==2)
		precio+=550;
	if(conductor.anyodecarnet()==3)
		precio+=750;
	if(conductor.anyodecarnet()>3)
		precio+=250*conductor.anyodecarnet();

	return precio;
}
public int precioterceros() {
	int precio=250;

	if (conductor.getedad()<24)
	precio+=50;
	if(conductor.getpuntoscarnet()<8)
		precio+=150;
	
	return precio;
}
}
