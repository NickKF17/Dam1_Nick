package RA8_Ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class EXEJ1 {
	static String fichero="votos.dat";
	static String [] partidos= {"PA","PB","PC","PD"};
	public static void main(String[] args) {
	
inicializarFichero();
	anyadirVotos("PA",10);
	anyadirVotos("PB",20);
	anyadirVotos("PC",25);
	anyadirVotos("PD",30);
	verResultados(1700);
			}
	//Funcion pedida en el examen que muestra el resultado de las votaciones hasta el momento y el % que se han realizado del total, que lo decides tu
	public static void verResultados(int censo) {
		int [] votos=leerfichero();
		int suma =0;
		for(int i=0;i<4;i++)
			suma+=votos[i];
		double escrutinio= (double) suma/censo*100;
		System.out.printf("Resultado con un %.2f%% de escrutinio:\n",escrutinio);
	}
	
	public static void anyadirVotos(String partido,int voto) {
		int[] votos=leerfichero();
		// Encontrado funciona como un boolean , pero tiene una funcion añadida en este caso, ya que guarda la posicion del partido que quieres añadir votos
		int encontrado=-1;
		for(int i=0;i<4 && encontrado ==-1;i++) {
			if(partido.equals(partidos[i])) {
				encontrado=i;
				if(encontrado==-1)
					System.out.println("Ese partido no se presenta a elecciones");
				else{
					votos[encontrado]+=voto;
					grabarFichero(votos);
					System.out.printf("Nuevos votos para el partido %s: %d\n",partidos[encontrado],voto);
					System.out.println("Votos hasta el momento");
					verVotos(votos);
				}
			}
		}

	}
	
	// Funcion que graba los nuevos votos en el .dat
	public static void grabarFichero(int [] votos) {
		try (DataOutputStream dos =new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){
			for(int i=0;i<4;i++) {
				dos.writeInt(votos[i]);
			}
		}catch(Exception e){
			System.out.println("Error al crear el fichero");

		}
	}
	// Funcion que muestra por pantalla los votos actuales
	public static void verVotos(int[] votos) {
		for(int i=0;i<4;i++) {
			System.out.printf("Partido %s: %d votos\n",partidos[i],votos[i]);
		}
	}
	
	//funcion que te guarda un array con los votos de cada partido
	public static int[] leerfichero() {
		int [] votos=new int [4];
		try (DataInputStream dis =new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			for(int i=0;i<4;i++)
			votos[i]=dis.readInt();
		}catch(Exception e){
			System.out.println("Error al leer el fichero");
		}
		return votos;
	}
	//Lo inicializas para ver si existe o no
	public static void inicializarFichero() {
		boolean noexiste=false;
try (DataInputStream dis =new DataInputStream(new BufferedInputStream(new FileInputStream(fichero)))){
			System.out.println("El fichero ya existe");
		}catch(Exception e){
			System.out.println("El fichero no existe");
			noexiste=true;
		}
//Crea el fichero si no existe y le mete 4 ceros
if(noexiste==true) 
	try (DataOutputStream dos =new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fichero)))){
		for(int i=0;i<4;i++) {
			dos.writeInt(0);
		}
	}catch(Exception e){
		System.out.println("Error al crear el fichero");

	}
	}
	
		}


