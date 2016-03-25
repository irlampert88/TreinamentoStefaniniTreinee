package collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class TesteDeList {

    public static void main(String[] args) {
        new TesteDeList();
    }

    public TesteDeList() {

        Set<String> nomes = new LinkedHashSet();

        nomes.add("Ivan");
        nomes.add("Ivan");
        nomes.add("Paulo");
        nomes.add("Maria");
        nomes.add("Ivan");
        nomes.add("João");

        for (String nome : nomes) {
            System.out.println(nome);
        }

    }

}
