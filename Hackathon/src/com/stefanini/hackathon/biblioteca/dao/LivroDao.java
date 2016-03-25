package com.stefanini.hackathon.biblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.stefanini.hackathon.biblioteca.entidade.Livro;

public class LivroDao 
	extends DaoAbstrato<Livro> {

	@Override
	public void inserir(Livro livro) {
		Connection conexaoComBanco = estabeleceConexaoComBanco();

		try {
			String sqlDoInsert = "INSERT INTO livro (nome, autor, paginas) VALUES(?, ?, ?)";

			PreparedStatement statement = conexaoComBanco.prepareStatement(sqlDoInsert);
			
			statement.setString(1, livro.getNome());
			statement.setString(2, livro.getAutor());
			statement.setInt(3, livro.getPaginas());
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			encerraConexaoComBanco(conexaoComBanco);
		}
	}

	@Override
	public void alterar(Livro livro) {
		Connection conexaoComBanco = estabeleceConexaoComBanco();

		try {
			String sqlDoUpdate = "UPDATE livro set nome = ?, autor = ?, paginas = ? where id_livro = ?";

			PreparedStatement statement = conexaoComBanco.prepareStatement(sqlDoUpdate);
			statement.setString(1, livro.getNome());
			statement.setString(2, livro.getAutor());
			statement.setInt(3, livro.getPaginas());
			statement.setInt(4, livro.getId());
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			encerraConexaoComBanco(conexaoComBanco);
		}
	}

	@Override
	public void deletar(Livro livro) {
		Connection conexaoComBanco = estabeleceConexaoComBanco();

		try {
			String sqlDoDelete = "DELETE FROM livro where id_livro = ?";

			PreparedStatement statement = conexaoComBanco.prepareStatement(sqlDoDelete);
			statement.setInt(1, livro.getId());
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			encerraConexaoComBanco(conexaoComBanco);
		}
	}

	@Override
	public Collection<Livro> buscarTodos() {
		Connection conexaoComBanco = estabeleceConexaoComBanco();

		try {
			String sqlDoSelect = "SELECT * FROM livro";

			PreparedStatement statement = conexaoComBanco.prepareStatement(sqlDoSelect);
			
			ResultSet resultadoDoSelect = statement.executeQuery();
			
			if ( resultadoDoSelect != null ) {
				List<Livro> livrosEncontrados = new ArrayList<Livro>();
				
				while ( resultadoDoSelect.next() ) {
					Livro livroEncontradoNoBanco = new Livro();
					livroEncontradoNoBanco.setId(resultadoDoSelect.getInt("id_livro"));
					livroEncontradoNoBanco.setNome(resultadoDoSelect.getString("nome"));
					livroEncontradoNoBanco.setAutor(resultadoDoSelect.getString("autor"));
					livroEncontradoNoBanco.setPaginas(resultadoDoSelect.getInt("paginas"));
					
					livrosEncontrados.add(livroEncontradoNoBanco);
				}
				
				return livrosEncontrados;
			}
			
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			encerraConexaoComBanco(conexaoComBanco);
		}
	}

	@Override
	public Livro buscarPeloId(int id) {
		Connection conexaoComBanco = estabeleceConexaoComBanco();

		try {
			String sqlDoSelect = "SELECT * FROM livro where id_livro = ?";

			PreparedStatement statement = conexaoComBanco.prepareStatement(sqlDoSelect);
			statement.setInt(1, id);
			
			ResultSet resultadoDoSelect = statement.executeQuery();
			
			if ( resultadoDoSelect != null ) {

				while ( resultadoDoSelect.next() ) {
					Livro livroEncontradoNoBanco = new Livro();
					livroEncontradoNoBanco.setId(resultadoDoSelect.getInt("id_livro"));
					livroEncontradoNoBanco.setNome(resultadoDoSelect.getString("nome"));
					livroEncontradoNoBanco.setAutor(resultadoDoSelect.getString("autor"));
					livroEncontradoNoBanco.setPaginas(resultadoDoSelect.getInt("paginas"));
				
					return livroEncontradoNoBanco;
				}
			}
			
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			encerraConexaoComBanco(conexaoComBanco);
		}
	}

}
