package com.stefanini.desafio.repositorio;

import com.stefanini.desafio.entidades.Venda;

/**
 * @author Ivan Lampert
 */
public final class RepositorioDeVendas 
	extends RepositorioAbstrato<Venda> {

	private static final RepositorioDeVendas instancia = new RepositorioDeVendas();
	
	private RepositorioDeVendas() {
	}

	public static RepositorioDeVendas getInstancia() {
		return instancia;
	}
	
}
