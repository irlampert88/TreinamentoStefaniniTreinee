package com.stefanini.desafio.validadores;

import com.stefanini.desafio.dominio.Constantes;

/**
 * @author Ivan Lampert
 */
public abstract class ValidadorDeLinhaAbstrato {

	public final boolean estaValida(String linha) {
		if (estaNulaOuVazia(linha))
			return false;
		
		if (quantidadeValoresDiferenteDe(linha, getQuantidadeDeValores()))
			return false;
		
		if (!validadorEspecificoEstaValido(linha))
			return false;
		
		return true;
	}

	abstract boolean validadorEspecificoEstaValido(String linha);
	abstract int getQuantidadeDeValores();

	private boolean quantidadeValoresDiferenteDe(String linha, int quantidadeDeValores) {
		return linha.split(Constantes.DELIMITADOR).length != quantidadeDeValores;
	}

	private boolean estaNulaOuVazia(String linha) {
		return linha == null || linha.trim().isEmpty();
	}
	
}
