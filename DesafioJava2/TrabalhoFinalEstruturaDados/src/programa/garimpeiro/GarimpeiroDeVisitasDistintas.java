package programa.garimpeiro;

import programa.entidades.ContadorDeVisitas;
import programa.entidades.DataDaLinha;
import programa.entidades.IpVisitanteDaLinha;
import programa.util.FormatadorDeResultadoDoGarimpo;

public final class GarimpeiroDeVisitasDistintas 
	extends GarimpeiroAbstrato {

	/** DESCRIÇÃO:
	 	Contar e mostrar o número de visitas distintas. Uma visita distinta é o conjunto de todos os
		acessos provenientes de um único endereço IP, com menos de 30 minutos de intervalo entre cada acesso
		consecutivo para esse IP. Ou seja, o seguinte trecho de log abaixo mostra três diferentes visitas
	 */
	
	private final ContadorDeVisitas visitas;
	
	public GarimpeiroDeVisitasDistintas() {
		super("Todas visitas distintas (dentro do intervalo de " + tempoLimiteEmMinutos() + " minutos):");
		
		this.visitas = new ContadorDeVisitas();
		this.visitas.definirIntervaloLimiteEmMinutos(tempoLimiteEmMinutos());
	}

	private static int tempoLimiteEmMinutos() {
		return 30;
	}
	
	@Override
	public void garimpar(String dado) {
		DataDaLinha dataDaLinhaAtual = new DataDaLinha(dado);
		IpVisitanteDaLinha ipVisitanteDaLinhaAtual = new IpVisitanteDaLinha(dado);

		visitas.adicionarIpVisitante(ipVisitanteDaLinhaAtual, dataDaLinhaAtual);
	}

	@Override
	void formatarInformacoesColetadas(FormatadorDeResultadoDoGarimpo formatadorResultados) {
		formatadorResultados.adicionaInformacao("Total de visitas distintas realizadas, respeitando os intervalos de " + tempoLimiteEmMinutos() + " minutos:")
							.adicionaInformacao(visitas.quantidadeDeVisitasFormatado());
	}
}
