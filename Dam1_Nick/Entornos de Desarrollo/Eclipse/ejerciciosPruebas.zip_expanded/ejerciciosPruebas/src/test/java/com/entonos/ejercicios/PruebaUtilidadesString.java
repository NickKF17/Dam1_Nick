package com.entonos.ejercicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PruebaUtilidadesString {

	String prueba;
	String palabra;
	
	@BeforeEach
	public void setUp() {
		prueba = null;
		palabra = null;
	}
	
	@Test
	public void compareStringsSonIguales() {
		prueba = "Hola";
		palabra = "Hola";
		
		String resultado = UtilidadesString.compareStrings(prueba, palabra);
		
		assertEquals("The strings are equal.",resultado,"Falla el resultado esperado de igualdad.");
	}
	
	@Test
	public void compareStringsNoSonIguales() {
		prueba = "Hola";
		palabra = "Adios";
		
		String resultado = UtilidadesString.compareStrings(prueba, palabra);
		
		assertEquals("The strings are not equal.",resultado);
	}
	
	@Test
	public void compareStringsNullParametro() {
		palabra = "Adios";
		
		assertThrows(NullPointerException.class, 
				() -> UtilidadesString.compareStrings(prueba, palabra));
	}
}
