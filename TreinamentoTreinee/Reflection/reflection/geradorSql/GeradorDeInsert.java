package reflection.geradorSql;

import java.lang.reflect.Field;

public class GeradorDeInsert {

    public String gerarInsert(Object objeto) throws Exception {
        validaSeObjetoTemAnotacaoTabela(objeto);
        validaSeObjetoTemUmId(objeto);

        // INSERT INTO TABELA_CLIENTE (CLIENTE_PK, COL_NOME, COL_IDADE, cpf) VALUES (3, 'Maria', 30, '555555');

        StringBuilder insertBuilder = new StringBuilder()

                .append("INSERT INTO " + pegaNomeDaTabela(objeto) + " (")
                .append(pegaNomeDasColunas(objeto))
                .append(" VALUES (")
                .append(pegaValoresDosCampos(objeto));

        return insertBuilder.toString();
    }

    private String pegaValoresDosCampos(Object objeto) throws Exception {
        StringBuilder valorDosCampos = new StringBuilder();
        final String delimitador = ", ";

        for (Field campo : objeto.getClass().getDeclaredFields()) {
            campo.setAccessible(true);

            if (campo.isAnnotationPresent(Id.class)) {
                Id id = campo.getAnnotation(Id.class);
                valorDosCampos.append(String.valueOf(campo.get(objeto)))
                              .append(delimitador);

            } else if (campo.isAnnotationPresent(Coluna.class)) {
                Coluna coluna = campo.getAnnotation(Coluna.class);

                if (! coluna.nulo() && campo.get(objeto) == null) {
                    throw new IllegalArgumentException("Objeto " + objeto.getClass().getSimpleName() + " está com o campo " + campo.getName() + " nulo.");
                }

                if (coluna.limiteMaximo() > 0
                        && campo.get(objeto) != null
                        && String.valueOf(campo.get(objeto)).length() > coluna.limiteMaximo()) {
                    throw new IllegalArgumentException("Objeto " + objeto.getClass().getSimpleName()
                            + ", no campo " + campo.getName() + " excedeu limite de caracteres(" + coluna.limiteMaximo() + ").");
                }

                // ERRADO
                // String delimitadorDeValor = ((campo.getType().isPrimitive() && !campo.getType().equals(char.class)) || (!campo.getType().isPrimitive() && campo.getType().getSuperclass().equals(Number.class)) ? "" : "'");

                Class<?> tipoDoCampo = campo.getType();
                String delimitadorDeValor = (tipoDoCampo.isPrimitive() || tipoDoCampo.getSuperclass().equals(Number.class) ? "" : "'");

                if (tipoDoCampo.equals(char.class)) {
                    delimitadorDeValor = "'";
                }

                valorDosCampos.append(String.valueOf(delimitadorDeValor + campo.get(objeto)) + delimitadorDeValor)
                              .append(delimitador);
            }
        }

        // NOVO Gambiarra básica!
//        return valorDosCampos.toString().substring(0, valorDosCampos.toString().length() - 2) + ")";
        return valorDosCampos.append(")").toString().replace(", )", ");");
    }

    private String pegaNomeDasColunas(Object objeto) {
        StringBuilder nomeDasColunas = new StringBuilder();
        final String delimitador = ", ";

        for (Field campo : objeto.getClass().getDeclaredFields()) {

            if (campo.isAnnotationPresent(Id.class)) {
                Id id = campo.getAnnotation(Id.class);
                nomeDasColunas.append(id.nome().trim().isEmpty() ? campo.getName() : id.nome())
                              .append(delimitador);

            } else if (campo.isAnnotationPresent(Coluna.class)) {
                Coluna coluna = campo.getAnnotation(Coluna.class);
                nomeDasColunas.append(coluna.nome().trim().isEmpty() ? campo.getName() : coluna.nome())
                              .append(delimitador);
            }
        }

        // NOVO Gambiarra básica!
//        return nomeDasColunas.toString().substring(0, nomeDasColunas.toString().length() - 2) + ")";
        return nomeDasColunas.append(")").toString().replace(", )", ")");
    }

    private String pegaNomeDaTabela(Object objeto) {
        Tabela anotacao = objeto.getClass().getAnnotation(Tabela.class);

        return (anotacao.nome().trim().isEmpty() ? objeto.getClass().getSimpleName() : anotacao.nome());
    }

    private void validaSeObjetoTemUmId(Object objeto) {
        int quantidadeIds = 0;

        for (Field campo : objeto.getClass().getDeclaredFields()) {
            if (campo.isAnnotationPresent(Id.class)) {
                quantidadeIds ++;
            }
        }

        if (quantidadeIds == 0) {
            throw new IllegalArgumentException("Objeto " + objeto.getClass().getSimpleName() + " não tem Id.");
        }

        if (quantidadeIds > 1) {
            throw new IllegalArgumentException("Objeto " + objeto.getClass().getSimpleName() + " tem multiplos Ids.");
        }
    }

    private void validaSeObjetoTemAnotacaoTabela(Object objeto) throws Exception {
        if (! objeto.getClass().isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("Objeto " + objeto.getClass().getSimpleName() + " não tem anotação @Tabela.");
        }
    }

}
