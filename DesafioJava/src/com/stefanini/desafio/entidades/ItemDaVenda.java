package com.stefanini.desafio.entidades;

/**
 * Formato
 * ItemID-ItemQuantity-ItemPrice
 * 
 * @author Ivan Lampert
 */
public class ItemDaVenda {

	private final String id;
	private final Double quantidade;
	private final Double preco;

	public ItemDaVenda(String id, Double quantidade, Double preco) {
		this.id = id;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public String getId() {
		return id;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public Double getQuantidade() {
		return quantidade;
	}
	
}
