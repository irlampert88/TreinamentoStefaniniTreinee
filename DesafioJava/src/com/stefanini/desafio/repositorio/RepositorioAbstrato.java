package com.stefanini.desafio.repositorio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ivan Lampert
 */
public abstract class RepositorioAbstrato<TIPO> {

	private List<TIPO> dados;
	
	public RepositorioAbstrato() {
		dados = new ArrayList<>();
	}
	
	public final void adiciona(TIPO novoDado) {
		dados.add(novoDado);
	}
	
	final List<TIPO> getDados() {
		return dados;
	}
	
}
