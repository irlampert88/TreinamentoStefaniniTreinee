package interfaces;

import java.util.ArrayList;
import java.util.List;

public class TesteDeCast {

    public static void main(String[] args) {
        new TesteDeCast();
    }

    public TesteDeCast() {

        List<Mamifero> mamiferos = new ArrayList<Mamifero>();

        Mamifero cachorro = new Cachorro();
        Mamifero gato = new Gato();

        mamiferos.add(gato);
        mamiferos.add(cachorro);

        for (Mamifero animal : mamiferos) {
            animal.comer();

        }

    }

}
