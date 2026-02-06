package def;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Cita {
private LocalDate fechaCita;
private Medico medico;

public Cita(Medico medico) {
	this.medico=medico;
	this.fechaCita=LocalDate.now().plusWeeks(1);
}
public String getFichaCita() {
	DateTimeFormatter formato =DateTimeFormatter.ofPattern("dd/MM/yyyy");
	return fechaCita.format(formato);
	
}
public Medico getMedico() {
	return this.medico;
}

}
