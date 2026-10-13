package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	ArrayList<Maquina> maquinas = new ArrayList<Maquina>();

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int ultimoCodigo = 100;

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

		if (recuperarMaquina(codigo) != null) {
			return false;
		}

		Maquina m = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
		maquinas.add(m);

		return true;
	}

	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			m.llenarMaquina();
		}
	}

	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina m = maquinas.get(i);
			if (m.getCodigo().equals(codigo)) {
				return m;
			}
		}
		return null;
	}

	public void registrarCliente(String nombre, String cedula) {
		ultimoCodigo++;
		Cliente c = new Cliente(nombre, cedula);
		c.setCodigo(ultimoCodigo);
		clientes.add(c);
	}

	public Cliente buscarClientePorCedula(String cedula) {
		for (int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			if (c.getCedula().equals(cedula)) {
				return c;
			}
		}
		return null;
	}

	public Cliente buscarClientePoCodigo(int codigo) {
		for (int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			if (c.getCodigo() == codigo) {
				return c;
			}
		}
		return null;
	}

	public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
		Maquina m = recuperarMaquina(codigoMaquina);
		Cliente c = buscarClientePoCodigo(codigoCliente);
		if (m != null && c != null) {
	        double consumo = m.cervirCerveza(cantidad);
	        registrasConsumo(c, consumo);
	    }
	}

	public void registrasConsumo(Cliente cliente, double valor) {
		cliente.setTotalConsumir(cliente.getTotalConsumir()+valor);
	}
	
	public double consultarValorVendido() {
		double valor=0;
		for(int i=0;i<clientes.size();i++) {
			Cliente c=clientes.get(i);
			valor=valor+c.getTotalConsumir();
		}
		return valor;
	}
}
