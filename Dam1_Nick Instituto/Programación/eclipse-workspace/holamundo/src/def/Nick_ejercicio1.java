package def;

import java.util.Scanner;
import java.io.Closeable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class Nick_ejercicio1{

	public static void main(String[] args) {

int contador1=0;
String numero1;
int azar;
	
		for (int k =0; k<4;k++){
			for (int j =0; j<5;j++) {
			for (int i =0; i<5;i++) {
			
		azar =(int)(Math.random()*10);
		numero1 =azar+"";
		System.out.print(numero1);
			}
			if (j!=4)
			System.out.print("-");
			}
			System.out.println("");
	}

		
	}}