package com.stefanini.hackathon2.web.service.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stefanini.hackathon2.entidades.Livro;

public class ConsumoWebService {

	public void listarTodosLivros() {

		Client client = ClientBuilder.newClient();
		
		WebTarget service = client.target("http://localhost:8080/HackathonV2/ws");

		salvarNovoLivro(service);
		
		String livrosEmJson = service.path("livros")
						             .request()
						             .accept(MediaType.APPLICATION_JSON)
						             .get(String.class);
	    Gson gson = new Gson();
	    
	    List<Livro> livros = gson.fromJson(livrosEmJson, new TypeToken<List<Livro>>(){}.getType());
		
	    livros.forEach(livro -> System.out.println("NOME: " + livro.getNome() + " | AUTOR: " + livro.getAutor()));
	}

	private void salvarNovoLivro(WebTarget service) {
		Livro novoLivroParaInserir = new Livro("NomeLivro" + horaAtual(), "AutorLivro" + horaAtual(), 99);
		
		service.path("livros")
			   .request()
			   .post(Entity.entity(novoLivroParaInserir, MediaType.APPLICATION_JSON), Response.class);
	}

	private String horaAtual() {
		return LocalDateTime.now().toString();
	}

}
