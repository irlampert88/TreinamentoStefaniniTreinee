package programa;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import programa.util.Strings;

public class LeitorDeArquivo {

	private final String caminhoDoArquivo;
	private final String nomeDoArquivo;

	public LeitorDeArquivo(String caminhoDoArquivo, String nomeDoArquivo) {
		this.caminhoDoArquivo = caminhoDoArquivo;
		this.nomeDoArquivo = nomeDoArquivo;

		validarCaminhoInformado(caminhoDoArquivo, nomeDoArquivo);
	}

	public List<String> lerConteudo() {
		try {
			return conteudoDoArquivo(caminhoDoArquivo, nomeDoArquivo);

		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	private List<String> conteudoDoArquivo(String caminhoDoArquivo, String nomeDoArquivo) throws IOException {
		Path localDoArquivo = Paths.get(caminhoDoArquivo, nomeDoArquivo);
		
		return Files.readAllLines(localDoArquivo, Charset.defaultCharset());
	}

	private void validarCaminhoInformado(String caminhoDoArquivo, String nomeDoArquivo) {
		if (Strings.estaVazioOuNulo(caminhoDoArquivo) || Strings.estaVazioOuNulo(nomeDoArquivo)) {
			throw new IllegalArgumentException("Caminho do arquivo informado está vazio ou é nulo. Informe um caminho válido.");
		}
		
		String nomeDoArquivoCompleto = caminhoDoArquivo + File.separator + nomeDoArquivo;
		File arquivoFisico = new File(nomeDoArquivoCompleto);
		if (!arquivoFisico.exists()) {
			throw new IllegalArgumentException("Arquivo " + nomeDoArquivoCompleto + " não encontrado.");
		}
	}
	
}
