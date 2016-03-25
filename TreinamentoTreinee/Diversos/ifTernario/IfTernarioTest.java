package ifTernario;

public class IfTernarioTest {

    private String nome;
    public String getNome() {
        return (nome != null ? nome : (nome = "Novo nome da Pessoa!"));
    }



//    public String vaiParaTelaPrincipal() {
//        return (usuarioEstaLogado ? "principal.html" : "login.html");
//    }


    private int idade;
    private String sexo;

    public boolean podeEntrar() {
//        if (idade >= 18) {
//            if ("M".equals(sexo)) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }


        return (idade >= 18 ? ("M".equals(sexo) ? (idade > 70 ? false : true) : false) : false);
    }


}
