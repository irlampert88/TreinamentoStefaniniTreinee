package com.stefanini.desafio.fabricas;

import com.stefanini.desafio.dominio.Dado;
import com.stefanini.desafio.entidades.Vendedor;

/**
 * @author Ivan Lampert
 */
public final class FabricaDeVendedores {

	private FabricaDeVendedores() {
	}
	
	public static Vendedor criar(Dado dado) {
		Double salarioDoDado = Double.valueOf(dado.getValorDaPosicao(3));
		return new Vendedor(dado.getValorDaPosicao(1), dado.getValorDaPosicao(2), salarioDoDado);
	}
	
}
