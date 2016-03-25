package interfaces;

public class Cachorro extends Mamifero implements Animal {

    private String nome;

    public Cachorro() {
    }

    private Cachorro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public void andar() {
    }

}
