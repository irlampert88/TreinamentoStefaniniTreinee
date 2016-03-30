package com.stefanini.desafio.entidades;

/**
 * Formato
 * 003�SaleID�[ItemID-ItemQuantity-ItemPrice]�Salesmanname
 * 
 * @author Ivan Lampert
 */
public class Venda {

	private final String id;
	private final Vendedor vendedor;
	private final ListaDeItensDaVenda listaDeItens;
	
	public Venda(String id, Vendedor vendedor) {
		this.id = id;
		this.vendedor = vendedor;
		listaDeItens = new ListaDeItensDaVenda();
	}
	
	public String getId() {
		return id;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void adicionaItem(ItemDaVenda itemDaVenda) {
		listaDeItens.adicionaItem(itemDaVenda);
	}
	
	public Double getValorTotalDaVenda() {
		return listaDeItens.getValorTotal();
	}
	
}
