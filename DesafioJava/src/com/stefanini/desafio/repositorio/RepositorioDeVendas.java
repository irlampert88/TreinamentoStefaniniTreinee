package com.stefanini.desafio.repositorio;

import com.stefanini.desafio.entidades.Venda;
import com.stefanini.desafio.entidades.Vendedor;

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

	public Vendedor melhorVendedor() {
		return getDados().stream()
				.max((venda1, venda2) -> venda1.getValorTotalDaVenda().compareTo(venda2.getValorTotalDaVenda()))
				.get().getVendedor();
	}
	
}
