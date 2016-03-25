package com.stefanini.hackathon.biblioteca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoAbstrato<E> implements CrudDao<E> {

	public static final String enderecoBanco = "jdbc:postgresql://localhost/hackathon_biblioteca";
	public static final String usuarioBanco = "postgres";
	public static final String senhaBanco = "root";

	public DaoAbstrato() {
		try {
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("N�o foi poss�vel carregar o driver de conex�o com Banco de Dados");
			e.printStackTrace();
		}
	}

	final Connection estabeleceConexaoComBanco() {
        try {
        	return DriverManager.getConnection(DaoAbstrato.enderecoBanco, DaoAbstrato.usuarioBanco, DaoAbstrato.senhaBanco);
		
        } catch (SQLException e) {
			System.out.println("N�o foi poss�vel estabelecer uma conex�o com o Banco de Dados.");
			e.printStackTrace();
			return null;
		}
	}
	
	final void encerraConexaoComBanco(Connection connection) {
		if (connection != null) {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("N�o foi poss�vel finalizar a conex�o com o Banco de Dados.");
				e.printStackTrace();
			}
		}
	}
	
}
