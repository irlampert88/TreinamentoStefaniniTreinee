package com.stefanini.desafio.entidades;

import java.util.ArrayList;
import java.util.List;

public final class ListaDeItensDaVenda {

	private final List<ItemDaVenda> itensDaVenda;
	private double valorTotal;
	
	public ListaDeItensDaVenda() {
		itensDaVenda = new ArrayList<>();
	}
	
	public final void adicionaItem(ItemDaVenda itemDaVenda) {
		if (itemDaVenda != null) {
			valorTotal =+ (itemDaVenda.getPreco() * itemDaVenda.getQuantidade());
			
			itensDaVenda.add(itemDaVenda);
		}
	}

	public final double getValorTotal() {
		return valorTotal;
	}
	
}
