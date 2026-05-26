package RA6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class hashsets {
public static void main(String[] args) {
	ArrayList<String> arrayfrutas= new ArrayList<>(List.of("manzana", "pera", "manzana", "uva", "pera", "kiwi"));
	
	HashSet<String> frutasHash=new HashSet<>(arrayfrutas);
	
	for(String fruta :frutasHash)
		System.out.println(fruta);
}
}
