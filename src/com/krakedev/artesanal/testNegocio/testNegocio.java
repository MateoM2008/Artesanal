package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class testNegocio {

	public static void main(String[] args) {
		
		
		Maquina nueva=new Maquina("0001","cerveza clup","cerveza fria",0.02,8000);
		Negocio n1=new Negocio("mi negocio",nueva);
		System.out.println("Nombre: "+n1.getNombre());
		System.out.println("Maquina"+n1.getMaquinaA());
		Maquina m1=n1.getMaquinaA();
		double capacidad=m1.getCapacidadMaxima();
	}

}
