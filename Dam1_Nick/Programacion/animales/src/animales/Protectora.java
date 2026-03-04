package animales;

public class Protectora {
	private Gato gatos[]=new Gato[1];
	private Perro perros[]=new Perro[1];
	private Tortuga tortugas[]=new Tortuga[1];
	public Protectora(Gato gatos[],Perro perros[],Tortuga tortugas[]) {
	this.gatos=gatos;
	this.perros=perros;
	this.tortugas=tortugas;
	
	}
public void mostraradoptados() {
	
}
public void mostrarnoadoptados() {
	for(int i=0;i<gatos.length;i++) {
		System.out.println("Gato " +i+":");
		if(gatos[i].adoptado==true)
	System.out.print(gatos[i].adoptado(true)+" --- ");
		else{
		System.out.print(gatos[i].adoptado(false)+" --- ");
		}
		if(gatos[i].vacuna==true)
		System.out.println(gatos[i].vacuna(true));
		else
			System.out.println(gatos[i].vacuna(false));
		
		System.out.println("Año de nacimiento: "+ gatos[i].getanyonaci()+" --- "+gatos[i].getnombre());
	}
	
	}
}
