package programa.util;

public class Strings {

	private Strings() {
	}

	public static boolean estaVazioOuNulo(String valor) {
		return (valor == null || valor.trim().isEmpty());
	}
	
}
