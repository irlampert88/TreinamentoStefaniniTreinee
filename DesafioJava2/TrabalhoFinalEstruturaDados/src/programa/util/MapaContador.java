package programa.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapaContador {

	private final Map<String, Double> mapaDeQuantidades; 
	
	public MapaContador() {
		mapaDeQuantidades = new HashMap<String, Double>();
	}
	
	public final void put(String chave) {
		atualizarQuantidade(chave, 1.0);
	}
	
	public final void put(String chave, Double valor) {
		atualizarQuantidade(chave, valor);
	}

	private void atualizarQuantidade(String chave, Double valor) {
		Double quantidade = mapaDeQuantidades.get(chave);
		quantidade = (quantidade == null) ? valor : quantidade + valor;
		mapaDeQuantidades.put(chave, quantidade);
	}
	
	public final int quantidadeDeDados() {
		return mapaDeQuantidades.size();
	}
	
	public final List<String> retornarValoresEmOrdemCrescente(int quantidadeDeRegistrosARetornar) {
		return retornarValoresOrdenados(OrdenacaoMapaContador.ASC, quantidadeDeRegistrosARetornar);
	}
	
	public final List<String> retornarValoresEmOrdemDecrescente(int quantidadeDeRegistrosARetornar) {
		return retornarValoresOrdenados(OrdenacaoMapaContador.DESC, quantidadeDeRegistrosARetornar);
	}

	private final List<String> retornarValoresOrdenados(OrdenacaoMapaContador ordenacao, int quantidadeDeDadosAOrdenarERetornar) {
		return ordenacao.ordenar(mapaDeQuantidades, quantidadeDeDadosAOrdenarERetornar);
	}
	
}
