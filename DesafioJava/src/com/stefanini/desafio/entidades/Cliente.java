package com.stefanini.desafio.entidades;

/**
 * Formato
 * 002ÁCNPJÁNameÁBusinessArea
 * 
 * @author Ivan Lampert
 */
public class Cliente {

	private final String cnpj;
	private final String nome;
	private final String local;

	public Cliente(String cnpj, String nome, String local) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.local = local;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getLocal() {
		return local;
	}
	
}
