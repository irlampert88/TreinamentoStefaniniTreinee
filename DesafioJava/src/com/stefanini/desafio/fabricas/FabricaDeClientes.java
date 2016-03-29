package com.stefanini.desafio.fabricas;

import com.stefanini.desafio.dominio.Dado;
import com.stefanini.desafio.entidades.Cliente;

/**
 * @author Ivan Lampert
 */
public final class FabricaDeClientes {

	private FabricaDeClientes() {
	}
	
	public static Cliente criar(Dado dado) {
		return new Cliente(dado.getValorDaPosicao(1), dado.getValorDaPosicao(2), dado.getValorDaPosicao(3));
	}
	
}
