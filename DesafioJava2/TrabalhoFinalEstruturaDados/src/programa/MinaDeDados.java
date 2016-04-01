package programa;

import java.util.ArrayList;
import java.util.List;

import programa.garimpeiro.Garimpeiro;

public class MinaDeDados {

	private final List<String> dadosAGarimpar;
	private final List<Garimpeiro> listaDeGarimpeiros;

	public MinaDeDados(List<String> dadosAGarimpar) {
		this.dadosAGarimpar = dadosAGarimpar;
		this.listaDeGarimpeiros = new ArrayList<Garimpeiro>();
		
		validarDadosAGarimpar(dadosAGarimpar);
	}

	private void validarDadosAGarimpar(List<String> dadosAGarimpar) {
		if (dadosAGarimpar == null || dadosAGarimpar.isEmpty()) {
			throw new IllegalArgumentException("Dados a garimpar por informações está vazio ou nulo. Informe uma fonde de dados para buscar por dados.");
		}
	}
	
	public void adicionarGarimpeiro(Garimpeiro garimpeiro) {
		if (garimpeiro != null) {
			listaDeGarimpeiros.add(garimpeiro);
		}
	}
	
	public void garimpar() {
		verificaSePossuiGarimpeirosAdicionados();
		
		for (Garimpeiro garimpeiro : listaDeGarimpeiros) {
			for (String dado : dadosAGarimpar) {
				garimpeiro.garimpar(dado);
			}
		}
	}
	
	public int quantidadeDeDadosMinerados() {
		return dadosAGarimpar.size();
	}
	
	public void listarInformacoesColetadasDosGarimpeiros() {
		verificaSePossuiGarimpeirosAdicionados();
		
		for (Garimpeiro garimpeiro : listaDeGarimpeiros) {
			garimpeiro.listarInformacoesColetadas();
		}
	}

	private void verificaSePossuiGarimpeirosAdicionados() {
		if (listaDeGarimpeiros == null || listaDeGarimpeiros.isEmpty()) {
			throw new IllegalArgumentException("Não foram adicionados Garimpeiros para análise e coleta de informações.");
		}
	}
	
}
