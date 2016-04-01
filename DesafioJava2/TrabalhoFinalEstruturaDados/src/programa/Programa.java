package programa;

import java.util.List;

import programa.garimpeiro.GarimpeiroDeBandaUtilizadaPorArquivo;
import programa.garimpeiro.GarimpeiroDeMaiorPeriodoSemAcesso;
import programa.garimpeiro.GarimpeiroDeNavegadoresMaisUtilizados;
import programa.garimpeiro.GarimpeiroDePlataformasMaisUtilizadas;
import programa.garimpeiro.GarimpeiroDeVisitasDistintas;
import programa.util.Cronometro;
import programa.util.Impressora;

/**
 *
 * @author Denner Erthal
 * @author Ivan Rafael Lampert
 * @author Patrick Siqueira da Rosa
 * @author Tales Igor Ebert
 */
public final class Programa {

	private final String localDoArquivo = "C:\\";
	private final String nomeDoArquivo = "access.log";

	public static void main(String[] args) {
		Impressora.imprimir("Início do programa\n");
		new Programa();
		Impressora.imprimir("\nFim do programa");
	}
	
	private Programa() {
		Cronometro cronometro = new Cronometro();
		cronometro.iniciar();

		List<String> conteudoDoLog = conteudoDoArquivoDeLog();
		MinaDeDados mina = new MinaDeDados(conteudoDoLog);

		adicionarGarimpeirosNaMina(mina);
		
		mina.garimpar();
		mina.listarInformacoesColetadasDosGarimpeiros();

		imprimirResumo(mina);
		cronometro.encerrar();	
	}

	private void imprimirResumo(MinaDeDados mina) {
		Impressora.imprimir("\n* Resumo:");
		Impressora.imprimir("Quantidade de dados minerados: " + mina.quantidadeDeDadosMinerados());
	}

	private void adicionarGarimpeirosNaMina(MinaDeDados mina) {
		mina.adicionarGarimpeiro(new GarimpeiroDeMaiorPeriodoSemAcesso());
		mina.adicionarGarimpeiro(new GarimpeiroDeVisitasDistintas());
		mina.adicionarGarimpeiro(new GarimpeiroDeNavegadoresMaisUtilizados());
		mina.adicionarGarimpeiro(new GarimpeiroDePlataformasMaisUtilizadas());
		mina.adicionarGarimpeiro(new GarimpeiroDeBandaUtilizadaPorArquivo());
	}

	private List<String> conteudoDoArquivoDeLog() {
		LeitorDeArquivo leitorDoArquivodeLog = new LeitorDeArquivo(localDoArquivo, nomeDoArquivo);
		return leitorDoArquivodeLog.lerConteudo();
	}
	
}
