package com.stefanini.desafio.validadores;

/**
 * @author Ivan Lampert
 */
public final class ValidadorDeLinhaDeCliente
	extends ValidadorDeLinhaAbstrato {

	// 002�CNPJ�Name�BusinessArea
	
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
