package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	ArrayList<Maquina> maquinas = new ArrayList<Maquina>();

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return "M-" + numero;
	}

	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
		Maquina m = new Maquina(codigo,nombreCerveza,descripcion,precioPorMl);
		for(int i=0;i<maquinas.size();i++) {
			Maquina encontrada=maquinas.get(i);
			if(encontrada.getCodigo()!=codigo) {
				maquinas.add(m);
				return true;
			}
			
		}
		return false;
	}
	
	public void cargarMaquinas() {
		for(int i=0;i<maquinas.size();i++) {
			Maquina m=maquinas.get(i);
			m.llenarMaquina();
		}
	}
	public Maquina recuperarMaquina(String codigo) {
		for(int i=0;i<maquinas.size();i++) {
			Maquina m=maquinas.get(i);
			if(m.getCodigo()==codigo) {
				return m;
			}
		}
		return null;
	}
}
