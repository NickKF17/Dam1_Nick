
public class Disco {
	private String nombre;
	private int anioPublicaion;
	
	static final int ANIO_ACTUAL=2022;
	
	public Disco(String nombre, int anioPublicaion) {
		super();
		this.nombre = nombre;
		this.anioPublicaion = anioPublicaion;
	}
	
	public Disco() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnioPublicaion() {
		return anioPublicaion;
	}

	public void setAnioPublicaion(int anioPublicaion) {
		this.anioPublicaion = anioPublicaion;
	}


	public int calcularAniosPublicacion() {
		return ANIO_ACTUAL-anioPublicaion;
	}
	
}
