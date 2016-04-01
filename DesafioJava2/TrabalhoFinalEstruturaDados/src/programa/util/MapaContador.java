package programa.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapaContador {

	private final Map<String, Double> mapaDeQuantidades; 
	
	public MapaContador() {
		mapaDeQuantidades = new HashMap<String, Double>();
	}
	
	public void put(String chave) {
		atualizarQuantidade(chave, 1.0);
	}
	
	public void put(String chave, Double valor) {
		atualizarQuantidade(chave, valor);
	}

	private void atualizarQuantidade(String chave, Double valor) {
		Double quantidade = mapaDeQuantidades.get(chave);
		quantidade = (quantidade == null) ? valor : quantidade + valor;
		mapaDeQuantidades.put(chave, quantidade);
	}
	
	public int quantidadeDeDados() {
		return mapaDeQuantidades.size();
	}
	
	public List<String> retornarValoresEmOrdemCrescente(int quantidadeDeRegistrosARetornar) {
		return retornarValoresOrdenados(OrdenacaoMapaContador.ASC, quantidadeDeRegistrosARetornar);
	}
	
	public List<String> retornarValoresEmOrdemDecrescente(int quantidadeDeRegistrosARetornar) {
		return retornarValoresOrdenados(OrdenacaoMapaContador.DESC, quantidadeDeRegistrosARetornar);
	}

	private List<String> retornarValoresOrdenados(OrdenacaoMapaContador ordenacao, int quantidadeDeDadosAOrdenarERetornar) {
		return ordenacao.ordenar(mapaDeQuantidades, quantidadeDeDadosAOrdenarERetornar);
	}
	
}
