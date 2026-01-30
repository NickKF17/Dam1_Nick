package def;

import java.time.LocalDate;

public class conductor {
private int nif;
private int anyonacimiento;
private int anyocarnet;
private int puntoscarnet;

public conductor(int nif,int anyonaci,int anyocarnet,int puntoscarnet) {
	this.nif=nif;
	this.anyonacimiento=anyonaci;
	this.anyocarnet=anyocarnet;
	this.puntoscarnet=puntoscarnet;
	
	
}
public int getedad(){

	LocalDate hoy = LocalDate.now();
int anyoactu=hoy.getYear();
int edad=anyoactu-this.anyonacimiento;
return edad;
	
	}
public int anyodecarnet(){
	LocalDate hoy = LocalDate.now();
	int anyoactu=hoy.getYear();
	int carnet=anyoactu-this.anyocarnet;
	return carnet;
}
public int getpuntoscarnet() {
	return this.puntoscarnet;
}
}
