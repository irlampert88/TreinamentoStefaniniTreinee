package reflection.geradorSql;

import reflection.generics.Entidade;

@Tabela(nome = "TABELA_CLIENTE")
public class Cliente extends Entidade<Integer> {

    @Id(nome = "CLIENTE_PK")
    private int id;

    @Coluna(nome = "COL_NOME", limiteMaximo = 5)
    private String nome;

    @Coluna(nome = "COL_IDADE", nulo = false)
    private Integer idade;

    @Coluna
    private String cpf;

    private String seila;

    public Cliente() {
    }

    public Cliente(int id, String nome, Integer idade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }


//    public String getNome() {
//        return nome;
//    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSeila() {
        return seila;
    }

    public void setSeila(String seila) {
        this.seila = seila;
    }

}
