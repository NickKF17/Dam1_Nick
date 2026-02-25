package def;

public class Main {

	public static void main(String[] args) {
 Participante j1 =new Participante("Mazepin","Rusia");
 Participante j2 =new Participante("Vettel","Alemania");
 Participante j3 =new Participante("Nick","España");
 Participante j4=new Participante("Hamilton","Inglaterra");
 
 DeporteIndividual d1=new DeporteIndividual("Snowboard");
 DeporteEquipo  d2 =new DeporteEquipo("Futbol");
 DeporteEquipo d3=new DeporteEquipo("Basket");
 
 Equipo e1=new Equipo("Rusia",d2);
 Equipo e2=new Equipo("España",d3);
 
 e1.anyadeParticipante(j1);
 e1.anyadeParticipante(j2);//Este deberia fallar
 e2.anyadeParticipante(j3);

 d1.resultado(j1,45.4);
 d1.resultado(j2,32.14);
 d1.resultado(j3,49.3);
 d1.resultado(j3,49.0);
 d1.resultado(j4,30.3);
 d1.resultado(j4,41.3);
 
 
 d1.obtenerPodium();
	}

}
