package collections;

import java.util.HashMap;
import java.util.Map;

public class TesteDeMapa {

    public static void main(String[] args) {
        new TesteDeMapa();
    }

    public TesteDeMapa() {

        Map<String, String> nomes = new HashMap<String, String>();

        nomes.put("Ivan", "Lampert");
        nomes.put("Ivan", "Cardoso");
        nomes.put("Ivan", "Silva");
        nomes.put("Ivan", "Souza");

        System.out.println("Quntiade de registros no Mapa: " + nomes.size());
        System.out.println("Sobrenome do Ivan: " + nomes.get("Ivan"));

    }

}
