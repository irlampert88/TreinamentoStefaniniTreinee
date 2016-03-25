package stringBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StringBuilderTest {

    public static void main(String[] args) {
        new StringBuilderTest();
    }

    public StringBuilderTest() {
        int limite = 30000;

        horaAtual();
        String nomeCompleto = "";
        for (int i = 0; i < limite; i++) {
            nomeCompleto += i + " ";
        }
        System.out.println(nomeCompleto.length());
        horaAtual();

        System.out.println("-----------------------------");

        horaAtual();
        StringBuilder nomeBuilder = new StringBuilder();
        for (int i = 0; i < limite; i++) {
            nomeBuilder.append(i + " ");
        }
        System.out.println(nomeBuilder.toString().length());
        horaAtual();
    }

    private void horaAtual() {
        System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(Calendar.getInstance().getTime()));
    }

}
