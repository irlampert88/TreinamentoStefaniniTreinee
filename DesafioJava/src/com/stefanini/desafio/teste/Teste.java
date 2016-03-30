package com.stefanini.desafio.teste;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teste {

	public static void main(String[] args) {
		new Teste();
	}
	
	public Teste() {
		
		List<User> usuarios = new ArrayList<>();
		usuarios.add(new User("NOME_1", "123"));
		usuarios.add(new User("NOME_2", "123"));
		
		
		 System.out.println(usuarios.stream().distinct().count());

	
	}
	
	public class User {
		
		private String nome;
		private String cpf;

		public User(String nome, String cpf) {
			this.nome = nome;
			this.cpf = cpf;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (cpf == null) {
				if (other.cpf != null)
					return false;
			} else if (!cpf.equals(other.cpf))
				return false;

			return true;
		}

		private Teste getOuterType() {
			return Teste.this;
		}
	}
	
}
