package com.stefanini.desafio.dominio;

import java.io.File;

/**
 * @author Ivan Lampert
 */
public interface Constantes {
	
	final String PREFIX = System.getProperty("user.home") + File.separator + "data" + File.separator;
	
	public final String LOCAL_LEITURA = PREFIX + "in/";
	
	public final String DELIMITADOR = "ç";
	
}
