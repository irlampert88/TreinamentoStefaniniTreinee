package com.stefanini.desafio.validadores;

/**
 * @author Ivan Lampert
 */
public final class ValidadorDeLinhaDoVendedor 
	extends ValidadorDeLinhaAbstrato {

	// 001�CPF�Name�Salary

	@Override
	final int getQuantidadeDeValores() {
		return 4;
	}

	@Override
	final boolean validadorEspecificoEstaValido(String linha) {
		// TODO
		return true;
	}
	
}
