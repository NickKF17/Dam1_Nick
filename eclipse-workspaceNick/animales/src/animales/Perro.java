package animales;

class Perro extends Animal {
	private boolean vacuna=false;
	public Perro(int anyonaci,String nom,boolean adop){
		super(anyonaci,nom);
		
	}
	public int getanyonaci() {
		return this.anyonaci;
	}
}
