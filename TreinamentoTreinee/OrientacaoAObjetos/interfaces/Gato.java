package interfaces;

public class Gato extends Mamifero implements Animal {



    @Override
    public void comer() {
        System.out.println("Gato come peixe");

        String t = TIPO_ANIMAL;

    }

    @Override
    public void andar() {

    }

}
