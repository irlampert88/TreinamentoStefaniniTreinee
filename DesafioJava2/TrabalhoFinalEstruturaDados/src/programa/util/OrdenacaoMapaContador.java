package programa.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public enum OrdenacaoMapaContador {
	ASC {
		@Override
		public List<String> ordenar(Map<String, Double> mapa, int limiteDeValores) {
			return mapa.entrySet()
					   .stream()
					   .sorted((valor1, valor2) -> valor1.getValue().compareTo(valor2.getValue()))
					   .limit(limiteDeValores) 
					   .map(e -> (e.getKey() + ": " + e.getValue()))
					   .collect(Collectors.toList());
		}
	},
	
	DESC {
		@Override
		public List<String> ordenar(Map<String, Double> mapa, int limiteDeValores) {
			return mapa.entrySet()
					   .stream()
					   .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
					   .limit(limiteDeValores)
					   .map(e -> (e.getKey() + ": " + e.getValue()))
					   .collect(Collectors.toList());
		}
	};
	
	public abstract List<String> ordenar(Map<String, Double> mapa, int limiteDeValores);
}
