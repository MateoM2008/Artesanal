package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestTotalConsumirJUnit {
	@Test
	public void testConsultarValorVendido() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    negocio.registrarCliente("Juan", "1723456789");
	    negocio.registrarCliente("Pedro", "1712345678");

	    Cliente cliente1 = negocio.buscarClientePorCedula("1723456789");
	    Cliente cliente2 = negocio.buscarClientePorCedula("1712345678");

	    cliente1.setTotalConsumir(5.0);
	    cliente2.setTotalConsumir(10.0);

	    double total = negocio.consultarValorVendido();

	    assertEquals(15.0, total, 0.001);
	}
}
