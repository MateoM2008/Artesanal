package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumoCliente {
	@Test
	public void provarConsumo() {
		Maquina maquinaA=new Maquina("001","pilcener","rubia",0.002,8000);
		Negocio barDeMou=new Negocio("Bar de mou",maquinaA);
		Cliente andres=new Cliente("Andres","03216549877");
		barDeMou.cargarMaquina();
		barDeMou.consumirCerveza(andres, 100);
		
		assertEquals(7700,maquinaA.getCantidadActual(),0.0001);
		assertEquals(0.2,andres.getTotalConsumir(),0.0001);
		
		barDeMou.consumirCerveza(andres, 200);
		
		assertEquals(7500,maquinaA.getCantidadActual(),0.0001);
		assertEquals(0.6,andres.getTotalConsumir(),0.0001);
	}
	
}
