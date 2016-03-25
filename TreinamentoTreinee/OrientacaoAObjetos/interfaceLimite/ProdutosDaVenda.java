package interfaceLimite;

import java.util.HashSet;
import java.util.Set;

public class ProdutosDaVenda {

    private Set<Produto> produtos;

    public ProdutosDaVenda() {
        produtos = new HashSet<Produto>();
    }

    public void adicionaProduto(Produto produto) {
        if (produto != null && produto.getEstoque() > 0) {
            produtos.add(produto);
        }
    }

}
