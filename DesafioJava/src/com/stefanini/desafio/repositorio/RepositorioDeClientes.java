package com.stefanini.desafio.repositorio;

import com.stefanini.desafio.entidades.Cliente;

/**
 * @author Ivan Lampert
 */
public final class RepositorioDeClientes 
	extends RepositorioAbstrato<Cliente> {

	private static final RepositorioDeClientes instancia = new RepositorioDeClientes();
	
	private RepositorioDeClientes() {
	}

	public static RepositorioDeClientes getInstancia() {
		return instancia;
	}
	
}
