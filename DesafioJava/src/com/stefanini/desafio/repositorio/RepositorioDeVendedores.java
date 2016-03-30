package com.stefanini.desafio.repositorio;

import com.stefanini.desafio.entidades.Vendedor;

/**
 * @author Ivan Lampert
 */
public final class RepositorioDeVendedores
	extends RepositorioAbstrato<Vendedor> {

	private static final RepositorioDeVendedores instancia = new RepositorioDeVendedores();
	
	private RepositorioDeVendedores() {
	}

	public static RepositorioDeVendedores getInstancia() {
		return instancia;
	}

	public Vendedor buscarVendedorPeloNome(String nomeDoVendedor) {
		return getDados().stream().filter(vendedor -> vendedor.getNome().equalsIgnoreCase(nomeDoVendedor))
				.findFirst().get();
	}
	
	public long quantidadeDeVendedores() {
		return getDados().stream().distinct().count();
	}
	
}
