package def;

public class Main {
	public static void main(String[] args) {
	Tareas t1=new Tareas("Aprender Java","Estudiar para el examen","Azul");
	Tareas t2=new Tareas("Stranger Things","Ver la ultima temporada antes de los spoilers","verde");
	Tareas t3=new Tareas("Ir al casino","Todo al rojo","Negro");
/*t1.mostrar();
	t2.mostrar();
	*/
	//Tareas.mostrartodo();
	/*
	t1.completar();
	Tareas.mostrartitulotodo();
	t1.borrartarea();
	System.out.println();
	
	t2.completar();;
	Tareas.mostrartitulocompletadas();;
	*/
	t1.borrartarea();
	t2.borrartarea();
	t3.borrartarea();
	t3.borrartarea();
	Tareas.mostrartodootraforma();
	System.out.println("\n \n \n");
	Tareas.mostrartodo();
	}
}
