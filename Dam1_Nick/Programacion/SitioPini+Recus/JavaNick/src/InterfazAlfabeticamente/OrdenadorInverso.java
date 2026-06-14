package InterfazAlfabeticamente;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenadorInverso implements OrdenadorNombres {
    @Override
    public void ordenar(List<String> nombres) {
        if (nombres != null) {
            // Arrays.sort acepta un Comparator para definir el orden
            Collections.sort(nombres, Collections.reverseOrder());
        }
    }
}