package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class testservir {

	public static void main(String[] args) {
		Maquina rubia = new Maquina("0001","pilcener", "cerveza fria", 0.02, 8000);
		System.out.println("estado inicial");
		rubia.imprimir();
		System.out.println("estado inicial");
		rubia.llenarMaquina();
		rubia.imprimir();
		System.out.println("servir 1000 ml");
		double valor = rubia.cervirCerveza(1000);
		System.out.println("Valor a pagar: " + valor);
		System.out.println("servir 2000 ml");
		valor = rubia.cervirCerveza(2000);
		System.out.println("Valor a pagar: " + valor);
		System.out.println("servir 6000 ml");
		valor = rubia.cervirCerveza(6000);
		System.out.println("Valor a pagar: " + valor);
		

	}

}
