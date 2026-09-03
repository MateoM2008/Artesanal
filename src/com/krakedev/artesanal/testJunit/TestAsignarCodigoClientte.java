package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoClientte {
	@Test
	public void asignarCodigo() {

		Negocio n1 = new Negocio();
		Cliente mario = new Cliente("Mario", "1234567890");
		Cliente andres = new Cliente("Andres", "0987654321");

		n1.asignarCodigoCliente(mario);
		n1.asignarCodigoCliente(andres);

		assertEquals(100,mario.getCodigo());
		assertEquals(101,andres.getCodigo());
	}
}
