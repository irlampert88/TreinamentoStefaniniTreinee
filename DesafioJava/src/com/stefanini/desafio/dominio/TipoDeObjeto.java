package com.stefanini.desafio.dominio;

import com.stefanini.desafio.fabricas.FabricaDeClientes;
import com.stefanini.desafio.fabricas.FabricaDeVendas;
import com.stefanini.desafio.fabricas.FabricaDeVendedores;
import com.stefanini.desafio.repositorio.RepositorioDeClientes;
import com.stefanini.desafio.repositorio.RepositorioDeVendas;
import com.stefanini.desafio.repositorio.RepositorioDeVendedores;
import com.stefanini.desafio.validadores.ValidadorDeLinhaAbstrato;
import com.stefanini.desafio.validadores.ValidadorDeLinhaDeCliente;
import com.stefanini.desafio.validadores.ValidadorDeLinhaDeVenda;
import com.stefanini.desafio.validadores.ValidadorDeLinhaDoVendedor;

public enum TipoDeObjeto {

	VENDEDOR("001") {
		@Override
		ValidadorDeLinhaAbstrato validadorDeLinhaDoTipo() {
			return new ValidadorDeLinhaDoVendedor();
		}
		
		@Override
		void criarDado(Dado dado) {
			RepositorioDeVendedores.getInstancia().adiciona(FabricaDeVendedores.criar(dado));
		}
	},
	CLIENTE("002") {
		@Override
		ValidadorDeLinhaAbstrato validadorDeLinhaDoTipo() {
			return new ValidadorDeLinhaDeCliente();
		}
		
		@Override
		void criarDado(Dado dado) {
			RepositorioDeClientes.getInstancia().adiciona(FabricaDeClientes.criar(dado));
		}
	},
	VENDA("003") {
		@Override
		ValidadorDeLinhaAbstrato validadorDeLinhaDoTipo() {
			return new ValidadorDeLinhaDeVenda();
		}
		
		@Override
		void criarDado(Dado dado) {
			RepositorioDeVendas.getInstancia().adiciona(FabricaDeVendas.criar(dado));
		}
	};
	
	private String id;
	
	private TipoDeObjeto(String id) {
		this.id = id;
	}
	
	abstract void criarDado(Dado dado);
	abstract ValidadorDeLinhaAbstrato validadorDeLinhaDoTipo();
	
	public static void criarDadoDaLinha(String linha) {
		Dado dado = new Dado(linha);
		if (dado.estaValido()) {
			TipoDeObjeto tipo = buscaTipoPeloId(dado.getIdDaLinha());
			if (tipo != null && tipo.validadorDeLinhaDoTipo().estaValida(linha))
				tipo.criarDado(dado);
		}
	}
	
	private static TipoDeObjeto buscaTipoPeloId(String id) {
		for (TipoDeObjeto tipo : values()) {
			if (tipo.id.equals(id))
				return tipo;
		}
		return null;
	}
	
}
