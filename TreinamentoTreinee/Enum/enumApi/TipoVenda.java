
package enumApi;

public enum TipoVenda implements ImpressaoDeVenda {
    CUPOM("Cupom Fiscal bla") {

        @Override
        void impressaoAdicional(Venda venda) {
            System.out.println("Impressão adicional do Cupom");
        }

        @Override
        public double calculaImposto(Venda venda) {
            System.out.println("Calcula imposto do Cupom");
            fazTalCoisa();
            return venda.getValorTotalDaVenda() * percentualEstadual;
        }

    },

    NOTA(Teste.TESTE) {

        @Override
        void impressaoAdicional(Venda venda) {
            System.out.println("Impressão adicional da Nota");
        }

        @Override
        public double calculaImposto(Venda venda) {
            System.out.println("Calcula imposto do NFE");
            fazTalCoisa();
            return venda.getValorTotalDaVenda() * percentualFederal;
        }
    }
    ;

    private String nome;

    private static final double percentualFederal = 1.03;
    private static final double percentualEstadual = 1.1;

    private TipoVenda(String nome) {
        this.nome = nome;
    }

    @Override
    public void imprimir(Venda venda) {
        System.out.println("Imprimir Cabeçalho");
        impressaoAdicional(venda);
    }

    abstract void impressaoAdicional(Venda venda);

    public abstract double calculaImposto(Venda venda);

    private static void fazTalCoisa() {
    }

    public String getNome() {
        return nome;
    }

}

