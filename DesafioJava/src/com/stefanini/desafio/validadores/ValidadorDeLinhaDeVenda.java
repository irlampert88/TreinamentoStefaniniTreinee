package com.stefanini.desafio.validadores;

/**
 * @author Ivan Lampert
 */
public final class ValidadorDeLinhaDeVenda
	extends ValidadorDeLinhaAbstrato {

	// 003�SaleID�[ItemID-ItemQuantity-ItemPrice]�Salesmanname
	
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
