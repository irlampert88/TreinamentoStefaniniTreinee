package programa.garimpeiro;

import programa.util.FormatadorDeResultadoDoGarimpo;
import programa.util.MapaContador;

public class GarimpeiroDeBandaUtilizadaPorArquivo
	extends GarimpeiroAbstrato {

	/** DESCRIÇÃO: 
	  	Mostrar a quantidade de largura de banda consumida por tipo de arquivo. Por exemplo, somar
		todo o consumo de banda das transferências registradas de arquivos PNG. Ordenar descrescente por
		tamanho total de transferência.
	 */

	private final MapaContador contadorDeBandaPorArquivo;
	
	public GarimpeiroDeBandaUtilizadaPorArquivo() {
		super("Banda total utilizada para cada tipo de arquivo:");
		
		contadorDeBandaPorArquivo = new MapaContador();
	}
	
	@Override
	public void garimpar(String dado) {
        String dadoTipo = dado.substring(0, dado.indexOf( "HTTP/1.0\"" )).toLowerCase();
        String dadoTamanho = dado.substring( dado.indexOf( "HTTP/1.0\"" ) + 14,dado.length());
        dadoTamanho = dadoTamanho.substring(0, dadoTamanho.indexOf( " " ));

        String tipo = "n/a";
        Double tamanho = 0.0;

        if (dadoTipo.contains(".png")) {
            tipo = "PNG";
        } else if ( dadoTipo.contains(".jpg")) {
            tipo = "JPG";
        } else if (dadoTipo.contains(".gif")) {
            tipo = "GIF";
        } else if (dadoTipo.contains(".php")) {
            tipo = "PHP";
        } else if ( dadoTipo.contains(".csv")) {
            tipo = "CSV";
        } else if (dadoTipo.contains(".txt")) {
            tipo = "TXT";
        } else if (dadoTipo.contains(".css")) {
            tipo = "CSS";
        } else if (dadoTipo.contains(".js")) {
            tipo = "JS";
        }

        if (!tipo.equals("n/a")) {
            if (buscaTamanho(dadoTamanho) != null) {
                tamanho = buscaTamanho(dadoTamanho);
                
                tamanho = (tamanho / 1024) / 1024;
                
                contadorDeBandaPorArquivo.put(tipo, tamanho);
            }
        }
    }

    private Double buscaTamanho(String dado) {
        try {
            return Double.valueOf(dado);
        } catch(NumberFormatException e) {
            //se chegou aqui, a linha nao tem tamanho e nao eh uma requisicao valida
        }
        return null;
	}

	@Override
	void formatarInformacoesColetadas(FormatadorDeResultadoDoGarimpo formatadorResultados) {
		for (String valor : contadorDeBandaPorArquivo.retornarValoresEmOrdemDecrescente(contadorDeBandaPorArquivo.quantidadeDeDados())) {
            formatadorResultados.adicionaInformacao(valor);
        }
	}
	
}
