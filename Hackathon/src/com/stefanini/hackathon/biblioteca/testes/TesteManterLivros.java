package com.stefanini.hackathon.biblioteca.testes;

import org.junit.Before;
import org.junit.Test;

import com.stefanini.hackathon.biblioteca.dao.LivroDao;
import com.stefanini.hackathon.biblioteca.entidade.Livro;

import static org.junit.Assert.*;

import java.util.Collection;

public class TesteManterLivros {

	private LivroDao livroDao;
	
	@Before
	public void instanciaLivroDao() {
		livroDao = new LivroDao();
	}
	
	@Test
	public void tentaInserirUmLivro() {
		Livro livroCleanCode = new Livro();
		livroCleanCode.setNome("Clean Code");
		livroCleanCode.setAutor("Rober C. Martin");
		livroCleanCode.setPaginas(400);
		
		livroDao.inserir(livroCleanCode);
	}
	
	@Test
	public void tentaAlterarUmLivro() {
		Livro livroEncontrado = livroDao.buscarPeloId(7);
		
		String nomeAtualDoLivro = livroEncontrado.getNome();
		
		String novoNomeDoLivro = "Design Patterns " + System.currentTimeMillis();
		
		livroEncontrado.setNome(novoNomeDoLivro);
		
		livroDao.alterar(livroEncontrado);
		
		Livro livroAlterado = livroDao.buscarPeloId(7);
		
		assertEquals(false, nomeAtualDoLivro.equals(livroAlterado.getNome()));
		assertEquals(true, novoNomeDoLivro.equals(livroAlterado.getNome()));
	}
	
	@Test
	public void tentaDeletarUmLivro() {
		Collection<Livro> todosLivros = livroDao.buscarTodos();
		
		int idLivroDeletado = 0;
		
		for (Livro livro : todosLivros) {
			idLivroDeletado = livro.getId();
			livroDao.deletar(livro);
			break;
		}
		
		Livro livroDeletado = livroDao.buscarPeloId(idLivroDeletado);
		
		assertEquals(null, livroDeletado);
	}
	
	@Test
	public void tentaBuscarTodosLivros() {
		Collection<Livro> livrosEncontrados = livroDao.buscarTodos();
		
		assertEquals(false, livrosEncontrados.isEmpty());
	}
	
	@Test 
	public void tentaBuscarLivroPeloId() {
		Livro livroEncontrado = livroDao.buscarPeloId(7);
		
		assertNotNull(livroEncontrado);
	}
	
}
