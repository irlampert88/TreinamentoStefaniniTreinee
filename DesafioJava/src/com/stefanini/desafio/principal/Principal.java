package com.stefanini.desafio.principal;

import java.nio.file.Path;
import java.util.List;

import com.stefanini.desafio.analise.AnalisadorDeDadosDat;
import com.stefanini.desafio.dominio.Constantes;
import com.stefanini.desafio.exportador.ExportadorDeResultadosDat;
import com.stefanini.desafio.extrator.ExtratorDeDadosDat;
import com.stefanini.desafio.repositorio.RepositorioDeArquivosDat;

/**
 * @author Ivan Lampert
 */
public final class Principal {

	public static void main(String[] args) {
		new Principal();
	}
	
	public Principal() {
		try {
			
			RepositorioDeArquivosDat repositorio = new RepositorioDeArquivosDat(Constantes.LOCAL_LEITURA);
			List<Path> arquivosDat = repositorio.buscarTodos();
			// arquivosDat.forEach(System.out::println);
			
			ExtratorDeDadosDat extrator = new ExtratorDeDadosDat(arquivosDat);
			extrator.iniciarExtracao();
			
			AnalisadorDeDadosDat analisador = new AnalisadorDeDadosDat();
			analisador.iniciarAnalise();
			
			ExportadorDeResultadosDat exportador = new ExportadorDeResultadosDat();
			exportador.iniciarExportacao();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
