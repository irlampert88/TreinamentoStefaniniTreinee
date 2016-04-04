package programa;

import java.util.ArrayList;
import java.util.List;

import programa.garimpeiro.Garimpeiro;

public final class MinaDeDados {

	private final List<String> dadosAGarimpar;
	private final List<Garimpeiro> listaDeGarimpeiros;

	public MinaDeDados(List<String> dadosAGarimpar) {
		this.dadosAGarimpar = dadosAGarimpar;
		this.listaDeGarimpeiros = new ArrayList<Garimpeiro>();
		
		validarDadosAGarimpar(dadosAGarimpar);
	}

	private void validarDadosAGarimpar(List<String> dadosAGarimpar) {
		if (dadosAGarimpar == null || dadosAGarimpar.isEmpty())
			throw new IllegalArgumentException("Dados a garimpar por informa��es est� vazio ou nulo. Informe uma fonde de dados para buscar por dados.");
	}
	
	public final void adicionarGarimpeiro(Garimpeiro garimpeiro) {
		if (garimpeiro != null)
			listaDeGarimpeiros.add(garimpeiro);
	}
	
	public final void garimpar() {
		verificaSePossuiGarimpeirosAdicionados();
		
		dadosAGarimpar.forEach(linha -> {
			listaDeGarimpeiros.forEach(garimpeiro -> garimpeiro.garimpar(linha));
		});
	}
	
	public final int quantidadeDeDadosMinerados() {
		return dadosAGarimpar.size();
	}
	
	public final void listarInformacoesColetadasDosGarimpeiros() {
		verificaSePossuiGarimpeirosAdicionados();
		listaDeGarimpeiros.forEach(garimpeiro -> garimpeiro.listarInformacoesColetadas());
	}

	private void verificaSePossuiGarimpeirosAdicionados() {
		if (listaDeGarimpeiros == null || listaDeGarimpeiros.isEmpty())
			throw new IllegalArgumentException("N�o foram adicionados Garimpeiros para an�lise e coleta de informa��es.");
	}
	
}
