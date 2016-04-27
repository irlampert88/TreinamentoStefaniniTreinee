package com.stefanini.hackathon2.managed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.hackathon2.web.service.rest.ConsumoWebService;

@ManagedBean
@ViewScoped
public class WebServiceManagedBean {

	@Inject
	private ConsumoWebService consumoServicos;
	
	public void todosLivros() {
		consumoServicos.listarTodosLivros();
	}
	
}
