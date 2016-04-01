package programa.garimpeiro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import programa.entidades.Data;
import programa.entidades.IntervaloDeDatas;
import programa.util.FormatadorDeResultadoDoGarimpo;

public final class GarimpeiroDeMaiorPeriodoSemAcesso 
	extends GarimpeiroAbstrato {

	/** DESCRIÇÃO: 
	 	Conheça os três maiores períodos de tempo sem acesso ao servidor web. Mostrar os períodos em
		ordem decrescente de tamanho
	 */
	
	private Data dataAnterior;
	private final List<IntervaloDeDatas> maioresIntervalos;
	
	public GarimpeiroDeMaiorPeriodoSemAcesso() {
		super("3 maiores períodos sem acesso:");
		maioresIntervalos = new ArrayList<IntervaloDeDatas>();
	}
	
	@Override
	public final void garimpar(String dado) {
		Data dataDaLinhaAtual = new Data(dado);

		if (dataAnterior != null)
			maioresIntervalos.add(new IntervaloDeDatas(dataAnterior, dataDaLinhaAtual));
		
		dataAnterior = dataDaLinhaAtual;
	}

	@Override
	void formatarInformacoesColetadas(FormatadorDeResultadoDoGarimpo formatadorResultados) {
		maioresIntervalos.stream()
				.sorted(Comparator.comparingLong(IntervaloDeDatas::diferencaEntreAsDatasEmMilisegundos).reversed())
				.limit(3)
				.forEach(intervalo -> formatadorResultados.adicionaInformacao(intervalo.retornarDuracaoEPeriodoFormatado()));
	}

}
