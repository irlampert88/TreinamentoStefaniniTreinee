package programa.garimpeiro;

import programa.util.FormatadorDeResultadoDoGarimpo;
import programa.util.Impressora;
import programa.util.Strings;

abstract class GarimpeiroAbstrato
	implements Garimpeiro {
	
	private final String descricaoDoGarimpeiro;

	GarimpeiroAbstrato(String descricaoDoGarimpeiro) {
		this.descricaoDoGarimpeiro = descricaoDoGarimpeiro;

		validateDescricaoDoGarimpeiro(descricaoDoGarimpeiro);
	}
	
	private void validateDescricaoDoGarimpeiro(String descricaoDoGarimpeiro) {
		if (Strings.estaVazioOuNulo(descricaoDoGarimpeiro)) 
			throw new IllegalArgumentException("A descri��o do Garimpeiro est� vazia ou nula. Informe uma descri��o v�lida.");
	}

	@Override
	public final void listarInformacoesColetadas() {
		escreverCabecalhoDoGarimpeiro();
		escreverConteudoDoGarimpeiro();
	}
	
	private void escreverCabecalhoDoGarimpeiro() {
		Impressora.imprimir("> " + descricaoDoGarimpeiro);
	}

	private void escreverConteudoDoGarimpeiro() {
		FormatadorDeResultadoDoGarimpo formatadorDeResultados = new FormatadorDeResultadoDoGarimpo();
		formatarInformacoesColetadas(formatadorDeResultados);
		
		Impressora.imprimir(formatadorDeResultados.resultadoFormatado());
	}

	abstract void formatarInformacoesColetadas(FormatadorDeResultadoDoGarimpo formatadorResultados);
	
}
