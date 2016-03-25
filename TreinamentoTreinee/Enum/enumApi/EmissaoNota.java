package enumApi;

public class EmissaoNota {

    public static void main(String[] args) {
        Venda v = new Venda();
        v.setTipo(TipoVenda.CUPOM);


        v.getTipo().imprimir(v);


        new EmissaoNota().finalizarVenda(v);
    }

    public void finalizarVenda(Venda venda) {
        TipoVenda tipo = venda.getTipo();

        ImpressaoDeVenda impressao = venda.getTipo();

        impressao.imprimir(venda);
    }

}
