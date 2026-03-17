package project.java.cadastrodeninjas;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity //NOTE: informa que a classe pertence ao banco de dados, transforma classe em entidade do BD
@Table(name = "tb_cadastro") //NOTE: nomenado a tabela

public class NinjaModel {

    private long id; //NOTE: o ID sera atribuido automaticamente no banco de dados, não é necessaria atribuicao dos valores
    private String nome;
    private String email;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
