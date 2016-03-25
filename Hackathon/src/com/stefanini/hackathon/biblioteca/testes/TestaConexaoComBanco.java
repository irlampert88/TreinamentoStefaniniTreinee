package com.stefanini.hackathon.biblioteca.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.*;
import org.junit.Test;

import com.stefanini.hackathon.biblioteca.dao.DaoAbstrato;

public class TestaConexaoComBanco {

	@Test
	public void tentaEstabelecerConexaoComBancoDeDados() {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(DaoAbstrato.enderecoBanco, DaoAbstrato.usuarioBanco, DaoAbstrato.senhaBanco);
			
			assertNotNull(connection);
			
		} catch (ClassNotFoundException | SQLException e) {
			fail("Não foi estabelecido uma conexão com o Banco de Dados.");
		}
	}
	
}
