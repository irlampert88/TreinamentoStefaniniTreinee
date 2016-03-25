package reflection.generics;

public class Dao<T extends Entidade<ID>, ID extends Long> {

    public void teste(T t) {

        Long id = t.getId();

    }

}
