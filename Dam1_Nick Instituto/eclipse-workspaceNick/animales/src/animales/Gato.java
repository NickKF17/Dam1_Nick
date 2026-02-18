package animales;

class Gato extends Animal {
	
 boolean vacuna=false;
	
	public Gato(int anyonaci,String nom, boolean adop,boolean vacuna){
		super(anyonaci,nom);
		this.adoptado=adop;
		this.vacuna=vacuna;
	}
public int getanyonaci() {
	return this.anyonaci;
}
public String getnombre() {
	return this.nombre;
}
public String adoptado(boolean adoptado) {
	this.adoptado=adoptado;
	String estado;
if (adoptado=true)
	estado="Adoptado";
else
	estado="En adopción";

return estado;
}
public String vacuna(boolean vacuna) {
	this.vacuna=vacuna;
	String estado;
if (this.vacuna=true)
	estado="Vacunado";
else
	estado="No vacunado";

return estado;
}
}
