package com.stefanini.hackathon2.web.service.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.stefanini.hackathon2.entidades.Livro;
import com.stefanini.hackathon2.servicos.LivroServico;

@Path("/livros")
@Produces({ "application/json" })
public class LivroFacade {

	@Inject
	private LivroServico livroServico;
	
	@GET
	@Path("/")
	public List<Livro> listarTodos() {
		return livroServico.carregaTodosLivrosDoBanco();
	}

	@POST
	@Path("/")
	public void salvar(Livro livro) {
		livroServico.salvar(livro);
	}

	@DELETE
	@Path("/{idLivro}")
	public void remover(@PathParam("Livro") Integer idLivro) {
		livroServico.deletar(livroServico.pesquisarPorID(idLivro));
	}
	
}
