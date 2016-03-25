package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

    public static void horaAtual() {
        System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(Calendar.getInstance().getTime()));
    }

    public void qualquerCoisa() {

    }

}
