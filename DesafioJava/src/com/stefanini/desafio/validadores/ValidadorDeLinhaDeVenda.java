package com.stefanini.desafio.validadores;

/**
 * @author Ivan Lampert
 */
public final class ValidadorDeLinhaDeVenda
	extends ValidadorDeLinhaAbstrato {

	// 003ÁSaleIDÁ[ItemID-ItemQuantity-ItemPrice]ÁSalesmanname
	
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
