package InterfacesPersona;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
	LocalDate f1 =LocalDate.of(2007, 07, 07);
	LocalDate f2 =LocalDate.of(2009, 4, 17);
	LocalDate f3 =LocalDate.of(2005, 02, 04);

Persona p1=new Persona("Nick","Constante",f1);
Persona p2=new Persona("Kagari","Fuyukawa",f2);
Persona p3=new Persona("Andrés", "Ortega Cebria",f3);

//p1.consultaJubilacion();
//p2.consultaJubilacion();
p1.HayBoda(p3);
p1.darDeBaja();
p1.darDeBaja();
p3.HuboAccidente();
p1.HayBoda(p2);
	}
	}
