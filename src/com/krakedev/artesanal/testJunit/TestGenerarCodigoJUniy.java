package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigoJUniy {
	@Test
	public void testGenerarCodigo() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    String codigo = negocio.generarCodigo();

	    assertNotNull(codigo);
	    assertTrue(codigo.matches("M-(100|[1-9][0-9]?)"));
	}
}
