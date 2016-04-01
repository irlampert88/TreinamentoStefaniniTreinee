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
		
		imprimir("Ivan", 19);
		
	}
	
	public void imprimir(String nome, int idade) {
		System.out.println(String.format("Meu nome é %s, tenho %s anos", nome, idade));
	}
	
	
}
