package programa.entidades;

import java.util.HashMap;
import java.util.Map;

public final class ContadorDeVisitas {

	private int intervaloEmMinutos = 1; // Valor default
	
	private final Map<String, DataDaLinha> visitasFeitas;
	private int visitasDistintas = 0;
	
	public ContadorDeVisitas() {
		visitasFeitas = new HashMap<String, DataDaLinha>();
	}
	
	public final void definirIntervaloLimiteEmMinutos(int tempoEmMinutos) {
		if (tempoEmMinutos > 0)
			this.intervaloEmMinutos = tempoEmMinutos;
	}

	public final String quantidadeDeVisitasFormatado() {
		int quantidadeDeVisitas = visitasDistintas;
		if (quantidadeDeVisitas == 0)
			return "Não foram feitas visitas";
		
		return "Total de visitas: " + quantidadeDeVisitas;
	}

	public final void adicionarIpVisitante(IpVisitanteDaLinha ipAtual, DataDaLinha dataDaVisitaAtual) {
		DataDaLinha dataDaVisitaAnterior = visitasFeitas.get(ipAtual.getIp());
		
		if (dataDaVisitaAnterior == null) 
			adicionaVisitanteEDataDaVisita(ipAtual, dataDaVisitaAtual);
			
		else
			if (dataDaVisitaExcedeuDataLimiteDaUltimaVisita(dataDaVisitaAnterior, dataDaVisitaAtual))
				adicionaVisitanteEDataDaVisita(ipAtual, dataDaVisitaAtual);
	}

	private boolean dataDaVisitaExcedeuDataLimiteDaUltimaVisita(DataDaLinha dataDaVisita, DataDaLinha dataDoIp) {
		long diferenteEmMinutos = dataDaVisita.diferenteEmMinutos(dataDoIp);
		return diferenteEmMinutos > intervaloEmMinutos;
	}

	private void adicionaVisitanteEDataDaVisita(IpVisitanteDaLinha ip, DataDaLinha dataDoIp) {
		visitasFeitas.put(ip.getIp(), dataDoIp);
		visitasDistintas ++;
	}
	
}
