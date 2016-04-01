package programa.util;

public class FormatadorDeResultadoDoGarimpo {

	private final StringBuilder resultado;
	private final String prefixoPadrao = "   > ";
	
	public FormatadorDeResultadoDoGarimpo() {
		this.resultado = new StringBuilder();
	}

	public FormatadorDeResultadoDoGarimpo adicionaInformacao(String informacaoGarimpada) {
		if (!Strings.estaVazioOuNulo(informacaoGarimpada)) {
			resultado.append(prefixoPadrao + informacaoGarimpada).append("\n");
		}
		
		return this;
	}
	
	public String resultadoFormatado() {
		String resultadoFormatado = resultado.toString();
		
		if (Strings.estaVazioOuNulo(resultadoFormatado)) {
			return prefixoPadrao + "Não foram encontradas informações para este Garimpeiro.";
		} 
		
		return resultadoFormatado;
	}
	
}
