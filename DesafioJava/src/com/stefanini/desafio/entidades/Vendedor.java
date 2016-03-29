package com.stefanini.desafio.entidades;

/**
 * Formato
 * 001ÁCPFÁNameÁSalary
 * 
 * @author Ivan Lampert
 */
public class Vendedor {

	private final String cpf;
	private final String nome;
	private final Double salario;

	public Vendedor(String cpf, String nome, Double salario) {
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Double getSalario() {
		return salario;
	}
	
}
