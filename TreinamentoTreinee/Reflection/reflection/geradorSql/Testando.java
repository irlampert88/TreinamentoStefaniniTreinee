package reflection.geradorSql;

public class Testando {

    public static void main(String[] args) {
        new Testando();
    }

    public Testando() {

        try {
//            Cliente objeto = new Cliente(3, "Maria", 30, "555555");

             Automovel objeto = new Automovel(66, "Palio", "BMW", 2013);

            String sqlDoInsert = new GeradorDeInsert().gerarInsert(objeto);

            System.out.println(sqlDoInsert);

        } catch (Exception e) {
            System.out.println("Ih, deu erro");
            e.printStackTrace();
        }
    }

}
