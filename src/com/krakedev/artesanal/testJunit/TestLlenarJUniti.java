package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUniti {

	@Test
	public void testLlenarMaquina() {
		Maquina rubia = new Maquina("0001","pilcener", "cerveza", 0.02, 8000);
		rubia.llenarMaquina();
		assertEquals(7900, rubia.getCantidadActual(), 0.0001);
	}
}
