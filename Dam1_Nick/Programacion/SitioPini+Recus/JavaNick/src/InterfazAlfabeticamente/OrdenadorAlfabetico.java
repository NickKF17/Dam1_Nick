package InterfazAlfabeticamente;

import java.util.Collections;
import java.util.List;

public class OrdenadorAlfabetico implements OrdenadorNombres {
    
    @Override
    public void ordenar(List<String> nombres) {
        if (nombres == null || nombres.isEmpty()) {
            return;
        }
        // Ordenación natural (alfabética)
        Collections.sort(nombres);
    }
}