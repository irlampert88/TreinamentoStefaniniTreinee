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
			throw new IllegalArgumentException("Dados a garimpar por informações está vazio ou nulo. Informe uma fonde de dados para buscar por dados.");
	}
	
	public final void adicionarGarimpeiro(Garimpeiro garimpeiro) {
		if (garimpeiro != null)
			listaDeGarimpeiros.add(garimpeiro);
	}
	
	public final void garimpar() {
		verificaSePossuiGarimpeirosAdicionados();
		
		listaDeGarimpeiros.forEach(garimpeiro -> {
			for (String dado : dadosAGarimpar) { 
				garimpeiro.garimpar(dado);
			}
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
			throw new IllegalArgumentException("Não foram adicionados Garimpeiros para análise e coleta de informações.");
	}
	
}
