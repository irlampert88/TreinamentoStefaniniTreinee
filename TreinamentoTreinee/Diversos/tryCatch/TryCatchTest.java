package tryCatch;

public class TryCatchTest {

    public static void main(String[] args) {
        new TryCatchTest();
    }

    public TryCatchTest() {

        LancadorDeException lancador = new LancadorDeException();

        try {
//            lancador.lancar();

        } finally {
            System.out.println("Sempre vai fazer isto aqui!!!");
        }

    }

}
