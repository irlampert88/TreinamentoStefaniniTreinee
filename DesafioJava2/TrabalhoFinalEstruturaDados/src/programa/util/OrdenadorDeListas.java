package programa.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenadorDeListas<TIPO> {

	private final List<TIPO> valoresNaoOrdenados;

	public OrdenadorDeListas(List<TIPO> valoresNaoOrdenados) {
		this.valoresNaoOrdenados = valoresNaoOrdenados;
	}

	public List<TIPO> ordemDecrescente(TIPO comparadorDeDados) {
		return null;
	}
	
	public List<TIPO> ordemDecrescente(Comparator<TIPO> comparadorDeDados) {
		return valoresNaoOrdenados.stream()
								  .sorted(comparadorDeDados.reversed())
								  .collect(Collectors.toList());
	}

}
