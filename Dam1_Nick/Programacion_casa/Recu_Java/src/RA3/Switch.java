package RA3;

public class Switch {
public static void main(String[] args) {
	System.out.println(calcularnota(2));
}
public static String calcularnota(int nota) {
	String comentario="";
	
	switch(nota) {
	
	case 1,2,3,4:
		comentario+="Insuficiente";
	break;
	case 5:
		comentario+="Suficiente";
		break;
	case 6:
		comentario+="Bien";
		break;
	case 7,8:
		comentario+="Notable";
	break;
	case 9,10:
		comentario+="Sobresaliente";
	break;
		default:
			comentario+="Ingrese un numero entre 0 y 10";
			break;
	}
	
	
	return comentario;
	
}
}
