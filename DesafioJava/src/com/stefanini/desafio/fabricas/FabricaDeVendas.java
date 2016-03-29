package com.stefanini.desafio.fabricas;

import com.stefanini.desafio.dominio.Dado;
import com.stefanini.desafio.entidades.Venda;
import com.stefanini.desafio.entidades.Vendedor;
import com.stefanini.desafio.repositorio.RepositorioDeVendedores;

/**
 * @author Ivan Lampert
 */
public final class FabricaDeVendas {

	private FabricaDeVendas() {
	}
	
	public static Venda criar(Dado dado) {
		Vendedor vendedorDaVenda = RepositorioDeVendedores.getInstancia().buscarVendedorPeloNome(dado.getValorDaPosicao(3));
		
		Venda venda = new Venda(dado.getValorDaPosicao(1), vendedorDaVenda);
		
		FabricaDeItensDaVenda.criarItens(dado.getValorDaPosicao(2))
			.forEach(item -> venda.adicionaItem(item));
		
		return venda;
	}
	
}
