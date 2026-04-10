package pokemon;

public class Pokemon {

	private int codigo = 0;
	private String nombre;
	private String[] tipos = new String[2];
	private int vida = 0;
	private Pokemon evolucion = null;

	public Pokemon(String nom, int cod, String tip1) {
		this.nombre = nom;
		this.codigo = cod;
		this.tipos[0] = tip1;
		this.vida = (int) (Math.random() * 51) + 50;
		// this.evolucion = ev;

	}

	public Pokemon(String nom, int cod, String tip1, String tip2) {
		this.nombre = nom;
		this.codigo = cod;
		this.tipos[0] = tip1;
		this.tipos[1] = tip2;
		this.vida = (int) (Math.random() * 51) + 50;
		// this.evolucion = ev;

	}

	public void mostrar() {
		System.out.println("--------------");
		System.out.println(this.codigo + " - " + this.nombre);
		if (this.tipos[1] == null)
			System.out.println("Tipo: " + this.tipos[0]);
		else
			System.out.println("Tipos: " + this.tipos[0] + ", " + this.tipos[1]);
		if (this.evolucion != null)
			System.out.println("Evoluciona en: " + this.evolucion.nombre);
		System.out.println("PV: " + this.vida);
		System.out.println("--------------");
	}

	public void setEvolucion(Pokemon p) {
		this.evolucion = p;
	}

	public Pokemon evoluciona() {
		Pokemon pokemon = this;
		if (this.evolucion == null)
			System.out.println("Este pokemon no puede evolucionar");
		else
			pokemon = this.evolucion;
		return pokemon;

	}

	public void combateContra(Pokemon atacado) {
		System.out.println(this.nombre+" combate contra "+ atacado.nombre);
		if (this.vida <= 0 || atacado.vida<=0)
			System.out.println("El pokemon no puede comabtir, está muerto!");
		else {
			while (this.vida > 0 &&atacado.vida > 0) {
				int ataque = (int) (Math.random() * 26) + 25;
				atacado.vida -= ataque;
				if (atacado.vida > 0) {
					ataque = (int) (Math.random() * 26) + 25;
					this.vida -= ataque;
					if (this.vida > 0) {
						System.out.println("Ningún pokemon ha vencido el combate");
						
					}

					else
						{
						System.out.println(this.nombre + " ha sido derrotado");
						this.vida=0;
						}
				} else {
					System.out.println(atacado.nombre + " ha sudo derrotado");
					atacado.vida=0;
				}
				this.mostrar();
				atacado.mostrar();
			}
		}
		
	}
}
