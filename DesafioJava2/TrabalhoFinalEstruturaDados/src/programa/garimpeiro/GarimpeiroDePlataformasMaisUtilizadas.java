package programa.garimpeiro;

import programa.util.FormatadorDeResultadoDoGarimpo;
import programa.util.MapaContador;

public class GarimpeiroDePlataformasMaisUtilizadas 
	extends GarimpeiroAbstrato {

	/** DESCRIÇÃO:
	  	Criar um ranking com a lista de todas as plataformas (Windows, Linux, Mac, Android, etc) de
		cliente utilizadas para acessar o servidor web, classificados em ordem crescente de quantidade.
	 */
	
	private final MapaContador contadorDePlataformas;
	
	public GarimpeiroDePlataformasMaisUtilizadas() {
		super("Plataformas (S.O.) mais utilizadas:");
		this.contadorDePlataformas = new MapaContador();
	}
	
	@Override
	public void garimpar(String dado) {
		dado = dado.toLowerCase();
        
        if (dado.contains("windows phone")) { 
            contadorDePlataformas.put("windows phone");
            
        } else if (dado.contains("windows")) {
            contadorDePlataformas.put("windows");
            
        } else if (dado.contains("android")) { 
            contadorDePlataformas.put("android");
            
        } else if(dado.contains("linux")) { 
            contadorDePlataformas.put("linux");
            
        } else if(dado.contains("macintosh")) {
            contadorDePlataformas.put("macintosh");
            
        } else if(dado.contains("iphone")) {
            contadorDePlataformas.put("iphone");
        }
	}

	@Override
	void formatarInformacoesColetadas(FormatadorDeResultadoDoGarimpo formatadorResultados) {
        for (String valor : contadorDePlataformas.retornarValoresEmOrdemDecrescente(5)) {
            formatadorResultados.adicionaInformacao(valor);
        }
	}

}
