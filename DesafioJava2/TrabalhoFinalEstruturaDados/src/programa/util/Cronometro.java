package programa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cronometro {

	private static final long TEMPO_INVALIDO = -1;
	
	private long tempoInicial = TEMPO_INVALIDO;
	private long tempoFinal = TEMPO_INVALIDO;
	
	public Cronometro() {
	}

	public void iniciar() {
		if (jaFoiIniciado()) {
			throw new IllegalArgumentException("Cronômetro já foi iniciado.");
		}
		
		if (jaFoiEncerrado()) {
			throw new IllegalArgumentException("Cronômetro já foi encerrado.");
		}
		
		tempoInicial = pegarTempoAtual("Início");
	}
	
	public void encerrar() {
		if (!jaFoiIniciado()) {
			throw new IllegalArgumentException("Inicie o cronômetro antes de encerrar.");
		}
		
		if (jaFoiEncerrado()) {
			throw new IllegalArgumentException("Cronômetro já foi encerrado.");
		}
		
		tempoFinal = pegarTempoAtual("Fim");
		imprimirDuracao();
	}

	private long pegarTempoAtual(String descricao) {
		return Calendar.getInstance().getTimeInMillis();
	}
	
	private void imprimirDuracao() {
		Calendar quandoIniciou = Calendar.getInstance();
		quandoIniciou.setTimeInMillis(tempoInicial);
		imprimirTempo("Iniciou:", quandoIniciou);
		
		Calendar quandoTerminou = Calendar.getInstance();
		quandoTerminou.setTimeInMillis(tempoFinal);
		imprimirTempo("Terminou:", quandoTerminou);
	}
	
	private void imprimirTempo(String descricao, Calendar tempo) {
		Impressora.imprimir(descricao + ": " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(tempo.getTime()));
	}

	private boolean jaFoiEncerrado() {
		return (tempoFinal != TEMPO_INVALIDO);
	}

	private boolean jaFoiIniciado() {
		return (tempoInicial != TEMPO_INVALIDO);
	}
	
}
