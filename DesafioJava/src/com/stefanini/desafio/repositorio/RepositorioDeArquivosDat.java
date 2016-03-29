package com.stefanini.desafio.repositorio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan Lampert
 */
public final class RepositorioDeArquivosDat {

	private final String localLeitura;

	public RepositorioDeArquivosDat(String localLeitura) {
		this.localLeitura = localLeitura;
	}

	public final List<Path> buscarTodos() throws Exception {
		
		return Files.list(new File(localLeitura).toPath())
			        .filter(arquivo -> arquivo.toFile().isFile())
			        .filter(arquivo -> arquivo.toFile().getAbsolutePath().endsWith(".dat"))
			        .collect(Collectors.toList());
	}

}
