package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestMaquinaMejoradaJunit {
	@Test
	public void testAgregarMaquina() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    boolean resultado = negocio.agregarMaquina(
	            "Pilsener",
	            "Cerveza artesanal",
	            0.05
	    );

	    assertTrue(resultado);
	    assertEquals(1, negocio.getMaquinas().size());

	    Maquina maquina = negocio.getMaquinas().get(0);

	    assertNotNull(maquina);
	    assertEquals("Pilsener", maquina.getNombreCerveza());
	    assertEquals("Cerveza artesanal", maquina.getDescripcion());
	    assertEquals(0.05, maquina.getPrecioPorMl(), 0.001);
	}
}
