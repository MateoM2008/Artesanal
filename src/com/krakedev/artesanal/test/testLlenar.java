package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class testLlenar {

	public static void main(String[] args) {
		Maquina rubia = new Maquina("0001","pilcener", "cerveza fria", 0.02, 8000);
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();

		Maquina negra = new Maquina("0002","club", "cerveza buena", 0.03);
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();

	}

}
