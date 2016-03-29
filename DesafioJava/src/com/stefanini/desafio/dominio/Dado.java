package com.stefanini.desafio.dominio;

/**
 * @author Ivan Lampert
 */
public final class Dado {

	private final String[] valoresDaLinha;
	
	public Dado(String linha) {
		this.valoresDaLinha = (linha == null || linha.trim().isEmpty()) ? null : linha.split(Constantes.DELIMITADOR);
	}
	
	public final boolean estaValido() {
		return valoresDaLinha.length == 0;
	}

	public final String getIdDaLinha() {
		return valoresDaLinha[0];
	}

	public String getValorDaPosicao(int posicao) {
		return valoresDaLinha[posicao];
	}
	
}
