package ordinaria;

import java.util.ArrayList;

public class EJ2_RA3 {

	public static void main(String[] args) {
		String adn="AAAAACCCCCAAGGGGTTTTTTCCC";
		String comprimida="";
		int cont=0;
		boolean sirve=true;
			
			if(sirve==true) {
		for(int i=0;i<adn.length();i++) {
		
			if(adn.charAt(i)=='A') {
				if(cont==0)
					comprimida+=adn.charAt(i);
				
				cont++;
				
				if(i!=adn.length()-1) {
					if(adn.charAt(i+1)!=adn.charAt(i)) {
						if(cont!=1) {
						comprimida+=cont;
						cont=0;
						}
						else
							cont=0;
					}
					if(i==adn.length()-2)
						
						comprimida+=cont+1;	
				}
			}else if(adn.charAt(i)=='C') {
				if(cont==0)
					comprimida+=adn.charAt(i);
				
				cont++;
				
				if(i!=adn.length()-1) {
					if(adn.charAt(i+1)!=adn.charAt(i)) {
						if(cont!=1) {
						comprimida+=cont;
						cont=0;
						}
						else
							cont=0;
					}
					if(i==adn.length()-2)
						
						comprimida+=cont+1;
						
					
				}
			}else if(adn.charAt(i)=='G') {
				if(cont==0)
					comprimida+=adn.charAt(i);
				
				cont++;
				
				if(i!=adn.length()-1) {
					if(adn.charAt(i+1)!=adn.charAt(i)) {
						if(cont!=1) {
						comprimida+=cont;
						cont=0;
						}
						else
							cont=0;
					}
					if(i==adn.length()-2)
						
						comprimida+=cont+1;
						
					
				}
			}else if(adn.charAt(i)=='T') {
				if(cont==0)
					comprimida+=adn.charAt(i);
				
				cont++;
				
				if(i!=adn.length()-1) {
					if(adn.charAt(i+1)!=adn.charAt(i)) {
						if(cont!=1) {
						comprimida+=cont;
						cont=0;
						}
						else
							cont=0;
					}
					if(i==adn.length()-2)
						
						comprimida+=cont+1;
						
					
				}
			}
			
		}
		System.out.println(comprimida);
		}else
			System.out.println(adn+" no es una cadena de ADN válida");
		
	}

}
