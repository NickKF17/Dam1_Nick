package def;



public class Main {

	public static void main(String[] args) {
	
		Programador p1=new Programador("Nick Constante","",5,true,true);
		Programador p2=new Programador("Lionel Messi","",5,false,true);
		Programador p3=new Programador("Cristiano Ronaldo","",5,true,false);
		Programador p4=new Programador("Neymar JR","",5,false,false);
		
		Jefes_Proyect j1=new Jefes_Proyect("YO", "", 1000);
		Jefes_Proyect j2=new Jefes_Proyect("TU", "", 30);
		
		Proyecto pro1=new Proyecto("",j1,"Hacer aplicacion Java para Enaire","2");
		Proyecto pro2=new Proyecto("",j1,"Hacer aplicacion movil para Clinica","");
		
		
		
		p1.mostrar();
		System.out.println();
		p2.mostrar();
		System.out.println();
		j1.mostrar();
		System.out.println();
		pro1.ListarProyecto();
		System.out.println();
		pro1.cambiarjefe(j2);
		System.out.println();
		pro1.ListarProyecto();
		System.out.println();
		pro2.asignarmaximo("4");
		System.out.println();
		pro1.asignarProgramador(p1);
		pro1.ListarProyecto();
	System.out.println();
	}

}
