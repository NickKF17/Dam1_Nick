package parte2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FechasyHoras {

	public static void main(String[] args) {
		LocalDate hoy = LocalDate.now();
		System.out.println(hoy);
		LocalTime ahora = LocalTime.now();
		System.out.println(ahora);

		/*
		 * LocalDate cumple = LocalDate.of(1968, 10, 8); System.out.println(cumple);
		 * LocalTime citaMedica = LocalTime.of(10, 0); System.out.println(citaMedica);
		 */

		/*
		 * LocalTime dentrodeUnaHora = ahora.plusHours(1);
		 * System.err.println("Dentro de una hora; " + dentrodeUnaHora);
		 * System.out.println(ahora); ahora.plusMinutes(5); ahora.plusSeconds(45);
		 * ahora.minusHours(5); ahora.minusMinutes(55); ahora.minusSeconds(44);
		 * LocalDate dentrodeUnAnyo = hoy.plusYears(1);
		 * System.out.println(dentrodeUnAnyo);
		 */
		LocalDateTime fechayhora = LocalDateTime.now();
		System.out.println(fechayhora);
		DateTimeFormatter formato1=DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy - HH:mm");
		DateTimeFormatter formato2=DateTimeFormatter.ofPattern("dd-MM-yy");
		
		String fechaConFormato = fechayhora.format(formato1);
		String fechaConFormato2 = hoy.format(formato2);
		
		System.out.println(fechaConFormato);
		System.out.println(fechaConFormato2);
		
		
		
		//para pasar de un String a una fecha
		String fechaTxt="08/10/1968";
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate cumple = LocalDate.parse(fechaTxt, formato);
		System.out.println(cumple);
		if(cumple.isAfter(hoy)) {
			System.out.println(cumple+" es posterior a "+ hoy);
		}
		else
			System.out.println(cumple+" no es posterior a " +hoy);
		if(cumple.isAfter(hoy))
			System.out.println(cumple+" es anterior a "+hoy);
		else
			System.out.println(cumple+ " no es anterior a "+ hoy);
		System.out.println(hoy.isEqual(cumple));
	}

}
