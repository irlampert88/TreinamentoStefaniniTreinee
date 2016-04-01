package programa.entidades;

public class IntervaloDeDatas {

	private Data data1;
	private Data data2;

	public IntervaloDeDatas(Data data1, Data data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	public long diferencaEntreAsDatasEmMilisegundos() {
		return (data1.diferencaEmMilisegundos(data2));
	}
	
	public String retornarDuracaoEPeriodoFormatado() {
		return "Duração : "+ diferencaEmMinutos() + " minutos. Período: " + data1.dataFormatada() + " até " + data2.dataFormatada();
	}

	private String diferencaEmMinutos() {
		return String.valueOf(data1.diferenteEmMinutos(data2));
	}
	
}
