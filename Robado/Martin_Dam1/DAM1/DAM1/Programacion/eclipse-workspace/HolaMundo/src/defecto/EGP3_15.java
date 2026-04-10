package defecto;

public class EGP3_15 {

	public static void main(String[] args) {
		String fecha = "22/10/2024";
		boolean fechacorr = true;
		if(fecha.length()!=10)
			fechacorr = false;
		else if (fecha.charAt(2)!= '/' || fecha.charAt(5)!='/')
			fechacorr = false;
		else {
			int dia = Integer.parseInt(fecha.substring(0,2));
			int mes = Integer.parseInt(fecha.substring(3,5));
			if(dia<1 || dia >31)
				fechacorr = false;
			else if (mes<1||mes>12)
				fechacorr = false;
		}
		if (fechacorr == true)
			System.out.println("La fecha " + fecha + " es correcta");
		else 
			System.out.println("La fecha " + fecha + " no es correcta");

	}

}
