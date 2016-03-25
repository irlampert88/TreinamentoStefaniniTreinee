package com.stefanini.hackathon.biblioteca.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.hackathon.biblioteca.dao.LivroDao;
import com.stefanini.hackathon.biblioteca.entidade.Livro;

@ManagedBean
@ViewScoped
public class LivroManagedBean 
	implements Serializable {
	private static final long serialVersionUID = 1L;

	private Livro livro;
	private LivroDao livroDao;
	
	public LivroManagedBean() {
		novoLivro();
		livroDao = new LivroDao();
	}	

	private void novoLivro() {
		livro = new Livro();
	}
	
	public boolean livroParaEdicao() {
		return getLivro().getId() != null;
	}

	public void inserir() {
		try {
			livroDao.inserir(getLivro());
			// TODO mensagem
			novoLivro();
			
		} catch (Exception e) {
			// TODO mensagem
			e.printStackTrace();
		}
	}
	
	public void alterar() {
		try {
			livroDao.alterar(getLivro());
			// TODO mensagem
			novoLivro();
			
		} catch (Exception e) {
			// TODO mensagem
			e.printStackTrace();
		}
	}
	
	public void deletar() {
		try {
			livroDao.deletar(getLivro());
			// TODO mensagem
			novoLivro();
			
		} catch (Exception e) {
			// TODO mensagem
			e.printStackTrace();
		}
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
