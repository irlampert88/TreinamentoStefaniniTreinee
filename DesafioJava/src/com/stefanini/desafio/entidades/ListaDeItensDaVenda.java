package com.stefanini.desafio.entidades;

import java.util.ArrayList;
import java.util.List;

public class ListaDeItensDaVenda {

	private List<ItemDaVenda> itensDaVenda;
	
	public ListaDeItensDaVenda() {
		itensDaVenda = new ArrayList<>();
	}
	
	public void adicionaItem(ItemDaVenda itemDaVenda) {
		if (itemDaVenda != null) {
			itensDaVenda.add(itemDaVenda);
		}
	}
	
}
