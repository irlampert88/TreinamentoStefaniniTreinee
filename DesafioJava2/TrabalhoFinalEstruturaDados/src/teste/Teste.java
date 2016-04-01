package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import programa.entidades.ConversorDeMes;

public class Teste {

	public static void main(String[] args) {
		new Teste();
	}
	
	public Teste() {
		
		String dado = "177.44.240.52 - 129.156.10.197, 200.17.81.22 - -";
		
		
		String[] dadosSeparados = dado.split("-");
		String ip = dadosSeparados[1];
		
		if (ip.contains(",")) {
			ip = ip.split(",")[1].trim();
		}
		
		System.out.println(ip);
		
	}
	
}
