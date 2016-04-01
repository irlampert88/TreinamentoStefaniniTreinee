package programa.util;

public final class FormatadorDeResultadoDoGarimpo {

	private final StringBuilder resultado;
	private final String prefixoPadrao = "   > ";
	
	public FormatadorDeResultadoDoGarimpo() {
		this.resultado = new StringBuilder();
	}

	public final FormatadorDeResultadoDoGarimpo adicionaInformacao(String informacaoGarimpada) {
		if (!Strings.estaVazioOuNulo(informacaoGarimpada)) 
			resultado.append(prefixoPadrao + informacaoGarimpada).append("\n");
		
		return this;
	}
	
	public final String resultadoFormatado() {
		String resultadoFormatado = resultado.toString();
		
		if (Strings.estaVazioOuNulo(resultadoFormatado))
			return prefixoPadrao + "Não foram encontradas informações para este Garimpeiro.";
		
		return resultadoFormatado;
	}
	
}
