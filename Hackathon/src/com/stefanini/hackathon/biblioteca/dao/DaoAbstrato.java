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
			System.out.println("Não foi possível carregar o driver de conexão com Banco de Dados");
			e.printStackTrace();
		}
	}

	final Connection estabeleceConexaoComBanco() {
        try {
        	return DriverManager.getConnection(DaoAbstrato.enderecoBanco, DaoAbstrato.usuarioBanco, DaoAbstrato.senhaBanco);
		
        } catch (SQLException e) {
			System.out.println("Não foi possível estabelecer uma conexão com o Banco de Dados.");
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
				System.out.println("Não foi possível finalizar a conexão com o Banco de Dados.");
				e.printStackTrace();
			}
		}
	}
	
}
