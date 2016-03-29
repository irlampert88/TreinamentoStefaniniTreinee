package com.stefanini.desafio.fabricas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.stefanini.desafio.entidades.ItemDaVenda;

/**
 * @author Ivan Lampert
 */
public final class FabricaDeItensDaVenda {

	// [1-34-10,2-33-1.50,3-40-0.10]
	
	private FabricaDeItensDaVenda() {
	}
	
	public static List<ItemDaVenda> criarItens(String itensDaVenda) {
		List<ItemDaVenda> listaItensDaVenda = new ArrayList<>();
			
		Arrays.asList(itensDaVenda.replace("[", "").replace("]", "").split(","))
			.forEach(item -> listaItensDaVenda.add(criarItemDaVenda(item)));
		
		return listaItensDaVenda;
	}

	private static ItemDaVenda criarItemDaVenda(String item) {
		String[] partesDoItem = item.split("-");

		Double quantidade = Double.valueOf(partesDoItem[1]);
		Double preco = Double.valueOf(partesDoItem[2]);
		
		return new ItemDaVenda(partesDoItem[0], quantidade, preco);
	}
	
}
