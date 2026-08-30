package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class testRecargar {

	public static void main(String[] args) {
		Maquina rubia = new Maquina("0001","pilcener", "cerveza fria", 0.02, 8000);
		System.out.println("estado inicial");
		rubia.imprimir();
		System.out.println("recarga 1");
		boolean resultado=rubia.recargarCerveza(3000);
		System.out.println("se recargo correctamente "+resultado);
		rubia.imprimir();
		System.out.println("recarga 2");
		rubia.recargarCerveza(2000);
		System.out.println("se recargo correctamente "+resultado);
		rubia.imprimir();
		System.out.println("recarga 2");
		rubia.recargarCerveza(2900);
		System.out.println("se recargo correctamente "+resultado);
		rubia.imprimir();

	}

}
