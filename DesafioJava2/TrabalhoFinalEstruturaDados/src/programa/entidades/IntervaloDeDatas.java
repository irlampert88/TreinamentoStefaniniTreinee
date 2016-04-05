package programa.entidades;

public final class IntervaloDeDatas {

	private final DataDaLinha data1;
	private final DataDaLinha data2;

	public IntervaloDeDatas(DataDaLinha data1, DataDaLinha data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	public final long diferencaEntreAsDatasEmMilisegundos() {
		return (data1.diferencaEmMilisegundos(data2));
	}
	
	public final String retornarDuracaoEPeriodoFormatado() {
		return "Dura��o : "+ diferencaEmMinutos() + " minutos. Per�odo: " + data1.dataFormatada() + " at� " + data2.dataFormatada();
	}

	private final String diferencaEmMinutos() {
		return String.valueOf(data1.diferenteEmMinutos(data2));
	}
	
}
