package def;

import java.time.LocalDate;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		LocalDate hoy=LocalDate.now();
		CentroMedico c1=new CentroMedico("CM de la paz","CM-345");
		CentroMedico c2=new CentroMedico("Infanta Sofia", "CM-17");
		CentroMedico c3=new CentroMedico("12 de Octubre", "CM-04");
	Paciente p1=new Paciente("Nick","Constante","4365431R",4656576,c1) ;
	Paciente p2=new Paciente("Nick","Constante","4365431R",4656576,c1) ;
	
	Medico m1=new Medico("Kagari","Fuyukawa","1704KF",555555,c1);
	Medico m2=new Medico("Kagari","Fuyukawa","1704KF",555555,c1);
	
	Consultas con1=new Consultas(p1,m1,hoy,"","",c1);
	Consultas con2=new Consultas(p2,m1,hoy,"","",c1);
	Consultas con3=new Consultas(p2,m1,hoy,"","",c1);
	Consultas con4=new Consultas(p2,m1,hoy,"","",c1);

	
	
	

	
	
	
	m1.listarConsultaspaci(p2);
	
	}

}
