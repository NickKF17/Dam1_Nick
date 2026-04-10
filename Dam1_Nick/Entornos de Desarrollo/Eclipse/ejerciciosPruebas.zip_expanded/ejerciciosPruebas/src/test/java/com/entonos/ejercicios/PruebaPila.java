package com.entonos.ejercicios;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PruebaPila {
	
	Pila p;
	
	@BeforeEach
	public void setUp() {
		p = new Pila();
	}
	
	@Test
	public void pruebaCreacionPila() {	
		assertAll(
				() -> assertNotNull(p),
				() -> assertTrue(p.isEmpty())
				);
	}
	@Test
	public void pruebaPushPilaCorrecto() {
		p.push(10);
		
		assertAll(
				() -> assertNotNull(p),
				() -> assertFalse(p.isEmpty())
				);
	}
	
	@Test
	public void pruebaPushPilaMenorTres() {
		p.push(2);
		
		assertAll(
				() -> assertNotNull(p),
				() -> assertTrue(p.isEmpty())
				);
	}
}
