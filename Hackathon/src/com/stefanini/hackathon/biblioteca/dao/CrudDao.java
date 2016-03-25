package com.stefanini.hackathon.biblioteca.dao;

import java.util.Collection;

public interface CrudDao<E> {

	public void inserir(E entidade);
	public void alterar(E entidade);
	public void deletar(E entidade); 
	public Collection<E> buscarTodos();
	public E buscarPeloId(int id);
	
}
