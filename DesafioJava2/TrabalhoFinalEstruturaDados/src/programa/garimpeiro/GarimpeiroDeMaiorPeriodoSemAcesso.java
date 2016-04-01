package programa.garimpeiro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import programa.entidades.Data;
import programa.entidades.IntervaloDeDatas;
import programa.util.FormatadorDeResultadoDoGarimpo;
import programa.util.OrdenadorDeListas;

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
	public void garimpar(String dado) {
		Data dataDaLinhaAtual = new Data(dado);

		if (dataAnterior != null) {
			IntervaloDeDatas intervalo = new IntervaloDeDatas(dataAnterior, dataDaLinhaAtual);
			
			maioresIntervalos.add(intervalo);
		}
		
		dataAnterior = dataDaLinhaAtual;
	}

	@Override
	void formatarInformacoesColetadas(FormatadorDeResultadoDoGarimpo formatadorResultados) {
		List<IntervaloDeDatas> valoresOrdenados = new OrdenadorDeListas<IntervaloDeDatas>(maioresIntervalos)
				.ordemDecrescente(Comparator.comparingLong(IntervaloDeDatas::diferencaEntreAsDatasEmMilisegundos));
		
		for (int count = 0; count < 3; count ++) {
			formatadorResultados.adicionaInformacao(valoresOrdenados.get(count).retornarDuracaoEPeriodoFormatado());
		}
	}

}
