package programa.util;

public class Impressora {

	private Impressora() {
	}

	public static void imprimir(String valor) {
		if (!Strings.estaVazioOuNulo(valor)) {
			System.out.println(valor);
		}
	}
	
}
