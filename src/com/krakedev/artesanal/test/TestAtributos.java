package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		Maquina rubia=new Maquina("0001","pilcener","cerveza rubia",0.02,10000);
		rubia.imprimir();
		
		rubia.setNombreCerveza("golden Ale");
		rubia.setDescripcion("cervaza con aroma mas intenso");
		rubia.imprimir();
		
	}

}
