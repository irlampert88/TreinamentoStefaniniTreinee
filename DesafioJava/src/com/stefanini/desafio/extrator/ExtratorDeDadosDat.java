package com.stefanini.desafio.extrator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.stefanini.desafio.dominio.TipoDeObjeto;
import com.stefanini.desafio.util.TratamentoDeErros;

/**
 * @author Ivan Lampert
 */
public final class ExtratorDeDadosDat {

	private final List<Path> arquivosDat;
	
	public ExtratorDeDadosDat(List<Path> arquivosDat) {
		this.arquivosDat = arquivosDat;
	}

	public final void iniciarExtracao() {
		arquivosDat.forEach(arquivo -> extrairDadosDoArquivo(arquivo));
	}

	private void extrairDadosDoArquivo(Path arquivo) {
		try {
			Files.readAllLines(arquivo).forEach(linha -> extrairDadoDaLinha(linha));
		} catch (Exception e) {
			new TratamentoDeErros().tratar(e);
		}
	}

	private void extrairDadoDaLinha(String linha) {
		TipoDeObjeto.criarDadoDaLinha(linha);
	}

}
