package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejoradoJUnit {
	@Test
	public void testClienteActualizado() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    negocio.registrarCliente("Juan", "1723456789");
	    negocio.agregarMaquina("Pilsener", "Cerveza artesanal", 0.05);
	    negocio.cargarMaquinas();

	    Cliente cliente = negocio.buscarClientePorCedula("1723456789");
	    Maquina maquina = negocio.getMaquinas().get(0);

	    negocio.consumirCerveza(
	            cliente.getCodigo(),
	            maquina.getCodigo(),
	            100
	    );

	    assertEquals(5.0, cliente.getTotalConsumir(), 0.001);
	}

	@Test
	public void testMaquinaAfectada() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    negocio.registrarCliente("Juan", "1723456789");
	    negocio.agregarMaquina("Pilsener", "Cerveza artesanal", 0.05);
	    negocio.cargarMaquinas();

	    Cliente cliente = negocio.buscarClientePorCedula("1723456789");
	    Maquina maquina = negocio.getMaquinas().get(0);

	    double cantidadInicial = maquina.getCantidadActual();

	    negocio.consumirCerveza(
	            cliente.getCodigo(),
	            maquina.getCodigo(),
	            100
	    );

	    assertEquals(
	            cantidadInicial - 100,
	            maquina.getCantidadActual(),
	            0.001
	    );
	}

	@Test
	public void testValoresCorrectos() {
	    NegocioMejorado negocio = new NegocioMejorado();

	    negocio.registrarCliente("Juan", "1723456789");
	    negocio.agregarMaquina("Pilsener", "Cerveza artesanal", 0.05);
	    negocio.cargarMaquinas();

	    Cliente cliente = negocio.buscarClientePorCedula("1723456789");
	    Maquina maquina = negocio.getMaquinas().get(0);

	    assertNotNull(cliente);
	    assertNotNull(maquina);

	    negocio.consumirCerveza(
	            cliente.getCodigo(),
	            maquina.getCodigo(),
	            200
	    );

	    assertEquals(10.0, cliente.getTotalConsumir(), 0.001);
	    assertEquals(9600.0, maquina.getCantidadActual(), 0.001);
	}
}
