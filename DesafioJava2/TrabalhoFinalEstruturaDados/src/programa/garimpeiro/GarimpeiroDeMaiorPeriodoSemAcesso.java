package programa.garimpeiro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import programa.entidades.DataDaLinha;
import programa.entidades.IntervaloDeDatas;
import programa.util.FormatadorDeResultadoDoGarimpo;

public final class GarimpeiroDeMaiorPeriodoSemAcesso 
	extends GarimpeiroAbstrato {

	/** DESCRI��O: 
	 	Conhe�a os tr�s maiores per�odos de tempo sem acesso ao servidor web. Mostrar os per�odos em
		ordem decrescente de tamanho
	 */
	
	private DataDaLinha dataAnterior;
	private final List<IntervaloDeDatas> maioresIntervalos;
	
	public GarimpeiroDeMaiorPeriodoSemAcesso() {
		super("3 maiores per�odos sem acesso:");
		maioresIntervalos = new ArrayList<IntervaloDeDatas>();
	}
	
	@Override
	public final void garimpar(String dado) {
		DataDaLinha dataDaLinhaAtual = new DataDaLinha(dado);

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
