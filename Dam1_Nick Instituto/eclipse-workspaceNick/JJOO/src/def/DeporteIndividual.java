package def;
import java.util.*;
class DeporteIndividual extends Deporte {
private HashMap<Participante,Double> listaParticipantes=new HashMap <>();
	public DeporteIndividual(String nombre) {
		super(nombre);
	}
	public void resultado(Participante p,Double marca) {
		if (listaParticipantes.containsKey(p)) {
			if(listaParticipantes.get(p)<marca)
				this.listaParticipantes.put(p, marca);
	}
		else 
			this.listaParticipantes.put(p, marca);
	}
public void obtenerPodium() {
	HashMap<Participante,Double> copia=new HashMap<>(listaParticipantes);
	obtenerMedalla("ORO", copia);
	obtenerMedalla("PLATA", copia);
	obtenerMedalla("BRONCE", copia);

}
public void obtenerMedalla(String medalla,HashMap<Participante,Double> copia) {
	System.out.println(medalla);
	if(copia.size()!=0) {
		Participante p=obtenerMayor(copia);
		double mayor =copia.get(p);
		System.out.println(p.getNombre()+" con "+copia.get(p)+" puntos\n");
		copia.remove(p);
		Iterator <Map.Entry<Participante, Double>> iterador=copia.entrySet().iterator();
		
				while(iterador.hasNext()){
					Map.Entry<Participante, Double> elemento =iterador.next();
		if(elemento.getValue()==mayor) {
			System.out.println(elemento.getKey().getNombre()+" con "+copia.get(p)+" puntos\n");
			copia.remove(p);
		}
		}
	}else
		System.out.println("No hay mas participantes en la competicion");
}
public Participante obtenerMayor(HashMap<Participante,Double>lista) {
	double mayor=-1;
			Participante pMayor=null;
			for(Participante p: lista)
				if (p>mayor)
			  
return pMayor;
}
}
