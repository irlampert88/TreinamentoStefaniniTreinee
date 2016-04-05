package programa.entidades;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import programa.util.FormatadorDeDatas;

public final class DataDaLinha {

	private final Date dataDaLinha;
	
	public DataDaLinha(String dadoBruto) {
		dataDaLinha = extrairDataDaLinha(dadoBruto);
	}
	
	private Date extrairDataDaLinha(String dadoBruto) {
		String[] linhaDividida = dadoBruto.split("-");
		
		String dataBruta = linhaDividida[3];
		dataBruta = dataBruta.replace("[", "").replace("-0300]", "").trim();
		
		// 05/Jul/2015:12:54:24
		String mes = dataBruta.substring(3, 6); // Jul
		dataBruta = dataBruta.replace(mes, String.valueOf(ConversorDeMes.retornaNumeroDoMes(mes)));
		
		return FormatadorDeDatas.getInstance().paraDataDoJava(dataBruta);
	}
	
	public final String dataFormatada() {
		return FormatadorDeDatas.getInstance().paraStringPtBr(dataDaLinha);
	}
	
	public final long diferencaEmMilisegundos(DataDaLinha dataAComparar) {
		long maiorValor = (dataDaLinha.getTime() > dataAComparar.dataDaLinha.getTime() ? dataDaLinha.getTime() : dataAComparar.dataDaLinha.getTime());
		long menorValor = (dataDaLinha.getTime() < dataAComparar.dataDaLinha.getTime() ? dataDaLinha.getTime() : dataAComparar.dataDaLinha.getTime());
		
		return (maiorValor - menorValor); 
	}
	
	public final long diferenteEmMinutos(DataDaLinha dataAComparar) {
		return TimeUnit.MILLISECONDS.toMinutes(diferencaEmMilisegundos(dataAComparar));
	}
	
}
