package com.krakedev.artesanal.testJunit;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquinaJUnit {
	@Test
	public void testRecuperarMaquinaExiste() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    Maquina maquina = new Maquina(
	            "M-25",
	            "Pilsener",
	            "Cerveza artesanal",
	            0.05
	    );

	    negocio.getMaquinas().add(maquina);

	    Maquina resultado = negocio.recuperarMaquina("M-25");

	    assertNotNull(resultado);
	    assertEquals("M-25", resultado.getCodigo());
	    assertEquals("Pilsener", resultado.getNombreCerveza());
	}

	@Test
	public void testRecuperarMaquinaNoExiste() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    Maquina resultado = negocio.recuperarMaquina("M-99");

	    assertNull(resultado);
	}
}
