package interfaces;

public abstract class Mamifero {

    private int idade;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void comer() {
        System.out.println("Mamifero come tudo");
    }

}
