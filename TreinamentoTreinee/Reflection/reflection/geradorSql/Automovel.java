package reflection.geradorSql;

@Tabela(nome = "TABELA_CARRO")
public class Automovel {

    @Id
    private int id;
    @Coluna(nome = "COL_MOD", nulo = false)
    private String modelo;
    @Coluna(nome = "COL_MARC", nulo = false, limiteMaximo = 3)
    private String marca;
    @Coluna
    private int ano;

    public Automovel(int id, String modelo, String marca, int ano) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }

}
