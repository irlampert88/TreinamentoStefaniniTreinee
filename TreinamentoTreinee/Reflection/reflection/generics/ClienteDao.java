package reflection.generics;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    public static void main(String[] args) {
        new ClienteDao();
    }

    public ClienteDao() {

//        numeros.stream().sorted().filter(num -> num %2 == 0).forEach(num -> System.out.println(num));

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(19, "Ivan"));
        usuarios.add(new Usuario(26, "Bob"));
        usuarios.add(new Usuario(16, "Jacó"));
        usuarios.add(new Usuario(30, "Tofi"));

//        Collections.sort(usuarios, new Comparator<Usuario>() {
//            @Override
//            public int compare(Usuario o1, Usuario o2) {
//                return Integer.compare(o1.idade, o2.idade);
//            }
//        });

        usuarios.stream().sorted((o1, o2) -> Integer.compare(o1.idade, o2.idade))
                         .filter(usuario -> usuario.idade < 20)
                         .forEach(usuario -> System.out.println("Idade: " + usuario.idade + " e Nome: "+ usuario.nome));

    }


    public class Usuario {
        private int idade;
        private String nome;
        public Usuario(int idade, String nome) {
            this.idade = idade;
            this.nome = nome;
        }
    }

}
