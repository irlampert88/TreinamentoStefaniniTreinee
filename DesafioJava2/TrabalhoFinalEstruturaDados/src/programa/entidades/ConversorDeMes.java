package programa.entidades;

import programa.util.Strings;

public enum ConversorDeMes {

	JAN(1), 
	FEB(2), 
	MAR(3), 
	APR(4), 
	MAY(5), 
	JUN(6), 
	JUL(7), 
	AUG(8), 
	SEP(9), 
	OCT(10), 
	NOV(11), 
	DEC(12);
	
	private final int numero;

	private ConversorDeMes(int numero) {
		this.numero = numero;
	}
	
	public static int retornaNumeroDoMes(String mes) {
		if (Strings.estaVazioOuNulo(mes))
			throw new IllegalArgumentException("O m�s informado para busca do n�mero est� inv�lido (vazio ou nulo).");
		
		return valueOf(mes.toUpperCase()).numero;
	}
	
}
