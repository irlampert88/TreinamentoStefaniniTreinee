package programa.garimpeiro;

import programa.util.FormatadorDeResultadoDoGarimpo;
import programa.util.MapaContador;

public class GarimpeiroDeNavegadoresMaisUtilizados 
	extends GarimpeiroAbstrato {

	/** DESCRIÇÃO: 
	    Criar um ranking indicando os cinco navegadores (MSIE, Mozilla, etc) mais utilizados para
		acessar o servidor web, classificados em ordem decrescente de ocorrência.
	 */
	
    private final MapaContador contadorDeNavegadores;
	
	public GarimpeiroDeNavegadoresMaisUtilizados() {
		super("5 navegadores mais utilizados:");
		 contadorDeNavegadores = new MapaContador();
	}
	
	@Override
	public void garimpar(String dado) {
		dado = dado.toLowerCase();

        if (dado.contains("msie")) {
            contadorDeNavegadores.put("MSIE");
            
        } else if (dado.contains("(khtml, like gecko")) {
            String browser = "safari";

            if (dado.contains("chrome")) {
                browser = "chrome";
            } else if (dado.contains("mobile")) {
                browser = "safari mobile";
            }

            contadorDeNavegadores.put(browser);
        } else if (dado.contains("googlebot-mobile")) {
            contadorDeNavegadores.put("Googlebot-Mobile");
            
        } else if(dado.contains( "gecko/")) {
            contadorDeNavegadores.put( "Firefox" );
            
        } else if(dado.contains("opera/")) {
            contadorDeNavegadores.put("opera");
        }
	}
	
	@Override
	void formatarInformacoesColetadas(FormatadorDeResultadoDoGarimpo formatadorResultados) {
        for (String valor : contadorDeNavegadores.retornarValoresEmOrdemDecrescente(5)) {
        	formatadorResultados.adicionaInformacao(valor);
        }
	}

}
