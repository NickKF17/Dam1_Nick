package animales;

public class Clientes {
private String nombre;
private String apellidos;
private int edad;
private int tlf;
private String animalint;

private Gato gatocont[]= new Gato[3];
private Perro perrocont[]=new Perro[2];
private Tortuga tortucont[]=new Tortuga[1];
public Clientes(String nom,String ape,int edad,int tlf,String interesado) {
this.nombre=nom;	
this.apellidos=ape;
this.edad=edad;
this.tlf=tlf;
this.animalint=interesado;
}
public void adoptagato(Gato gato) {
	for (int i=0;i<=2;i++)
if(this.gatocont[i]==null)
	this.gatocont[i]=gato;
}

public void adoptaperro(Perro perro) {
	for (int i=0;i<=1;i++)
if(this.perrocont[i]==null)
	this.perrocont[i]=perro;
}
public void adoptatortuga(Tortuga tortuga) {
	for (int i=0;i<1;i++)
if(this.tortucont[i]==null)
	this.tortucont[i]=tortuga;
}
public void numanimales(){

	if (this.gatocont.length>2)
		System.out.println("No puedes adoptar mas de 3 gatos");
	if (this.perrocont.length>2)
		System.out.println("No puedes adoptar mas de 2 perros");
	if (this.tortucont.length>2)
		System.out.println("No puedes adoptar mas de 1 tortuga");
}
}
