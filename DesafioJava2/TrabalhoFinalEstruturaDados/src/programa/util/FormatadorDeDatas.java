package programa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatadorDeDatas {

	private final static FormatadorDeDatas instance = new FormatadorDeDatas(); 
	private final SimpleDateFormat formatacaoDoArquivoDeLog;
	private final SimpleDateFormat formatadorPadrao;

	private FormatadorDeDatas() {
		formatacaoDoArquivoDeLog = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss");
		formatadorPadrao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	}

	public static FormatadorDeDatas getInstance() {
		return instance;
	}

	public String paraStringPtBr(Date data) {
		return formatadorPadrao.format(data);
	}
	
	public Date paraDataDoJava(String dataEmString) {
		try {
			return formatacaoDoArquivoDeLog.parse(dataEmString);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao extrair data da linha. Verifique o arquivo.");
		}
	}
	
}
