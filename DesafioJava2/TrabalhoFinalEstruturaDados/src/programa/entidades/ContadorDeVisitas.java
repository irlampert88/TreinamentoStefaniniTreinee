package programa.entidades;

import java.util.HashMap;
import java.util.Map;

public class ContadorDeVisitas {

	private int intervaloEmMinutos = 30;
	private final Map<String, Data> visitasFeitas;
	private int visitasDistintas = 0;
	
	
	public ContadorDeVisitas() {
		visitasFeitas = new HashMap<String, Data>();
	}
	
	public void definirIntervaloLimiteEmMinutos(int tempoEmMinutos) {
		if (tempoEmMinutos > 0) {
			this.intervaloEmMinutos = tempoEmMinutos;
		}
	}

	public String quantidadeDeVisitasFormatado() {
		int quantidadeDeVisitas = visitasDistintas;
		if (quantidadeDeVisitas == 0) {
			return "Não foram feitas visitas";
		}
		
		return "Total de visitas: " + quantidadeDeVisitas;
	}

	public void adicionarIpVisitante(IpVisitante ip, Data dataDoIp) {
		Data dataDaVisita = visitasFeitas.get(ip.getIp());
		
		if (dataDaVisita == null) {
			adicionaVisitanteEDataDaVisita(ip, dataDoIp);
			
		} else {
			if (dataDaVisitaExcedeuDataLimiteDaUltimaVisita(dataDaVisita, dataDoIp)) {
				adicionaVisitanteEDataDaVisita(ip, dataDoIp);
			}
		}
	}

	private boolean dataDaVisitaExcedeuDataLimiteDaUltimaVisita(Data dataDaVisita, Data dataDoIp) {
		long diferenteEmMinutos = dataDaVisita.diferenteEmMinutos(dataDoIp);
		return diferenteEmMinutos > intervaloEmMinutos;
	}

	private void adicionaVisitanteEDataDaVisita(IpVisitante ip, Data dataDoIp) {
		visitasFeitas.put(ip.getIp(), dataDoIp);
		visitasDistintas ++;
	}
	
}
